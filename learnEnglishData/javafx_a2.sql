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
-- Table structure for table `a2`
--

DROP TABLE IF EXISTS `a2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `a2` (
  `id` int DEFAULT NULL,
  `words_in_english` varchar(100) DEFAULT NULL,
  `translate` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a2`
--

LOCK TABLES `a2` WRITE;
/*!40000 ALTER TABLE `a2` DISABLE KEYS */;
INSERT INTO `a2` VALUES (1,'friendship','дружба'),(2,'travel','подорож'),(3,'music','музика'),(4,'movie','фільм'),(5,'sport','спорт'),(6,'hobby','хобі'),(7,'shopping','покупки'),(8,'restaurant','ресторан'),(9,'party','вечірка'),(10,'celebrate','святкувати'),(11,'dangerous','небезпечний'),(12,'safe','безпечний'),(13,'beautiful','прекрасний'),(14,'ugly','відтхильний'),(15,'successful','успішний'),(16,'unsuccessful','невдалий'),(17,'surprise','сюрприз'),(18,'predictable','передбачуваний'),(19,'boring','нудний'),(20,'interesting','цікавий'),(21,'healthy','здоровий'),(22,'unhealthy','нездоровий'),(23,'exciting','захоплюючий'),(24,'bored','нудний'),(25,'excited','захоплений'),(26,'successful','успішний'),(27,'unsuccessful','невдалий'),(28,'surprise','сюрприз'),(29,'predictable','передбачуваний'),(30,'boring','нудний'),(31,'interesting','цікавий'),(32,'healthy','здоровий'),(33,'unhealthy','нездоровий'),(34,'exciting','захоплюючий'),(35,'bored','нудний'),(36,'excited','захоплений'),(37,'successful','успішний'),(38,'unsuccessful','невдалий'),(39,'surprise','сюрприз'),(40,'predictable','передбачуваний'),(41,'boring','нудний'),(42,'interesting','цікавий'),(43,'healthy','здоровий'),(44,'unhealthy','нездоровий'),(45,'exciting','захоплюючий'),(46,'bored','нудний'),(47,'excited','захоплений'),(48,'successful','успішний'),(49,'unsuccessful','невдалий'),(50,'surprise','сюрприз');
/*!40000 ALTER TABLE `a2` ENABLE KEYS */;
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
