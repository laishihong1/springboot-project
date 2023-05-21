package springbooy.contact.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import springbooy.contact.daomin.user;
import springbooy.contact.daomin.user_reply;

import java.util.List;

@Component
public interface UserService extends IService<user> {

    List<user> getAllUser(Integer currentPage,Integer pageSize);
    List<user>getUserSearch(String name,String location,Integer currentPage,Integer pageSize);
    boolean isPhone(String phone);
}
