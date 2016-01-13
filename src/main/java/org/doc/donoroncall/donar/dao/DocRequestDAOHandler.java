/**
 * 
 */
package org.doc.donoroncall.donar.dao;

import org.doc.donoroncall.donar.DocDonorInfo;
import org.doc.donoroncall.donar.DocRequesterInfo;

/**
 * @author pandiyaraja
 * 
 */
public interface DocRequestDAOHandler {
	public String donorRequestDao(DocRequesterInfo brInfo);
	public String docDonorRequestDao(DocDonorInfo ddInfo);
	public String getPendingRequest();
}
