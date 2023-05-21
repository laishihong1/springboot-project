package springbooy.contact.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import springbooy.contact.daomin.user;

import java.util.List;

@Mapper
@Repository
public interface UserDao  extends BaseMapper<user> {

    //保证数据库字段名与实体类型相同
    @Select("SELECT* FROM USER WHERE user.id IN(SELECT id FROM user_reply WHERE reply_account=#{account} AND reply_password=#{password})")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_used_equipment", property="userUsedEquipment", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_online_time", property="userOnlineTime", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_total_time", property="userTotalTime", jdbcType=JdbcType.DATE),
            @Result(column="user_location", property="userLocation", jdbcType=JdbcType.TIME),
            @Result(column="mark", property="mark", jdbcType=JdbcType.INTEGER),
    })
    user getSimpleMessage(String account,  String password);


    @Update("update user set mark=#{mark} where id =#{id}")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
            @Result(column="mark", property="mark", jdbcType=JdbcType.INTEGER),
    })
    void updateMark(int mark,int id);

    //查询对应页的数据
    @Select("select *from user limit #{currentPage},#{pageSize}")
    List<user>getAllUser(@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);

    //查询所查数据对应页数据
    @Select("select*from user where user_name=#{name} and user_location=#{location} limit #{currentPage},#{pageSize}")
    List<user>getUserSearch(String name,String location,@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);


}
