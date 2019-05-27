package tk.mybatis.simple;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
/*@MapperScan(basePackages = "tk.mybatis.simple.mapper")*/
public class SimpleApplication {


    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }


}


