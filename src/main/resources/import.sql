--
-- Copyright (C) 2011 Earle Nietzel <earle.nietzel@gmail.com>
--
-- This file is part of SVFC57.
--
-- SVFC57 is free software: you can redistribute it and/or modify
-- it under the terms of the GNU General Public License as published by
-- the Free Software Foundation, either version 3 of the License, or
-- (at your option) any later version.
--
-- SVFC57 is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
-- GNU General Public License for more details.
--
-- You should have received a copy of the GNU General Public License
-- along with SVFC57.  If not, see <http://www.gnu.org/licenses/>.
--

-- ===================== DO NOT EDIT ANYTHING BELOW THIS LINE =====================
-- Add admin user
insert into USER (USERNAME, PASSWORD, ENABLED, ACCOUNTNONLOCKED, ACCOUNTNONEXPIRED, CREDENTIALSNONEXPIRED) values ('admin', '3f0149558bb3967a270a5014507f1911399b283f', true, true, true, true);
-- Add default permissions
insert into Permission (NAME) values ('PERM_UPDT_ANNOUNCEMENT');
insert into Permission (NAME) values ('PERM_VIEW_ANNOUNCEMENT');
insert into Permission (NAME) values ('PERM_ADD_ANNOUNCEMENT');
insert into Permission (NAME) values ('PERM_UPDT_PERSON');
insert into Permission (NAME) values ('PERM_ADD_PERSON');
insert into Permission (NAME) values ('PERM_VIEW_PERSON');
insert into Permission (NAME) values ('PERM_UPDT_USER');
insert into Permission (NAME) values ('PERM_ADD_USER');
insert into Permission (NAME) values ('PERM_VIEW_USER');
-- Add default roles 
insert into Role (NAME) values ('ROLE_ADMIN');
-- Associate default permissions with a role
insert into ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) values (select PERMISSION_ID from Permission where NAME='PERM_UPDT_ANNOUNCEMENT', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
insert into ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) values (select PERMISSION_ID from Permission where NAME='PERM_VIEW_ANNOUNCEMENT', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
insert into ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) values (select PERMISSION_ID from Permission where NAME='PERM_ADD_ANNOUNCEMENT', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
insert into ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) values (select PERMISSION_ID from Permission where NAME='PERM_UPDT_PERSON', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
insert into ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) values (select PERMISSION_ID from Permission where NAME='PERM_VIEW_PERSON', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
insert into ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) values (select PERMISSION_ID from Permission where NAME='PERM_ADD_PERSON', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
insert into ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) values (select PERMISSION_ID from Permission where NAME='PERM_UPDT_USER', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
insert into ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) values (select PERMISSION_ID from Permission where NAME='PERM_VIEW_USER', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
insert into ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) values (select PERMISSION_ID from Permission where NAME='PERM_ADD_USER', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
-- Associate admin user with ROLE_ADMIN
insert into USER_ROLE (USER_ID, ROLE_ID) values (select USER_ID from USER where USERNAME = 'admin', select ROLE_ID from Role where NAME = 'ROLE_ADMIN');
-- ===================== DO NOT EDIT ANYTHING ABOVE THIS LINE =====================

-- ===================== EDIT BELOW THIS LINE =====================
insert into Person (city, email, firstName, lastName, phone, state, streetOne, zip) values ( 'Wallkill', 'earle.nietzel@gmail.com', 'Earle', 'Nietzel', '845-866-1957', 'NY', '1233 Hoagerburgh Rd', '12589');
