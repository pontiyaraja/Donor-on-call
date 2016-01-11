/**
 * 
 */
package org.doc.donoroncall.donar.dao;

import org.doc.donoroncall.donar.DocRequesterInfo;

/**
 * @author pandiyaraja
 * 
 */
public interface DocRequestDAOHandler {
	public String donorRequestDao(DocRequesterInfo brInfo);
	public String getPendingRequest();
}
