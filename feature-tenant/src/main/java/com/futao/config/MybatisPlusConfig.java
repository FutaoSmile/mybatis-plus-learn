package com.futao.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.futao.util.CurrentUserId;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.parser.SimpleNode;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author futao
 * @date 2020/12/15
 */
@Slf4j
@Configuration
public class MybatisPlusConfig {

    @Bean
    public Interceptor interceptor() {
        //多租户
        TenantLineInnerInterceptor tenantLineInnerInterceptor = new TenantLineInnerInterceptor(new TenantLineHandler() {
            @Override
            public Expression getTenantId() {
                log.info("获取租户ID:{}", CurrentUserId.s());
                //租户-从ThreadLocal中读取当前登录的用户
                return new LongValue(CurrentUserId.s());
            }

            @Override
            public String getTenantIdColumn() {
                //设置租户字段名
                return "tenant_id";
            }

            @Override
            public boolean ignoreTable(String tableName) {
                //是否忽略tableName
                log.info("调用ignoreTable:{}", tableName);
                // 可设置超级管理员，能操作所有数据
                if (110L == CurrentUserId.s()) {
                    return true;
                }
                return false;
            }
        });

        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(tenantLineInnerInterceptor);
        return mybatisPlusInterceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }
}
