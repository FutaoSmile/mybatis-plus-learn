CREATE TABLE `mybatis_tenant_article`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `tenant_id` int(11) NOT NULL,
    `title`     varchar(255) DEFAULT NULL COMMENT '标题',
    `content`   varchar(255) DEFAULT NULL COMMENT '内容',
    `user_id`   int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4 COMMENT ='文章表';


INSERT INTO `mybatis-plus-learn`.mybatis_tenant_article (id, tenant_id, title, content, user_id) VALUES (1, 1, '租户1的文章1', '111', 1);
INSERT INTO `mybatis-plus-learn`.mybatis_tenant_article (id, tenant_id, title, content, user_id) VALUES (2, 1, '租户1的文章1', '111', 1);
INSERT INTO `mybatis-plus-learn`.mybatis_tenant_article (id, tenant_id, title, content, user_id) VALUES (3, 2, '租户2的文章1', '111', 2);