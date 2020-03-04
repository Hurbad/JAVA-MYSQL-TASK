DROP DATABASE pt;
CREATE DATABASE pt;

use pt;


CREATE TABLE focus (
focusid VARCHAR(3),
focusname VARCHAR(25),
PRIMARY KEY (focusid));



CREATE TABLE client (
clientid VARCHAR(3),
fname VARCHAR(25) NOT NULL,
lname VARCHAR(25) NOT NULL,
PRIMARY KEY(clientid));


CREATE TABLE trainer (
trainerid VARCHAR(3),
pt_name VARCHAR(25) NOT NULL,
PRIMARY KEY(trainerid));



CREATE TABLE booking (
bookingid INT NOT NULL AUTO_INCREMENT,
clientid VARCHAR(4) NOT NULL,
trainerid VARCHAR(4) NOT NULL,
focusid VARCHAR(4)NOT NULL,
duration INT NOT NULL,
date DATE NOT NULL,
time TIME NOT NULL,
PRIMARY KEY(bookingid),
FOREIGN KEY(clientid) REFERENCES client(clientid)ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(trainerid) REFERENCES trainer(trainerid)ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(focusid) REFERENCES focus(focusid)ON DELETE CASCADE ON UPDATE CASCADE);



INSERT INTO focus(focusid, focusname) VALUES
('F1' , 'Weight'),
('F2' , 'Cardio'),
('F3' , 'Muscle'),
('F4',  'Flexibility' );

INSERT INTO client(clientid, fname, lname) VALUES
('C1', 'Tom' , 'Smith' ),
('C2', 'John' , 'Harris' ),
('C3', 'Sam' , 'Max' ),
('C4', 'Bob' , 'Mike');

INSERT INTO trainer(trainerid, pt_name) VALUES

('T1', 'Billy' ),
('T2', 'Matthew' ),
('T3', 'Jessica' ),
('T4', 'Eve' );

INSERT INTO booking( clientid, focusid, trainerid, duration, date, time) VALUES
('C1', 'F1', 'T1' , 60,'2020-12-10 ', '11:00:00'),
('C2', 'F2', 'T2' , 60, '2020-12-10' , '11:00:00'),
('C3', 'F3', 'T3' , 60,'2020-12-10' , '11:00:00'),
('C4', 'F4', 'T4' , 60, '2020-12-10' , '11:00:00');



