-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 27 Apr 2019 pada 08.10
-- Versi Server: 10.1.9-MariaDB
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `alumni`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akunalumni`
--

CREATE TABLE `akunalumni` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `dataalumni`
--

CREATE TABLE `dataalumni` (
  `Nama` varchar(50) NOT NULL,
  `NIM` varchar(10) NOT NULL,
  `Tahun_Lulus` char(4) NOT NULL,
  `Tempat_KP` varchar(50) NOT NULL,
  `IPK` double NOT NULL,
  `Riwayat_Pekerjaan` varchar(50) NOT NULL,
  `Judul_TA` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akunalumni`
--
ALTER TABLE `akunalumni`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `dataalumni`
--
ALTER TABLE `dataalumni`
  ADD PRIMARY KEY (`NIM`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
