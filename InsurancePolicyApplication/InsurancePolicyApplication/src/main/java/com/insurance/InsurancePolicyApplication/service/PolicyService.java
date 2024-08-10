package com.insurance.InsurancePolicyApplication.service;

import java.util.List;
import java.util.Optional;

import com.insurance.InsurancePolicyApplication.Entity.Policy;



public interface PolicyService {
	
	public List<Policy> getAllPolicies();
	public Optional<Policy> getPolicyById(long theId);
	public Policy createPolicy(Policy policy);
	public Optional<Policy> updatePolicy(Long id, Policy updatedPolicy);
	public void deletePolicy(Long id);
	public void save(Policy thepol);
	

}
