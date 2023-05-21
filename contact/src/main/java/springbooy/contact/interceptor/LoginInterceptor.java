package springbooy.contact.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //判断当前请求地址是否登录地址
//        if(uri.contains("Login") || uri.contains("RegisterPage"))
//        {
//            //登录请求，直接放行
//            return true;
//        }

            //判断用户是否登录
//            if(request.getSession().getAttribute("account")!=null)
//            {
//                //说明已经登录，放行
//                return true;
//            }
//
//            else
//            {
//                //没有登录，重定向到登录界面
//                response.sendRedirect(request.getContextPath() + "/Login");
//                return false;
//            }
                return true;
        }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
