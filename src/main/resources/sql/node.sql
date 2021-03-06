CREATE DATABASE java;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `account`
-- ----------------------------

CREATE TABLE `users`
(
    `id`          int(16)   NOT NULL AUTO_INCREMENT,
    `name`        char(127) NOT NULL COMMENT '姓名',
    `age`         int(8)             DEFAULT NULL COMMENT '年龄',
    `account`     char(32)  NOT NULL,
    `password`    char(32)  NOT NULL COMMENT '密码',
    `email`       char(255)          DEFAULT NULL,
    `create_time` datetime  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`, `name`, `account`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 21
  DEFAULT CHARSET = utf32;

