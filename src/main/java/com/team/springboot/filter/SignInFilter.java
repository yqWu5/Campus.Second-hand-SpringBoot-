package com.team.springboot.filter;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "logFilter")
public class SignInFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();
        if(req.getRequestURL().indexOf("login")!=-1||req.getRequestURL().indexOf("regist")!=-1||req.getRequestURL().indexOf("layui")!=-1||req.getRequestURL().indexOf("repwd")!=-1) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else if(session.getAttribute("u_Account")==null) {
            session.setAttribute("msg","没有权限，请先登录");
            resp.sendRedirect(req.getContextPath() + "/login");
        }
        else
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
