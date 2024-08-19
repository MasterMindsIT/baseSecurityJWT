package com.base.repositories;

import com.base.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    List<RoleEntity> findRoleEntitiesByNameIn(List<String> roleNames);
    RoleEntity findByName(String name);
}