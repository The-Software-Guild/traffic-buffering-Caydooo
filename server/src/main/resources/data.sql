
INSERT INTO witness VALUES
('johnr@email.com','John', 'Reece', 123456789 , "a4ayc/80/OGda4BO/1o/V0etpOqiLx1JwB5S3beHW0s="),
('bevanmuirhead@gmail.com','Bevan', 'Muirhead', 987654321, "a4ayc/80/OGda4BO/1o/V0etpOqiLx1JwB5S3beHW0s="),
('marks@email.com','Mark', 'Snow', 111111111, "a4ayc/80/OGda4BO/1o/V0etpOqiLx1JwB5S3beHW0s="),
('haroldfinch@email.com','Harold', 'Finch', 111111112, "a4ayc/80/OGda4BO/1o/V0etpOqiLx1JwB5S3beHW0s="),
('cayden.darley@gmail.com', 'Cayden', 'Darley', 1111222333, "a4ayc/80/OGda4BO/1o/V0etpOqiLx1JwB5S3beHW0s=");

INSERT INTO accidenttype values
(1,"Car Crash"),
(2,"Truck Crash"),
(3,"Motorcycle Crash"),
(4,"Bus Crash"),
(5,"Hit And Run"),
(6,"Overturned Truck"),
(7,"Car Fire"),
(8,"Spill"),
(9,"Vehicle and Pedestrian"),
(10,"Other");


INSERT INTO severity values
("Minor"),
("Major"),
("Severe");

INSERT INTO location VALUES
(1,'1', "Wellgate Avenue" ,"Kellyville",2155, "NSW", "-33.68359941231308", "150.93210341670581" ),
(2,"2", "May Street" ,"Cardiff South",2285, "NSW", "-32.950974", "151.662222" ),
(3,'2', "Staple Street" ,"Seventeen Mile Rocks",4073, "QLD", "-27.545100", "152.954106" );


INSERT INTO accident VALUES
(1,2,"2023-06-15","08:15:12","Two car major crash in the middle of the road",1,1,'johnr@email.com',"Minor"),
(2,1,"2023-06-17","09:15:15","Massive Oil Spill",2,7,'marks@email.com',"Major"),
(3,3,"2023-06-19","10:15:19","2x motorbikes and one truck involved",3,3,'haroldfinch@email.com',"Severe");


