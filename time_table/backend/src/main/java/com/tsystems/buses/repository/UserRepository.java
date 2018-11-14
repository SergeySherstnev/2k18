package com.tsystems.buses.repository;

import com.tsystems.buses.entity.PortalUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<PortalUser, Long> {

    @Query("select u from PortalUser u where u.loginId = ?1")
    List<PortalUser> findByLoginId(String loginId);
}
