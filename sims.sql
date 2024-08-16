/*
 Navicat Premium Data Transfer

 Source Server         : xiaozhe
 Source Server Type    : MySQL
 Source Server Version : 80300 (8.3.0)
 Source Host           : localhost:3306
 Source Schema         : sims

 Target Server Type    : MySQL
 Target Server Version : 80300 (8.3.0)
 File Encoding         : 65001

 Date: 16/08/2024 18:29:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `acc_num` varchar(10) CHARACTER SET ucs2 COLLATE ucs2_general_ci NULL DEFAULT NULL,
  `date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '学生', '112233', '2023-12-27 19:30:21');
INSERT INTO `account` VALUES (2, '教师', '123456', '2023-12-27 19:33:37');
INSERT INTO `account` VALUES (3, '学生', '888888', '2023-12-28 17:34:46');
INSERT INTO `account` VALUES (4, '教师', '123456', '2023-12-29 12:39:25');
INSERT INTO `account` VALUES (5, '教师', '123456', '2024-08-16 12:06:47');
INSERT INTO `account` VALUES (6, '教师', '123456', '2024-08-16 12:07:42');
INSERT INTO `account` VALUES (7, '教师', '123456', '2024-08-16 12:56:21');
INSERT INTO `account` VALUES (8, '教师', '123456', '2024-08-16 13:12:15');
INSERT INTO `account` VALUES (9, '教师', '123456', '2024-08-16 13:14:01');
INSERT INTO `account` VALUES (10, '教师', '123456', '2024-08-16 13:16:43');
INSERT INTO `account` VALUES (11, '教师', '123456', '2024-08-16 13:22:03');
INSERT INTO `account` VALUES (12, '学生', '888888', '2024-08-16 14:18:57');
INSERT INTO `account` VALUES (13, '学生', '123456', '2024-08-16 14:24:08');
INSERT INTO `account` VALUES (14, '学生', '888888', '2024-08-16 14:26:23');

-- ----------------------------
-- Table structure for adminpsw
-- ----------------------------
DROP TABLE IF EXISTS `adminpsw`;
CREATE TABLE `adminpsw`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `apsw` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adminpsw
-- ----------------------------
INSERT INTO `adminpsw` VALUES (1, '666666');
INSERT INTO `adminpsw` VALUES (2, '123456');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `c_nature` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `c_s` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'Java程序设计', '必修', '已选');
INSERT INTO `course` VALUES (2, '数据结构', '必修', '已选');
INSERT INTO `course` VALUES (3, '计算机组成原理', '必修', '已选');
INSERT INTO `course` VALUES (4, '计算机网络', '必修', '已选');
INSERT INTO `course` VALUES (5, '操作系统', '必修', '已选');

-- ----------------------------
-- Table structure for password
-- ----------------------------
DROP TABLE IF EXISTS `password`;
CREATE TABLE `password`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `acc_num` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `psw` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of password
-- ----------------------------
INSERT INTO `password` VALUES (1, '教师', '123456', '123456');
INSERT INTO `password` VALUES (2, '学生', '112233', '112233');
INSERT INTO `password` VALUES (3, '学生', '888888', '888888');
INSERT INTO `password` VALUES (4, '学生', '1002', '1002');

-- ----------------------------
-- Table structure for stuachieve
-- ----------------------------
DROP TABLE IF EXISTS `stuachieve`;
CREATE TABLE `stuachieve`  (
  `stu_id` int NOT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stu_a1` int NULL DEFAULT NULL,
  `stu_a2` int NULL DEFAULT NULL,
  `stu_a3` int NULL DEFAULT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stuachieve
-- ----------------------------
INSERT INTO `stuachieve` VALUES (100210, '徐洋', 100, 100, 100);
INSERT INTO `stuachieve` VALUES (101011, '小强', 60, 60, 60);
INSERT INTO `stuachieve` VALUES (112233, '李四', 68, 85, 90);
INSERT INTO `stuachieve` VALUES (789456, '张三', 99, 99, 99);
INSERT INTO `stuachieve` VALUES (888888, '小哲', 98, 90, 95);

-- ----------------------------
-- Table structure for studentdata
-- ----------------------------
DROP TABLE IF EXISTS `studentdata`;
CREATE TABLE `studentdata`  (
  `stu_id` int NOT NULL,
  `stu_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stu_age` smallint NULL DEFAULT NULL,
  `stu_class` smallint NULL DEFAULT NULL,
  `stu_college` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentdata
-- ----------------------------
INSERT INTO `studentdata` VALUES (100210, '徐洋', 18, 2, '计科');
INSERT INTO `studentdata` VALUES (101011, '小强', 20, 2, '软工');
INSERT INTO `studentdata` VALUES (112233, '李四', 22, 3, '网工');
INSERT INTO `studentdata` VALUES (789456, '张三', 25, 6, '大数据');
INSERT INTO `studentdata` VALUES (888888, '小哲', 18, 1, '计科');

SET FOREIGN_KEY_CHECKS = 1;
