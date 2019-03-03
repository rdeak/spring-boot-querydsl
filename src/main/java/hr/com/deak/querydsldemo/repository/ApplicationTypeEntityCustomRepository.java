package hr.com.deak.querydsldemo.repository;

import com.querydsl.core.types.Predicate;
import hr.com.deak.querydsldemo.entity.ApplicationTypeEntity;

import java.util.List;

public interface ApplicationTypeEntityCustomRepository {
    List<ApplicationTypeEntity> activeApps(Predicate predicate);
}
