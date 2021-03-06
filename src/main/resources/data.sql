INSERT INTO transaction_category VALUES (1, 'BALANCE', 'Requested balance');
INSERT INTO transaction_category VALUES (2, 'WITHDRAWAL', 'Performed withdrawal');
INSERT INTO transaction_category VALUES (3, 'INCOME', 'Received income');
INSERT INTO transaction_category VALUES (4, 'OTHER', 'Other operation');

INSERT INTO authorities VALUES (1, 'externalUser', 'ROLE_USER');
INSERT INTO authorities VALUES (2, '0000000000000000', 'ROLE_USER');
INSERT INTO authorities VALUES (3, '1111111111111111', 'ROLE_USER');

-- User pass: 1111
INSERT INTO users
VALUES (1, '2222222222222222', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', 1000, TRUE, 1, 0);
INSERT INTO users
VALUES (2, '0000000000000000', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', 1300, TRUE, 1, 0);
INSERT INTO users
VALUES (3, '1111111111111111', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', 400, TRUE, 1, 0);
INSERT INTO users
VALUES (4, '3333333333333333', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', 800, FALSE, 1, 0);

INSERT INTO account_transaction VALUES (1, CURRENT_TIMESTAMP(), 1000, NULL, 3, 1);
INSERT INTO account_transaction VALUES (2, CURRENT_TIMESTAMP(), 1300, NULL, 3, 2);
INSERT INTO account_transaction VALUES (3, CURRENT_TIMESTAMP(), 400, NULL, 3, 3);
INSERT INTO account_transaction VALUES (4, CURRENT_TIMESTAMP(), 800, NULL, 3, 4);
