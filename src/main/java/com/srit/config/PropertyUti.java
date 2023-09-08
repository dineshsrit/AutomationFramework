package com.srit.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.srit.constants.FrameworkConstants;
import com.srit.enums.ConfigProperties;

public class PropertyUti {


	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP= new HashMap<String, String>();
	private PropertyUti()
	{
		
	}
	 
	static {
		
		FileInputStream file;
		try {
			file = new FileInputStream(FrameworkConstants.getPropertyfilepath());
			prop.load(file);
			/*for(Object key:prop.keySet())
			{
				CONFIGMAP.put(String.valueOf(key), String.valueOf(prop.get(key)));
			}*/
			
			for(Map.Entry<Object, Object> entry: prop.entrySet())
			{
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		
	}
	
	public static String get(ConfigProperties  key) throws Exception
	{
		if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.toString().toLowerCase())))
		{
			throw new Exception ("Property name:" + key + "Not found");
		}
		
		return CONFIGMAP.get(key.name().toLowerCase());
		
	}
	
	/*public static String getValue(String key) throws Exception
	{
			
		if (Objects.isNull(prop.getProperty(key)) || Objects.isNull(key))
		{
			throw new Exception ("Property name:" + key + "Not found");
		}
		
		return prop.getProperty(key);
		*/
		
	}


