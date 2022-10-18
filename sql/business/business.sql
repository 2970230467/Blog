-- Table structure for s_homework
-- ----------------------------
DROP TABLE IF EXISTS `s_homework`;
CREATE TABLE `s_homework`  (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                               `teacher_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '教师id',
                               `teacher_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '教师姓名',
                               `course_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '课程名称',
                               `stuclassid` bigint(20) DEFAULT NULL COMMENT '班级ID',
                               `stuclassname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '班级名称',
                               `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作业标题',
                               `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作业内容',
                               `start_time` datetime(0) DEFAULT NULL COMMENT '开始时间',
                               `end_time` datetime(0) DEFAULT NULL COMMENT '截止时间',
                               `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注信息',
                               `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '状态(0开始，1结束)',
                               `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
                               `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                               `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
                               `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_homework
-- ----------------------------
INSERT INTO `s_homework` VALUES (8, '105', '阿卜', 'yw', 103, 'A班', '背诵阿房宫赋', '<p>背诵阿房宫赋背诵阿房宫赋<br></p>', '2021-06-08 10:06:33', '2021-06-09 18:06:34', '背诵阿房宫赋', '0', '2021-06-08 13:34:16', NULL, 'abu', NULL);
INSERT INTO `s_homework` VALUES (9, '104', '张翰', 'sx', 104, 'B班', '把期末考试模拟卷子写完', '<p>把期末考试模拟卷子写完<br></p>', '2021-06-08 13:06:44', '2021-06-09 18:06:44', '把期末考试模拟卷子写完', '0', '2021-06-08 13:35:58', NULL, 'zh', NULL);


-- ----------------------------
-- Table structure for s_student_homework
-- ----------------------------
DROP TABLE IF EXISTS `s_student_homework`;
CREATE TABLE `s_student_homework`  (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                       `student_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学生id',
                                       `student_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学生姓名',
                                       `homework_id` bigint(20) DEFAULT NULL COMMENT '作业id',
                                       `homework_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作业标题',
                                       `homework_content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作业内容',
                                       `create_time` datetime(0) DEFAULT NULL COMMENT '提交时间',
                                       `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                                       `homework_score` decimal(11, 2) DEFAULT 0.00 COMMENT '作业评分',
                                       `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评分建议',
                                       `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
                                       `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
                                       `stuclassid` bigint(20) DEFAULT NULL COMMENT '班级ID',
                                       `stuclassname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '班级名称',
                                       `state` bigint(20) DEFAULT 0 COMMENT '状态(默认0：已完成、1：已平分)',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_student_homework
-- ----------------------------
INSERT INTO `s_student_homework` VALUES (14, '106', '张三', 8, '背诵阿房宫赋', '<b>背诵阿房宫赋已完成背诵，呵呵呵呵</b>', '2021-06-08 13:36:59', '2021-06-08 16:12:15', 100.00, '100分，背诵的不错呀！', 'zs', 'abu', 103, 'A班', 1);
INSERT INTO `s_student_homework` VALUES (15, '107', '李四', 9, '把期末考试模拟卷子写完', '<p>不会做呀，也不叫我写写，你是干什么吃的老师，呵呵呵</p><p><br></p>', '2021-06-08 13:38:17', '2021-06-08 13:42:03', 0.00, '给零分，什么鬼你这交的！呵呵呵', 'ls', 'zh', 104, 'B班', 0);


-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (1, 's_homework', '留作业表', '', NULL, 'SHomework', 'crud', 'com.ruoyi.business', 'business', 'leavehomework', '作业', 'BahetCoder', '0', '/', '{\"parentMenuId\":\"2000\",\"treeName\":\"\",\"treeParentCode\":\"\",\"parentMenuName\":\"作业管理\",\"treeCode\":\"\"}', 'admin', '2021-06-03 20:55:43', '', '2021-06-04 21:44:34', '');
INSERT INTO `gen_table` VALUES (2, 's_student_homework', '提交作业表', '', NULL, 'SStudentHomework', 'crud', 'com.ruoyi.business', 'business', 'Stuhomework', '查看作业', 'BahetCoder', '0', '/', '{\"parentMenuId\":\"2000\",\"treeName\":\"\",\"treeParentCode\":\"\",\"parentMenuName\":\"作业管理\",\"treeCode\":\"\"}', 'admin', '2021-06-03 20:55:43', '', '2021-06-06 14:29:48', '');



-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES (1, '1', 'id', '主键', 'bigint(20)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (2, '1', 'teacher_id', '教师id', 'varchar(20)', 'String', 'teacherId', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 2, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (3, '1', 'teacher_name', '教师姓名', 'varchar(20)', 'String', 'teacherName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (4, '1', 'course_name', '课程名称', 'varchar(20)', 'String', 'courseName', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', 's_course_name', 4, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (5, '1', 'title', '作业标题', 'varchar(100)', 'String', 'title', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (6, '1', 'content', '作业内容', 'varchar(2000)', 'String', 'content', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'summernote', '', 6, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (7, '1', 'start_time', '开始时间', 'datetime', 'Date', 'startTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 7, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (8, '1', 'end_time', '截止时间', 'datetime', 'Date', 'endTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 8, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (9, '1', 'remark', '备注信息', 'varchar(255)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 9, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (10, '1', 'status', '状态(0开始，1结束)', 'char(1)', 'String', 'status', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', 's_homework_status', 10, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (11, '1', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 11, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (12, '1', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 12, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (13, '1', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 13, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (14, '1', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 14, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-04 21:44:34');
INSERT INTO `gen_table_column` VALUES (15, '2', 'id', '主键', 'bigint(20)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (16, '2', 'student_id', '学生id', 'varchar(20)', 'String', 'studentId', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 2, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (17, '2', 'student_name', '学生姓名', 'varchar(20)', 'String', 'studentName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (18, '2', 'homework_id', '作业id', 'bigint(20)', 'Long', 'homeworkId', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 4, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (19, '2', 'homework_title', '作业标题', 'varchar(100)', 'String', 'homeworkTitle', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (20, '2', 'homework_content', '作业内容', 'varchar(2000)', 'String', 'homeworkContent', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'summernote', '', 6, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (21, '2', 'create_time', '提交时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 7, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (22, '2', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 8, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (23, '2', 'homework_score', '作业评分', 'decimal(11,2)', 'BigDecimal', 'homeworkScore', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 9, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (24, '2', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 11, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (25, '2', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 12, 'admin', '2021-06-03 20:55:43', NULL, '2021-06-06 14:29:48');
INSERT INTO `gen_table_column` VALUES (26, '2', 'remark', '评分建议', 'varchar(255)', 'String', 'remark', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 10, '', '2021-06-06 14:27:39', NULL, '2021-06-06 14:29:48');
