# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bookmark (
  id                        bigint not null,
  title                     varchar(255),
  url                       varchar(255),
  details                   varchar(255),
  category_id               bigint,
  constraint pk_bookmark primary key (id))
;

create table category (
  id                        bigint not null,
  label                     varchar(255),
  constraint pk_category primary key (id))
;

create sequence bookmark_seq;

create sequence category_seq;

alter table bookmark add constraint fk_bookmark_category_1 foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_bookmark_category_1 on bookmark (category_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists bookmark;

drop table if exists category;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists bookmark_seq;

drop sequence if exists category_seq;

