
INSERT INTO witness VALUES
('testperson@email.com','Test', 'Person', 123456789),
('bevanmuirhead@gmail.com','Bevan', 'Muirhead', 987654321),
('genericman@email.com','Generic', 'Man', 111111111),
('genericwoman@email.com','Generic', 'Woman', 111111112),
('cayden.darley@gmail.com', 'Cayden', 'Darley', 1111222333);

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
(2,"", "" ,"Cardiff South",2285, "NSW", "-32.950974", "151.662222" ),
(3,'', "" ,"Red Hill",4059, "QLD", "0", "0" );


INSERT INTO accident VALUES
(1,2,"2023-06-15","08:15:12","Two car major crash in middle of road",1,1,'testperson@email.com',"Minor"),
(2,1,"2023-06-17","09:15:15","Massive Oil Spill",2,7,'genericman@email.com',"Major"),
(3,3,"2023-06-19","10:15:19","2x motorbikes and one truck involved",3,3,'genericwoman@email.com',"Severe");


