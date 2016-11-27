package cn.cal.test;

import cn.cal.mapper.AddUserMapper;
import cn.cal.entity.Member;
import cn.cal.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Admin on 2016/7/18.
 */
@Controller
public class RemeberSession {

    @RequestMapping("/ShowIp2.htm")
    public String getIp(HttpServletRequest request){
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemoteAddr());
        request.setAttribute("userip",request.getRemoteAddr());
        return "page/showip";
    }
//
//    @RequestMapping("/ShowIp2.htm")
//    public String getIpAddr(HttpServletRequest request){
//        String ipAddress = request.getHeader("x-forwarded-for");
//        System.out.println("x-forwarded-for:"+ipAddress);
//        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//            ipAddress = request.getHeader("Proxy-Client-IP");
//            System.out.println("Proxy-Client-IP:"+ipAddress);
//        }
//        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//            ipAddress = request.getHeader("WL-Proxy-Client-IP");
//            System.out.println("WL-Proxy-Client-IP:"+ipAddress);
//        }
//        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//            ipAddress = request.getRemoteAddr();
//            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
//                //根据网卡取本机配置的IP
//                InetAddress inet=null;
//                try {
//                    inet = InetAddress.getLocalHost();
//                    System.out.println("inet:"+inet);
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//                ipAddress= inet.getHostAddress();
//                System.out.println("final ip:"+ipAddress);
//            }
//        }
//        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
//        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
//            if(ipAddress.indexOf(",")>0){
//                System.out.println("real final:"+ipAddress);
//                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
//            }
//        }
//        System.out.println("登录用户的IP是"+ipAddress);
//        System.out.println("用户的主机名是"+request.getRemoteHost());
//        System.out.println("用户的名字是"+request.getRemoteUser());
//        System.out.println();
//        request.setAttribute("userip",ipAddress);
//        return "page/showip";
//    }

    @Autowired
    private AddUserMapper addUserMapper;

    @RequestMapping("/SessionRem.htm")
    public String remSession(HttpServletRequest request, HttpServletResponse response){

            String sid = request.getParameter("uid");
            String sname = request.getParameter("uname");
            Member member = new Member();
            member.setSid(sid);
            member.setSname(sname);
            member.setSession(request.getRequestedSessionId());
            addUserMapper.addUser(member);

            HttpSession session = request.getSession(true);
            session.setAttribute("Member", member);

        System.out.println("--------------首次签到---------------");
        System.out.println("首次签到拿到的"+request.getRequestedSessionId());
        System.out.println("创建时间"+session.getCreationTime());
        System.out.println("最近访问时间"+session.getLastAccessedTime());
        System.out.println("最大不活动时间"+session.getMaxInactiveInterval());
        System.out.println("获取到的名字:"+sname);
        System.out.println("------------------------------------");
        try {
            CookieUtil.addCookie(sname,request.getRequestedSessionId(),3600 * 24 * 30,response);
            System.out.println("成功添加了一个Cookie到浏览器本地");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "page/showip";
    }

}
