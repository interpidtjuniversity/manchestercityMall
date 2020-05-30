-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: localhost    Database: web_mall_2020
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `goodId` int(20) NOT NULL,
  `goodName` varchar(30) NOT NULL,
  `goodPrice` int(20) NOT NULL,
  `goodDeliveryPlace` varchar(40) NOT NULL,
  PRIMARY KEY (`goodId`) USING BTREE,
  UNIQUE KEY `idx_goodId` (`goodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='货物表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'Pride in Battle引战必备',600,'Manchester City'),(2,'阿Kun正版签名球衣',6000,'Manchester City'),(3,'蓝月三叉戟实录',520,'Manchester City'),(4,'曼彻斯特城5号新星足球-白色',500,'Manchester City'),(5,'曼彻斯特城球衣2019-20-儿童',300,'Manchester City'),(6,'曼彻斯特城市时尚手提包',1000,'Manchester City'),(7,'曼彻斯特市Pulse Double羽绒被',2000,'Manchester City'),(8,'曼彻斯特市卧室灯',100,'Manchester City'),(9,'曼城个性杯',150,'Manchester City'),(10,'渣男手办',200,'Manchester City');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods2`
--

DROP TABLE IF EXISTS `goods2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods2` (
  `goodId` int(20) NOT NULL,
  `goodName` varchar(30) NOT NULL,
  `goodPrice` int(20) NOT NULL,
  `goodDeliveryPlace` varchar(40) NOT NULL,
  PRIMARY KEY (`goodId`),
  UNIQUE KEY `idx_goodId` (`goodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='货物表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods2`
--

LOCK TABLES `goods2` WRITE;
/*!40000 ALTER TABLE `goods2` DISABLE KEYS */;
INSERT INTO `goods2` VALUES (1,'游戏王1012补充包 永恒代码',290,'Japan'),(2,'游戏王LVP3补充包',148,'Japan'),(3,'游戏王DP23补充包',162,'Japan'),(4,'游戏王 EP19 EXTRA PACK 2019',155,'Japan'),(5,'游戏王1008 暗黑新宇宙风暴',290,'Japan'),(6,'游戏王OCG DM 20周年决斗者礼盒',500,'Japan'),(7,'游戏王 EP18 EXTRA PACK 2018',125,'Japan'),(8,'游戏王1011补充包 点火强袭',320,'Japan'),(9,'游戏王日文正版1010补充包',300,'Japan'),(10,'游戏王LINK VRAINS DUELIST SET',120,'Japan');
/*!40000 ALTER TABLE `goods2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `username` varchar(20) NOT NULL,
  `goodId` int(20) NOT NULL,
  `goodNum` int(20) NOT NULL,
  `goodDeliveryPlace` varchar(40) NOT NULL,
  `totalPrice` int(20) NOT NULL,
  `orderId` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `order_orderId_uindex` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES ('1752486cy',1,1,'Manchester City',600,67),('1752486cy',2,1,'Manchester City',6000,68),('1752486cy',3,1,'Manchester City',520,69),('1752486cy',4,1,'Manchester City',500,70),('1752486cy',7,1,'Manchester City',2000,71),('1752486cy',10,1,'Manchester City',200,72),('lxy',6,1,'Manchester City',1000,73),('lxy',8,1,'Manchester City',100,74),('1752486cy',1,2,'Manchester City',1200,75),('1752486cy',2,1,'Manchester City',6000,76),('1752486cy',3,1,'Manchester City',520,77),('1752486cy',9,1,'Manchester City',150,78),('1752486cy',2,1,'Manchester City',6000,79),('1752486cy',7,1,'Manchester City',2000,80),('1752486cy',10,6,'Manchester City',1200,81),('1752486CY',1,1,'Manchester City',600,82),('1752486CY',2,1,'Manchester City',6000,83),('1752486CY',6,1,'Manchester City',1000,84),('1752486cy',9,1,'Manchester City',150,85),('logan',3,1,'Manchester City',520,86),('logan',4,1,'Manchester City',500,87),('logan',2,1,'Manchester City',6000,88),('logan',3,1,'Manchester City',520,89),('1752486cy',2,1,'Manchester City',6000,90),('nxzwzxf',1,1,'Manchester City',600,91),('nxzwzxf',2,1,'Manchester City',6000,92),('nxzwzxf',4,1,'Manchester City',500,93),('1752486cy',1,1,'Manchester City',600,94),('1752486cy',2,1,'Manchester City',6000,95),('1752486cy',9,2,'Manchester City',300,96),('123test',1,1,'Manchester City',600,97),('123test',2,1,'Manchester City',6000,98),('123test',4,1,'Manchester City',500,99),('123test',5,1,'Manchester City',300,100),('cuiyao',3,2,'Manchester City',1040,101),('zhujiao',1,1,'Manchester City',600,102),('zhujiao',3,1,'Manchester City',520,103),('zhujiao',8,1,'Manchester City',100,104),('zhujiao',9,1,'Manchester City',150,105);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order2`
--

DROP TABLE IF EXISTS `order2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order2` (
  `username` varchar(20) NOT NULL,
  `goodId` int(20) NOT NULL,
  `goodNum` int(20) NOT NULL,
  `goodDeliveryPlace` varchar(40) NOT NULL,
  `totalPrice` int(20) NOT NULL,
  `orderId` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `order_orderId_uindex` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order2`
--

LOCK TABLES `order2` WRITE;
/*!40000 ALTER TABLE `order2` DISABLE KEYS */;
INSERT INTO `order2` VALUES ('1753603lyj',3,2,'Japan',324,1),('1753603lyj',7,1,'Japan',125,2),('1753603lyj',4,1,'Japan',155,3),('1753603lyj',8,1,'Japan',320,4),('1752486cy',1,1,'Japan',290,5),('1752486cy',2,1,'Japan',148,6);
/*!40000 ALTER TABLE `order2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userCart`
--

DROP TABLE IF EXISTS `userCart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userCart` (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodId` int(20) NOT NULL,
  `goodNum` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`,`goodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户购物车表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userCart`
--

LOCK TABLES `userCart` WRITE;
/*!40000 ALTER TABLE `userCart` DISABLE KEYS */;
/*!40000 ALTER TABLE `userCart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userCart2`
--

DROP TABLE IF EXISTS `userCart2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userCart2` (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodId` int(20) NOT NULL,
  `goodNum` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`,`goodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户购物车表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userCart2`
--

LOCK TABLES `userCart2` WRITE;
/*!40000 ALTER TABLE `userCart2` DISABLE KEYS */;
/*!40000 ALTER TABLE `userCart2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userLogin`
--

DROP TABLE IF EXISTS `userLogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userLogin` (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE,
  UNIQUE KEY `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登陆表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userLogin`
--

LOCK TABLES `userLogin` WRITE;
/*!40000 ALTER TABLE `userLogin` DISABLE KEYS */;
INSERT INTO `userLogin` VALUES ('123test','123456'),('1752486cy','cy19991116'),('1753603lyj','lyjsbsbsbsb'),('cr7cy','leomessi'),('cuiyao','12345'),('interpidtjuniversity','123456'),('jklmnya','jklmnya1234'),('leocy','cr7'),('lin','1234'),('logan','123456'),('lxy','lxy19981229'),('nxzwzxf','123456'),('zhujiao','123456');
/*!40000 ALTER TABLE `userLogin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-30 11:27:20
