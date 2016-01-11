/**
 * 
 */
package org.doc.donoroncall.donar;

/**
 * @author pandiyaraja
 * 
 */
public interface DocRequestHandler {
	public String donorRequest(DocRequesterInfo brInfo);
	public String getPendingDocRequest();
}
