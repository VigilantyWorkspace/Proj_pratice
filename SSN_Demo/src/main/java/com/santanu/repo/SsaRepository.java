package com.santanu.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.santanu.entity.SsaUserEntity;

public interface SsaRepository extends JpaRepository<SsaUserEntity, Serializable> {
	
	
	public SsaUserEntity findBySsnAndStateName(Long ssno, String stateName);
}
