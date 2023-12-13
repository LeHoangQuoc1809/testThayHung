-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 06, 2020 at 04:38 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbhaisan`
--

-- --------------------------------------------------------

--
-- Table structure for table `haisan`
--

DROP TABLE IF EXISTS `haisan`;
CREATE TABLE IF NOT EXISTS `haisan` (
  `ma` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(50) NOT NULL,
  `xuatxu` varchar(50) NOT NULL,
  `donvitinh` varchar(20) NOT NULL,
  `tuoisong` tinyint(1) NOT NULL,
  `maloai` int(11) NOT NULL,
  PRIMARY KEY (`ma`),
  KEY `maloai` (`maloai`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `haisan`
--

INSERT INTO `haisan` (`ma`, `ten`, `xuatxu`, `donvitinh`, `tuoisong`, `maloai`) VALUES
(1, 'Tôm sú', 'Trong nước', 'Kg', 1, 1),
(2, 'Tôm hùm Alaska', 'Mỹ', 'Con', 0, 1),
(3, 'Cua nâu', 'Ireland', 'Con', 0, 3),
(4, 'Cua Hoàng Đế', 'Alaska', 'Con', 0, 3),
(5, 'Ốc Bulot', 'Ireland', 'Kg', 0, 4),
(6, 'Tu hài', 'Trong nước', 'Kg', 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `loaihaisan`
--

DROP TABLE IF EXISTS `loaihaisan`;
CREATE TABLE IF NOT EXISTS `loaihaisan` (
  `ma` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(50) NOT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaihaisan`
--

INSERT INTO `loaihaisan` (`ma`, `ten`) VALUES
(1, 'Tôm'),
(2, 'Cá'),
(3, 'Cua ghẹ'),
(4, 'Nghêu sò ốc');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `haisan`
--
ALTER TABLE `haisan`
  ADD CONSTRAINT `haisan_ibfk_1` FOREIGN KEY (`maloai`) REFERENCES `loaihaisan` (`ma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
