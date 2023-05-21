package springbooy.contact.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import springbooy.contact.dao.UserStatisticsDao;
import springbooy.contact.daomin.user_statistics;

@Service
public class UserStatisticsService extends ServiceImpl<UserStatisticsDao, user_statistics> implements springbooy.contact.service.UserStatisticsService {

}
