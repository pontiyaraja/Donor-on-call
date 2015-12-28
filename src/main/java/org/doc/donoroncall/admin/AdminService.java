/**
 * 
 */
package org.doc.donoroncall.admin;

import java.util.List;

import org.doc.core.api.registration.info.RegisterationInfo;
import org.doc.core.util.DocMailingProcessor;
import org.doc.donoroncall.admin.dao.AdminDAOHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pandiyaraja
 *
 */
@Service
public class AdminService implements AdminHandler{

	@Autowired
	private AdminDAOHandler adminDAOHandler;
	@Override
	public String getRegUserList() {
		List<RegisterationInfo> regUserList = adminDAOHandler.getRegUserList();
		return null;
	}

	@Override
	public String authorizeUser(String userName) {
		String resString = adminDAOHandler.authorizeUser(userName);
		if(resString.equalsIgnoreCase("success")){
			DocMailingProcessor docMailProcess = new DocMailingProcessor();
	    	docMailProcess.sendMail("pontiyaraja14@gmail.com", "vimalsri#14", "pontiyaraja14@gmail.com", "Registration request approved", "Hi, Your registration has been done successfully!");
		}
		return resString;
	}

	@Override
	public String acceptBloodRequest(String userName) {
		String resString = adminDAOHandler.acceptRequest(userName);
		if(resString.equalsIgnoreCase("success")){
			DocMailingProcessor docMailProcess = new DocMailingProcessor();
	    	docMailProcess.sendMail("pontiyaraja14@gmail.com", "vimalsri#14", "pontiyaraja14@gmail.com", "Blood Request request approved", "Hi, Your blood request accepted successfully!");
		}
		return resString;
	}

}
