package com.yifeng.servlet;

import com.yifeng.domain.Scourse;
import com.yifeng.domain.Teacher;
import com.yifeng.service.TeacherService;
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

@WebServlet("/putGrateServlet")
public class PutGrateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();
        Scourse scourse = new Scourse();

        try {
            BeanUtils.populate(scourse, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        TeacherService service = new TeacherServiceImpl();
        service.updateGrate(scourse);
        response.sendRedirect(request.getContextPath()+"/findStudentGrateServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
