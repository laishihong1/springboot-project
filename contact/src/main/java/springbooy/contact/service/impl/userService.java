package springbooy.contact.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbooy.contact.dao.UserDao;
import springbooy.contact.daomin.user;
import springbooy.contact.service.UserService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class userService extends ServiceImpl<UserDao, user>implements UserService {


    @Autowired
    private  UserDao userDao;

    //查询所有已注册用户数据
    @Override
    public List<user> getAllUser(Integer currentPage, Integer pageSize) {
        return userDao.getAllUser(currentPage,pageSize);
    }


    @Override
    public List<user> getUserSearch(String name, String location, Integer currentPage, Integer pageSize) {
        return userDao.getUserSearch(name,location,currentPage,pageSize);
    }

    @Override
    public boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    //判断是否为手机号码




}
