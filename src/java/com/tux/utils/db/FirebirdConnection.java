package com.tux.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author miklex
 */
public class FirebirdConnection {

    public Connection getConnection() {
        String db = "C:/Compacw/Secuencias/CONTPAQ.FDB";
        String user = "compaqcw";
        String password = "c0ntp4q";
        Connection conexion = null;
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            conexion = DriverManager.getConnection("jdbc:firebirdsql://localhost/" + db, user, password);
            System.out.println("[FirebirdConnection] Conectado a la base de datos ---> " + db + "]");
        } catch (Exception e) {
            System.out.println("[FirebirdConnection] Ocurrio un error al conectarse a la base de datos " + db + " de firebird: " + e.getMessage());
            e.printStackTrace();
        } finally {
            return conexion;
        }
    }
}
