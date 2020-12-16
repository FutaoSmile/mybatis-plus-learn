package com.futao.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.futao.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author futao
 * @date 2020/12/16
 */
@InterceptorIgnore(tenantLine = "false")
public interface UserMapper extends BaseMapper<User> {

    @InterceptorIgnore(tenantLine = "true")
    @Select("SELECT * FROM mybatis_tenant_user")
    List<User> queryList();

}
