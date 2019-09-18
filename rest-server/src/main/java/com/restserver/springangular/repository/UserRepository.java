package com.restserver.springangular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restserver.springangular.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
