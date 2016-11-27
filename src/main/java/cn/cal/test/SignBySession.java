package cn.cal.test;

import cn.cal.entity.Tion;
import cn.cal.mapper.GetUnameMapper;
import cn.cal.mapper.SignConditionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 2016/7/18.
 */
@Controller
public class SignBySession {

    @Autowired
    private GetUnameMapper gum;

    @Autowired
    private SignConditionMapper scm;

    @RequestMapping("/SessionRem2.htm")
    public String signFirst(HttpServletRequest request){
        String uname;
        HttpSession session = request.getSession();
        /**
         * 获取本次签到用户的用户名
         */
            uname= (String) request.getSession().getAttribute("secondname");
//            uname = gum.getUnameBysession(request.getRequestedSessionId());
            request.setAttribute("uname", uname);


        /**
         * 记录用户签到时间到数据库
         */
        Tion tion = new Tion();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-HH-mm");
        tion.setSigntime(sdf.format(new Date()));
        tion.setSignrank("");
        tion.setUname(uname);
        scm.signcond(tion);




        return "page/shownotfirst";
    }

}
