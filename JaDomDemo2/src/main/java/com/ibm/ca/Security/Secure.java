package com.ibm.ca.Security;
  

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.ibm.ca.MainServlet.AppManager;

public class Secure {
	private  Cipher cipher; 
	private  SecretKey secretKey;
	
	public Secure() throws NoSuchAlgorithmException, NoSuchPaddingException    {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		secretKey = keyGenerator.generateKey();
		cipher = Cipher.getInstance("AES");  
	}

	
	public Secure(String encodedKey) throws NoSuchAlgorithmException, NoSuchPaddingException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		this.SetKey(encodedKey);
		cipher = Cipher.getInstance("AES");  
		
	}

	public  String encrypt(String plainText)
			throws Exception {
		byte[] plainTextByte = plainText.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte); 
		return encryptedText;
	}

	public  String decrypt(String encryptedText)
			throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);  
		return decryptedText;
	}
	
	public void SetKey(String encodedKey){ 
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey); 
		secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");  
	}
	
	public String getKey(){
		return  Base64.getEncoder().encodeToString(secretKey.getEncoded()) ;
	}
}
