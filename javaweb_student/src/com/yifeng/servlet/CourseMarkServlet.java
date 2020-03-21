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
 * 查询课程分数列表
 */
@WebServlet("/courseMarkServlet")
public class CourseMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");


        CourseService service = new CourseServiceImpl();
        String userId = (String) request.getSession().getAttribute("userId");
        List<Course> courses = service.findCourseMark(userId);

       // System.out.println(courses);
        request.setAttribute("courseMark", courses);
        request.getRequestDispatcher("/pages/student/courseMark.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
