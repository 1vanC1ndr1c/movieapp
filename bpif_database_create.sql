create table entity_by_roles (id bigint not null, name varchar(255), role varchar(255), primary key (id)) engine=MyISAM;
create table entity_by_roles_ids (entity_by_roles_id bigint not null, ids bigint) engine=MyISAM;
create table entity_by_roles_names (entity_by_roles_id bigint not null, name varchar(20000)) engine=MyISAM;
create table hibernate_sequence (next_val bigint) engine=MyISAM;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table movie (id bigint not null, name varchar(255), movie_description varchar(255), movie_runtime blob, release_date blob, primary key (id)) engine=MyISAM;
create table movie_category_list (movie_id bigint not null, category varchar(20000)) engine=MyISAM;
create table movie_people_by_roles_set (movie_id bigint not null, people_by_roles_set_id bigint not null, primary key (movie_id, people_by_roles_set_id)) engine=MyISAM;
create table person (id bigint not null, name varchar(255), bio varchar(20000), birth_date blob, birth_place varchar(255), primary key (id)) engine=MyISAM;
create table person_movies_by_roles_set (person_id bigint not null, movies_by_roles_set_id bigint not null, primary key (person_id, movies_by_roles_set_id)) engine=MyISAM;
create table person_roles (person_id bigint not null, roles varchar(20000)) engine=MyISAM;
alter table movie_people_by_roles_set add constraint UK_dw0pc11032sb15g2781ucidr unique (people_by_roles_set_id);
alter table person_movies_by_roles_set add constraint UK_4kmo4dh4deo1677kcc48of4xy unique (movies_by_roles_set_id);
alter table entity_by_roles_ids add constraint FKg3p0tuunhiqpd2w14qsds0e72 foreign key (entity_by_roles_id) references entity_by_roles (id);
alter table entity_by_roles_names add constraint FKam8tovrtvmwot5k959der2orq foreign key (entity_by_roles_id) references entity_by_roles (id);
alter table movie_category_list add constraint FK78k8tex8sgohv7k5i426c38cr foreign key (movie_id) references movie (id);
alter table movie_people_by_roles_set add constraint FK6dq9hvq5bnl87s218dinispph foreign key (people_by_roles_set_id) references entity_by_roles (id);
alter table movie_people_by_roles_set add constraint FK4ikeqb17paq67g8h0t9bbjtia foreign key (movie_id) references movie (id);
alter table person_movies_by_roles_set add constraint FKtl14xgt8d7vfiaebj3418po0g foreign key (movies_by_roles_set_id) references entity_by_roles (id);
alter table person_movies_by_roles_set add constraint FKh2kgwkilsjwi5idbseuh3hvob foreign key (person_id) references person (id);
alter table person_roles add constraint FKs955luj19xyjwi3s1omo1pgh4 foreign key (person_id) references person (id);
