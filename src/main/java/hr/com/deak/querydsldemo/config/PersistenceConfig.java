package hr.com.deak.querydsldemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        basePackages = "hr.com.deak.querydsldemo",
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class
)
@EnableJpaAuditing
@EnableTransactionManagement
public class PersistenceConfig {
}
