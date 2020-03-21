package com.yifeng.servlet;


import com.yifeng.domain.Course;
import com.yifeng.domain.Scourse;
import com.yifeng.domain.Student;
import com.yifeng.service.CourseService;
import com.yifeng.service.StudentService;
import com.yifeng.service.impl.CourseServiceImpl;
import com.yifeng.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findStudentGrateServlet")
public class FindStudentGrateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //System.out.println("-------------------");
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        String userId = (String) request.getSession().getAttribute("userId");
        Course course = courseService.findCourseByTeacherId(userId);
        List<Scourse> students = studentService.findSelectStudent(course.getId());
//        System.out.println(students);
        request.setAttribute("students", students);
        request.getRequestDispatcher("/pages/teacher/studentGrate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
