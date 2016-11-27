package cn.cal.test;

import cn.cal.entity.Tion;
import cn.cal.mapper.ShowCondMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Admin on 2016/7/19.
 */


@Controller
public class ShowCondition {

    @Autowired
    ShowCondMapper showCondMapper;

    @RequestMapping("/Show.htm")
    public String showCondition(HttpServletRequest request){
        List<Tion> lt = showCondMapper.showCondi();
        for(Tion t:lt)
            System.out.println(t);
        request.setAttribute("condlist",lt);
        return "page/showcond";
    }

}
