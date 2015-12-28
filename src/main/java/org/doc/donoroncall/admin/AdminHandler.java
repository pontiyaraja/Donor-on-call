/**
 * 
 */
package org.doc.donoroncall.admin;

import org.springframework.stereotype.Service;

/**
 * @author pandiyaraja
 *
 */
@Service
public interface AdminHandler {
	public String getRegUserList();
	public String authorizeUser(String userName);
	public String acceptBloodRequest(String userName);
}
