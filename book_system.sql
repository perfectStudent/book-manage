/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.27-log : Database - book_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book_system` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book_system`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `admin_id` varchar(19) NOT NULL COMMENT '管理员账号',
  `admin_name` varchar(19) DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`admin_id`,`admin_name`,`password`) values ('admin','管理员','a66abb5684c45962d887564f08346e8d');

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `book_name` varchar(19) DEFAULT NULL COMMENT '书名',
  `author` varchar(10) DEFAULT NULL COMMENT '作者',
  `type` int(11) DEFAULT NULL COMMENT '分类',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `press` varchar(19) DEFAULT NULL COMMENT '出版社',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `isbn` varchar(10) DEFAULT NULL COMMENT '标准书号',
  `cover` varchar(255) DEFAULT NULL COMMENT '封面',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `lend_number` int(11) DEFAULT NULL COMMENT '借出数量',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`book_id`,`book_name`,`author`,`type`,`price`,`press`,`number`,`isbn`,`cover`,`describe`,`lend_number`) values (177,'java','不知道',2,'8.50','打的撒多',3333,'123456896',NULL,'32132131',0);

/*Table structure for table `t_borrow_info` */

DROP TABLE IF EXISTS `t_borrow_info`;

CREATE TABLE `t_borrow_info` (
  `borrow_id` varchar(19) NOT NULL COMMENT '借阅订单号',
  `lend_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '借阅时间',
  `give_back_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '归还时间',
  `reader_id` varchar(19) DEFAULT NULL COMMENT '读者账号',
  `book_id` int(11) DEFAULT NULL COMMENT '书本编号',
  `be_overdue` tinyint(1) DEFAULT NULL COMMENT '是否逾期',
  `fine` decimal(10,2) DEFAULT NULL COMMENT '罚款金额',
  `be_overdue_day` varchar(19) DEFAULT NULL COMMENT '逾期天数',
  `whether_lend` tinyint(1) DEFAULT NULL COMMENT '是否归还',
  PRIMARY KEY (`borrow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_borrow_info` */

/*Table structure for table `t_class` */

DROP TABLE IF EXISTS `t_class`;

CREATE TABLE `t_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(30) DEFAULT NULL COMMENT '班级名称',
  `major_id` int(11) DEFAULT NULL COMMENT '学院id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=326 DEFAULT CHARSET=utf8;

/*Data for the table `t_class` */

insert  into `t_class`(`id`,`class_name`,`major_id`) values (1,'17园艺技术1',1),(2,'17园艺技术2',1),(3,'17园艺技术3',1),(4,'18园艺技术2',1),(5,'18园艺技术3',1),(6,'19园艺技术1',1),(7,'19园艺技术2',1),(8,'17园林工程技术1',2),(9,'17园林工程技术2',2),(10,'18园林工程技术1',2),(11,'18园林工程技术2',2),(12,'19园林工程技术1',2),(13,'19园林工程技术2',2),(14,'17茶艺与茶叶营销1',3),(15,'17茶艺与茶叶营销2',3),(16,'18茶艺与茶叶营销1',3),(17,'18茶艺与茶叶营销2',3),(18,'19茶艺与茶叶营销1',3),(19,'19茶艺与茶叶营销2',3),(20,'17茶树栽培与茶叶加工1',4),(21,'17茶树栽培与茶叶加工2',4),(22,'18茶树栽培与茶叶加工1',4),(23,'18茶树栽培与茶叶加工2',4),(24,'19茶树栽培与茶叶加工1',4),(25,'19茶树栽培与茶叶加工2',4),(26,'17畜牧兽医1',5),(27,'17畜牧兽医2',5),(28,'18畜牧兽医1',5),(29,'18畜牧兽医2',5),(30,'19畜牧兽医1',5),(31,'19畜牧兽医2',5),(32,'17水产养殖技术1',6),(33,'17水产养殖技术2',6),(34,'18水产养殖技术1',6),(35,'18水产养殖技术2',6),(36,'19水产养殖技术1',6),(37,'19水产养殖技术2',6),(38,'17食品生物技术1',7),(39,'17食品生物技术2',7),(40,'18食品生物技术1',7),(41,'18食品生物技术2',7),(42,'19食品生物技术1',7),(43,'19食品生物技术2',7),(44,'17食品检测技术1',8),(45,'17食品检测技术2',8),(46,'18食品检测技术1',8),(47,'18食品检测技术2',8),(48,'19食品检测技术1',8),(49,'19食品检测技术2',8),(50,'17烹调工艺与营养1',10),(51,'17烹调工艺与营养2',10),(52,'18烹调工艺与营养1',10),(53,'18烹调工艺与营养2',10),(54,'19烹调工艺与营养1',10),(55,'19烹调工艺与营养2',10),(56,'17中医养生保健1',11),(57,'17中医养生保健2',11),(58,'18中医养生保健1',11),(59,'18中医养生保健2',11),(60,'19中医养生保健1',11),(61,'19中医养生保健2',11),(62,'17中医康复技术1',12),(63,'17中医康复技术2',12),(64,'18中医康复技术1',12),(65,'18中医康复技术2',12),(66,'19中医康复技术1',12),(67,'19中医康复技术2',12),(68,'17模具设计与制造1',14),(69,'17模具设计与制造2',14),(70,'18模具设计与制造1',14),(71,'18模具设计与制造2',14),(72,'19模具设计与制造1',14),(73,'19模具设计与制造2',14),(74,'17机械制造与自动化1',15),(75,'17机械制造与自动化2',15),(76,'18机械制造与自动化1',15),(77,'18机械制造与自动化2',15),(78,'19机械制造与自动化1',15),(79,'19机械制造与自动化2',15),(80,'17软件技术1',17),(81,'17软件技术2',17),(82,'18软件技术1',17),(83,'18软件技术2',17),(84,'19软件技术1',17),(85,'19软件技术2',17),(86,'17计算机应用技术1',18),(87,'17计算机应用技术2',18),(88,'18计算机应用技术1',18),(89,'18计算机应用技术2',18),(90,'19计算机应用技术1',18),(91,'19计算机应用技术2',18),(92,'17数控技术1',13),(93,'17数控技术2',13),(94,'18数控技术1',13),(95,'18数控技术2',13),(96,'19数控技术1',13),(97,'19数控技术2',13),(98,'17计算机应用技术（大数据分析及应用）1',16),(99,'17计算机应用技术（大数据分析及应用）2',16),(100,'18计算机应用技术（大数据分析及应用）1',16),(101,'18计算机应用技术（大数据分析及应用）2',16),(102,'19计算机应用技术（大数据分析及应用）1',16),(103,'19计算机应用技术（大数据分析及应用）2',16),(104,'17无人机应用技术1',19),(105,'17无人机应用技术2',19),(106,'18无人机应用技术1',19),(107,'18无人机应用技术2',19),(108,'19无人机应用技术1',19),(109,'19无人机应用技术2',19),(110,'17应用电子技术1',20),(111,'17应用电子技术2',20),(112,'18应用电子技术1',20),(113,'18应用电子技术2',20),(114,'19应用电子技术1',20),(115,'19应用电子技术2',20),(116,'17通信技术1',21),(117,'17通信技术2',21),(118,'18通信技术1',21),(119,'18通信技术2',21),(120,'19通信技术1',21),(121,'19通信技术2',21),(122,'17计算机网络技术1',22),(123,'17计算机网络技术2',22),(124,'18计算机网络技术1',22),(125,'18计算机网络技术2',22),(126,'19计算机网络技术1',22),(127,'19计算机网络技术2',22),(128,'17工业机器人技术1',23),(129,'17工业机器人技术2',23),(130,'18工业机器人技术1',23),(131,'18工业机器人技术2',23),(132,'19工业机器人技术1',23),(133,'19工业机器人技术2',23),(134,'17电气自动化技术1',24),(135,'17电气自动化技术2',24),(136,'18电气自动化技术1',24),(137,'18电气自动化技术2',24),(138,'19电气自动化技术1',24),(139,'19电气自动化技术2',24),(140,'17机电一体化技术1',25),(141,'17机电一体化技术2',25),(142,'18机电一体化技术1',25),(143,'18机电一体化技术2',25),(144,'19机电一体化技术1',25),(145,'19机电一体化技术',25),(146,'17汽车营销与服务1',26),(147,'17汽车营销与服务2',26),(148,'18汽车营销与服务1',26),(149,'18汽车营销与服务2',26),(150,'19汽车营销与服务1',26),(151,'19汽车营销与服务',26),(152,'17汽车检测与维修技术1',27),(153,'17汽车检测与维修技术2',27),(154,'18汽车检测与维修技术1',27),(155,'18汽车检测与维修技术2',27),(156,'19汽车检测与维修技术1',27),(157,'19汽车检测与维修技术2',27),(158,'17汽车电子技术1',28),(159,'17汽车电子技术2',28),(160,'18汽车电子技术1',28),(161,'18汽车电子技术2',28),(162,'19汽车电子技术1',28),(163,'19汽车电子技术2',28),(164,'17物联网应用技术1',29),(165,'17物联网应用技术2',29),(166,'18物联网应用技术1',29),(167,'18物联网应用技术2',29),(168,'19物联网应用技术1',29),(169,'19物联网应用技术',29),(170,'17物流管理1',30),(171,'17物流管理2',30),(172,'18物流管理1',30),(173,'18物流管理2',30),(174,'19物流管理1',30),(175,'19物流管理',30),(176,'17旅游管理1',31),(177,'17旅游管理2',31),(178,'18旅游管理1',31),(179,'18旅游管理2',31),(180,'19旅游管理1',31),(181,'19旅游管理2',31),(182,'17酒店管理1',32),(183,'17酒店管理2',32),(184,'18酒店管理1',32),(185,'18酒店管理2',32),(186,'19酒店管理1',32),(187,'19酒店管理2',32),(188,'17商务英语1',33),(189,'17商务英语2',33),(190,'18商务英语1',33),(191,'18商务英语2',33),(192,'19商务英语1',33),(193,'19商务英语',33),(194,'17国际商务1',34),(195,'17国际商务2',34),(196,'18国际商务1',34),(197,'18国际商务2',34),(198,'19国际商务1',34),(199,'19国际商务',34),(200,'17物流金融1',35),(201,'17物流金融2',35),(202,'18物流金融1',35),(203,'18物流金融2',35),(204,'19物流金融1',35),(205,'19物流金融2',35),(206,'17应用越南语1',36),(207,'17应用越南语2',36),(208,'18应用越南语1',36),(209,'18应用越南语2',36),(210,'19应用越南语1',36),(211,'19应用越南语2',36),(212,'17连锁经营管理1',37),(213,'17连锁经营管理2',37),(214,'18连锁经营管理1',37),(215,'18连锁经营管理2',37),(216,'19连锁经营管理1',37),(217,'19连锁经营管理',37),(218,'17人力资源管理1',38),(219,'17人力资源管理2',38),(220,'18人力资源管理1',38),(221,'18人力资源管理2',38),(222,'19人力资源管理1',38),(223,'19人力资源管理',38),(224,'17会计专业1',39),(225,'17会计专业2',39),(226,'18会计专业1',39),(227,'18会计专业2',39),(228,'19会计专业1',39),(229,'19会计专业2',39),(230,'17电子商务专业1',40),(231,'17电子商务专业2',40),(232,'18电子商务专业1',40),(233,'18电子商务专业2',40),(234,'19电子商务专业1',40),(235,'19电子商务专业2',40),(236,'17市场营销专业1',41),(237,'17市场营销专业2',41),(238,'18市场营销专业1',41),(239,'18市场营销专业2',41),(240,'19市场营销专业1',41),(241,'19市场营销专业',41),(242,'17互联网金融专业1',42),(243,'17互联网金融专业2',42),(244,'18互联网金融专业1',42),(245,'18互联网金融专业2',42),(246,'19互联网金融专业1',42),(247,'19互联网金融专业',42),(248,'17投资与理财专业1',43),(249,'17投资与理财专业2',43),(250,'18投资与理财专业1',43),(251,'18投资与理财专业2',43),(252,'19投资与理财专业1',43),(253,'19投资与理财专业2',43),(254,'17环境艺术设计1',44),(255,'17环境艺术设计2',44),(256,'18环境艺术设计1',44),(257,'18环境艺术设计2',44),(258,'19环境艺术设计1',44),(259,'19环境艺术设计2',44),(260,'17建筑室内设计1',45),(261,'17建筑室内设计2',45),(262,'18建筑室内设计1',45),(263,'18建筑室内设计2',45),(264,'19建筑室内设计1',45),(265,'19建筑室内设计',45),(266,'17工程造价1',46),(267,'17工程造价2',46),(268,'18工程造价1',46),(269,'18工程造价2',46),(270,'19工程造价1',46),(271,'19工程造价',46),(272,'17建筑工程技术1',47),(273,'17建筑工程技术2',47),(274,'18建筑工程技术1',47),(275,'18建筑工程技术2',47),(276,'19建筑工程技术1',47),(277,'19建筑工程技术2',47),(278,'17室内艺术设计1',48),(279,'17室内艺术设计2',48),(280,'18室内艺术设计1',48),(281,'18室内艺术设计2',48),(282,'19室内艺术设计1',48),(283,'19室内艺术设计2',48),(284,'17艺术设计1',49),(285,'17艺术设计2',49),(286,'18艺术设计1',49),(287,'18艺术设计2',49),(288,'19艺术设计1',49),(289,'19艺术设计',49),(290,'17新闻采编与制作1',50),(291,'17新闻采编与制作2',50),(292,'18新闻采编与制作1',50),(293,'18新闻采编与制作2',50),(294,'19新闻采编与制作1',50),(295,'19新闻采编与制作',50),(296,'17数字媒体影视动画1',51),(297,'17数字媒体影视动画2',51),(298,'18数字媒体影视动画1',51),(299,'18数字媒体影视动画2',51),(300,'19数字媒体影视动画1',51),(301,'19数字媒体影视动画2',51),(302,'17播音与主持1',52),(303,'17播音与主持2',52),(304,'18播音与主持1',52),(305,'18播音与主持2',52),(306,'19播音与主持1',52),(307,'19播音与主持2',52),(308,'17影视动画1',53),(309,'17影视动画2',53),(310,'18影视动画1',53),(311,'18影视动画2',53),(312,'19影视动画1',53),(313,'19影视动画',53),(314,'17广告设计与制作1',54),(315,'17广告设计与制作2',54),(316,'18广告设计与制作1',54),(317,'18广告设计与制作2',54),(318,'19广告设计与制作1',54),(319,'19广告设计与制作',54),(320,'17食品加工技术1',9),(321,'17食品加工技术2',9),(322,'18食品加工技术1',9),(323,'18食品加工技术2',9),(324,'19食品加工技术1',9),(325,'19食品加工技术2',9);

/*Table structure for table `t_college` */

DROP TABLE IF EXISTS `t_college`;

CREATE TABLE `t_college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(19) DEFAULT NULL COMMENT '学院',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_college` */

insert  into `t_college`(`id`,`college_name`) values (1,'农业与环境工程学院'),(2,'食品与生物技术学院'),(3,'机电与信息工程学院'),(4,'管理学院'),(5,'经贸学院'),(6,'艺术传媒与建筑工程学院');

/*Table structure for table `t_gender` */

DROP TABLE IF EXISTS `t_gender`;

CREATE TABLE `t_gender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender_name` varchar(19) DEFAULT NULL COMMENT '性别称呼',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_gender` */

insert  into `t_gender`(`id`,`gender_name`) values (1,'男'),(2,'女'),(3,'保密');

/*Table structure for table `t_major` */

DROP TABLE IF EXISTS `t_major`;

CREATE TABLE `t_major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major_name` varchar(19) DEFAULT NULL COMMENT '专业名称',
  `college_id` int(11) DEFAULT NULL COMMENT '学院id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Data for the table `t_major` */

insert  into `t_major`(`id`,`major_name`,`college_id`) values (1,'园艺技术',1),(2,'园林工程技术',1),(3,'茶艺与茶叶营销',1),(4,'茶树栽培与茶叶加工',1),(5,'畜牧兽医',1),(6,'水产养殖技术',1),(7,'食品生物技术',2),(8,'食品检测技术',2),(9,'食品加工技术',2),(10,'烹调工艺与营养',2),(11,'中医养生保健',2),(12,'中医康复技术',2),(13,'数控技术',3),(14,'模具设计与制造',3),(15,'机械制造与自动化',3),(16,'计算机应用技术（大数据分析及应用）',3),(17,'软件技术',3),(18,'计算机应用技术',3),(19,'无人机应用技术',3),(20,'应用电子技术',3),(21,'通信技术',3),(22,'计算机网络技术',3),(23,'工业机器人技术',3),(24,'电气自动化技术',3),(25,'机电一体化技术',3),(26,'汽车营销与服务',3),(27,'汽车检测与维修技术',3),(28,'汽车电子技术',3),(29,'物联网应用技术',3),(30,'物流管理',4),(31,'旅游管理',4),(32,'酒店管理',4),(33,'商务英语',4),(34,'国际商务',4),(35,'物流金融',4),(36,'应用越南语',4),(37,'连锁经营管理',4),(38,'人力资源管理',4),(39,'会计专业',4),(40,'电子商务专业',4),(41,'市场营销专业',4),(42,'互联网金融专业',4),(43,'投资与理财专业',4),(44,'环境艺术设计',4),(45,'建筑室内设计',4),(46,'工程造价',4),(47,'建筑工程技术',4),(48,'室内艺术设计',4),(49,'艺术设计',4),(50,'新闻采编与制作',4),(51,'数字媒体艺术设计',4),(52,'播音与主持',4),(53,'影视动画',4),(54,'广告设计与制作',4);

/*Table structure for table `t_reader` */

DROP TABLE IF EXISTS `t_reader`;

CREATE TABLE `t_reader` (
  `reader_id` varchar(19) NOT NULL COMMENT '账号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `name` varchar(19) DEFAULT NULL COMMENT '姓名',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `college_id` int(11) DEFAULT NULL COMMENT '学院',
  `major_id` int(11) DEFAULT NULL COMMENT '专业',
  `class_id` int(11) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`reader_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_reader` */

insert  into `t_reader`(`reader_id`,`password`,`name`,`gender`,`avatar`,`phone`,`college_id`,`major_id`,`class_id`) values ('11111','bbb8aae57c104cda40c93843ad5e6db8','111111',1,NULL,'11111111111',3,16,100),('123456','ea48576f30be1669971699c09ad05c94','123',1,NULL,'12345678911',1,2,9);

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(19) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`type_name`) values (1,'小说'),(2,'文学'),(3,'历史'),(4,'传记'),(5,'青春'),(6,'励志'),(7,'社科'),(8,'心里'),(9,'经济'),(10,'管理'),(11,'理财'),(12,'美食'),(13,'时尚'),(14,'健身'),(15,'孕产'),(16,'少儿'),(17,'科学'),(18,'科普'),(19,'医学'),(20,'教辅'),(21,'外语'),(22,'工业'),(23,'旅游');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;