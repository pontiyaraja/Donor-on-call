/**
 * 
 */
package org.doc.donoroncall.donar;

/**
 * @author pandiyaraja
 * 
 */
public interface DocRequestHandler {
	public String docRequest(DocRequesterInfo drInfo);
	public String docDonorRequest(DocDonorInfo ddInfo);
	public String getPendingDocRequest();
}
