package com.tdeado.utils.network;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pangPython
 *  Cookie工具类
 */
public class CookieUtil {
    /**
     * 从cookie数组中获取指定key的cookie
     * @param cookies
     * @param target
     * @return
     */
    public static Cookie getCookieFromCookies(Cookie[] cookies, String target){
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals(target)){
                cookie = cookies[i];
            }
        }

        return cookie;
    }

    /**
     * 删除所有cookie
     * @param req
     * @param resp
     */
    public static void removeAllCookies(HttpServletRequest req, HttpServletResponse resp){
            Cookie[] cookies = req.getCookies();
            for(Cookie cookie: cookies){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }
    }

    /**
     * 根据cookie名称移除cookie
     * @param cookie_name
     * @param request
     * @param resp
     */
    public static void removeCookieByName(String cookie_name,HttpServletRequest request,HttpServletResponse resp){
        Cookie cookie = null;
           Cookie[] cookies = null;
           // 获取当前域名下的cookies，是一个数组
           cookies = request.getCookies();
           if( cookies != null ){
              for (int i = 0; i < cookies.length; i++){
                 cookie = cookies[i];
                 if((cookie.getName()).compareTo(cookie_name) == 0 ){
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                 }
              }
           }
    }

    /**
     * 设置cookie
     * @param response
     * @param key
     * @param value
     */
    public static void setCookie(HttpServletResponse response,String key,String value){
        // 新建cookie 客户浏览器端保存当前用户的id
        // key-value格式 key-loginuser value-当前用户的id
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        // 设置客户端cookie
        response.addCookie(cookie);
    }

}