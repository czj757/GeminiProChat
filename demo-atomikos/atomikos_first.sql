/*
 Navicat MySQL Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : atomikos_first

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 19/11/2020 15:18:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for af_user
-- ----------------------------
DROP TABLE IF EXISTS `af_user`;
CREATE TABLE `af_user`  (
  `user_id` bigint(0) NOT NULL COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of af_user
-- ----------------------------
INSERT INTO `af_user` VALUES (1329299302326849538, '用户1');
INSERT INTO `af_user` VALUES (1329303129914388482, '用户1');

SET FOREIGN_KEY_CHECKS = 1;
