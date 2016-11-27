package cn.cal.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Admin on 2016/7/21.
 */
@Controller
public class TestSession {

    @RequestMapping("/sessionTest")
    public String sessionTest(HttpServletRequest request, HttpServletResponse response){

        System.out.println("success!");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);

        request.setAttribute("creationtime",session.getCreationTime());
        request.setAttribute("id",session.getId());
        request.setAttribute("max",session.getMaxInactiveInterval());
        request.setAttribute("lasttime",session.getLastAccessedTime());
        request.setAttribute("sessionTest",session);
//        System.out.println(session.getCreationTime());
//        System.out.println(session.getMaxInactiveInterval());
//        System.out.println(session.getLastAccessedTime());

        return "page/showSession";
    }


}
