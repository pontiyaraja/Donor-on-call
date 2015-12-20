/**
 * 
 */
package org.doc.donoroncall.donar;

import org.doc.donoroncall.donar.dao.DonorRequestDAOHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pandiyaraja
 * 
 */
@Service
public class DonorRequesterService implements DonorRequesterHandler {
	@Autowired
	DonorRequestDAOHandler drDAOHandler;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.doc.donoroncall.donar.BloodRequesterHandler#requestBlood(org.doc.
	 * donoroncall.donar.BloodRequesterInfo)
	 */
	@Override
	public String donorRequest(DonorRequesterInfo drInfo) {
		return drDAOHandler.donorRequestDao(drInfo);
	}

}
