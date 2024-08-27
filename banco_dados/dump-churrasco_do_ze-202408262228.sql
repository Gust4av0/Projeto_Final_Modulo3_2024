-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: churrasco_do_ze
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
  `idCena` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoCena` text NOT NULL,
  PRIMARY KEY (`idCena`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cenas`
--

LOCK TABLES `cenas` WRITE;
/*!40000 ALTER TABLE `cenas` DISABLE KEYS */;
INSERT INTO `cenas` VALUES (1,'Zé está preparando um churrasco para os amigos. Ele já tem uma churrasqueira pronta com carvão, mas precisa comprar a carne, o fósforo e a cerveja. Há um grande MERCADO na esquina que pode fornecer tudo o que falta. Não se esqueça de pegar os fósforos para acender a churrasqueira.'),(2,'Você está no mercado. Precisa pegar a CARNE a CERVEJA e o FÓSFORO, e depois retornar para CASA para fazer o belo churrasco.'),(3,'De volta à casa, você pode verificar o que você já coletou e preparar o churrasco. A CHURRASQUEIRA está pronta para ser acesa, você só precisa do fósforo.'),(4,'Com a churrasqueira acesa, é hora de colocar a carne na GRELHA, assar a carne e abrir uma CERVEJA.'),(5,'Com a carne assando e a cerveja na mão, você se senta para aproveitar o churrasco. Seus amigos começam a chegar, e todos estão prontos para se divertir e saborear a refeição deliciosa. Você se sente satisfeito, sabendo que fez um excelente trabalho preparando tudo. O churrasco do Zé foi um sucesso!');
/*!40000 ALTER TABLE `cenas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comandos`
--

DROP TABLE IF EXISTS `comandos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comandos` (
  `idComando` int(11) NOT NULL AUTO_INCREMENT,
  `comando` varchar(255) NOT NULL,
  `descricao` text DEFAULT NULL,
  PRIMARY KEY (`idComando`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comandos`
--

LOCK TABLES `comandos` WRITE;
/*!40000 ALTER TABLE `comandos` DISABLE KEYS */;
INSERT INTO `comandos` VALUES (1,'help','Exibe o menu de ajuda do Jogo: \nUSE [ITEM]: interage com o item da cena\nCHECK [ITEM]: mostra a descrição do objeto na cena\nGET [ITEM]: Se possível, adiciona o item ao inventário\nINVENTORY: mostra os itens que estão no inventário\nUSE (INVENTORY_ITEM) WITH (SCENE_ITEM): Realiza a ação utilizando um item do inventário com um item da cena\nSAVE: salva o jogo\nLOAD: carrega um jogo salvo\nRESTART: reinicia o jogo'),(2,'use mercado','Vai para o mercado para fazer as compras.'),(3,'get carne','Pega a carne e adiciona ao inventário.'),(4,'get cerveja','Pega a cerveja e adiciona ao inventário.'),(5,'get fósforo','Pega o fósforo e adiciona ao inventário.'),(6,'use casa','Volta para casa.'),(7,'use fósforo with churrasqueira','Acende a churrasqueira com o fósforo.'),(8,'check fósforo','Verifica se o fósforo está disponível e pronto para uso.'),(9,'use carne with grelha','Coloca a carne na grelha.'),(10,'use cerveja','Abre uma cerveja para curtir o churrasco.'),(11,'check carne','Verifica se a carne está pronta para ser colocada na grelha.');
/*!40000 ALTER TABLE `comandos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `idInventario` int(11) NOT NULL AUTO_INCREMENT,
  `idObjeto` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT 1,
  PRIMARY KEY (`idInventario`),
  KEY `idObjeto` (`idObjeto`),
  CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`idObjeto`) REFERENCES `objetos` (`idObjeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_cena`
--

DROP TABLE IF EXISTS `itens_cena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_cena` (
  `idItemCena` int(11) NOT NULL AUTO_INCREMENT,
  `idObjeto` int(11) DEFAULT NULL,
  `idCena` int(11) DEFAULT NULL,
  PRIMARY KEY (`idItemCena`),
  KEY `idCena` (`idCena`),
  KEY `idObjeto` (`idObjeto`),
  CONSTRAINT `itens_cena_ibfk_1` FOREIGN KEY (`idCena`) REFERENCES `cenas` (`idCena`),
  CONSTRAINT `itens_cena_ibfk_2` FOREIGN KEY (`idObjeto`) REFERENCES `objetos` (`idObjeto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_cena`
--

LOCK TABLES `itens_cena` WRITE;
/*!40000 ALTER TABLE `itens_cena` DISABLE KEYS */;
INSERT INTO `itens_cena` VALUES (1,1,1),(2,2,2),(3,3,2),(4,4,2),(5,5,2),(6,6,3),(7,7,3),(8,8,4),(9,9,4),(10,10,4);
/*!40000 ALTER TABLE `itens_cena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogos_salvos`
--

DROP TABLE IF EXISTS `jogos_salvos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogos_salvos` (
  `idJogo` int(11) NOT NULL AUTO_INCREMENT,
  `idCenaAtual` int(11) DEFAULT NULL,
  `dataHora` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`idJogo`),
  KEY `idCenaAtual` (`idCenaAtual`),
  CONSTRAINT `jogos_salvos_ibfk_1` FOREIGN KEY (`idCenaAtual`) REFERENCES `cenas` (`idCena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogos_salvos`
--

LOCK TABLES `jogos_salvos` WRITE;
/*!40000 ALTER TABLE `jogos_salvos` DISABLE KEYS */;
/*!40000 ALTER TABLE `jogos_salvos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objetos`
--

DROP TABLE IF EXISTS `objetos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `objetos` (
  `idObjeto` int(11) NOT NULL AUTO_INCREMENT,
  `idCena` int(11) DEFAULT NULL,
  `nomeObjeto` varchar(255) NOT NULL,
  `descricaoObjeto` text DEFAULT NULL,
  `resultadoPositivo` text DEFAULT NULL,
  `resultadoNegativo` text DEFAULT NULL,
  `comandoCorreto` varchar(255) NOT NULL,
  `proximaCena` int(11) DEFAULT NULL,
  `podeCarregar` tinyint(1) NOT NULL,
  PRIMARY KEY (`idObjeto`),
  KEY `idCena` (`idCena`),
  KEY `proximaCena` (`proximaCena`),
  CONSTRAINT `objetos_ibfk_1` FOREIGN KEY (`idCena`) REFERENCES `cenas` (`idCena`),
  CONSTRAINT `objetos_ibfk_2` FOREIGN KEY (`proximaCena`) REFERENCES `cenas` (`idCena`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objetos`
--

LOCK TABLES `objetos` WRITE;
/*!40000 ALTER TABLE `objetos` DISABLE KEYS */;
INSERT INTO `objetos` VALUES (1,1,'MERCADO','Um grande mercado na esquina, com uma variedade de produtos. Perfeito para encontrar tudo o que falta para o churrasco.','Você vai até o mercado!','COMANDO INVÁLIDO! Consegue digitar novamente amigão?','use mercado',2,0),(2,2,'CARNE','Uma bela peça de carne para o churrasco.','Você escolhe a melhor ponta de peito e adiciona ao seu inventário.','COMANDO INVÁLIDO! Consegue digitar novamente amigão?','get carne',NULL,1),(3,2,'CERVEJA','Uma caixa de cerveja gelada, ideal para acompanhar o churrasco.','Você pega uma caixa de cerveja gelada e adiciona ao seu inventário.','COMANDO INVÁLIDO! Consegue digitar novamente amigão?','get cerveja',NULL,1),(4,2,'FÓSFORO','Uma caixa de fósforos, essencial para acender a churrasqueira.','Você pega uma caixa de fósforos e adiciona ao seu inventário.','COMANDO INVÁLIDO! Consegue digitar novamente amigão?','get fósforo',NULL,1),(5,2,'CASA','Casa do Zé, o recanto do Churrasco!',NULL,'COMANDO INVÁLIDO! Consegue digitar novamente amigão?','use casa',3,0),(6,3,'CHURRASQUEIRA','A churrasqueira está pronta para ser acesa, com carvão já colocado.','Você acendeu a churrasqueira com sucesso, e o carvão começa a esquentar. Agora, você pode preparar a grelha para a carne.','COMANDO INVÁLIDO! Consegue digitar novamente amigão?','use fósforo with churrasqueira',4,0),(7,3,'FÓSFORO','Já compramos o fósforo no mercado, só falta utilizá-lo para acender a churrasqueira.','Você coloca a carne na grelha. O aroma delicioso começa a se espalhar.','COMANDO INVÁLIDO! Consegue digitar novamente amigão?','check fósforo',NULL,1),(8,4,'GRELHA','A grelha está bem quente, pronta para receber a carne.',NULL,'COMANDO INVÁLIDO! Consegue digitar novamente amigão?','use carne with grelha',NULL,0),(9,4,'CERVEJA','Uma cerveja gelada, perfeita para relaxar enquanto o churrasco acontece.','Você abriu a cerveja e está pronto para relaxar.','COMANDO INVÁLIDO! Consegue digitar novamente amigão?','use cerveja',5,1),(10,4,'CARNE','Você já comprou a carne no mercado. Agora é hora de colocá-la na grelha para assar.',NULL,'COMANDO INVÁLIDO! Consegue digitar novamente amigão?','check carne',NULL,1);
/*!40000 ALTER TABLE `objetos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'churrasco_do_ze'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-26 22:28:51
