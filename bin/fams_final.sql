/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : fams

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-07-14 12:01:40
*/
CREATE DATABASE  IF NOT EXISTS `fams` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fams`;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(45) DEFAULT NULL,
  `admin_password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1,'yjh','123456'),(2,'grb','dfdgdf'),(3,'emt','dsfsf');

-- ----------------------------
-- Table structure for `assets_in`
-- ----------------------------
DROP TABLE IF EXISTS `assets_in`;
CREATE TABLE `assets_in` (
  `assets_in_id` int(11) NOT NULL AUTO_INCREMENT,
  `assets_id` int(10) unsigned NOT NULL,
  `assets_in_admin` int(11) NOT NULL,
  `assets_in_user` int(11) NOT NULL,
  `assets_in_date` date DEFAULT NULL,
  `assets_in_remark` text,
  PRIMARY KEY (`assets_in_id`,`assets_id`,`assets_in_admin`,`assets_in_user`),
  KEY `fk_assets_in_fixed_assets1_idx` (`assets_id`),
  KEY `fk_assets_in_admin1_idx` (`assets_in_admin`),
  KEY `fk_assets_in_user1_idx` (`assets_in_user`),
  CONSTRAINT `fk_assets_in_admin1` FOREIGN KEY (`assets_in_admin`) REFERENCES `admin` (`admin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_assets_in_fixed_assets1` FOREIGN KEY (`assets_id`) REFERENCES `fixed_assets` (`assets_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_assets_in_user1` FOREIGN KEY (`assets_in_user`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assets_in
-- ----------------------------
INSERT INTO `assets_in` VALUES (13,1,1,1,'2016-07-14',NULL),(14,2,1,2,NULL,NULL);

-- ----------------------------
-- Table structure for `assets_out`
-- ----------------------------
DROP TABLE IF EXISTS `assets_out`;
CREATE TABLE `assets_out` (
  `assets_out_id` int(11) NOT NULL AUTO_INCREMENT,
  `assets_id` int(10) unsigned NOT NULL,
  `assets_out_admin` int(11) NOT NULL,
  `assets_out_user` int(11) NOT NULL,
  `assets_out_date` date DEFAULT NULL,
  `assets_out_purpose` varchar(100) DEFAULT NULL,
  `assets_out_remark` text,
  PRIMARY KEY (`assets_out_id`,`assets_id`,`assets_out_admin`,`assets_out_user`),
  KEY `fk_assets_out_fixed_assets_idx` (`assets_id`),
  KEY `fk_assets_out_admin1_idx` (`assets_out_admin`),
  KEY `fk_assets_out_user1_idx` (`assets_out_user`),
  CONSTRAINT `fk_assets_out_admin1` FOREIGN KEY (`assets_out_admin`) REFERENCES `admin` (`admin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_assets_out_fixed_assets` FOREIGN KEY (`assets_id`) REFERENCES `fixed_assets` (`assets_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_assets_out_user1` FOREIGN KEY (`assets_out_user`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assets_out
-- ----------------------------
INSERT INTO `assets_out` VALUES (2,1,1,1,'2016-07-14',NULL,NULL),(3,2,1,2,'2016-07-14',NULL,NULL),(4,3,1,1,'2016-07-14',NULL,NULL),(5,4,1,2,'2016-07-14',NULL,NULL);


-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1,'办公外设'),(2,'数码产品'),(3,'计算机');

-- ----------------------------
-- Table structure for `fixed_assets`
-- ----------------------------
DROP TABLE IF EXISTS `fixed_assets`;
CREATE TABLE `fixed_assets` (
  `assets_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `assets_name` varchar(45) DEFAULT NULL,
  `assets_catagory` int(11) NOT NULL,
  `assets_model` varchar(100) DEFAULT NULL,
  `assets_value` int(11) DEFAULT NULL,
  `assets_purchase_date` date DEFAULT NULL,
  `assets_state` tinyint(4) DEFAULT '0',
  `assets_user` int(11) DEFAULT NULL,
  `assets_remark` text,
  PRIMARY KEY (`assets_id`,`assets_catagory`),
  KEY `fk_fixed_assets_sub_class1_idx` (`assets_catagory`),
  CONSTRAINT `fk_fixed_assets_sub_class1` FOREIGN KEY (`assets_catagory`) REFERENCES `sub_class` (`sub_class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fixed_assets
-- ----------------------------
INSERT INTO `fixed_assets` VALUES (1,'传真机1',1,'sdfsdf',100,'2016-07-13',0,NULL,NULL),(2,'传真机2',1,'werwr',200,'2016-07-13',0,NULL,NULL),(3,'笔记本1',6,'reytj',3000,'2016-07-13',0,1,NULL),(4,'笔记本2',6,'sdfsdvc',5000,'2016-07-13',0,2,NULL),(5,'相机1',4,'cvxvc',1000,'2016-07-13',0,NULL,NULL),(6,'服务器1',8,'cxvxsdf',50000,'2016-07-13',0,NULL,NULL);


-- ----------------------------
-- Table structure for `sub_class`
-- ----------------------------
DROP TABLE IF EXISTS `sub_class`;
CREATE TABLE `sub_class` (
  `sub_class_id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_class_name` varchar(45) DEFAULT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`sub_class_id`,`class_id`),
  KEY `fk_sub_class_class1_idx` (`class_id`),
  CONSTRAINT `fk_sub_class_class1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sub_class
-- ----------------------------
INSERT INTO `sub_class` VALUES (1,'传真机',1),(2,'复印机',1),(3,'打印机',1),(4,'数码相机',2),(5,'投影仪',2),(6,'笔记本电脑',3),(7,'台式机',3),(8,'服务器',3);


-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `user_job` varchar(45) DEFAULT NULL,
  `user_remark` text,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1,'a','CEO',NULL),(2,'b','CTO',NULL);

-- ----------------------------
-- View structure for `fixed_assets_view`
-- ----------------------------
DROP VIEW IF EXISTS `fixed_assets_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fixed_assets_view` AS select `a`.`assets_id` AS `assets_id`,`a`.`assets_name` AS `assets_name`,`a`.`class_name` AS `assets_class`,`a`.`sub_class_name` AS `assets_sub_class`,`a`.`assets_model` AS `assets_model`,`a`.`assets_value` AS `assets_value`,`a`.`assets_purchase_date` AS `assets_purchase_date`,`a`.`assets_state` AS `assets_state`,`a`.`assets_user` AS `assets_user_id`,`fams`.`user`.`user_name` AS `assets_user_name`,`a`.`assets_remark` AS `assets_remark` from (((select `fams`.`fixed_assets`.`assets_id` AS `assets_id`,`fams`.`fixed_assets`.`assets_name` AS `assets_name`,`fams`.`class`.`class_name` AS `class_name`,`fams`.`sub_class`.`sub_class_name` AS `sub_class_name`,`fams`.`fixed_assets`.`assets_model` AS `assets_model`,`fams`.`fixed_assets`.`assets_value` AS `assets_value`,`fams`.`fixed_assets`.`assets_purchase_date` AS `assets_purchase_date`,`fams`.`fixed_assets`.`assets_state` AS `assets_state`,`fams`.`fixed_assets`.`assets_user` AS `assets_user`,`fams`.`fixed_assets`.`assets_remark` AS `assets_remark` from ((`fams`.`fixed_assets` join `fams`.`sub_class`) join `fams`.`class`) where ((`fams`.`fixed_assets`.`assets_catagory` = `fams`.`sub_class`.`sub_class_id`) and (`fams`.`sub_class`.`class_id` = `fams`.`class`.`class_id`)))) `a` left join `fams`.`user` on((`fams`.`user`.`user_id` = `a`.`assets_user`))) ;
DROP TRIGGER IF EXISTS `assets_in_insert_trigger`;
DELIMITER ;;
CREATE TRIGGER `assets_in_insert_trigger` AFTER INSERT ON `assets_in` FOR EACH ROW BEGIN
update fixed_assets set assets_user=NULL where assets_id=new.assets_id;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `assets_out_insert_trigger`;
DELIMITER ;;
CREATE TRIGGER `assets_out_insert_trigger` AFTER INSERT ON `assets_out` FOR EACH ROW BEGIN
update fixed_assets set assets_user=new.assets_out_user where assets_id=new.assets_id;
end
;;
DELIMITER ;
