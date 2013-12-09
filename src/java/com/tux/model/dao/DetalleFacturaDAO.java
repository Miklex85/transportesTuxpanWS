package com.tux.model.dao;

import com.tux.dto.ContpaqDetalleFactura;
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
public class DetalleFacturaDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> detallesFactura;

    public boolean crearDetalleFactura(ContpaqDetalleFactura detalleFactura) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(1, null, null));
                sentencia.setBigDecimal(1, detalleFactura.getCidmovim01());
                sentencia.setBigDecimal(2, detalleFactura.getCiddocum01());
                sentencia.setDouble(3, detalleFactura.getCnumerom01());
                sentencia.setBigDecimal(4, detalleFactura.getCiddocum02());
                sentencia.setBigDecimal(5, detalleFactura.getCidprodu01());
                sentencia.setBigDecimal(6, detalleFactura.getCidalmacen());
                sentencia.setDouble(7, detalleFactura.getCunidades());
                sentencia.setDouble(8, detalleFactura.getCunidade01());
                sentencia.setDouble(9, detalleFactura.getCunidade02());
                sentencia.setBigDecimal(10, detalleFactura.getCidunidad());
                sentencia.setBigDecimal(11, detalleFactura.getCidunida01());
                sentencia.setDouble(12, detalleFactura.getCprecio());
                sentencia.setDouble(13, detalleFactura.getCprecioc01());
                sentencia.setDouble(14, detalleFactura.getCcostoca01());
                sentencia.setDouble(15, detalleFactura.getCcostoes01());
                sentencia.setDouble(16, detalleFactura.getCneto());
                sentencia.setDouble(17, detalleFactura.getCimpuesto1());
                sentencia.setDouble(18, detalleFactura.getCporcent01());
                sentencia.setDouble(19, detalleFactura.getCimpuesto2());
                sentencia.setDouble(20, detalleFactura.getCporcent02());
                sentencia.setDouble(21, detalleFactura.getCimpuesto3());
                sentencia.setDouble(22, detalleFactura.getCporcent03());
                sentencia.setDouble(23, detalleFactura.getCretenci01());
                sentencia.setDouble(24, detalleFactura.getCporcent04());
                sentencia.setDouble(25, detalleFactura.getCretenci02());
                sentencia.setDouble(26, detalleFactura.getCporcent05());
                sentencia.setDouble(27, detalleFactura.getCdescuen01());
                sentencia.setDouble(28, detalleFactura.getCporcent06());
                sentencia.setDouble(29, detalleFactura.getCdescuen02());
                sentencia.setDouble(30, detalleFactura.getCporcent07());
                sentencia.setDouble(31, detalleFactura.getCdescuen03());
                sentencia.setDouble(32, detalleFactura.getCporcent08());
                sentencia.setDouble(33, detalleFactura.getCdescuen04());
                sentencia.setDouble(34, detalleFactura.getCporcent09());
                sentencia.setDouble(35, detalleFactura.getCdescuen05());
                sentencia.setDouble(36, detalleFactura.getCporcent10());
                sentencia.setDouble(37, detalleFactura.getCtotal());
                sentencia.setDouble(38, detalleFactura.getCporcent11());
                sentencia.setString(39, detalleFactura.getCreferen01());
                sentencia.setString(40, detalleFactura.getCobserva01());
                sentencia.setBigDecimal(41, detalleFactura.getCafectae01());
                sentencia.setBigDecimal(42, detalleFactura.getCafectad01());
                sentencia.setBigDecimal(43, detalleFactura.getCafectad02());
                sentencia.setDate(44, detalleFactura.getCfecha());
                sentencia.setBigDecimal(45, detalleFactura.getCmovtooc01());
                sentencia.setBigDecimal(46, detalleFactura.getCidmovto01());
                sentencia.setBigDecimal(47, detalleFactura.getCidmovto02());
                sentencia.setDouble(48, detalleFactura.getCunidade03());
                sentencia.setDouble(49, detalleFactura.getCunidade04());
                sentencia.setDouble(50, detalleFactura.getCunidade05());
                sentencia.setDouble(51, detalleFactura.getCunidade06());
                sentencia.setBigDecimal(52, detalleFactura.getCtipotra01());
                sentencia.setBigDecimal(53, detalleFactura.getCidvalor01());
                sentencia.setString(54, detalleFactura.getCtextoex01());
                sentencia.setString(55, detalleFactura.getCtextoex02());
                sentencia.setString(56, detalleFactura.getCtextoex03());
                sentencia.setDate(57, detalleFactura.getCfechaex01());
                sentencia.setDouble(58, detalleFactura.getCimporte01());
                sentencia.setDouble(59, detalleFactura.getCimporte02());
                sentencia.setDouble(60, detalleFactura.getCimporte03());
                sentencia.setDouble(61, detalleFactura.getCimporte04());
                sentencia.setString(62, detalleFactura.getCtimestamp());
                sentencia.setDouble(63, detalleFactura.getCgtomovto());
                sentencia.setString(64, detalleFactura.getCscmovto());
                sentencia.setDouble(65, detalleFactura.getCcomventa());
                sentencia.setBigDecimal(66, detalleFactura.getCidmovdest());
                sentencia.setBigDecimal(67, detalleFactura.getCnumconsol());
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[DetalleFacturaDAO] No se pudo guardar la direccion");
            }
        } catch (Exception e) {
            System.out.println("[DetalleFacturaDAO] Ocurrio un error al guardar la direccion");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public boolean actualizarDetalleFactura(String campo, String valor) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(2, campo, valor));
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[DetalleFacturaDAO] No se pudo actualizar la direccion");
            }
        } catch (Exception e) {
            System.out.println("[DetalleFacturaDAO] Ocurrio un error al actualizar la direccion");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public ContpaqDetalleFactura consultarDetalleFactura(String criterio, String valor) {
        ContpaqDetalleFactura detalle = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                detalle = construirDetalleFactura(resultado);
                System.out.println("[DetalleFacturaDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[DetalleFacturaDAO] No se pudo consultar la direccion");
            }
        } catch (Exception e) {
            System.out.println("[DetalleFacturaDAO] Ocurrio un error al consultar la direccion");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return detalle;
        }
    }

    private ContpaqDetalleFactura construirDetalleFactura(ResultSet rs) {
        ContpaqDetalleFactura det = null;
        String clase;
        String[][] columnas;
        try {
            getColumnNames(rs);
            if (rs.next()) {
                det = new ContpaqDetalleFactura();
                Field[] attributes = det.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                columnas = getColumnNames(attributes);
                //for (Field field : attributes) {
                for (int i = 0; i < columnas.length; i++) {
                    clase = columnas[i][1];
                    System.out.println("ATTRIBUTE NAME: " + columnas[i][0]);
                    if (clase.equals("java.math.BigDecimal")) {
                        System.out.println("-------------------BD---------------------");
                        BigDecimal ejemplo = rs.getBigDecimal(columnas[i][0]);
                        System.out.println("------- PROP: " + columnas[i][0] + " - CN: " + detallesFactura.get(columnas[i][0]) + " - VAL: " + ejemplo);//+ rs.getBigDecimal(factura.get(columnas[i][0])) + " ----------");
                        PropertyUtils.setSimpleProperty(det, columnas[i][0], ejemplo);
                        System.out.println("ATTRIBUTE NAME: " + columnas[i][0]);
                    } else if (clase.equals("java.lang.String")) {
                        System.out.println("-------------------Str---------------------");
                        PropertyUtils.setSimpleProperty(det, columnas[i][0], rs.getString(detallesFactura.get(columnas[i][0])));
                    } else if (clase.equals("java.lang.Double")) {
                        System.out.println("-------------------Db---------------------");
                        PropertyUtils.setSimpleProperty(det, columnas[i][0], rs.getDouble(detallesFactura.get(columnas[i][0])));
                    } else if (clase.equals("java.sql.Date")) {
                        System.out.println("-------------------Da---------------------");
                        PropertyUtils.setSimpleProperty(det, columnas[i][0], rs.getDate(detallesFactura.get(columnas[i][0])));
                    }
                    System.out.println("ATTRIBUTE VALUE: " + PropertyUtils.getSimpleProperty(det, columnas[i][0]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return det;
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
                System.out.println("detalle.set" + metadatos.getColumnLabel(i)+"();");
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
        detallesFactura = tableMapper.mapDbfTable("detalleFactura");
        switch (opcion) {
            case 1:
                sql = "INSERT INTO " + detallesFactura.get("archivoDbf") + "(CIDMOVIM01,CIDDOCUM01,CNUMEROM01,CIDDOCUM02,CIDPRODU01,CIDALMACEN,CUNIDADES,CUNIDADE01,"
                        + "CUNIDADE02,CIDUNIDAD,CIDUNIDA01,CPRECIO,CPRECIOC01,CCOSTOCA01,CCOSTOES01,CNETO,CIMPUESTO1,CPORCENT01,CIMPUESTO2,CPORCENT02,CIMPUESTO3,CPORCENT03"
                        + ",CRETENCI01,CPORCENT04,CRETENCI02,CPORCENT05,CDESCUEN01,CPORCENT06,CDESCUEN02,CPORCENT07,CDESCUEN03,CPORCENT08,CDESCUEN04,CPORCENT09,CDESCUEN05,"
                        + "CPORCENT10,CTOTAL,CPORCENT11,CREFEREN01,COBSERVA01,CAFECTAE01,CAFECTAD01,CAFECTAD02,CFECHA,CMOVTOOC01,CIDMOVTO01,CIDMOVTO02,CUNIDADE03,CUNIDADE04,"
                        + "CUNIDADE05,CUNIDADE06,CTIPOTRA01,CIDVALOR01,CTEXTOEX01,CTEXTOEX02,CTEXTOEX03,CFECHAEX01,CIMPORTE01,CIMPORTE02,CIMPORTE03,CIMPORTE04,CTIMESTAMP,CGTOMOVTO,"
                        + "CSCMOVTO,CCOMVENTA,CIDMOVDEST,CNUMCONSOL)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                break;
            case 2:
                sql = "UPDATE " + detallesFactura.get("archivoDbf") + " SET " + campo + " = " + valor;
                break;
            case 3:
                sql = "SELECT * FROM " + detallesFactura.get("archivoDbf") + " WHERE " + campo + " = " + valor;
                break;
            case 4:
                sql = "SELECT * FROM " + detallesFactura.get("archivoDbf");
                break;
            default:
                System.out.println("");
        }
        System.out.println("[DetalleFacturaDAO] SQL Generado: " + sql);
        return sql;
    }

    private boolean abrirConexion() {
        boolean done = false;
        System.out.println("[DetalleFacturaDAO] Se abrira conexion a la base de datos");
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq");
        conexion = contpaqConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[DetalleFacturaDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }

    private boolean cerrarConexion() {
        boolean done = false;
        System.out.println("[DetalleFacturaDAO] Se cerrara la conexion a la base de datos");
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            conexion = null;
        } catch (Exception e) {
            System.out.println("[DetalleFacturaDAO] Ocurrio un error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        }
        return done;
    }
}
