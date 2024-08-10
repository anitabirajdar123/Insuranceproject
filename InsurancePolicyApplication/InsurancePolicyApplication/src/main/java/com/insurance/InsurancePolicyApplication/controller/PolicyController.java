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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.InsurancePolicyApplication.Entity.Policy;
import com.insurance.InsurancePolicyApplication.service.PolicyService;





@Controller
@RequestMapping("/policies")
public class PolicyController {
	@Autowired
	private PolicyService policyService;
	
	@GetMapping
	public List<Policy> getAllPolicies()
	{
		return policyService.getAllPolicies();
	}
	
	@GetMapping("/list")
	public String listProduct(Model theModel)
	{
		List<Policy> thepol = policyService.getAllPolicies();
		theModel.addAttribute("policies",thepol);
		 return  "list_policy";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

Policy theEmployee=new Policy();
		// add to the spring model
		theModel.addAttribute("policies", theEmployee);
		
		return "policyForm";
	}
 
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId,  Model theModel) {

Optional<Policy> thepol=policyService.getPolicyById(theId);

		theModel.addAttribute("policies", thepol);
		
		return "policyForm";
	}


	
	@PostMapping("/save")
	public String save(@ModelAttribute("Policy") Policy thepol) {
	
		policyService.save(thepol);
		
		return "redirect:/policies/list";
	}
	
	
	
	 

	    // DELETE delete a policy
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
	        policyService.deletePolicy(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	
	
	
	
	
	
	

}
