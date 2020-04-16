package com.java.cookie;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class CookieClass {
    public static final String COOKIENAME = "auth_cookie";
    public static boolean flag = true;

    public static boolean isCookieExist(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies==null) {
            return false;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(COOKIENAME) && cookie.getValue() != null) {
                flag = true;
            }
        }
        return flag;

    }
public static void redirectUrl(ServletResponse response){
    HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        Cookie cookie=new Cookie(COOKIENAME, UUID.randomUUID().toString());
        ((HttpServletResponse) response).addCookie(cookie);
    try {
        ((HttpServletResponse) response).sendRedirect("http://localhost:8081/oauth-facebook-login/hello");
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
