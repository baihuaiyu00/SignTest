package cn.cal.entity;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Admin on 2016/7/18.
 */
public class Tion implements Serializable{

    String signtime;
    String signrank;
    String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSigntime() {
        return signtime;
    }

    public void setSigntime(String signtime) {
        this.signtime = signtime;
    }

    public String getSignrank() {
        return signrank;
    }

    public void setSignrank(String signrank) {
        this.signrank = signrank;
    }

    @Override
    public String toString() {
        return "Tion{" +
                "signtime='" + signtime + '\'' +
                ", signrank='" + signrank + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}
