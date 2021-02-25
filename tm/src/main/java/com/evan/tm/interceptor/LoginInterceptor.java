package com.evan.tm.interceptor;

import com.evan.tm.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 断 session 中是否存在 user 属性，如果存在就放行，如果不存在就跳转到 login 页面。这里使用了一个路径列表（requireAuthPages
public class LoginInterceptor  implements HandlerInterceptor{

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String contextPath=session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                "index",
        };

        String uri = httpServletRequest.getRequestURI();

        uri = StringUtils.remove(uri, contextPath+"/");
        String page = uri;

        if(begingWith(page, requireAuthPages)){
            User user = (User) session.getAttribute("user");
            if(user==null) {
                httpServletResponse.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    private boolean begingWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if(StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}