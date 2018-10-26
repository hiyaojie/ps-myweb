package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by yaojie on 2018-10-19.
 */
@Service
public class AdminService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void login(String user , String password ,HttpServletResponse response){

        if (password.equals("1234")){
            String token = getUUID();
            System.out.println(token);
            stringRedisTemplate.opsForValue().set(token,user);
            Cookie cookie = new Cookie("token",token);
            response.addCookie(cookie);
        }

    }

    public static String getUUID(){
        String uuidStr = UUID.randomUUID().toString();
        uuidStr = uuidStr.replace("-","");
        return uuidStr;
    }
}
