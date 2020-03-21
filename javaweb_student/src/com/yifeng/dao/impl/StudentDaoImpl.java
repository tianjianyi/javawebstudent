package com.yifeng.dao.impl;


import com.yifeng.domain.Scourse;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.yifeng.dao.StudentDao;
import com.yifeng.domain.Student;
import com.yifeng.util.JdbcUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSouce());

    @Override
    public List<Student> findAllStudent() {

        String sql = "select * from student";
        List<Student> students = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return students;
    }

    @Override
    public void addStudent(Student student) {
        String sql = "insert into student (studentId, name, major, clazz) values(?, ?, ?, ?)";
        template.update(sql,student.getStudentId(), student.getName(), student.getMajor(), student.getClazz());
    }

    @Override
    public void delStudentById(String id) {
        String sql = "DELETE from student where studentId = ?";
        template.update(sql, id);
    }

    @Override
    public Student selStudentById(String id) {
        String sql = "select * from student where studentId = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "update student set name = ?, major = ?, clazz = ? where studentId = ?";
        template.update(sql, student.getName(), student.getMajor(), student.getClazz(), student.getStudentId());
    }

    @Override
    public void inSelectedCourse(String userId, int id) {
        String sql = "insert into selectedcourse(studentId, id) values(?, ?)";
        template.update(sql, userId, id);
    }

    @Override
    public List<Scourse> findSelectStudent(Integer id) {
        String sql = "SELECT * from (SELECT a.mark,a.id, a.courseId,st.name, a.studentId,st.major,st.clazz from (SELECT s.mark,c.id,c.courseId,s.studentId from course c, selectedcourse s WHERE c.id = s.id) a, student st where a.studentId = st.studentId) b WHERE b.id = ?";
        return template.query(sql, new BeanPropertyRowMapper<Scourse>(Scourse.class), id);
    }
}
