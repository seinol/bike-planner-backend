create type answer_type as enum ('YES', 'NO');
create type element_type as enum ('DATE');

create table survey (
    id SERIAL not null,
    name text not null,
    creationDate timestamp,
    finishBy timestamp,
    area text,
    url_hash text,
    primary key (id)
);

create table person (
    id SERIAL not null,
    lastname text,
    firstname text,
    mail text,
    primary key (id)
);

create table answer_group (
    id SERIAL not null,
    description text,
    answer_possibilities answer_type[],
    primary key (id)
);

create table survey_group (
    id SERIAL not null,
    survey_id integer,
    answer_group_id integer,
    part integer,
    primary key (id)
);

create table survey_element (
    id SERIAL not null,
    survey_group_id integer,
    type text,
    position int,
    primary key (id)
);

create table survey_date_element (
    id SERIAL not null,
    survey_element_id integer,
    date date
);

create table answer (
    id SERIAL not null,
    survey_id integer,
    survey_element_id integer,
    person_id integer,
    selected_answer smallint,
    primary key (id)
);




