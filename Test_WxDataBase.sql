-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: WxDataBase
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `basic_info_dao`
--

DROP TABLE IF EXISTS `basic_info_dao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `basic_info_dao` (
  `openid` varchar(28) NOT NULL,
  `comid` char(8) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `tel` char(11) DEFAULT NULL,
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basic_info_dao`
--

LOCK TABLES `basic_info_dao` WRITE;
/*!40000 ALTER TABLE `basic_info_dao` DISABLE KEYS */;
INSERT INTO `basic_info_dao` (`openid`, `comid`, `name`, `sex`, `tel`) VALUES ('oPp935sJ5J4f_oc-40g4tsdbSjDA','18182618','杰斯',0,'13822138222'),('oPp935sJ5J4f_oc-40g4tsdbTEST','18181818','嘎子',1,'13800138111'),('oQ2D55tdazS8L-d_zEXON7eCrHlY','18180000','潘子',1,'13800138123');
/*!40000 ALTER TABLE `basic_info_dao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_dao`
--

DROP TABLE IF EXISTS `message_dao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_dao` (
  `openid` varchar(28) NOT NULL,
  `healthcondition` tinyint(1) NOT NULL,
  `latitude` double(10,5) NOT NULL,
  `longitude` double NOT NULL,
  `riskcontact` double(10,5) NOT NULL,
  `risklocation` tinyint(1) NOT NULL,
  `time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_dao`
--

LOCK TABLES `message_dao` WRITE;
/*!40000 ALTER TABLE `message_dao` DISABLE KEYS */;
INSERT INTO `message_dao` (`openid`, `healthcondition`, `latitude`, `longitude`, `riskcontact`, `risklocation`, `time`) VALUES ('oPp935sJ5J4f_oc-40g4tsdbSjDA',1,39.90469,116.40717,1.00000,0,'2021-05-12 20:43:04.000000'),('oQ2D55tdazS8L-d_zEXON7eCrHlY',0,39.90469,116.40717,0.00000,1,'2021-05-13 10:41:45.000000');
/*!40000 ALTER TABLE `message_dao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-16 20:21:46
