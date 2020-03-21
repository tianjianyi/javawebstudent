package com.yifeng.dao;

import com.yifeng.domain.Course;

import java.util.List;

public interface CourseDao {
    List<Course> findAllCourse();

    void addCourse(Course course);

    void delCourseById(int id);

    void delSelectCourseById(int id);

    Course selCourseById(int id);

    void updateCourse(Course course);

    void upSelCourse(int id, int num);

    List<Course> findCourseMark(String userId);

    List<Course> findSelCourse(String userId);

    void delSelectCourseByIdAndStudentId(String userId, int id);

    Course findCourseByTeacherId(String userId);
}
