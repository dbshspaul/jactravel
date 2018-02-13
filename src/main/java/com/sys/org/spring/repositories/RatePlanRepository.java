package com.sys.org.spring.repositories;

import com.sys.org.spring.model.RatePlan;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatePlanRepository extends CassandraRepository<RatePlan> {
}
