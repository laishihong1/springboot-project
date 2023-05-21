package springbooy.contact.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import springbooy.contact.daomin.user;
import springbooy.contact.daomin.user_reply;

import java.util.List;

@Mapper
@Repository
public interface UserReplyDao extends BaseMapper<user_reply> {

    @Update("update user_reply set mark=#{mark} where id =#{id}")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
            @Result(column="mark", property="mark", jdbcType=JdbcType.INTEGER),
    })
    void updateMark(int mark,int id);

//查询所有用户的账号
    @Select("SELECT reply_account FROM user_reply JOIN USER ON user_reply.id=user.id  limit #{currentPage},#{pageSize}")
    List<user_reply> getAllAccount(@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

 //查询对应用户账号
 @Select("select reply_account from user_reply where reply_account=#{account}  limit #{currentPage},#{pageSize}")
 List<user_reply> getAccountSearch(@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize,String account);

    //查询所有所有注册数据
    @Select("select *from user_reply limit #{currentPage},#{pageSize}")
    List<user_reply>getAllUserReply(@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);

    //根据账号密码查询对应页码数据
    @Select("select * from user_reply where reply_account=#{account} and reply_password=#{password} limit #{currentPage},#{pageSize}")
    List<user_reply> getUserReplySearch(String account,String password,@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

}
