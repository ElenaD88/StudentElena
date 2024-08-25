package com.example.container;

import com.example.annotation.Autowire;
import com.example.annotation.Component;
import com.example.annotation.Value;
import org.reflections.Reflections;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class IocContainer {

    private final Map<Class<?>, Object> container = new HashMap<Class<?>, Object>();
    private final Map<Class<?>, Class<?>> interfaceToImpl = new HashMap<>();
    private final Properties properties = new Properties();

    public IocContainer(String packageName) {
        loadProperties();
        scanAndInitializeComponents(packageName);
    }

    private void loadProperties() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            if (inputStream == null) {
                System.out.println("Нет файла application.properties");
                return;
            }
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void scanAndInitializeComponents(String packageName) {
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Component.class);
        Set<Class<?>> constructorClasses = new HashSet<>();

        for (Class<?> clazz : annotatedClasses) {
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            if (constructors.length > 1) {
                constructorClasses.add(clazz);
            } else {
                try {
                    Object instance = createInstance(clazz);
                    container.put(clazz, instance);
                    for (Class<?> iface : clazz.getInterfaces()) {
                        interfaceToImpl.put(iface, clazz);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {

            for (Class<?> clazz : container.keySet()) {
                for (Class<?> iface : clazz.getInterfaces()) {
                    interfaceToImpl.put(iface, clazz);
                }
                injectValues(container.get(clazz));
                injectDependencies(container.get(clazz));
            }

            for (Class<?> clazz : constructorClasses) {

                Object instance = createInstance(clazz);
                container.put(clazz, instance);

                for (Class<?> iface : clazz.getInterfaces()) {
                    interfaceToImpl.put(iface, clazz);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object createInstance(Class<?> clazz) throws Exception {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        if (constructors.length > 1) {

            Constructor<?> constructor = constructors[0];

            Class<?>[] parameterTypes = constructor.getParameterTypes();

            Object[] dependencies = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                dependencies[i] = container.get(parameterTypes[i]);

                if (dependencies[i] == null) {

                    if (interfaceToImpl.containsKey(parameterTypes[i])) {
                        Class<?> implClass = interfaceToImpl.get(parameterTypes[i]);
                        dependencies[i] = container.get(implClass);
                    } else {
                        Class<?> parameterType = parameterTypes[i];
                        Object instance = createInstance(parameterType);
                        dependencies[i] = instance;
                        container.put(parameterType, instance);
                        for (Class<?> iface : parameterType.getInterfaces()) {
                            interfaceToImpl.put(iface, parameterType);
                        }
                    }
                }
            }
            return constructor.newInstance(dependencies);
        }
        return clazz.getDeclaredConstructor().newInstance();
    }

    private void injectValues(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Value.class)) {
                String key = field.getAnnotation(Value.class).value().replace("{", "").replace("}", "");
                String value = properties.getProperty(key);
                field.setAccessible(true);
                field.set(object, value);
            }
        }
    }

    private void injectDependencies(Object object) throws IllegalAccessException, InvocationTargetException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Autowire.class)) {
                Class<?> type = field.getType();
                Object dependency = container.get(type);
                if (dependency == null && interfaceToImpl.containsKey(type)) {
                    Class<?> implClass = interfaceToImpl.get(type);
                    dependency = container.get(implClass);
                }
                if (dependency == null) {
                    throw new RuntimeException("Нет такого бина:" + type + "в контейнере");
                }
                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {

            if (method.isAnnotationPresent(Autowire.class)) {

                Class<?>[] parameterTypes = method.getParameterTypes();
                Object[] dependencies = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    dependencies[i] = container.get(parameterTypes[i]);
                    if (dependencies[i] == null && interfaceToImpl.containsKey(parameterTypes[i])) {
                        Class<?> implClass = interfaceToImpl.get(parameterTypes[i]);
                        dependencies[i] = container.get(implClass);
                    }
                }
                method.setAccessible(true);
                method.invoke(object, dependencies);
            }
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return (T) container.get(clazz);
    }
}
