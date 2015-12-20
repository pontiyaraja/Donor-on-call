/**
 * 
 */
package org.doc.core.api.registration.dao;

import org.doc.core.api.registration.info.LoginInfo;
import org.doc.core.api.registration.info.RegisterationInfo;
import org.springframework.stereotype.Service;

/**
 * @author pandiyaraja
 * 
 */
@Service
public interface RegistrationDAOHandler {
	public String loginAuthenticationDAO(LoginInfo logInfo);
	public String registrationAccountDAO(RegisterationInfo regInfo);
}
