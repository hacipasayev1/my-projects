insert into users(username,password,enabled)
values
('admin','{bcrypt}$2a$12$yDxXrlKbz1uXZN6qdjF40.u6eYyZy4UsbzRx2aFltFb22nsafSzSq',1),
('cashier','{bcrypt}$2a$12$upiX/s6YDyx.iyITyaiG2O62RWpc1Tn7AX6iFWG1XLBt2xX7LmUWu',1);

insert into authorities(username,authority)
values
('admin','for:admin'),
('cashier','for:cashier');