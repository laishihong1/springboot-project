package springbooy.contact.daomin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;

//@JsonProperty 使前后端json key 一致，防止@RequestBody 解析不出来自前端对应数据

@Data
@TableName(value = "user_reply")
public class user_reply {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;  //用户id
    @JsonProperty(value = "replyTime")
    private Date replyTime; //用户注册时间
    @JsonProperty(value = "replyAccount")
    private String replyAccount; //用户账号
    @JsonProperty(value = "replyPassword")
    private String replyPassword;//用户密码
    @JsonProperty(value = "numberPhone")
    private String numberPhone;  //用户电话号码
    @JsonProperty(value = "replyReason")
    private String replyReason; //用户注册原因
    @JsonProperty(value = "mark")
    private char mark;  //判断用户是否允许注册账号



}
