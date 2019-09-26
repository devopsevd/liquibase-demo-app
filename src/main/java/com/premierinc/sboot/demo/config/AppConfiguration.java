package com.premierinc.sboot.demo.config;

// import com.premierinc.sboot.demo.service.SomeService;
// import com.premierinc.sboot.demo.service.NewSomeServiceImpl;
// //import com.premierinc.sboot.demo.service.impl.*;
// // import com.premierinc.sboot.demo.service.impl.OldSomeServiceImpl;
// import com.premierinc.sboot.demo.service.OldSomeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.spring.proxy.FeatureProxyFactoryBean;

import redis.clients.jedis.JedisPool;

@Configuration
public class AppConfiguration {

    private final JedisPool jedisPool;
    private final String togglzPrefix;

    public AppConfiguration(JedisPool jedisPool, @Value("${togglzPrefix}") String togglzPrefix) {
        this.jedisPool = jedisPool;
        this.togglzPrefix = togglzPrefix;
    }

    @Bean
    public StateRepository getStateRepository() {
        return new RedisStateRepository.Builder().keyPrefix(togglzPrefix + ":").jedisPool(jedisPool).build();
    }

    // @Bean
    // public FeatureProvider featureProvider() {
    //     return new EnumBasedFeatureProvider(FeatureToggles.class);
    // }

    // @Bean
    // public SomeService oldSomeService() {
    // return new OldSomeServiceImpl();
    // }

    // @Bean
    // public SomeService newSomeService() {
    // return new NewSomeServiceImpl();
    // }

    // @Bean
    // public FeatureProxyFactoryBean proxiedSomeService() {
    // FeatureProxyFactoryBean proxyFactoryBean = new FeatureProxyFactoryBean();
    // proxyFactoryBean.setFeature(FeatureToggles.USE_NEW_SOMESERVICE.name());
    // proxyFactoryBean.setProxyType(SomeService.class);
    // proxyFactoryBean.setActive(this.newSomeService());
    // proxyFactoryBean.setInactive(this.oldSomeService());
    // return proxyFactoryBean;
    // }

    // @Bean
    // @Primary
    // public SomeService someService(@Autowired FeatureProxyFactoryBean
    // proxiedSomeService) throws Exception {
    // return (SomeService) proxiedSomeService.getObject();
    // }
}