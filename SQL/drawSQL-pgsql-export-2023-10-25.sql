CREATE TABLE "User"(
    "id" BIGINT NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "phone" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "first_name" BIGINT NOT NULL,
    "family_name" BIGINT NOT NULL
);
ALTER TABLE
    "User" ADD PRIMARY KEY("id");
CREATE TABLE "Instrument"(
    "item_id" BIGINT NOT NULL,
    "name" BIGINT NOT NULL,
    "description" VARCHAR(255) NOT NULL,
    "type" BIGINT NOT NULL,
    "genre" BIGINT NOT NULL,
    "company" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Instrument" ADD PRIMARY KEY("item_id");
CREATE TABLE "Item"(
    "item_id" BIGINT NOT NULL,
    "stock" BOOLEAN NOT NULL,
    "discrimination" VARCHAR(255) NOT NULL,
    "status" BIGINT NOT NULL,
    "type" VARCHAR(255) NOT NULL,
    "year" DATE NOT NULL,
    "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Item" ADD PRIMARY KEY("item_id");
CREATE TABLE "Item_price"(
    "price" DOUBLE PRECISION NOT NULL,
    "item" BIGINT NOT NULL,
    "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Item_price" ADD PRIMARY KEY("price");
ALTER TABLE
    "Item_price" ADD PRIMARY KEY("item");
CREATE TABLE "Sale_item"(
    "sale" BIGINT NOT NULL,
    "item" BIGINT NOT NULL
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
    "discretion" BIGINT NOT NULL,
    "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Genre" ADD PRIMARY KEY("id");
CREATE TABLE "Company"(
    "id" BIGINT NOT NULL,
    "name" BIGINT NOT NULL,
    "time_stamp" DATE NOT NULL
);
ALTER TABLE
    "Company" ADD PRIMARY KEY("id");
CREATE TABLE "Artist"(
    "id" BIGINT NOT NULL,
    "Name" VARCHAR(255) NOT NULL,
    "record_label" BIGINT NOT NULL,
    "time_stamp" BIGINT NOT NULL
);
ALTER TABLE
    "Artist" ADD PRIMARY KEY("id");
CREATE TABLE "Record"(
    "item_id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "artist" BIGINT NOT NULL,
    "genre" BIGINT NOT NULL,
    "activ" BOOLEAN NOT NULL,
    "record_label" BIGINT NOT NULL,
    "time_stamp" DATE NOT NULL,
    "company" BIGINT NOT NULL
);
ALTER TABLE
    "Record" ADD PRIMARY KEY("item_id");
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
    "position" BIGINT NOT NULL
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
    "Record" ADD CONSTRAINT "record_artist_foreign" FOREIGN KEY("artist") REFERENCES "Artist"("Name");
ALTER TABLE
    "Item" ADD CONSTRAINT "item_item_id_foreign" FOREIGN KEY("item_id") REFERENCES "Record"("item_id");
ALTER TABLE
    "Sale_item" ADD CONSTRAINT "sale_item_sale_foreign" FOREIGN KEY("sale") REFERENCES "Sale"("Number");
ALTER TABLE
    "Instrument _type" ADD CONSTRAINT "instrument _type_name_foreign" FOREIGN KEY("name") REFERENCES "Instrument"("type");
ALTER TABLE
    "Item" ADD CONSTRAINT "item_item_id_foreign" FOREIGN KEY("item_id") REFERENCES "Instrument"("item_id");
ALTER TABLE
    "Instrument" ADD CONSTRAINT "instrument_genre_foreign" FOREIGN KEY("genre") REFERENCES "Genre"("name");
ALTER TABLE
    "Record" ADD CONSTRAINT "record_record_label_foreign" FOREIGN KEY("record_label") REFERENCES "Record_label"("Name");
ALTER TABLE
    "Record" ADD CONSTRAINT "record_genre_foreign" FOREIGN KEY("genre") REFERENCES "Genre"("name");
ALTER TABLE
    "Worker" ADD CONSTRAINT "worker_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "User"("id");
ALTER TABLE
    "Sale_item" ADD CONSTRAINT "sale_item_item_foreign" FOREIGN KEY("item") REFERENCES "Item"("item_id");
ALTER TABLE
    "Item" ADD CONSTRAINT "item_item_id_foreign" FOREIGN KEY("item_id") REFERENCES "Item_price"("item");
ALTER TABLE
    "Record" ADD CONSTRAINT "record_company_foreign" FOREIGN KEY("company") REFERENCES "Company"("name");
ALTER TABLE
    "Client" ADD CONSTRAINT "client_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "User"("id");
ALTER TABLE
    "Record_label" ADD CONSTRAINT "record_label_name_foreign" FOREIGN KEY("Name") REFERENCES "Artist"("record_label");
ALTER TABLE
    "Sale" ADD CONSTRAINT "sale_user_foreign" FOREIGN KEY("user") REFERENCES "User"("id");