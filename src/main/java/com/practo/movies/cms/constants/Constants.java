package com.practo.movies.cms.constants;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Constants {
	
	private static final Logger LOGGER = LogManager.getLogger(Constants.class);
	public static final Properties prop = getProperties();
	
	public static Properties getProperties() {
		Properties prop = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = null;
		
		try {
			inputStream = Constants.class.getClassLoader().getResourceAsStream(propFileName);
			
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch(Exception ex) {
			LOGGER.fatal("Failed To Start: " + ex.getMessage());
		} finally {
			try {
				inputStream.close();
			} catch(Exception ex) {
				LOGGER.error("Cannot close inputstream: " + ex.getMessage());
			}
		}
		
		return prop;
	}		
}
