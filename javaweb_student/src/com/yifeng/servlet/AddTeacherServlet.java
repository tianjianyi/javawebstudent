package com.yifeng.servlet;

import com.yifeng.domain.Student;
import com.yifeng.domain.Teacher;
import com.yifeng.service.StudentService;
import com.yifeng.service.TeacherService;
import com.yifeng.service.impl.StudentServiceImpl;
import com.yifeng.service.impl.TeacherServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 添加老师
 */
@WebServlet("/addTeacherServlet")
public class AddTeacherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Teacher teacher = new Teacher();
        try {
            BeanUtils.populate(teacher, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //System.out.println(student);

        TeacherService service = new TeacherServiceImpl();
        service.addTeacher(teacher);
//        UserService service = new UserServiceImpl();
//        service.addCourse(course);
        response.sendRedirect(request.getContextPath()+"/teacherListServlet");
//        request.getRequestDispatcher("/pages/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
