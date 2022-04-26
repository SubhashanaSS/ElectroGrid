-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2022 at 06:58 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `consumptions`
--

CREATE TABLE `consumptions` (
  `ConsumptionID` int(5) NOT NULL,
  `CustomerName` varchar(255) NOT NULL,
  `CustomerUsage` varchar(255) NOT NULL,
  `Price` varchar(255) NOT NULL,
  `CustomerType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `consumptions`
--

INSERT INTO `consumptions` (`ConsumptionID`, `CustomerName`, `CustomerUsage`, `Price`, `CustomerType`) VALUES
(2, 'Subhashana', '40 units', '400', 'Platinum'),
(3, 'Prabhavi', '21 units', '210', 'Silver'),
(4, 'Supun', '21 units', '210', 'Silver');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `CustomerID` int(5) NOT NULL,
  `CustomerName` varchar(255) NOT NULL,
  `CustomerAddress` varchar(255) NOT NULL,
  `CustomerEmail` varchar(255) NOT NULL,
  `CustomerContact` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CustomerID`, `CustomerName`, `CustomerAddress`, `CustomerEmail`, `CustomerContact`) VALUES
(1, 'Sam', 'Kaduwela,Malabe', 'Sam@gmail.com', '0771234567'),
(3, 'Jake', '3rd Lane,Rajagiriya', 'jake.n@gmail.com', '0771256741'),
(5, 'Subhashana', 'Kurupita', 'subhashana@gmail.com', '0776543211');

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

CREATE TABLE `feedbacks` (
  `FeedbackID` int(5) NOT NULL,
  `CustomerName` varchar(255) NOT NULL,
  `CustomerEmail` varchar(90) NOT NULL,
  `Rate` varchar(1) NOT NULL,
  `FeedbackNotes` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedbacks`
--

INSERT INTO `feedbacks` (`FeedbackID`, `CustomerName`, `CustomerEmail`, `Rate`, `FeedbackNotes`) VALUES
(1, 'Isiwarani', 'ishi@gmail.com', '5', 'Elec'),
(2, 'Supun', 'supun@gmail.com', '1', 'worst');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `PaymentID` int(5) NOT NULL,
  `Amount` varchar(255) NOT NULL,
  `PaymentCardNo` varchar(255) NOT NULL,
  `PaymentType` varchar(255) NOT NULL,
  `PaymentDate` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`PaymentID`, `Amount`, `PaymentCardNo`, `PaymentType`, `PaymentDate`) VALUES
(1, '3500', '1234450987', 'Visa', '2022-04-19'),
(2, '4500', '1232222123', 'Amex', '2022-04-20');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `SupplierID` int(5) NOT NULL,
  `SupplierName` varchar(255) NOT NULL,
  `SupplySize` varchar(255) NOT NULL,
  `EnergyType` varchar(255) NOT NULL,
  `SupplierStatus` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`SupplierID`, `SupplierName`, `SupplySize`, `EnergyType`, `SupplierStatus`) VALUES
(1, 'LECO', '10MWh', 'wind', 'Active'),
(5, 'Apower', '6MWh', 'Diesel', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consumptions`
--
ALTER TABLE `consumptions`
  ADD PRIMARY KEY (`ConsumptionID`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD PRIMARY KEY (`FeedbackID`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`SupplierID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consumptions`
--
ALTER TABLE `consumptions`
  MODIFY `ConsumptionID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `CustomerID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `feedbacks`
--
ALTER TABLE `feedbacks`
  MODIFY `FeedbackID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `PaymentID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `SupplierID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
