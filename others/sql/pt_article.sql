/*
Navicat MySQL Data Transfer

Source Server         : localmysql
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : peopletimes

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2015-12-31 18:09:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pt_article
-- ----------------------------
DROP TABLE IF EXISTS `pt_article`;
CREATE TABLE `pt_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(100) DEFAULT NULL COMMENT '摘要标题',
  `abstractText` varchar(512) DEFAULT NULL COMMENT '文章摘要',
  `imageUrl` varchar(1024) DEFAULT NULL,
  `type` int(3) NOT NULL,
  `contentTitle` varchar(100) DEFAULT NULL COMMENT '文章标题',
  `content` text,
  `author` varchar(128) DEFAULT NULL COMMENT '文章作者',
  `linkurl` varchar(1024) DEFAULT NULL,
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态：1可用，0不可用',
  `creator` varchar(64) NOT NULL,
  `prior` int(11) DEFAULT NULL,
  `publishtime` datetime DEFAULT NULL,
  `addtime` datetime NOT NULL,
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pt_article
-- ----------------------------
INSERT INTO `pt_article` VALUES ('1', '吃货ab', '这是一段总共一百四十字的摘要这是一段总共一百四十字的摘要这是一段总共一百四十字的摘要这是一段总共一百四十字的摘要这是一段总共一百四十字的摘要这是一段总共一百四十字的摘要这是一段总共一百四十字的摘要这是一段总共一百四十字的摘要这是一段总共一百四十字的摘要这是一段总共一百四十字的摘要', '/resource/img/abstract_zuhai_jiang20151227_214942_084.jpg', '1', '卢卡斯与星球大战', '从前有个人。。。\n<img src=\'/resource/img/articlecontent_zuhai_jiang20151228_220008_433.jpg\' />', '蕊姐', 'xxxx', '2', '姜祖海', null, '2015-12-24 00:00:00', '2015-12-24 00:00:00', '2015-12-24 21:48:58');
INSERT INTO `pt_article` VALUES ('2', '庄子', '北冥有鱼', '/resource/img/abstract_zuhai_jiang20151228_221408_814.jpg', '1', null, null, null, null, '2', 'zuhai.jiang', null, null, '2015-12-28 22:22:33', '2015-12-28 22:22:33');
