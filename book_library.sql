/*
 Navicat Premium Data Transfer

 Source Server         : 本地库
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : book_library

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 26/03/2022 12:46:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `book_id` int NOT NULL AUTO_INCREMENT COMMENT '图书id',
  `book_name` varchar(20) DEFAULT NULL COMMENT '书名',
  `author` varchar(200) DEFAULT NULL COMMENT '作者',
  `publisher` varchar(20) DEFAULT NULL COMMENT '出版社',
  `publish_date` datetime DEFAULT NULL COMMENT '出版日期',
  `price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `book_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图书类型（目前不定义）',
  `store_location` varchar(30) DEFAULT NULL COMMENT '存放位置',
  `store_date` datetime DEFAULT NULL COMMENT '入库日期',
  `borrowed_number` int NOT NULL DEFAULT '0' COMMENT '借出数量',
  `number` int NOT NULL DEFAULT '0' COMMENT '图书剩余数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` int DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` int DEFAULT NULL COMMENT '修改人',
  `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
BEGIN;
INSERT INTO `t_book` VALUES (1, 'Windows核心编程', 'Jeffrey Richter', '机械工业出版社', '2000-06-26 14:03:26', 86, '经济学', 'A30', '2013-10-26 14:03:26', 1, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (2, 'C程序设计语言', '（美）Brian W. Kernighan （美）Dennis M. Ritchie', '机械工业出版社', '2004-03-27 00:22:54', 30, '编程', 'A90', '2013-10-27 14:22:47', 1, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (3, '计算机程序的构造和解释', 'Harold Abelson Gerald Jay Sussman Julie Sussman', '机械工业出版社', '2004-03-27 00:21:24', 45, '经济学', 'B10', '2013-10-27 00:21:24', 1, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (4, '代码大全（第2版）', '[美] 史蒂夫·迈克康奈尔', '电子工业出版社', '2006-04-27 00:22:06', 128, '编程', 'B10', '2013-10-27 00:22:06', 1, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (5, '算法导论', '[美] Thomas H.Cormen Charles E.Leiserson Ronald L.Rivest Clifford Stein', '机械工业出版社', '2006-10-23 23:28:48', 85, '编程', '111', '2013-10-23 23:28:48', 2, 98, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (6, '编程之美', '《编程之美》小组 编', '电子工业出版社', '2008-04-26 14:03:55', 40, '经济学', 'A31', '2013-10-26 14:03:55', 4, 96, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (7, 'Python核心编程（第二版）', '[美]Wesley J. Chun（陳仲才）', '人民邮电出版社', '2008-07-26 14:02:19', 89, '编程', 'A20', '2013-10-26 14:02:19', 8, 92, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (8, '大学物理学', '张三慧', '清华大学出版社', '2009-03-24 13:38:41', 38, '编程', 'A-1-002', '2013-10-24 13:38:41', 3, 97, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (9, 'Android应用开发揭秘', '杨丰盛', '机械工业出版社', '2010-02-24 13:30:25', 69, '编程', 'A-1-01', '2013-10-24 13:30:25', 5, 95, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (10, '与孩子一起学编程', '[美] 桑德Warren Sande Carter Sande', '人民邮电出版社', '2010-12-26 14:02:58', 65, '编程', 'A20', '2013-10-26 14:02:58', 1, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_book` VALUES (11, 'JavaEE程序设计与应用开发', '郭克华 编', '清华大学', '2011-02-28 21:29:01', 32, '编程', 'A20', '2013-10-28 21:29:01', 4, 96, NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `member_type` tinyint DEFAULT NULL COMMENT '会员类型（1黄金2白银3普通）',
  `member_name` varchar(255) DEFAULT NULL COMMENT '会员名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` int DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` int DEFAULT NULL COMMENT '修改人',
  `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dictionary
-- ----------------------------
BEGIN;
INSERT INTO `t_dictionary` VALUES (1, 1, 'gold', NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (2, 2, 'silver', NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (3, 3, 'copper', NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `book_id` int DEFAULT NULL COMMENT '图书id',
  `book_num` int DEFAULT NULL COMMENT '图书数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` int DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` int DEFAULT NULL COMMENT '修改人',
  `price` decimal(10,2) DEFAULT NULL COMMENT '成交价格',
  `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES (57, 11, 3, '2022-03-26 03:06:41', 1, NULL, NULL, 67.20, 0);
INSERT INTO `t_order` VALUES (58, 7, 3, '2022-03-26 03:18:02', 1, NULL, NULL, 186.90, 0);
INSERT INTO `t_order` VALUES (59, 2, 1, '2022-03-26 03:18:11', 2, NULL, NULL, 24.00, 0);
INSERT INTO `t_order` VALUES (60, 8, 3, '2022-03-26 03:18:22', 1, NULL, NULL, 79.80, 0);
INSERT INTO `t_order` VALUES (61, 4, 1, '2022-03-26 03:18:32', 1, NULL, NULL, 89.60, 0);
INSERT INTO `t_order` VALUES (62, 9, 1, '2022-03-26 03:18:43', 3, NULL, NULL, 69.00, 0);
INSERT INTO `t_order` VALUES (63, 10, 1, '2022-03-26 03:18:43', 3, NULL, NULL, 65.00, 0);
INSERT INTO `t_order` VALUES (64, 7, 4, '2022-03-26 03:18:43', 3, NULL, NULL, 356.00, 0);
INSERT INTO `t_order` VALUES (65, 6, 4, '2022-03-26 03:18:43', 3, NULL, NULL, 160.00, 0);
INSERT INTO `t_order` VALUES (66, 11, 1, '2022-03-26 03:19:21', 3, NULL, NULL, 32.00, 0);
INSERT INTO `t_order` VALUES (67, 3, 1, '2022-03-26 03:20:12', 2, NULL, NULL, 36.00, 0);
INSERT INTO `t_order` VALUES (68, 1, 1, '2022-03-26 03:20:12', 2, NULL, NULL, 68.80, 0);
INSERT INTO `t_order` VALUES (69, 7, 1, '2022-03-26 03:20:12', 2, NULL, NULL, 71.20, 0);
INSERT INTO `t_order` VALUES (70, 9, 4, '2022-03-26 03:20:12', 2, NULL, NULL, 220.80, 0);
INSERT INTO `t_order` VALUES (71, 5, 2, '2022-03-26 03:20:30', 3, NULL, NULL, 170.00, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `member_id` int NOT NULL DEFAULT '3',
  `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'zhangsan', '123', 1, 0);
INSERT INTO `t_user` VALUES (2, 'lisi', '123', 2, 0);
INSERT INTO `t_user` VALUES (3, 'wangwu', '123', 3, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
