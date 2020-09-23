package com.iranargham.atmmonitoring.repository;


import com.iranargham.atmmonitoring.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OauthUserRolesRepository extends JpaRepository<UserRole, Long> {

    @Query("select a.role from UserRole a, OauthUser b where b.userName=?1 and a.userId=b.userId")
    List<String> findRoleByUserName(String username);

    void deleteByUserId(long userId);

}