--liquibase formatted sql
--changeset tchmielecki:1

insert into subject(id, display_name, course_id)
values (7, 'zmienne', 3);

insert into subject(id, display_name, course_id)
values (8, 'bledy', 3);

insert into subject(id, display_name, course_id)
values (9, 'klasy', 3);

insert into subject(id, display_name, course_id)
values (10, 'wyjatki', 3);

insert into subject(id, display_name, course_id)
values (11, 'ArrayList', 3);

insert into subject(id, display_name, course_id)
values (12, 'LinkedLists', 3);

insert into subject(id, display_name, course_id)
values (13, 'HashMap', 3);

insert into subject(id, display_name, course_id)
values (14, 'Getter and Setters', 3);

insert into subject(id, display_name, course_id)
values (15, 'Constructors', 3);
