package com.ironman.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.ironman.model.MySqlBackend;

public class MySqlBackendTest extends TestCase {
    
    String database = null;
    String username = null;
    String password = null;
    
    @Before
    public void setUp() throws Exception {
        InputStream inStream = new FileInputStream(new File("App.properties"));
        Properties prop = new Properties();
        prop.load(inStream);
        database = (String) prop.get("database");
        username = (String) prop.get("user");
        password = (String) prop.get("password");
    }

    @Test
    public void testBatchSave() throws Exception {
        MySqlBackend<User> backend = new MySqlBackend<User>(database, username, password);
        backend.connect();
        String filePath = "src/test/java/test.xml";
        backend.batchSave(loadTestDataFromXml(filePath));
    }
    
    
    private List<User> loadTestDataFromXml(String filePath) throws Exception {
        Util<Users, UsersSubclass> util = new Util<Users, UsersSubclass>();
        Users u = new Users();
        List<UsersSubclass> list = new ArrayList<UsersSubclass>();
        //list.add(u);
        Users users = util.unmarshalFromXml(filePath, Users.class);
        System.out.println(users.getList());
        util.testMe(list);
        return users.getList();
    }
    
}
