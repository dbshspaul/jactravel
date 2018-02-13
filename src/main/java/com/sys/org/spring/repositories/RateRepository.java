package com.sys.org.spring.repositories;

import com.sys.org.spring.model.Rate;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CassandraRepository<Rate> {
}
