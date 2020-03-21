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

@WebServlet("/exitCourseServlet")
public class ExitCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("id");
        int id =Integer.valueOf(sid);
        //System.out.println(id);
        //System.out.println(student);

        CourseService service = new CourseServiceImpl();
        //service.delSelectCourseById(id);
        Course course = service.selCourseById(id);
        //System.out.println("----------");
        //System.out.println(course);
        request.setAttribute("course", course);
//        UserService service = new UserServiceImpl();
//        service.addCourse(course);
//        response.sendRedirect(request.getContextPath()+"/courseListServlet");
        request.getRequestDispatcher("/pages/admin/exitCourse.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
