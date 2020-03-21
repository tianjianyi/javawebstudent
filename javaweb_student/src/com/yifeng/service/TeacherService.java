package com.yifeng.service;

import com.yifeng.domain.Scourse;
import com.yifeng.domain.Student;
import com.yifeng.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAllTeacher();

    void addTeacher(Teacher teacher);

    void delTeacherById(String id);

    Teacher selTeacherById(String id);

    void updateTeacher(Teacher teacher);

    void updateGrate(Scourse scourse);
}
