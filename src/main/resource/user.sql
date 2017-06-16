/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-16 14:46:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '名字',
  `id_code` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `national` varchar(50) DEFAULT NULL COMMENT '民族',
  `education` varchar(50) DEFAULT NULL COMMENT '学历',
  `position` varchar(200) DEFAULT NULL COMMENT '职务',
  `title` varchar(200) DEFAULT NULL COMMENT '职称',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `brithday` varchar(50) DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '52262619800410121X', '汉', '本科', '学生', '学生会主席', '好主席', '1980-04-10', '男');
INSERT INTO `user` VALUES ('2', '张三2', '522125197912221315', '汉', '本科', '学生', '学生会主席', '好主席', '1979-12-22', '男');
INSERT INTO `user` VALUES ('3', '张CS安', '152801198703025310', '汉', '本科', '学生', '高级', '好学生', '1987-03-02', '男');
INSERT INTO `user` VALUES ('6', '李四1', '520201197209083216', '汉', '硕士', '班长', '无', '好班长', '1972-09-08', '男');
INSERT INTO `user` VALUES ('7', '李四2', '211003198407230111', '汉', '硕士', '班长', '无', '好班长', '1984-07-23', '男');
INSERT INTO `user` VALUES ('8', '李四3', '152123198510030631', '汉', '硕士', '班长', '无', '好班长', '1985-10-03', '男');
