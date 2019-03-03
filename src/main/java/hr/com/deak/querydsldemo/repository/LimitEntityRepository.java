package hr.com.deak.querydsldemo.repository;

import hr.com.deak.querydsldemo.entity.LimitEntity;
import hr.com.deak.querydsldemo.entity.embeddable.LimitIdEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;

public interface LimitEntityRepository extends
        JpaRepository<LimitEntity, LimitIdEmbeddable>,
        QuerydslPredicateExecutor<LimitEntity>,
        RevisionRepository<LimitEntity, LimitIdEmbeddable, Integer>,
        LimitEntityCustomRepository {
}
