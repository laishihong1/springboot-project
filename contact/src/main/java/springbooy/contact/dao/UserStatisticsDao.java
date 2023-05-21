package springbooy.contact.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import springbooy.contact.daomin.user_statistics;

@Mapper
@Repository
public interface UserStatisticsDao extends BaseMapper<user_statistics> {

    //保证数据库字段名与实体类型相同
    @Insert("insert into user_statistics('month') value(#{month})'")
    public void insertInMonthNext(int month);

    //每次有用户登陆，数量加一
    @Update("update user_statistics set online_people=online_people+1 where month=#{month}")
    public void addOnlinePeople(int month);

    //每次有用户注册，数量加一
    @Update("update user_statistics set reply_people=reply_people+1 where month=#{month}")
    public void addReplyPeople(int month);

    //每次有用户注册通过，数量加一
    @Update("update user_statistics set reply_pass_number=reply_pass_number+1 where month=#{month}")
    public void addReplypassNumber(int month);

    //每次有用户注册撤回，数量加一
    @Update("update user_statistics set failed_reply_number=failed_reply_number+1 where month=#{month}")
    public void addFailedReplyNumber(int month);

}
