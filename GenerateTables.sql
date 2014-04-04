SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `testdb` DEFAULT CHARACTER SET utf8 ;
USE `testdb` ;

-- -----------------------------------------------------
-- Table `testdb`.`accesscapability`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`accesscapability` (
  `accessID` INT(11) NOT NULL AUTO_INCREMENT,
  `accessCapability` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`accessID`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`manufacturer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`manufacturer` (
  `manufacturerID` INT(11) NOT NULL AUTO_INCREMENT,
  `manufacturerName` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`manufacturerID`))
ENGINE = InnoDB
AUTO_INCREMENT = 73
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`uemodel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`uemodel` (
  `modelId` INT(11) NOT NULL AUTO_INCREMENT,
  `modelName` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`modelId`))
ENGINE = InnoDB
AUTO_INCREMENT = 92
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`userequipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`userequipment` (
  `tac` VARCHAR(255) NOT NULL,
  `ueInputMode` VARCHAR(255) NULL DEFAULT NULL,
  `ueOperatingSys` VARCHAR(255) NULL DEFAULT NULL,
  `ueType` VARCHAR(255) NULL DEFAULT NULL,
  `ueManufacturerId` INT(11) NULL DEFAULT NULL,
  `ueModelId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`tac`),
  INDEX `FKE4D75DE37CC93B58` (`ueManufacturerId` ASC),
  INDEX `FKE4D75DE3AA0FCCE2` (`ueModelId` ASC),
  CONSTRAINT `FKE4D75DE37CC93B58`
    FOREIGN KEY (`ueManufacturerId`)
    REFERENCES `testdb`.`manufacturer` (`manufacturerID`),
  CONSTRAINT `FKE4D75DE3AA0FCCE2`
    FOREIGN KEY (`ueModelId`)
    REFERENCES `testdb`.`uemodel` (`modelId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`eventcause`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`eventcause` (
  `eventcauseCode` INT(11) NOT NULL AUTO_INCREMENT,
  `causeCode` INT(11) NOT NULL,
  `causeDescription` VARCHAR(255) NULL DEFAULT NULL,
  `eventID` INT(11) NOT NULL,
  PRIMARY KEY (`eventcauseCode`))
ENGINE = InnoDB
AUTO_INCREMENT = 81
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`country` (
  `mcc` INT(11) NOT NULL,
  `countryName` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`mcc`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`mccmnc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`mccmnc` (
  `mccmncID` INT(11) NOT NULL AUTO_INCREMENT,
  `mnc` INT(11) NOT NULL,
  `operator` VARCHAR(255) NULL DEFAULT NULL,
  `mcc` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`mccmncID`),
  INDEX `FK8734EE353380F5F8` (`mcc` ASC),
  CONSTRAINT `FK8734EE353380F5F8`
    FOREIGN KEY (`mcc`)
    REFERENCES `testdb`.`country` (`mcc`))
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`failure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`failure` (
  `failureID` INT(11) NOT NULL,
  `failureDescription` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`failureID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`celltable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`celltable` (
  `cellID` INT(11) NOT NULL,
  `hier321_ID` VARCHAR(255) NULL DEFAULT NULL,
  `hier32_ID` VARCHAR(255) NULL DEFAULT NULL,
  `hier3_ID` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`cellID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`basedata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`basedata` (
  `baseDataID` INT(11) NOT NULL AUTO_INCREMENT,
  `baseDate` DATETIME NULL DEFAULT NULL,
  `duration` INT(11) NOT NULL,
  `imsi` VARCHAR(255) NULL DEFAULT NULL,
  `neVersion` VARCHAR(255) NULL DEFAULT NULL,
  `cellID` INT(11) NULL DEFAULT NULL,
  `eventCauseID` INT(11) NULL DEFAULT NULL,
  `failureClassID` INT(11) NULL DEFAULT NULL,
  `mccmncID` INT(11) NULL DEFAULT NULL,
  `TAC` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`baseDataID`),
  INDEX `FK9D36FE3BC1D768B0` (`mccmncID` ASC),
  INDEX `FK9D36FE3BEAC24228` (`failureClassID` ASC),
  INDEX `FK9D36FE3B368ED464` (`eventCauseID` ASC),
  INDEX `FK9D36FE3B135732AE` (`TAC` ASC),
  INDEX `FK9D36FE3BF862D1E` (`cellID` ASC),
  CONSTRAINT `FK9D36FE3B135732AE`
    FOREIGN KEY (`TAC`)
    REFERENCES `testdb`.`userequipment` (`tac`),
  CONSTRAINT `FK9D36FE3B368ED464`
    FOREIGN KEY (`eventCauseID`)
    REFERENCES `testdb`.`eventcause` (`eventcauseCode`),
  CONSTRAINT `FK9D36FE3BC1D768B0`
    FOREIGN KEY (`mccmncID`)
    REFERENCES `testdb`.`mccmnc` (`mccmncID`),
  CONSTRAINT `FK9D36FE3BEAC24228`
    FOREIGN KEY (`failureClassID`)
    REFERENCES `testdb`.`failure` (`failureID`),
  CONSTRAINT `FK9D36FE3BF862D1E`
    FOREIGN KEY (`cellID`)
    REFERENCES `testdb`.`celltable` (`cellID`))
ENGINE = InnoDB
AUTO_INCREMENT = 801
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`ue_accesscapability`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`ue_accesscapability` (
  `accessCapabilityID` INT(11) NOT NULL,
  `userEquipID` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`accessCapabilityID`, `userEquipID`),
  INDEX `FK4EDFB34B19297BFE` (`accessCapabilityID` ASC),
  CONSTRAINT `FK4EDFB34B19297BFE`
    FOREIGN KEY (`accessCapabilityID`)
    REFERENCES `testdb`.`accesscapability` (`accessID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`user` (
  `userID` INT(11) NOT NULL AUTO_INCREMENT,
  `employeeNumber` VARCHAR(255) NULL DEFAULT NULL,
  `firstName` VARCHAR(255) NULL DEFAULT NULL,
  `lastName` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `userName` VARCHAR(255) NULL DEFAULT NULL,
  `userType` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`userID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
