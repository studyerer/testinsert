package com.testinsert.mvc.Interceptor;

import com.testinsert.mvc.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object o) throws Exception{

//        HttpSession session=request.getSession();
//        User user=(User)session.getAttribute("username");

        if(null==request.getSession().getAttribute("loginUser")){
            request.getSession().setAttribute("errorMsg", "请登陆");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }else {
            return true;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object o, ModelAndView modelAndView)throws Exception{

    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,
    Object o,Exception e){

    }

}
