package cn.cal.test;

import cn.cal.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by Admin on 2016/7/18.
 */
@Controller
public class CheckSession {

    @RequestMapping("/checkSession.htm")
    public String checkSession(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        if(request.getRemoteAddr().equals("117.32.216.61")) {
            Cookie c;
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for (int i = 0; i < cookies.length; i++) {
                    c = cookies[i];
                    System.out.println("---------------------------");
                    System.out.println("里面有名字:" + c.getName());
                    System.out.println("里面有值:" + c.getValue());
                    System.out.println("---------------------------");
                    if (!"JSESSIONID".equals(c.getName())) {
                        String cookiename = c.getName();
                        String cookievalue = CookieUtil.findCookie(cookiename, request);
                        Cookie ck = new Cookie(cookiename, cookievalue);
                        //response.addCookie(ck);
                        CookieUtil.addCookie(cookiename, cookievalue, 3600 * 24 * 30, response);
                        System.out.println("找到了Cookie");
//                    request.setAttribute("secondname",cookiename);
                        request.getSession().setAttribute("secondname", cookiename);

                        request.getSession();
                        System.out.println("把名字" + cookiename + "放入了page域中");
                        return "page/turn";
                    }

                }
            }
            return "page/index";
        }
        return "page/wrongIp";
    }
}


