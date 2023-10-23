package com.utils.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.extern.slf4j.Slf4j;


import com.utils.redis.entities.Organization;

@Slf4j
@Repository
public class OrganizationRedisRepository {

    public static final String HASH_KEY = "organization";

    @Autowired
    private RedisTemplate template;
    

    public Organization findById(String id){
        
     log.info("### findById("+id+").getHash ###");
      Organization organization =
          (Organization) template
                 .opsForHash().get(HASH_KEY,id);

      return organization;
    }

  public Organization save(Organization organization){
         
      log.info("### saving to  Redis DB.id: "+organization.getId());
        template.opsForHash().put(HASH_KEY,organization.getId(), organization);
        return organization;
    }

    public List<Organization> findAll(){
      return template.opsForHash().values(HASH_KEY);
    }

}
