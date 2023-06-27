--drop tables in order
DROP TABLE IF EXISTS accident;
DROP TABLE IF EXISTS severity;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS accidenttype;
DROP TABLE IF EXISTS witness;

-- create tables
CREATE TABLE witness (
  witness_email VARCHAR(40) PRIMARY KEY,
  first_name varchar(20) NOT NULL,
  last_name varchar(20) NOT NULL,
  mobile int NOT NULL,
  password varchar(64) NOT NULL
);

CREATE TABLE accidenttype(
  accident_type_id int AUTO_INCREMENT PRIMARY KEY, 
  accident_type VARCHAR(30) NOT NULL
);

CREATE TABLE severity(
  severity varchar(8) PRIMARY KEY
  
);

CREATE TABLE location(
 location_id int AUTO_INCREMENT PRIMARY KEY,
 street_number varchar(5) NOT NULL,
 street_name varchar(30) NOT NULL,
 suburb VARCHAR(30) NOT NULL,
 postcode int NOT NULL,
 loc_state VARCHAR(3) NOT NULL,
 latitude double NOT NULL,
 longitude double NOT NULL
);

CREATE TABLE accident(
 accident_id int AUTO_INCREMENT PRIMARY KEY,
 vehicle_count int NOT NULL,
 accident_date DATE NOT NULL,
 accident_time TIME NOT NULL,
 accident_desc VARCHAR(100) DEFAULT NULL, 
 location_id int NOT NULL,
 accident_type_id int NOT NULL,
 witness_email VARCHAR(40) NOT NULL, 
 severity varchar(8) NOT NULL,
 
 CONSTRAINT FK_acc_type FOREIGN KEY (accident_type_id) REFERENCES accidenttype(accident_type_id),
 CONSTRAINT FK_witness FOREIGN KEY (witness_email) REFERENCES witness(witness_email),
 CONSTRAINT FK_location FOREIGN KEY (location_id) REFERENCES location(location_id),
 CONSTRAINT FK_severity FOREIGN KEY (severity) REFERENCES severity(severity)
 
);