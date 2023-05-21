package springbooy.contact.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import springbooy.contact.dao.UserStatisticsDao;

import java.util.Calendar;

@Component
public class SendWsListener  {

    @Autowired
    private UserStatisticsDao userStatistics;
    //创建一个月份定时器，用于统计每月用户信息, 每月最后一日的晚上23：55触发
   @Scheduled(cron = "0 55 23 L * ? ")
   public void addMonthInNext(){
       Calendar cal = Calendar.getInstance();
       int month=cal.get(Calendar.MONTH) + 1;
       userStatistics.insertInMonthNext(month);
   }

}


