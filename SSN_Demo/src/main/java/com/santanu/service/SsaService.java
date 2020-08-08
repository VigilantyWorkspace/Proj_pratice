package com.santanu.service;

import java.util.List;

import com.santanu.model.SsaUserRequest;

public interface SsaService {
	
	public Long enrollSsn(SsaUserRequest ssaUserReq) throws Exception;
	
	public List<String> getAllStateNames();
	
	public String validateEnrollment(Long ssno,String stateName) throws Exception;
	
}
