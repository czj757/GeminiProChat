/*
 Navicat MySQL Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : atomikos_second

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 19/11/2020 15:18:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for af_customer
-- ----------------------------
DROP TABLE IF EXISTS `af_customer`;
CREATE TABLE `af_customer`  (
  `customer_id` bigint(0) NOT NULL COMMENT '客户id',
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of af_customer
-- ----------------------------
INSERT INTO `af_customer` VALUES (1329299301911613442, '客户1');
INSERT INTO `af_customer` VALUES (1329303129692090370, '客户1');

SET FOREIGN_KEY_CHECKS = 1;
