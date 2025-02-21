CREATE TABLE db_bankABC_wallet.wallet (
	id INTEGER auto_increment NOT NULL,
	account varchar(100) NULL,
	description varchar(100) NULL,
	mount DOUBLE NULL,
	key (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;
