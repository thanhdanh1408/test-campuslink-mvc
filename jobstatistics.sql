-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: jobstatistics
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `cong_viec`
--

DROP TABLE IF EXISTS `cong_viec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cong_viec` (
  `SoCMND` bigint NOT NULL,
  `NgayVaoCongTy` date NOT NULL,
  `MaNganh` int NOT NULL,
  `TenCongTy` varchar(100) DEFAULT NULL,
  `ThoiGianLamViec` int DEFAULT NULL,
  PRIMARY KEY (`SoCMND`,`NgayVaoCongTy`,`MaNganh`),
  KEY `MaNganh` (`MaNganh`),
  CONSTRAINT `cong_viec_ibfk_1` FOREIGN KEY (`SoCMND`) REFERENCES `sinhvien` (`SoCMND`),
  CONSTRAINT `cong_viec_ibfk_2` FOREIGN KEY (`MaNganh`) REFERENCES `nganh` (`MaNganh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cong_viec`
--

LOCK TABLES `cong_viec` WRITE;
/*!40000 ALTER TABLE `cong_viec` DISABLE KEYS */;
/*!40000 ALTER TABLE `cong_viec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nganh`
--

DROP TABLE IF EXISTS `nganh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nganh` (
  `MaNganh` int NOT NULL,
  `TenNganh` varchar(100) NOT NULL,
  `LoaiNganh` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaNganh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nganh`
--

LOCK TABLES `nganh` WRITE;
/*!40000 ALTER TABLE `nganh` DISABLE KEYS */;
INSERT INTO `nganh` VALUES (1,'Công nghệ Thông tin',NULL),(2,'Kinh tế Quốc tế',NULL);
/*!40000 ALTER TABLE `nganh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien` (
  `SoCMND` bigint NOT NULL,
  `HoTen` varchar(100) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `SoDT` bigint DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SoCMND`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tot_nghiep`
--

DROP TABLE IF EXISTS `tot_nghiep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tot_nghiep` (
  `SoCMND` bigint NOT NULL,
  `MaTruong` int NOT NULL,
  `MaNganh` int NOT NULL,
  `HeTN` varchar(50) DEFAULT NULL,
  `NgayTN` date DEFAULT NULL,
  `LoaiTN` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SoCMND`,`MaTruong`,`MaNganh`),
  KEY `MaTruong` (`MaTruong`),
  KEY `MaNganh` (`MaNganh`),
  CONSTRAINT `tot_nghiep_ibfk_1` FOREIGN KEY (`SoCMND`) REFERENCES `sinhvien` (`SoCMND`),
  CONSTRAINT `tot_nghiep_ibfk_2` FOREIGN KEY (`MaTruong`) REFERENCES `truong` (`MaTruong`),
  CONSTRAINT `tot_nghiep_ibfk_3` FOREIGN KEY (`MaNganh`) REFERENCES `nganh` (`MaNganh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tot_nghiep`
--

LOCK TABLES `tot_nghiep` WRITE;
/*!40000 ALTER TABLE `tot_nghiep` DISABLE KEYS */;
/*!40000 ALTER TABLE `tot_nghiep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truong`
--

DROP TABLE IF EXISTS `truong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `truong` (
  `MaTruong` int NOT NULL,
  `TenTruong` varchar(100) NOT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `SoDT` bigint DEFAULT NULL,
  PRIMARY KEY (`MaTruong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truong`
--

LOCK TABLES `truong` WRITE;
/*!40000 ALTER TABLE `truong` DISABLE KEYS */;
INSERT INTO `truong` VALUES (1,'Đại học Bách Khoa',NULL,NULL),(2,'Đại học Kinh Tế',NULL,NULL);
/*!40000 ALTER TABLE `truong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-29 10:18:00
