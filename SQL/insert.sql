/*
  Creating 5 Users
*/

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (1, 'ivo@mail.com', '089671253', 'ivo12345678', 'Ivaylo', 'Rumenov');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (2, 'asen@mail.com', '089412425', 'asen123asen', 'Asen', 'Hristove');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (3, 'damqn@mail.com', '09984932', 'damqnShefa', 'Damqn', 'Mihailov');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (4, 'hasan@mail.com', '08931265', 'hasendej', 'Hasan', 'Hassanov');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (5, 'user@mail.com', '08999999', '1234', 'User1', 'User1');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (6, 'muamed@mail.com', '0894234', 'muhadqnina123', 'Muhamed', 'Imal');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (7, 'IvanZvazdev@gmail.com', '0347573648', '112323231', 'Ivan', 'Zvezdev');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (8, 'KokoNikolov@mail.com', '08123123543', 'kdopasaoi', 'Koko', 'Nikolov');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (9, 'CecaIvanova@hotmail.com', '0892342176', 'Mamboamericano', 'Ceca', 'Ivanova');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (10, 'DamqnHristov@abv.bg', '089123789', 'Carqnakopona', 'Damqn', 'Hristov');

INSERT INTO Ape_user(id, email, phone, password, first_name, family_name)
VALUES (11, 'Marakew213@outloock.com', '08398345', 'Dubail123', 'Samoil', 'Kovachev');
/*
  Creating 3 Workers
*/

INSERT INTO Worker(worker_id,ape_user,position,time_stamp)
VALUES (1,1,'Meneger','2023-10-28');

INSERT INTO Worker(worker_id,ape_user,position,time_stamp)
VALUES (2,2,'HR','2023-10-28');

INSERT INTO Worker(worker_id,ape_user,position,time_stamp)
VALUES (3,3,'Support','2023-10-28');

/*
  Creating 2 Clients
*/

INSERT INTO Client(client_id,ape_user,status,time_stamp)
VALUES (1,4,1,1);

INSERT INTO Client(client_id,ape_user,status,time_stamp)
VALUES (2,5,2,1);

INSERT INTO Client(client_id,ape_user,status,time_stamp)
VALUES (3,6,1,1);

INSERT INTO Client(client_id,ape_user,status,time_stamp)
VALUES (4,7,2,1);

INSERT INTO Client(client_id,ape_user,status,time_stamp)
VALUES (5,8,1,1);

INSERT INTO Client(client_id,ape_user,status,time_stamp)
VALUES (6,9,2,1);

INSERT INTO Client(client_id,ape_user,status,time_stamp)
VALUES (7,10,2,1);

INSERT INTO Client(client_id,ape_user,status,time_stamp)
VALUES (8,11,2,1);

/*
  Creating 3 Instrument types
*/

INSERT INTO Instrument_type(id,instrument_type_name,time_stamp)
values (1,'Gittar','2023-10-28');

INSERT INTO Instrument_type(id,instrument_type_name,time_stamp)
values (2,'Drums','2023-10-28');

INSERT INTO Instrument_type(id,instrument_type_name,time_stamp)
values (3,'Brass','2023-10-28');

/*
  Creating 3 Genres
*/

INSERT INTO Genre(id,name,discretion,time_stamp)
values (1,'Rock','you know','2023-10-28');

INSERT INTO Genre(id,name,discretion,time_stamp)
values (2,'Jazz','you know','2023-10-28');

INSERT INTO Genre(id,name,discretion,time_stamp)
values (3,'Pop','you know','2023-10-28');

INSERT INTO Genre(id,name,discretion,time_stamp)
values (4,'Reggae','you know','2023-10-28');

INSERT INTO Genre(id,name,discretion,time_stamp)
values (5,'Mettal','you know','2023-10-28');

/*
  Creating 3 companies
*/

INSERT INTO Company(id,name,time_stamp)
values (1,'Febder','2023-10-28');

INSERT INTO Company(id,name,time_stamp)
values (2,'LPD','2023-10-28');

INSERT INTO Company(id,name,time_stamp)
values (3,'Yamaha','2023-10-28');

INSERT INTO Company(id,name,time_stamp)
values (4,'Perl','2023-10-28');

INSERT INTO Company(id,name,time_stamp)
values (5,'Marpex','2023-10-28');

INSERT INTO Company(id,name,time_stamp)
values (6,'Thumb','2023-10-28');

/*
  Creating 2 guitars and one bass Instruments.
*/

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (1,TRUE,32,'Fender_Squier_affinity_Series_Jazz_Bass.jpg','2013-10-28','Fender_Squier_Classic','Some diescriopton',1,1,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (2,TRUE,54,'Fender_Squier_Affinity.jpg','2013-10-28','Fender_Squier_Affinity','Some diescriopton',1,1,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (3,TRUE,65,'Fender_Squier_Bass.jpg','2013-10-28','Yamaha_YAS','Some diescriopton',2,3,'2023-10-28');

/*
    Creating 3 Records
*/

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (4,TRUE,32,'Guns_N_Rosses_GreatestHits.jpg','2013-10-28','Guns_N_Rosses_GreatestHits','Some diescriopton',2,3,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (5,TRUE,43,'Nirvana_Nevermind.JPG','2013-10-28','Nirvana_Nevermind','Some diescriopton',2,3,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (6,TRUE,15,'Queen_Greatest_Hits_1.jpg','2013-10-28','Queen_Greatest_Hits_1','Some diescriopton',2,3,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (7,TRUE,65,'Yamaha_YAS_280_S.jpg','2013-10-28','Yamaha_YAS','Some diescriopton',2,3,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (8,TRUE,45,'Yamaha_YAS_280.jpg','2013-10-28','Yamaha_YAS','Some diescriopton',2,3,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (9,TRUE,34,'Yamaha_YEP_642_TS.jpg','2013-10-28','Yamaha_YAS','Some diescriopton',2,3,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (10,TRUE,47,'Yamaha_YEP_642.jpg','2013-10-28','Yamaha_YAS','Some diescriopton',2,3,'2023-10-28');

/* Drum items */

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (11,TRUE,500,'thumb_base_fdb9291a.jpg','2013-10-28','Tama MBSS55-SKA Starclassic','Some diescriopton',1,6,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (12,TRUE,1340,'Ymapex-armory-ocean-sunset-ar628sfujg.jpg','2013-10-28','Ymapex-armory','Some diescriopton',1,5,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (13,TRUE,1120,'EXL725S-C246-large.jpg','2013-10-28','Perl','Some diescriopton',1,4,'2023-10-28');

/* Second set of records*/

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (14,TRUE,123,'Tyler_The_Creator_Igor.jpg','2013-10-28','Tyler The Creator Igor','Some diescriopton',3,6,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (15,TRUE,32,'Tama_Impala_Currents.jpg','2013-10-28','Tama Impala Currents','Some diescriopton',1,5,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (16,TRUE,54,'The_Bearles_Abbey_Read.JPG','2013-10-28','The Bearles Abbey Read','Some diescriopton',1,4,'2023-10-28');

/* Metalica*/

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (17,TRUE,44,'Metakkica_Garage_Inc.jpg','2013-10-28','Metakkica Garage Inc','Some diescriopton',5,6,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (18,TRUE,35,'Metallica.JPG','2013-10-28','Kill dem all','Some diescriopton',5,5,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (19,TRUE,56,'Metallica_Hardwired_To_Self_Destruct.JPG','2013-10-28','Hardwired To Self Destruct','Some diescriopton',5,4,'2023-10-28');

/* Bob marly */

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (20,TRUE,46,'Bob_Marley_Natty_Dread_Tour_75.jpg','2013-10-28','Natty Dread Tour','Some diescriopton',4,6,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (21,TRUE,75,'Bob_Marley_Uprising_Live.jpg','2013-10-28','Uprising Live','Some diescriopton',4,5,'2023-10-28');

INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp)
values (22,TRUE,45,'Bob+Marley_Songs_Of_Freedom.jpg','2013-10-28','Songs Of Freedom','Some diescriopton',4,4,'2023-10-28');

/*
  Creating 3 Instruments
*/

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (1,1,1,'2023-10-28');

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (2,2,2,'2023-10-28');

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (3,3,1,'2023-10-28');

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (4,7,1,'2023-10-28');

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (5,8,1,'2023-10-28');

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (6,9,1,'2023-10-28');

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (7,10,1,'2023-10-28');

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (8,11,2,'2023-10-28');

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (9,12,2,'2023-10-28');

INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp)
VALUES (10,13,2,'2023-10-28');


/*
  Creating 3 Instruments
*/

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (1,1);

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (2,1);

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (3,3);

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (4,3);

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (5,3);

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (6,3);

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (7,3);

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (8,2);

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (9,2);

INSERT INTO Instrument_istrument_type(instrument_id,instrument_type_id)
VALUES (10,2);

/*
  Creating 3 Record label
*/

INSERT INTO Record_label(id,Name,description,time_stamp)
VALUES (1,'Wiener Records','Some diescriopton','2023-10-28');

INSERT INTO Record_label(id,Name,description,time_stamp)
VALUES (2,'Kanine Records','Some diescriopton','2023-10-28');

INSERT INTO Record_label(id,Name,description,time_stamp)
VALUES (3,'Aftermath Entertainment','Some diescriopton','2023-10-28');

/*
  Creating 3 Artists
*/

INSERT INTO Artist(id,Name,record_label,time_stamp)
VALUES (1,'GunsNRoses',1,'2023-10-28');

INSERT INTO Artist(id,Name,record_label,time_stamp)
VALUES (2,'Nirvana',1,'2023-10-28');

INSERT INTO Artist(id,Name,record_label,time_stamp)
VALUES (3,'Queen',1,'2023-10-28');

INSERT INTO Artist(id,Name,record_label,time_stamp)
VALUES (4,'Tyler The Creator',1,'2023-10-28');

INSERT INTO Artist(id,Name,record_label,time_stamp)
VALUES (5,'Tema',1,'2023-10-28');

INSERT INTO Artist(id,Name,record_label,time_stamp)
VALUES (6,'The Bearles',1,'2023-10-28');

INSERT INTO Artist(id,Name,record_label,time_stamp)
VALUES (7,'Metalica',1,'2023-10-28');

INSERT INTO Artist(id,Name,record_label,time_stamp)
VALUES (8,'Bob Marley',1,'2023-10-28');

/*
  Creating 3 Records
*/

INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (1,4,1,1,'2023-10-28');

INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (2,5,2,1,'2023-10-28');

INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (3,6,3,3,'2023-10-28');



INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (4,14,4,1,'2023-10-28');

INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (5,15,5,1,'2023-10-28');

INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (6,16,6,3,'2023-10-28');



INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (7,17,7,2,'2023-10-28');

INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (8,18,7,2,'2023-10-28');

INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (9,19,7,2,'2023-10-28');



INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (10,20,8,1,'2023-10-28');

INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (11,21,8,1,'2023-10-28');

INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp)
VALUES (12,22,8,1,'2023-10-28');


/*
  Creating 10 Sale
*/

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (1,4,44,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (2,4,44,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (3,4,123,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (4,4,432,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (5,4,425,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (6,4,52,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (7,4,36,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (8,4,16,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (9,4,134,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (10,4,543,TRUE,'2023-10-28');

INSERT INTO Sale(Number,ape_user,amount,fulfill,time_stamp)
values (12,5,543,TRUE,'2023-10-28');
/*
  Creating 3 Sale_item
*/

INSERT INTO Sale_item(sale,item)
values (1,1);

INSERT INTO Sale_item(sale,item)
values (1,2);

INSERT INTO Sale_item(sale,item)
values (1,3);

INSERT INTO Sale_item(sale,item)
values (2,1);

INSERT INTO Sale_item(sale,item)
values (2,3);

INSERT INTO Sale_item(sale,item)
values (4,2);

INSERT INTO Sale_item(sale,item)
values (5,6);

INSERT INTO Sale_item(sale,item)
values (6,7);

INSERT INTO Sale_item(sale,item)
values (7,7);

INSERT INTO Sale_item(sale,item)
values (8,8);

INSERT INTO Sale_item(sale,item)
values (9,9);

INSERT INTO Sale_item(sale,item)
values (10,10);

INSERT INTO Sale_item(sale,item)
values (10,1);

INSERT INTO Sale_item(sale,item)
values (10,1);