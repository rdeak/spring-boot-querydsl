package hr.com.deak.querydsldemo.repository;

import hr.com.deak.querydsldemo.config.PersistenceConfig;
import hr.com.deak.querydsldemo.dto.ApplicationType;
import hr.com.deak.querydsldemo.dto.Limit;
import hr.com.deak.querydsldemo.dto.LimitType;
import hr.com.deak.querydsldemo.entity.LimitEntity;
import hr.com.deak.querydsldemo.entity.embeddable.LimitIdEmbeddable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static hr.com.deak.querydsldemo.entity.QLimitEntity.limitEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({PersistenceConfig.class})
public class LimitEntityRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    LimitEntityRepository limitEntityRepository;

    @Test
    public void givenLimitRepository_whenSave_thenOk(){
        LimitEntity entity = new LimitEntity()
                .setId(
                        new LimitIdEmbeddable(
                                "1",
                                LocalDate.now(),
                                ApplicationType.WEB,
                                LimitType.TRANSACTION
                        )
                );
        entityManager.persistAndFlush(entity);

        Optional<LimitEntity> fetchedEntity = limitEntityRepository.findById(entity.getId());
        assertThat(fetchedEntity.isPresent(), is(true));
    }

}