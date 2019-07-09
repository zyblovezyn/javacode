import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Administrator
 * @title: ManApplication
 * @projectName user-service-consumer
 * @description: TODO
 * @date 2019/7/9 000922:41
 */
public class ManApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ((ClassPathXmlApplicationContext) ioc).start();

        System.in.read();
    }
}
