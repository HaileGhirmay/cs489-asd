-- Create tables

CREATE TABLE User (
  user_id varchar(10) PRIMARY KEY,
  username varchar(50),
  password varchar(50), 
  user_type varchar(10)
);

CREATE TABLE Dentist (
  dentist_id varchar(10) PRIMARY KEY,
  first_name varchar(50),
  last_name varchar(50),
  phone varchar(20),
  email varchar(100),
  specialization varchar(100),
  user_id varchar(10) REFERENCES User(user_id)
);

CREATE TABLE Patient (
  patient_id varchar(10) PRIMARY KEY,
  first_name varchar(50),
  last_name varchar(50),
  phone varchar(20),
  email varchar(100),
  address_id int REFERENCES Address(address_id),
  date_of_birth date,
  user_id varchar(10) REFERENCES User(user_id)  
);

CREATE TABLE Address (
  address_id int PRIMARY KEY,
  street varchar(100),
  city varchar(50),
  state varchar(2),
  zip varchar(10)
);

CREATE TABLE Appointment (
  appointment_id int PRIMARY KEY,
  appointment_date date, 
  appointment_time datetime,
  dentist_id varchar(10) REFERENCES Dentist(dentist_id),
  patient_id varchar(10) REFERENCES Patient(patient_id),
  surgery_id varchar(10)
);

CREATE TABLE Surgery (
  surgery_id varchar(10) PRIMARY KEY,
  name varchar(100),
  address varchar(200),
  phone varchar(20)
);

CREATE TABLE Bill (
  bill_id int PRIMARY KEY,
  bill_date date,
  amount float,
  patient_id varchar(10) REFERENCES Patient(patient_id)
);


-- Populate sample data

INSERT INTO User VALUES
  ('U03', 'haile', 'password1123', 'dentist'),
  ('U04', 'abiel', 'password4456', 'patient');

INSERT INTO Dentist VALUES
  ('D02', 'Johnm', 'Doem', '444-1234-99', 'omd@email.com', 'pediatrics', 'U03'); 

INSERT INTO Patient VALUES
  ('P02', 'Amma', 'nes', '555-3488', 'mma@email.com', 1, '2001-05-06', 'U04');
  
INSERT INTO Address VALUES
  (1, '123 Main St', 'City', 'CA', '12345');

INSERT INTO Appointment VALUES
  (1, '2023-10-12', '2023-10-12 09:00:00', 'D01', 'P02', 'S02');

INSERT INTO Surgery VALUES
  ('S02', 'City Center Surgery', '123 5th St, City, CA', '555-6789');

INSERT INTO Bill VALUES
  (1, '2023-10-12', 150.00, 'P01');
  
  
  -- QUERYING COMMANDS
 -- selecting all addresses
  SELECT * FROM ads.address;
  
  -- Dentists sorted by last name
SELECT *
FROM Dentist
ORDER BY last_name;

-- Appointments for a dentist 
SELECT a.*, p.*
FROM Appointment a
JOIN Patient p ON a.patient_id = p.patient_id
WHERE a.dentist_id = 'D1';

-- Appointments at a surgery
SELECT *
FROM Appointment
WHERE surgery_id = 'S1';

-- Appointments for a patient on a date  
SELECT *
FROM Appointment
WHERE patient_id = 'P1'
AND appointment_date = '2023-10-15';