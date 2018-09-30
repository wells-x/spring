package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        System.out.println("Success");
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/")
    public String postIndex() {
        return "Post";
    }
}
