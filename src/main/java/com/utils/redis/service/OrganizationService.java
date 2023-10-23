package com.utils.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utils.redis.entities.Organization;
import com.utils.redis.repository.OrganizationRedisRepository;

@Service
public class OrganizationService{

    @Autowired
    OrganizationRedisRepository redisRepository;


    public Organization findById(String id){
      return redisRepository.findById(id);
    }
    
    public Organization createOrganization(Organization org) {

       redisRepository.save(org);

       return org;
    }
    
    public List <Organization> findAll(){
     return redisRepository.findAll();
    }
}



