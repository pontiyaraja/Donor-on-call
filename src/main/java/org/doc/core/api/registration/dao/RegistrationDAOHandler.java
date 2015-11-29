/**
 * 
 */
package org.doc.core.api.registration.dao;

import org.doc.core.api.registration.info.LoginInfo;
import org.doc.core.api.registration.info.RegistrationInfo;

/**
 * @author pandiyaraja
 *
 */
public interface RegistrationDAOHandler {
	public String loginAuthenticationDAO(LoginInfo logInfo);
	public String registrationAccountDAO(RegistrationInfo regInfo);
}
