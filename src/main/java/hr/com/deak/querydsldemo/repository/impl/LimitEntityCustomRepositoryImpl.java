package hr.com.deak.querydsldemo.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQuery;
import hr.com.deak.querydsldemo.dto.ApplicationType;
import hr.com.deak.querydsldemo.dto.Limit;
import hr.com.deak.querydsldemo.dto.LimitType;
import hr.com.deak.querydsldemo.repository.LimitEntityCustomRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static hr.com.deak.querydsldemo.entity.QLimitEntity.limitEntity;

public class LimitEntityCustomRepositoryImpl implements LimitEntityCustomRepository {

    private final EntityManager entityManager;

    public LimitEntityCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Limit> findLimit(Predicate predicate){

        NumberExpression<BigDecimal> dailyLimit = new CaseBuilder()
                .when(limitEntity.id.transactionDate.eq(LocalDate.now())).then(limitEntity.amount)
                .otherwise(BigDecimal.ZERO);

        List<Tuple> rows = new JPAQuery<Limit>(entityManager)
                .select(
                        limitEntity.id.limitType,
                        limitEntity.id.applicationType,
                        dailyLimit.sum(),
                        limitEntity.amount.sum()
                )
                .from(limitEntity)
                .where(predicate)
                .fetch();

        List<Limit> limits = new ArrayList<>();
        for( Tuple row : rows){
            limits.add(
                    new Limit()
                    .setLimitType(row.get(0, LimitType.class))
                    .setApplicationType(row.get(1, ApplicationType.class))
                    .setDailyLimit(row.get(2, BigDecimal.class))
                    .setMonthlyLimit(row.get(3, BigDecimal.class))
            );
        }
        return limits;
    }

}
