package com.yifeng.dao.impl;

import com.yifeng.dao.UserDao;
import com.yifeng.domain.User;
import com.yifeng.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSouce());
    @Override
    public User checkUser(String userId) {
        String sql = "select * from user where userId = ?";
        System.out.println("------------------");
        System.out.println(userId);
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userId);
    }
}
