package com.jia13.encrypt;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SignatureEncryptor {

	static {
		System.loadLibrary("signature-encryptor");
	}

 
	private final String getSignatureParamString(Map<String, String> params) {
		if (params == null)
			return null;
		StringBuffer orgin = new StringBuffer();
		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.putAll(params);
		Iterator<String> iter = treeMap.keySet().iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			orgin.append(name).append(params.get(name));
		}
		return orgin.toString();
	}

	public final String encrypt(Map<String, String> param, String key) {
		String s = getSignatureParamString(param);
		return encrypt(s, key).toUpperCase();
		
	}
	
	public final String encrypt(Map<String, String> param) {
		String s = getSignatureParamString(param);
		return encryptWithoutSecurekey(s).toUpperCase();
	}

	public native String encrypt(String param, String key);

	public native String encryptWithoutSecurekey(String param);
}
