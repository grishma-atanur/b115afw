package script;

import java.io.FileInputStream;
import java.util.Properties;

import generic.Utility;

public class Demo3 {

	public static void main(String[] args) throws Exception {
//		Properties p=new Properties();
//		p.load(new FileInputStream("./config.properties"));
//		String  v=p.getProperty("BROWSER");
//		System.out.println(v);
		
		String v = Utility.getProperty("./config.properties", "BROWSER");
		System.out.println(v);
	}

}
