package com.omniwyse.springdatajpa.all;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class DetectTenant {

	private static final DetectTenant detectTenant = new DetectTenant();

	private String tenant;

	private DetectTenant() {
		tenant="test";

	}

	public static DetectTenant getInstance() {

		return detectTenant;

	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

}
