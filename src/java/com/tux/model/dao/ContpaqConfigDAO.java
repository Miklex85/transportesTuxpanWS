package com.tux.model.dao;

import com.tux.dto.ContpaqConfig;
import com.tux.utils.ContpaqTableMapper;
import com.tux.utils.db.ContpaqConnection;
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
public class ContpaqConfigDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> configuracion;

    public boolean actualizarConfiguracion(String campo, String valor, long id) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(2, campo, valor, id));
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[ContpaqConfigDAO] No se pudo actualizar el cliente");
            }
        } catch (Exception e) {
            System.out.println("[ContpaqConfigDAO] Ocurrio un error al actualizar el cliente");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public ContpaqConfig consultarConfiguracion(String criterio, String valor, long id) {
        ContpaqConfig cliente = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor, id));
                resultado = sentencia.executeQuery();
                cliente = construirContpaqConfig(resultado);
                System.out.println("[ContpaqConfigDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[ContpaqConfigDAO] No se pudo consultar el cliente");
            }
        } catch (Exception e) {
            System.out.println("[ContpaqConfigDAO] Ocurrio un error al consultar el cliente");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return cliente;
        }
    }

    private ContpaqConfig construirContpaqConfig(ResultSet rs) {
        ContpaqConfig client = null;
        String clase;
        String[][] columnas;
        try {
            getColumnNames(rs);
            if (rs.next()) {
                client = new ContpaqConfig();
                Field[] attributes = client.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                columnas = getColumnNames(attributes);
                //for (Field field : attributes) {
                for (int i = 0; i < columnas.length; i++) {
                    clase = columnas[i][1];
                    System.out.println("ATTRIBUTE NAME: " + columnas[i][0]);
                    if (clase.equals("java.math.BigDecimal")) {
                        System.out.println("-------------------BD---------------------");
                        BigDecimal ejemplo = rs.getBigDecimal(columnas[i][0]);
                        System.out.println("------- PROP: " + columnas[i][0] + " - CN: " + configuracion.get(columnas[i][0]) + " - VAL: " + ejemplo);//+ rs.getBigDecimal(factura.get(columnas[i][0])) + " ----------");
                        PropertyUtils.setSimpleProperty(client, columnas[i][0], ejemplo);
                        System.out.println("ATTRIBUTE NAME: " + columnas[i][0]);
                    } else if (clase.equals("java.lang.String")) {
                        System.out.println("-------------------Str---------------------");
                        PropertyUtils.setSimpleProperty(client, columnas[i][0], rs.getString(configuracion.get(columnas[i][0])));
                    } else if (clase.equals("java.lang.Double")) {
                        System.out.println("-------------------Db---------------------");
                        PropertyUtils.setSimpleProperty(client, columnas[i][0], rs.getDouble(configuracion.get(columnas[i][0])));
                    } else if (clase.equals("java.sql.Date")) {
                        System.out.println("-------------------Da---------------------");
                        PropertyUtils.setSimpleProperty(client, columnas[i][0], rs.getDate(configuracion.get(columnas[i][0])));
                    }
                    System.out.println("ATTRIBUTE VALUE: " + PropertyUtils.getSimpleProperty(client, columnas[i][0]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
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
                //System.out.println(metadatos.getColumnLabel(i) + "=" + metadatos.getColumnLabel(i).toUpperCase());
                System.out.println("sentencia.set" + metadatos.getColumnClassName(i) + "(" + i + ",cliente.get" + metadatos.getColumnLabel(i) + "());");
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
    private String construirSQL(int opcion, String campo, String valor, long id) {
        String sql = "";
        ContpaqTableMapper tableMapper = new ContpaqTableMapper();
        configuracion = tableMapper.mapDbfTable("modules");
        switch (opcion) {
            case 1:
                sql = "INSERT INTO " + configuracion.get("archivoDbf") + "(CIDCLIEN01,CCODIGOC01,CRAZONSO01,CFECHAALTA,CRFC,CCURP,CDENCOME01,CREPLEGAL,CIDMONEDA,CLISTAPR01,CDESCUEN01,"
                        + "CDESCUEN02,CBANVENT01,CIDVALOR01,CIDVALOR02,CIDVALOR03,CIDVALOR04,CIDVALOR05,CIDVALOR06,CTIPOCLI01,CESTATUS,CFECHABAJA,CFECHAUL01,CLIMITEC01,CDIASCRE01,"
                        + "CBANEXCE01,CDESCUEN03,CDIASPRO01,CINTERES01,CDIAPAGO,CDIASREV01,CMENSAJE01,CCUENTAM01,CDIASEMB01,CIDALMACEN,CIDAGENT01,CIDAGENT02,CRESTRIC01,CIMPUESTO1,"
                        + "CIMPUESTO2,CIMPUESTO3,CRETENCI01,CRETENCI02,CIDVALOR07,CIDVALOR08,CIDVALOR09,CIDVALOR10,CIDVALOR11,CIDVALOR12,CLIMITEC02,CDIASCRE02,CTIEMPOE01,CDIASEMB02,"
                        + "CIMPUEST01,CIMPUEST02,CIMPUEST03,CRETENCI03,CRETENCI04,CBANINTE01,CCOMVENT01,CCOMCOBR01,CBANPROD01,CSEGCONT01,CSEGCONT02,CSEGCONT03,CSEGCONT04,CSEGCONT05,"
                        + "CSEGCONT06,CSEGCONT07,CSEGCONT08,CSEGCONT09,CSEGCONT10,CSEGCONT11,CSEGCONT12,CSEGCONT13,CSEGCONT14,CTEXTOEX01,CTEXTOEX02,CTEXTOEX03,CFECHAEX01,CIMPORTE01,"
                        + "CIMPORTE02,CIMPORTE03,CIMPORTE04,CBANDOMI01,CBANCRED01,CBANENVIO,CBANAGENTE,CBANIMPU01,CBANPRECIO,CTIMESTAMP,CFACTERC01,CCOMVENTA,CCOMCOBRO,CIDMONEDA2,CEMAIL1,"
                        + "CEMAIL2,CEMAIL3,CTIPOENTRE,CCONCTEEMA,CFTOADDEND,CIDCERTCTE,CENCRIPENT,CBANCFD,CTEXTOEX04,CTEXTOEX05,CIMPORTE05,CIDADDENDA,CCODPROVCO,CENVACUSE,CCON1NOM,"
                        + "CCON1TEL,CQUITABLAN,CFMTOENTRE,CIDCOMPLEM,CDESGLOSAI,CLIMDOCTOS,CSITIOFTP,CUSRFTP)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                break;
            case 2:
                sql = "UPDATE " + configuracion.get("archivoDbf") + " SET " + campo + " = " + valor + " WHERE " + configuracion.get("id") + " = " + id;
                break;
            case 3:
                sql = "SELECT * FROM " + configuracion.get("archivoDbf") + " WHERE " + campo + " = " + valor;
                break;
            case 4:
                sql = "SELECT * FROM " + configuracion.get("archivoDbf");
                break;
            default:
                System.out.println("");
        }
        System.out.println("[ContpaqConfigDAO] SQL Generado: " + sql);
        return sql;
    }

    private boolean abrirConexion() {
        boolean done = false;
        System.out.println("[ContpaqConfigDAO] Se abrira conexion a la base de datos");
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq");
        conexion = contpaqConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[ContpaqConfigDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }

    private boolean cerrarConexion() {
        boolean done = false;
        System.out.println("[ContpaqConfigDAO] Se cerrara la conexion a la base de datos");
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            conexion = null;
        } catch (Exception e) {
            System.out.println("[ContpaqConfigDAO] Ocurrio un error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        }
        return done;
    }
}
