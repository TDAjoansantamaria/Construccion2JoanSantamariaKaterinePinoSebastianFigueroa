-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2024 a las 07:13:27
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
  `medicationDosage` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `history`
--

INSERT INTO `history` (`date`, `pet`, `doctor`, `owner`, `reason`, `symptoms`, `procedures`, `medicine`, `orders`, `vaccination`, `allergy`, `details`, `diagnosis`, `medicationDosage`) VALUES
(1710649115094, 3, 56565656, 135791113, 'r1', 'r2', 'r4', 'r8', 21, 'r5', 'r7', 'r6', 'r3', '10'),
(1714882601621, 3, 56565656, 135791113, 'joan1', 'joan2', 'joana', 'joan', 28, 'ajoan', 'joan', 'ajosd', 'joan4', 'joan');

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
  `ordercancellation` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `orderhc`
--

INSERT INTO `orderhc` (`idOrder`, `idPet`, `idOwner`, `idDoctor`, `medicine`, `dateOrder`, `ordercancellation`) VALUES
(21, 3, 1017168486, 56565656, 'r8', 1710649115094, 'Active'),
(22, 3, 135791113, 56565656, 'sadf', 1714602686562, 'Aceptada'),
(23, 3, 135791113, 56565656, 'asdf', 1714604105899, 'Aceptada'),
(24, 3, 135791113, 56565656, 'qew', 1714604262234, 'Aceptada'),
(25, 3, 135791113, 56565656, 'dfs', 1714604827586, 'Aceptada'),
(26, 3, 135791113, 56565656, 'asdfa', 1714604992334, 'Aceptada'),
(27, 3, 135791113, 56565656, 'asdf', 1714878585327, 'Aceptada'),
(28, 3, 135791113, 56565656, 'joan', 1714882601621, 'Aceptada');

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
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`id`, `username`, `role`) VALUES
(224, 'katechis', 'Medico'),
(225, 'joan.santamaria', 'Administrador'),
(226, 'katechis', 'Medico'),
(227, 'katechis', 'Medico'),
(228, 'katechis', 'Medico'),
(229, 'katechis', 'Medico'),
(230, 'katechis', 'Medico'),
(231, 'katechis', 'Medico'),
(232, 'katechis', 'Medico'),
(233, 'katechis', 'Medico'),
(234, 'katechis', 'Medico'),
(235, 'katechis', 'Medico'),
(236, 'katechis', 'Medico'),
(237, 'katechis', 'Medico'),
(238, 'katechis', 'Medico'),
(239, 'katechis', 'Medico'),
(240, 'katechis', 'Medico'),
(241, 'katechis', 'Medico'),
(242, 'katechis', 'Medico'),
(243, 'katechis', 'Medico'),
(244, 'katechis', 'Medico'),
(245, 'katechis', 'Medico'),
(246, 'katechis', 'Medico'),
(247, 'katechis', 'Medico'),
(248, 'katechis', 'Medico'),
(249, 'katechis', 'Medico'),
(250, 'katechis', 'Medico'),
(251, 'katechis', 'Medico'),
(252, 'katechis', 'Medico'),
(253, 'katechis', 'Medico'),
(254, 'katechis', 'Medico'),
(255, 'katechis', 'Medico'),
(256, 'katechis', 'Medico'),
(257, 'katechis', 'Medico'),
(258, 'katechis', 'Medico'),
(259, 'katechis', 'Medico'),
(260, 'katechis', 'Medico'),
(261, 'katechis', 'Medico'),
(262, 'katechis', 'Medico'),
(263, 'katechis', 'Medico'),
(264, 'katechis', 'Medico'),
(265, 'katechis', 'Medico'),
(266, 'katechis', 'Medico'),
(267, 'katechis', 'Medico'),
(268, 'katechis', 'Medico'),
(269, 'katechis', 'Medico'),
(270, 'katechis', 'Medico'),
(271, 'katechis', 'Medico'),
(272, 'katechis', 'Medico');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`date`),
  ADD KEY `pet` (`pet`);

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
  MODIFY `idOrder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `pet`
--
ALTER TABLE `pet`
  MODIFY `idPet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=273;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `pet` FOREIGN KEY (`pet`) REFERENCES `pet` (`idPet`) ON DELETE CASCADE ON UPDATE CASCADE;

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
