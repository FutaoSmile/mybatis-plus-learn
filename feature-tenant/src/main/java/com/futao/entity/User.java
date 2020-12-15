package com.futao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/12/15
 */
@Getter
@Setter
@TableName("mybatis_tenant_user")
public class User extends IdTenantEntity {
    private String username;
}
