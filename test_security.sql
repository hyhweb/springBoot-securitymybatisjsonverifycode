/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : 127.0.0.1:3306
Source Database       : test_security

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2020-06-22 15:46:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission`;
CREATE TABLE `t_sys_permission` (
  `permission_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permission_name` varchar(20) NOT NULL COMMENT '权限名称',
  `permission_code` varchar(20) NOT NULL COMMENT '权限编码',
  PRIMARY KEY (`permission_id`),
  KEY `permission_name_index` (`permission_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_permission
-- ----------------------------
INSERT INTO `t_sys_permission` VALUES ('1', '添加', 'add');

-- ----------------------------
-- Table structure for t_sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission_role`;
CREATE TABLE `t_sys_permission_role` (
  `permission_role_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '权限角色ID',
  `permission_id` bigint(10) NOT NULL COMMENT '权限ID',
  `role_id` bigint(10) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`permission_role_id`),
  KEY `permission_id_index` (`permission_id`),
  KEY `role_id_index` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_permission_role
-- ----------------------------
INSERT INTO `t_sys_permission_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `name_text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', 'ROLE_dba', '数据库管理员');
INSERT INTO `t_sys_role` VALUES ('2', 'ROLE_admin', '管理员');
INSERT INTO `t_sys_role` VALUES ('3', 'ROLE_user', '用户');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `locked` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'hong', '123456', '1', '0');
INSERT INTO `t_sys_user` VALUES ('3', '11', '11', '1', '0');
INSERT INTO `t_sys_user` VALUES ('4', '22', '22', '1', '0');
INSERT INTO `t_sys_user` VALUES ('6', '123', '297254e9bfe0b8f39c682eda30bb9be0', '1', '0');
INSERT INTO `t_sys_user` VALUES ('7', '111', 'd89267ba6e888426c8f798a04f2fb874', '1', '0');
INSERT INTO `t_sys_user` VALUES ('8', '222', '7165e4fbb0b73542dc2ba357e802f880', '1', '0');
INSERT INTO `t_sys_user` VALUES ('9', '333', '13e1feb08766fedbf1a692aa9fb97984', '1', '0');
INSERT INTO `t_sys_user` VALUES ('10', '777', '783ab3e2d02f5c8a654111b2e064d52d', '1', '0');
INSERT INTO `t_sys_user` VALUES ('11', '888', '$2a$10$xTL9QJHCaslb2hVDTuub7ucseMR7P37gB3DeGqCGo9F3WJSrXhHye', '1', '0');
INSERT INTO `t_sys_user` VALUES ('12', '1212', '$2a$10$kv1BUQOh6BYeSuazfUZWY.v1Oo6MDGr9.vUX1lgBbpry0ZPKzAov6', '1', '0');

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT 'user_id',
  `role_id` bigint(20) NOT NULL COMMENT 'role_id',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('2', '12', '1');
