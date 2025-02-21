
-- "db_bankABC_Account".account definition

-- Drop table

-- DROP TABLE "db_bankABC_Account".account;

CREATE TABLE "db_bankABC_Account".account (
	id int NOT NULL,
	accountnumber varchar NULL,
	minimumbalance numeric NULL,
	currentbalance numeric NULL,
	interestrate numeric NULL
);
