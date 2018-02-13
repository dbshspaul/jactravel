package com.sys.org.spring.config;

import com.sys.org.spring.idclass.ContractPK;
import com.sys.org.spring.ignitecache.store.ContractCacheStore;
import com.sys.org.spring.model.Contract;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.cache.configuration.FactoryBuilder;

@Configuration
public class IgniteConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(IgniteConfiguration.class);
    @Autowired
    Ignite ignite;

    @Bean(name = "ignite")
    @Lazy
    public Ignite getIgnite() {
//        Ignition.setClientMode(true);
//        org.apache.ignite.configuration.IgniteConfiguration igniteConfiguration = new org.apache.ignite.configuration.IgniteConfiguration();
//
//        DataStorageConfiguration storageCfg = new DataStorageConfiguration();
//        storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);
//        igniteConfiguration.setDataStorageConfiguration(storageCfg);
//
//        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
//        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
//        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47502"));
//        tcpDiscoverySpi.setIpFinder(ipFinder);
//        igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);
//
//        Ignite ignite = Ignition.start(igniteConfiguration);
//        ignite.active(true);
        Ignite ignite = Ignition.start();
        LOGGER.info(">>>>>>>>>>>>>>>>Ignite Cache Started successfully");
        return ignite;
    }

    @Bean(name = "contractCache")
    @Lazy
    public IgniteCache<ContractPK, Contract> getCache() {
        LOGGER.info("creating contractCache");
        return createCache("contractCache", ContractCacheStore.class);
    }

    private IgniteCache createCache(String cacheName, Class clazz) {
        CacheConfiguration contractCacheConfig = new CacheConfiguration();
        contractCacheConfig.setName(cacheName);
        contractCacheConfig.setReadThrough(true);
        contractCacheConfig.setWriteThrough(true);
        contractCacheConfig.setWriteBehindEnabled(true);
        contractCacheConfig.setBackups(1);
        contractCacheConfig.setCacheMode(CacheMode.PARTITIONED);
        contractCacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(clazz));
        IgniteCache cache = ignite.getOrCreateCache(contractCacheConfig);
        LOGGER.info(cacheName + " created.");
        return cache;
    }
}
