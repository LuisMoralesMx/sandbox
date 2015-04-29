package com.sandbox.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

	private Properties prop = null;
	
	public String getDbPropertyValue(String key) {
		
		InputStream is = null;
		
		try {
			
			prop = new Properties();			
			is = getClass().getResourceAsStream("/com/sandbox/resources/db.properties");
			prop.load(is);
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return prop.getProperty(key);		
	}	
}