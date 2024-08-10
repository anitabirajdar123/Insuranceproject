package com.insurance.InsurancePolicyApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.InsurancePolicyApplication.Entity.Policy;
import com.insurance.InsurancePolicyApplication.service.PolicyService;
@RestController
@RequestMapping("/api/policies")
public class PolicyControllerrest {
	
	@Autowired
	private PolicyService policyService;
	
	@GetMapping
	public List<Policy> getAllPolicies()
	{
		return policyService.getAllPolicies();
	}
	
	
	
	
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
	        Optional<Policy> policy = policyService.getPolicyById(id);
	        return policy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // POST create a new policy
	    @PostMapping
	    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
	        Policy createdPolicy = policyService.createPolicy(policy);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdPolicy);
	    }

	    // PUT update an existing policy
	    @PutMapping("/{id}")
	    public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @RequestBody Policy updatedPolicy) {
	        Optional<Policy> policy = policyService.updatePolicy(id, updatedPolicy);
	        return policy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // DELETE delete a policy
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
	        policyService.deletePolicy(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	 

}
