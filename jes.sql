/*
Navicat MySQL Data Transfer

Source Server         : docker
Source Server Version : 50721
Source Host           : 192.168.165.3:3306
Source Database       : jes

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-28 17:35:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` char(1) DEFAULT NULL COMMENT '区域类型',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of sys_area
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `code` varchar(100) NOT NULL COMMENT '代码',
  `type` varchar(100) NOT NULL COMMENT '类型(分类/项目)',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父级编号',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `domain_id` varchar(64) NOT NULL COMMENT '所属域',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`code`),
  KEY `sys_dict_label` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('bd08e8b1-0981-491d-a318-b8fbda67333d', '是否', 'YES_NO', '0', '是/否', '0', '0', 'admin', '2018-04-28 16:49:45', 'admin', '2018-04-28 16:49:45', null, 'd926086b-bdb9-4e9f-af4e-e960523e9427');
INSERT INTO `sys_dict` VALUES ('f463c9e4-a7b0-48dd-b2ab-6ac623b9585f', '字典类型', 'DIC_TYPE', '0', '字典类型，目录，节点', '0', '0', 'admin', '2018-04-28 16:52:28', 'admin', '2018-04-28 16:52:28', null, 'd926086b-bdb9-4e9f-af4e-e960523e9427');

-- ----------------------------
-- Table structure for sys_domain
-- ----------------------------
DROP TABLE IF EXISTS `sys_domain`;
CREATE TABLE `sys_domain` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `home_page` varchar(255) DEFAULT NULL COMMENT '地址',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否可用',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `sys_role_enname` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='域（子系统）表';

-- ----------------------------
-- Records of sys_domain
-- ----------------------------
INSERT INTO `sys_domain` VALUES ('04dbbae9-5fdf-45c4-a6a9-cecfd25e8735', '标准化种植', '4', '', '1', 'admin', '2018-04-19 17:42:27', 'admin', '2018-04-19 17:42:27', '');
INSERT INTO `sys_domain` VALUES ('51deaa68-df77-4f31-bf8c-51f0a01dfc1c', '区块链', '5', '', '1', 'admin', '2018-04-19 17:42:44', 'admin', '2018-04-19 17:42:44', '');
INSERT INTO `sys_domain` VALUES ('5a3a051c-e90a-4059-9ad4-672d64a4ef05', '价格体系', '3', '', '1', 'admin', '2018-04-11 11:05:29', 'admin', '2018-04-19 17:42:14', '');
INSERT INTO `sys_domain` VALUES ('c76b0455-674e-4b98-bb64-74573fc4e4b5', '市政桥涵', '6', '', '1', 'admin', '2018-04-19 17:43:09', 'admin', '2018-04-19 17:43:09', '');
INSERT INTO `sys_domain` VALUES ('d03cd0ad-c773-43d0-a88d-6e6defac49e3', '物联网平台', '2', '', '1', 'admin', '2018-04-11 11:04:50', 'admin', '2018-04-19 17:39:26', '');
INSERT INTO `sys_domain` VALUES ('d926086b-bdb9-4e9f-af4e-e960523e9427', '系统管理', '11', 'localhost:8081', '1', 'admin', '2018-04-10 11:28:00', 'admin', '2018-04-28 14:47:09', null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `type` char(1) DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `exception` text COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_mdict
-- ----------------------------
DROP TABLE IF EXISTS `sys_mdict`;
CREATE TABLE `sys_mdict` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `domain_id` varchar(64) NOT NULL COMMENT '域ID',
  PRIMARY KEY (`id`),
  KEY `sys_mdict_parent_id` (`parent_id`),
  KEY `sys_mdict_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='多级字典表';

-- ----------------------------
-- Records of sys_mdict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) DEFAULT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `domain_id` varchar(64) NOT NULL COMMENT '域ID',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`),
  KEY `sys_menu_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('11b324cf-93dc-48d6-84b4-9e7330ff7b86', 'b4793219-4850-4783-beb4-1df2270d57ae', null, '角色管理', '0', '0', '0', '0', '1', 'sys:privilege:view', 'admin', '2018-04-23 17:25:16', 'admin', '2018-04-23 17:25:16', '', '0', 'd926086b-bdb9-4e9f-af4e-e960523e9427');
INSERT INTO `sys_menu` VALUES ('1f98b175-89ed-4ef9-8e89-527535765558', '-1', null, '系统设置', '0', '0', '0', '0', '1', 'sys', 'admin', '2018-04-23 17:23:09', 'admin', '2018-04-23 17:23:09', '', '0', 'd926086b-bdb9-4e9f-af4e-e960523e9427');
INSERT INTO `sys_menu` VALUES ('33c17909-a314-4642-b3b7-0009242515e8', 'b4793219-4850-4783-beb4-1df2270d57ae', null, '权限管理', '0', '0', '0', '0', '1', 'sys:privilege:view', 'admin', '2018-04-23 17:25:30', 'admin', '2018-04-23 17:25:30', '', '0', 'd926086b-bdb9-4e9f-af4e-e960523e9427');
INSERT INTO `sys_menu` VALUES ('3f067214-8c61-4444-b38c-ab25faa57d7f', '-1', null, '基础数据', '0', '0', '0', '0', '1', 'sys', 'admin', '2018-04-23 17:22:57', 'admin', '2018-04-23 17:22:57', '', '0', 'd926086b-bdb9-4e9f-af4e-e960523e9427');
INSERT INTO `sys_menu` VALUES ('591304b7-9fb5-4a56-b65e-fe262eb5da8d', 'b4793219-4850-4783-beb4-1df2270d57ae', null, '域管理', '0', '0', '0', '0', '1', 'sys:privilege:view', 'admin', '2018-04-23 17:24:57', 'admin', '2018-04-23 17:24:57', '', '0', 'd926086b-bdb9-4e9f-af4e-e960523e9427');
INSERT INTO `sys_menu` VALUES ('786a3bf0-dd27-45ba-b87a-f155e5a03bbc', '95fc82bd-f9a6-4982-bca2-ddc367c7432b', null, '用户管理', '0', '0', '0', '0', '1', 'sys:user:view', 'admin', '2018-04-23 17:24:05', 'admin', '2018-04-23 17:24:05', '', '0', 'd926086b-bdb9-4e9f-af4e-e960523e9427');
INSERT INTO `sys_menu` VALUES ('95fc82bd-f9a6-4982-bca2-ddc367c7432b', '-1', '0', '用户中心', '0', '0', '0', '0', '1', 'sys', 'admin', '2018-04-21 10:24:09', 'admin', '2018-04-23 17:23:20', '', '0', 'd926086b-bdb9-4e9f-af4e-e960523e9427');
INSERT INTO `sys_menu` VALUES ('b4793219-4850-4783-beb4-1df2270d57ae', '-1', null, '权限管理', '0', '0', '0', '0', '1', 'sys', 'admin', '2018-04-23 17:21:37', 'admin', '2018-04-23 17:21:37', '', '0', 'd926086b-bdb9-4e9f-af4e-e960523e9427');

-- ----------------------------
-- Table structure for sys_office
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `area_id` varchar(64) NOT NULL COMMENT '归属区域',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` char(1) NOT NULL COMMENT '机构类型',
  `grade` char(1) NOT NULL COMMENT '机构等级',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `master` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `USEABLE` varchar(64) DEFAULT NULL COMMENT '是否启用',
  `PRIMARY_PERSON` varchar(64) DEFAULT NULL COMMENT '主负责人',
  `DEPUTY_PERSON` varchar(64) DEFAULT NULL COMMENT '副负责人',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_del_flag` (`del_flag`),
  KEY `sys_office_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
-- Records of sys_office
-- ----------------------------

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `domain_id` varchar(64) NOT NULL COMMENT '所属域',
  `name` varchar(100) NOT NULL COMMENT '参数名',
  `code` varchar(64) DEFAULT NULL COMMENT '参数代码',
  `value` varchar(100) NOT NULL COMMENT '参数值',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';

-- ----------------------------
-- Records of sys_param
-- ----------------------------
INSERT INTO `sys_param` VALUES ('0add0173-ca82-4df2-9233-1964c1d59c2a', '04dbbae9-5fdf-45c4-a6a9-cecfd25e8735', '超时时间', 'TIMEOUT', '100', 'day', 'admin', '2018-04-28 14:18:16', 'admin', '2018-04-28 14:18:26', null);
INSERT INTO `sys_param` VALUES ('2902183e-6475-44ca-9b89-cfb8ec67941b', 'd926086b-bdb9-4e9f-af4e-e960523e9427', '默认密码', 'DEF_PWD', '123456', '12312', 'admin', '2018-04-28 11:15:43', 'admin', '2018-04-28 11:59:28', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `office_id` varchar(64) DEFAULT NULL COMMENT '归属机构',
  `domain_id` varchar(64) NOT NULL COMMENT '所属域',
  `enname` varchar(255) DEFAULT NULL COMMENT '角色代码',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `role_type` varchar(255) DEFAULT NULL COMMENT '角色类型',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围',
  `is_sys` varchar(64) DEFAULT NULL COMMENT '是否系统数据',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否可用',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`),
  KEY `sys_role_enname` (`enname`),
  KEY `sys_role_ibfk_1` (`domain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('12003d28-0ba3-4838-8c14-76dfbe60e6fa', null, '5a3a051c-e90a-4059-9ad4-672d64a4ef05', 'cms-admin', 'CMS管理员', null, null, null, null, 'admin', '2018-04-11 11:09:06', 'admin', '2018-04-11 11:09:06', null, '0');
INSERT INTO `sys_role` VALUES ('50cd66d9-f41f-4bcc-8110-c3efb5613b6d', '', '04dbbae9-5fdf-45c4-a6a9-cecfd25e8735', 'admin', '管理员', '', '', '', '', 'admin', '2018-04-21 09:41:36', 'admin', '2018-04-21 09:41:36', '', '0');
INSERT INTO `sys_role` VALUES ('bbdbb64a-6ee4-4c01-8607-0b01e9652d32', null, 'd03cd0ad-c773-43d0-a88d-6e6defac49e3', 'oa-admin', 'OA管理员', null, null, null, null, 'admin', '2018-04-11 11:09:26', 'admin', '2018-04-11 11:09:26', null, '0');
INSERT INTO `sys_role` VALUES ('f24642e2-7e13-4012-8fe4-fd897e982826', null, 'd926086b-bdb9-4e9f-af4e-e960523e9427', 'sys-admin', '系统管理员', null, null, null, null, 'admin', '2018-04-11 11:02:26', 'admin', '2018-04-11 11:02:26', null, '0');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_office
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_office`;
CREATE TABLE `sys_role_office` (
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `office_id` varchar(64) NOT NULL COMMENT '机构编号',
  PRIMARY KEY (`role_id`,`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-机构';

-- ----------------------------
-- Records of sys_role_office
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `company_id` varchar(64) NOT NULL COMMENT '归属公司',
  `office_id` varchar(64) NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `no` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1000) DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) DEFAULT NULL COMMENT '是否可登录',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_user_office_id` (`office_id`),
  KEY `sys_user_login_name` (`login_name`),
  KEY `sys_user_company_id` (`company_id`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('-1', '-1', '-1', 'admin', 'admin', '001', '超级管理员', '001', '001', '11', '1', '', null, null, null, '-1', '2018-04-08 10:44:27', 'admin', '2018-04-10 10:46:39', null, '0');
INSERT INTO `sys_user` VALUES ('764b3bb8-d97a-4586-9046-04342210ae5c', '0', '0', '00', '0', '0', '0', '0', '00', '0', '0', '0', null, null, null, 'admin', '2018-04-17 17:24:06', 'admin', '2018-04-17 17:24:06', null, '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(64) NOT NULL COMMENT '用户编号',
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
