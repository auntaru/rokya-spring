create database dtrtradingsecurity default character set 'utf8'
  default collate 'utf8_general_ci';

use dtrtradingsecurity;

drop table if exists user_roles;
drop table if exists role_permissions;
drop table if exists users;
drop table if exists roles;
drop table if exists permissions;


create table users (
    id int(6) not null auto_increment,
    username varchar(50) not null,
    password varchar(50) not null,
    enabled  tinyint(1)  not null,
    primary key (id),
    unique index username (username)
) collate='utf8_general_ci' engine=innodb auto_increment=1;

create table roles (
    id        int(6) not null auto_increment,
    rolename  varchar(50) not null,
    primary key (id),
    unique index rolename (rolename)
) collate='utf8_general_ci' engine=innodb auto_increment=1;

create table user_roles (
    user_id int(6) not null,
    role_id int(6) not null,
    key user (user_id),
    key role (role_id),
    constraint user foreign key (user_id) references users (id) on delete cascade on update cascade,
    constraint role foreign key (role_id) references roles (id) on delete cascade on update cascade
) collate='utf8_general_ci' engine=innodb;

create table permissions (
    id int(6) not null auto_increment,
    permissionname varchar(50) not null,
    primary key(id),
    unique index permissionname (permissionname)
) collate='utf8_general_ci' engine=innodb auto_increment=1;

create table role_permissions (
    role_id       int(6) not null,
    permission_id int(6) not null,
    foreign key (role_id) references roles (id) on delete cascade on update cascade,
    foreign key (permission_id) references permissions (id) on delete cascade on update cascade
) collate='utf8_general_ci' engine=innodb;





use dtrtradingsecurity;

DROP PROCEDURE IF EXISTS createPermission;
DROP PROCEDURE IF EXISTS createRole;
DROP PROCEDURE IF EXISTS createRoleHasPermission;
DROP PROCEDURE IF EXISTS createUser;
DROP PROCEDURE IF EXISTS createUserHasRole;
 
delimiter //

create procedure createPermission($name varchar(50))
begin
    insert into permissions (permissionname) values ($name);
end //

create procedure createRole($name varchar(50), out $id int)
begin
    insert into roles (rolename) values ($name);
    set $id := last_insert_id();
end //
 
create procedure createRoleHasPermission($role_id smallint, $perm_name varchar(50))
begin
    declare _perm_id int;
    select id from permissions where permissionname = $perm_name into _perm_id;
    insert into role_permissions (role_id, permission_id) values ($role_id, _perm_id);
end //
 
create procedure createUserEntry($name varchar(50), out $id int)
begin
    insert into users (username, password, enabled) values ($name, 'password', 1);
    set $id := last_insert_id();
end //
 
create procedure createUserHasRole($user_id int, $role_id smallint)
begin
    insert into user_roles (user_id, role_id) values ($user_id, $role_id);
end //
 
delimiter ;




USE dtrtradingsecurity;

-- Create permissions

call createPermission('CTRL_STRATEGY_LIST_GET');
call createPermission('CTRL_STRATEGY_ADD_POST');
call createPermission('CTRL_STRATEGY_EDIT_GET');
call createPermission('CTRL_STRATEGY_EDIT_POST');
call createPermission('CTRL_STRATEGY_DELETE_GET');


-- Create roles

call createRole('ROLE_ADMIN', @role_admin);
call createRoleHasPermission(@role_admin, 'CTRL_STRATEGY_LIST_GET');
call createRoleHasPermission(@role_admin, 'CTRL_STRATEGY_ADD_POST');
call createRoleHasPermission(@role_admin, 'CTRL_STRATEGY_EDIT_GET');
call createRoleHasPermission(@role_admin, 'CTRL_STRATEGY_EDIT_POST');
call createRoleHasPermission(@role_admin, 'CTRL_STRATEGY_DELETE_GET');

call createRole('ROLE_TRADER', @role_trader);

call createRole('ROLE_USER', @role_user);


-- Create accounts

call createUserEntry('admin', @admin);
call createUserHasRole(@admin, @role_admin);

call createUserEntry('trader', @trader);
call createUserHasRole(@trader, @role_trader);

call createUserEntry('user', @user);
call createUserHasRole(@user, @role_user);

