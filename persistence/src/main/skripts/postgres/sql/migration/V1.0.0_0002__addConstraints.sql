-- Foreign Keys
alter table survey_group
    add foreign key (survey_id) references survey (id);
alter table survey_group
    add foreign key (answer_group_id) references answer_group (id);

alter table survey_element
    add foreign key (survey_group_id) references survey_group (id);

alter table answer
    add foreign key (survey_id) references survey (id);
alter table answer
    add foreign key (survey_element_id) references survey_element (id);
alter table answer
    add foreign key (person_id) references person (id);

