package supuesto.aagonzalez.departamentos.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "supuesto.aagonzalez.departamentos")
@SpringBootApplication
public class DepartamentosBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DepartamentosBootApplication.class, args);
    }

}
