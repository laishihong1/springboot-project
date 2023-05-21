package springbooy.contact;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springbooy.contact.dao.UserDao;
import springbooy.contact.daomin.user;
import springbooy.contact.daomin.user_reply;
import springbooy.contact.daomin.user_statistics;
import springbooy.contact.service.UserService;
import springbooy.contact.service.UserStatisticsService;
import springbooy.contact.service.impl.UserReplyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ContactApplicationTests {
      @Autowired

      private UserReplyService userReplyService;

      @Autowired
	  private UserDao userDao;

      @Autowired
      private UserService userService;

	@Autowired
	private UserStatisticsService userStatisticsService;

	@Test
	void contextLoads() {
		user_reply user=new user_reply();

       // user.setId(1);
        user.setReplyAccount("123456");
		user.setReplyPassword("123456");
//		user.setReplyReason("sdadadasdaddas");
//		user.setMark('1');
		//userReplyService.save(user);

		if(userReplyService.login(user.getReplyAccount(),user.getReplyPassword())){

			System.out.println(true);
		}
		   else{
			System.out.println(false);
		}
	}
	@Test
	void register(){
//		System.out.println(userDao.getSimpleMessage("123456","123456"));
	}


	 @Test
	void getUserStatistics(){
		 List<user> list = userService.list();
		 System.out.println(list);
	 }


     @Test
    void  SingleUserMessage(){
		 user_reply user=new user_reply();
		 user.setReplyAccount("123456");
		 user.setReplyPassword("123456");
		// System.out.println(user);
		 springbooy.contact.daomin.user simpleMessage = userDao.getSimpleMessage(user.getReplyAccount(), user.getReplyPassword());

		 System.out.println(simpleMessage);
//		 System.out.println(simpleMessage.getId());


		 userDao.updateMark(0,simpleMessage.getId());

		// System.out.println(simpleMessage.getMark());
	 }
      @Test
       void getUserStatist(){
		  List<user_statistics> list = userStatisticsService.list();
		  int totalReplyNumber=0;
		  int totalReplyPassNumber=0;
		  for (user_statistics item:list) {
			  totalReplyNumber+=item.getReplyPeople();
			  totalReplyPassNumber+= item.getReplyPassNumber();
		  }

		  Map<String,Object> map=new HashMap<>();
		  map.put("user_statistics",userStatisticsService.list());
		  map.put(" totalReplyNumber",totalReplyNumber);        //每年的申请总人数
		  map.put("totalReplyPassNumber",totalReplyPassNumber); //每年通过申请的人数
		  System.out.println(map);
	  }

	//返回所有注册用户信息
    @Test
	  void  getUserReplyAll(){
		 int currentPage=0;
		 int pageSize=20;
		//userReplyService.getAllUserReply((currentPage-1)*currentPage,pageSize);
		System.out.println(userReplyService.getAllUserReply((currentPage-1)*currentPage,pageSize));
	}

	//返回对应查询注册用户信息
	@Test
	 void getUserReplySearch(){
		user_reply user_reply=new user_reply();
		user_reply.setReplyAccount("123456");
		user_reply.setReplyPassword("123456");
		int currentPage=0;
		int pageSize=20;
		System.out.println(userReplyService.getUserReplySearch
				(user_reply.getReplyAccount(),user_reply.getReplyPassword(),currentPage,pageSize));
	}

	@Test
	//返回查询已注册用户的数据
	void getUserSearch(){
		user user=new user();
		user.setId(1);
		user.setUserName("枫叶");
		user.setUserLocation("成都");
		user.setUserAccount("123456");
		int currentPage=0;
		int pageSize=20;

		List<user>data=userService.getAllUser((currentPage-1)*currentPage,pageSize);
		List<user_reply>account=userReplyService.getAllAccount((currentPage-1)*currentPage,pageSize);

		int num=0;
		for (user users:data) {

			users.setUserAccount(account.get(num).getReplyAccount());
			num++;
		}

		System.out.println(data);

	}

	//返回所有已注册用户数据
	@Test
	void getUserAll(){
		int currentPage=0;
		int pageSize=20;
		Map<String,Object>map=new HashMap<>();
		List<user>data=userService.getAllUser((currentPage-1)*currentPage,pageSize);
		map.put("userData",data);
		List<user_reply>account=userReplyService.getAllAccount((currentPage-1)*currentPage,pageSize);
		map.put("account",account);
		System.out.println(map);
	}




}


