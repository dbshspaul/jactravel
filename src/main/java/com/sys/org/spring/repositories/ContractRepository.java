package com.sys.org.spring.repositories;

import com.sys.org.spring.idclass.ContractPK;
import com.sys.org.spring.model.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends CrudRepository<Contract, ContractPK> {

}
