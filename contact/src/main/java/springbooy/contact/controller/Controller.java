package springbooy.contact.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springbooy.contact.controller.utils.R;
import springbooy.contact.daomin.user;
import springbooy.contact.daomin.user_reply;
import springbooy.contact.daomin.user_statistics;
import springbooy.contact.service.UserService;
import springbooy.contact.service.UserStatisticsService;
import springbooy.contact.service.impl.UserReplyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller

@RequestMapping("/user")
@ResponseBody

public class Controller {

    //单用户数据
    @Autowired
    private UserService userService;
    //所有用户数据
    @Autowired
    private UserReplyService userReplyService;

    @Autowired
    private UserStatisticsService userStatisticsService;

    //获取本月用户对应数据✔
    @GetMapping("/user_statistics")
    public R getUserStatistics(){
        List<user_statistics> list = userStatisticsService.list();
        int totalReplyNumber=0;
        int totalReplyPassNumber=0;
        for (user_statistics item:list) {
            totalReplyNumber+=item.getReplyPeople();
            totalReplyPassNumber+= item.getReplyPassNumber();
        }

        Map<String,Object>map=new HashMap<>();
        map.put("user_statistics",userStatisticsService.list());
        map.put("totalReplyNumber",totalReplyNumber);        //每年的申请总人数
        map.put("totalReplyPassNumber",totalReplyPassNumber); //每年通过申请的人数
        return new R(true,map);
    }

    //返回所有已注册用户数据✔
    @GetMapping("/userAll/{currentPage}/{pageSize}")
    public R getUserAll(@PathVariable int currentPage, @PathVariable int pageSize) {
         try{

             List<user>data=userService.getAllUser((currentPage-1)*currentPage,pageSize);
             List<user_reply>account=userReplyService.getAllAccount((currentPage-1)*currentPage,pageSize);

             int num=0;
             for (user user:data) {

                user.setUserAccount(account.get(num).getReplyAccount());
                num++;
             }

             return new R(true,data);
         }catch (Exception e){
             return new R(false);
         }
    }

    //返回查询已注册用户的数据✔
     @GetMapping("userSearch/{currentPage}/{pageSize}")
     public R getUserSearch(@PathVariable int currentPage, @PathVariable int pageSize,@PathVariable user user){
       try{
           List<user>data=userService.getUserSearch(user.getUserName(), user.getUserLocation(), currentPage,pageSize);
           List<user_reply>account=userReplyService.getAccountSearch(currentPage,pageSize,user.getUserAccount());
           int num=0;
           for (user users:data) {

               users.setUserAccount(account.get(num).getReplyAccount());
               num++;
           }

           return new R(true, data);
       }catch (Exception e){
             return new R(false);
       }
     }

    //返回所有当前已注册通过的用户信息
//    @GetMapping("/registerPass")
//    public R getAllRegisterPass(){
////        return new R(true,userService.list());
//        return new R(true);
//    }

    //返回所有注册用户信息✔
    @GetMapping("userReplyAll/{currentPage}/{pageSize}")
    public R getUserReplyAll(@PathVariable int currentPage, @PathVariable int pageSize) {
       try{
           return new R(true,userReplyService.getAllUserReply((currentPage-1)*currentPage,pageSize));
       }catch (Exception e){
           return new R(false);
       }
    }

    //返回对应查询注册用户信息✔
    @GetMapping("userReplySearch/{currentPage}/{pageSize}")
    public R getUserReplySearch(@PathVariable int currentPage, @PathVariable int pageSize,@PathVariable user_reply user_reply) {

       try{
           return new
                   R(true,
                   userReplyService.getUserReplySearch
                           (user_reply.getReplyAccount(),user_reply.getReplyPassword(),currentPage,pageSize));
       }catch (Exception e){
           return new R(false);
       }

    }



}
