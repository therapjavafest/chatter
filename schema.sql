CREATE TABLE IF NOT EXISTS `User` (
  `id`            INT         NOT NULL AUTO_INCREMENT,
  `first_name`    VARCHAR(20) NOT NULL,
  `last_name`     VARCHAR(20) NOT NULL,
  `email_address` VARCHAR(30) NOT NULL,
  `password`      VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`email_address`)
)