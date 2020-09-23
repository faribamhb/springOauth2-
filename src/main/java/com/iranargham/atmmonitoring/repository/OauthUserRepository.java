package com.iranargham.atmmonitoring.repository;


import com.iranargham.atmmonitoring.entity.OauthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface OauthUserRepository extends JpaRepository<OauthUser, Long> {
    Optional<OauthUser> findByUserName(String userName);
}