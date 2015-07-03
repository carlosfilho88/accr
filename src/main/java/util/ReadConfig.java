package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
 
public class ReadConfig {
 
	public Map<String, String> getPropValues() throws IOException {
 
		Map<String, String> props = new HashMap<String, String>();
		Properties prop = new Properties();
		String propFileName = "config.properties";
 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
		props.put("address", prop.getProperty("address"));
		props.put("database", prop.getProperty("database"));
		props.put("username", prop.getProperty("username"));
		props.put("password", prop.getProperty("password"));
		props.put("port", prop.getProperty("port"));
 
		return props;
	}
}