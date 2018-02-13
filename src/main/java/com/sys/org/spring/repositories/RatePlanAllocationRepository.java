package com.sys.org.spring.repositories;

import com.sys.org.spring.model.RatePlanAllocation;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * created by My System on 21-Dec-17
 **/
public interface RatePlanAllocationRepository extends CassandraRepository<RatePlanAllocation> {
}
