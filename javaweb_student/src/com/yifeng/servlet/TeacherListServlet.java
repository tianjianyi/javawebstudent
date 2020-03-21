package com.yifeng.servlet;



import com.yifeng.domain.Teacher;
import com.yifeng.service.TeacherService;
import com.yifeng.service.impl.TeacherServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacherListServlet")
public class TeacherListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");


        TeacherService service = new TeacherServiceImpl();
        List<Teacher> teachers = service.findAllTeacher();
        //System.out.println(students);
//        System.out.println("-------------");
//        System.out.println(teachers);
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("/pages/admin/teacher-list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
