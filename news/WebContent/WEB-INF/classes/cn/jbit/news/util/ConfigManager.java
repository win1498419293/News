package cn.jbit.news.util;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Properties;

public class ConfigManager {
	private  static ConfigManager  con=new ConfigManager();
	private  static  Properties Pro;
	private ConfigManager() {
		String confile="database.properties";
		Pro=new  Properties();
		InputStream is=ConfigManager.class.getClassLoader().getResourceAsStream(confile);
		try {
			Pro.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ConfigManager getinstacen() {
		return con;
	}
	public String getString(String key) {
		return Pro.getProperty(key);
	}
	}
			
