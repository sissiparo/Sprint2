SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `testdb` DEFAULT CHARACTER SET utf8 ;
USE `testdb` ;

-- -----------------------------------------------------
-- Table `testdb`.`AccessCapability`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`AccessCapability` (
  `accessID` INT(11) NOT NULL AUTO_INCREMENT,
  `accessCapability` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`accessID`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`Manufacturer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`Manufacturer` (
  `manufacturerID` INT(11) NOT NULL AUTO_INCREMENT,
  `manufacturerName` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`manufacturerID`))
ENGINE = InnoDB
AUTO_INCREMENT = 73
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`UEModel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`UEModel` (
  `modelId` INT(11) NOT NULL AUTO_INCREMENT,
  `modelName` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`modelId`))
ENGINE = InnoDB
AUTO_INCREMENT = 92
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`UserEquipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`UserEquipment` (
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
    REFERENCES `testdb`.`UEModel` (`modelId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`EventCause`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`EventCause` (
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
CREATE TABLE IF NOT EXISTS `testdb`.`Country` (
  `mcc` INT(11) NOT NULL,
  `countryName` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`mcc`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`MCCMNC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`MCCMNC` (
  `mccmncID` INT(11) NOT NULL AUTO_INCREMENT,
  `mnc` INT(11) NOT NULL,
  `operator` VARCHAR(255) NULL DEFAULT NULL,
  `mcc` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`mccmncID`),
  INDEX `FK8734EE353380F5F8` (`mcc` ASC),
  CONSTRAINT `FK8734EE353380F5F8`
    FOREIGN KEY (`mcc`)
    REFERENCES `testdb`.`Country` (`mcc`))
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`Failure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`Failure` (
  `failureID` INT(11) NOT NULL,
  `failureDescription` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`failureID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`CellTable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`CellTable` (
  `cellID` INT(11) NOT NULL,
  `hier321_ID` VARCHAR(255) NULL DEFAULT NULL,
  `hier32_ID` VARCHAR(255) NULL DEFAULT NULL,
  `hier3_ID` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`cellID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`BaseData`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`BaseData` (
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
    REFERENCES `testdb`.`UserEquipment` (`tac`),
  CONSTRAINT `FK9D36FE3B368ED464`
    FOREIGN KEY (`eventCauseID`)
    REFERENCES `testdb`.`EventCause` (`eventcauseCode`),
  CONSTRAINT `FK9D36FE3BC1D768B0`
    FOREIGN KEY (`mccmncID`)
    REFERENCES `testdb`.`MCCMNC` (`mccmncID`),
  CONSTRAINT `FK9D36FE3BEAC24228`
    FOREIGN KEY (`failureClassID`)
    REFERENCES `testdb`.`Failure` (`failureID`),
  CONSTRAINT `FK9D36FE3BF862D1E`
    FOREIGN KEY (`cellID`)
    REFERENCES `testdb`.`CellTable` (`cellID`))
ENGINE = InnoDB
AUTO_INCREMENT = 801
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`UE_Accesscapability`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`UE_AccessCapability` (
  `accessCapabilityID` INT(11) NOT NULL,
  `userEquipID` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`accessCapabilityID`, `userEquipID`),
  INDEX `FK4EDFB34B19297BFE` (`accessCapabilityID` ASC),
  CONSTRAINT `FK4EDFB34B19297BFE`
    FOREIGN KEY (`accessCapabilityID`)
    REFERENCES `testdb`.`AccessCapability` (`accessID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testdb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`User` (
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
