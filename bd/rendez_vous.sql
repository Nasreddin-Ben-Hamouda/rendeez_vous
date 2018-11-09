-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 03 oct. 2018 à 18:23
-- Version du serveur :  5.7.19
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `rendez_vous`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `sexe` text NOT NULL,
  `date_naiss` varchar(55) NOT NULL,
  `region` text NOT NULL,
  `num_hopital_respons` int(100) NOT NULL,
  `num_tel` int(8) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id_admin`, `nom`, `prenom`, `email`, `password`, `sexe`, `date_naiss`, `region`, `num_hopital_respons`, `num_tel`) VALUES
(6, 'oussama', 'abdelwahed', 'oussama@gmail.com', 'dfghjkldfgh', 'homme', '1544-12-12', 'bizerte', 2, 21548754),
(7, 'nasreddine', 'ben hammouda', 'nasreddine@gmail.com', 'hamzawi1996', 'homme', '1996-07-06', 'bizerte', 1, 54808062);

-- --------------------------------------------------------

--
-- Structure de la table `hopitale`
--

DROP TABLE IF EXISTS `hopitale`;
CREATE TABLE IF NOT EXISTS `hopitale` (
  `num_hopitale` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `region` text NOT NULL,
  `adresse` text NOT NULL,
  `specialite` text NOT NULL,
  PRIMARY KEY (`num_hopitale`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hopitale`
--

INSERT INTO `hopitale` (`num_hopitale`, `nom`, `region`, `adresse`, `specialite`) VALUES
(1, 'bougatfa', 'bizerte', 'rue hbib bougatfa bizerte', 'Cardiologie'),
(2, 'charnicole', 'al alia', 'rue tastour', 'Ophtalmologie'),
(3, 'al aziza othmana', 'bizerte', 'bizerte rue revolution', 'Cardiologie'),
(4, 'hbib thamer', 'Manzel bourguiba', 'rue intilanka', 'Anatomie'),
(5, 'hopital el rabta', 'Rass Rjbal', 'ru turkish', 'Neurologie'),
(6, 'hopital regional de manzel bourgiba', 'Manzel bourguiba', 'rue hbib bou rgiba', 'biochimie'),
(7, 'hassen', 'al alia', 'rue tastour el alia', 'Ophtalmologie');

-- --------------------------------------------------------

--
-- Structure de la table `medcin`
--

DROP TABLE IF EXISTS `medcin`;
CREATE TABLE IF NOT EXISTS `medcin` (
  `id_medcin` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `email` text NOT NULL,
  `region` text NOT NULL,
  `id_hopital` int(11) NOT NULL,
  `sexe` text NOT NULL,
  `date_naiss` date NOT NULL,
  `num_tel` varchar(8) NOT NULL,
  PRIMARY KEY (`id_medcin`),
  KEY `id_hopital` (`id_hopital`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medcin`
--

INSERT INTO `medcin` (`id_medcin`, `nom`, `prenom`, `email`, `region`, `id_hopital`, `sexe`, `date_naiss`, `num_tel`) VALUES
(1, 'docteur moncef', 'gandoura', 'azerty@azertyui', 'bizerte', 1, 'homme', '1982-10-10', '54789456'),
(2, ' Najwa', 'Gandoura', 'aqqsdfgh@sdfghj', 'bizerte', 2, 'femme', '1884-02-10', '21548963'),
(3, 'Samia', 'gharbi', 'qsdfghjk@sdfghj', 'al alia', 2, 'femme', '1981-05-10', '23659874'),
(4, 'Mohamed', 'ben hammouda', 'qsdfghj@qsdfgh', 'Manzel bourguiba', 4, 'homme', '1984-12-10', '54741258'),
(5, 'brahim', 'ben hamouda', 'qsdfghjk@sdfghjklm', 'Rass ejbal', 5, 'homme', '1885-10-09', '21475847'),
(6, 'donya', 'sehli', 'sdfghjkl@sdfghjkl', 'al alia', 2, 'femme', '1998-03-10', '25147258'),
(7, 'anissa', 'tlich', 'zezrtyuiol@ertyuil', 'al alia', 3, 'femme', '1982-10-11', ''),
(8, 'faten', 'lahbib', 'azertyu@sdfghjk', 'rass jbal', 5, 'femme', '1889-01-01', ''),
(9, 'radhia', 'ben hammouda', 'radhia@gmail.com', 'El alia', 2, 'femme', '1984-02-10', '21369785'),
(10, 'mahdi', 'gandoura', 'mahdi@gmail.com', 'bizerte', 1, 'homme', '1990-05-15', '54100100'),
(12, 'aymen', 'sehli', 'aymen@gmail.com', 'El Alia', 1, 'homme', '1987-05-01', '20100100');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `matricule` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `date_naiss` date NOT NULL,
  `email` text NOT NULL,
  `region` text NOT NULL,
  `num_tel` int(8) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`matricule`, `nom`, `prenom`, `date_naiss`, `email`, `region`, `num_tel`, `sexe`) VALUES
(2, 'nasreddine', 'ben hammouda', '1996-07-06', 'hamza@gmail.com', 'bizerte', 54808062, 'homme'),
(4, 'donia', 'ben hammouda', '1990-02-10', 'donia@gmail.com', 'el alia', 52100101, 'femme'),
(5, 'issam', 'ben amor ', '2010-04-23', 'issam@gmail.com', 'bizerte', 52663728, 'homme'),
(6, 'mouin', 'chala', '1544-02-06', 'chala@gmail.com', 'bizerte', 548796321, 'homme'),
(7, 'salah', 'guinoubi', '1999-04-20', 'salah@gmail.com', 'El alia', 52302294, 'homme');

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

DROP TABLE IF EXISTS `rdv`;
CREATE TABLE IF NOT EXISTS `rdv` (
  `num_rdv` int(11) NOT NULL AUTO_INCREMENT,
  `matricule_patinet` int(11) NOT NULL,
  `num_hopital` int(11) NOT NULL,
  `id_medcin` int(11) NOT NULL,
  `date_rdv` date NOT NULL,
  `time` time NOT NULL,
  `affectation` varchar(30) NOT NULL,
  `region` varchar(30) NOT NULL,
  `nature_rdv` varchar(30) NOT NULL,
  `etat` text,
  `vue_admin` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`num_rdv`),
  KEY `matricule` (`matricule_patinet`),
  KEY `num_hopitale` (`num_hopital`),
  KEY `id_medcin` (`id_medcin`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`num_rdv`, `matricule_patinet`, `num_hopital`, `id_medcin`, `date_rdv`, `time`, `affectation`, `region`, `nature_rdv`, `etat`, `vue_admin`) VALUES
(4, 2, 1, 1, '2018-05-24', '15:00:00', 'Passer', 'Bizerte', 'Cardiologie', NULL, NULL),
(15, 4, 1, 2, '2018-05-15', '10:00:00', 'En Attent', 'bizerte', 'cardiologie', 'pas encore confirmer', 'non'),
(21, 4, 1, 1, '2018-05-30', '12:00:00', 'Passer', 'El Alia', 'Cardiologie', 'confirmer', 'oui'),
(22, 2, 1, 1, '2018-10-29', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Confirmer', 'non'),
(29, 2, 2, 6, '2018-10-29', '10:00:00', 'Annuler', 'al alia', 'Ophtalmologie', 'Pas encore confirmer', 'non'),
(30, 2, 3, 7, '2018-05-29', '10:00:00', 'En Attent', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(31, 2, 2, 3, '2018-05-30', '10:00:00', 'En Attent', 'al alia', 'Ophtalmologie', 'Pas encore confirmer', 'non'),
(32, 2, 3, 7, '2018-05-30', '10:00:00', 'En Attent', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(34, 2, 1, 1, '2018-05-16', '10:00:00', 'Passer', 'bizerte', 'Cardiologie', 'confirmer', 'oui'),
(38, 2, 1, 1, '2018-05-25', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Refuser a cause du probleme de service merci de prendre un autre rendez a un autre temps', 'non'),
(41, 2, 2, 2, '2018-05-30', '10:00:00', 'En Attent', 'al alia', 'Ophtalmologie', 'Pas encore confirmer', 'non'),
(42, 2, 1, 1, '2018-05-30', '10:00:00', 'Passer', 'Bizerte', 'Cardiologie', 'Refuser a cause du probleme de service merci de prendre un autre rendez a un autre temps', 'non'),
(43, 2, 1, 1, '2018-05-30', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Confirmer', 'non'),
(44, 4, 1, 12, '2018-05-30', '10:00:00', 'Passer', 'El Alia', 'Cardiologie', 'Refuser a cause de probleme du service', 'oui'),
(47, 2, 1, 1, '2018-05-28', '15:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Confirmer', 'non'),
(48, 4, 1, 1, '2018-05-29', '10:00:00', 'Passer', 'Bizerte', 'Cardiologie', 'Refuser a cause de probleme du service', 'non'),
(49, 2, 1, 1, '2018-05-01', '10:00:00', 'Passer', 'Bizerte', 'Cardiologie', 'Confirmer', 'non'),
(50, 2, 1, 1, '2018-05-28', '10:00:00', 'En Attent', 'Bizerte', 'Cardiologie', 'Refuser a cause de probleme du service', 'non'),
(51, 2, 1, 1, '2018-05-24', '12:00:00', 'En Attent', 'El Alia', 'Cardiologie', 'confirmer', 'oui'),
(52, 6, 1, 1, '2018-02-12', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(53, 6, 1, 1, '2222-02-11', '12:22:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(54, 7, 1, 1, '2017-02-12', '14:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(55, 7, 1, 1, '2017-01-20', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(56, 7, 1, 1, '2017-12-12', '10:48:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(57, 7, 1, 1, '2017-02-12', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(58, 7, 1, 1, '2017-02-10', '11:11:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(59, 7, 1, 1, '2019-01-10', '20:15:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(60, 7, 1, 1, '2017-12-12', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(61, 7, 3, 7, '2017-12-20', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(62, 7, 1, 1, '2019-01-10', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(63, 7, 1, 1, '2018-11-11', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(64, 7, 1, 1, '2018-09-12', '10:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(65, 7, 1, 1, '2018-09-10', '10:00:00', 'En Attent', 'Bizerte', 'Cardiologie', 'Refuser a cause de probleme du service', 'non'),
(66, 7, 1, 1, '1111-11-22', '12:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non'),
(67, 7, 1, 12, '1111-11-22', '12:00:00', 'Annuler', 'Bizerte', 'Cardiologie', 'Pas encore confirmer', 'non');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `medcin`
--
ALTER TABLE `medcin`
  ADD CONSTRAINT `medcin_ibfk_1` FOREIGN KEY (`id_hopital`) REFERENCES `hopitale` (`num_hopitale`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `rdv_ibfk_1` FOREIGN KEY (`matricule_patinet`) REFERENCES `patient` (`matricule`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rdv_ibfk_2` FOREIGN KEY (`num_hopital`) REFERENCES `hopitale` (`num_hopitale`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rdv_ibfk_3` FOREIGN KEY (`id_medcin`) REFERENCES `medcin` (`id_medcin`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
