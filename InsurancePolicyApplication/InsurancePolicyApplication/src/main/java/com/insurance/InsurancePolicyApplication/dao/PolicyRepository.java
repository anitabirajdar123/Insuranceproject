package com.insurance.InsurancePolicyApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.InsurancePolicyApplication.Entity.Policy;

public interface PolicyRepository  extends JpaRepository<Policy, Long>
{

}
