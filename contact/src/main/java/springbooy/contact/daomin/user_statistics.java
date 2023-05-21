package springbooy.contact.daomin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;

//使用驼峰命名解决mybatis 数据返回为空
//每月对应储存的用户数据
@Data
@TableName(value = "user_statistics")
public class user_statistics {

         private int month; //月份

         private int onlinePeople; //当月对应的在线人数

         private int replyPeople;  //当月对应的注册人数

         private int replyPassNumber;  //当月申请通过的人数

         private int failedReplyNumber; //当月申请撤回的人数

//         @TableField(value= "false")
//        private int totalReplyNumber;
//
//         @TableField(value = "false")
//        private int totalReplyPassNumber;

}
