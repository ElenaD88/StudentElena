package com.example.container;
import com.example.annotation.Autowire;
import com.example.annotation.Component;
import com.example.annotation.Value;
import org.reflections.Reflections;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import java.util.Properties;
import java.util.Set;

public class IocContainer {

    private final Map<Class<?>, Object> container = new HashMap<Class<?>, Object>();
    private final Properties properties = new Properties();

    public IocContainer(String packageName) {
        loadProperties();
        scanAndInitializeComponents(packageName);
    }

    private void loadProperties(){
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

    private void scanAndInitializeComponents(String packageName){
        Reflections reflections = new Reflections();
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Component.class);
        for(Class<?> clazz : annotatedClasses){
            try{
                Object o = clazz.getDeclaredConstructor().newInstance();
                container.put(clazz, o);
                injectValues(o);
                injectDependencies(o);
            } catch (Exception e ) {
                e.printStackTrace();
            }
        }
    }

    private void injectValues(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for(Field field : declaredFields){
            if(field.isAnnotationPresent(Value.class)){
                Value annotation = field.getAnnotation(Value.class);
                String value = properties.getProperty(annotation.value());
                field.setAccessible(true);
                field.set(object, value);
            }
        }
    }

    private void injectDependencies(Object object) throws IllegalAccessException, InvocationTargetException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for(Field field : declaredFields){
            if(field.isAnnotationPresent(Autowire.class)){
                Class<?> type = field.getType();
                Object dependency = container.get(type);
                if(dependency == null){
                    throw new RuntimeException("Нет такого бина:" + type + "в контейнере" );
                }
                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for(Method method : declaredMethods){

            if(method.isAnnotationPresent(Autowire.class)){

                Class<?>[] parameterTypes = method.getParameterTypes();
                Object[] dependencies = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++){
                    dependencies[i] = container.get(parameterTypes[i]);
                }
                method.setAccessible(true);
                method.invoke(object, dependencies);
            }
        }
    }

    public <T> T getBean(Class<T> clazz){
        return (T) container.get(clazz);
    }
}
