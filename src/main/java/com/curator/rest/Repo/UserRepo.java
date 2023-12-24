package com.curator.rest.Repo;

import com.curator.rest.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <user, Long> {
}
