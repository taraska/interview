package vaadin.ivannikov.app;

import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Arrays;

@SpringBootApplication
@Theme(value = "my-theme")
@PWA(
    name = "Vaadin Gradle Example",
    shortName = "Vaadin"
)
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        int[] arr = new int[3];
        Arrays.stream(arr).boxed().toList();
        SpringApplication.run(Application.class, args);
    }
}
