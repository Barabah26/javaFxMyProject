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
-- Table structure for table `b2`
--

DROP TABLE IF EXISTS `b2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `b2` (
  `id` int DEFAULT NULL,
  `words_in_english` varchar(100) DEFAULT NULL,
  `translate` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b2`
--

LOCK TABLES `b2` WRITE;
/*!40000 ALTER TABLE `b2` DISABLE KEYS */;
INSERT INTO `b2` VALUES (1,'adequate','достатній'),(2,'comprehensive','загальний'),(3,'deteriorate','погіршуватися'),(4,'discriminate','дискримінувати'),(5,'feasible','реальний'),(6,'intricate','складний'),(7,'profound','глибокий'),(8,'reluctant','небажаний'),(9,'tenacious','цілеспрямований'),(10,'ambiguous','неоднозначний'),(11,'alleviate','полегшувати'),(12,'coherent','логічний'),(13,'complacent','самовдоволений'),(14,'concise','короткий'),(15,'diligent','старанний'),(16,'exemplify','прикладати'),(17,'fallacious','осяжний'),(18,'gratify','задовольняти'),(19,'haphazard','випадковий'),(20,'inherent','властивий'),(21,'meticulous','ретельний'),(22,'obsolete','застарілий'),(23,'pervasive','поширений'),(24,'pragmatic','прагматичний'),(25,'rebuke','докоряти'),(26,'reciprocal','взаємний'),(27,'scrutinize','досліджувати'),(28,'substantiate','підтверджувати'),(29,'superfluous','зайвий'),(30,'ubiquitous','всюди присутній'),(31,'vociferous','голосний'),(32,'wane','зменшувати'),(33,'xenophobia','ксенофобія'),(34,'yearn','тужити'),(35,'zealot','фанатик'),(36,'whimsical','капризний'),(37,'veracious','правдивий'),(38,'unprecedented','безпрецедентний'),(39,'trepidation','тремтіння'),(40,'serendipity','серендипіті'),(41,'quintessential','квінтесенція'),(42,'pernicious','шкідливий'),(43,'obfuscate','затемнювати'),(44,'nefarious','злочинний'),(45,'magnanimous','великодушний'),(46,'languish','гинути'),(47,'kowtow','вклонятися'),(48,'juxtapose','поручити'),(49,'ignominious','прикро'),(50,'furtive','таємничий');
/*!40000 ALTER TABLE `b2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-15 15:25:30
