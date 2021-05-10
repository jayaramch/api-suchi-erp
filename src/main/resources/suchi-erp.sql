/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.19-log : Database - suchi-erp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `menus_tbl` */

CREATE TABLE `menus_tbl` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_description` varchar(255) DEFAULT NULL,
  `menu_image_name` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_seq_no` int(11) NOT NULL,
  `menu_source` varchar(255) DEFAULT NULL,
  `menu_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `menus_tbl` */

LOCK TABLES `menus_tbl` WRITE;

insert  into `menus_tbl`(`menu_id`,`menu_description`,`menu_image_name`,`menu_name`,`menu_seq_no`,`menu_source`,`menu_type`) values (1,'Dashboard',NULL,'Dashboard',1,'dashboard',NULL),(2,'Users',NULL,'Users',2,'users',NULL);

UNLOCK TABLES;

/*Table structure for table `role_menus_tbl` */

CREATE TABLE `role_menus_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqcnfdv8w09052aq1xfwtjm7vp` (`menu_id`),
  KEY `FKduja20oepxticravc2yiy8g4h` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role_menus_tbl` */

LOCK TABLES `role_menus_tbl` WRITE;

insert  into `role_menus_tbl`(`id`,`menu_id`,`role_id`) values (1,1,1),(2,2,1),(3,1,2);

UNLOCK TABLES;

/*Table structure for table `role_tbl` */

CREATE TABLE `role_tbl` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role_tbl` */

LOCK TABLES `role_tbl` WRITE;

insert  into `role_tbl`(`role_id`,`role_name`) values (1,'SUPER ADMIN'),(2,'ADMIN'),(3,'EMPLOYEE');

UNLOCK TABLES;

/*Table structure for table `user_roles_tbl` */

CREATE TABLE `user_roles_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb4qiprh2m26tx3sm82dqnmo5j` (`role_id`),
  KEY `FKaub3lhr5txkgfu3npprtr76f` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_roles_tbl` */

LOCK TABLES `user_roles_tbl` WRITE;

insert  into `user_roles_tbl`(`id`,`role_id`,`user_id`) values (1,1,1),(2,2,2),(3,3,3);

UNLOCK TABLES;

/*Table structure for table `user_tbl` */

CREATE TABLE `user_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_tbl` */

LOCK TABLES `user_tbl` WRITE;

insert  into `user_tbl`(`id`,`email`,`password`,`user_name`) values (1,'superadmin@gmail.com','superadmin','superadmin'),(2,'admin@gmail.com','admin','admin'),(3,'employee@gmail.com','employee','employee');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
