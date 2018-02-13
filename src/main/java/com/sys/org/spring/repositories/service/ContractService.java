package com.sys.org.spring.repositories.service;

import com.sys.org.spring.idclass.ContractPK;
import com.sys.org.spring.model.Contract;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.util.Assert;

public class ContractService {
    private final CassandraOperations operations;

    public ContractService(CassandraOperations operations) {
        this.operations = operations;
    }
}
