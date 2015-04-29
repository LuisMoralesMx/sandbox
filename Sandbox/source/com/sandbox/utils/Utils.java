package com.sandbox.utils;

import com.sun.istack.internal.Nullable;

public class Utils {
	
	public static boolean isNullOrEmpty(@Nullable String string) {
		
		if(string != null && !string.equalsIgnoreCase(Constants.EMPTY_STRING)) {
			return false;
		} else {
			return true;
		}		
	}
}