package hr.com.deak.querydsldemo.repository;

import com.querydsl.core.types.Predicate;
import hr.com.deak.querydsldemo.dto.Limit;

import java.util.List;

public interface LimitEntityCustomRepository {

    List<Limit> findLimit(Predicate predicate);

}
