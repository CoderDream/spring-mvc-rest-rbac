/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50146
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50146
File Encoding         : 65001

Date: 2017-07-20 19:33:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_organization_parent_id` (`parent_id`),
  KEY `idx_sys_organization_parent_ids` (`parent_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
INSERT INTO `sys_organization` VALUES ('1', '总公司', '0', '0/', '1');
INSERT INTO `sys_organization` VALUES ('2', '分公司1', '1', '0/1/', '1');
INSERT INTO `sys_organization` VALUES ('3', '分公司2', '1', '0/1/', '1');
INSERT INTO `sys_organization` VALUES ('4', '分公司11', '2', '0/1/2/', '1');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_resource_parent_id` (`parent_id`),
  KEY `idx_sys_resource_parent_ids` (`parent_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '资源', 'menu', '', '0', '0/', '', '1');
INSERT INTO `sys_resource` VALUES ('11', '组织机构管理', 'menu', '/organization', '1', '0/1/', 'organization:*', '1');
INSERT INTO `sys_resource` VALUES ('12', '组织机构新增', 'button', '', '11', '0/1/11/', 'organization:create', '1');
INSERT INTO `sys_resource` VALUES ('13', '组织机构修改', 'button', '', '11', '0/1/11/', 'organization:update', '1');
INSERT INTO `sys_resource` VALUES ('14', '组织机构删除', 'button', '', '11', '0/1/11/', 'organization:delete', '1');
INSERT INTO `sys_resource` VALUES ('15', '组织机构查看', 'button', '', '11', '0/1/11/', 'organization:view', '1');
INSERT INTO `sys_resource` VALUES ('21', '用户管理', 'menu', '/user', '1', '0/1/', 'user:*', '1');
INSERT INTO `sys_resource` VALUES ('22', '用户新增', 'button', '', '21', '0/1/21/', 'user:create', '1');
INSERT INTO `sys_resource` VALUES ('23', '用户修改', 'button', '', '21', '0/1/21/', 'user:update', '1');
INSERT INTO `sys_resource` VALUES ('24', '用户删除', 'button', '', '21', '0/1/21/', 'user:delete', '1');
INSERT INTO `sys_resource` VALUES ('25', '用户查看', 'button', '', '21', '0/1/21/', 'user:view', '1');
INSERT INTO `sys_resource` VALUES ('31', '资源管理', 'menu', '/resource', '1', '0/1/', 'resource:*', '1');
INSERT INTO `sys_resource` VALUES ('32', '资源新增', 'button', '', '31', '0/1/31/', 'resource:create', '1');
INSERT INTO `sys_resource` VALUES ('33', '资源修改', 'button', '', '31', '0/1/31/', 'resource:update', '1');
INSERT INTO `sys_resource` VALUES ('34', '资源删除', 'button', '', '31', '0/1/31/', 'resource:delete', '1');
INSERT INTO `sys_resource` VALUES ('35', '资源查看', 'button', '', '31', '0/1/31/', 'resource:view', '1');
INSERT INTO `sys_resource` VALUES ('41', '角色管理', 'menu', '/role', '1', '0/1/', 'role:*', '1');
INSERT INTO `sys_resource` VALUES ('42', '角色新增', 'button', '', '41', '0/1/41/', 'role:create', '1');
INSERT INTO `sys_resource` VALUES ('43', '角色修改', 'button', '', '41', '0/1/41/', 'role:update', '1');
INSERT INTO `sys_resource` VALUES ('44', '角色删除', 'button', '', '41', '0/1/41/', 'role:delete', '1');
INSERT INTO `sys_resource` VALUES ('45', '角色查看', 'button', '', '41', '0/1/41/', 'role:view', '1');
INSERT INTO `sys_resource` VALUES ('51', '会话管理', 'menu', '/sessions', '1', '0/1/', 'session:*', '1');
INSERT INTO `sys_resource` VALUES ('61', '任务管理', 'menu', '/task', '1', '0/1/', 'task:*', '1');
INSERT INTO `sys_resource` VALUES ('62', '任务新增', 'button', null, '61', '0/1/61/', 'task:create', '1');
INSERT INTO `sys_resource` VALUES ('63', '任务修改', 'button', null, '61', '0/1/61/', 'task:update', '1');
INSERT INTO `sys_resource` VALUES ('64', '任务删除', 'button', null, '61', '0/1/61/', 'task:delete', '1');
INSERT INTO `sys_resource` VALUES ('65', '任务查看', 'button', null, '61', '0/1/61/', 'task:view', '1');
INSERT INTO `sys_resource` VALUES ('66', '人力管理', 'menu', '/profile', '1', '0/1/', 'profile:*', '1');
INSERT INTO `sys_resource` VALUES ('67', '人力新增', 'button', null, '66', '0/1/66/', 'profile:create', '1');
INSERT INTO `sys_resource` VALUES ('68', '人力修改', 'button', null, '66', '0/1/66/', 'profile:update', '1');
INSERT INTO `sys_resource` VALUES ('69', '人力删除', 'button', null, '66', '0/1/66/', 'profile:delete', '1');
INSERT INTO `sys_resource` VALUES ('70', '人力查看', 'button', null, '66', '0/1/66/', 'profile:view', '1');
INSERT INTO `sys_resource` VALUES ('71', '项目评价管理', 'menu', '/projecteval', '1', '0/1/', 'projecteval:*', '1');
INSERT INTO `sys_resource` VALUES ('72', '项目评价新增', 'button', null, '71', '0/1/71/', 'projecteval:create', '1');
INSERT INTO `sys_resource` VALUES ('73', '项目评价修改', 'button', null, '71', '0/1/71/', 'projecteval:update', '1');
INSERT INTO `sys_resource` VALUES ('74', '项目评价删除', 'button', null, '71', '0/1/71/', 'projecteval:delete', '1');
INSERT INTO `sys_resource` VALUES ('75', '项目评价查看', 'button', null, '71', '0/1/71/', 'projecteval:view', '1');
INSERT INTO `sys_resource` VALUES ('76', '人力评价管理', 'menu', '/profileeval', '1', '0/1/', 'profileeval:*', '1');
INSERT INTO `sys_resource` VALUES ('77', '人力评价新增', 'button', null, '76', '0/1/76/', 'profileeval:create', '1');
INSERT INTO `sys_resource` VALUES ('78', '人力评价修改', 'button', null, '76', '0/1/76/', 'profileeval:update', '1');
INSERT INTO `sys_resource` VALUES ('79', '人力评价删除', 'button', null, '76', '0/1/76/', 'profileeval:delete', '1');
INSERT INTO `sys_resource` VALUES ('80', '人力评价查看', 'button', null, '76', '0/1/76/', 'profileeval:view', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `resource_ids` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_role_resource_ids` (`resource_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', '11,21,31,41,51', '1');
INSERT INTO `sys_role` VALUES ('2', 'normal', '普通员工', '65,68,70,75,80', '1');
INSERT INTO `sys_role` VALUES ('3', 'pm', '项目经理', '61,70,71,80', '1');
INSERT INTO `sys_role` VALUES ('4', 'tm', '团队经理', '65,70,75,76', '1');
INSERT INTO `sys_role` VALUES ('5', 'rm', '部门经理', '65,70,75,76', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `organization_id` bigint(20) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `role_ids` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`),
  KEY `idx_sys_user_organization_id` (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '0');
INSERT INTO `sys_user` VALUES ('2', '1', 'B-28709', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '2', '0');
INSERT INTO `sys_user` VALUES ('3', '1', 'B-26050', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '3', '0');
INSERT INTO `sys_user` VALUES ('4', '1', 'B-22341', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '4', '0');
INSERT INTO `sys_user` VALUES ('5', '1', 'B-26026', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '5', '0');
SET FOREIGN_KEY_CHECKS=1;
