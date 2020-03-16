create extension if not exists "uuid-ossp";
create type answer_type as enum ('YES', 'NO');

create table survey (
    id uuid not null default uuid_generate_v4 (),
    name text not null,
    creationDate timestamp,
    finishBy timestamp,
    area text,
    primary key (id)
);

create table person (
    id uuid not null default uuid_generate_v4 (),
    lastname text,
    firstname text,
    mail text,
    primary key (id)
);

create table answer_group (
    id uuid not null default uuid_generate_v4 (),
    description text,
    answer_possibilities answer_type[],
    primary key (id)
);

create table survey_group (
    id uuid not null default uuid_generate_v4 (),
    survey_id uuid,
    answer_group_id uuid,
    part integer,
    primary key (id)
);

create table survey_element (
    id uuid not null default uuid_generate_v4 (),
    survey_group_id uuid,
    type text,
    position int,
    primary key (id)
);

create table survey_date_element (
    date date
) inherits(survey_element);

create table answer (
    id uuid not null default uuid_generate_v4 (),
    survey_id uuid,
    survey_element_id uuid,
    person_id uuid,
    selected_answer answer_type,
    primary key (id)
);




