package com.insurance.InsurancePolicyApplication.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="policy")
public class Policy {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	private Long id;
	@Column(name="policy_holder")
	private String policyHolder;
	@Column(name="policy_type")
	private String policyType;
	@Column(name="premium_amount")
	private double premiumAmount;
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policy(Long id, String policyHolder, String policyType, double premiumAmount) {
		super();
		this.id = id;
		this.policyHolder = policyHolder;
		this.policyType = policyType;
		this.premiumAmount = premiumAmount;
	}
	
	
	
	public Policy(String policyHolder, String policyType, double premiumAmount) {
		super();
		this.policyHolder = policyHolder;
		this.policyType = policyType;
		this.premiumAmount = premiumAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPolicyHolder() {
		return policyHolder;
	}
	public void setPolicyHolder(String policyHolder) {
		this.policyHolder = policyHolder;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	@Override
	public String toString() {
		return "Policy [id=" + id + ", policyHolder=" + policyHolder + ", policyType=" + policyType + ", premiumAmount="
				+ premiumAmount + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, policyHolder, policyType, premiumAmount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Policy other = (Policy) obj;
		return Objects.equals(id, other.id) && Objects.equals(policyHolder, other.policyHolder)
				&& Objects.equals(policyType, other.policyType)
				&& Double.doubleToLongBits(premiumAmount) == Double.doubleToLongBits(other.premiumAmount);
	}
	
	

}
