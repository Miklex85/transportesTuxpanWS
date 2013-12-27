package com.tux.model.dao;

import com.tux.dto.ContpaqDireccion;
import com.tux.utils.ContpaqTableMapper;
import com.tux.utils.db.ContpaqConnection;
import com.tux.utils.db.FirebirdConnection;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author Mike
 */
public class DireccionDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> direccion;

    public boolean crearDireccion(ContpaqDireccion direccion) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                conexion.setAutoCommit(false);
                sentencia = conexion.prepareStatement(construirSQL(1, null, null));
                sentencia.setBigDecimal(1, direccion.getCiddirec01());
                sentencia.setBigDecimal(2, direccion.getCidcatal01());
                sentencia.setBigDecimal(3, direccion.getCtipocat01());
                sentencia.setBigDecimal(4, direccion.getCtipodir01());
                sentencia.setString(5, direccion.getCnombrec01());
                sentencia.setString(6, direccion.getCnumeroe01());
                //sentencia.setString(7, direccion.getCnumeroi01());
                sentencia.setString(8, direccion.getCcolonia());
                sentencia.setString(9, direccion.getCcodigop01());
                //sentencia.setString(10, direccion.getCtelefono1());
                //sentencia.setString(11, direccion.getCtelefono2());
                //sentencia.setString(12, direccion.getCtelefono3());
                //sentencia.setString(13, direccion.getCtelefono4());
                //sentencia.setString(14, direccion.getCemail());
                //sentencia.setString(15, direccion.getCdirecci01());
                sentencia.setString(16, direccion.getCpais());
                sentencia.setString(17, direccion.getCestado());
                sentencia.setString(18, direccion.getCciudad());
                //sentencia.setString(19, direccion.getCtextoex01());
                sentencia.setString(20, direccion.getCtimestamp());
                sentencia.setString(21, direccion.getCmunicipio());
                //sentencia.setString(22, direccion.getCsucursal());
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[DireccionDAO] No se pudo guardar la direccion");
            }
        } catch (Exception e) {
            if (conexion != null) {
                conexion.rollback();
                System.out.println("[DireccionDAO] Haciendo rollback");
            }
            System.out.println("[DireccionDAO] Ocurrio un error al guardar la direccion");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public boolean actualizarDireccion(String campo, String valor) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(2, campo, valor));
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[DireccionDAO] No se pudo actualizar la direccion");
            }
        } catch (Exception e) {
            System.out.println("[DireccionDAO] Ocurrio un error al actualizar la direccion");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public ContpaqDireccion consultarDireccion(String criterio, String valor) {
        ContpaqDireccion direccion = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                direccion = construirDireccion(resultado);
                System.out.println("[DireccionDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[DireccionDAO] No se pudo consultar la direccion");
            }
        } catch (Exception e) {
            System.out.println("[DireccionDAO] Ocurrio un error al consultar la direccion");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return direccion;
        }
    }

    public BigDecimal getMaxId() {
        BigDecimal numeroFactura = null;
        try {
            if (abrirConexionFirebird()) {
                sentencia = conexion.prepareStatement(construirSQL(5, "seq_direcciones_id", null));
                resultado = sentencia.executeQuery();
                if (resultado.next()) {
                    numeroFactura = resultado.getBigDecimal(1);
                }
            } else {
                System.out.println("[DireccionDAO] No se pudo obtener el siguiente ID");
            }
        } catch (Exception e) {
            System.out.println("[DireccionDAO] Ocurrio un error al obtener el siguiente ID");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return numeroFactura;
        }
    }

    private ContpaqDireccion construirDireccion(ResultSet rs) {
        ContpaqDireccion dir = null;
        String clase;
        String[][] columnas;
        try {
            getColumnNames(rs);
            if (rs.next()) {
                dir = new ContpaqDireccion();
                Field[] attributes = dir.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                columnas = getColumnNames(attributes);
                //for (Field field : attributes) {
                for (int i = 0; i < columnas.length; i++) {
                    clase = columnas[i][1];
                    System.out.println("ATTRIBUTE NAME: " + columnas[i][0]);
                    if (clase.equals("java.math.BigDecimal")) {
                        System.out.println("-------------------BD---------------------");
                        BigDecimal ejemplo = rs.getBigDecimal(columnas[i][0]);
                        System.out.println("------- PROP: " + columnas[i][0] + " - CN: " + direccion.get(columnas[i][0]) + " - VAL: " + ejemplo);//+ rs.getBigDecimal(factura.get(columnas[i][0])) + " ----------");
                        PropertyUtils.setSimpleProperty(dir, columnas[i][0], ejemplo);
                        System.out.println("ATTRIBUTE NAME: " + columnas[i][0]);
                    } else if (clase.equals("java.lang.String")) {
                        System.out.println("-------------------Str---------------------");
                        PropertyUtils.setSimpleProperty(dir, columnas[i][0], rs.getString(direccion.get(columnas[i][0])));
                    } else if (clase.equals("java.lang.Double")) {
                        System.out.println("-------------------Db---------------------");
                        PropertyUtils.setSimpleProperty(dir, columnas[i][0], rs.getDouble(direccion.get(columnas[i][0])));
                    } else if (clase.equals("java.sql.Date")) {
                        System.out.println("-------------------Da---------------------");
                        PropertyUtils.setSimpleProperty(dir, columnas[i][0], rs.getDate(direccion.get(columnas[i][0])));
                    }
                    System.out.println("ATTRIBUTE VALUE: " + PropertyUtils.getSimpleProperty(dir, columnas[i][0]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dir;
    }

    private String[][] getColumnNames(Field[] campos) {
        String[][] respuesta = new String[campos.length][2];
        for (int x = 0; x < campos.length; x++) {
            respuesta[x][0] = ((Field) campos[x]).getName();
            respuesta[x][1] = ((Field) campos[x]).getType().getCanonicalName();
            System.out.println("-----> " + respuesta[x][0] + " - " + respuesta[x][1]);
        }
        return respuesta;
    }

    private void getColumnNames(ResultSet rs) {
        try {
            ResultSetMetaData metadatos = rs.getMetaData();
            metadatos.getClass().getSimpleName();
            for (int i = 1; i <= metadatos.getColumnCount(); i++) {
                //System.out.println("private " + metadatos.getColumnClassName(i) + " " + metadatos.getColumnLabel(i) + ";");
                System.out.println(metadatos.getColumnLabel(i) + "=" + metadatos.getColumnLabel(i).toUpperCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene la sentencia SQL de acuerdo a la opcion enviada
     *
     * @param opcion El parametro define la sentencia SQL que se generara,
     * siendo los valores probables los siguientes: 1 - Insert 2 - Update 3 -
     * Select
     * @return La cadena con la instrucción SQL construida
     */
    private String construirSQL(int opcion, String campo, String valor) {
        String sql = "";
        ContpaqTableMapper tableMapper = new ContpaqTableMapper();
        direccion = tableMapper.mapDbfTable("direcciones");
        switch (opcion) {
            case 1:
                sql = "INSERT INTO " + direccion.get("archivoDbf") + "(CIDDIREC01,CIDCATAL01,CTIPOCAT01,CTIPODIR01,CNOMBREC01,CNUMEROE01,CNUMEROI01,CCOLONIA,CCODIGOP01,CTELEFONO1,"
                        + "CTELEFONO2,CTELEFONO3,CTELEFONO4,CEMAIL,CDIRECCI01,CPAIS,CESTADO,CCIUDAD,CTEXTOEX01,CTIMESTAMP,CMUNICIPIO,CSUCURSALP)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                break;
            case 2:
                sql = "UPDATE " + direccion.get("archivoDbf") + " SET " + campo + " = " + valor;
                break;
            case 3:
                sql = "SELECT * FROM " + direccion.get("archivoDbf") + " WHERE " + campo + " = " + valor;
                break;
            case 4:
                sql = "SELECT * FROM " + direccion.get("archivoDbf");
                break;
            case 5:
                sql = "SELECT NEXT VALUE FOR " + campo + " FROM RDB$DATABASE";
                break;
            default:
                System.out.println("");
        }
        System.out.println("[DireccionDAO] SQL Generado: " + sql);
        return sql;
    }

    private boolean abrirConexion() {
        boolean done = false;
        System.out.println("[DireccionDAO] Se abrira conexion a la base de datos");
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq7");
        conexion = contpaqConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[DireccionDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }

    private boolean cerrarConexion() {
        boolean done = false;
        System.out.println("[DireccionDAO] Se cerrara la conexion a la base de datos");
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            conexion = null;
        } catch (Exception e) {
            System.out.println("[DireccionDAO] Ocurrio un error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        }
        return done;
    }

    private boolean abrirConexionFirebird() {
        boolean done = false;
        System.out.println("[DireccionDAO] Se abrira conexion a la base de datos");
        FirebirdConnection firebirdConnection = new FirebirdConnection();
        conexion = firebirdConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[DireccionDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }
}
