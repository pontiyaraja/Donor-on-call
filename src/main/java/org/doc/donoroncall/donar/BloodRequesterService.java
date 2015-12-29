/**
 * 
 */
package org.doc.donoroncall.donar;

import org.doc.core.util.DocMailingProcessor;
import org.doc.donoroncall.donar.dao.BloodRequestDAOHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pandiyaraja
 * 
 */
@Service
public class BloodRequesterService implements BloodRequesterHandler {
	@Autowired
	BloodRequestDAOHandler drDAOHandler;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.doc.donoroncall.donar.BloodRequesterHandler#requestBlood(org.doc.
	 * donoroncall.donar.BloodRequesterInfo)
	 */
	@Override
	public String donorRequest(BloodRequesterInfo drInfo) {
		String regRes = drDAOHandler.donorRequestDao(drInfo);
		if(regRes.equalsIgnoreCase("success")){
			DocMailingProcessor dmProcess = new DocMailingProcessor();
			dmProcess.sendMail("pontiyaraja14@gmail.com", "Blood request", "Hi, Please accept my blood request");			
		}
		return regRes;
	}

}
