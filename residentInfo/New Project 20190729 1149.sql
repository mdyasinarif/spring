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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `builliding`
--

/*!40000 ALTER TABLE `builliding` DISABLE KEYS */;
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city_corporation`
--

/*!40000 ALTER TABLE `city_corporation` DISABLE KEYS */;
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

/*!40000 ALTER TABLE `country` DISABLE KEYS */;
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

/*!40000 ALTER TABLE `district` DISABLE KEYS */;
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `division`
--

/*!40000 ALTER TABLE `division` DISABLE KEYS */;
/*!40000 ALTER TABLE `division` ENABLE KEYS */;


--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(255) DEFAULT NULL,
  `denigration` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid_no` varchar(255) DEFAULT NULL,
  `salary` double NOT NULL,
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flat`
--

/*!40000 ALTER TABLE `flat` DISABLE KEYS */;
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
  `no_of_employe` int(11) NOT NULL,
  `no_of_mamber` int(11) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `tin_no` varchar(255) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd2m8fahm7hrykrfjb628x7973` (`thana_id`),
  KEY `FKhpbnjn4ipu3a94qaxrdlogbnn` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `house_owner`
--

/*!40000 ALTER TABLE `house_owner` DISABLE KEYS */;
INSERT INTO `house_owner` (`id`,`contract_no`,`date_of_birth`,`education`,`gender`,`income`,`name`,`nid_no`,`no_of_employe`,`no_of_mamber`,`photo`,`tin_no`,`thana_id`,`user_id`) VALUES 
 (1,'01686239188','2019-08-02','','',0,'','',0,0,'','',NULL,1),
 (2,'01676555764','2019-08-02','','',0,'','',0,0,'','',NULL,4);
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `house_rent`
--

/*!40000 ALTER TABLE `house_rent` DISABLE KEYS */;
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
 (1,'','01686239149','2019-08-02','','','','','',NULL,2);
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
 (2,'POLICE'),
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
  `no_of_employe` int(11) NOT NULL,
  `no_of_mamber` int(11) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `tin_no` varchar(255) DEFAULT NULL,
  `thana_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpfkiq1sn2e0rrx7ruwpcwy0uf` (`thana_id`),
  KEY `FKmoj8m61gtmcdo59nh0574w7q1` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tenant`
--

/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` (`id`,`contract_no`,`date_of_birth`,`education`,`gender`,`income`,`name`,`nid_no`,`no_of_employe`,`no_of_mamber`,`photo`,`tin_no`,`thana_id`,`user_id`) VALUES 
 (1,'01686239170','2019-08-02','','',0,'','',0,0,'','',NULL,3);
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `thana`
--

/*!40000 ALTER TABLE `thana` DISABLE KEYS */;
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
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`password`,`phone`,`user_name`) VALUES 
 (1,'$2a$10$uVtqkoA0jvFPLykenObruuov5a5QFpfbQwwOmfFUspTi5gtBi/1T2','01686239188','minhaz'),
 (2,'$2a$10$ADJ0ufmQuAWdeMihf/aAZ./qHjlku78Pd27vZ1uAq42WdTyaOcDoq','01686239149','sami'),
 (3,'$2a$10$7il5QQ7RSQRDan/4S.DKzOzM2/ujBruaBi/8/QHtEhhH3VF0KpX0.','01686239170','yasin'),
 (4,'$2a$10$JdNw8H7s75Wt1.SwaBI6R.VLlrKWIN7CcI5xATBlJL/gFqvn1FCXq','01676555764','arif');
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
 (2,2),
 (3,3),
 (4,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
