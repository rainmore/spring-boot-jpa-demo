package net.rainmore.services;

import net.rainmore.domains.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface GenericRepository<T extends Model, ID extends Serializable> extends
        JpaRepository<T, ID>,
        QueryDslPredicateExecutor<T> {

}
