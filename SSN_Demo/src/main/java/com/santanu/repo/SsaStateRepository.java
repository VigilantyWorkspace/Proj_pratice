package com.santanu.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.santanu.entity.StatesEntity;

public interface SsaStateRepository extends JpaRepository<StatesEntity, Serializable> {

	@Query(value="select stateName from StatesEntity")
	public List<String> findStateNames();
	
}
