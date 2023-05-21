package springbooy.contact.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbooy.contact.dao.UserReplyDao;
import springbooy.contact.daomin.user_reply;
import springbooy.contact.service.UserReply;

import java.util.List;

@Service
public class UserReplyService extends ServiceImpl<UserReplyDao, user_reply> implements UserReply{


   @Autowired
   private  UserReplyDao userReplyDao;
   //用户登陆
    @Override
    public Boolean login(String account, String password) {
        int count= (int) this.count
                (new LambdaQueryWrapper<user_reply>()
                        .exists("select reply_account,reply_password,mark from user_reply where reply_account='"+account+"' and reply_password='"+password+"' and mark='1'  LIMIT 1"));
        if(count>0){
            System.out.println(count);
            return true;
        }
        System.out.println(count);
        return false;
    }

    //查询所有注册账户账号
    @Override
    public List<user_reply> getAllAccount(Integer currentPage, Integer pageSize) {
        return userReplyDao.getAllAccount(currentPage,pageSize);
    }

    //查询对应注册账户账号
    @Override
    public List<user_reply> getAccountSearch(Integer currentPage, Integer pageSize, String account) {
        return userReplyDao.getAccountSearch(currentPage,pageSize,account);
    }

    //查询所有注册账户
    @Override
    public List<user_reply> getAllUserReply(Integer currentPage, Integer pageSize) {
        return userReplyDao.getAllUserReply(currentPage,pageSize);
    }

    //查询对应注册账户
    @Override
    public List<user_reply> getUserReplySearch(String account,String password, Integer currentPage, Integer pageSize) {
        return userReplyDao.getUserReplySearch(account,password,currentPage,pageSize);
    }

}
