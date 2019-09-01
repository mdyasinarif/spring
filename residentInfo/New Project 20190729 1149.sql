-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.40-log


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
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `building`
--

/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` (`id`,`address`,`name`,`thana_id`) VALUES 
 (1,'11','building1',1),
 (2,'12','building2',2),
 (3,'13','building3',3),
 (4,'14','building4',4),
 (5,'15','building5',5),
 (6,'16','building6',2);
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
 (1,1),
 (2,2),
 (3,3),
 (4,4),
 (5,5),
 (6,2);
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
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city_corporation`
--

/*!40000 ALTER TABLE `city_corporation` DISABLE KEYS */;
INSERT INTO `city_corporation` (`id`,`name`,`notes`,`district_id`) VALUES 
 (1,'Dhaka North City Corporation',NULL,1),
 (2,'Dhaka South City Corporation',NULL,1),
 (3,'Narayanganj City Corporation',NULL,11),
 (4,'Gazipur City Corporation',NULL,3),
 (5,'Chattogram City Corporation',NULL,43),
 (6,'Cumilla City Corporation',NULL,44),
 (7,'Cox\'s bazar City Corporation',NULL,45),
 (8,'Bogura City Corporation',NULL,18),
 (9,'Faridpur City Corporation',NULL,2),
 (10,'Tangail City Corporation',NULL,17),
 (11,'Barishal City Corporation',NULL,35),
 (12,'Khulna City Corporation',NULL,59),
 (13,'Jashore City Corporation',NULL,57),
 (14,'Rangpur City Corporation',NULL,32),
 (15,'Dinajpur City Corporation',NULL,26),
 (16,'Sylhet City Corporation',NULL,54),
 (17,'Mymensingh City Corporation',NULL,10),
 (18,'Rajshahi City Corporation',NULL,24);
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
) ENGINE=MyISAM AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` (`id`,`bn_name`,`name`,`division_id`) VALUES 
 (1,'????','Dhaka',3),
 (2,'???????','Faridpur',3),
 (3,'???????','Gazipur',3),
 (4,'?????????','Gopalganj',3),
 (5,'????????','Jamalpur',8),
 (6,'?????????','Kishoreganj',3),
 (7,'?????????','Madaripur',3),
 (8,'?????????','Manikganj',3),
 (9,'??????????','Munshiganj',3),
 (10,'????????','Mymensingh',8),
 (11,'???????????','Narayanganj',3),
 (12,'???????','Narsingdi',3),
 (13,'?????????','Netrokona',8),
 (14,'???????','Rajbari',3),
 (15,'????????','Shariatpur',3),
 (16,'??????','Sherpur',8),
 (17,'????????','Tangail',3),
 (18,'?????','Bogura',5),
 (19,'????????','Joypurhat',5),
 (20,'?????','Naogaon',5),
 (21,'?????','Natore',5),
 (22,'??????????????','Chapainawabganj',5),
 (23,'?????','Pabna',5),
 (24,'???????','Rajshahi',5),
 (25,'?????????','Sirajgonj',5),
 (26,'????????','Dinajpur',6),
 (27,'?????????','Gaibandha',6),
 (28,'?????????','Kurigram',6),
 (29,'??????????','Lalmonirhat',6),
 (30,'?????????','Nilphamari',6),
 (31,'??????','Panchagarh',6),
 (32,'?????','Rangpur',6),
 (33,'?????????','Thakurgaon',6),
 (34,'??????','Barguna',1),
 (35,'??????','Barishal',1),
 (36,'????','Bhola',1),
 (37,'???????','Jhalokati',1),
 (38,'?????????','Patuakhali',1),
 (39,'????????','Pirojpur',1),
 (40,'?????????','Bandarban',2),
 (41,'??????????????','Brahmanbaria',2),
 (42,'???????','Chandpur',2),
 (43,'?????????','Chattogram',2),
 (44,'????????','Cumilla',2),
 (45,'???? ?????','Cox\'s Bazar',2),
 (46,'????','Feni',2),
 (47,'????????','Khagrachhari',2),
 (48,'??????????','Lakshmipur',2),
 (49,'????????','Noakhali',2),
 (50,'??????????','Rangamati',2),
 (51,'???????','Habiganj',7),
 (52,'??????????','Moulvibazar',7),
 (53,'?????????','Sunamganj',7),
 (54,'?????','Sylhet',7),
 (55,'????????','Bagerhat',4),
 (56,'??????????','Chuadanga',4),
 (57,'????','Jashore',4),
 (58,'???????','Jhenaidah',4),
 (59,'?????','Khulna',4),
 (60,'????????','Kushtia',4),
 (61,'??????','Magura',4),
 (62,'????????','Meherpur',4),
 (63,'?????','Narail',4),
 (64,'?????????','Satkhira',4);
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
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `division`
--

/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` (`id`,`bn_name`,`name`,`country_id`) VALUES 
 (1,'??????','Barishal',1),
 (2,'?????????','Chattogram',1),
 (3,'????','Dhaka',1),
 (4,'?????','Khulna',1),
 (5,'???????','Rajshahi',1),
 (6,'?????','Rangpur',1),
 (7,'?????','Sylhet',1),
 (8,'????????','Mymensingh',1);
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
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flat`
--

/*!40000 ALTER TABLE `flat` DISABLE KEYS */;
INSERT INTO `flat` (`id`,`name`,`note`,`photo`,`rent_amount`,`rent_date`,`status`,`building_id`) VALUES 
 (1,'101',NULL,'/images/new-flat1.jpg',5000,'2019-09-01',0x00,1),
 (2,'102',NULL,'/images/new-flat1.jpg',5000,'2019-09-01',0x00,1),
 (3,'601',NULL,'/images/new-flat1.jpg',5000,'2019-09-01',0x01,6),
 (4,'602',NULL,'/images/new-flat1.jpg',5000,'2019-09-01',0x01,6),
 (5,'201',NULL,'/images/new-flat2.jpg',5000,'2019-09-01',0x01,2),
 (6,'202',NULL,'/images/new-flat2.jpg',5000,'2019-09-01',0x01,2),
 (7,'301',NULL,'/images/new-flat3.jpg',5000,'2019-09-01',0x01,3),
 (8,'302',NULL,'/images/new-flat3.jpg',5000,'2019-09-01',0x01,3),
 (9,'401',NULL,'/images/new-flat4.jpg',5000,'2019-09-01',0x01,4),
 (10,'402',NULL,'/images/new-flat4.jpg',5000,'2019-09-01',0x01,4),
 (11,'501',NULL,'/images/new-flat5.jpg',5000,'2019-09-01',0x01,5),
 (12,'501',NULL,'/images/new-flat5.jpg',5000,'2019-09-01',0x01,5);
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
 (5,2),
 (6,2),
 (7,3),
 (8,3),
 (9,4),
 (10,4),
 (11,5),
 (12,5);
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
 (1,'01612345601','1985-08-26','Graduate','Male',60000,'Owner1','985623','/images/new-owner1.jfif','895623',1,1),
 (2,'01612345602','1985-08-26','Graduate','Male',60000,'Owner2','985623','/images/new-owner2.jfif','895623',2,2),
 (3,'01612345603','1985-08-26','Graduate','Male',60000,'Owner3','985623','/images/new-owner3.jfif','895623',3,3),
 (4,'01612345604','1985-08-26','Graduate','Male',60000,'Owner4','985623','/images/new-owner4.jfif','895623',4,4),
 (5,'01612345605','1985-08-26','Graduate','Male',60000,'Owner5','985623','/images/new-owner5.jfif','895623',5,5);
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
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `house_rent`
--

/*!40000 ALTER TABLE `house_rent` DISABLE KEYS */;
INSERT INTO `house_rent` (`id`,`advance_amount`,`currentdate`,`rent_amount`,`rent_type`,`rentcondition`,`rentdate`,`building_id`,`flat_id`,`house_owner_id`,`tenant_id`,`thana_id`) VALUES 
 (9,50000,'2019-08-29',5000,'Family',NULL,'2019-09-01',1,1,1,1,1),
 (10,600000,'2019-08-29',6000,'Family',NULL,'2019-09-01',1,2,1,2,1);
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
 (1,'585','01612345694','2019-08-29','Male','police1','7845','/images/new-police1.jfif','SI',1,18),
 (2,'586','01612345693','2019-08-29','Male','police2','4578','/images/new-police2.jfif','SI',2,19),
 (3,'579','01612345692','2019-08-29','FeMale','police3','5689','/images/new-police3.jfif','SI',3,20);
/*!40000 ALTER TABLE `police` ENABLE KEYS */;


--
-- Definition of table `rent_collection`
--

DROP TABLE IF EXISTS `rent_collection`;
CREATE TABLE `rent_collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rantmonth` varchar(255) DEFAULT NULL,
  `rent_amount` double DEFAULT NULL,
  `rentdate` date DEFAULT NULL,
  `building_id` bigint(20) DEFAULT NULL,
  `flat_id` bigint(20) DEFAULT NULL,
  `house_owner_id` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKv3p7bpfy4ix1sl4asexrf4k5` (`building_id`),
  KEY `FKc0hjqytat18rr0uadgmcr0cpq` (`flat_id`),
  KEY `FKqm5mihfn9ql6ty92fhpym6f6v` (`house_owner_id`),
  KEY `FKsbrcxkemln56p43r0cagrushg` (`tenant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rent_collection`
--

/*!40000 ALTER TABLE `rent_collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `rent_collection` ENABLE KEYS */;


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
 (1,'POLICE'),
 (2,'HOUSEOWNER'),
 (3,'TENANT');
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
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tenant`
--

/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` (`id`,`contract_no`,`date_of_birth`,`education`,`gender`,`income`,`name`,`nid_no`,`photo`,`tin_no`,`thana_id`,`user_id`) VALUES 
 (1,'01612345681','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant1.jfif','8895623',1,6),
 (2,'01612345682','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant2.jfif','8895623',1,7),
 (3,'01612345683','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant3.jfif','8895623',2,8),
 (4,'01612345684','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant4.jfif','8895623',2,9),
 (5,'01612345685','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant5.jfif','8895623',3,10),
 (6,'01612345686','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant6.jfif','8895623',3,11),
 (7,'01612345687','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant7.jfif','8895623',4,12),
 (8,'01612345688','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant8.jfif','8895623',4,13),
 (9,'01612345689','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant9.jfif','8895623',5,14),
 (10,'01612345680','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant10.jfif','8895623',5,15),
 (11,'01612345611','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant11.jfif','8895623',6,16),
 (12,'01612345612','1985-08-26','Graduate','Male',17000,'Tenant G 1','785623','/images/new-tenant12.jfif','8895623',6,17);
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
) ENGINE=MyISAM AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `thana`
--

/*!40000 ALTER TABLE `thana` DISABLE KEYS */;
INSERT INTO `thana` (`id`,`name`,`note`,`citycorporation_id`) VALUES 
 (1,'Adabor',NULL,1),
 (2,'Uttar Khan',NULL,1),
 (3,'Uttara',NULL,1),
 (4,'Kafrul',NULL,1),
 (5,'Cantonment',NULL,1),
 (6,'Khilkhet',NULL,1),
 (7,'Gulshan',NULL,1),
 (8,'Turag',NULL,1),
 (9,'Tejgaon',NULL,1),
 (10,'Dakshinkhan',NULL,1),
 (11,'Darus Salam',NULL,1),
 (12,'Pallabi',NULL,1),
 (13,'Badda',NULL,1),
 (14,'Rampura',NULL,1),
 (15,'Shah Ali',NULL,1),
 (16,'Sher-e-Bangla Nagar',NULL,1),
 (17,'Darus Salam',NULL,1),
 (18,'Darus Salam',NULL,1),
 (19,'Kadamtali',NULL,2),
 (20,'Kalabagan',NULL,2),
 (21,'Kamrangirc',NULL,2),
 (22,'Kotwali',NULL,2),
 (23,'Khilgaon',NULL,2),
 (24,'Gendaria',NULL,2),
 (25,'Chawkbazar',NULL,2),
 (26,'Demra',NULL,2),
 (27,'Dhanmondi',NULL,2),
 (28,'New Market',NULL,2),
 (29,'Paltan',NULL,2),
 (30,'Bangshal',NULL,2),
 (31,'Bimanbanda',NULL,1),
 (32,'Motijheel',NULL,2),
 (33,'Mirpur Mod',NULL,1),
 (34,'Mohammadpu',NULL,1),
 (35,'Jatrabari',NULL,2),
 (36,'Ramna',NULL,2),
 (37,'Lalbagh',NULL,2),
 (38,'Shahbagh',NULL,2),
 (39,'Shyampur',NULL,2),
 (40,'Sabujbagh',NULL,2),
 (41,'Sutrapur',NULL,2),
 (42,'Hazaribagh',NULL,2);
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
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`password`,`phone`,`user_name`) VALUES 
 (1,'$2a$10$kwPR45QABj9ZfwaXiKs9cO9u0erskI7PtRDj.MYMyLpqT/DpOQLh6','01612345601','Owner1'),
 (2,'$2a$10$McXAVL0lSQfOYlO/bbrMW.mj7LwXAfnAVfs64r9kiNEwbhxlI9BRe','01612345602','Owner2'),
 (3,'$2a$10$ssEz62Qyb1sZgWV6tdl8JeUhgPFer0dpIK2b1ekCj2AWOAnbHKJO2','01612345603','Owner3'),
 (4,'$2a$10$1/mZ.fF2mkrK4c5SGSlWFOR.VUq1lMLI/SFd0n18clTbSFtEADrem','01612345604','Owner4'),
 (5,'$2a$10$c6kNXpPH7LesyyzFtBlRKehG1xr58emLu56g06Qd9kGyMAiLosa/y','01612345605','Owner5'),
 (6,'$2a$10$FEluiJPfNRkuy78Yic2Zdu0xYOgBu/Y5bBaaelpcDsrjViVeA5r5W','01612345681','tenant1'),
 (7,'$2a$10$egcZ1q07T7ua0O0Xi5XNjupkyJA3jR8b.SkmGGFjNciMV5PBRwODG','01612345682','tenant2'),
 (8,'$2a$10$IfIziNGDW42XwWJ3L07vzOrg2MKhPM0WIUzNsF7tAQiltvu4W3UBO','01612345683','tenant3'),
 (9,'$2a$10$6LN71twOPZbeEcj188OeseRYA96oU.o9.lEM6VkdT6TkVqfTPs49O','01612345684','tenant4'),
 (10,'$2a$10$KZ1RQHIWVzaZ3sJ8ejwqau0TOsSJsEClLhWlv6hlOr..l9kk3iDKW','01612345685','tenant5'),
 (11,'$2a$10$uUQnb4N3.mEAb2gVNerfsuvENX5YOcUlSY8MtG90dimHqB4jXl942','01612345686','tenant6'),
 (12,'$2a$10$tta7T3Qt1epFmSvEPdy6PONBoZDSrP8kduzA4imNdnNPw9FKM.Kty','01612345687','tenant7'),
 (13,'$2a$10$paN9NmyIM9FW1XD0bkAQOOMUJMK3aHB3MRmLHGD4JQFp9n5b74R5i','01612345688','tenant8'),
 (14,'$2a$10$MEXCYTXNTJh2W/jbW4RtSeyPS0Dz.daOXbnl7yrXieX.y3hrmaB5W','01612345689','tenant9'),
 (15,'$2a$10$bhRoARK7UsnIJ8BsuyDxruCUNk32RqUx/WQiHP6xBhfk3d7Tr7nVK','01612345680','tenant10'),
 (16,'$2a$10$7qrA9ilrtdtRE0waTovT3OitsjO03gJyTMIkUjs1/OADzb.uujocm','01612345611','tenant11'),
 (17,'$2a$10$E0HbDyGPcyx7Sh2NHJoSfOWuHmBmM1G5nRzCTN4YGuegVjBU1Dlxy','01612345612','tenant12'),
 (18,'$2a$10$EqX5Ob6fRUupLNs3xcKaDex8e3ubblAGhRj9BCreKoOs7bgTGJ/W.','01612345694','police1'),
 (19,'$2a$10$2V7uMvfspfAb.sMRpSoCVuiQwRj.GkKgXcFIi6mVpfGFiWCZSTaQS','01612345693','police2'),
 (20,'$2a$10$oT17dYLodI9.Ba6yOmu9h.siC1LsbvMhpKSgEBZKx.wE7a7ljyTcK','01612345692','police3');
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
 (1,2),
 (2,2),
 (3,2),
 (4,2),
 (5,2),
 (6,3),
 (7,3),
 (8,3),
 (9,3),
 (10,3),
 (11,3),
 (12,3),
 (13,3),
 (14,3),
 (15,3),
 (16,3),
 (17,3),
 (18,1),
 (19,1),
 (20,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
