CREATE TABLE transaction_category (
  id                   INT PRIMARY KEY AUTO_INCREMENT,
  category_name        VARCHAR(50),
  category_description VARCHAR(255)
);

CREATE TABLE authorities (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  username  VARCHAR(100),
  authority VARCHAR(100)
);

CREATE TABLE users (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  username     VARCHAR(100),
  password     VARCHAR(255),
  balance      INT NOT NULL,
  enabled      BOOLEAN,
  id_authority INT NOT NULL,
  failed_password_attempts INT,
  FOREIGN KEY (id_authority) REFERENCES authorities (id)
);

CREATE TABLE account_transaction (
  id                      INT PRIMARY KEY AUTO_INCREMENT,
  transaction_date        TIMESTAMP,
  amount                  INT NOT NULL,
  note                    VARCHAR(255),
  transaction_category_id INT NOT NULL,
  user_id                 INT NOT NULL,
  FOREIGN KEY (transaction_category_id) REFERENCES transaction_category (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);