package com.yifeng.dao.impl;

import com.yifeng.dao.CourseDao;
import com.yifeng.domain.Course;
import com.yifeng.domain.Student;
import com.yifeng.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSouce());
    @Override
    public List<Course> findAllCourse() {
        String sql = "select * from course";
        List<Course> courses = template.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        String sql = "insert into course (courseId,name,teachername,num,room,teacherId) values(?, ?, ?, ?, ?, ?)";
        template.update(sql,course.getCourseId(), course.getName(), course.getTeachername(), course.getNum(), course.getRoom(),course.getTeacherId());
    }

    @Override
    public void delCourseById(int id) {
        String sql = "delete from course where id = ?";
        template.update(sql, id);
    }

    @Override
    public void delSelectCourseById(int id) {
        String sql = "DELETE from selectedcourse where id = ?";
        template.update(sql, id);
    }

    @Override
    public Course selCourseById(int id) {
        String sql = "select * from course where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Course>(Course.class), id);
    }

    @Override
    public void updateCourse(Course course) {
        String sql = "update course set courseId = ? ,name = ?,teachername = ?,num=?,room= ?,teacherId=? where id = ?";
        template.update(sql, course.getCourseId(), course.getName(), course.getTeachername(),
                course.getNum(), course.getRoom(), course.getTeacherId(), course.getId());
    }

    @Override
    public void upSelCourse(int id, int num) {
        String sql = "update course set num = ? where id = ?";
        template.update(sql, num, id);
    }

    @Override
    public List<Course> findCourseMark(String userId) {
        String sql = "SELECT * from (select c.id, c.name, c.courseId, c.teachername,c.room, s.mark from course c, selectedcourse s where c.id = s.id) a where a.id in (select id from selectedcourse where studentId=?)";

        return template.query(sql, new BeanPropertyRowMapper<Course>(Course.class), userId);
    }

    @Override
    public List<Course> findSelCourse(String userId) {
        String sql = "select * from course where id in (select id from selectedcourse where studentId=?)";
        return template.query(sql, new BeanPropertyRowMapper<Course>(Course.class), userId);
    }

    @Override
    public void delSelectCourseByIdAndStudentId(String userId, int id) {
        String sql = "delete from selectedcourse where studentId = ? and id = ?";
        template.update(sql, userId, id);
    }

    @Override
    public Course findCourseByTeacherId(String userId) {
        String sql = "select * from course where teacherId = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Course>(Course.class),userId);
    }
}
