package cn.cal.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtil {
   // private static int age = 3600 * 24; //缺省的生存时间
    private static String path = "/SignTest";
//应用名，如果要将该工具用在其它的应用当中，需要
//修改这个值。

    /**
     * 添加cookie,考虑了编码、生存时间、路径问题。
     */
    public static void addCookie(String name, String value, int age, HttpServletResponse response) throws
            UnsupportedEncodingException {
        Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
        c.setMaxAge(age);
        c.setPath(path);
        response.addCookie(c);
    }
//从cookie中取出数据

    /**
     * 依据cookie的名称返回cookie的值，如果
     * 找不到对应的cookie,返回null。
     *
     * @throws UnsupportedEncodingException
     */
    public static String findCookie(String name, HttpServletRequest request) throws UnsupportedEncodingException {
        String value = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                if (c.getName().equals(name)) {
                    System.out.println("拿到的Cookie的名字"+c.getName());
                    value = URLDecoder.decode(c.getValue(), "utf-8");
                }
            }
        }
        return value;
    }
}
