create TABLE products (
    product_guid            VARCHAR (36)  NOT NULL PRIMARY KEY,
    product_name            VARCHAR (150) NOT NULL,
    product_code            VARCHAR (11),
    weight                  BOOLEAN DEFAULT (0),
    base_unit_name          VARCHAR (150) NOT NULL
);


create TABLE orders (
    order_guid                  VARCHAR (36) PRIMARY KEY,
    order_number                BIGINT       NOT NULL,
    order_date                  TIMESTAMP    DEFAULT (CURRENT_TIMESTAMP),
    summa_doc                   DOUBLE,
    agent_name                  VARCHAR (150) NULL,
    order_comment               VARCHAR (150) NULL
);


create TABLE orders_detail (
    orders_detail_guid      VARCHAR (36) PRIMARY KEY,
    order_guid              VARCHAR (36) NOT NULL,
    line_number             INT,
    product_guid            VARCHAR (36) NOT NULL,
    qty                     DOUBLE,
    qty_collected           DOUBLE,
    price                   DOUBLE,
    summa                   DOUBLE       DEFAULT (0),
    CONSTRAINT orders_detail_fk_orders FOREIGN KEY (order_guid) REFERENCES orders(order_guid),
    CONSTRAINT orders_detail_fk_productss FOREIGN KEY (product_guid) REFERENCES products(product_guid)
);


CREATE TABLE users (
	id                      bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username               VARCHAR(255),
	password                VARCHAR(255),
	role                    VARCHAR(36) NOT NULL,
	enabled                 BOOLEAN DEFAULT false
);

create unique index ix_users_user_name   on users (username);


INSERT INTO users (username, password, role)
VALUES ('admin', '$2a$10$5qBqaBeWBCgn61.C1A7MtejTofjljRTMsLs5NhG55cQ2sSeGIZA0u', 'ROLE_ADMIN');
