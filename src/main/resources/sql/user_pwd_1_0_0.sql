CREATE TABLE `user_pwd` (
	`uid` BIGINT(20) NOT NULL COMMENT '用户代号',
	`login_id` VARCHAR(64) NOT NULL COMMENT '登录账号',
	`passwd` VARCHAR(64) NOT NULL COMMENT '登录密码',
	`modified_uid` BIGINT(20) NOT NULL COMMENT '更新者的用户代号',
	`modified_time` VARCHAR(32) NOT NULL COMMENT '更新时间',
	PRIMARY KEY (`uid`),
	UNIQUE INDEX `login_id` (`login_id`),
	CONSTRAINT `FK_USER_PWD_UID_TO_USER_ID` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='用户密码表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
