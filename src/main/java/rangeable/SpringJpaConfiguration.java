package rangeable;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import rangeable.jpa.RangeableRepositoryImpl;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = RangeableRepositoryImpl.class)
public class SpringJpaConfiguration {
}
