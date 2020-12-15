package com.futao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/12/15
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName("mybatis_tenant_article")
public class Article extends IdTenantEntity {
    private String title;
    private String content;
    private Long userId;
}
