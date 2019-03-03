package hr.com.deak.querydsldemo.repository.impl;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import hr.com.deak.querydsldemo.entity.ApplicationTypeEntity;
import hr.com.deak.querydsldemo.repository.ApplicationTypeEntityCustomRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static hr.com.deak.querydsldemo.entity.QApplicationTypeEntity.applicationTypeEntity;

public class ApplicationTypeEntityCustomRepositoryImpl implements ApplicationTypeEntityCustomRepository {

    private final EntityManager entityManager;

    public ApplicationTypeEntityCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ApplicationTypeEntity> activeApps(Predicate predicate) {
        return new JPAQuery<ApplicationTypeEntity>(entityManager)
                .from(applicationTypeEntity)
                .where(applicationTypeEntity.active.eq(true).and(predicate))
                .fetch();
    }
}
