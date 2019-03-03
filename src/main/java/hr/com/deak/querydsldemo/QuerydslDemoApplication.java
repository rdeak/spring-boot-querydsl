package hr.com.deak.querydsldemo;

import hr.com.deak.querydsldemo.dto.ApplicationType;
import hr.com.deak.querydsldemo.dto.LimitType;
import hr.com.deak.querydsldemo.entity.ApplicationTypeEntity;
import hr.com.deak.querydsldemo.entity.LimitEntity;
import hr.com.deak.querydsldemo.entity.embeddable.LimitIdEmbeddable;
import hr.com.deak.querydsldemo.repository.ApplicationTypeEntityRepository;
import hr.com.deak.querydsldemo.repository.LimitEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class QuerydslDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerydslDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initApps(ApplicationTypeEntityRepository applicationTypeEntityRepository){
        return args -> {
            applicationTypeEntityRepository.save(
                    new ApplicationTypeEntity()
                    .setName("MOBILE")
                    .setActive(true)
            );
            applicationTypeEntityRepository.save(
                    new ApplicationTypeEntity()
                            .setName("WEB")
                            .setActive(true)
            );
            applicationTypeEntityRepository.save(
                    new ApplicationTypeEntity()
                            .setName("BLACKBERRY")
                            .setActive(false)
            );
        };
    }

    @Bean
    public CommandLineRunner initLimits(LimitEntityRepository limitEntityRepository){
        return args -> {
            limitEntityRepository.save(
                    new LimitEntity()
                    .setId(
                            new LimitIdEmbeddable(
                                    "1",
                                    LocalDate.now(),
                                    ApplicationType.WEB,
                                    LimitType.TRANSACTION
                            )
                    )
                    .setTotalOrders(0)
                    .setAmount(BigDecimal.ZERO)
            );
        };
    }

}
