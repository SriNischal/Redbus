package com.atmecs.orangrhr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FlightProperties {
	public String readPropertiesFile(String elements) throws FileNotFoundException {
		Properties prop=new Properties();
		
			FileInputStream input=new FileInputStream("./Resources/ConfigProperties/flight1.properties");
			try {
			prop.load(input);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	String data =prop.getProperty(elements);
	return data;
	
	}

	
}


