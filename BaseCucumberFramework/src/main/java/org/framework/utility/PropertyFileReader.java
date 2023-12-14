package org.framework.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
	/**
	 * This method read the properties and return the value based on key
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getValueProperty(String key) throws Throwable {
		FileInputStream file=new FileInputStream("./src/test/resources/PropertiesFile/config.properties");
		Properties properties=new Properties();
		properties.load(file);
		return properties.getProperty(key);
	}


}
