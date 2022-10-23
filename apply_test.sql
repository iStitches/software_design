/*
 Navicat Premium Data Transfer

 Source Server         : centos
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 192.168.24.4:3306
 Source Schema         : apply_test

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 23/10/2022 16:54:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_application
-- ----------------------------
DROP TABLE IF EXISTS `tb_application`;
CREATE TABLE `tb_application`  (
  `id_application` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `id_applicant` int(20) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_application`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_application
-- ----------------------------
INSERT INTO `tb_application` VALUES (00000000001, 1, '采购物品A数量100件,物品B数量10件', 2, '2022-10-23 14:30:48');
INSERT INTO `tb_application` VALUES (00000000002, 1, '请假10天,望批准', 3, '2022-10-23 14:40:35');
INSERT INTO `tb_application` VALUES (00000000003, 1, 'kkkkkkkkk', 0, '2022-10-23 15:02:49');
INSERT INTO `tb_application` VALUES (00000000004, 1, 'qqqqq', 2, '2022-10-23 15:03:00');
INSERT INTO `tb_application` VALUES (00000000005, 1, 'qqqqq', 2, '2022-10-23 15:03:04');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` tinyint(1) NULL DEFAULT NULL,
  `department` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (00000000001, 'staff1', '123456', 1, '采购部');
INSERT INTO `tb_user` VALUES (00000000002, 'staff2', '123456', 0, '采购部');
INSERT INTO `tb_user` VALUES (00000000003, 'root', '123456', 0, '人力部');

SET FOREIGN_KEY_CHECKS = 1;
