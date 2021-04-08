package com.labhi.gateway.security.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.labhi.auth.model.JwtToken;

@Repository
public interface JwtTokenRepository extends MongoRepository<JwtToken,String> {

}
