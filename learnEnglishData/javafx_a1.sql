-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: javafx
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `a1`
--

DROP TABLE IF EXISTS `a1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `a1` (
  `id` int DEFAULT NULL,
  `words_in_english` varchar(100) DEFAULT NULL,
  `translate` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a1`
--

LOCK TABLES `a1` WRITE;
/*!40000 ALTER TABLE `a1` DISABLE KEYS */;
INSERT INTO `a1` VALUES (1,'big','великий'),(2,'small','малий'),(3,'new','новий'),(4,'old','старий'),(5,'happy','щасливий'),(6,'sad','сумний'),(7,'hot','гарячий'),(8,'cold','холодний'),(9,'fast','швидкий'),(10,'slow','повільний'),(11,'beautiful','красивий'),(12,'ugly','несимпатичний'),(13,'good','добрий'),(14,'bad','поганий'),(15,'hard','важкий'),(16,'easy','легкий'),(17,'cheap','дешевий'),(18,'expensive','дорогий'),(19,'right','правий'),(20,'left','лівий'),(21,'open','відкритий'),(22,'closed','закритий'),(23,'early','рано'),(24,'late','пізно'),(25,'far','далеко'),(26,'near','близько'),(27,'empty','порожній'),(28,'full','повний'),(29,'thick','товстий'),(30,'thin','тонкий'),(31,'long','довгий'),(32,'short','короткий'),(33,'loud','голосний'),(34,'quiet','тихий'),(35,'simple','простий'),(36,'complicated','складний'),(37,'clean','чистий'),(38,'dirty','брудний'),(39,'sweet','солодкий'),(40,'sour','кислий'),(41,'bitter','гіркий'),(42,'spicy','гострий'),(43,'thirsty','спраглий'),(44,'hungry','голодний'),(45,'tired','втомлений'),(46,'healthy','здоровий'),(47,'sick','хворий'),(48,'happy','радісний'),(49,'angry','злий'),(50,'calm','спокійний');
/*!40000 ALTER TABLE `a1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-15 15:25:31
