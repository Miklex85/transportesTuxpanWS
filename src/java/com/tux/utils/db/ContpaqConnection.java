/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ContpaqConnection {

    private Connection conexion;
    private String odbcDNS;

    public ContpaqConnection(String odbcDNS) {
        this.odbcDNS = odbcDNS;
    }

    public Connection getConnection() {
        String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String url = "jdbc:odbc:" + odbcDNS;
        String username = "";
        String password = "";
        try {
            Class.forName(driver);
            System.out.println("Connection Data: " + url);
            conexion = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("[ContpaqConnection] Ocurrio un error al obtener la conexión a la base de datos de Contpaq-i");
            e.printStackTrace();
        } finally {
            return conexion;
        }
    }
}
