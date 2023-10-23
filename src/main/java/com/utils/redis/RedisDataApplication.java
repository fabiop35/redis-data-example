package com.utils.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;


import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
 
import lombok.extern.slf4j.Slf4j;


@EnableAutoConfiguration(exclude = RedisAutoConfiguration.class)
@SpringBootApplication
public class RedisDataApplication {


     @Bean
     JedisConnectionFactory jedisConnectionFactory() {
        
    String hostname = "localhost";
    int port = 6379;
        RedisStandaloneConfiguration 
            redisStandaloneConfiguration = 
    new RedisStandaloneConfiguration(hostname, port);
        //redisStandaloneConfiguration.setPassword(RedisPassword.of("yourRedisPasswordIfAny"));
       // return new JedisConnectionFactory(redisStandaloneConfiguration);
    JedisConnectionFactory connectionFactory = 
     new JedisConnectionFactory(redisStandaloneConfiguration);

     connectionFactory.afterPropertiesSet();
      return connectionFactory;

    }

    @Lazy
    @Bean
    public RedisTemplate<String, Object> 
                               redisTemplate() {
      
     RedisTemplate<String, Object> template = 
                              new RedisTemplate<>();
      template.setConnectionFactory(jedisConnectionFactory());
      return template;
    }

	public static void main(String[] args) {
		SpringApplication.run(RedisDataApplication.class, args);
	}

}
