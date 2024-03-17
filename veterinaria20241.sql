-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-03-2024 a las 07:08:47
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinaria20241`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `history`
--

CREATE TABLE `history` (
  `date` bigint(20) NOT NULL,
  `pet` int(11) NOT NULL,
  `doctor` bigint(20) NOT NULL,
  `owner` bigint(20) NOT NULL,
  `reason` text NOT NULL,
  `symptoms` text NOT NULL,
  `procedures` varchar(30) NOT NULL,
  `medicine` varchar(30) NOT NULL,
  `orders` int(11) NOT NULL,
  `vaccination` text NOT NULL,
  `allergy` text NOT NULL,
  `details` text NOT NULL,
  `diagnosis` varchar(30) NOT NULL,
  `medicationDosage` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `history`
--

INSERT INTO `history` (`date`, `pet`, `doctor`, `owner`, `reason`, `symptoms`, `procedures`, `medicine`, `orders`, `vaccination`, `allergy`, `details`, `diagnosis`, `medicationDosage`) VALUES
(1710649115094, 3, 56565656, 1017168486, 'r1', 'r2', 'r4', 'r8', 21, 'r5', 'r7', 'r6', 'r3', '10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `idOrder` bigint(20) NOT NULL,
  `pet` int(11) NOT NULL,
  `owner` bigint(20) NOT NULL,
  `productName` varchar(30) NOT NULL,
  `value` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `invoiceDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orderhc`
--

CREATE TABLE `orderhc` (
  `idOrder` int(11) NOT NULL,
  `idPet` int(11) NOT NULL,
  `idOwner` bigint(20) NOT NULL,
  `idDoctor` bigint(20) NOT NULL,
  `medicine` varchar(30) NOT NULL,
  `dateOrder` bigint(30) NOT NULL,
  `ordercancellation` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `orderhc`
--

INSERT INTO `orderhc` (`idOrder`, `idPet`, `idOwner`, `idDoctor`, `medicine`, `dateOrder`, `ordercancellation`) VALUES
(21, 3, 1017168486, 56565656, 'r8', 1710649115094, 'Active');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `idPerson` bigint(11) NOT NULL,
  `fullName` varchar(30) NOT NULL,
  `age` int(3) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`idPerson`, `fullName`, `age`, `username`, `password`, `role`) VALUES
(56788, 'Daniel Perez', 23, 'dani2', '123456', 'Medico'),
(7654321, 'Sebastian Figueroa', 19, 'sebast2024', '12345', 'Vendedor'),
(9753135, 'Alfonso Tabares', 45, 'alfonsito', '9876', 'Medico'),
(56565656, 'Kate Chismosa', 65, 'katechis', '9876', 'Medico'),
(135791113, 'Natazha Santamaria', 5, '', '', 'Propietario'),
(1017168486, 'Joan Santamaria', 30, 'joan.santamaria', '12345', 'Administrador'),
(1035421888, 'liza gonzalez', 30, 'liza.gonzalez', '12345', 'Vendedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pet`
--

CREATE TABLE `pet` (
  `idPet` int(11) NOT NULL,
  `IdOwner` bigint(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  `breed` varchar(10) NOT NULL,
  `species` varchar(10) NOT NULL,
  `characteristics` text NOT NULL,
  `weight` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pet`
--

INSERT INTO `pet` (`idPet`, `IdOwner`, `name`, `age`, `breed`, `species`, `characteristics`, `weight`) VALUES
(3, 135791113, 'Natazha', 4, 'Gatuna', 'Gato', 'gris - pequeño', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`date`);

--
-- Indices de la tabla `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `factura_mascota` (`pet`),
  ADD KEY `factura_propietario` (`owner`);

--
-- Indices de la tabla `orderhc`
--
ALTER TABLE `orderhc`
  ADD PRIMARY KEY (`idOrder`),
  ADD KEY `orden_mascota` (`idPet`),
  ADD KEY `orden_propietario` (`idOwner`),
  ADD KEY `orden_veterinario` (`idDoctor`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idPerson`);

--
-- Indices de la tabla `pet`
--
ALTER TABLE `pet`
  ADD PRIMARY KEY (`idPet`),
  ADD KEY `propietario` (`IdOwner`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `orderhc`
--
ALTER TABLE `orderhc`
  MODIFY `idOrder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `pet`
--
ALTER TABLE `pet`
  MODIFY `idPet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=224;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `factura_mascota` FOREIGN KEY (`pet`) REFERENCES `pet` (`idPet`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_propietario` FOREIGN KEY (`owner`) REFERENCES `person` (`idPerson`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pet`
--
ALTER TABLE `pet`
  ADD CONSTRAINT `pet_ibfk_1` FOREIGN KEY (`IdOwner`) REFERENCES `person` (`idPerson`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
