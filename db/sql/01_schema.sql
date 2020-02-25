CREATE DATABASE greatnamedb DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
GRANT ALL PRIVILEGES ON greatnamedb.* TO 'root'@'%' WITH GRANT OPTION;

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

USE `greatnamedb`;

DROP TABLE IF EXISTS "sample";
DROP SEQUENCE IF EXISTS sample_id_seq;
CREATE SEQUENCE sample_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE "public"."sample" (
    "id" integer DEFAULT nextval('sample_id_seq') NOT NULL,
    "name" character varying(100) NOT NULL,
    CONSTRAINT "sample_pkey" PRIMARY KEY ("id")
) WITH (oids = false);