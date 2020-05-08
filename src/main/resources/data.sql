--This file has purpose of populating the database when you launch the service for the first time
--This should be removed when going live

INSERT INTO team (teamname) VALUES ('Innovation Hub');
INSERT INTO team (teamname) VALUES ('Star Team');
INSERT INTO team (teamname) VALUES ('Intern Team');

INSERT INTO team_member (availability, name, teamid) VALUES (true, 'David Owen', 1);
INSERT INTO team_member (availability, name, teamid) VALUES (true, 'Jianan Sun', 1);
INSERT INTO team_member (availability, name, teamid) VALUES (true, 'Kaushik Datta', 1);
INSERT INTO team_member (availability, name, teamid) VALUES (true, 'Jordan Simo', 3);
INSERT INTO team_member (availability, name, teamid) VALUES (true, 'Kaiva Mannam', 3);
INSERT INTO team_member (availability, name, teamid) VALUES (true, 'Dennis Schwab', 3);
INSERT INTO team_member (availability, name, teamid) VALUES (true, 'Kevin Tiba', 2);
INSERT INTO team_member (availability, name, teamid) VALUES (true, 'Andrianna Walker', 2);
INSERT INTO team_member (availability, name, teamid) VALUES (true, 'Robot 1', 2);


INSERT INTO task (description, end_date, help, start_date, status, teammemberid) VALUES ('Build Taskr Service', '2020-05-04 00:00:00', false, '2020-05-01 00:00:00', true, 4);
INSERT INTO task (description, end_date, help, start_date, status, teammemberid) VALUES ('Link frontend and backend', '2020-05-01 00:00:00', false, '2020-05-01 00:00:00', true, 5);
INSERT INTO task (description, end_date, help, start_date, status, teammemberid) VALUES ('Create Powerpoint deck', '2020-05-01 00:00:00', false, '2020-05-01 00:00:00', true, 6);
