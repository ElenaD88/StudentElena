create table rent.announcement_marketing (
    announcement_id INTEGER,
    marketing_id INTEGER,
    primary key (announcement_id,
marketing_id),
    foreign key (announcement_id) references rent.announcement(announcement_id) on delete cascade,
	foreign key (marketing_id) references rent.marketing(marketing_id) on delete cascade
);