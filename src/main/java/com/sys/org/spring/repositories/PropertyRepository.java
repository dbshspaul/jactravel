package com.sys.org.spring.repositories;

import com.sys.org.spring.idclass.PropertyPK;
import com.sys.org.spring.model.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property, PropertyPK> {
}
