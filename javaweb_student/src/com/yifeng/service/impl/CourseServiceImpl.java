package com.yifeng.service.impl;

import com.yifeng.dao.CourseDao;
import com.yifeng.dao.impl.CourseDaoImpl;
import com.yifeng.domain.Course;
import com.yifeng.domain.Student;
import com.yifeng.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao  = new CourseDaoImpl();

    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAllCourse();
    }

    @Override
    public void addCourse(Course course) {
        //System.out.println(course);
        courseDao.addCourse(course);
    }

    @Override
    public void delCourseById(int id) {
        courseDao.delCourseById(id);
    }

    @Override
    public void delSelectCourseById(int id) {
        courseDao.delSelectCourseById(id);
    }

    @Override
    public Course selCourseById(int id) {
        return courseDao.selCourseById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public void upSelCourse(int id, int num) {
        courseDao.upSelCourse(id, num);
    }

    @Override
    public List<Course> findCourseMark(String userId) {
        return courseDao.findCourseMark(userId);
    }

    @Override
    public List<Course> findSelCourse(String userId) {
        return courseDao.findSelCourse(userId);
    }

    @Override
    public void delSelectCourseByIdAndStudentId(String userId, int id) {
        courseDao.delSelectCourseByIdAndStudentId(userId, id);
    }

    @Override
    public Course findCourseByTeacherId(String userId) {
        return courseDao.findCourseByTeacherId(userId);
    }

}
