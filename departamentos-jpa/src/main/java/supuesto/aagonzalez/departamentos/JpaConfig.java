package supuesto.aagonzalez.departamentos;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "supuesto.aagonzalez.departamentos")
@EntityScan(basePackages = "supuesto.aagonzalez.departamentos")
public class JpaConfig {

}
