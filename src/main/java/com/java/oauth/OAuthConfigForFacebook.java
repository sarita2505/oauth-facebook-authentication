package com.java.oauth;

public class OAuthConfigForFacebook {
    public static final String AUTHORIZE_URL="https://graph.facebook.com/oauth/authorize";
    public static final String ACCESS_TOKEN_URL="https://graph.facebook.com/oauth/access_token";
    public static final String CALLBACK_URL="http://localhost:8081/oauth-facebook-login/login";
    public static final String CLIENT_ID="226962495041529";
    public static final String CLIENT_SECRET="d84afe45478f239e43811345643521e5";
    public static final String REQUEST_CODE_URL=AUTHORIZE_URL+"?client_id="+CLIENT_ID+"&redirect_uri="+CALLBACK_URL+"&state=%s";
}
