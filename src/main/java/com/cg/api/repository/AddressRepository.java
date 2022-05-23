package com.cg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.api.pojo.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
