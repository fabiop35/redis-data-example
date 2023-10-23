package com.utils.redis.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;

import com.utils.redis.service.OrganizationService;
import com.utils.redis.entities.Organization;

@Slf4j
@RestController
@RequestMapping(value = "v1/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Organization> 
      getOrganization(@PathVariable("id") String id) {

     log.info("INI: getOrganization()");
     
     Organization organization = organizationService.findById(id);

     return ResponseEntity.ok(organization);

    }

    @PostMapping
    public ResponseEntity<Organization> 
          createOrganization(@RequestBody 
                  Organization request){

        return ResponseEntity.ok(organizationService.createOrganization(request));
    }

    @GetMapping
    public ResponseEntity <List<Organization>> findAll(){

     return ResponseEntity.ok(organizationService.findAll());
    }
       


}
