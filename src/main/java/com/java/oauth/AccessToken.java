package com.java.oauth;

import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Map;

public class AccessToken {
    static Map<String, String> map = new HashMap<>();

    public static void getAccessToken(ServletRequest request) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        map.put("code", code);
        map.put("state", state);
        map.put("redirect_uri", OAuthConfigForFacebook.CALLBACK_URL);
        map.put("client_id", OAuthConfigForFacebook.CLIENT_ID);
        map.put("client_secret", OAuthConfigForFacebook.CLIENT_SECRET);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(OAuthConfigForFacebook.ACCESS_TOKEN_URL);

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.setAll(map);
        builder.queryParams(multiValueMap);

        UriComponents components = builder.build();
        RestTemplate restTemplate = new RestTemplate();
        String body = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
                String.class).getBody();
        System.out.println("access token"+body);

    }
}
