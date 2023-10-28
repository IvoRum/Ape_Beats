/*
  Creating 5 Users
*/

INSERT INTO "User"("id", "email", "phone", "password", "first_name","famisly_name")
VALUES (1, "ivo@mail.com", "089671253", "ivo12345678", "Ivaylo", "Rumenov");

INSERT INTO "User"("id", "email", "phone", "password", "first_name","family_name")
VALUES (2, "asen@mail.com", "089412425", "asen123asen", "Asen", "Hristove");

INSERT INTO "User"("id", "email", "phone", "password", "first_name","family_name")
VALUES (3, "damqn@mail.com", "09984932", "damqnShefa", "Damqn", "Mihailov");

INSERT INTO "User"("id", "email", "phone", "password", "first_name","family_name")
VALUES (4, "hasan@mail.com", "08931265", "hasendej", "Hasan", "Hassanov");

INSERT INTO "User"("id", "email", "phone", "password", "first_name","family_name")
VALUES (5, "user@mail.com", "08999999", "1234", "User1", "User1");

/*
  Creating 3 Workers
*/

INSERT INTO "Worker"("worker_id","user_id","position","time_stamp")
VALUES (1,1,"Meneger",'2023-10-28');

INSERT INTO "Worker"("worker_id","user_id","position","time_stamp")
VALUES (2,2,"HR",'2023-10-28');

INSERT INTO "Worker"("worker_id","user_id","position","time_stamp")
VALUES (3,3,"Support",'2023-10-28');

/*
  Creating 2 Clients
*/

INSERT INTO "Client"("client_id","user_id","status","time_stamp")
VALUES (1,4,"Bannad",'2023-10-28');

INSERT INTO "Client"("client_id","user_id","status","time_stamp")
VALUES (2,5,"Regular",'2023-10-28');

/*
  Creating 3 Instrument types
*/

INSERT INTO "Instrument _type"("id","name","time_stamp")
values (1,"Gittar",'2023-10-28');

INSERT INTO "Instrument _type"("id","name","time_stamp")
values (2,"Drums",'2023-10-28');

INSERT INTO "Instrument _type"("id","name","time_stamp")
values (3,"Brass",'2023-10-28');

/*
  Creating 3 Genres
*/

INSERT INTO "Genre"("id","name","discretion","time_stamp")
values (1,"Rock","You know",'2023-10-28');

INSERT INTO "Genre"("id","name","discretion","time_stamp")
values (2,"Jazz","You know",'2023-10-28');

INSERT INTO "Genre"("id","name","discretion","time_stamp")
values (3,"Pop","You know",'2023-10-28');

/*
  Creating 3 companies
*/

INSERT INTO "Company"("id","name","time_stamp")
values (1,"Febder",'2023-10-28');

INSERT INTO "Company"("id","name","time_stamp")
values (2,"LPD",'2023-10-28');

INSERT INTO "Company"("id","name","time_stamp")
values (3,"Yamaha",'2023-10-28');

/*
  Creating 2 guitars and one bass Instruments.
*/

INSERT INTO "Item"("item_id","stock","price","discrimination","manufacturing_date","name","description","genre","company","time_stamp")
values (1,TRUE,"32","Some diescriopton",'2013-10-28',"Fender_Squier_Classic","Some diescriopton",1,1,'2023-10-28');

INSERT INTO "Item"("item_id","stock","price","discrimination","manufacturing_date","name","description","genre","company","time_stamp")
values (2,TRUE,"54","Some diescriopton",'2013-10-28',"Fender_Squier_Affinity","Some diescriopton",3,1,'2023-10-28');

INSERT INTO "Item"("item_id","stock","price","discrimination","manufacturing_date","name","description","genre","company","time_stamp")
values (3,TRUE,"65","Some diescriopton",'2013-10-28',"Yamaha_YAS","Some diescriopton",2,3,'2023-10-28');

/*
    Creating 3 Records
*/

INSERT INTO "Item"("item_id","stock","price","discrimination","manufacturing_date","name","description","genre","company","time_stamp")
values (4,TRUE,"32","Some diescriopton",'2013-10-28',"Yamaha_YAS","Some diescriopton",2,3,'2023-10-28');

INSERT INTO "Item"("item_id","stock","price","discrimination","manufacturing_date","name","description","genre","company","time_stamp")
values (5,TRUE,"43","Some diescriopton",'2013-10-28',"Yamaha_YAS","Some diescriopton",2,3,'2023-10-28');

INSERT INTO "Item"("item_id","stock","price","discrimination","manufacturing_date","name","description","genre","company","time_stamp")
values (6,TRUE,"15","Some diescriopton",'2013-10-28',"Yamaha_YAS","Some diescriopton",2,3,'2023-10-28');

/*
  Creating 3 Instruments
*/

INSERT INTO "Instrument"("Instrument_id","item_id","type","time_stamp")
VALUES (1,1,1,"time_stamp",'2023-10-28');

INSERT INTO "Instrument"("Instrument_id","item_id","type","time_stamp")
VALUES (2,2,1,"time_stamp",'2023-10-28');

INSERT INTO "Instrument"("Instrument_id","item_id","type","time_stamp")
VALUES (3,2,1,"time_stamp",'2023-10-28');

/*
  Creating 3 Instruments
*/

INSERT INTO "Instrument_istrument_type"("instrument_id","instrument_type_id")
VALUES (1,1);

INSERT INTO "Instrument_istrument_type"("instrument_id","instrument_type_id")
VALUES (1,2);

INSERT INTO "Instrument_istrument_type"("instrument_id","instrument_type_id")
VALUES (2,1);

/*
  Creating 3 Record label
*/

INSERT INTO "Record_label"("id","Name","description","time_stamp")
VALUES (1,"Wiener Records","Some diescriopton",'2023-10-28');

INSERT INTO "Record_label"("id","Name","description","time_stamp")
VALUES (2,"Kanine Records","Some diescriopton",'2023-10-28');

INSERT INTO "Record_label"("id","Name","description","time_stamp")
VALUES (3,"Aftermath Entertainment","Some diescriopton",'2023-10-28');

/*
  Creating 3 Artists
*/

INSERT INTO "Artist"("id","Name","record_label","time_stamp")
VALUES (1,"GunsNRoses",1,'2023-10-28');

INSERT INTO "Artist"("id","Name","record_label","time_stamp")
VALUES (2,"Nirvana",1,'2023-10-28');

INSERT INTO "Artist"("id","Name","record_label","time_stamp")
VALUES (3,"Queen",1,'2023-10-28');

/*
  Creating 3 Records
*/

INSERT INTO "Record"("Record_id","item_id","name","artist","record_label","time_stamp")
VALUES (1,4,"Guns_N_Rosses_GreatestHits",1,1,'2023-10-28');

INSERT INTO "Record"("Record_id","item_id","name","artist","record_label","time_stamp")
VALUES (2,5,"Nirvana_Nevermind",2,1,'2023-10-28');

INSERT INTO "Record"("Record_id","item_id","name","artist","record_label","time_stamp")
VALUES (3,6,"Queen_Greatest_Hits_1",3,3,'2023-10-28');

/*
  Creating 3 Sale
*/

INSERT INTO "Sale"("Number","user","amount","fulfill","time_stamp")
values (1,4,44,TRUE,'2023-10-28');

INSERT INTO "Sale"("Number","user","amount","fulfill","time_stamp")
values (1,4,44,TRUE,'2023-10-28');

INSERT INTO "Sale"("Number","user","amount","fulfill","time_stamp")
values (1,4,44,TRUE,'2023-10-28');

/*
  Creating 3 Sale_item
*/

INSERT INTO "Sale_item"("sale","item")
values (1,1);

INSERT INTO "Sale_item"("sale","item")
values (1,2);

INSERT INTO "Sale_item"("sale","item")
values (1,3);


