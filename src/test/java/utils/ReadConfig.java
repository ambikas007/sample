package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig() {

        File file = new File("C:\\Users\\rajkshin\\Downloads\\UDEMY RESTASSURED\\letsCreateFramework\\src\\Configuration\\config.properties");

        try {
            FileInputStream fis = new FileInputStream(file);
            pro = new Properties();
            pro.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getApplicationURL() {
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getUserName() {
        String username = pro.getProperty("username");
        return username;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getChromePath() {
        String chromepath = pro.getProperty("chromepath");
        return chromepath;
    }


}
