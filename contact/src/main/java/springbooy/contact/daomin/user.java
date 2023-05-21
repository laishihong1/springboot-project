package springbooy.contact.daomin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@TableName(value = "user")
public class user  {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;  //用户id

    @JsonProperty(value = "userName")
    private String userName; //用户名

    @JsonProperty(value = "userUserEquipemt")
    private String userUsedEquipment;//用户使用登陆设备

    @JsonProperty(value = "userOnlineTime")
    private Date userOnlineTime;//用户上次在线时间

    @JsonProperty(value = "userTotalTime")
    private Time userTotalTime;//用户总在线时长

    @JsonProperty(value = "userLocation")
    private String userLocation;//用户当前在线位置

    @JsonProperty(value = "mark")
    private int mark;

    @TableField(exist = false)

    @JsonProperty(value = "userAccount")
    private String userAccount;
}
