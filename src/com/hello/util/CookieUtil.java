package com.hello.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    private CookieUtil() {
    }

     /**
     * 添加cookie
     * 
17     * @param response
18      * @param name
19      * @param value
20      * @param maxAge
21      */
     public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
       response.addCookie(cookie);
    }
   /**
32      * 删除cookie
33      * 
34      * @param response
35      * @param name
36      */
     public static void removeCookie(HttpServletResponse response, String name) {
         Cookie uid = new Cookie(name, null);
         uid.setPath("/");
         uid.setMaxAge(0);
        response.addCookie(uid);
    }

    /**
45      * 获取cookie值
46      * 
47      * @param request
48      * @return
49      */
     public static String getUid(HttpServletRequest request,String cookieName) {
         Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
             if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
         return null;
    }
 }