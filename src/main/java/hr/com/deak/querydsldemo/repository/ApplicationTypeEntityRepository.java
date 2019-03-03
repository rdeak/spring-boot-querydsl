package hr.com.deak.querydsldemo.repository;

import hr.com.deak.querydsldemo.entity.ApplicationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;

public interface ApplicationTypeEntityRepository extends
        JpaRepository<ApplicationTypeEntity, Long>,
        QuerydslPredicateExecutor<ApplicationTypeEntity>,
        RevisionRepository<ApplicationTypeEntity, Long, Integer>,
        ApplicationTypeEntityCustomRepository
{

}
