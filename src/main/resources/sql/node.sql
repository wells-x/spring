
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `node`
-- ----------------------------
CREATE TABLE `users` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` char(127) NOT NULL COMMENT '姓名',
  `age` int(8) DEFAULT NULL COMMENT '年龄',
  `account` char(32) NOT NULL,
  `password` char(32) NOT NULL COMMENT '密码',
  `email` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`,`account`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf32

-- ----------------------------
--  Records of `node`
-- ----------------------------
BEGIN;
INSERT INTO `node` VALUES ('55', '林颖', '18', '女'), ('22', '刘常江', '29', '男'), ('60', '林条达', '99', '男'), ('30', '阿绿', '33', '男');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
