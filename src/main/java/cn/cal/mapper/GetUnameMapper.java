package cn.cal.mapper;

/**
 * Created by Admin on 2016/7/18.
 */
public interface GetUnameMapper extends SqlMapper{

    String getUnameBysession(String sessionid);

}
