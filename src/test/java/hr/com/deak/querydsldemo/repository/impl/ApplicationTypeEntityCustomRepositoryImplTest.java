package hr.com.deak.querydsldemo.repository.impl;


import hr.com.deak.querydsldemo.config.PersistenceConfig;
import hr.com.deak.querydsldemo.entity.ApplicationTypeEntity;
import hr.com.deak.querydsldemo.repository.ApplicationTypeEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({PersistenceConfig.class})
public class ApplicationTypeEntityCustomRepositoryImplTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ApplicationTypeEntityRepository applicationTypeEntityRepository;

    @Test
    public void givenApplicationTypeEntityRepository_whenActiveApps_thenOk() {
        entityManager.persistAndFlush(
                applicationTypeEntityRepository.save(
                        new ApplicationTypeEntity()
                                .setName("test")
                                .setActive(true)
                )
        );
        List<ApplicationTypeEntity> apps = applicationTypeEntityRepository.activeApps(null);
        assertThat(apps, hasSize(1));
    }
}