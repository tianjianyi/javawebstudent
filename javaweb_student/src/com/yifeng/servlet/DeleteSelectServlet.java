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

@WebServlet("/deleteSelectServlet")
public class DeleteSelectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("id");
        int id =Integer.valueOf(sid);
        //System.out.println(student);
        String userId = (String) request.getSession().getAttribute("userId");

        CourseService service = new CourseServiceImpl();
        service.delSelectCourseByIdAndStudentId(userId, id);
        Course course = service.selCourseById(id);
        service.upSelCourse(id, course.getNum() + 1);
//        service.delCourseById(id);
        response.sendRedirect(request.getContextPath()+"/alreadySelectServlet");
//        request.getRequestDispatcher("/pages/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
