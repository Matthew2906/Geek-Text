package com.geektext19.restapi.repositories.profile_management;

import com.geektext19.restapi.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByUsername(String username);
}
