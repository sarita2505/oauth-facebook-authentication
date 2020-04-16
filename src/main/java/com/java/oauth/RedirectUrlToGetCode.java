package com.java.oauth;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class RedirectUrlToGetCode {
    public static void getCode(ServletResponse response){
        String url=OAuthConfigForFacebook.REQUEST_CODE_URL;
        String state= UUID.randomUUID().toString();
        url=String.format(url,state);
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        try {
            httpServletResponse.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
