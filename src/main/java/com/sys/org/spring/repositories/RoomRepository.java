package com.sys.org.spring.repositories;

import com.sys.org.spring.idclass.RoomPK;
import com.sys.org.spring.model.Room;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room,RoomPK> {
}
