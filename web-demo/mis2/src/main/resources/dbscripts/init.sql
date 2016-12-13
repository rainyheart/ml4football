insert into user(username,password) values('admin','admin');

insert into role (role_name, role_desc) values ('normal user', 'normal user');
insert into role (role_name, role_desc) values ('admin', 'admin user');
insert into role (role_name, role_desc) values ('super', 'super admin user');
commit;