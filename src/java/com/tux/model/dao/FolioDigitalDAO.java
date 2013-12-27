package com.tux.model.dao;

import com.tux.dto.ContpaqDetalleFactura;
import com.tux.dto.ContpaqFactura;
import com.tux.dto.ContpaqFolioDigital;
import com.tux.utils.db.ContpaqConnection;
import com.tux.utils.ContpaqTableMapper;
import com.tux.utils.db.FirebirdConnection;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 *
 * @author miklex
 */
public class FolioDigitalDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> folioDigital;

    public boolean crearFolioDigital(ContpaqFolioDigital folio) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                conexion.setAutoCommit(done);
                sentencia = conexion.prepareStatement(construirSQL(1, null, null));
                sentencia.setBigDecimal(1, folio.getCidfoldig());
                sentencia.setBigDecimal(2, folio.getCiddoctode());
                sentencia.setBigDecimal(3, folio.getCidcptodoc());
                sentencia.setBigDecimal(4, folio.getCiddocto());
                sentencia.setBigDecimal(5, folio.getCiddocaldi());
                //sentencia.setBigDecimal(6, folio.getCidfirmarl());
                //sentencia.setBigDecimal(7, folio.getCnoorden());
                //sentencia.setString(8, folio.getCserie());
                sentencia.setBigDecimal(6, folio.getCfolio());
                //sentencia.setBigDecimal(10, folio.getCnoaprob());
                //sentencia.setDate(11, folio.getCfecaprob());
                sentencia.setBigDecimal(7, folio.getCestado());
                sentencia.setBigDecimal(8, folio.getCentregado());
                sentencia.setDate(9, folio.getCfechaemi());
                //sentencia.setString(15, folio.getChoraemi());
                //sentencia.setString(16, folio.getCemail());
                //sentencia.setString(17, folio.getCarchdidis());
                //sentencia.setBigDecimal(18, folio.getCidcptoori());
                //sentencia.setDate(19, folio.getCfechacanc());
                //sentencia.setString(20, folio.getChoracanc());
                sentencia.setBigDecimal(10, folio.getCestrad());
                //sentencia.setString(22, folio.getCcadpedi());
                //sentencia.setString(23, folio.getCarchcbb());
                //sentencia.setDate(24, folio.getCinivig());
                //sentencia.setDate(25, folio.getCfinvig());
                //sentencia.setString(26, folio.getCtipo());
                //sentencia.setString(27, folio.getCserierec());
                //sentencia.setBigDecimal(28, folio.getCfoliorec());
                sentencia.setString(11, folio.getCrfc());
                //sentencia.setString(30, folio.getCrazon());
                //sentencia.setBigDecimal(31, folio.getCsisorigen());
                //sentencia.setBigDecimal(32, folio.getCejerpol());
                //sentencia.setBigDecimal(33, folio.getCperpol());
                //sentencia.setBigDecimal(34, folio.getCtipopol());
                //sentencia.setBigDecimal(35, folio.getCnumpol());
                //sentencia.setString(36, folio.getCtipoldesc());
                sentencia.setDouble(12, folio.getCtotal());
                //sentencia.setString(38, folio.getCaliasbdct());
                //sentencia.setBigDecimal(39, folio.getCcfdprueba());
                //sentencia.setString(40, folio.getCdesestado());
                //sentencia.setBigDecimal(41, folio.getCpagadoban());
                //sentencia.setString(42, folio.getCdespagban());
                //sentencia.setString(43, folio.getCreferen01());
                //sentencia.setString(44, folio.getCobserva01());
                //sentencia.setString(45, folio.getCcodconcba());
                //sentencia.setString(46, folio.getCdesconcba());
                //sentencia.setString(47, folio.getCnumctaban());
                //sentencia.setString(48, folio.getCfolioban());
                //sentencia.setBigDecimal(49, folio.getCiddocdeba());
                //sentencia.setString(50, folio.getCusuautban());
                //sentencia.setString(51, folio.getCuuid());
                //sentencia.setString(52, folio.getCusuban01());
                //sentencia.setBigDecimal(53, folio.getCautusba01());
                //sentencia.setString(54, folio.getCusuban02());
                //sentencia.setBigDecimal(55, folio.getCautusba02());
                //sentencia.setString(56, folio.getCusuban03());
                //sentencia.setBigDecimal(57, folio.getCautusba03());
                //sentencia.setString(58, folio.getCdescaut01());
                //sentencia.setString(59, folio.getCdescaut02());
                //sentencia.setString(60, folio.getCdescaut03());
                //sentencia.setBigDecimal(61, folio.getCerrorval());
                //sentencia.setString(62, folio.getCacusecan());
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[FolioDigitalDAO] No se pudo guardar la factura");
            }
        } catch (Exception e) {
            if (conexion != null) {
                conexion.rollback();
                System.out.println("[FolioDigitalDAO] Haciendo rollback");
            }
            System.out.println("[FolioDigitalDAO] Ocurrio un error al guardar la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public ContpaqFolioDigital consultarFolioDigital(String criterio, String valor) {
        ContpaqFolioDigital factura = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                factura = construirFactura(resultado);
                System.out.println("[FolioDigitalDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[FolioDigitalDAO] No se pudo guardar la factura");
            }
        } catch (Exception e) {
            System.out.println("[FolioDigitalDAO] Ocurrio un error al consultar la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return factura;
        }
    }

    public BigDecimal getMaxId() {
        BigDecimal numeroFactura = null;
        try {
            if (abrirConexionFirebird()) {
                sentencia = conexion.prepareStatement(construirSQL(6, "seq_folio_digital_id", null));
                resultado = sentencia.executeQuery();
                if (resultado.next()) {
                    numeroFactura = resultado.getBigDecimal(1);
                }
            } else {
                System.out.println("[FolioDigitalDAO] No se pudo obtener el siguiente ID");
            }
        } catch (Exception e) {
            System.out.println("[FolioDigitalDAO] Ocurrio un error al obtener el siguiente ID");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return numeroFactura;
        }
    }

    private ContpaqFolioDigital construirFactura(ResultSet rs) {
        ContpaqFolioDigital fact = null;
        String clase;
        //String[][] columnas;
        try {
            getColumnNames(rs);
            if (rs.next()) {
                fact = new ContpaqFolioDigital();
                Field[] attributes = fact.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                //columnas = getColumnNames(attributes);
                for (Field field : attributes) {
                    //for (int i = 0; i < columnas.length; i++) {
                    //clase = columnas[i][1];
                    field.setAccessible(true);
                    clase = field.getType().getCanonicalName();
                    //System.out.println("FolioDigitalDAO.construirFactura: Obteniendo y seteando propiedad --> " + field.getName());
                    if (clase.equals("java.math.BigDecimal")) {
                        field.set(fact, rs.getBigDecimal(field.getName()));
                    } else if (clase.equals("java.lang.String")) {
                        field.set(fact, rs.getString(folioDigital.get(field.getName())));
                    } else if (clase.equals("java.lang.Double")) {
                        field.set(fact, rs.getDouble(folioDigital.get(field.getName())));
                    } else if (clase.equals("java.sql.Date")) {
                        field.set(fact, rs.getDate(folioDigital.get(field.getName())));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("FolioDigitalDAO.construirFactura: Ocurrio un error al construir la factura");
            e.printStackTrace();
        }
        return fact;
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
                System.out.println(metadatos.getColumnLabel(i).toUpperCase() + ",");
                //System.out.println("private " + metadatos.getColumnClassName(i) + " " + metadatos.getColumnLabel(i) + ";");
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
        folioDigital = tableMapper.mapDbfTable("folioDigital");
        switch (opcion) {
            case 1:
                sql = "INSERT INTO " + folioDigital.get("archivoDbf") + "(CIDFOLDIG,CIDDOCTODE,CIDCPTODOC,CIDDOCTO,CIDDOCALDI,CFOLIO,CESTADO,CENTREGADO,CFECHAEMI,CESTRAD,CRFC,CTOTAL)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
                break;
            case 3:
                sql = "SELECT * FROM " + folioDigital.get("archivoDbf") + " WHERE " + campo + " = " + valor;
                break;
            case 6:
                sql = "SELECT NEXT VALUE FOR " + campo + " FROM RDB$DATABASE";
                break;
            default:
                System.out.println("-------------------------------------------------------------");
        }
        System.out.println("[FolioDigitalDAO] SQL Generado: " + sql);
        return sql;
    }

    private boolean abrirConexion() {
        boolean done = false;
        System.out.println("[FolioDigitalDAO] Se abrira conexion a la base de datos");
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq7");
        conexion = contpaqConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[FolioDigitalDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }

    private boolean cerrarConexion() {
        boolean done = false;
        System.out.println("[FolioDigitalDAO] Se cerrara la conexion a la base de datos");
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            conexion = null;
        } catch (Exception e) {
            System.out.println("[FolioDigitalDAO] Ocurrio un error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        }
        return done;
    }

    private boolean abrirConexionFirebird() {
        boolean done = false;
        System.out.println("[FolioDigitalDAO] Se abrira conexion a la base de datos");
        FirebirdConnection firebirdConnection = new FirebirdConnection();
        conexion = firebirdConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[FolioDigitalDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }
}
