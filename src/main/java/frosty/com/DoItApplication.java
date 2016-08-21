package frosty.com;

import frosty.com.dao.entity.BaseUser;
import frosty.com.dao.user.UserDao;
import frosty.com.dao.user.impl.UserDaoImpl;
import frosty.com.service.user.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DoItApplication {

	@Autowired(required = true)
	private UserService adminService;


	public static void main(String[] args) {


		SpringApplication.run(DoItApplication.class, args);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		BaseUser user = new BaseUser("gay");

	}
}
