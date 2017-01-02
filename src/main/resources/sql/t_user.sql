/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2017-01-02 18:54:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) DEFAULT NULL,
  `userBirth` date DEFAULT NULL,
  `userEmail` varchar(200) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'root', '2016-12-01', '11111@qq.com', '63a9f0ea7bb98050796b649e85481845', '张三丰');
INSERT INTO `t_user` VALUES ('2', '123456', '2016-12-27', '22222@163.com', '63a9f0ea7bb98050796b649e85481845', '杨过');
INSERT INTO `t_user` VALUES ('3', '888888', '2010-06-15', '33333@126.com', '63a9f0ea7bb98050796b649e85481845', '小龙女');
