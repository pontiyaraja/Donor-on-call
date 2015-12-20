/**
 * 
 */
package org.doc.core.api.registration.service;

import org.doc.core.api.registration.dao.RegistrationDAOHandler;
import org.doc.core.api.registration.handler.RegisterationHandler;
import org.doc.core.api.registration.info.RegisterationInfo;
import org.doc.core.util.db.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pandiyaraja
 * 
 */
@Service
public class RegistrationService implements RegisterationHandler {
	@Autowired
	private RegistrationDAOHandler rdHand;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.doc.core.api.registration.handler.RegisterationHandler#registerAccount
	 * (org.doc.core.api.registration.handler.RegisterationHandler)
	 */
	@Override
	public String registerAccount(RegisterationInfo regInfo) {
		
		return rdHand.registrationAccountDAO(regInfo);
	}

}
