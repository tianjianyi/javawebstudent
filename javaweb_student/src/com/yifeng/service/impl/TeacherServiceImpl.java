package com.yifeng.service.impl;

import com.yifeng.dao.TeacherDao;
import com.yifeng.dao.impl.TeacherDaoImpl;
import com.yifeng.domain.Scourse;
import com.yifeng.domain.Teacher;
import com.yifeng.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public List<Teacher> findAllTeacher() {
        return teacherDao.findAllTeacher();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public void delTeacherById(String id) {
        teacherDao.delTeacherById(id);
    }

    @Override
    public Teacher selTeacherById(String id) {
        //System.out.println(id);
        return teacherDao.selTeacherById(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        //System.out.println(teacher);
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void updateGrate(Scourse scourse) {
        teacherDao.updateGrate(scourse);
    }
}
