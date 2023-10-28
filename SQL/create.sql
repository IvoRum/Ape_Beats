CREATE TABLE "User"(
                       "id" BIGINT NOT NULL,
                       "email" VARCHAR(255) NOT NULL,
                       "phone" VARCHAR(255) NOT NULL,
                       "password" VARCHAR(255) NOT NULL,
                       "first_name" VARCHAR(255) NOT NULL,
                       "family_name" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "User" ADD PRIMARY KEY("id");
CREATE TABLE "Instrument"(
                             "Instrument_id" BIGINT NOT NULL,
                             "item_id" BIGINT NOT NULL,
                             "type" BIGINT NOT NULL,
                             "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Instrument" ADD PRIMARY KEY("Instrument_id");
CREATE TABLE "Item"(
                       "item_id" BIGINT NOT NULL,
                       "stock" BOOLEAN NOT NULL,
                       "price" BIGINT NOT NULL,
                       "discrimination" VARCHAR(255) NULL,
                       "manufacturing_date" DATE NOT NULL,
                       "name" VARCHAR(255) NOT NULL,
                       "description" VARCHAR(255) NOT NULL,
                       "genre" BIGINT NOT NULL,
                       "company" BIGINT NOT NULL,
                       "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Item" ADD PRIMARY KEY("item_id");
CREATE TABLE "Sale_item"(
                            "sale" BIGINT NOT NULL,
                            "item" BIGINT NOT NULL
);
CREATE TABLE "Instrument_istrument_type"(
                                            "instrument_id" BIGINT NOT NULL,
                                            "instrument_type_id" BIGINT NOT NULL
);
CREATE TABLE "Sale"(
                       "Number" BIGINT NOT NULL,
                       "user" BIGINT NOT NULL,
                       "amount" BIGINT NOT NULL,
                       "fulfill" BOOLEAN NOT NULL,
                       "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Sale" ADD PRIMARY KEY("Number");
CREATE TABLE "Genre"(
                        "id" BIGINT NOT NULL,
                        "name" VARCHAR(255) NOT NULL,
                        "discretion" VARCHAR(255) NOT NULL,
                        "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Genre" ADD PRIMARY KEY("id");
CREATE TABLE "Company"(
                          "id" BIGINT NOT NULL,
                          "name" VARCHAR(255) NOT NULL,
                          "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Company" ADD PRIMARY KEY("id");
CREATE TABLE "Artist"(
                         "id" BIGINT NOT NULL,
                         "Name" VARCHAR(255) NOT NULL,
                         "record_label" BIGINT NOT NULL,
                         "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Artist" ADD PRIMARY KEY("id");
CREATE TABLE "Record"(
                         "Record_id" BIGINT NOT NULL,
                         "item_id" BIGINT NOT NULL,
                         "name" VARCHAR(255) NOT NULL,
                         "artist" BIGINT NOT NULL,
                         "record_label" BIGINT NOT NULL,
                         "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Record" ADD PRIMARY KEY("Record_id");
CREATE TABLE "Record_label"(
                               "id" BIGINT NOT NULL,
                               "Name" VARCHAR(255) NOT NULL,
                               "description" VARCHAR(255) NOT NULL,
                               "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Record_label" ADD PRIMARY KEY("id");
CREATE TABLE "Worker"(
                         "worker_id" BIGINT NOT NULL,
                         "user_id" BIGINT NOT NULL,
                         "position" VARCHAR(255) NOT NULL,
                         "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Worker" ADD PRIMARY KEY("worker_id");
CREATE TABLE "Client"(
                         "client_id" BIGINT NOT NULL,
                         "user_id" BIGINT NOT NULL,
                         "status" BIGINT NOT NULL,
                         "time_stamp" BIGINT NOT NULL
);
ALTER TABLE
    "Client" ADD PRIMARY KEY("client_id");
CREATE TABLE "Instrument _type"(
                                   "id" BIGINT NOT NULL,
                                   "name" VARCHAR(255) NOT NULL,
                                   "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Instrument _type" ADD PRIMARY KEY("id");
ALTER TABLE
    "Instrument_istrument_type" ADD CONSTRAINT "instrument_istrument_type_instrument_type_id_foreign" FOREIGN KEY("instrument_type_id") REFERENCES "Instrument _type"("id");
ALTER TABLE
    "Item" ADD CONSTRAINT "item_company_foreign" FOREIGN KEY("company") REFERENCES "Company"("id");
ALTER TABLE
    "Record" ADD CONSTRAINT "record_item_id_foreign" FOREIGN KEY("item_id") REFERENCES "Item"("item_id");
ALTER TABLE
    "Sale_item" ADD CONSTRAINT "sale_item_sale_foreign" FOREIGN KEY("sale") REFERENCES "Sale"("Number");
ALTER TABLE
    "Record" ADD CONSTRAINT "record_artist_foreign" FOREIGN KEY("artist") REFERENCES "Artist"("id");
ALTER TABLE
    "Instrument" ADD CONSTRAINT "instrument_item_id_foreign" FOREIGN KEY("item_id") REFERENCES "Item"("item_id");
ALTER TABLE
    "Artist" ADD CONSTRAINT "artist_record_label_foreign" FOREIGN KEY("record_label") REFERENCES "Record_label"("id");
ALTER TABLE
    "Worker" ADD CONSTRAINT "worker_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "User"("id");
ALTER TABLE
    "Sale_item" ADD CONSTRAINT "sale_item_item_foreign" FOREIGN KEY("item") REFERENCES "Item"("item_id");
ALTER TABLE
    "Record" ADD CONSTRAINT "record_record_label_foreign" FOREIGN KEY("record_label") REFERENCES "Record_label"("id");
ALTER TABLE
    "Client" ADD CONSTRAINT "client_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "User"("id");
ALTER TABLE
    "Item" ADD CONSTRAINT "item_genre_foreign" FOREIGN KEY("genre") REFERENCES "Genre"("id");
ALTER TABLE
    "Sale" ADD CONSTRAINT "sale_user_foreign" FOREIGN KEY("user") REFERENCES "User"("id");
ALTER TABLE
    "Instrument_istrument_type" ADD CONSTRAINT "instrument_istrument_type_instrument_id_foreign" FOREIGN KEY("instrument_id") REFERENCES "Instrument"("Instrument_id");