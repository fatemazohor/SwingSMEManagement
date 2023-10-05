CREATE DATABASE  IF NOT EXISTS `smemanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `smemanagement`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: smemanagement
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `batch`
--

DROP TABLE IF EXISTS `batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batch` (
  `batch_id` int NOT NULL AUTO_INCREMENT,
  `class` int DEFAULT NULL,
  `teacher_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`batch_id`),
  CONSTRAINT `id` FOREIGN KEY (`batch_id`) REFERENCES `demo_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch`
--

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` VALUES (1,10,'Lion Raihan');
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `idcustomers` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `cell` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  PRIMARY KEY (`idcustomers`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Ahmed','012536','Dhaka','Kakrail','2023-09-25'),(2,'Oni','0125698574','Chittagong','Hali Town','2023-10-03');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_entry1`
--

DROP TABLE IF EXISTS `data_entry1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data_entry1` (
  `iddata_entry1` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddata_entry1`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_entry1`
--

LOCK TABLES `data_entry1` WRITE;
/*!40000 ALTER TABLE `data_entry1` DISABLE KEYS */;
INSERT INTO `data_entry1` VALUES (5,'Yamin','Dhanmondi','Java','Male'),(6,'Opera','Banani','Mysql','Female'),(7,'Halim','Shankar','[HTML , Mysql ]','Male'),(8,'self','Dhanmondi',' ','Male'),(9,'dr','Dhanmondi',' ','Female'),(10,'Arif','Dhanmondi','JavaMysql','Male'),(11,'Alim rayhan','Banani','HTML ,Mysql ','Male'),(12,'yamin','Shankar','Mysql ,No subject selected','Female'),(13,'Uman','Dhanmondi','Mysql ','Female'),(14,'Opu','Lalbag','Mysql ','Male');
/*!40000 ALTER TABLE `data_entry1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_charge`
--

DROP TABLE IF EXISTS `delivery_charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_charge` (
  `delivery_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(45) DEFAULT NULL,
  `delivery_code` varchar(45) DEFAULT NULL,
  `delivery_chargecol` float DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `delivery_address` varchar(45) DEFAULT NULL,
  `delivery_company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`delivery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_charge`
--

LOCK TABLES `delivery_charge` WRITE;
/*!40000 ALTER TABLE `delivery_charge` DISABLE KEYS */;
INSERT INTO `delivery_charge` VALUES (1,'2','de0410cId2r8',30,'2023-10-04','2023-10-07','haha','Item 3'),(2,'1','de0410cId1r54',30,'2023-10-04','2023-10-07','Kakrail','Item 4'),(3,'2','de0410cId2r56',30,'2023-10-04','2023-10-07','Kakrail','Item 2'),(4,'1','de0410cId1r3',30,'2023-10-04','2023-10-07','Dhaka','Item 3'),(5,'1','de0410cId1r7',30,'2023-10-04','2023-10-04','ooo','Item 4'),(6,'1','de0410cId1r2',30,'2023-10-04','2023-10-07','uuuuu','Item 3'),(7,'2','de0410cId2r1',30,'2023-10-04','2023-10-07','ppppp','Item 3');
/*!40000 ALTER TABLE `delivery_charge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demo_table`
--

DROP TABLE IF EXISTS `demo_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `batch_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo_table`
--

LOCK TABLES `demo_table` WRITE;
/*!40000 ALTER TABLE `demo_table` DISABLE KEYS */;
INSERT INTO `demo_table` VALUES (1,'Rakib',25,NULL),(2,'Akib',25,NULL),(3,'Rakib',25,NULL),(4,'Rakib',25,NULL);
/*!40000 ALTER TABLE `demo_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `division` (
  `id_division` int NOT NULL AUTO_INCREMENT,
  `division` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_division`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'Barisal'),(2,'Dhaka'),(3,'Chittagong'),(4,'Khulna'),(5,'Mymensingh'),(6,'Rajshahi'),(7,'Rangpur'),(8,'Sylhet');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `delivery_code` varchar(45) DEFAULT NULL,
  `payment` float DEFAULT NULL,
  `paid` float DEFAULT NULL,
  `due` float DEFAULT NULL,
  `payment_option` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,NULL,30,30,0,NULL),(2,NULL,40,40,0,NULL),(3,NULL,40,40,0,NULL),(4,NULL,40,40,0,NULL),(5,NULL,40,40,0,NULL),(6,NULL,40,40,0,NULL),(7,'de0410cId2r8',60,60,0,NULL),(8,'de0410cId1r54',40,40,0,'--Select Payment method--'),(9,'de0410cId1r3',40,40,0,'Pay Online'),(10,'de0410cId1r7',40,40,0,'Pay Online'),(11,'de0410cId1r2',40,40,0,'Pay Online'),(12,'de0410cId2r1',40,40,0,'Pay Online');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_stock`
--

DROP TABLE IF EXISTS `product_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_stock` (
  `idproduct_stock` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`idproduct_stock`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_stock`
--

LOCK TABLES `product_stock` WRITE;
/*!40000 ALTER TABLE `product_stock` DISABLE KEYS */;
INSERT INTO `product_stock` VALUES (1,'demo1',9,NULL),(2,'demo2',12,NULL),(3,'demo3',0,NULL),(4,'funcopop1',14,NULL),(5,'demo33',0,NULL);
/*!40000 ALTER TABLE `product_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_tag`
--

DROP TABLE IF EXISTS `product_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_tag` (
  `idproduct_tag` int NOT NULL AUTO_INCREMENT,
  `product_tag` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproduct_tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_tag`
--

LOCK TABLES `product_tag` WRITE;
/*!40000 ALTER TABLE `product_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `idproducts` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `quentity` int DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `purchase_price` float DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  PRIMARY KEY (`idproducts`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'demo1',NULL,10,5,'2023-09-23'),(2,'demo2',NULL,10,3,'2023-09-23'),(3,'demo3',NULL,20,2,'2023-09-23'),(4,'funcopop1',NULL,120,50,'2023-09-23'),(5,'demo33',NULL,13,2,'2023-09-27');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchases` (
  `idpurchases` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `quentity` int DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  PRIMARY KEY (`idpurchases`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases`
--

LOCK TABLES `purchases` WRITE;
/*!40000 ALTER TABLE `purchases` DISABLE KEYS */;
INSERT INTO `purchases` VALUES (1,'demo1',2,10,20,'2023-09-23'),(2,'demo2',3,10,30,'2023-09-23'),(3,'demo3',5,10,50,'2023-09-23'),(4,'funcopop1',10,120,1200,'2023-09-23'),(5,'demo2',50,10,500,'2023-09-24'),(6,'demo2',1,10,10,'2023-09-24'),(7,'funcopop1',2,120,240,'2023-09-25'),(8,'demo1',5,10,50,'2023-09-25'),(9,'demo3',5,10,50,'2023-10-02'),(10,'demo1',10,10,100,'2023-10-04'),(11,'funcopop1',10,120,1200,'2023-10-04'),(12,'funcopop1',3,120,360,'2023-10-04');
/*!40000 ALTER TABLE `purchases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `idsales` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `purchase_quentity` float DEFAULT NULL,
  `actual_price` float DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `sales_date` date DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `payment_id` int DEFAULT NULL,
  `delivery_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsales`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,'demo1',1,20,0,'2023-09-23',NULL,NULL,NULL,NULL),(2,'demo1',1,10,0,'2023-09-23',10,NULL,NULL,NULL),(3,'demo2',1,10,0,'2023-09-23',10,NULL,NULL,NULL),(4,'demo2',2,20,0,'2023-09-24',10,NULL,NULL,NULL),(5,'funcopop1',1,120,0,'2023-09-25',120,NULL,NULL,NULL),(6,'funcopop1',2,240,0,'2023-09-25',120,NULL,NULL,NULL),(7,'funcopop1',1,120,0,'2023-10-02',120,NULL,NULL,NULL),(8,'demo3',1,20,0,'2023-10-02',20,NULL,NULL,NULL),(9,'funcopop1',1,120,0,'2023-10-02',120,NULL,NULL,NULL),(10,'demo3',1,20,0,'2023-10-02',20,NULL,NULL,NULL),(11,'demo3',1,20,0,'2023-10-02',20,NULL,NULL,NULL),(12,'demo3',1,20,0,'2023-10-02',20,NULL,NULL,NULL),(13,'demo3',1,20,0,'2023-10-02',20,NULL,NULL,NULL),(14,'demo1',1,0,10,NULL,10,NULL,NULL,NULL),(15,'demo2',1,0,10,NULL,10,NULL,NULL,NULL),(16,'funcopop1',1,0,120,NULL,120,NULL,NULL,NULL),(17,'demo3',1,0,20,'2023-10-02',20,NULL,NULL,NULL),(18,'demo1',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(19,'demo2',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(20,'demo3',1,0,20,NULL,20,NULL,NULL,NULL),(21,'funcopop1',1,0,120,NULL,120,NULL,NULL,NULL),(22,'demo2',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(23,'demo2',2,0,20,'2023-10-01',10,NULL,NULL,NULL),(24,'demo1',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(25,'demo1',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(26,'demo3',1,0,20,'2023-10-02',20,NULL,NULL,NULL),(27,'demo2',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(28,'demo3',1,0,20,'2023-10-01',20,NULL,NULL,NULL),(29,'demo2',1,0,10,'2023-10-01',10,NULL,NULL,NULL),(30,'demo2',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(31,'demo2',1,0,10,'2023-10-01',10,NULL,NULL,NULL),(32,'demo2',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(33,'funcopop1',1,0,10,'2023-10-01',120,NULL,NULL,NULL),(34,'demo1',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(35,'demo2',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(36,'demo2',2,0,20,'2023-10-02',10,NULL,NULL,NULL),(37,'demo2',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(38,'demo2',2,0,20,'2023-10-02',10,NULL,NULL,NULL),(39,'demo2',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(40,'demo2',2,0,20,'2023-10-02',10,NULL,NULL,NULL),(41,'demo2',1,0,10,'2023-10-02',10,NULL,NULL,NULL),(42,'demo2',3,0,30,'2023-10-02',10,NULL,NULL,NULL),(43,'demo2',2,0,20,'2023-10-03',10,1,NULL,'1'),(44,'demo1',1,0,10,'2023-10-03',10,1,NULL,'1'),(45,'demo2',1,0,10,'2023-10-03',10,2,NULL,'de0310cId2r71'),(46,'demo2',1,0,10,'2023-10-03',10,1,NULL,'de0310cId1r77'),(47,'demo2',1,0,10,'2023-10-03',10,1,NULL,'de0310cId1r52'),(48,'demo2',1,0,10,'2023-10-03',10,1,NULL,'de0310cId1r5'),(49,'demo1',1,0,10,'2023-10-04',10,2,NULL,'de0410cId2r8'),(50,'demo2',2,0,20,'2023-10-04',10,2,NULL,'de0410cId2r8'),(51,'demo1',1,0,10,'2023-10-04',10,1,NULL,'de0410cId1r54'),(52,'demo1',1,0,10,'2023-10-04',10,2,NULL,'de0410cId2r56'),(53,'demo2',1,0,10,'2023-10-04',10,2,NULL,'de0410cId2r56'),(54,'demo2',1,0,10,'2023-10-04',10,1,NULL,'de0410cId1r3'),(55,'demo2',1,0,10,'2023-10-04',10,1,NULL,'de0410cId1r7'),(56,'demo2',1,10,0,'2023-10-04',10,1,NULL,'de0410cId1r2'),(57,'demo2',1,10,0,'2023-10-04',10,2,NULL,'de0410cId2r1');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','A@1234','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-04 13:16:39