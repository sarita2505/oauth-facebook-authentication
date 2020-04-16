package com.java.filter;


import com.java.cookie.CookieClass;
import com.java.oauth.AccessToken;
import com.java.oauth.RedirectUrlToGetCode;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class OAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("===1st filter init===");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest) servletRequest).getServletPath().equals("/login"))
        {
            AccessToken.getAccessToken(servletRequest);
            CookieClass.redirectUrl(servletResponse);
        }
        else if (CookieClass.isCookieExist(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            RedirectUrlToGetCode.getCode(servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
