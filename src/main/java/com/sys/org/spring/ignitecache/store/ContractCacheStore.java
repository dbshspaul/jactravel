package com.sys.org.spring.ignitecache.store;

import com.sys.org.spring.idclass.ContractPK;
import com.sys.org.spring.model.Contract;
import com.sys.org.spring.repositories.ContractRepository;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;
import java.io.Serializable;

@Service
public class ContractCacheStore extends CacheStoreAdapter<ContractPK, Contract> implements Serializable{
    Logger logger = LoggerFactory.getLogger(ContractCacheStore.class);

    private static ContractRepository contractRepository;

    @Autowired
    public void setContractRepository(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract load(ContractPK contractPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + contractPK + ']');
        return contractRepository.findOne(contractPK);
    }

    @Override
    public void write(Cache.Entry<? extends ContractPK, ? extends Contract> entry) throws CacheWriterException {
        ContractPK key = entry.getKey();
        Contract value = entry.getValue();
        try {
            logger.info(">>> Store write [key=" + key + ", val=" + value + ']');
            contractRepository.save(value);
//            ProducerUtil.sendMessage("kafkaCacheTopic", value.toString());
        } catch (Exception e) {
//            ProducerUtil.sendMessage("kafkaErrorTopic", value.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {
        try {
            contractRepository.delete((ContractPK) o);
            logger.info("<<< Contract Successfully deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
