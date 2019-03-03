package hr.com.deak.querydsldemo.repository;

import hr.com.deak.querydsldemo.config.PersistenceConfig;
import hr.com.deak.querydsldemo.entity.ApplicationTypeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({PersistenceConfig.class})
public class ApplicationTypeEntityRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ApplicationTypeEntityRepository applicationTypeEntityRepository;

    @Test
    public void givenApplicationTypeEntityRepository_whenSave_thenOk() {
        ApplicationTypeEntity entity = applicationTypeEntityRepository.save(
                new ApplicationTypeEntity()
                        .setName("test")
                        .setActive(true)
        );

        ApplicationTypeEntity saved = entityManager.find(ApplicationTypeEntity.class, entity.getId());

        assertThat(saved, is(notNullValue()));
    }
}