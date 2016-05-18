DROP DATABASE simplecms;
CREATE DATABASE simplecms;

DROP TABLE  IF EXISTS `tb_user_info`;
DROP TABLE IF EXISTS `tb_role_info`;
DROP TABLE IF EXISTS `tb_permission_role_ref`;
DROP TABLE IF EXISTS `tb_permission_info`;

CREATE TABLE `tb_user_info` (
    `id` int(20) NOT NULL AUTO_INCREMENT,
    `user_account` varchar(32) NOT NULL,
    `user_password` varchar(32) NOT NULL,
    `user_true_name` varchar(32) DEFAULT NULL,
    `user_sex` varchar(32) DEFAULT NULL,
    `user_depart` varchar(32) DEFAULT NULL,
    `user_phone` varchar(32) DEFAULT NULL,
    `user_mobile` varchar(32) DEFAULT NULL,
    `user_email` varchar(32) DEFAULT NULL,
    `user_idcard` varchar(32) DEFAULT NULL,
    `user_state` char(1) DEFAULT NULL,
    `role_id` int(20) NOT NULL,
    `user_reg_time` timestamp NOT NULL,
    `user_last_time` timestamp NOT NULL,
    `user_times` varchar(32) DEFAULT "0",
    PRIMARY KEY (`id`)
 )
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_role_info`(
    `id` int(20) NOT NULL AUTO_INCREMENT,
    `role_name` varchar(32) NOT NULL,
    `role_create_time` timestamp NOT NULL,
    `role_describ` varchar(100) DEFAULT NULL,
    PRIMARY KEY(`id`)
 )
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_permission_info`(
    `id` int(20) NOT NULL AUTO_INCREMENT,
    `permission_name` varchar(32) NOT NULL,
    `permission_serial` varchar(32) NOT NULL,
    `permission_create_time` timestamp NOT NULL,
    `permission_describ` varchar(100) DEFAULT NULL,
    PRIMARY KEY(id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_permission_role_ref`(
    `id` int(20) NOT NULL AUTO_INCREMENT,
    `permission_id` int(20) NOT NULL,
    `role_id` int(20) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`permission_id`) REFERENCES `tb_permission_info`(`id`),
    FOREIGN KEY(`role_id`) REFERENCES `tb_role_info`(`id`)
 )
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;