package com.yifeng.dao.impl;

import com.yifeng.dao.TeacherDao;
import com.yifeng.domain.Course;
import com.yifeng.domain.Scourse;
import com.yifeng.domain.Student;
import com.yifeng.domain.Teacher;
import com.yifeng.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSouce());

    @Override
    public List<Teacher> findAllTeacher() {
        String sql = "select * from teacher";
        List<Teacher> teachers = template.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class));
        return teachers;
//        return null;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        String sql = "insert into teacher (teacherId, name, college, tie) values(?, ?, ?, ?)";
        template.update(sql,teacher.getTeacherId(), teacher.getName(), teacher.getCollege(), teacher.getTie());
    }

    @Override
    public void delTeacherById(String id) {
        String sql = "DELETE from teacher where teacherId = ?";
        template.update(sql, id);
    }

    @Override
    public Teacher selTeacherById(String id) {
//        String sql = "update teacher set name = ?, college = ?, tie = ? where teacherId = ?";
//        return template.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), id);

        String  sql = "select * from teacher where teacherId = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), id);
//        return template.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        String sql = "update teacher set name = ?, college = ?, tie = ? where teacherId = ?";
        template.update(sql,  teacher.getName(), teacher.getCollege(), teacher.getTie(), teacher.getTeacherId());
    }

    @Override
    public void updateGrate(Scourse scourse) {
        String sql = "update selectedcourse set mark = ? where studentId = ? and id = ?";
        template.update(sql, scourse.getMark(), scourse.getStudentId(), scourse.getId());
    }
}
