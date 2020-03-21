package com.yifeng.service;

import com.yifeng.domain.Course;
import com.yifeng.domain.Student;
import com.yifeng.domain.Teacher;

import java.util.List;

public interface CourseService {
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
