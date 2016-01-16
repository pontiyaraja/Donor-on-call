/**
 * 
 */
package org.doc.donoroncall.doc;

import java.util.List;

import org.doc.donoroncall.doc.info.DocDonorInfo;
import org.springframework.stereotype.Service;

/**
 * @author Pandiyaraja
 *
 */
@Service
public interface DocHandler {
	public List<DocDonorInfo> getAllDonors();
	public List<DocDonorInfo> getDonorsForRecipient(DocDonorInfo dInfo);
	public String selectDonors();
}
