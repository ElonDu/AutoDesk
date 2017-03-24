CREATE TABLE `user` (
	`id` BIGINT(20) NOT NULL,
	`name` VARCHAR(64) NOT NULL COMMENT '姓名',
	`gender` INT(1) NULL DEFAULT NULL COMMENT '性别',
	`birthday` VARCHAR(8) NOT NULL COMMENT '出生日期',
	`identity_no` VARCHAR(32) NOT NULL COMMENT '身份证号码',
	`mobile` VARCHAR(32) NOT NULL COMMENT '手机号码',
	`tel` VARCHAR(32) NULL DEFAULT NULL COMMENT '固定电话',
	`status` INT(1) NOT NULL COMMENT '状态',
	`create_time` VARCHAR(32) NULL DEFAULT NULL COMMENT '创建时间',
	`modified_time` VARCHAR(32) NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `identity_no` (`identity_no`),
	INDEX `mobile` (`mobile`)
)
COMMENT='用户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
