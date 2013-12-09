package com.tux.model.dao;

import com.tux.dto.ContpaqDetalleFactura;
import com.tux.dto.ContpaqFactura;
import com.tux.utils.db.ContpaqConnection;
import com.tux.utils.ContpaqTableMapper;
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
public class FacturaDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> factura;

    public boolean crearFactura(ContpaqFactura factura) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(1, null, null));
                sentencia.setBigDecimal(1, factura.getCiddocum01());
                sentencia.setBigDecimal(2, factura.getCiddocum02());
                sentencia.setBigDecimal(3, factura.getCidconce01());
                sentencia.setString(4, factura.getCseriedo01());
                sentencia.setDouble(5, factura.getCfolio());
                sentencia.setDate(6, factura.getCfecha());
                sentencia.setBigDecimal(7, factura.getCidclien01());
                sentencia.setString(8, factura.getCrazonso01());
                sentencia.setString(9, factura.getCrfc());
                sentencia.setBigDecimal(10, factura.getCidagente());
                sentencia.setDate(11, factura.getCfechave01());
                sentencia.setDate(12, factura.getCfechapr01());
                sentencia.setDate(13, factura.getCfechaen01());
                sentencia.setDate(14, factura.getCfechaul01());
                sentencia.setBigDecimal(15, factura.getCidmoneda());
                sentencia.setDouble(16, factura.getCtipocam01());
                sentencia.setString(17, factura.getCreferen01());
                sentencia.setString(18, factura.getCobserva01());
                sentencia.setBigDecimal(19, factura.getCnatural01());
                sentencia.setBigDecimal(20, factura.getCiddocum03());
                sentencia.setBigDecimal(21, factura.getCplantilla());
                sentencia.setBigDecimal(22, factura.getCusaclie01());
                sentencia.setBigDecimal(23, factura.getCusaprov01());
                sentencia.setBigDecimal(24, factura.getCafectado());
                sentencia.setBigDecimal(25, factura.getCimpreso());
                sentencia.setBigDecimal(26, factura.getCcancelado());
                sentencia.setBigDecimal(27, factura.getCdevuelto());
                sentencia.setBigDecimal(28, factura.getCidprepo01());
                sentencia.setBigDecimal(29, factura.getCidprepo02());
                sentencia.setBigDecimal(30, factura.getCestadoc01());
                sentencia.setDouble(31, factura.getCneto());
                sentencia.setDouble(32, factura.getCimpuesto1());
                sentencia.setDouble(33, factura.getCimpuesto2());
                sentencia.setDouble(34, factura.getCimpuesto3());
                sentencia.setDouble(35, factura.getCretenci01());
                sentencia.setDouble(36, factura.getCretenci02());
                sentencia.setDouble(37, factura.getCdescuen01());
                sentencia.setDouble(38, factura.getCdescuen02());
                sentencia.setDouble(39, factura.getCdescuen03());
                sentencia.setDouble(40, factura.getCgasto1());
                sentencia.setDouble(41, factura.getCgasto2());
                sentencia.setDouble(42, factura.getCgasto3());
                sentencia.setDouble(43, factura.getCtotal());
                sentencia.setDouble(44, factura.getCpendiente());
                sentencia.setDouble(45, factura.getCtotalun01());
                sentencia.setDouble(46, factura.getCdescuen04());
                sentencia.setDouble(47, factura.getCporcent01());
                sentencia.setDouble(48, factura.getCporcent02());
                sentencia.setDouble(49, factura.getCporcent03());
                sentencia.setDouble(50, factura.getCporcent04());
                sentencia.setDouble(51, factura.getCporcent05());
                sentencia.setDouble(52, factura.getCporcent06());
                sentencia.setString(53, factura.getCtextoex01());
                sentencia.setString(54, factura.getCtextoex02());
                sentencia.setString(55, factura.getCtextoex03());
                sentencia.setDate(56, factura.getCfechaex01());
                sentencia.setDouble(57, factura.getCimporte01());
                sentencia.setDouble(58, factura.getCimporte02());
                sentencia.setDouble(59, factura.getCimporte03());
                sentencia.setDouble(60, factura.getCimporte04());
                sentencia.setString(61, factura.getCdestina01());
                sentencia.setString(62, factura.getCnumerog01());
                sentencia.setString(63, factura.getCmensaje01());
                sentencia.setString(64, factura.getCcuentam01());
                sentencia.setDouble(65, factura.getCnumeroc01());
                sentencia.setDouble(66, factura.getCpeso());
                sentencia.setBigDecimal(67, factura.getCbanobse01());
                sentencia.setBigDecimal(68, factura.getCbandato01());
                sentencia.setBigDecimal(69, factura.getCbancond01());
                sentencia.setBigDecimal(70, factura.getCbangastos());
                sentencia.setDouble(71, factura.getCunidade01());
                sentencia.setString(72, factura.getCtimestamp());
                sentencia.setDouble(73, factura.getCimpcheq01());
                sentencia.setBigDecimal(74, factura.getCsistorig());
                sentencia.setBigDecimal(75, factura.getCidmonedca());
                sentencia.setDouble(76, factura.getCtipocamca());
                sentencia.setBigDecimal(77, factura.getCescfd());
                sentencia.setBigDecimal(78, factura.getCtienecfd());
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[FacturaDAO] No se pudo guardar la factura");
            }
        } catch (Exception e) {
            System.out.println("[FacturaDAO] Ocurrio un error al guardar la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public boolean actualizarFactura(String campo, String valor) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(2, campo, valor));
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[FacturaDAO] No se pudo guardar la factura");
            }
        } catch (Exception e) {
            System.out.println("[FacturaDAO] Ocurrio un error al actualizar la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public boolean cancelarFactura() {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(2, "", ""));
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[FacturaDAO] No se pudo guardar la factura");
            }
        } catch (Exception e) {
            System.out.println("[FacturaDAO] Ocurrio un error al cancelar la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public ContpaqFactura consultarFactura(String criterio, String valor) {
        ContpaqFactura factura = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                factura = construirFactura(resultado);
                System.out.println("[FacturaDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[FacturaDAO] No se pudo guardar la factura");
            }
        } catch (Exception e) {
            System.out.println("[FacturaDAO] Ocurrio un error al consultar la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return factura;
        }
    }

    public List<ContpaqFactura> consultarTodasLasFactura() {
        List<ContpaqFactura> facturas = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(4, null, null));
                sentencia.executeQuery();
                conexion.commit();
            } else {
                System.out.println("[FacturaDAO] No se pudo guardar la factura");
            }
        } catch (Exception e) {
            System.out.println("[FacturaDAO] Ocurrio un error al consultar la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return facturas;
        }
    }

    public BigDecimal getMaxId() {
        BigDecimal numeroFactura = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(6, null, null));
                resultado = sentencia.executeQuery();
                if (resultado.next()) {
                    numeroFactura = resultado.getBigDecimal(1);
                }
            } else {
                System.out.println("[FacturaDAO] No se pudo obtener el siguiente ID");
            }
        } catch (Exception e) {
            System.out.println("[FacturaDAO] Ocurrio un error al obtener el siguiente ID");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return numeroFactura;
        }
    }

    public Double getSiguienteFactura() {
        Double numeroFactura = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(5, null, null));
                resultado = sentencia.executeQuery();
                if (resultado.next()) {
                    numeroFactura = resultado.getDouble(1);
                }
            } else {
                System.out.println("[FacturaDAO] No se pudo obtener el siguiente numero de factura");
            }
        } catch (Exception e) {
            System.out.println("[FacturaDAO] Ocurrio un error al obtener el siguiente numero de factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return numeroFactura;
        }
    }

    private ContpaqFactura construirFactura(ResultSet rs) {
        ContpaqFactura fact = null;
        String clase;
        String[][] columnas;
        try {
            //getColumnNames(rs);
            if (rs.next()) {
                fact = new ContpaqFactura();
                Field[] attributes = fact.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                columnas = getColumnNames(attributes);
                //for (Field field : attributes) {
                for (int i = 0; i < columnas.length; i++) {
                    clase = columnas[i][1];
                    System.out.println("ATTRIBUTE NAME: " + columnas[i][0]);
                    if (clase.equals("java.math.BigDecimal")) {
                        System.out.println("-------------------BD---------------------");
                        BigDecimal ejemplo = rs.getBigDecimal(columnas[i][0]);
                        System.out.println("------- PROP: " + columnas[i][0] + " - CN: " + factura.get(columnas[i][0]) + " - VAL: " + ejemplo);//+ rs.getBigDecimal(factura.get(columnas[i][0])) + " ----------");
                        PropertyUtils.setSimpleProperty(fact, columnas[i][0], ejemplo);
                        System.out.println("ATTRIBUTE NAME: " + columnas[i][0]);
                    } else if (clase.equals("java.lang.String")) {
                        System.out.println("-------------------Str---------------------");
                        PropertyUtils.setSimpleProperty(fact, columnas[i][0], rs.getString(factura.get(columnas[i][0])));
                    } else if (clase.equals("java.lang.Double")) {
                        System.out.println("-------------------Db---------------------");
                        PropertyUtils.setSimpleProperty(fact, columnas[i][0], rs.getDouble(factura.get(columnas[i][0])));
                    } else if (clase.equals("java.sql.Date")) {
                        System.out.println("-------------------Da---------------------");
                        PropertyUtils.setSimpleProperty(fact, columnas[i][0], rs.getDate(factura.get(columnas[i][0])));
                    }
                    System.out.println("ATTRIBUTE VALUE: " + PropertyUtils.getSimpleProperty(fact, columnas[i][0]));
                }
            }
        } catch (Exception e) {
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
                System.out.println("sentencia.set" + metadatos.getColumnClassName(i) + "(" + i + ",factura.get" + metadatos.getColumnLabel(i) + "());");
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
        factura = tableMapper.mapDbfTable("factura");
        switch (opcion) {
            case 1:
                sql = "INSERT INTO " + factura.get("archivoDbf") + "(CIDDOCUM01,CIDDOCUM02,CIDCONCE01,CSERIEDO01,CFOLIO,CFECHA,"
                        + "CIDCLIEN01,CRAZONSO01,CRFC,CIDAGENTE,CFECHAVE01,CFECHAPR01,CFECHAEN01,CFECHAUL01,CIDMONEDA,CTIPOCAM01,"
                        + "CREFEREN01,COBSERVA01,CNATURAL01,CIDDOCUM03,CPLANTILLA,CUSACLIE01,CUSAPROV01,CAFECTADO,CIMPRESO,CCANCELADO,"
                        + "CDEVUELTO,CIDPREPO01,CIDPREPO02,CESTADOC01,CNETO,CIMPUESTO1,CIMPUESTO2,CIMPUESTO3,CRETENCI01,CRETENCI02,CDESCUEN01,"
                        + "CDESCUEN02,CDESCUEN03,CGASTO1,CGASTO2,CGASTO3,CTOTAL,CPENDIENTE,CTOTALUN01,CDESCUEN04,CPORCENT01,CPORCENT02,CPORCENT03,"
                        + "CPORCENT04,CPORCENT05,CPORCENT06,CTEXTOEX01,CTEXTOEX02,CTEXTOEX03,CFECHAEX01,CIMPORTE01,CIMPORTE02,CIMPORTE03,CIMPORTE04,"
                        + "CDESTINA01,CNUMEROG01,CMENSAJE01,CCUENTAM01,CNUMEROC01,CPESO,CBANOBSE01,CBANDATO01,CBANCOND01,CBANGASTOS,CUNIDADE01,"
                        + "CTIMESTAMP,CIMPCHEQ01,CSISTORIG,CIDMONEDCA,CTIPOCAMCA,CESCFD,CTIENECFD)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                break;
            case 2:
                sql = "UPDATE " + factura.get("archivoDbf") + " SET " + campo + " = " + valor;
                break;
            case 3:
                sql = "SELECT * FROM " + factura.get("archivoDbf") + " WHERE " + campo + " = " + valor;
                break;
            case 4:
                sql = "SELECT * FROM " + factura.get("archivoDbf");
                break;
            case 5:
                sql = "SELECT MAX(CFOLIO) FROM " + factura.get("archivoDbf");
                break;
            case 6:
                sql = "SELECT MAX(CIDDOCUM01) FROM " + factura.get("archivoDbf");
                break;
            default:
                System.out.println("");
        }
        System.out.println("[FacturaDAO] SQL Generado: " + sql);
        return sql;
    }

    private boolean abrirConexion() {
        boolean done = false;
        System.out.println("[FacturaDAO] Se abrira conexion a la base de datos");
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq");
        conexion = contpaqConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[FacturaDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }

    private boolean cerrarConexion() {
        boolean done = false;
        System.out.println("[FacturaDAO] Se cerrara la conexion a la base de datos");
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            conexion = null;
        } catch (Exception e) {
            System.out.println("[FacturaDAO] Ocurrio un error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        }
        return done;
    }
}
