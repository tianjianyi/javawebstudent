package com.yifeng.servlet;

import com.yifeng.domain.Course;
import com.yifeng.domain.Teacher;
import com.yifeng.service.CourseService;
import com.yifeng.service.TeacherService;
import com.yifeng.service.impl.CourseServiceImpl;
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
 * 添加课程
 */
@WebServlet("/addCourseServlet")
public class AddCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Course course = new Course();
        try {
            BeanUtils.populate(course, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //System.out.println(student);

        CourseService service = new CourseServiceImpl();
        service.addCourse(course);
        //System.out.println("----------");
        //System.out.println(course);
//        UserService service = new UserServiceImpl();
//        service.addCourse(course);
        response.sendRedirect(request.getContextPath()+"/courseListServlet");
//        request.getRequestDispatcher("/pages/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
