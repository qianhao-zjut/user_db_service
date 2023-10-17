package com.haoqian.demo.repo.mappers;

import com.haoqian.demo.repo.model.User;


import org.apache.ibatis.annotations.*;

import org.apache.ibatis.type.JdbcType;


public interface UserMapper {

    @Select({
            "select *",
            "from user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @Insert({
          "insert into user(id,name) values (#{user.id,jdbcType=INTEGER}, #{user.name,jdbcType=VARCHAR})"
    })
    int insertUser(@Param("user")User user);

}