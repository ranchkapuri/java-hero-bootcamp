drop database if exists pizza_restaurant;
create database pizza_restaurant;

drop table IF EXISTS pizza_restaurant.ItemOrdered;
drop table IF EXISTS pizza_restaurant.Ordered;
drop table IF EXISTS pizza_restaurant.Customers;
drop table IF EXISTS pizza_restaurant.Pizza;

use pizza_restaurant;

create table pizza_restaurant.Customers (
customer_id int not null,
first_name varchar(50) not null,
last_name varchar (50) not null,
phone_number varchar(15),
PRIMARY KEY (`customer_id`)
);

create table pizza_restaurant.Pizza (
pizza_id int not null,
pizza_type varchar(100),
pizza_price decimal(6,2),
PRIMARY KEY (`pizza_id`)
);

create table pizza_restaurant.Ordered (
order_id int not null,
customer_id int not null,
order_date date,
PRIMARY KEY (`order_id`),
foreign key (`customer_id`) references customers (`customer_id`)
);

create table pizza_restaurant.ItemOrdered (
order_id int not null,
item_no int not null,
pizza_id int not null,
amount int not null,
PRIMARY KEY (`pizza_id`,`item_no`),
foreign key (`order_id`) references Ordered  (`order_id`),
foreign key (`pizza_id`) references Pizza  (`pizza_id`)
);





insert into pizza_restaurant.Customers (customer_id,first_name,last_name,phone_number) values(1,'ervis','todi','123-354-1111');
insert into pizza_restaurant.Customers (customer_id,first_name,last_name,phone_number) values(2,'maxim','qoku','123-354-2222');
insert into pizza_restaurant.Customers (customer_id,first_name,last_name,phone_number) values(3,'sokol','gjermeni','123-354-3333');
insert into pizza_restaurant.Customers (customer_id,first_name,last_name,phone_number) values(4,'adela','gjeka','123-354-4444');


insert into pizza_restaurant.Pizza (pizza_id,pizza_type,pizza_price) values(1,'Pepperoni & Cheese',7.99);
insert into pizza_restaurant.Pizza (pizza_id,pizza_type,pizza_price) values(2,'Vegetarian',9.99);
insert into pizza_restaurant.Pizza (pizza_id,pizza_type,pizza_price) values(3,'Meat Lovers',14.99);
insert into pizza_restaurant.Pizza (pizza_id,pizza_type,pizza_price) values(4,'Hawaiian',12.99);


insert into pizza_restaurant.Ordered (order_id,customer_id,order_date) values(1,1,'2021-03-01');
insert into pizza_restaurant.Ordered (order_id,customer_id,order_date) values(2,1,'2021-03-01');
insert into pizza_restaurant.Ordered (order_id,customer_id,order_date) values(3,1,'2021-04-10');
insert into pizza_restaurant.Ordered (order_id,customer_id,order_date) values(4,2,'2021-04-10');


insert into pizza_restaurant.ItemOrdered (order_id,item_no,pizza_id,amount) values(1,111,1,2);
insert into pizza_restaurant.ItemOrdered (order_id,item_no,pizza_id,amount) values(2,222,2,1);
insert into pizza_restaurant.ItemOrdered (order_id,item_no,pizza_id,amount) values(3,333,4,3);
insert into pizza_restaurant.ItemOrdered (order_id,item_no,pizza_id,amount) values(3,444,3,1);
insert into pizza_restaurant.ItemOrdered (order_id,item_no,pizza_id,amount) values(3,555,2,2);
insert into pizza_restaurant.ItemOrdered (order_id,item_no,pizza_id,amount) values(4,666,1,2);
insert into pizza_restaurant.ItemOrdered (order_id,item_no,pizza_id,amount) values(4,777,3,1);


Select "Pizza Order:",ord.order_id,itmord.amount,pzz.pizza_type
from pizza_restaurant.Customers cust 
join pizza_restaurant.Ordered ord
on cust.customer_id=ord.customer_id
join pizza_restaurant.ItemOrdered itmord
on itmord.order_id=ord.order_id
join Pizza pzz
on pzz.pizza_id=itmord.pizza_id
order by 1;



/**

-- This query joins all tables and select everything


select *
from pizza_restaurant.Customers cust 
join pizza_restaurant.Ordered ord
on cust.customer_id=ord.customer_id
join pizza_restaurant.ItemOrdered itmord
on itmord.order_id=ord.order_id
join Pizza pzz
on pzz.pizza_id=itmord.pizza_id
order by 1;


-- This query goups by customers ID and sumerizes the pizza price for each customer

select cust.customer_id,sum(pizza_price)
from pizza_restaurant.Customers cust 
join pizza_restaurant.Ordered ord
on cust.customer_id=ord.customer_id
join pizza_restaurant.ItemOrdered itmord
on itmord.order_id=ord.order_id
join Pizza pzz
on pzz.pizza_id=itmord.pizza_id
group by cust.customer_id
order by 1;


--This query goups by customers ID and DATE and sumerizes the pizza price for each customer

select cust.customer_id,sum(pizza_price)
from pizza_restaurant.Customers cust 
join pizza_restaurant.Ordered ord
on cust.customer_id=ord.customer_id
join pizza_restaurant.ItemOrdered itmord
on itmord.order_id=ord.order_id
join Pizza pzz
on pzz.pizza_id=itmord.pizza_id
group by cust.customer_id,ord.order_date
order by 1;

**/

