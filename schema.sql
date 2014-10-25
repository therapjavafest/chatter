CREATE TABLE IF NOT EXISTS `users` (
  `id`            INT         NOT NULL AUTO_INCREMENT,
  `first_name`    VARCHAR(20) NOT NULL,
  `last_name`     VARCHAR(20) NOT NULL,
  `email_address` VARCHAR(30) NOT NULL,
  `password`      VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`email_address`)
);

CREATE TABLE IF NOT EXISTS chatters (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  chatter_text VARCHAR(140) NOT NULL,
  created      DATETIME     NOT NULL,
  created_by   INT          NOT NULL,
  CONSTRAINT fk_created_by FOREIGN KEY (created_by) REFERENCES users (id)
);