SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema users_database
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `users_database` ;

-- -----------------------------------------------------
-- Schema users_database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `users_database` ;
USE `users_database` ;

-- -----------------------------------------------------
-- Table `users_database`.`hotel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users_database`.`hotel` ;

CREATE TABLE IF NOT EXISTS `users_database`.`hotel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `url` VARCHAR(45) NULL,
  `categoryName` VARCHAR(45) NULL,
  `latitude` DECIMAL(8,6) NULL,
  `longitude` DECIMAL(9,6) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `users_database`.`room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users_database`.`room` ;

CREATE TABLE IF NOT EXISTS `users_database`.`room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `roomtype` SMALLINT NULL DEFAULT 0,
  `number` INT NULL,
  `smoke` TINYINT(1) NULL DEFAULT 0,
  `type` VARCHAR(45) NULL,
  `hotel_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_room_hotel1_idx` (`hotel_id` ASC),
  CONSTRAINT `fk_room_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `users_database`.`hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `users_database`.`booking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users_database`.`booking` ;

CREATE TABLE IF NOT EXISTS `users_database`.`booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hotel_id` INT NOT NULL,
  `check_in` DATE NOT NULL,
  `check_out` DATE NOT NULL,
  `total_cost` DECIMAL(8,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `users_database`.`rooms_booked`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users_database`.`rooms_booked` ;

CREATE TABLE IF NOT EXISTS `users_database`.`rooms_booked` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `booking_id` INT NOT NULL,
  `room_id` INT NOT NULL,
  `booking_id1` INT NOT NULL,
  `room_id1` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rooms_booked_booking1_idx` (`booking_id1` ASC),
  INDEX `fk_rooms_booked_room1_idx` (`room_id1` ASC),
  CONSTRAINT `fk_rooms_booked_booking1`
    FOREIGN KEY (`booking_id1`)
    REFERENCES `users_database`.`booking` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rooms_booked_room1`
    FOREIGN KEY (`room_id1`)
    REFERENCES `users_database`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;