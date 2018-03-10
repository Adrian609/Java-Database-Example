/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Arod6
 */
public class DatabaseTest {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    
    // Database properties file
   
    public void writeProperties() throws IOException{
        Properties prop = new Properties();
        prop.setProperty(DB_URL, "localhost");
        prop.setProperty(DB_USER, "username");
        prop.setProperty(DB_PASSWORD, "password");
        
        try(OutputStream out = new FileOutputStream("project.properties")){
            prop.store(out, "Database Properties File");
        }    
    }
    public void readProperties() throws IOException{
       try(InputStream in = new FileInputStream(DB_PROPERTIES)){
           
           // Load into propety object
           Properties prop = new Properties();
           prop.load(in);
           // Readin dbUrl, dbUser and dbPassword into String variables
           dbUrl=prop.getProperty(DB_URL);
           dbUser=prop.getProperty(DB_USER);
           dbPassword= prop.getProperty(DB_PASSWORD);
       }
    }    
    private static final String DB_PASSWORD = "dbPassword";
    private static final String DB_USER = "dbUser";
    private static final String DB_URL = "dbUrl";
    private static final String DB_PROPERTIES = "db.properties";
}  
    

