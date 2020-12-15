package com.futao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author futao
 * @date 2020/12/15
 */
@Configuration
@PropertySource(value = "file:/Users/futao/src/backend/my/mybatis-plus-learn/resources/application.properties")
public class ResourceConfig {
}
