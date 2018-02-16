package com.sys.org.ignitePersistance;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteLogger;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.DataRegionConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.logger.java.JavaLogger;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by debasish paul on 15-02-2018.
 */
public class IgniteClientNode {
    private static final Logger LOGGER = LoggerFactory.getLogger(IgniteClientNode.class);

    /**
     * this is for testing purpose, do not run this class in prod env.
     * @param args
     */
    public static void main(String[] args) {
        Ignition.setClientMode(true);
        org.apache.ignite.configuration.IgniteConfiguration igniteConfiguration = new org.apache.ignite.configuration.IgniteConfiguration();

        DataStorageConfiguration storageCfg = new DataStorageConfiguration();
        DataRegionConfiguration dataRegionConfiguration = new DataRegionConfiguration();
        dataRegionConfiguration.setName("Default_Region");
        dataRegionConfiguration.setMaxSize(4L * 1024 * 1024 * 1024);
        dataRegionConfiguration.setPersistenceEnabled(true);
        storageCfg.setDataRegionConfigurations(dataRegionConfiguration);
        igniteConfiguration.setDataStorageConfiguration(storageCfg);


        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47502"));
        tcpDiscoverySpi.setIpFinder(ipFinder);
        igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);

        IgniteLogger log = new JavaLogger(true);
        igniteConfiguration.setGridLogger(log);


        Ignite ignite = Ignition.start(igniteConfiguration);
        ignite.active(true);
//        Ignite ignite = Ignition.start();
        LOGGER.info(">>>>>>>>>>>>>>>>Ignite Cache Started successfully");
    }
}
