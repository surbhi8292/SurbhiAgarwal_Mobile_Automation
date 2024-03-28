package support;

import java.io.*;
import java.util.Properties;

public class ConfigProp {
	public static Properties prop = new Properties();
	public static String filepath;

	static {
		try {
			filepath = "./src/test/resources/configuration.properties";
			prop.load(new FileInputStream(filepath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}
}