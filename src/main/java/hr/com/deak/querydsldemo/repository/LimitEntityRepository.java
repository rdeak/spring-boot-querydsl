package hr.com.deak.querydsldemo.repository;

import hr.com.deak.querydsldemo.entity.LimitEntity;
import hr.com.deak.querydsldemo.entity.embeddable.LimitIdEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface LimitEntityRepository extends
        JpaRepository<LimitEntity, LimitIdEmbeddable>,
        QuerydslPredicateExecutor<LimitEntity>,
        LimitEntityCustomRepository {
}
