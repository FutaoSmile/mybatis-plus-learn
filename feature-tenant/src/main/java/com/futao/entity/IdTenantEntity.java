package com.futao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/12/15
 */
@Getter
@Setter
public class IdTenantEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 租户
     */
    private Long tenantId;
}
