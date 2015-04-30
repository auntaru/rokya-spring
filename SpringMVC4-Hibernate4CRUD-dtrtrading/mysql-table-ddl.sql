create database dtrtrading;


CREATE TABLE `strategy` (
    `ID` INT(6) UNSIGNED NOT NULL AUTO_INCREMENT,
    `TYPE` VARCHAR(20) NOT NULL,
    `NAME` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`ID`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=8;

