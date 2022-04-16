package com.pepsiwyl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pepsiwyl.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-04-12 20:31
 */

@Transactional

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户名查询角色
     *
     * @param username
     * @return list Role
     */
    List<Role> getRolesByUserName(String username);

}
