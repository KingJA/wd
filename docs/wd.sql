/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : wd

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 14/05/2020 17:32:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `face_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1a26a5664bb44ec79af008827cac3949', '111', '698d51a19d8a121ce581499d7b701668', '2020-05-14 14:57:44', '2020-05-14 14:57:44', NULL);
INSERT INTO `user` VALUES ('8bb6d53ff83e4bcc89bcbb65d3f9b2a7', '3334', '331316d4efb44682092a006307b9ae3a', '2020-05-14 15:28:25', '2020-05-14 15:28:25', NULL);
INSERT INTO `user` VALUES ('a2680265591c45bbba9623b01fb5a7cf', '333', '310dcbbf4cce62f762a2aaa148d556bd', '2020-05-14 15:01:01', '2020-05-14 15:01:01', NULL);

SET FOREIGN_KEY_CHECKS = 1;
