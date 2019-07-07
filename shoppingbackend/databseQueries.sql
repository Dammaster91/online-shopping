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

