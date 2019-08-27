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
-- Create schema resi
--

CREATE DATABASE IF NOT EXISTS resi;
USE resi;

--
-- Definition of table `building`
--

DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo7ef7b0cu39uyj7e8gtxjmbvb` (`thana_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `building`
--

/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` (`id`,`address`,`name`,`thana_id`) VALUES 
 (1,'54 Gandaria ','Owner B 1',1),
 (2,'54 Mirpur','Owner B 2',2),
 (3,'2 No Satmosgid Road','Owner D B',3);
/*!40000 ALTER TABLE `building` ENABLE KEYS */;


--
-- Definition of table `building_owner`
--

DROP TABLE IF EXISTS `building_owner`;
CREATE TABLE `building_owner` (
  `building_id` bigint(20) NOT NULL,
  `owner_id` bigint(20) NOT NULL,
  PRIMARY KEY (`building_id`,`owner_id`),
  KEY `FKj3c3a6q5fwe6pwd81folahod6` (`owner_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `building_owner`
--

/*!40000 ALTER TABLE `building_owner` DISABLE KEYS */;
INSERT INTO `building_owner` (`building_id`,`owner_id`) VALUES 
 (1,5),
 (2,6),
 (3,7);
/*!40000 ALTER TABLE `building_owner` ENABLE KEYS */;


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
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city_corporation`
--

/*!40000 ALTER TABLE `city_corporation` DISABLE KEYS */;
INSERT INTO `city_corporation` (`id`,`name`,`notes`,`district_id`) VALUES 
 (1,'Dhaka South City',NULL,1),
 (2,'Dhaka North City',NULL,1),
 (3,'Chattogram City',NULL,2);
/*!40000 ALTER TABLE `city_corporation` ENABLE KEYS */;


--
-- Definition of table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bn_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`id`,`bn_name`,`name`) VALUES 
 (1,NULL,'Bangladesh');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


--
-- Definition of table `district`
--

DROP TABLE IF EXISTS `district`;
CREATE TABLE `district` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bn_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `division_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK78g8m793eebrogjuuey668ihu` (`division_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` (`id`,`bn_name`,`name`,`division_id`) VALUES 
 (1,NULL,'Dhaka',1),
 (2,NULL,'Chattogram',2);
/*!40000 ALTER TABLE `district` ENABLE KEYS */;


--
-- Definition of table `division`
--

DROP TABLE IF EXISTS `division`;
CREATE TABLE `division` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bn_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrjici6pk7j0mjom8a1xga0jsg` (`country_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `division`
--

/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` (`id`,`bn_name`,`name`,`country_id`) VALUES 
 (1,NULL,'Dhaka',1),
 (2,NULL,'Chattogram',1);
/*!40000 ALTER TABLE `division` ENABLE KEYS */;


--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(255) DEFAULT NULL,
  `denigration` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid_no` varchar(255) DEFAULT NULL,
  `salary` double NOT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK15af427j279hfm3chpb8cqi8e` (`owner_id`),
  KEY `FKhvmrplj0c8g0dyhfbhai1gp14` (`tenant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`,`contract_no`,`denigration`,`education`,`gender`,`name`,`nid_no`,`salary`,`owner_id`,`tenant_id`) VALUES 
 (1,'01612345621','Coock','SSC','Male','T 1 Employee','895623',1200,NULL,1),
 (2,'01612345651','Driver','HSC','Male','Owner E 1','4578',15000,5,NULL),
 (3,'016123456712','Coock','HSC','Male','Owner E 2','5784521',5000,6,NULL),
 (4,'0164512378','Coock','HSC','Male','O D E 1','895623',5000,7,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


--
-- Definition of table `family_mamber`
--

DROP TABLE IF EXISTS `family_mamber`;
CREATE TABLE `family_mamber` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `contract_no` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid_no` varchar(255) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp93mfiefm3epfk83x1gla9awm` (`owner_id`),
  KEY `FKqfcl0gwgq31qunbcb1wolpcix` (`tenant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `family_mamber`
--

/*!40000 ALTER TABLE `family_mamber` DISABLE KEYS */;
INSERT INTO `family_mamber` (`id`,`age`,`contract_no`,`education`,`gender`,`name`,`nid_no`,`owner_id`,`tenant_id`) VALUES 
 (1,25,'01612345611','HSC','Male','T 1 Member','562389',NULL,1),
 (2,25,'01612345642','Graduate','Male','Owner M 1','895623',5,NULL),
 (3,5623,'016123456711','SSC','Male','Owner M 2','895623',6,NULL),
 (4,25,'01612345622','SSC','Male','O D 1','568923',7,NULL);
/*!40000 ALTER TABLE `family_mamber` ENABLE KEYS */;


--
-- Definition of table `flat`
--

DROP TABLE IF EXISTS `flat`;
CREATE TABLE `flat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `rent_amount` double DEFAULT NULL,
  `rent_date` date DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `building_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcuvibqssnlnlcvkphbl35qud1` (`building_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flat`
--

/*!40000 ALTER TABLE `flat` DISABLE KEYS */;
INSERT INTO `flat` (`id`,`name`,`note`,`photo`,`rent_amount`,`rent_date`,`status`,`building_id`) VALUES 
 (1,'O 1 A101',NULL,'/images/new-flat1.jpg',5000,'2019-09-01',0x01,1),
 (2,'O 1 A102',NULL,'/images/new-flat2.jpg',6000,'2019-09-01',0x01,1),
 (3,'M A101',NULL,'/images/new-flat3.jpg',5000,'2019-09-01',0x01,2),
 (4,'O M102',NULL,'/images/new-flat4a.jpg',4000,'2019-09-01',0x00,2),
 (5,'D A101',NULL,'/images/new-flatDA.jpg',5000,'2019-09-01',0x01,3);
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
 (1,5),
 (2,5),
 (3,6),
 (4,6),
 (5,7);
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
  `income` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid_no` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `tin_no` varchar(255) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd2m8fahm7hrykrfjb628x7973` (`thana_id`),
  KEY `FKhpbnjn4ipu3a94qaxrdlogbnn` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `house_owner`
--

/*!40000 ALTER TABLE `house_owner` DISABLE KEYS */;
INSERT INTO `house_owner` (`id`,`contract_no`,`date_of_birth`,`education`,`gender`,`income`,`name`,`nid_no`,`photo`,`tin_no`,`thana_id`,`user_id`) VALUES 
 (7,'01612345673','1985-08-26','Graduate','Male',60000,'Owner D 1','985623','/images/new-owner3.jfif','895623',3,16),
 (8,'01612345674','2019-08-26','','',0,'','','','',NULL,17),
 (6,'01612345672','1975-08-26','HSC','Male',70000,'Owner M 1','895623','/images/new-owner2.jfif','5623',2,15),
 (5,'01612345671','1956-08-26','Graduate','Male',50000,'Owner G 1','895623','/images/new-owner1.jfif','4512',1,14);
/*!40000 ALTER TABLE `house_owner` ENABLE KEYS */;


--
-- Definition of table `house_rent`
--

DROP TABLE IF EXISTS `house_rent`;
CREATE TABLE `house_rent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `advance_amount` double DEFAULT NULL,
  `currentdate` date DEFAULT NULL,
  `rent_amount` double DEFAULT NULL,
  `rent_type` varchar(255) NOT NULL,
  `rentcondition` varchar(255) DEFAULT NULL,
  `rentdate` date DEFAULT NULL,
  `building_id` bigint(20) DEFAULT NULL,
  `flat_id` bigint(20) DEFAULT NULL,
  `house_owner_id` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpvaemi1ubc1bo3lgobo6qjuvj` (`building_id`),
  KEY `FKm90k3awepp2lsjiojdy8pwww3` (`flat_id`),
  KEY `FKr9x4j07pr54filbiqtvvt41v3` (`house_owner_id`),
  KEY `FKi5y6byoll6ufhw7pntfllfsrp` (`tenant_id`),
  KEY `FKb9mnhpng077uimij2u3m24t32` (`thana_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `house_rent`
--

/*!40000 ALTER TABLE `house_rent` DISABLE KEYS */;
INSERT INTO `house_rent` (`id`,`advance_amount`,`currentdate`,`rent_amount`,`rent_type`,`rentcondition`,`rentdate`,`building_id`,`flat_id`,`house_owner_id`,`tenant_id`,`thana_id`) VALUES 
 (1,50000,'2019-08-26',5000,'Family',NULL,NULL,1,1,NULL,1,1),
 (3,40000,'2019-08-26',4000,'Commercial',NULL,'2019-09-01',2,3,NULL,NULL,2),
 (4,40000,'2019-08-26',4000,'Commercial',NULL,'2019-09-01',2,3,NULL,NULL,2),
 (5,40000,'2019-08-26',4000,'Commercial',NULL,'2019-09-01',2,3,NULL,NULL,2),
 (6,30000,'2019-08-26',3000,'Family',NULL,'2019-09-01',2,4,NULL,3,2),
 (7,50000,'2019-08-26',5000,'Family_Sub_late',NULL,'2019-09-01',3,5,NULL,4,3),
 (8,50000,'2019-08-26',50000,'Family',NULL,'2019-09-01',1,4,5,4,1);
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
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `police`
--

/*!40000 ALTER TABLE `police` DISABLE KEYS */;
INSERT INTO `police` (`id`,`batch_id`,`contract_no`,`date_of_birth`,`gender`,`name`,`nid`,`photo`,`post`,`thana_id`,`user_id`) VALUES 
 (1,'895623','01612345691','0178-08-26','Male','Police G 1','5237','/images/new-police1.jfif','ASP',1,8),
 (2,'85623','01612345692','1988-08-26','Male','Police M 1','895647','/images/new-police2.jfif','Inspector',2,9),
 (3,'784596','01612345693','1975-08-26','Female','Police D 1','785623','/images/new-police3.jfif','SI',3,10),
 (4,'895623','01612345694','1976-08-26','Male','Police W 1','85623','/images/new-police4.jfif','Inspector',4,11),
 (5,'89562',' 01612345695','1985-08-26','Male','Police 2 G','784512','/images/new-pic2.jfif','Inspector',1,18);
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
 (1,'HOUSEOWNER'),
 (2,'TENANT'),
 (3,'POLICE');
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
  `income` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid_no` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `tin_no` varchar(255) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpfkiq1sn2e0rrx7ruwpcwy0uf` (`thana_id`),
  KEY `FKmoj8m61gtmcdo59nh0574w7q1` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tenant`
--

/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` (`id`,`contract_no`,`date_of_birth`,`education`,`gender`,`income`,`name`,`nid_no`,`photo`,`tin_no`,`thana_id`,`user_id`) VALUES 
 (1,'01612345681','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant1.jfif','8895623',1,4),
 (3,'01612345684','1975-08-26','Graduate','Male',15000,'Tenant W 1','895623','/images/new-tenant4.jfif','562389',4,7),
 (4,'01612345682','1988-08-26','SSC','Male',20000,'Tenant M 1','85623','/images/new-tenant2.jfif','56289',2,12),
 (5,'01612345683','1968-08-26','HSC','Male',30000,'Tenant D 1','895675','/images/new-tenant3.jfif','895623',3,13);
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
 (1,'Gandaria',NULL,1),
 (2,'Mirpur',NULL,2),
 (3,'Dhanmondi',NULL,2),
 (4,'Wari',NULL,1);
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
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_589idila9li6a4arw1t8ht1gx` (`phone`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`password`,`phone`,`user_name`) VALUES 
 (14,'$2a$10$wv73vNtm33QiTJo5GL2WheN4FGy.NUln99GyeZo1Jkg8mwSS9oY3e','01612345671','owner1'),
 (4,'$2a$10$whnwtdizwCITAlC0ecTTJOlLsrMTFxQlBg1YSewmGGTNz2H4DnfVq','01612345681','tenant1'),
 (12,'$2a$10$lE1cOmgsXzot/QKkmIWgv.m44fUqF3omxpLGU5bPyluiw5r3lHLcq','01612345682','tenant2'),
 (13,'$2a$10$FgtnUciCFexrNzInI.hwnep2S1XONnjnfoJAlVYbQvYvraYVwYSd6','01612345683','tenant3'),
 (7,'$2a$10$34hn4kQgiCF2H5NVlWcmRedWzi5liilKLCHYFb7aHCOkHnKjC3Tuq','01612345684','tenant4'),
 (8,'$2a$10$Ptesy.NqpnX7pMAoZmKuVe9tlVlritkyDBzIA2mE0z5UZ9L8Whmiu','01612345691','police1'),
 (9,'$2a$10$0YQzjeWgxT.doNfvh5/Um.DEbvSNI.z0tt0fV1lwFJ.d8FCWkSV12','01612345692','police2'),
 (10,'$2a$10$uxt4OZlmKWmxpP0uexzq7OlrlVu4isyqA9jfXrJI/4atMJOULjMwa','01612345693','police3'),
 (11,'$2a$10$IC.xjQ7ioVSbao74w.MYQO21TTbjbDUsyhp7e5ZRlIUo/A7HM./2i','01612345694','police4'),
 (15,'$2a$10$OkfgA4KhqSjNvVG0oKPt0uJjxD4FJ2Ftea4tIArHkaMAUJFoIJrWe','01612345672','owner2'),
 (16,'$2a$10$/5JqbyTmS45OyJ0IFjW/texHoupGOfVBBGjFunRfjH1e580bx4DIi','01612345673','owner3'),
 (17,'$2a$10$9qBwmGJpmPqJD8UB3iRQCOc5iEsnkBc0XOCKJKhq8.ytKw2XLItp6','01612345674','owner4'),
 (18,'$2a$10$NOazmByhJTeMKcH.ksIHvevsXmMn2N72PdhUbEi7OSVaFp1GKOLHe',' 01612345695','police5');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`user_id`,`role_id`) VALUES 
 (1,1),
 (2,1),
 (3,1),
 (4,2),
 (5,2),
 (6,2),
 (7,2),
 (8,3),
 (9,3),
 (10,3),
 (11,3),
 (12,2),
 (13,2),
 (14,1),
 (15,1),
 (16,1),
 (17,1),
 (18,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
