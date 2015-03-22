# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table admin (
  id                        bigint not null,
  email                     varchar(255),
  password                  varchar(255),
  role                      varchar(255),
  name                      varchar(255),
  picture                   bytea,
  constraint pk_admin primary key (id))
;

create table instructor (
  id                        bigint not null,
  email                     varchar(255),
  password                  varchar(255),
  role                      varchar(255),
  name                      varchar(255),
  picture                   bytea,
  thesis_id                 bigint,
  facilty                   varchar(255),
  constraint pk_instructor primary key (id))
;

create table learner (
  id                        bigint not null,
  email                     varchar(255),
  password                  varchar(255),
  role                      varchar(255),
  name                      varchar(255),
  picture                   bytea,
  thesis_id                 bigint,
  facilty                   varchar(255),
  class                     varchar(255),
  constraint pk_learner primary key (id))
;

create table thesis (
  id                        bigint not null,
  code                      varchar(255),
  name                      varchar(255),
  description               varchar(255),
  date                      varchar(255),
  constraint pk_thesis primary key (id))
;

create table user_account (
  id                        bigint not null,
  email                     varchar(255),
  password                  varchar(255),
  role                      varchar(255),
  name                      varchar(255),
  picture                   bytea,
  constraint pk_user_account primary key (id))
;

create sequence admin_seq;

create sequence instructor_seq;

create sequence learner_seq;

create sequence thesis_seq;

create sequence user_account_seq;

alter table instructor add constraint fk_instructor_thesis_1 foreign key (thesis_id) references thesis (id);
create index ix_instructor_thesis_1 on instructor (thesis_id);
alter table learner add constraint fk_learner_thesis_2 foreign key (thesis_id) references thesis (id);
create index ix_learner_thesis_2 on learner (thesis_id);



# --- !Downs

drop table if exists admin cascade;

drop table if exists instructor cascade;

drop table if exists learner cascade;

drop table if exists thesis cascade;

drop table if exists user_account cascade;

drop sequence if exists admin_seq;

drop sequence if exists instructor_seq;

drop sequence if exists learner_seq;

drop sequence if exists thesis_seq;

drop sequence if exists user_account_seq;

