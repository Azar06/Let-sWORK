/*
DROP DATABASE "LetsWorkDB";
DROP ROLE "LetsWorkAdmin";
*/

-- Role: LetsWorkAdmin

CREATE ROLE "LetsWorkAdmin" LOGIN
  ENCRYPTED PASSWORD 'md5c522856f0ba2e6c9b1a33df03fad6809'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

-- Database: "LetsWorkDB"

CREATE DATABASE "LetsWorkDB"
  WITH OWNER = "LetsWorkAdmin"
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1;
