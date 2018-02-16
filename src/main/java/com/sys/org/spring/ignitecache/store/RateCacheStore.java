package com.sys.org.spring.ignitecache.store;

import com.sys.org.spring.idclass.RatePK;
import com.sys.org.spring.model.Rate;
import com.sys.org.spring.repositories.RateRepository;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RateCacheStore extends CacheStoreAdapter<RatePK, Rate> {
    Logger logger = LoggerFactory.getLogger(RateCacheStore.class);
    @Autowired
    private static RateRepository rateRepository;

    @Override
    public Rate load(RatePK ratePK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + ratePK + ']');
        return rateRepository.findOne(ratePK);
    }

    @Override
    public void write(Cache.Entry<? extends RatePK, ? extends Rate> entry) throws CacheWriterException {
        RatePK key = entry.getKey();
        Rate rate = entry.getValue();
        try {
            logger.info(">>> Store write [key=" + key + ", val=" + rate + ']');
            rateRepository.save(rate);
//            ProducerUtil.sendMessage("kafkaCacheTopic", rate.toString());
        } catch (Exception e) {
//            ProducerUtil.sendMessage("kafkaErrorTopic", rate.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {
        try {
            rateRepository.delete((RatePK) o);
            logger.info("<<< Rate Successfully deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
