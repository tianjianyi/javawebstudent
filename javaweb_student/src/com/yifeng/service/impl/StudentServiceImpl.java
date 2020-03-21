package com.yifeng.service.impl;

import com.yifeng.dao.StudentDao;
import com.yifeng.dao.impl.StudentDaoImpl;
import com.yifeng.domain.Scourse;
import com.yifeng.domain.Student;
import com.yifeng.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> findAllStudent() {
        //System.out.println("------------------");
        return studentDao.findAllStudent();
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void delStudentById(String id) {
        studentDao.delStudentById(id);
    }

    @Override
    public Student selStudentById(String id) {
        return studentDao.selStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void inSelectedCourse(String userId, int id) {
        studentDao.inSelectedCourse(userId, id);
    }

    @Override
    public List<Scourse> findSelectStudent(Integer id) {
        return studentDao.findSelectStudent(id);
    }
}
