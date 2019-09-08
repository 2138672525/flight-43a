-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- Server version:               8.0.16 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for flight
CREATE DATABASE IF NOT EXISTS `flight` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `flight`;

-- Dumping structure for table flight.flight_price
CREATE TABLE IF NOT EXISTS `flight_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `origin` varchar(3) DEFAULT NULL COMMENT '出发地',
  `dest` varchar(3) DEFAULT NULL COMMENT '到达地',
  `baggage` varchar(200) DEFAULT NULL COMMENT '行李额',
  `rule` varchar(200) DEFAULT NULL COMMENT '退改签信息',
  `depart_date` varchar(12) DEFAULT NULL COMMENT '起飞日期',
  `depart_time` varchar(6) DEFAULT NULL COMMENT '起飞时间',
  `arrival_date` varchar(12) DEFAULT NULL COMMENT '到达日期',
  `arrival_time` varchar(6) DEFAULT NULL COMMENT '到达时间',
  `carrier` varchar(2) DEFAULT NULL COMMENT '航司二字码',
  `flight_no` varchar(4) DEFAULT NULL COMMENT '航班号',
  `aircraft` varchar(8) DEFAULT NULL COMMENT '机型',
  `act_flight_no` varchar(4) DEFAULT NULL COMMENT '实际承运航班号',
  `act_carrier` varchar(2) DEFAULT NULL COMMENT '实际承运航司',
  `price` int(11) DEFAULT NULL COMMENT '价格',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Dumping data for table flight.flight_price: ~12 rows (approximately)
/*!40000 ALTER TABLE `flight_price` DISABLE KEYS */;
INSERT INTO `flight_price` (`id`, `origin`, `dest`, `baggage`, `rule`, `depart_date`, `depart_time`, `arrival_date`, `arrival_time`, `carrier`, `flight_no`, `aircraft`, `act_flight_no`, `act_carrier`, `price`, `create_time`, `update_time`) VALUES
	(1, 'BJS', 'BKK', '10kg', '不可退改', '2019-05-20', '10:00', '2019-05-20', '14:00', 'CA', '101', '730', '101', 'CA', 1000, '2019-05-02 16:39:36', '2019-05-02 16:40:16'),
	(2, 'BJS', 'BKK', '20KG', '退票手续费500元', '2019-05-20', '10:20', '2019-05-20', '14:30', 'MU', '701', '737', '701', 'MU', 1300, '2019-05-03 16:51:08', '2019-05-03 16:51:10'),
	(3, 'BJS', 'BKK', '15KG', '提前15天免费退票', '2019-05-20', '11:00', '2019-05-20', '14:40', 'CZ', '1010', '787', '1010', 'CZ', 1500, '2019-05-03 16:52:53', '2019-05-03 16:52:54'),
	(4, 'BJS', 'BKK', '10KG', '不可退改', '2019-05-20', '11:20', '2019-05-20', '15:00', 'CA', '103', '730', '103', 'CA', 1200, '2019-05-03 16:54:29', '2019-05-03 16:54:29'),
	(5, 'BJS', 'BKK', '15KG', '退改400元起', '2019-05-20', '11:30', '2019-05-20', '15:20', 'JD', '173', '720', '173', 'JD', 1400, '2019-05-03 16:54:48', '2019-05-03 16:54:49'),
	(6, 'BJS', 'BKK', '20KG', '不可退改', '2019-05-20', '12:00', '2019-05-20', '16:00', 'MF', '101', '730', '101', 'MF', 1600, '2019-05-03 16:55:01', '2019-05-03 16:55:02'),
	(7, 'BJS', 'BKK', '10kg', '不可退改', '2019-05-20', '10:50', '2015-05-20', '14:50', 'CA', '105', '730', '105', 'CA', 1100, '2019-05-03 17:02:03', '2019-05-03 17:02:06'),
	(8, 'BJS', 'BKK', '20KG', '退票手续费500元', '2019-05-20', '10:40', '2019-05-20', '14:50', 'MU', '703', '737', '703', 'MU', 1300, '2019-05-03 17:02:08', '2019-05-03 17:02:07'),
	(9, 'BJS', 'BKK', '15KG', '提前15天免费退票', '2019-05-20', '11:40', '2019-05-20', '15:40', 'CZ', '1013', '787', '1013', 'CZ', 1600, '2019-05-03 17:02:09', '2019-05-03 17:02:10'),
	(10, 'BJS', 'BKK', '10KG', '不可退改', '2019-05-20', '11:50', '2019-05-20', '15:20', 'CA', '107', '730', '107', 'CA', 1700, '2019-05-03 17:02:13', '2019-05-03 17:02:12'),
	(11, 'BJS', 'BKK', '15KG', '退改400元起', '2019-05-20', '13:10', '2019-05-20', '16:20', 'JD', '175', '720', '175', 'JD', 1600, '2019-05-03 17:02:13', '2019-05-03 17:02:15'),
	(12, 'BJS', 'BKK', '20KG', '不可退改', '2019-05-20', '12:50', '2019-05-20', '16:30', 'MF', '103', '730', '103', 'MF', 1650, '2019-05-03 17:02:17', '2019-05-03 17:02:16');
/*!40000 ALTER TABLE `flight_price` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
