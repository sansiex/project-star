/*
Navicat MySQL Data Transfer

Source Server         : localmysql
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : peopletimes

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2015-12-31 18:09:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pt_admin_login_info
-- ----------------------------
DROP TABLE IF EXISTS `pt_admin_login_info`;
CREATE TABLE `pt_admin_login_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `role` int(2) NOT NULL DEFAULT '0' COMMENT '用户类型',
  `password` varchar(32) NOT NULL COMMENT '加密后密码',
  `salt` varchar(10) NOT NULL COMMENT '加密干扰项',
  `addtime` datetime NOT NULL COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '上次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pt_admin_login_info
-- ----------------------------
INSERT INTO `pt_admin_login_info` VALUES ('1', 'zuhai.jiang', '0', 'b37b35a4367932c8e178dbc74b219ccf', '234534', '2015-12-27 00:00:00', '2015-12-27 21:01:22');
INSERT INTO `pt_admin_login_info` VALUES ('2', 'menghao.wang', '0', '332675f560229ce1afdae2f8c2c822a3', '356323', '2015-12-27 00:00:00', '2015-12-27 21:01:42');
INSERT INTO `pt_admin_login_info` VALUES ('3', 'hemei.wang', '0', '3cf23a0c1096635b51ab37fe2af38059', '2111234', '2015-12-27 00:00:00', '2015-12-27 21:01:56');
