create TABLE orders (
    order_guid                  VARCHAR (36) PRIMARY KEY,
    order_number                VARCHAR (36) NOT NULL,
    order_date                  TIMESTAMP    DEFAULT (CURRENT_TIMESTAMP),
    summa_doc                   DOUBLE,
    agent_name                  VARCHAR (150) NULL,
    order_comment               VARCHAR (150) NULL,
    client_name                 VARCHAR(150)  NULL,
    point_name                  VARCHAR(150)  NULL,
    point_address               VARCHAR(150)  NULL
);


create TABLE orders_detail (
    orders_detail_guid      VARCHAR (36) PRIMARY KEY,
    order_guid              VARCHAR (36) NOT NULL,
    line_number             INT,
    product_guid            VARCHAR (36) NOT NULL,
    product_code            VARCHAR (11),
    product_name            VARCHAR (150) NOT NULL,
    qty                     DOUBLE,
    qty_collected           DOUBLE,
    unit_name               VARCHAR (150) NOT NULL,
    price                   DOUBLE,
    summa                   DOUBLE  DEFAULT (0),
    CONSTRAINT orders_detail_fk_orders FOREIGN KEY (order_guid) REFERENCES orders(order_guid)
);


CREATE TABLE users (
	id                      bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username               VARCHAR(255),
	password                VARCHAR(255),
	role                    VARCHAR(36) NOT NULL,
	enabled                 BOOLEAN DEFAULT false
);

create unique index ix_users_user_name   on users (username);
