package com.example.shiro.mapper;

import com.example.shiro.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where name = #{userName}")
    User findByUsername(@Param("userName") String userName);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
}
