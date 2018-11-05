package com.blog.support;

import com.blog.exception.ErrorCode;
import com.blog.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by yaojie on 2018-10-30.
 */
public class UserInfoUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final ThreadLocal<String> USERNAME = new ThreadLocal<>();
    private static final ThreadLocal<String> AREACODE = new ThreadLocal<>();
    private static final ThreadLocal<String> TYPE = new ThreadLocal<>();

    public static String getUsername() {
        if (USERNAME.get() == null) {
            throw new ServiceException(ErrorCode.invalidToken);
        }
        return USERNAME.get();
    }

    public static void setUsername(String username) {
        USERNAME.set(username);
    }
    public static void setAreaCode(String areaCode) {
        AREACODE.set(areaCode);
    }
    public static void setType(String type) {
        TYPE.set(type);
    }


    public static String getAreaCode() {
        if (AREACODE.get() == null) {
            throw new ServiceException(ErrorCode.invalidToken);
        }
        return AREACODE.get();
    }
    public static String getType() {
        if (TYPE.get() == null) {
            throw new ServiceException(ErrorCode.invalidToken);
        }
        return TYPE.get();
    }

//    private String user;
//    private String type;
//
//    public String getUser() {
//        if ()
//        return user;
//    }
//
//    public void setUser(String user) {
//        this.user = user;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public void setToken(String token){
        System.out.println(token);
        String user = stringRedisTemplate.opsForValue().get(token);
        USERNAME.set(user);
    }


//    public void login(String user , String password ,HttpServletResponse response){
//
//        if (password.equals("1234")){
//            String token = getUUID();
//            System.out.println(token);
//            stringRedisTemplate.opsForValue().set(token,user);
//            Cookie cookie = new Cookie("token",token);
//            response.addCookie(cookie);
//        }
//
//    }
//
//    public static String getUUID(){
//        String uuidStr = UUID.randomUUID().toString();
//        uuidStr = uuidStr.replace("-","");
//        return uuidStr;
//    }
}
