package com.noclist.solution;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Generate a security checksum for the noclist users api call
 * 
 * @author User
 *
 */
@SuppressWarnings({"PMD.BeanMembersShouldSerialize","PMD.AvoidCatchingGenericException","PMD.AtLeastOneConstructor","PMD.SystemPrintln","PMD.LongVariable","PMD.LawOfDemeter","PMD.CommentRequired","PMD.CommentSize","PMD.DataflowAnomalyAnalysis","PMD.DoNotCallSystemExit"})
@Service
public class ChecksumGenerator {

	// Inject via application.properties
	private NoclistProperties properties;

	@Autowired
	public void setApp(final NoclistProperties properties) {
	    this.properties = properties;
	}

	/**
	 * Generate a sha256 checksum based on token generated by prior /auth API call + uri of userList
	 * 
	 * @return String checkSum
	 */
	public String generateChecksum(final String securityToken) {
		
		final String sha256hex = DigestUtils.sha256Hex(securityToken+properties.getUsers()); // Create a SHA256 checksum token
		System.err.println("SHA256 Checksum Token :"+sha256hex);
		return sha256hex;

	}


}
