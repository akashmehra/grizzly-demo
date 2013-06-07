package com.ironman.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.ironman.exceptions.BackendConnectionException;
import com.ironman.exceptions.XMlSerializationException;

public class MySqlBackend <T extends MetaDataEntity> implements Backend<T> {

    private Connection connection = null;
    private String databaseName;
    private String hostname;
    private int port;
    private String username;
    private String password;
    
    public MySqlBackend(String databaseName,String username, String password) throws SQLException {
        this(databaseName, "localhost", 3306, username, password);
    }
    
    public MySqlBackend(String databaseName, String hostname, int port, String username, String password) throws SQLException {
        this.databaseName = databaseName;
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
    }
    
    public void connect() throws BackendConnectionException {
        String url = "jdbc:mysql://"+hostname+":"+Integer.toString(port)+"/"+databaseName;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new BackendConnectionException(ex);
        }
    }

    public void save(T entity) {
        
    }

    public T read() {
        // TODO Auto-generated method stub
        return null;
    }

    public void batchSave(List<T> entities) {
        T firstEntity = entities.get(0);
        String tableName = firstEntity.getTableName();
        String xml = getXml(entities);
        //System.out.println(xml);
    }

    private String getXml(List<T> entities) {
        StringBuilder sb = new StringBuilder();
        try {
            for(T entity : entities) {
                sb.append(entity.toXml());
            }
        } catch (XMlSerializationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return sb.toString();
    }

}
