package springbooy.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springbooy.contact.controller.utils.R;
import springbooy.contact.dao.UserDao;
import springbooy.contact.dao.UserReplyDao;
import springbooy.contact.dao.UserStatisticsDao;
import springbooy.contact.daomin.user;
import springbooy.contact.daomin.user_reply;
import springbooy.contact.service.UserService;
import springbooy.contact.service.UserStatisticsService;
import springbooy.contact.service.impl.UserReplyService;

import java.util.Calendar;

@Controller
@ResponseBody
@RequestMapping("/simpleUser")
public class ControllerSimpleUser {
    @Autowired
    private UserDao userDao;

    //单用户数据
    @Autowired
    private UserService userService;
    @Autowired
    private UserReplyService userReplyService;
    @Autowired
    private UserReplyDao userReplyDao;

    @Autowired
    private UserStatisticsDao userStatisticsDao;



    //存储用户注册信息
    @PostMapping("/register")
    public R register(@RequestBody user_reply user){
        boolean save = userReplyService.save(user);
         if(save==true){
             Calendar cal = Calendar.getInstance();
             int month=cal.get(Calendar.MONTH) + 1;
             userStatisticsDao.addReplyPeople(month);
           return new R(true);
         }
          return new R(false);
    }

    @PostMapping("login")
    //用户登陆方法✔
    public R login(@RequestBody user_reply user) {
        System.out.println(user.getReplyAccount());
        System.out.println(user.getReplyPassword());

        if (userReplyService.login(user.getReplyAccount(), user.getReplyPassword())) {

           try{
               userDao.updateMark(1, userDao.getSimpleMessage(user.getReplyAccount(), user.getReplyPassword()).getId());
               Calendar cal = Calendar.getInstance();
               int month=cal.get(Calendar.MONTH) + 1;
               userStatisticsDao.addOnlinePeople(month);

               return new R(true);
           }
             catch (Exception e){
               return new R(false);
             }
        }
         else{
             return new R(false);
        }

    }


    //用户登陆后返回用户信息购✔
    @PostMapping
    public R SingleUserMessage(@RequestBody user_reply user){

        springbooy.contact.daomin.user simpleMessage = userDao.getSimpleMessage(user.getReplyAccount(), user.getReplyPassword());
        return new R(true,simpleMessage);
    }

    //同意当前用户注册
    @PostMapping("agreeReplyUser/{id}")
    public R save(@PathVariable Integer id) {
       try{
           userReplyDao.updateMark(1, id);
           Calendar cal = Calendar.getInstance();
           int month=cal.get(Calendar.MONTH) + 1;
           userStatisticsDao.addReplypassNumber(month);
           return new R(true);
       }catch (Exception e){
            return new R(false);
       }
    }

    //通过id 方式删除对应用户信息
    @DeleteMapping("deleteReplyUser/{id}")
    public R delete(@PathVariable Integer id) {
      try{
          userReplyService.removeById(id);
          userService.removeById(id);
          Calendar cal = Calendar.getInstance();
          int month=cal.get(Calendar.MONTH) + 1;
          userStatisticsDao.addFailedReplyNumber(month);
          return new R(true);
      }catch (Exception e){
           return new R(false);
      }
    }

    //用户修改信息
    @PostMapping("updateUser")
    public R UpdateById(@RequestBody user user) {
        return new R(userService.updateById(user));
    }

}
