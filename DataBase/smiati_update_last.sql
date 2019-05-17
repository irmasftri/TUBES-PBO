-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2019 at 04:01 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smiati_update`
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
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `akunalumni`
--

CREATE TABLE `akunalumni` (
  `Password` varchar(30) NOT NULL,
  `NIM` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akunalumni`
--

INSERT INTO `akunalumni` (`Password`, `NIM`) VALUES
('1999-02-02', '14117002'),
('1999-02-02', '14117003'),
('1999-04-04', '14117004'),
('1999-05-05', '14117005'),
('1999-08-27', '14117046'),
('1999-01-22', '14117067'),
('1999-01-03', '14117071'),
('1999-04-04', '14117072'),
('2000-02-21', '14117086'),
('1999-01-01', '14117091');

-- --------------------------------------------------------

--
-- Table structure for table `alumni`
--

CREATE TABLE `alumni` (
  `NIM` varchar(10) NOT NULL,
  `NAMA` varchar(25) NOT NULL,
  `Tahun_Lulus` char(4) NOT NULL,
  `Tempat_KP` varchar(30) NOT NULL,
  `IPK` double NOT NULL,
  `Riwayat_Kerja` varchar(30) NOT NULL,
  `Judul_TA` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alumni`
--

INSERT INTO `alumni` (`NIM`, `NAMA`, `Tahun_Lulus`, `Tempat_KP`, `IPK`, `Riwayat_Kerja`, `Judul_TA`, `email`) VALUES
('14117002', 'Adila Gita Risnanda', '2021', 'Surabaya', 4, 'Papua', 'Sistem Parkir Online', 'adila.14117002@student.itera.ac.id'),
('14117003', 'Wahyu Wiranti', '2021', 'Wayhuwi', 3.5, 'Jati Agung', 'Perpustakaan Online', 'wahyu.14117003@student.itera.ac.id'),
('14117004', 'Fatin Delfiantina', '2021', 'Wayhuwi', 3.4, 'Jati Agung', 'Sistem Pemesanan Bus Online', 'wahyu.14117003@student.itera.ac.id'),
('14117005', 'Latisya', '2021', 'Malang', 3.7, 'Web design di Surabaya', 'Sistem manajemen asprak', 'latisya.14117005@student.itera.ac.id'),
('14117046', 'Annisa Maharani', '2021', 'Jakarta', 4, 'Programmer di Jakarta', 'Sistem Informasi Akademik', 'annisa.14117046@student.itera.ac.id'),
('14117067', 'Irma Safitri', '2021', 'Buka Lapak, Jakarta', 3.7, 'Buka Lapak, Jakarta', 'Sistem Informasi Alumni', 'irma.14117067@student.itera.ac.id'),
('14117071', 'Nurul Fauzia Azizah', '2021', 'Bandung', 4, 'Programmer di perusahaan Gojek', 'Sistem Peminjaman Ruangan', 'nurul.1411071@student.itera.ac.id'),
('14117086', 'Nurtias Rahayu', '2019', 'Shopee', 3.7, 'Shopee', 'Sistem Pembagian Kelompok', 'nurtias.14117086@student.itera.ac.id'),
('14117091', 'Hiskia Perdamen Pulungan', '2021', 'Grab, jakarta', 3, 'Grab', 'Sistem Absensi Online', 'hiskia.14117091@student.itera.ac.id');

-- --------------------------------------------------------

--
-- Table structure for table `lowongan_kerja`
--

CREATE TABLE `lowongan_kerja` (
  `nama_perusahaan` varchar(30) NOT NULL,
  `jabatan` varchar(25) NOT NULL,
  `email` varchar(40) NOT NULL,
  `alamat` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lowongan_kerja`
--

INSERT INTO `lowongan_kerja` (`nama_perusahaan`, `jabatan`, `email`, `alamat`) VALUES
('Blibli', 'Web Designers', 'customerservice@blibli.com', 'Jawa Barat'),
('Buka Lapak', 'Programmer', 'customerservice@buka-lapak.com', 'Jakarta'),
('Gojek', 'Programmer', 'customerservice@go-jek.com', 'Bandung'),
('Grab', 'Programmer', 'customerservice@grab.com', 'Jakarta'),
('JD ID', 'Web Designer', 'customerservice@jdid.com', 'Jakarta'),
('Lazada', 'Programmer', 'customerservice@lazada.com', 'Surabaya'),
('Lady Fame Shop', 'Admin Akun', 'customerservice@lf-shop.com', 'Lampung'),
('olx', 'Web Designer', 'customerservice@olx.com', 'Jawa Tengah'),
('Shopee', 'Web Designer', 'customerservice@shopee.com', 'Jakarta'),
('pt pln', 'programmer', 'customersr@pln', 'jakarta');

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
  ADD PRIMARY KEY (`NIM`),
  ADD KEY `NIM` (`NIM`);

--
-- Indexes for table `alumni`
--
ALTER TABLE `alumni`
  ADD PRIMARY KEY (`NIM`);

--
-- Indexes for table `lowongan_kerja`
--
ALTER TABLE `lowongan_kerja`
  ADD PRIMARY KEY (`email`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alumni`
--
ALTER TABLE `alumni`
  ADD CONSTRAINT `alumni_ibfk_1` FOREIGN KEY (`NIM`) REFERENCES `akunalumni` (`NIM`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
