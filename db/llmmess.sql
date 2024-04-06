SET FOREIGN_KEY_CHECKS=0;

USE spiderflow;
DROP TABLE IF EXISTS `llm_mess_tb`;
CREATE TABLE `llm_mess_tb` (
                           `id` varchar(32) NOT NULL,
                           `question` varchar(128) DEFAULT NULL COMMENT '问题描述',
                           `answer` longtext DEFAULT NULL COMMENT '参考答案',
#                            `createDate` datetime DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '交互式语言问答';
