-- db_bankabc_credit.credit definition

CREATE TABLE `credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardnumber` varchar(100) DEFAULT NULL,
  `cardtype` varchar(100) DEFAULT NULL,
  `customercode` varchar(100) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `card_type` varchar(255) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;