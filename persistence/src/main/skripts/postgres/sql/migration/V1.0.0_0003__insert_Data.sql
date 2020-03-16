-- Test Data

insert into person values
('892af680-366b-4eee-982c-0dfce178c9e4', 'Scheiwiller', 'Christoph', 'christoph.scheiwiller@hsr.ch');

insert into survey values
('95968faf-de7d-4a42-976c-c72cd660bd57', 'Sommer Tour', '2020-03-11 07:29:25', '2020-05-01 00:00:00 ' , 'Zentralschweiz');

insert into answer_group (id, description, answer_possibilities) values
('2a4b7a66-2aa0-40a3-bd46-d0ead621dc69', 'YesNoOption', '{"YES", "NO"}');

insert into survey_group (id, survey_id, answer_group_id, part) values
('1aef2470-4328-43c2-bb05-b263ccbec084', '95968faf-de7d-4a42-976c-c72cd660bd57', '2a4b7a66-2aa0-40a3-bd46-d0ead621dc69', 0);

insert into survey_date_element (id, survey_group_id, type, position, date) values
('21e16178-9920-4da2-bc72-102882f13f10', '1aef2470-4328-43c2-bb05-b263ccbec084', 'DATE', 0, '20200401'),
('5c13cf09-e94e-43e7-a698-e74ee9dc3b8e', '1aef2470-4328-43c2-bb05-b263ccbec084', 'DATE', 1, '20200402'),
('e9b178bc-0adc-4537-bb8a-a0c380204d2d', '1aef2470-4328-43c2-bb05-b263ccbec084', 'DATE', 2, '20200403');

insert into answer (id, survey_id, survey_element_id, person_id, selected_answer) values
('8a829fa1-b39f-447e-83e7-a4a4d728f0bb', '95968faf-de7d-4a42-976c-c72cd660bd57','21e16178-9920-4da2-bc72-102882f13f10', '892af680-366b-4eee-982c-0dfce178c9e4', 'YES'),
('ec2a3324-4315-4a36-9567-3eb042a75f43', '95968faf-de7d-4a42-976c-c72cd660bd57','5c13cf09-e94e-43e7-a698-e74ee9dc3b8e', '892af680-366b-4eee-982c-0dfce178c9e4', 'NO'),
('0adb2f2e-fb53-4e6e-b2d5-3d72497829ae', '95968faf-de7d-4a42-976c-c72cd660bd57','e9b178bc-0adc-4537-bb8a-a0c380204d2d', '892af680-366b-4eee-982c-0dfce178c9e4', 'YES');
