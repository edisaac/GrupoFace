--Crear usuario **
CREATE ROLE quyuser LOGIN
ENCRYPTED PASSWORD 'quypass'
NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE;
--Crear base de datos**
CREATE DATABASE quybd  
WITH OWNER = quyuser  ENCODING = 'UTF8';
--Darle todos los permisos a Quyuser sobre quy app
GRANT ALL PRIVILEGES ON DATABASE quybd  to quyuser;
