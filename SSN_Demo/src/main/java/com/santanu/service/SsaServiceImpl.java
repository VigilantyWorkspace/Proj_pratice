package com.santanu.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanu.entity.SsaUserEntity;
import com.santanu.exceptions.InvalidSsnException;
import com.santanu.exceptions.SsnNotGeneratedException;
import com.santanu.model.SsaUserRequest;
import com.santanu.repo.SsaRepository;
import com.santanu.repo.SsaStateRepository;

@Service
public class SsaServiceImpl implements SsaService {
	
	@Autowired
	private SsaRepository ssaRepo;
	
	@Autowired
	private SsaStateRepository ssaStateRepo;

	
	@Override
	public Long enrollSsn(SsaUserRequest ssaUserReq) throws SsnNotGeneratedException {
		
		SsaUserEntity ssaUser = new SsaUserEntity();
		BeanUtils.copyProperties(ssaUserReq, ssaUser);
		SsaUserEntity ssaUserEntity = ssaRepo.save(ssaUser);
	
		if(ssaUserEntity != null) {
			return ssaUserEntity.getSsn();
		}else {
			throw new SsnNotGeneratedException("Enrollment Failed");
			
		}
	}
	

	@Override
	public List<String> getAllStateNames() {
		
		return ssaStateRepo.findStateNames();
	}

	@Override
	public String validateEnrollment(Long ssno, String stateName)  {
		
		SsaUserEntity ssaUser = ssaRepo.findBySsnAndStateName(ssno, stateName);
		if(ssaUser !=null) {
			return "VALID SSN";
		}else {
			throw new InvalidSsnException("IN-VALID SSN");
		}
	}

	
}