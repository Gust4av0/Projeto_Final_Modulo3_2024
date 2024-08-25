-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: projeto_churrasco_do_ze
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `cenas`
--

DROP TABLE IF EXISTS `cenas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cenas` (
  `idCena` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `descricao` text NOT NULL,
  PRIMARY KEY (`idCena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cenas`
--

LOCK TABLES `cenas` WRITE;
/*!40000 ALTER TABLE `cenas` DISABLE KEYS */;
INSERT INTO `cenas` VALUES (0,'Preparativos para o Churrasco','Zé está preparando um churrasco para os amigos. Ele precisa de CARVÃO, CARNE, FÓSFORO e CERVEJA. Há uma CHURRASQUEIRA na casa e um MERCADO na esquina'),(1,'No Mercado','Você está no mercado. Precisa pegar o CARVÃO, a CARNE a CERVEJA e o FÓSFORO, e depois retornar para CASA para fazer o belo churrasco'),(2,'Verificação do Inventário e acendendo churrasqueira','De volta à casa, você pode verificar o que você já coletou e preparar o churrasco. A CHURRASQUEIRA está pronta para ser acesa, você só precisa do carvão e do fósforo'),(3,'O Churrasco Perfeito','Com a CHURRASQUEIRA acesa, é hora de assar a carne e abrir uma CERVEJA. A carne está começando a grelhar e o cheiro é irresistível. Você se sente pronto para relaxar e aproveitar o churrasco');
/*!40000 ALTER TABLE `cenas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'projeto_churrasco_do_ze'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-25 16:14:47
