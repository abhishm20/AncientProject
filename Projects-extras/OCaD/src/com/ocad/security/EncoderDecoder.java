package com.ocad.security;

import org.apache.tomcat.util.codec.binary.Base64;

public class EncoderDecoder {
	
	
	public static String encode(String userId)
	{
		byte[]   bytesEncoded = Base64.encodeBase64(userId.getBytes());
		String encodedForm = new String(bytesEncoded);
		return encodedForm;
	}
	
	public static String decode(String encodedId)
	{
		byte[] valueDecoded= Base64.decodeBase64(encodedId);
		return (new String(valueDecoded));
	}
	/*// encrypt data on your side using BASE64
	
main
	// Decrypt data on other side, by processing encoded data
	
	*/
	
}
