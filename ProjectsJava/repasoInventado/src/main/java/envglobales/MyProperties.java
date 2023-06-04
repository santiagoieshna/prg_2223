package envglobales;

import java.util.Properties;

public class MyProperties {
	public final static String FINAL_URL="jdbc:mysql://localhost:3306/classicmodels";
	public static final Properties FINAL_ACCESO= getFINAL_ACCESO();
	
	private static Properties getFINAL_ACCESO() {
		 Properties FINAL_ACCESO_=new Properties();
		 FINAL_ACCESO_.put("user", "santiago");
		 FINAL_ACCESO_.put("password", "123456");
		 return FINAL_ACCESO_;
	}
}
