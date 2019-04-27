-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 27, 2019 at 09:43 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminakun`
--

CREATE TABLE `adminakun` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminakun`
--

INSERT INTO `adminakun` (`Username`, `Password`) VALUES
('Hiskia', '1234567');

-- --------------------------------------------------------

--
-- Table structure for table `akunalumni`
--

CREATE TABLE `akunalumni` (
  `Password` varchar(30) NOT NULL,
  `NIM` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `alumni`
--

CREATE TABLE `alumni` (
  `NIM` varchar(10) NOT NULL,
  `NAMA` varchar(25) NOT NULL,
  `Tahun_Lulu` char(4) NOT NULL,
  `Tempat_KP` varchar(30) NOT NULL,
  `IPK` double NOT NULL,
  `Riwayat_Kerja` varchar(30) NOT NULL,
  `Judul_TA` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alumni`
--

INSERT INTO `alumni` (`NIM`, `NAMA`, `Tahun_Lulu`, `Tempat_KP`, `IPK`, `Riwayat_Kerja`, `Judul_TA`, `email`) VALUES
('14117067', 'Irma Safitri', '2019', '', 4, '', '', 'irma.14117067@student.itera.ac.id'),
('14117086', 'Nurtias Rahayu', '2019', '', 3, '', '', 'nurtias.14117086@student.itera.ac.id'),
('14117091', 'Hiskia Perdamen Pulungan', '2021', '', 3, '', '', 'hiskia.14117091@student.itera.ac.id');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminakun`
--
ALTER TABLE `adminakun`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `akunalumni`
--
ALTER TABLE `akunalumni`
  ADD KEY `NIM` (`NIM`);

--
-- Indexes for table `alumni`
--
ALTER TABLE `alumni`
  ADD PRIMARY KEY (`NIM`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `akunalumni`
--
ALTER TABLE `akunalumni`
  ADD CONSTRAINT `akunalumni_ibfk_1` FOREIGN KEY (`NIM`) REFERENCES `alumni` (`NIM`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
