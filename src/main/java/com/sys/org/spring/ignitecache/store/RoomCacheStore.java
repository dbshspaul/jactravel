package com.sys.org.spring.ignitecache.store;

import com.sys.org.spring.idclass.RoomPK;
import com.sys.org.spring.model.Room;
import com.sys.org.spring.repositories.RoomRepository;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RoomCacheStore extends CacheStoreAdapter<RoomPK, Room> {
    Logger logger = LoggerFactory.getLogger(RoomCacheStore.class);
    @Autowired
    private static RoomRepository roomRepository;


    @Override
    public Room load(RoomPK roomPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + roomPK + ']');
        return roomRepository.findOne(roomPK);
    }

    @Override
    public void write(Cache.Entry<? extends RoomPK, ? extends Room> entry) throws CacheWriterException {
        RoomPK key = entry.getKey();
        Room value = entry.getValue();
        try {
            logger.info(">>> Store write [key=" + key + ", val=" + value + ']');
            roomRepository.save(value);
//            ProducerUtil.sendMessage("kafkaCacheTopic", value.toString());
        } catch (Exception e) {
//            ProducerUtil.sendMessage("kafkaErrorTopic", value.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {
        try {
            roomRepository.delete((RoomPK) o);
            logger.info("<<< Rate Successfully deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
