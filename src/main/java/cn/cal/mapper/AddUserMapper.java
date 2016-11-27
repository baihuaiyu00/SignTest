package cn.cal.mapper;

import cn.cal.entity.Member;

/**
 * Created by Admin on 2016/7/18.
 */
public interface AddUserMapper extends SqlMapper {

    public void addUser(Member member);

}
