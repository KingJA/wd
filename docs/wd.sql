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

 Date: 28/05/2020 17:25:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `image_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `question_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `res_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('046f7effe4314f1198da379b7b2135b8', '1a26a5664bb44ec79af008827cac3949', '如何看待人大代表关于警示图形上烟盒的建议？', '全国人大代表何琳建议，中国应同国际接轨，建议烟害警示图形上烟盒，对烟民戒烟有帮助。我国烟盒只有文字的健康警示，很难发挥作用，也损害了消费者的知情权。', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590580477796&di=94b7c552167d8892a4871c75119c53e6&imgtype=0&src=http%3A%2F%2Fpic4.58cdn.com.cn%2Fzhuanzh%2Fn_acd4d08f0cca42f3b1e2d5668ec03762_750_0.jpg', '2020-05-27 17:07:41', '2020-05-26 16:26:47');
INSERT INTO `question` VALUES ('0e3a8731112a4252b0afa5c3a99eb7b0', '1a26a5664bb44ec79af008827cac3949', '老来得子的孩子们过的好吗？', '我21岁，爸妈62岁，哥哥32岁。总的来说就是我现在过的很累很累，想找找和我一样的人儿们，看看你们都过的好吗', NULL, '2020-05-26 16:22:59', '2020-05-26 16:22:59');
INSERT INTO `question` VALUES ('178c81ffce56439bbc5e673876a09daf', '1a26a5664bb44ec79af008827cac3949', '张文宏提问：真正的「群体免疫」就是抗疫民众组成的屏障，你', '获取信息的层级越低、穿透越深，治理越有效。  疫情之初，大量信息被地方截流、干扰、掺杂噪音，导致中央的决策机制不能及时启动。', NULL, '2020-05-26 16:21:05', '2020-05-26 16:21:05');
INSERT INTO `question` VALUES ('1f9efaf06bf34414b73612f0ef7e1865', '1a26a5664bb44ec79af008827cac3949', '如何看待《纽约时报》提前公布头版，列出 1000 名死者', '《纽约时报》23日提前公布了将于24日出版的报纸头版，该报用整个头版列出了1000名新冠肺炎死者的信息', NULL, '2020-05-26 16:24:18', '2020-05-26 16:24:18');
INSERT INTO `question` VALUES ('23bd7b52d94849de9e52e43f92219d69', '1a26a5664bb44ec79af008827cac3949', '如何看待政协委员建议「因疫情归国留学学生，可入学高职高专', '一是全面开放高职高专学校，对于高年级学生可采取降一年级直接入学，进入相关专业的办法。未满1年的归国留学生，可以通过高职高专扩招计划，解决继续学习的问题。  二是启用插班生考试政策，每个学期开学前，在不同年级设定大专业组插班生考试，通过插班生考试的学生可以进入普通高校试读，1年后成', NULL, '2020-05-26 16:20:14', '2020-05-26 16:20:14');
INSERT INTO `question` VALUES ('29080d07aa9d45be956e6b337c06eee6', '1a26a5664bb44ec79af008827cac3949', '联想还是一家值得中国人称赞的公司吗?', '一家不太好评判的公司  从一些商业角度来看  04年以后联想的话语权一直在减少', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590580272111&di=9c075e23afe471f07dbaf1d06dc277d3&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20181012%2F8b6e1f78f06041288f9fedaf67ed81ca.jpeg', '2020-05-27 17:03:30', '2020-05-26 16:26:02');
INSERT INTO `question` VALUES ('297f9455ec904d83a7c95e66186bbdd8', '1a26a5664bb44ec79af008827cac3949', '如何评价 5 月 26 日 Redmi 10 X 系列发', '本次发布会除Redmi 10 X 系列产品外，还有 RedmiBook 系列以及 Redmi 智能电视X系列等新品！发布会现场卢伟冰又会有哪些金句诞生？如何评价此次发布会以及相关的新品？', NULL, '2020-05-26 16:24:38', '2020-05-26 16:24:38');
INSERT INTO `question` VALUES ('349ba131fc654b3c87ff2104ba94d8ef', '1a26a5664bb44ec79af008827cac3949', ' 如何看待 SNH48 女团成员直播中背景的呼救声？', '链接：女团#snh48 成员直播时网友听到背景好像有人在求救，这是什么情况 https://v.douyin.com/J1782cf/ 复制此链接，打开【抖音短视频】，直接观看视频！', NULL, '2020-05-26 16:23:44', '2020-05-26 16:23:44');
INSERT INTO `question` VALUES ('583d7c004b8c4f01b7ef361c2930b189', '1a26a5664bb44ec79af008827cac3949', '赌王何鸿燊病逝，享年 98 岁，如何评价他的一生？', '据香港“东网”报道，当地时间5月26日，港澳知名爱国企业家、第9届至第11届全国政协常委何鸿燊逝世，享年98岁。  何鸿燊于1921年11月25日在香港出生，祖籍广东。他家庭背景显赫，是香港商人何东爵士的侄孙。其旗下的主要企业包括：澳门博彩控股有限公司、香港新濠国际集团、香港信德', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3165002765,835201329&fm=26&gp=0.jpg', '2020-05-27 17:06:06', '2020-05-26 16:22:30');
INSERT INTO `question` VALUES ('5cdca8623d9a423d9b09dadb43409831', '1a26a5664bb44ec79af008827cac3949', '本次发布会除Redmi 10 X 系列产品外，还有 Re', '顺带还有个问题，我是旅店老板，正常营业，突然所在城市举办奥运会，房间供不应求，我没有付出额外的劳动时间，为什么我的收入比平常增加了？', NULL, '2020-05-26 16:25:42', '2020-05-26 16:25:42');
INSERT INTO `question` VALUES ('833a0bebede64fd4b5adca55abcf22e6', '1a26a5664bb44ec79af008827cac3949', '有哪些你去了以后会感叹「卧槽世界上还有这种地方」的所在？', '大四马上毕业，想挑选一个毕业旅行的地方', NULL, '2020-05-26 16:22:08', '2020-05-26 16:22:08');
INSERT INTO `question` VALUES ('9a5ee54d224f4fd1bfebc2f39fe7914e', '1a26a5664bb44ec79af008827cac3949', '今天以色列的实力能不能打败 1940 年的德国，拯救几百', '假如今天的以色列穿越到1940年的二战时期，那么以今天以色列的实力能不能打败1940年的德国，拯救几百万犹太人同胞的生命？', NULL, '2020-05-26 17:01:06', '2020-05-26 17:01:06');
INSERT INTO `question` VALUES ('b4c97a7aeed94a079dfd7e8dabdc2afa', '1a26a5664bb44ec79af008827cac3949', '全国人大代表何琳建议，中国应同国际接轨，建议烟害警示图形', '其实我更想问，如果你生命只剩三分钟，而你的身旁只有一部手机，你会用这三分钟打给谁？但仔细想想，不加设定的选择应该会更多有意思的回答吧，那些遗憾的，不能满足的，都交给最后的三分钟吧', NULL, '2020-05-26 16:27:39', '2020-05-26 16:27:39');
INSERT INTO `question` VALUES ('d16ed5cd06db40eeb8a4f751458f963f', '1a26a5664bb44ec79af008827cac3949', '2020 年 5 月 27 日高程测量登山队登顶珠峰成功', '5月27日11：03，2020珠峰高程测量登山队队员成功登顶珠穆朗玛峰顶峰。此次攻顶，测量登山队的8名攻顶组队员奋战了65小时后终于如愿。5月24日14时15分，测量登山队的队员从海拔6500米的前进营地出发到达海拔7028米的北坳营地；25日队员们从北坳营地发出，陆续抵达779', 'http://qaz0xaezg.bkt.clouddn.com/wxac52c4041a066f3d.o6zAJs7DHD-qFv7NH73XhNPxQguo.rxoC1mVKXXmt3d334aaa7c1e5fbf98e3b8e79ab143a5.jpg', '2020-05-27 16:54:20', '2020-05-27 16:54:20');
INSERT INTO `question` VALUES ('d206d8d610a04602b91ad6d85c4ae862', '1a26a5664bb44ec79af008827cac3949', '国产 HPV 疫苗 329 元一支会有多少女性使用？', '中国成功研发HPV疫苗。按照3.56亿适龄女性、每人3针计算，市场缺口超过10亿支。关于HVP疫苗的所有疑问', NULL, '2020-05-26 16:26:20', '2020-05-26 16:26:20');

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
INSERT INTO `user` VALUES ('1a26a5664bb44ec79af008827cac3949', '111', '698d51a19d8a121ce581499d7b701668', '2020-05-27 16:40:51', '2020-05-14 14:57:44', 'http://qaz0xaezg.bkt.clouddn.com/wxac52c4041a066f3d.o6zAJs7DHD-qFv7NH73XhNPxQguo.fvW7Qn015dP979b8463dbb9c6639557f494438f22de1.jpg');
INSERT INTO `user` VALUES ('7de7dea6a9974d08963df61be75deb26', '222', 'bcbe3365e6ac95ea2c0343a2395834dd', '2020-05-15 09:56:04', '2020-05-15 09:56:04', NULL);
INSERT INTO `user` VALUES ('8bb6d53ff83e4bcc89bcbb65d3f9b2a7', '3334', '331316d4efb44682092a006307b9ae3a', '2020-05-14 15:28:25', '2020-05-14 15:28:25', NULL);
INSERT INTO `user` VALUES ('a2680265591c45bbba9623b01fb5a7cf', '333', '310dcbbf4cce62f762a2aaa148d556bd', '2020-05-14 15:01:01', '2020-05-14 15:01:01', NULL);

SET FOREIGN_KEY_CHECKS = 1;
