--liquibase formatted sql
--changeset tchmielecki:1

insert into course(id, display_name)
values (3, 'Kurs Java');
insert into course(id, display_name)
values (4, 'Kurs Phyton');
insert into course(id, display_name)
values (5, 'Kurs Angular');
insert into course(id, display_name)
values (6, 'Kurs JavaScript');

