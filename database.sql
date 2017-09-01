
CREATE DATABASE IF NOT EXISTS `concretepage` ;
USE `concretepage`;

CREATE TABLE IF NOT EXISTS `articles` (
  `article_id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;

INSERT INTO `articles` (`article_id`, `title`, `category`) VALUES
	(101, 'Angular 2 Tutorial using CLI', 'Angular'),
	(102, 'Spring Boot Getting Started', 'Spring Boot'),
	(103, 'Lambda Expressions Java 8 Example', 'Java 8'),
	(104, 'Android AsyncTask Example', 'Android'); 