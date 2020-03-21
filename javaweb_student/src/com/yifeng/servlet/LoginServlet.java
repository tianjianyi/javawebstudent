package com.yifeng.servlet;

import com.yifeng.domain.LoginUser;
import com.yifeng.domain.Student;
import com.yifeng.domain.User;
import com.yifeng.service.StudentService;
import com.yifeng.service.UserService;
import com.yifeng.service.impl.StudentServiceImpl;
import com.yifeng.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        LoginUser loginUser = new LoginUser();
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImpl();
        User user = service.checkUser(loginUser.getUsername());
        if(user != null){
            if (user.getPASSWORD().equals(loginUser.getPassword())){
                request.getSession().setAttribute("userId", user.getUserId());
                if(user.getRoldId() == 0) request.getRequestDispatcher("/pages/admin/main.jsp").forward(request,response);
                if(user.getRoldId() == 1) request.getRequestDispatcher("/pages/student/main.jsp").forward(request,response);
                if(user.getRoldId() == 2) request.getRequestDispatcher("/pages/teacher/main.jsp").forward(request,response);

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
