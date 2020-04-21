-- Test Data

insert into person values
('1', 'Scheiwiller', 'Christoph', 'christoph.scheiwiller@hsr.ch');

insert into survey values
('1', 'Sommer Tour', '2020-03-11 07:29:25', '2020-05-01 00:00:00 ' , 'Zentralschweiz');

insert into answer_group (id, description, answer_possibilities) values
('1', 'YesNoOption', '{"YES", "NO"}');

insert into survey_group (id, survey_id, answer_group_id, part) values
('1', '1', '1', 0);

insert into survey_element (id, survey_group_id, type, position) values
('1', '1', 'DATE', 0),
('2', '1', 'DATE', 1),
('3', '1', 'DATE', 2);


insert into survey_date_element (id, survey_element_id, date) values
('1', '1', '20200401'),
('2', '2', '20200402'),
('3', '3', '20200403');


insert into answer (id, survey_id, survey_element_id, person_id, selected_answer) values
('1', '1','1', '1', 'YES'),
('2', '1','2', '1', 'NO'),
('3', '1','3', '1', 'YES');

