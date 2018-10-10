package hello;

import com.google.gson.Gson;
import hello.dao.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * guides https://spring.io/guides/gs/spring-boot/
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Map map = new HashMap();
        Person person = new Person("ss", 20);
//        person
        map.put("data", person);
//         gson.toJson(map);
        System.out.println(gson.toJson(map));
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//        };
//    }
}
