-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 19, 2022 at 04:41 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jwt`
--

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL,
  `permission` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `permission`
--

INSERT INTO `permission` (`id`, `permission`) VALUES
(1, 'aaaaaaaaaaaaaaa'),
(2, 'bbbbbbbbbbbbbbbb');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'MEMBER'),
(2, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `role_permission_map`
--

CREATE TABLE `role_permission_map` (
  `id_role` bigint(20) NOT NULL,
  `id_permission` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role_permission_map`
--

INSERT INTO `role_permission_map` (`id_role`, `id_permission`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE `token` (
  `id` bigint(20) NOT NULL,
  `token` text DEFAULT NULL,
  `token_exp_date` datetime DEFAULT NULL COMMENT 'read-only',
  `created_by` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `token`
--

INSERT INTO `token` (`id`, `token`, `token_exp_date`, `created_by`) VALUES
(1, 'eyJhbGciOiJIUzI1NiJ9.eyJ0YWlwcm92aXAzIjp7InBhc3N3b3JkIjoiJDJhJDEwJDJJdW1JUjBKT0hwZElzN0xHSU1UZ09KMHpuWmhTa1lJRllSQzFLZENwVEszY0dzY2R1U3d5IiwiaWQiOjIsImF1dGhvcml0aWVzIjpbImFhYWFhYWFhYWFhYWFhYSIsIk1FTUJFUiJdLCJ1c2VybmFtZSI6InN1c2FuMiJ9LCJleHAiOjE2NjY5NDU1MzB9.AH7ezYkhAWasaBc7LOMW-vZv-ykrpPZIP4zNj8-Efk4', '2022-10-28 08:02:40', 2),
(2, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdXNhbiIsImV4cCI6MTY2NjEyNDQ3NiwiaWF0IjoxNjY2MTA2NDc2fQ.WQ6SvndZ2Ygo7V1y6Brmi9778dRwypDuKdDmmCq1JQg97cGH3UtUocerKuUHwNVKL1vb4Fz25QIqo8u9t1nKmA', '2022-10-28 15:37:03', 1),
(3, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdXNhbjciLCJleHAiOjE2NjYxMjAyOTcsImlhdCI6MTY2NjEwMjI5N30.tcPnvMlYn1cT0_2H5htr610Sy-XFeUs0wx4yqHnx_0mALTplNwHftJqzi7WvwHJAT4AdoDJLqldyS-jGvdzubQ', '2022-10-17 21:53:01', 7),
(4, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdXNhbjgiLCJleHAiOjE2NjYxNTU2OTMsImlhdCI6MTY2NjEzNzY5M30.MHKjqhhwsA2BZB5qd4fVSXpUecbtMwAZLdK9ArIeiXWklpLCYJnPcJtZOHm2Y61eCFOeGcH3IwwRPHLEvY6Uew', '2022-10-19 11:57:40', 8);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(1, '$2a$10$BE4evaxJ6z5Jn73fSFHiku9rYlu3HlPr6n1pNC9EWnAflSw857fJ2', 'susan'),
(2, '$2a$10$2IumIR0JOHpdIs7LGIMTgOJ0znZhSkYIFYRC1KdCpTK3cGscduSwy', 'susan2'),
(3, '$2a$10$TsgGp48dYZG4//hzydYGYuHl/IDpgRD6789fhbf1uwbAsOLEXy.uu', 'susan3'),
(4, '$2a$10$msx70fxvIwPwMdWbvkTgkOSqoUicZyxlYeGxIKTDK7Jx7MfiDa./q', 'susan4'),
(5, '$2a$10$CDc8WxZbcWUAsCxG1/Z7feoWMUPM4a.QzsigjIG4QtsSMq5.exi8q', 'susan5'),
(6, '$2a$10$my6onsdNbXgp8/fNut2Ztu1dxcFu2lsGlMLhY6EruTZ34C.v/doUW', 'susan6'),
(7, '$2a$10$Ft5QhbFUN3aaEgoPhmI2Tuj9EtJoLydSFmZa2cjHmfvHiJn6tu.SG', 'susan7'),
(8, '$2a$10$.s6LWTxZvVOazfFLzzrjMubBHj8tU3JuhGoPgHfEJh3p3VJQkKT2e', 'susan8');

-- --------------------------------------------------------

--
-- Table structure for table `user_role_map`
--

CREATE TABLE `user_role_map` (
  `id_user` bigint(20) NOT NULL,
  `id_role` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role_map`
--

INSERT INTO `user_role_map` (`id_user`, `id_role`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role_permission_map`
--
ALTER TABLE `role_permission_map`
  ADD PRIMARY KEY (`id_role`,`id_permission`),
  ADD UNIQUE KEY `UK_m1k6evof73n1rreqnn427d5v1` (`id_permission`);

--
-- Indexes for table `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq5g30l3l475dgnvd85fe254ln` (`created_by`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role_map`
--
ALTER TABLE `user_role_map`
  ADD PRIMARY KEY (`id_user`,`id_role`),
  ADD KEY `FKj1ggj17aib8c49ppm5pxj42o7` (`id_role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `permission`
--
ALTER TABLE `permission`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `token`
--
ALTER TABLE `token`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `role_permission_map`
--
ALTER TABLE `role_permission_map`
  ADD CONSTRAINT `FKg10nq04sem65ifn7fku658bkx` FOREIGN KEY (`id_permission`) REFERENCES `permission` (`id`),
  ADD CONSTRAINT `FKsd5nu56rs6a7vret5p2f8v7ua` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`);

--
-- Constraints for table `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `FKq5g30l3l475dgnvd85fe254ln` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_role_map`
--
ALTER TABLE `user_role_map`
  ADD CONSTRAINT `FKj1ggj17aib8c49ppm5pxj42o7` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKyjdp00usiuj07xumj63fh0du` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
