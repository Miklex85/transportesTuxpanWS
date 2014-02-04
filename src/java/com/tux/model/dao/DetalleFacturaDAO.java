package com.tux.model.dao;

import com.tux.dto.ContpaqDetalleFactura;
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
public class DetalleFacturaDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> detallesFactura;

    public boolean crearDetalleFactura(ContpaqDetalleFactura detalleFactura) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                conexion.setAutoCommit(false);
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
                //sentencia.setString(39, detalleFactura.getCreferen01());
                //sentencia.setString(40, detalleFactura.getCobserva01());
                sentencia.setBigDecimal(39, detalleFactura.getCafectae01());
                sentencia.setBigDecimal(40, detalleFactura.getCafectad01());
                sentencia.setBigDecimal(41, detalleFactura.getCafectad02());
                sentencia.setDate(42, detalleFactura.getCfecha());
                sentencia.setBigDecimal(43, detalleFactura.getCmovtooc01());
                //sentencia.setBigDecimal(46, detalleFactura.getCidmovto01());
                //sentencia.setBigDecimal(47, detalleFactura.getCidmovto02());
                sentencia.setDouble(44, detalleFactura.getCunidade03());
                sentencia.setDouble(45, detalleFactura.getCunidade04());
                sentencia.setDouble(46, detalleFactura.getCunidade05());
                sentencia.setDouble(47, detalleFactura.getCunidade06());
                sentencia.setBigDecimal(48, detalleFactura.getCtipotra01());
                sentencia.setBigDecimal(49, detalleFactura.getCidvalor01());
                //sentencia.setString(54, detalleFactura.getCtextoex01());
                //sentencia.setString(55, detalleFactura.getCtextoex02());
                //sentencia.setString(56, detalleFactura.getCtextoex03());
                //sentencia.setDate(57, detalleFactura.getCfechaex01());
                sentencia.setDouble(50, detalleFactura.getCimporte01());
                sentencia.setDouble(51, detalleFactura.getCimporte02());
                sentencia.setDouble(52, detalleFactura.getCimporte03());
                sentencia.setDouble(53, detalleFactura.getCimporte04());
                ///sentencia.setString(62, detalleFactura.getCtimestamp());
                sentencia.setDouble(54, detalleFactura.getCgtomovto());
                //sentencia.setString(55, detalleFactura.getCscmovto());
                sentencia.setDouble(55, detalleFactura.getCcomventa());
                //sentencia.setBigDecimal(66, detalleFactura.getCidmovdest());
                //sentencia.setBigDecimal(67, detalleFactura.getCnumconsol());
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[DetalleFacturaDAO] No se pudo guardar la direccion");
            }
        } catch (Exception e) {
            if (conexion != null) {
                conexion.rollback();
                System.out.println("[DetalleFacturaDAO] Haciendo rollback");
            }
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
            //getColumnNames(rs);
            if (rs.next()) {
                det = new ContpaqDetalleFactura();
                Field[] attributes = det.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                //columnas = getColumnNames(attributes);
                for (Field field : attributes) {
                    //for (int i = 0; i < columnas.length; i++) {
                    //clase = columnas[i][1];
                    field.setAccessible(true);
                    clase = field.getType().getCanonicalName();
                    //System.out.println("DetalleFacturaDAO.construirCliente: Obteniendo y seteando propiedad --> " + field.getName());
                    if (clase.equals("java.math.BigDecimal")) {
                        field.set(detallesFactura, rs.getBigDecimal(field.getName()));
                    } else if (clase.equals("java.lang.String")) {
                        field.set(detallesFactura, rs.getString(detallesFactura.get(field.getName())));
                    } else if (clase.equals("java.lang.Double")) {
                        field.set(detallesFactura, rs.getDouble(detallesFactura.get(field.getName())));
                    } else if (clase.equals("java.sql.Date")) {
                        field.set(detallesFactura, rs.getDate(detallesFactura.get(field.getName())));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return det;
    }

    public BigDecimal getMaxId() {
        BigDecimal numeroFactura = null;
        try {
            if (abrirConexionFirebird()) {
                sentencia = conexion.prepareStatement(construirSQL(5, "seq_detalle_factura_id", null));
                resultado = sentencia.executeQuery();
                if (resultado.next()) {
                    numeroFactura = resultado.getBigDecimal(1);
                    System.out.println("[DetalleFacturaDAO] Obtenido el id : " + numeroFactura);
                }
            } else {
                System.out.println("[DetalleFacturaDAO] No se pudo obtener el siguiente ID");
            }
        } catch (Exception e) {
            System.out.println("[DetalleFacturaDAO] Ocurrio un error al obtener el siguiente ID");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return numeroFactura;
        }
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
                System.out.println("detalle.set" + metadatos.getColumnLabel(i) + "();");
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
                        + "CPORCENT10,CTOTAL,CPORCENT11,CAFECTAE01,CAFECTAD01,CAFECTAD02,CFECHA,CMOVTOOC01,CUNIDADE03,CUNIDADE04,"
                        + "CUNIDADE05,CUNIDADE06,CTIPOTRA01,CIDVALOR01,CIMPORTE01,CIMPORTE02,CIMPORTE03,CIMPORTE04,CGTOMOVTO,"
                        + "CCOMVENTA)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            case 5:
                sql = "SELECT NEXT VALUE FOR " + campo + " FROM RDB$DATABASE";
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
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq7");
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

    private boolean abrirConexionFirebird() {
        boolean done = false;
        System.out.println("[DetalleFacturaDAO] Se abrira conexion a la base de datos");
        FirebirdConnection firebirdConnection = new FirebirdConnection();
        conexion = firebirdConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[DetalleFacturaDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }
}
