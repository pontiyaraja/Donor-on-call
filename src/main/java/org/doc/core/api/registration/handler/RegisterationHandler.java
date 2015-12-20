/**
 * 
 */
package org.doc.core.api.registration.handler;

import org.doc.core.api.registration.info.RegisterationInfo;
import org.springframework.stereotype.Service;

/**
 * @author pandiyaraja
 * 
 */
@Service
public interface RegisterationHandler {
	public String registerAccount(RegisterationInfo regInfo);
}
