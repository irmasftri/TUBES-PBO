-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 29 Apr 2019 pada 01.17
-- Versi Server: 10.1.9-MariaDB
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smiati`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `adminakun`
--

CREATE TABLE `adminakun` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `adminakun`
--

INSERT INTO `adminakun` (`Username`, `Password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `akunalumni`
--

CREATE TABLE `akunalumni` (
  `Password` varchar(30) NOT NULL,
  `NIM` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `akunalumni`
--

INSERT INTO `akunalumni` (`Password`, `NIM`) VALUES
('1999-01-01', '14117091'),
('2000-02-21', '14117086'),
('1999-01-22', '14117067');

-- --------------------------------------------------------

--
-- Struktur dari tabel `alumni`
--

CREATE TABLE `alumni` (
  `NIM` varchar(10) NOT NULL,
  `NAMA` varchar(25) NOT NULL,
  `Tahun_Lulus` char(4) NOT NULL,
  `Tempat_KP` varchar(30) NOT NULL,
  `IPK` double NOT NULL,
  `Riwayat_Kerja` varchar(30) NOT NULL,
  `Judul_TA` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `alumni`
--

INSERT INTO `alumni` (`NIM`, `NAMA`, `Tahun_Lulus`, `Tempat_KP`, `IPK`, `Riwayat_Kerja`, `Judul_TA`, `email`) VALUES
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
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `akunalumni`
--
ALTER TABLE `akunalumni`
  ADD CONSTRAINT `akunalumni_ibfk_1` FOREIGN KEY (`NIM`) REFERENCES `alumni` (`NIM`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
