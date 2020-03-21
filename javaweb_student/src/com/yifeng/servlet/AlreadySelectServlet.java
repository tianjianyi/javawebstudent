package com.yifeng.servlet;


import com.yifeng.domain.Course;
import com.yifeng.service.CourseService;
import com.yifeng.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 已选课程
 */
@WebServlet("/alreadySelectServlet")
public class AlreadySelectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");


        CourseService service = new CourseServiceImpl();
        String userId = (String) request.getSession().getAttribute("userId");
        List<Course> courses = service.findSelCourse(userId);

       // System.out.println(courses);
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/pages/student/alreadySelectCourse.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
