package com.osaic.sample.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osaic.sample.sql.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>{

}
