CREATE TABLE IF NOT EXISTS products
(
    id serial,
    product_name varchar(255) NOT NULL,
    country varchar(255),
    manufacturer varchar(255),
    online_order boolean,
    installment boolean,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS models
(
    id serial,
    model_name varchar(255) NOT NULL,
    serial_number varchar(255),
    color varchar(50),
    size varchar(50),
    price double_precision,
    in_stock boolean,
    product_id bigint,
    CONSTRAINT pk_models PRIMARY KEY (id),
    CONSTRAINT fk_product_id_models FOREIGN KEY (product_id) REFERENCES products (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT uq_serial_number UNIQUE (serial_number)
);

CREATE TABLE IF NOT EXISTS smartphones
(
    id serial,
    memory bigint,
    cameras bigint,
    model_id bigint,
    CONSTRAINT pk_smartphones PRIMARY KEY (id),
    CONSTRAINT fk_model_id_smartphones FOREIGN KEY (model_id) REFERENCES models (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS computers
(
    id serial,
    category varchar(50),
    processor_type varchar(50),
    model_id bigint,
    CONSTRAINT pk_computers PRIMARY KEY (id),
    CONSTRAINT fk_model_id_computers FOREIGN KEY (model_id) REFERENCES models (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS tvs
(
    id serial,
    category varchar(50),
    technology varchar(50),
    model_id bigint,
    CONSTRAINT pk_tvs PRIMARY KEY (id),
    CONSTRAINT fk_model_id_tvs FOREIGN KEY (model_id) REFERENCES models (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS vacuum_cleaners
(
    id serial,
    dust_collector_volume double_precision,
    modes int,
    model_id bigint,
    CONSTRAINT pk_vacuum_cleaners PRIMARY KEY (id),
    CONSTRAINT fk_model_id_vacuum_cleaners FOREIGN KEY (model_id) REFERENCES models (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS refrigerators
(
    id serial,
    door_count bigint,
    compressor_type varchar(50),
    model_id bigint,
    CONSTRAINT pk_refrigerators PRIMARY KEY (id),
    CONSTRAINT fk_model_id_refrigerators FOREIGN KEY (model_id) REFERENCES models (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);