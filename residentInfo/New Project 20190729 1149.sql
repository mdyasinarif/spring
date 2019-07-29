-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.44-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema residentinfo
--

CREATE DATABASE IF NOT EXISTS residentinfo;
USE residentinfo;

--
-- Definition of table `builliding`
--

DROP TABLE IF EXISTS `builliding`;
CREATE TABLE `builliding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK73vf1rb00ifs33inn4fusoxld` (`thana_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `builliding`
--

/*!40000 ALTER TABLE `builliding` DISABLE KEYS */;
INSERT INTO `builliding` (`id`,`adress`,`name`,`thana_id`) VALUES 
 (1,'59/5/4 SotisSorkar Road','Yasin Vila',1);
/*!40000 ALTER TABLE `builliding` ENABLE KEYS */;


--
-- Definition of table `builling_owner`
--

DROP TABLE IF EXISTS `builling_owner`;
CREATE TABLE `builling_owner` (
  `builling_id` bigint(20) NOT NULL,
  `owner_id` bigint(20) NOT NULL,
  PRIMARY KEY (`builling_id`,`owner_id`),
  KEY `FKehlurubt6dnibamxtnxreivhe` (`owner_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `builling_owner`
--

/*!40000 ALTER TABLE `builling_owner` DISABLE KEYS */;
INSERT INTO `builling_owner` (`builling_id`,`owner_id`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `builling_owner` ENABLE KEYS */;


--
-- Definition of table `city_corporation`
--

DROP TABLE IF EXISTS `city_corporation`;
CREATE TABLE `city_corporation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `district_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrrhdydqlsxmre3e9a19fwvwk0` (`district_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city_corporation`
--

/*!40000 ALTER TABLE `city_corporation` DISABLE KEYS */;
INSERT INTO `city_corporation` (`id`,`name`,`notes`,`district_id`) VALUES 
 (1,'Dhaka notrh ',NULL,1),
 (2,'Dhaka South',NULL,1),
 (3,'Pakistan',NULL,1),
 (4,'Savar City',NULL,2);
/*!40000 ALTER TABLE `city_corporation` ENABLE KEYS */;


--
-- Definition of table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`id`,`name`,`note`) VALUES 
 (1,'Bangladesh',NULL),
 (2,'India',NULL),
 (5,'UKE',NULL),
 (4,'USA',NULL);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


--
-- Definition of table `district`
--

DROP TABLE IF EXISTS `district`;
CREATE TABLE `district` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `division_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK78g8m793eebrogjuuey668ihu` (`division_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` (`id`,`name`,`division_id`) VALUES 
 (1,'Dhaka',1),
 (2,'Savar',1);
/*!40000 ALTER TABLE `district` ENABLE KEYS */;


--
-- Definition of table `division`
--

DROP TABLE IF EXISTS `division`;
CREATE TABLE `division` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrjici6pk7j0mjom8a1xga0jsg` (`country_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `division`
--

/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` (`id`,`name`,`note`,`country_id`) VALUES 
 (1,'Dhaka',NULL,1),
 (2,'Cummila',NULL,1);
/*!40000 ALTER TABLE `division` ENABLE KEYS */;


--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid_no` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK15af427j279hfm3chpb8cqi8e` (`owner_id`),
  KEY `FKhvmrplj0c8g0dyhfbhai1gp14` (`tenant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


--
-- Definition of table `family_mamber`
--

DROP TABLE IF EXISTS `family_mamber`;
CREATE TABLE `family_mamber` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `contract_no` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid_no` varchar(255) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp93mfiefm3epfk83x1gla9awm` (`owner_id`),
  KEY `FKqfcl0gwgq31qunbcb1wolpcix` (`tenant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `family_mamber`
--

/*!40000 ALTER TABLE `family_mamber` DISABLE KEYS */;
/*!40000 ALTER TABLE `family_mamber` ENABLE KEYS */;


--
-- Definition of table `flat`
--

DROP TABLE IF EXISTS `flat`;
CREATE TABLE `flat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `buillding_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK32plolo4le0jfsnmec90sgd8m` (`buillding_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flat`
--

/*!40000 ALTER TABLE `flat` DISABLE KEYS */;
INSERT INTO `flat` (`id`,`name`,`note`,`buillding_id`) VALUES 
 (1,'101',NULL,1),
 (2,'102',NULL,1),
 (3,'201',NULL,1),
 (4,'202',NULL,1),
 (5,'301',NULL,1),
 (6,'302',NULL,1);
/*!40000 ALTER TABLE `flat` ENABLE KEYS */;


--
-- Definition of table `flat_owner`
--

DROP TABLE IF EXISTS `flat_owner`;
CREATE TABLE `flat_owner` (
  `flat_id` bigint(20) NOT NULL,
  `owner_id` bigint(20) NOT NULL,
  PRIMARY KEY (`flat_id`,`owner_id`),
  KEY `FK3eo5ghmksha2mwnb4i5cjlgfq` (`owner_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flat_owner`
--

/*!40000 ALTER TABLE `flat_owner` DISABLE KEYS */;
INSERT INTO `flat_owner` (`flat_id`,`owner_id`) VALUES 
 (1,1),
 (2,1),
 (3,1),
 (4,1),
 (5,1),
 (6,1);
/*!40000 ALTER TABLE `flat_owner` ENABLE KEYS */;


--
-- Definition of table `house_owner`
--

DROP TABLE IF EXISTS `house_owner`;
CREATE TABLE `house_owner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `income` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid_no` varchar(255) DEFAULT NULL,
  `no_of_employe` int(11) NOT NULL,
  `no_of_mamber` int(11) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `tin_no` varchar(255) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd2m8fahm7hrykrfjb628x7973` (`thana_id`),
  KEY `FKhpbnjn4ipu3a94qaxrdlogbnn` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `house_owner`
--

/*!40000 ALTER TABLE `house_owner` DISABLE KEYS */;
INSERT INTO `house_owner` (`id`,`contract_no`,`date_of_birth`,`education`,`gender`,`income`,`name`,`nid_no`,`no_of_employe`,`no_of_mamber`,`photo`,`tin_no`,`thana_id`,`user_id`) VALUES 
 (1,'01676555765','2019-07-02','Post Graduate','Male','20000','sohan','7894563',4,4,'/images/new-pic1.jpg','123456',1,NULL);
/*!40000 ALTER TABLE `house_owner` ENABLE KEYS */;


--
-- Definition of table `house_rent`
--

DROP TABLE IF EXISTS `house_rent`;
CREATE TABLE `house_rent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currentdate` date DEFAULT NULL,
  `rent_amount` double DEFAULT NULL,
  `rent_type` varchar(255) NOT NULL,
  `rentcondition` varchar(255) DEFAULT NULL,
  `rentdate` date DEFAULT NULL,
  `buillding_id` bigint(20) DEFAULT NULL,
  `flat_id` bigint(20) DEFAULT NULL,
  `house_owner_id` bigint(20) DEFAULT NULL,
  `tena_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKasdbgef91rdvfuflp3e8fkaxo` (`buillding_id`),
  KEY `FKm90k3awepp2lsjiojdy8pwww3` (`flat_id`),
  KEY `FKr9x4j07pr54filbiqtvvt41v3` (`house_owner_id`),
  KEY `FK4hsseer2te20l4q817kw25wlq` (`tena_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `house_rent`
--

/*!40000 ALTER TABLE `house_rent` DISABLE KEYS */;
INSERT INTO `house_rent` (`id`,`currentdate`,`rent_amount`,`rent_type`,`rentcondition`,`rentdate`,`buillding_id`,`flat_id`,`house_owner_id`,`tena_id`) VALUES 
 (1,'2019-07-29',5000,'Family',NULL,'2019-08-01',1,1,1,1);
/*!40000 ALTER TABLE `house_rent` ENABLE KEYS */;


--
-- Definition of table `police`
--

DROP TABLE IF EXISTS `police`;
CREATE TABLE `police` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `batch_id` varchar(255) DEFAULT NULL,
  `contract_no` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa3j1fkcke7ltpdmyvvggoxc6h` (`thana_id`),
  KEY `FKlusag0hf1u7u267xo76u3b9ii` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `police`
--

/*!40000 ALTER TABLE `police` DISABLE KEYS */;
INSERT INTO `police` (`id`,`batch_id`,`contract_no`,`date_of_birth`,`gender`,`name`,`nid`,`photo`,`post`,`thana_id`,`user_id`) VALUES 
 (1,'124','01777809236','2019-07-01','Male','yasinarif','7894461236','/images/new-pic3.jfif','Inspector',1,NULL);
/*!40000 ALTER TABLE `police` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iubw515ff0ugtm28p8g3myt0h` (`role_name`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`,`role_name`) VALUES 
 (1,'Police'),
 (2,'Howse Owne'),
 (3,'Tenant');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
CREATE TABLE `tenant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `income` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid_no` varchar(255) DEFAULT NULL,
  `no_of_employe` int(11) NOT NULL,
  `no_of_mamber` int(11) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `tin_no` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmoj8m61gtmcdo59nh0574w7q1` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tenant`
--

/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` (`id`,`contract_no`,`date_of_birth`,`education`,`gender`,`income`,`name`,`nid_no`,`no_of_employe`,`no_of_mamber`,`photo`,`tin_no`,`user_id`) VALUES 
 (1,'01676555766','2019-07-01','Post Graduate','Male','100000','sohan','789546',4,4,'/images/new-pic3.jfif','789654',NULL);
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;


--
-- Definition of table `thana`
--

DROP TABLE IF EXISTS `thana`;
CREATE TABLE `thana` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `citycorporation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjkcq11nmvwhctlg0m10bu73p1` (`citycorporation_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `thana`
--

/*!40000 ALTER TABLE `thana` DISABLE KEYS */;
INSERT INTO `thana` (`id`,`name`,`note`,`citycorporation_id`) VALUES 
 (1,'Gandara',NULL,1),
 (2,'Wari',NULL,1),
 (3,'Sutrapul',NULL,1),
 (4,'Jatrabari',NULL,1);
/*!40000 ALTER TABLE `thana` ENABLE KEYS */;


--
-- Definition of table `u_nion`
--

DROP TABLE IF EXISTS `u_nion`;
CREATE TABLE `u_nion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK97rchktyhfdxnsu5qudfu6w73` (`thana_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_nion`
--

/*!40000 ALTER TABLE `u_nion` DISABLE KEYS */;
/*!40000 ALTER TABLE `u_nion` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `text` varchar(255) NOT NULL,
  `usertype` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pq03cqtcq12v641gicwv741rs` (`text`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`name`,`password`,`text`,`usertype`) VALUES 
 (5,'sohan','123456','01676555765','houseowner'),
 (4,'yasinarif','123456','01777809236','police');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
