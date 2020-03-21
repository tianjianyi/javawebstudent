package com.yifeng.servlet;

import com.yifeng.domain.Student;
import com.yifeng.domain.Teacher;
import com.yifeng.service.StudentService;
import com.yifeng.service.TeacherService;
import com.yifeng.service.impl.StudentServiceImpl;
import com.yifeng.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exitStudentServlet")
public class ExitStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
//        int id =Integer.valueOf(sid);
        //System.out.println(id);
        //System.out.println(student);

        StudentService service = new StudentServiceImpl();
        //service.delSelectCourseById(id);
       // System.out.println("-----------------");
        Student student = service.selStudentById(id);

        request.setAttribute("student", student);
//        UserService service = new UserServiceImpl();
//        service.addCourse(course);
//        response.sendRedirect(request.getContextPath()+"/courseListServlet");
        request.getRequestDispatcher("/pages/admin/exitStudent.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
