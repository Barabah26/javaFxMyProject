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
-- Table structure for table `b1`
--

DROP TABLE IF EXISTS `b1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `b1` (
  `id` int DEFAULT NULL,
  `words_in_english` varchar(100) DEFAULT NULL,
  `translate` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b1`
--

LOCK TABLES `b1` WRITE;
/*!40000 ALTER TABLE `b1` DISABLE KEYS */;
INSERT INTO `b1` VALUES (1,'effort','зусилля'),(2,'compromise','компроміс'),(3,'responsibility','відповідальність'),(4,'independence','незалежність'),(5,'commitment','зобов\"язання'),(6,'determination','визначеність'),(7,'negotiate','переговори'),(8,'evaluate','оцінювати'),(9,'challenge','виклик'),(10,'opportunity','можливість'),(11,'persuade','переконувати'),(12,'criticism','критика'),(13,'motivate','мотивувати'),(14,'accomplish','досягати'),(15,'ambitious','амбіційний'),(16,'cooperate','співпрацювати'),(17,'initiative','ініціатива'),(18,'evaluate','оцінювати'),(19,'overcome','подолати'),(20,'achieve','досягати'),(21,'tolerance','толерантність'),(22,'justice','справедливість'),(23,'perseverance','стійкість'),(24,'adapt','приспособлюватися'),(25,'innovative','інноваційний'),(26,'controversial','контроверсійний'),(27,'potential','потенціал'),(28,'ethical','етичний'),(29,'curiosity','цікавість'),(30,'interaction','взаємодія'),(31,'diversity','різноманіття'),(32,'globalization','глобалізація'),(33,'sustainable','стійкий'),(34,'integration','інтеграція'),(35,'resourceful','ресурсний'),(36,'consensus','консенсус'),(37,'accommodate','влаштовувати'),(38,'contribute','сприяти'),(39,'empathy','співчуття'),(40,'advocate','захищати інтереси'),(41,'philanthropy','філантропія'),(42,'integrity','чесність'),(43,'diplomacy','дипломатія'),(44,'sophisticated','вишуканий'),(45,'conscientious','сумлінний'),(46,'prosperity','процвітання'),(47,'sociable','товариський'),(48,'innovation','інновації'),(49,'entrepreneur','підприємець'),(50,'collaboration','співпраця');
/*!40000 ALTER TABLE `b1` ENABLE KEYS */;
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
