ROLLBACK;
BEGIN TRANSACTION;
DROP TABLE IF EXISTS members CASCADE;
DROP TABLE IF EXISTS interest_group CASCADE;
DROP TABLE IF EXISTS event_ CASCADE;
DROP TABLE IF EXISTS member_event CASCADE;
DROP TABLE IF EXISTS member_interest_group CASCADE;

CREATE TABLE members (
	member_number serial,
	last_name varchar(200) NOT NULL,
	first_name varchar(200) NOT NULL,
	email_address varchar(200) NOT NULL,
	phone_number varchar (200) NOT NULL,
	date_of_birth date NOT NULL,
	reminder_email_flag boolean,
	PRIMARY KEY (member_number)
);
CREATE TABLE interest_group (
	group_number serial,
	name varchar(100) UNIQUE,
	PRIMARY KEY (group_number)
);
CREATE TABLE event_ (
    event_number serial,
    name varchar(100) NOT NULL,
    description varchar(100) NOT NULL,
    start_date_time timestamp NOT NULL,
    duration int NOT NULL,
    group_number int,
	PRIMARY KEY (event_number)
    
);
CREATE TABLE member_event (
    member_number int NOT NULL,
    event_number int NOT NULL
   
);
CREATE TABLE member_interest_group (
    member_number int NOT NULL,
    group_number int NOT NULL
);
ALTER TABLE event_
ADD FOREIGN KEY (group_number) REFERENCES interest_group (group_number);

ALTER TABLE member_event
ADD FOREIGN KEY (member_number) REFERENCES members(member_number);

ALTER TABLE member_event
ADD FOREIGN KEY (event_number) REFERENCES event_(event_number);

ALTER TABLE member_interest_group
ADD FOREIGN KEY (member_number) REFERENCES members(member_number);

ALTER TABLE member_interest_group
ADD FOREIGN KEY (group_number) REFERENCES interest_group(group_number);
	
COMMIT;
INSERT INTO members (last_name, first_name, email_address, phone_number, date_of_birth, reminder_email_flag)
VALUES ('Stone', 'Alex', 'stonealex@gmail.com', '1234567890', '05-08-1996', true),
('Garza', 'Brian', 'briangarza@gmail.com', '1234567897', '05-08-2000', true),
('Steiner', 'Grant', 'gjsteiner@gmail.com', '1234567896', '10-09-1996', false),
('Little', 'Quang', 'littlequang@gmail.com', '1234567895', '06-08-1996', false),
('Nguyan', 'Nicole', 'nguyannicole@gmail.com', '1234567894', '09-10-1990', false),
('Fichtner', 'Aisha', 'afichtner@gmail.com', '1234567893', '05-08-1995', false),
('Brady', 'Tom', 'tbrady@gmail.com', '1234567892', '03-19-1996', true),
('McGee', 'Bob', 'bmcgee@gmail.com', '1234567891', '03-08-2006', true);


INSERT INTO interest_group (name)
VALUES ('Self Betterment'),
('The Only Way'),
('Getting a Hand');

INSERT INTO event_ (name, description, start_date_time, duration, group_number)
VALUES ('Brian Garza Self Discovery Seminar', 'Discovering your inner bald old man', '2023-04-18', 180, 1),
('Alex Stone in the path to perfect spelling', 'How to spell your name in two to three easy words', '2023-04-20', 60, 2),
('Quangs Handy Coding Time', 'How to become a rich handsome coder man', '2023-04-23', 90, 3),
('Kevin Little Presentation', 'Being super handsome in three easy steps', '2023-04-14', 200, 1);

INSERT INTO member_event (member_number, event_number)
VALUES (1,1),
(2,2),
(3,3),
(4,4);

INSERT INTO member_interest_group (member_number, group_number)
VALUES (1,1),
(2,1),
(3,2),
(4,2),
(5,3),
(6,3)