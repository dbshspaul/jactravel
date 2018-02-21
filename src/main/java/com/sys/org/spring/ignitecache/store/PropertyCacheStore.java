package com.sys.org.spring.ignitecache.store;

import com.sys.org.spring.idclass.PropertyPK;
import com.sys.org.spring.model.Property;
import com.sys.org.spring.repositories.PropertyRepository;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

@Service
public class PropertyCacheStore extends CacheStoreAdapter<PropertyPK, Property> {
    Logger logger = LoggerFactory.getLogger(PropertyCacheStore.class);

    private static PropertyRepository propertyRepository;

    @Autowired
    public static void setPropertyRepository(PropertyRepository propertyRepository) {
        PropertyCacheStore.propertyRepository = propertyRepository;
    }

    @Override
    public Property load(PropertyPK integer) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + integer + ']');
        return propertyRepository.findOne(integer);
    }

    @Override
    public void write(Cache.Entry<? extends PropertyPK, ? extends Property> entry) throws CacheWriterException {
        PropertyPK key = entry.getKey();
        Property value = entry.getValue();
        try {
            logger.info(">>> Store write [key=" + key + ", val=" + value + ']');
            propertyRepository.save(value);
//            ProducerUtil.sendMessage("kafkaCacheTopic", value.toString());
        } catch (Exception e) {
//            ProducerUtil.sendMessage("kafkaErrorTopic", value.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {
        try {
            propertyRepository.delete((PropertyPK) o);
            logger.info("<<< Successfully deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
