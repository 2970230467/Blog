package com.ruoyi.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.blog.common.security.annotation.EnableCustomConfig;
import com.blog.common.security.annotation.EnableRyFeignClients;
import com.blog.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 作业模块
 *
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RuoYiBusinessApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(RuoYiBusinessApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  作业模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
