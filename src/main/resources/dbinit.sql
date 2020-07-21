CREATE DATABASE `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `test`.`person`
(`id`,
`name`,
`phone`)
VALUES
(1,
'sugondo',
'08190101101');