-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Nov 2019 pada 02.44
-- Versi server: 10.1.34-MariaDB
-- Versi PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gaspol_tubes`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nip` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `dosen`
--

CREATE TABLE `dosen` (
  `id` int(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `id_keahlian` int(10) NOT NULL,
  `kode_dosen` varchar(10) NOT NULL,
  `nip` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dosen`
--

INSERT INTO `dosen` (`id`, `nama`, `email`, `id_keahlian`, `kode_dosen`, `nip`) VALUES
(6866, 'Mina Marvin', 'qcremin@hotmail.com', 5, 'xkso', '43'),
(8515, 'Tanner Welch III', 'lempi89@hotmail.com', 5, 'ilmn', '96'),
(749143, 'Dr. Nicola Towne PhD', 'taryn06@hotmail.com', 5, 'nmyz', '887614625'),
(17, 'Cleta Considine Sr.', 'madalyn19@hermanlangworth.com', 4, 'izfw', '86609976'),
(581784530, 'Marlene Robel', 'osmitham@parisian.biz', 3, 'qhqf', '103548'),
(356, 'Alverta Walsh', 'geoffrey97@hotmail.com', 8, 'sfpq', ''),
(98619136, 'Eden Koelpin', 'hills.alexandro@pacocha.org', 2, 'witi', '9071'),
(1006903, 'Emmie Weimann IV', 'river.oberbrunner@hotmail.com', 5, 'muis', '72314'),
(36916, 'Jaime Runolfsdottir', 'fred20@hotmail.com', 1, 'bxfi', '87964'),
(956, 'Francesco Moen', 'dax88@gmail.com', 9, 'pvim', '261563'),
(325, 'Florida Welch', 'genevieve97@yahoo.com', 4, 'qoqj', '888592'),
(726, 'Mozelle Dicki', 'herman.lauriane@gmail.com', 9, 'jmoj', '48972'),
(78559, 'Mona Upton', 'jacobi.ceasar@oconnell.com', 1, 'vrup', '5'),
(20, 'Miss Felicita Emard Jr.', 'mdicki@hotmail.com', 6, 'xysd', '8'),
(3204481, 'Keeley Cormier', 'adrain.davis@hotmail.com', 8, 'iqcu', '26'),
(56827, 'Dr. Estella Prohaska', 'wilhelmine.buckridge@daugherty.com', 5, 'pedy', '43'),
(68, 'Hester Kerluke', 'walsh.llewellyn@gmail.com', 4, 'inrn', '8191'),
(8397827, 'Hollis Corkery IV', 'shields.carol@kilbackbartell.com', 7, 'sahg', '7'),
(345302, 'Ms. Deja Franecki I', 'pollich.buddy@stiedemannwyman.com', 6, 'qsca', ''),
(0, 'Kurtis Grant', 'mccullough.jacinto@roberts.biz', 8, 'phwh', '258972347');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal_mengajar_dosen`
--

CREATE TABLE `jadwal_mengajar_dosen` (
  `id` int(10) NOT NULL,
  `jam_mulai` time NOT NULL,
  `jam_selesai` time NOT NULL,
  `hari_ke` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal_sidang`
--

CREATE TABLE `jadwal_sidang` (
  `id` int(10) NOT NULL,
  `jam_mulai` time NOT NULL,
  `jam_selesai` time NOT NULL,
  `tanggal` date NOT NULL,
  `id_mhs` int(10) NOT NULL,
  `id_dosbing1` int(10) NOT NULL,
  `id_dosbing2` int(10) NOT NULL,
  `id_penguji1` int(10) NOT NULL,
  `id_penguji2` int(10) NOT NULL,
  `id_ruang` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `keahlian`
--

CREATE TABLE `keahlian` (
  `id` int(10) NOT NULL,
  `nama_keahlian` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `id_keahlian` int(10) NOT NULL,
  `nim` char(10) NOT NULL,
  `judul_pa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `ruangan`
--

CREATE TABLE `ruangan` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `jadwal_mengajar_dosen`
--
ALTER TABLE `jadwal_mengajar_dosen`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `jadwal_sidang`
--
ALTER TABLE `jadwal_sidang`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `keahlian`
--
ALTER TABLE `keahlian`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `keahlian`
--
ALTER TABLE `keahlian`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `ruangan`
--
ALTER TABLE `ruangan`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
