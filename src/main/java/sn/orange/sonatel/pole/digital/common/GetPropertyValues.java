package sn.orange.sonatel.pole.digital.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {

	InputStream inputStream;
	Properties prop;
	String propFileName;
 
	public GetPropertyValues() throws IOException
	{
		prop = new Properties();
		propFileName = "config.properties";
		
		try {

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
	
	/**
	 * Cette fonction renvoie le type du webdriver à utiliser selon le navigateur
	 * @param navigateur
	 * @return
	 */
	public String getDriverType(String navigateur)
	{
		return prop.getProperty(navigateur+"_driver_type");
	}
	
	/**
	 * Cette fonction renvoie le chemin vers le webdriver à utiliser selon le navigateur
	 * @param navigateur
	 * @return
	 */
	public String getDriverPath(String navigateur)
	{
		return prop.getProperty(navigateur+"_driver_path");
	}
	
	/**
	 * Cette fonction renvoie l'adresse IP de la base Influx DB
	 * 
	 * @return
	 */
	public final String getInfluxDBIP()
	{
		return prop.getProperty("InfluxDB_ip");
	}
	
	/**
	 * Cette fonction renvoie le nom d'utilisateur de la base Influx DB
	 * @return
	 */
	public String getInfluxDBUsername()
	{
		return prop.getProperty("InfluxDB_username");
	}
	
	/**
	 * Cette fonction renvoie le mot de passe de la base Influx DB
	 * @return
	 */
	public String getInfluxDBPassword()
	{
		return prop.getProperty("InfluxDB_password");
	}
	
	/**
	 * Cette fonction renvoie le nom de la base Influx DB
	 * @return
	 */
	public String getInfluxDBDatabaseName()
	{
		return prop.getProperty("InfluxDB_database");
	}
	
	
	
	
}
