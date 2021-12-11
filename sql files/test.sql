-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 11, 2021 at 07:59 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
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
-- Table structure for table `assignedbooks`
--

CREATE TABLE `assignedbooks` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `bookname` varchar(100) NOT NULL,
  `returndate` varchar(100) NOT NULL,
  `bookid` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assignedbooks`
--

INSERT INTO `assignedbooks` (`id`, `name`, `bookname`, `returndate`, `bookid`) VALUES
(1, 'Eve', 'Gordon Ramsay Makes it Easy', '12/12/2021', '7');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `availability` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `name`, `genre`, `availability`) VALUES
(1, 'Harry Potter and the Prisoner of Azkaban', 'Mystery', 'Available'),
(2, 'Harry Potter and the Philosopher\'s Stone', 'Adventure', 'Available'),
(3, 'Lord of the Rings', 'Adventure', 'Available'),
(4, 'Mein Kampf', 'Autobiograpy', 'Available'),
(5, 'Anne Frank', 'Autobiography', 'Available'),
(6, 'Geronimo Stilton', 'Fiction', 'Available'),
(7, 'Gordon Ramsay Makes it Easy', 'Non-Fiction', 'Unavailable'),
(8, 'The Fault in Our Stars', 'Fiction', 'Available'),
(9, 'The Old Man and the Sea', 'Fiction', 'Available'),
(10, 'For Whom the Bell Tolls', 'Fiction', 'Available'),
(11, 'Charlie and the Chocolate Factory', 'Fiction', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `privilege` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `privilege`) VALUES
(1, 'test', '123', '2'),
(2, 'ben', 'lol', '0'),
(3, 'cbudihar', '123', '1'),
(4, 'bob', 'bobpwd', '0'),
(5, 'Alice', '123', '0'),
(6, 'Eve', '911', '2'),
(7, 'Vincent', 'vince', '0'),
(8, 'James', '4567', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignedbooks`
--
ALTER TABLE `assignedbooks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignedbooks`
--
ALTER TABLE `assignedbooks`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
