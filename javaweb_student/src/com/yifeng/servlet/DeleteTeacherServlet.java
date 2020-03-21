package com.yifeng.servlet;

import com.yifeng.domain.Teacher;
import com.yifeng.service.CourseService;
import com.yifeng.service.TeacherService;
import com.yifeng.service.impl.CourseServiceImpl;
import com.yifeng.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        System.out.println(id);
        //System.out.println(student);

        TeacherService service = new TeacherServiceImpl();
        //service.delSelectCourseById(id);
        service.delTeacherById(id);
        //System.out.println("----------");
//        System.out.println(course);
//        UserService service = new UserServiceImpl();
//        service.addCourse(course);
        response.sendRedirect(request.getContextPath()+"/teacherListServlet");
//        request.getRequestDispatcher("/pages/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
