package springbooy.contact.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;
import springbooy.contact.daomin.user_reply;

import java.util.List;

@Component
public interface UserReply extends IService<user_reply> {
    Boolean login(String account,String password);
    List<user_reply> getAllAccount(Integer currentPage,Integer pageSize);
    List<user_reply> getAccountSearch(Integer currentPage,Integer pageSize,String account);
    List<user_reply>getAllUserReply(Integer currentPage,Integer pageSize);
    List<user_reply> getUserReplySearch(String account,String password,Integer currentPage,Integer pageSize);
}
