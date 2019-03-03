package hr.com.deak.querydsldemo.repository.impl;

import hr.com.deak.querydsldemo.config.PersistenceConfig;
import hr.com.deak.querydsldemo.dto.ApplicationType;
import hr.com.deak.querydsldemo.dto.Limit;
import hr.com.deak.querydsldemo.dto.LimitType;
import hr.com.deak.querydsldemo.entity.LimitEntity;
import hr.com.deak.querydsldemo.entity.embeddable.LimitIdEmbeddable;
import hr.com.deak.querydsldemo.repository.LimitEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static hr.com.deak.querydsldemo.entity.QLimitEntity.limitEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({PersistenceConfig.class})
public class LimitEntityCustomRepositoryImplTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    LimitEntityRepository limitEntityRepository;

    @Test
    public void givenLimitRepository_whenFindLimit_thenOk(){
        entityManager.persistAndFlush(
                new LimitEntity()
                        .setId(
                                new LimitIdEmbeddable(
                                        "1",
                                        LocalDate.now(),
                                        ApplicationType.WEB,
                                        LimitType.TRANSACTION
                                )
                        )
                        .setAmount(new BigDecimal(100L))
                        .setTotalOrders(3)
        );
        entityManager.persistAndFlush(
                new LimitEntity()
                        .setId(
                                new LimitIdEmbeddable(
                                        "1",
                                        LocalDate.now().minusDays(1),
                                        ApplicationType.WEB,
                                        LimitType.TRANSACTION
                                )
                        )
                        .setAmount(new BigDecimal(100L))
                        .setTotalOrders(3)
        );

        List<Limit> limits = limitEntityRepository.findLimit(limitEntity.id.clientReferenceId.eq("1"));

        assertThat(limits, hasSize(1));
    }

}