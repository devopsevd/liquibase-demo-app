package com.premierinc.sboot.demo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.togglz.spring.proxy.FeatureProxyFactoryBean;
import org.togglz.core.repository.StateRepository;

// import com.asimio.demo.togglz.service.SomeService;
// import com.asimio.demo.togglz.service.impl.NewSomeServiceImpl;
// import com.asimio.demo.togglz.service.impl.OldSomeServiceImpl;

import redis.clients.jedis.JedisPool;

@Configuration
public class AppConfiguration {

    private final JedisPool jedisPool;
    private final String togglzPrefix;
    public AppConfiguration(JedisPool jedisPool,
                            @Value("${togglzPrefix}") String togglzPrefix) {
        this.jedisPool = jedisPool;
        this.togglzPrefix = togglzPrefix;
    }

    @Bean
    public StateRepository getStateRepository() {
        return new RedisStateRepository.Builder()
                .keyPrefix(togglzPrefix + ":")
                .jedisPool(jedisPool)
                .build();
    }

    // @Bean
    // public SomeService oldSomeService() {
    //     return new OldSomeServiceImpl();
    // }

    // @Bean
    // public SomeService newSomeService() {
    //     return new NewSomeServiceImpl();
    // }

    // @Bean
    // public FeatureProxyFactoryBean proxiedSomeService() {
    //     FeatureProxyFactoryBean proxyFactoryBean = new FeatureProxyFactoryBean();
    //     proxyFactoryBean.setFeature(FeatureToggles.USE_NEW_SOMESERVICE.name());
    //     proxyFactoryBean.setProxyType(SomeService.class);
    //     proxyFactoryBean.setActive(this.newSomeService());
    //     proxyFactoryBean.setInactive(this.oldSomeService());
    //     return proxyFactoryBean;
    // }

    // @Bean
    // @Primary
    // public SomeService someService(@Autowired FeatureProxyFactoryBean proxiedSomeService) throws Exception {
    //     return (SomeService) proxiedSomeService.getObject();
    // }
}