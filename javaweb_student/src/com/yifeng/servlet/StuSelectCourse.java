package com.yifeng.servlet;

import com.yifeng.domain.Course;
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

@WebServlet("/stuSelectCourse")
public class StuSelectCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("id");
        int id =Integer.valueOf(sid);


        StudentService service = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        String userId = (String) request.getSession().getAttribute("userId");
        //System.out.println("------------------99");
        //System.out.println(userId);
        service.inSelectedCourse(userId, id);
        Course course = courseService.selCourseById(id);
        courseService.upSelCourse(id, course.getNum() - 1);

        //System.out.println("----------");
//        System.out.println(course);
//        UserService service = new UserServiceImpl();
//        service.addCourse(course);
        response.sendRedirect(request.getContextPath()+"/selCourseListServlet");
//        request.getRequestDispatcher("/pages/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
