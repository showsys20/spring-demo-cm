package com.demo.cm.sample.mapper;

import com.demo.cm.model.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author ：changxxx
 * @date ：Created at 2020/4/4 21:36
 * @description：
 * @modified By：
 */
public interface UserMapper extends Mapper<User> {
    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);
}
