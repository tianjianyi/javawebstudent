package com.yifeng.servlet;

import com.yifeng.domain.Course;
import com.yifeng.service.CourseService;
import com.yifeng.service.impl.CourseServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/deleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("id");
        int id =Integer.valueOf(sid);
        System.out.println(id);
        //System.out.println(student);

        CourseService service = new CourseServiceImpl();
        service.delSelectCourseById(id);
        service.delCourseById(id);
        //System.out.println("----------");
//        System.out.println(course);
//        UserService service = new UserServiceImpl();
//        service.addCourse(course);
        response.sendRedirect(request.getContextPath()+"/courseListServlet");
//        request.getRequestDispatcher("/pages/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
