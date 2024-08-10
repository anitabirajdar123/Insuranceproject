package com.insurance.InsurancePolicyApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.InsurancePolicyApplication.Entity.Policy;
import com.insurance.InsurancePolicyApplication.dao.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService{
	
	@Autowired
	private PolicyRepository policyRepository ;

	public PolicyServiceImpl(PolicyRepository policyRepository) {
		super();
		this.policyRepository = policyRepository;
	}

	@Override
	public List<Policy> getAllPolicies() {
		
		return policyRepository.findAll() ;
	}

	public Optional<Policy> getPolicyById(Long id) {
		// TODO Auto-generated method stub
		return policyRepository.findById(id) ;
	}

	@Override
	public Policy createPolicy(Policy policy) {
		// TODO Auto-generated method stub
		return policyRepository.save(policy);
	}

	@Override
	public Optional<Policy> updatePolicy(Long id, Policy updatedPolicy) {
		Optional<Policy> optionalPolicy = policyRepository.findById(id);
        if (optionalPolicy.isPresent()) {
            Policy existingPolicy = optionalPolicy.get();
            existingPolicy.setPolicyHolder(updatedPolicy.getPolicyHolder());
            existingPolicy.setPolicyType(updatedPolicy.getPolicyType());
            existingPolicy.setPremiumAmount(updatedPolicy.getPremiumAmount());
            policyRepository.save(existingPolicy);
        }
        return optionalPolicy;
	}

	@Override
	public void deletePolicy(Long id) {
		policyRepository.deleteById(id);
		
	}

	@Override
	public Optional<Policy> getPolicyById(long theId) {
		// TODO Auto-generated method stub
		return policyRepository.findById(theId) ;
	}

	@Override
	public void save(Policy thepol) {
		policyRepository.save(thepol);
		
	}


}
