/*
 Navicat Premium Data Transfer

 Source Server         : fcl
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : fblog

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 15/04/2022 22:40:28
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES (1, 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', 'admin', '1397697356@qq.com', '2022-04-09 18:52:03', '2022-04-09 18:52:06');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `preface` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章前言',
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `visit_count` int(10) UNSIGNED NULL DEFAULT NULL,
  `enable_comment` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '0-允许评论 1-不允许评论',
  `published` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '0-草稿 1-发布',
  `category_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_category_id`(`category_id`) USING BTREE,
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, '测试标题', '解放啦巨大能发送', '测试文本', 'moren.png', '原创', 222, 1, 0, 4, '2021-09-02 16:51:38', '2022-04-11 19:56:07');
INSERT INTO `blog` VALUES (2, '测试22', '达瓦的吗拉我的发你了啊', 'sdahdkad', 'moren.png', '原创', 21, 0, 0, 2, '2021-10-10 19:20:34', '2022-04-11 19:57:55');
INSERT INTO `blog` VALUES (4, '测试22', '丰富对方怕我', 'sdahdkad', 'moren.png', '原创', 20, 0, 1, 2, '2022-04-11 00:06:37', '2022-04-11 19:57:31');
INSERT INTO `blog` VALUES (10, '萨达萨达', '发附件啊你发', '的撒打发的发射点大大发是撒旦发生发生', 'moren.png', '原创', 0, 0, 1, 3, '2022-04-11 09:50:08', '2022-04-11 22:24:12');
INSERT INTO `blog` VALUES (11, '这次是是是顶顶顶顶是真真真好着呢的好了', '大瓦房卡洛夫烦恼了', '的撒打发的发射点大大发是', 'moren.png', '转载', 0, 0, 1, 1, '2022-04-11 09:56:55', '2022-04-11 22:32:04');
INSERT INTO `blog` VALUES (12, '大萨达', '士大夫，卡上佛', '的撒打发的发射点大大发是', 'moren.png', '原创', 0, 0, 0, 1, '2022-04-11 09:59:33', '2022-04-11 14:49:13');
INSERT INTO `blog` VALUES (13, 'vv大大', '发肺癌收费啊', '的撒打发的发射点大大发是', 'moren.png', '原创', 0, 0, 1, 6, '2022-04-11 10:00:15', '2022-04-11 10:00:15');
INSERT INTO `blog` VALUES (15, '终于好了22222', '的法网发我', '好好打好地方哈萨克就方便快速大部分是的粉丝酷似东方航空色非常陌生的比分拉开身边发生的附件是的部分金额二百file啊石膏板封面那是对加沙广泛接受的美女风俗用来分隔麻烦色的计划分为方面那时的风流色共花费了部分是，九的股份ibdf，金黄色给覅略是否，马上就大部分刘娥温哥华发生的阀门厂，你围观回复我今儿办法接受电话发给i为了表达方面呢阿瑟王iu风往北饭卡额覅为规范你们说的为u范宏伟抱负美女法国额外iu发手机端背景和施工方iu文化开始打包覅为规范哈部分i哈根覅去武汉课件撒比覅u额哇官方节哀吧起伏的哈无法本身就华国锋viu饿我去回复办卡文件iu请问话费卡五百的饭卡上iu啊我会疯掉兰卡威部分喀什官方iu阿韦贵妃喀什步伐加快啊七武海发货本菲卡手机号覅乱舞韩国覅u啊好地方喀什给覅卢湾区俄国防部飞机还是的功夫i也问过iu我和覅u阿文贺卡回复iu啊我和饭卡设备覅u啊我给发表i啊u和覅u啊我回复开u发完后GIF蛤科进士翟銮文化饭卡本菲卡是iu哇哈覅u拉瓦回复 课件撒会无法和i拉乌哈克设计风格会完全尔夫卡和反抗精神的给i爱无悔覅乱话费卡是覅乱五发俩回复iu卢瓦夫和u金卡边防军哈撒给覅u拉我回复卡和覅u拉我哈三播放机哈桑发我iu发贺卡上发布卡死了发狐狸啊u我和疯狂练级啊说法iu啊我和iu物权法喀什附件为噶覅u哈维iu我ask解放后i啊u午饭后卡世界杯丢瓦房卡i啊u无法哈维iu和夫卡是法规为规范卡ui我废话话费卡死iu千万富豪开好房间卡啊呜i发哈快递费伯纳乌iu法海刷卡返回啊我回复卡机山地户外iu埃及空军等会啊我回复空间啊几次啊覅u未婚夫开啊u废话分厘卡手机发，是你的，阿萨都i爱哭的你看撒娇都i啊我就的哦i啊我尽量快点静安王松i我的啊我答复就卡机飞鸟时代科技回复i啊u扼杀卡号丹佛iu啊哈打卡机五年的飞机喀什覅u啊嗯啊我i发违法拿什么，法海我发货啊我可能达康书记和丹佛i哇发，建安四年到书房卡死你的卡上佛i阿文发的卡上范奈斯发货鸥外房间，卡死你覅偶啊违法和奥克兰年未回复ia 南卡罗符号位i合法空间啊氟化物回复啊，就是覅u阿富汗卡奥i回复哦i阿娇的疯狂练级啊 哦爱妃哈偶哦i阿飞佛奥委会翻看覅客户哈佛i啊我和付款囧房间号呢啊看是否哦啊发啊，分红i阿飞贺卡哈佛iu啊卡麻烦你都i阿飞花花浮动空间拉风好玩好发啦回复瓦活佛都i啊老师佛i啊瓦活佛啊', 'moren.png', '原创', 0, 0, 1, 15, '2022-04-11 13:36:42', '2022-04-11 20:30:44');
INSERT INTO `blog` VALUES (16, 'DVD发VS的', '法尔无法哇哇', '山豆根山豆根VS', 'moren.png', '原创', 0, 0, 1, 6, '2022-04-11 13:45:46', '2022-04-11 14:49:31');
INSERT INTO `blog` VALUES (17, '大达娃大', '法网发阿瓦', '士大夫打撒法尔发我啊打发我发', 'moren.png', '原创', 0, 1, 1, 4, '2022-04-11 13:56:46', '2022-04-11 13:56:46');
INSERT INTO `blog` VALUES (18, '萨达萨达', '发发', '', 'moren.png', '原创', 0, 0, 1, 4, '2022-04-11 13:57:53', '2022-04-11 13:57:53');
INSERT INTO `blog` VALUES (19, '达瓦达瓦', '发哇乳房粉丝发噶尔', '达瓦达瓦达瓦', 'moren.png', '原创', 0, 0, 1, 4, '2022-04-11 13:59:20', '2022-04-11 13:59:20');
INSERT INTO `blog` VALUES (20, '大苏打伟大', '的法务啊', '飞洒发发达娃大萨达啊', 'moren.png', '转载', 0, 0, 1, 9, '2022-04-11 19:42:13', '2022-04-11 19:42:13');
INSERT INTO `blog` VALUES (21, '哈哈哈哈哈', '发我发我', '好好打好地方哈萨克就方便快速大部分是的粉丝酷似东方航空色非常陌生的比分拉开身边发生的附件是的部分金额二百file啊石膏板封面那是对加沙广泛接受的美女风俗用来分隔麻烦色的计划分为方面那时的风流色共花费了部分是，九的股份ibdf，金黄色给覅略是否，马上就大部分刘娥温哥华发生的阀门厂，你围观回复我今儿办法接受电话发给i为了表达方面呢阿瑟王iu风往北饭卡额覅为规范你们说的为u范宏伟抱负美女法国额外iu发手机端背景和施工方iu文化开始打包覅为规范哈部分i哈根覅去武汉课件撒比覅u额哇官方节哀吧起伏的哈无法本身就华国锋viu饿我去回复办卡文件iu请问话费卡五百的饭卡上iu啊我会疯掉兰卡威部分喀什官方iu阿韦贵妃喀什步伐加快啊七武海发货本菲卡手机号覅乱舞韩国覅u啊好地方喀什给覅卢湾区俄国防部飞机还是的功夫i也问过iu我和覅u阿文贺卡回复iu啊我和饭卡设备覅u啊我给发表i啊u和覅u啊我回复开u发完后GIF蛤科进士翟銮文化饭卡本菲卡是iu哇哈覅u拉瓦回复 课件撒会无法和i拉乌哈克设计风格会完全尔夫卡和反抗精神的给i爱无悔覅乱话费卡是覅乱五发俩回复iu卢瓦夫和u金卡边防军哈撒给覅u拉我回复卡和覅u拉我哈三播放机哈桑发我iu发贺卡上发布卡死了发狐狸啊u我和疯狂练级啊说法iu啊我和iu物权法喀什附件为噶覅u哈维iu我ask解放后i啊u午饭后卡世界杯丢瓦房卡i啊u无法哈维iu和夫卡是法规为规范卡ui我废话话费卡死iu千万富豪开好房间卡啊呜i发哈快递费伯纳乌iu法海刷卡返回啊我回复卡机山地户外iu埃及空军等会啊我回复空间啊几次啊覅u未婚夫开啊u废话分厘卡手机发，是你的，阿萨都i爱哭的你看撒娇都i啊我就的哦i啊我尽量快点静安王松i我的啊我答复就卡机飞鸟时代科技回复i啊u扼杀卡号丹佛iu啊哈打卡机五年的飞机喀什覅u啊嗯啊我i发违法拿什么，法海我发货啊我可能达康书记和丹佛i哇发，建安四年到书房卡死你的卡上佛i阿文发的卡上范奈斯发货鸥外房间，卡死你覅偶啊违法和奥克兰年未回复ia 南卡罗符号位i合法空间啊氟化物回复啊，就是覅u阿富汗卡奥i回复哦i阿娇的疯狂练级啊 哦爱妃哈偶哦i阿飞佛奥委会翻看覅客户哈佛i啊我和付款囧房间号呢啊看是否哦啊发啊，分红i阿飞贺卡哈佛iu啊卡麻烦你都i阿飞花花浮动空间拉风好玩好发啦回复瓦活佛都i啊老师佛i啊瓦活佛啊', 'moren.png', '原创', 1, 0, 1, 2, '2022-04-11 19:43:00', '2022-04-11 19:43:00');
INSERT INTO `blog` VALUES (22, '大大大', '发啊我发我', '``发士大夫士大夫阿松大啊萨达阿三\n广东省公司的``\n发士大夫十分范德萨', 'moren.png', '转载', 0, 0, 1, 15, '2022-04-11 19:44:34', '2022-04-11 19:44:34');
INSERT INTO `blog` VALUES (23, '飞洒发的', '发阿文发瓦发', '``发士大夫士大夫阿松大啊萨达阿三\n广东省公司的``\n', 'moren.png', '转载', 0, 0, 1, 6, '2022-04-11 19:47:12', '2022-04-11 19:47:12');
INSERT INTO `blog` VALUES (24, '哈哈哈哈哈', '发法网发阿凡达哇', '# 测试\n很好 非常好\n无所谓了\n代码试试\n```java\n@PostMapping(\"/update\")\n    public LayuiResult blogUpdate(@RequestBody Map<String,Object> map){\n        try {\n            blogService.updateBlog(map);\n            return LayuiResult.success(MessageConstant.UPDATE_BLOG_SUCCESS);\n        } catch (Exception e) {\n            e.printStackTrace();\n            return LayuiResult.fail(MessageConstant.UPDATE_BLOG_FAIL);\n        }\n    }\n```\n好像并不怎么好用\n\n表格试试\n\n| id  |  name |\n| ------------ | ------------ |\n|  1 | 张三  |\n|  2 |  李四 |\n\n好吧就这样吧 \n\n', 'moren.png', '原创', 0, 0, 1, 2, '2022-04-11 19:47:30', '2022-04-13 14:22:52');

-- ----------------------------
-- Table structure for blog_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag_relation`;
CREATE TABLE `blog_tag_relation`  (
  `blog_id` int(10) UNSIGNED NOT NULL,
  `tag_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`blog_id`, `tag_id`) USING BTREE,
  INDEX `fk_tag_id`(`tag_id`) USING BTREE,
  CONSTRAINT `fk_blogid` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_tag_relation
-- ----------------------------
INSERT INTO `blog_tag_relation` VALUES (11, 1);
INSERT INTO `blog_tag_relation` VALUES (12, 1);
INSERT INTO `blog_tag_relation` VALUES (13, 1);
INSERT INTO `blog_tag_relation` VALUES (15, 1);
INSERT INTO `blog_tag_relation` VALUES (1, 2);
INSERT INTO `blog_tag_relation` VALUES (10, 2);
INSERT INTO `blog_tag_relation` VALUES (11, 2);
INSERT INTO `blog_tag_relation` VALUES (12, 2);
INSERT INTO `blog_tag_relation` VALUES (15, 2);
INSERT INTO `blog_tag_relation` VALUES (20, 2);
INSERT INTO `blog_tag_relation` VALUES (23, 2);
INSERT INTO `blog_tag_relation` VALUES (10, 3);
INSERT INTO `blog_tag_relation` VALUES (17, 3);
INSERT INTO `blog_tag_relation` VALUES (19, 3);
INSERT INTO `blog_tag_relation` VALUES (22, 3);
INSERT INTO `blog_tag_relation` VALUES (10, 4);
INSERT INTO `blog_tag_relation` VALUES (16, 4);
INSERT INTO `blog_tag_relation` VALUES (18, 4);
INSERT INTO `blog_tag_relation` VALUES (20, 4);
INSERT INTO `blog_tag_relation` VALUES (23, 4);
INSERT INTO `blog_tag_relation` VALUES (1, 5);
INSERT INTO `blog_tag_relation` VALUES (17, 5);
INSERT INTO `blog_tag_relation` VALUES (18, 5);
INSERT INTO `blog_tag_relation` VALUES (19, 5);
INSERT INTO `blog_tag_relation` VALUES (22, 5);
INSERT INTO `blog_tag_relation` VALUES (13, 6);
INSERT INTO `blog_tag_relation` VALUES (21, 6);
INSERT INTO `blog_tag_relation` VALUES (24, 6);
INSERT INTO `blog_tag_relation` VALUES (13, 7);
INSERT INTO `blog_tag_relation` VALUES (21, 7);
INSERT INTO `blog_tag_relation` VALUES (24, 7);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'spring');
INSERT INTO `category` VALUES (2, '设计模式');
INSERT INTO `category` VALUES (3, '数据结构');
INSERT INTO `category` VALUES (4, 'c');
INSERT INTO `category` VALUES (5, 'c++');
INSERT INTO `category` VALUES (6, '数据库');
INSERT INTO `category` VALUES (9, '操作系统');
INSERT INTO `category` VALUES (13, 'java');
INSERT INTO `category` VALUES (14, 'javaweb');
INSERT INTO `category` VALUES (15, '测试标签12');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `blog_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `parent_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '评论父id',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容，不超200字',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论者头像估计都是一样的',
  `comment_status` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '评论状态 1审核通过，0审核未通过',
  `is_delete` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '评论是否删除1删除0不删除',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `parent_nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论父昵称冗余字段',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_comment_parent`(`parent_id`) USING BTREE,
  INDEX `fk_blog_id`(`blog_id`) USING BTREE,
  CONSTRAINT `fk_blog_id` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_parent` FOREIGN KEY (`parent_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 24, NULL, '方法', '12222@163.com', '的烦烦烦', '/blog/images/touxiang.jpg', 1, 0, '2022-04-12 14:20:39', NULL);
INSERT INTO `comment` VALUES (2, 24, NULL, '大大', 'ww@qq.com', 'fadfff', '/blog/images/touxiang.jpg', 1, 0, '2022-04-12 14:21:24', NULL);
INSERT INTO `comment` VALUES (3, 24, 2, 'rr', 'ww@qq.com', 'tcfdf', '/blog/images/touxiang.jpg', 1, 0, '2022-04-12 14:21:54', '大大');
INSERT INTO `comment` VALUES (4, 24, 3, 'qq', '222@qq.com', 'ffgwwwdd', '/blog/images/touxiang.jpg', 1, 0, '2022-04-13 15:34:34', NULL);
INSERT INTO `comment` VALUES (5, 24, NULL, '测试一号机', 'sadasd@qq.com', '测试评论', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:01:18', NULL);
INSERT INTO `comment` VALUES (6, 24, NULL, '测试二号机', 'sadasd@qq.com', '测试评论2号', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:02:37', NULL);
INSERT INTO `comment` VALUES (7, 24, 1, '测试一号机', 'sadasd@qq.com', '测试评论3号', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:05:02', 'rr');
INSERT INTO `comment` VALUES (8, 24, NULL, '测试一号机', '1397697356@qq.com', 'haha ', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:07:20', NULL);
INSERT INTO `comment` VALUES (9, 24, NULL, '测试一号机', 'sadasd@qq.com', 'ff', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:13:31', NULL);
INSERT INTO `comment` VALUES (10, 24, NULL, '测试一号机', 'sadasd@qq.com', 'ff', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:15:05', NULL);
INSERT INTO `comment` VALUES (11, 24, NULL, '测试一号机', 'sadasd@qq.com', 'ff', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:15:06', NULL);
INSERT INTO `comment` VALUES (12, 24, NULL, '测试一号机', 'sadasd@qq.com', 'ff', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:15:07', NULL);
INSERT INTO `comment` VALUES (13, 24, NULL, '测试一号机', 'sadasd@qq.com', 'ff', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:15:08', NULL);
INSERT INTO `comment` VALUES (14, 24, NULL, '测试二号机', 'sadasd@qq.com', '大大大', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:26:16', NULL);
INSERT INTO `comment` VALUES (15, 24, NULL, '测试一号机', 'sadasd@qq.com', '烦烦烦', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:30:10', NULL);
INSERT INTO `comment` VALUES (16, 24, NULL, '测试一号机', 'sadasd@qq.com', 'ddd', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:31:03', NULL);
INSERT INTO `comment` VALUES (17, 24, 1, '测试二号机', 'sadasd@qq.com', 'ffgvcvd', '/blog/images/touxiang.jpg', 0, 0, '2022-04-13 17:31:17', 'rr');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, '随笔文章');
INSERT INTO `tag` VALUES (2, '生活记录');
INSERT INTO `tag` VALUES (3, '部署运维');
INSERT INTO `tag` VALUES (4, '知识积累');
INSERT INTO `tag` VALUES (5, '数据库');
INSERT INTO `tag` VALUES (6, '前端笔记');
INSERT INTO `tag` VALUES (7, '游戏杂谈');
INSERT INTO `tag` VALUES (10, '测试标签1');
INSERT INTO `tag` VALUES (11, '测试标签9');
INSERT INTO `tag` VALUES (13, '测试标签4');
INSERT INTO `tag` VALUES (14, '测试标签42');

SET FOREIGN_KEY_CHECKS = 1;
