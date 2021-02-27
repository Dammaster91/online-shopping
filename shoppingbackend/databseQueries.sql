create table category(
id serial,
name varchar(50),
description varchar(255),
image_url varchar(50),
active boolean,
constraint pk_category_id primary key(id)

);

alter table category add column active boolean

INSERT INTO category( id,name, description, image_url, active)
    VALUES ( 2,'Television','This is Description about TV', 'tv.png', true);
    
INSERT INTO category( id,name, description, image_url, active)
    VALUES (3, 'Mobile','This is Description about Mobile', 'mobile.png', true); 
    
 -------------------------------   
create table user_details(
id serial,
first_name varchar(50),
last_name varchar(50),
role varchar(50),
enabled boolean,
password varchar(50),
email varchar(50),
contact_number varchar(50)
constraint pk_user_id primary key(id)

);


INSERT INTO user_details(
             first_name, last_name, role, enabled, password, email,contact_number)
    VALUES ('sandeep','dhamal', 'admin', true,'123' ,'dhamalsandeep91@gmail.com','956158177');

    INSERT INTO user_details(
             first_name, last_name, role, enabled, password, email,contact_number)
    VALUES ('amit','dhamal', 'SUPPLIER', true,'123' ,'dhamalsandeep91@gmail.com','956158177');

INSERT INTO user_details(
             first_name, last_name, role, enabled, password, email,contact_number)
    VALUES ('sachin','dhamal', 'SUPPLIER', true,'123' ,'dhamalsandeep91@gmail.com','956158177');
    
    -----------------------------
    create table product(
id serial,
code varchar(50),
name varchar(50),
brand varchar(50),
description varchar(50),
unit_price numeric(10,2),
quantity integer,
is_active boolean,
category_id integer,
supplier_id integer,
purchases  integer default 0,
views  integer default 0,
constraint pk_product_id primary key(id),
constraint pk_product_category_id foreign key(category_id) references category(id),
constraint pk_product_supplier_id foreign key(supplier_id) references user_details(id),

);

INSERT INTO product(
             code, name, brand, description, unit_price, quantity, is_active, 
            category_id, supplier_id, purchases, views)
    VALUES ( 'PRDABC123DEFX','iphone 5s','apple','best', 30000, 2,true, 
            3, 2, 0, 0);


            
   --------------------------
   -- Table: address

-- DROP TABLE address;

	

CREATE TABLE address
(
  id serial NOT NULL,
  user_id integer,
  address_line_one character varying(50),
  address_line_two character varying(50),
  city character varying(50),
  state character varying(50),
  country character varying(50),
  postal_code character varying(50),
  shipping boolean,
  billing boolean,
  CONSTRAINT fk_address_user_id FOREIGN KEY (user_id) REFERENCES user_details(id),
  CONSTRAINT pk_address_id  PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_details
  OWNER TO postgres;

  -------------------------------
  
  
  
  create table cart(
id serial,
user_id integer,
grand_total numeric,
cart_lines integer,
constraint pk_cart_user_id FOREIGN KEY (user_id) REFERENCES user_details(id)
constraint pk_cart_id primary key(id)

);
---------------------------------------------

-- Table: cart

-- DROP TABLE cart;

CREATE TABLE cart
(
  id serial NOT NULL,
  uid integer,
  grand_total numeric,
  cart_lines integer,
  CONSTRAINT pk_cart_id PRIMARY KEY (id),
  CONSTRAINT pk_cart_user_id FOREIGN KEY (uid)
      REFERENCES user_details (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cart
  OWNER TO postgres;


-----------------------------------------

-- Table: address

-- DROP TABLE address;

CREATE TABLE address
(
  id serial NOT NULL,
  user_id integer,
  address_line_one character varying(50),
  address_line_two character varying(50),
  city character varying(50),
  state character varying(50),
  country character varying(50),
  postal_code character varying(50),
  shipping boolean,
  billing boolean,
  CONSTRAINT pk_address_id PRIMARY KEY (id),
  CONSTRAINT fk_address_user_id FOREIGN KEY (user_id)
      REFERENCES user_details (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE address
  OWNER TO postgres;
----------------
-- Table: product

-- DROP TABLE product;

CREATE TABLE product
(
  id serial NOT NULL,
  code character varying(50),
  name character varying(50),
  brand character varying(50),
  description character varying(50),
  unit_price numeric(10,2),
  quantity integer,
  is_active boolean,
  category_id integer,
  supplier_id integer,
  purchases integer DEFAULT 0,
  views integer DEFAULT 0,
  CONSTRAINT pk_product_id PRIMARY KEY (id),
  CONSTRAINT pk_product_category_id FOREIGN KEY (category_id)
      REFERENCES category (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT pk_product_supplier_id FOREIGN KEY (supplier_id)
      REFERENCES user_details (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE product
  OWNER TO postgres;
-------------------
-- Table: user_details

-- DROP TABLE user_details;

CREATE TABLE user_details
(
  id serial NOT NULL,
  first_name character varying(50),
  last_name character varying(50),
  role character varying(50),
  enabled boolean,
  password character varying(70),
  email character varying(50),
  contact_number character varying(50),
  CONSTRAINT pk_user_id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_details
  OWNER TO postgres;
  
  
  
  
  CREATE TABLE cart_line
(
  id serial NOT NULL,
  cart_id integer,
  total numeric,
  product_id integer,
  product_count integer,
  buying_price numeric,
  is_available boolean,
 CONSTRAINT fk_cartline_cart_id FOREIGN KEY (cart_id) REFERENCES cart(id),
 CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES product(id),
CONSTRAINT pk_cartline_id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_details
  OWNER TO postgres;

