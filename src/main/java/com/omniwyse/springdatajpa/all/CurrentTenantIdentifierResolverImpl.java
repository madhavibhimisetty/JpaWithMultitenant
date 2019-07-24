package com.omniwyse.springdatajpa.all;

import javax.transaction.Transactional;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

 

	@Override
	public String resolveCurrentTenantIdentifier() {
		 return DetectTenant.getInstance().getTenant();
	}

	/**
	 * Get tenantId in the session attribute KEY_TENANTID_SESSION
	 * 
	 * @return TenantId on KEY_TENANTID_SESSION
	 */
	/*
	 * public String resolveTenantByHttpSession() { ServletRequestAttributes attr =
	 * (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); //If
	 * session attribute exists returns tenantId saved on the session if(attr !=
	 * null){ HttpSession session = attr.getRequest().getSession(false); // true ==
	 * allow create if(session != null){ String tenant = (String)
	 * session.getAttribute(KEY_TENANTID_SESSION); if(tenant != null){ return
	 * tenant; } } } //otherwise return default tenant
	 * logger.trace("Tenant resolved in session is: " + DEFAULT_TENANTID); return
	 * DEFAULT_TENANTID; }
	 */

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}
}