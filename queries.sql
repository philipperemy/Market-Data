create database marketdata;

use marketdata;

CREATE TABLE `market_data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `SYMBOL` VARCHAR(45) NOT NULL,
  `PRICE` VARCHAR(45) NOT NULL,
  `TIMESTAMP` DATETIME NOT NULL,
  PRIMARY KEY (`ID`));
