package com.yifeng.servlet;


import com.yifeng.domain.QueryVo;
import com.yifeng.domain.Student;
import com.yifeng.service.StudentService;
import com.yifeng.service.impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/studentListServlet")
public class StudentListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //System.out.println("-------------------");
        StudentService service = new StudentServiceImpl();
        List<Student> students = service.findAllStudent();
        //System.out.println(students);
//        System.out.println("-------------");
//        System.out.println(teachers);
        request.setAttribute("students", students);
        request.getRequestDispatcher("/pages/admin/student-list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
