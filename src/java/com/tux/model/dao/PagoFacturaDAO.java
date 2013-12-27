/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.model.dao;

import com.tux.dto.ContpaqDetalleFactura;
import com.tux.dto.ContpaqFactura;
import com.tux.dto.ContpaqPagoFactura;
import com.tux.utils.ContpaqTableMapper;
import com.tux.utils.db.ContpaqConnection;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mike
 */
public class PagoFacturaDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> pago;
    private Map<String, String> factura;
    private Map<String, String> detallesFactura;

    public boolean crearPagoFactura(double nuevoSaldo, ContpaqFactura factura, ContpaqDetalleFactura detalleFactura, ContpaqPagoFactura pagoFactura) {
        boolean done = false;
        System.out.println("Nuevo saldo: " + nuevoSaldo);
        try {
            if (abrirConexion()) {
                conexion.setAutoCommit(false);
                //BLOQUE DE CREACION DE REGISTRO EN LA TABLA DE DOCUMENTOS MGW10008
                sentencia = conexion.prepareStatement(construirSQL(1, null, null, null, null));
                sentencia.setBigDecimal(1, factura.getCiddocum01());
                sentencia.setBigDecimal(2, factura.getCiddocum02());
                sentencia.setBigDecimal(3, factura.getCidconce01());
                //sentencia.setString(4, factura.getCseriedo01());
                sentencia.setDouble(4, factura.getCfolio());
                sentencia.setDate(5, factura.getCfecha());
                sentencia.setBigDecimal(6, factura.getCidclien01());
                sentencia.setString(7, factura.getCrazonso01());
                sentencia.setString(8, factura.getCrfc());
                sentencia.setBigDecimal(9, factura.getCidagente());
                sentencia.setDate(10, factura.getCfechave01());
                sentencia.setDate(11, factura.getCfechapr01());
                //sentencia.setDate(12, factura.getCfechaen01());
                sentencia.setDate(12, factura.getCfechaul01());
                sentencia.setBigDecimal(13, factura.getCidmoneda());
                sentencia.setDouble(14, factura.getCtipocam01());
                sentencia.setString(15, factura.getCreferen01());
                sentencia.setString(16, factura.getCobserva01());
                sentencia.setBigDecimal(17, factura.getCnatural01());
                //sentencia.setBigDecimal(20, factura.getCiddocum03());
                //sentencia.setBigDecimal(21, factura.getCplantilla());
                sentencia.setBigDecimal(18, factura.getCusaclie01());
                sentencia.setBigDecimal(19, factura.getCusaprov01());
                sentencia.setBigDecimal(20, factura.getCafectado());
                sentencia.setBigDecimal(21, factura.getCimpreso());
                sentencia.setBigDecimal(22, factura.getCcancelado());
                sentencia.setBigDecimal(23, factura.getCdevuelto());
                //sentencia.setBigDecimal(28, factura.getCidprepo01());
                //sentencia.setBigDecimal(29, factura.getCidprepo02());
                sentencia.setBigDecimal(24, factura.getCestadoc01());
                sentencia.setDouble(25, factura.getCneto());
                sentencia.setDouble(26, factura.getCimpuesto1());
                sentencia.setDouble(27, factura.getCimpuesto2());
                sentencia.setDouble(28, factura.getCimpuesto3());
                sentencia.setDouble(29, factura.getCretenci01());
                sentencia.setDouble(30, factura.getCretenci02());
                sentencia.setDouble(31, factura.getCdescuen01());
                sentencia.setDouble(32, factura.getCdescuen02());
                sentencia.setDouble(33, factura.getCdescuen03());
                sentencia.setDouble(34, factura.getCgasto1());
                sentencia.setDouble(35, factura.getCgasto2());
                sentencia.setDouble(36, factura.getCgasto3());
                sentencia.setDouble(37, factura.getCtotal());
                sentencia.setDouble(38, factura.getCpendiente());
                sentencia.setDouble(39, factura.getCtotalun01());
                sentencia.setDouble(40, factura.getCdescuen04());
                sentencia.setDouble(41, factura.getCporcent01());
                sentencia.setDouble(42, factura.getCporcent02());
                sentencia.setDouble(43, factura.getCporcent03());
                sentencia.setDouble(44, factura.getCporcent04());
                sentencia.setDouble(45, factura.getCporcent05());
                sentencia.setDouble(46, factura.getCporcent06());
                //sentencia.setString(53, factura.getCtextoex01());
                //sentencia.setString(54, factura.getCtextoex02());
                //sentencia.setString(55, factura.getCtextoex03());
                //sentencia.setDate(56, factura.getCfechaex01());
                sentencia.setDouble(47, factura.getCimporte01());
                sentencia.setDouble(48, factura.getCimporte02());
                sentencia.setDouble(49, factura.getCimporte03());
                sentencia.setDouble(50, factura.getCimporte04());
                sentencia.setString(51, factura.getCdestina01());
                sentencia.setString(52, factura.getCnumerog01());
                sentencia.setString(53, factura.getCmensaje01());
                sentencia.setString(54, factura.getCcuentam01());
                sentencia.setDouble(55, factura.getCnumeroc01());
                sentencia.setDouble(56, factura.getCpeso());
                sentencia.setBigDecimal(57, factura.getCbanobse01());
                sentencia.setBigDecimal(58, factura.getCbandato01());
                sentencia.setBigDecimal(59, factura.getCbancond01());
                sentencia.setBigDecimal(60, factura.getCbangastos());
                sentencia.setDouble(61, factura.getCunidade01());
                //sentencia.setString(72, factura.getCtimestamp());
                sentencia.setDouble(62, factura.getCimpcheq01());
                sentencia.setBigDecimal(63, factura.getCsistorig());
                sentencia.setBigDecimal(64, factura.getCidmonedca());
                sentencia.setDouble(65, factura.getCtipocamca());
                sentencia.setBigDecimal(66, factura.getCescfd());
                sentencia.setBigDecimal(67, factura.getCtienecfd());
                sentencia.execute();
                //BLOQUE DE CREACION DE REGISTRO EN LA TABLA DE ACUMULADOS MGW10010
                sentencia = conexion.prepareStatement(construirSQL(2, null, null, null, null));
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
                //sentencia.setBigDecimal(48, detalleFactura.getCtipotra01());
                //sentencia.setBigDecimal(49, detalleFactura.getCidvalor01());
                //sentencia.setString(54, detalleFactura.getCtextoex01());
                //sentencia.setString(55, detalleFactura.getCtextoex02());
                //sentencia.setString(56, detalleFactura.getCtextoex03());
                //sentencia.setDate(57, detalleFactura.getCfechaex01());
                sentencia.setDouble(48, detalleFactura.getCimporte01());
                sentencia.setDouble(49, detalleFactura.getCimporte02());
                sentencia.setDouble(50, detalleFactura.getCimporte03());
                sentencia.setDouble(51, detalleFactura.getCimporte04());
                ///sentencia.setString(62, detalleFactura.getCtimestamp());
                sentencia.setDouble(52, detalleFactura.getCgtomovto());
                //sentencia.setString(55, detalleFactura.getCscmovto());
                sentencia.setDouble(53, detalleFactura.getCcomventa());
                //sentencia.setBigDecimal(66, detalleFactura.getCidmovdest());
                //sentencia.setBigDecimal(67, detalleFactura.getCnumconsol());
                sentencia.execute();
                //BLOQUE DE CREACION DE REGISTRO EN LA TABLA DE CARGOS/ABONOS MGW10009
                sentencia = conexion.prepareStatement(construirSQL(3, null, null, null, null));
                sentencia.setBigDecimal(1, pagoFactura.getCiddocum01());
                sentencia.setBigDecimal(2, pagoFactura.getCiddocum02());
                sentencia.setDouble(3, pagoFactura.getCimporte01());
                sentencia.setDouble(4, pagoFactura.getCimporte02());
                sentencia.setDate(5, pagoFactura.getCfechaab01());
                sentencia.setBigDecimal(6, pagoFactura.getCidutili01());
                sentencia.setBigDecimal(7, pagoFactura.getCidajusiva());
                sentencia.execute();
                //BLOQUE DE DEL SALDO PENDIENTE EN LA TABLA DE DOCUMENTOS MGW10008
                sentencia = conexion.prepareStatement(construirSQL(4, "CPENDIENTE", ("" + nuevoSaldo), this.factura.get("id"), ("" + pagoFactura.getCiddocum02())));
                sentencia.execute();
                //BLOQUE DE CREACION DE REGISTRO EN LA TABLA DE ACUMULADOS MGW10018
                conexion.commit();
                done = true;
            } else {
                System.out.println("[PagoFacturaDAO] No se pudo guardar el pago de la factura");
            }
        } catch (Exception e) {
            if (conexion != null) {
                conexion.rollback();
                System.out.println("[PagoFacturaDAO] Haciendo rollback");
            }
            System.out.println("[PagoFacturaDAO] Ocurrio un error al guardar el pago de la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public ContpaqPagoFactura consultarPagoFactura(String criterio, String valor) {
        ContpaqPagoFactura factura = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor, null, null));
                resultado = sentencia.executeQuery();
                factura = construirPagoFactura(resultado);
                System.out.println("[PagoFacturaDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[PagoFacturaDAO] No se pudo guardar la factura");
            }
        } catch (Exception e) {
            System.out.println("[PagoFacturaDAO] Ocurrio un error al consultar el pago de la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return factura;
        }
    }

    public List<ContpaqPagoFactura> consultarTodasLasFactura() {
        List<ContpaqPagoFactura> pagos = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(4, null, null, null, null));
                sentencia.executeQuery();
                conexion.commit();
            } else {
                System.out.println("[PagoFacturaDAO] No se pudo guardar la factura");
            }
        } catch (Exception e) {
            System.out.println("[PagoFacturaDAO] Ocurrio un error al consultar la factura");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return pagos;
        }
    }

    private ContpaqPagoFactura construirPagoFactura(ResultSet rs) {
        ContpaqPagoFactura pagoFact = null;
        String clase;
        //String[][] columnas;
        try {
            //getColumnNames(rs);
            if (rs.next()) {
                pagoFact = new ContpaqPagoFactura();
                Field[] attributes = pagoFact.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                //columnas = getColumnNames(attributes);
                for (Field field : attributes) {
                    //for (int i = 0; i < columnas.length; i++) {
                    //clase = columnas[i][1];
                    field.setAccessible(true);
                    clase = field.getType().getCanonicalName();
                    //System.out.println("PagoFacturaDAO.construirPagoFactura: Obteniendo y seteando propiedad --> " + field.getName());
                    if (clase.equals("java.math.BigDecimal")) {
                        field.set(pagoFact, rs.getBigDecimal(field.getName()));
                    } else if (clase.equals("java.lang.String")) {
                        field.set(pagoFact, rs.getString(pago.get(field.getName())));
                    } else if (clase.equals("java.lang.Double")) {
                        field.set(pagoFact, rs.getDouble(pago.get(field.getName())));
                    } else if (clase.equals("java.sql.Date")) {
                        field.set(pagoFact, rs.getDate(pago.get(field.getName())));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagoFact;
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
    private String construirSQL(int opcion, String campo, String valor, String filtro, String valorFiltro) {
        String sql = "";
        ContpaqTableMapper tableMapper = new ContpaqTableMapper();
        pago = tableMapper.mapDbfTable("pagoFactura");
        factura = tableMapper.mapDbfTable("factura");
        detallesFactura = tableMapper.mapDbfTable("detalleFactura");
        switch (opcion) {
            case 1:
                sql = "INSERT INTO " + factura.get("archivoDbf") + "(CIDDOCUM01,CIDDOCUM02,CIDCONCE01,CFOLIO,CFECHA,"
                        + "CIDCLIEN01,CRAZONSO01,CRFC,CIDAGENTE,CFECHAVE01,CFECHAPR01,CFECHAUL01,CIDMONEDA,CTIPOCAM01,"
                        + "CREFEREN01,COBSERVA01,CNATURAL01,CUSACLIE01,CUSAPROV01,CAFECTADO,CIMPRESO,CCANCELADO,"
                        + "CDEVUELTO,CESTADOC01,CNETO,CIMPUESTO1,CIMPUESTO2,CIMPUESTO3,CRETENCI01,CRETENCI02,CDESCUEN01,"
                        + "CDESCUEN02,CDESCUEN03,CGASTO1,CGASTO2,CGASTO3,CTOTAL,CPENDIENTE,CTOTALUN01,CDESCUEN04,CPORCENT01,CPORCENT02,CPORCENT03,"
                        + "CPORCENT04,CPORCENT05,CPORCENT06,CIMPORTE01,CIMPORTE02,CIMPORTE03,CIMPORTE04,"
                        + "CDESTINA01,CNUMEROG01,CMENSAJE01,CCUENTAM01,CNUMEROC01,CPESO,CBANOBSE01,CBANDATO01,CBANCOND01,CBANGASTOS,CUNIDADE01,"
                        + "CIMPCHEQ01,CSISTORIG,CIDMONEDCA,CTIPOCAMCA,CESCFD,CTIENECFD)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                break;
            case 2:
                sql = "INSERT INTO " + detallesFactura.get("archivoDbf") + "(CIDMOVIM01,CIDDOCUM01,CNUMEROM01,CIDDOCUM02,CIDPRODU01,CIDALMACEN,CUNIDADES,CUNIDADE01,"
                        + "CUNIDADE02,CIDUNIDAD,CIDUNIDA01,CPRECIO,CPRECIOC01,CCOSTOCA01,CCOSTOES01,CNETO,CIMPUESTO1,CPORCENT01,CIMPUESTO2,CPORCENT02,CIMPUESTO3,CPORCENT03"
                        + ",CRETENCI01,CPORCENT04,CRETENCI02,CPORCENT05,CDESCUEN01,CPORCENT06,CDESCUEN02,CPORCENT07,CDESCUEN03,CPORCENT08,CDESCUEN04,CPORCENT09,CDESCUEN05,"
                        + "CPORCENT10,CTOTAL,CPORCENT11,CAFECTAE01,CAFECTAD01,CAFECTAD02,CFECHA,CMOVTOOC01,CUNIDADE03,CUNIDADE04,"
                        + "CUNIDADE05,CUNIDADE06,CIMPORTE01,CIMPORTE02,CIMPORTE03,CIMPORTE04,CGTOMOVTO,"
                        + "CCOMVENTA)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                break;
            case 3:
                sql = "INSERT INTO " + pago.get("archivoDbf") + "(CIDDOCUM01,CIDDOCUM02,CIMPORTE01,CIMPORTE02,CFECHAAB01,CIDUTILI01,CIDAJUSIVA)"
                        + " values(?,?,?,?,?,?,?)";
                break;
            case 4:
                sql = "UPDATE " + factura.get("archivoDbf") + " SET " + campo + " = " + valor + " WHERE " + filtro + " = " + valorFiltro;
                break;
            case 5:
                sql = "SELECT * FROM " + pago.get("archivoDbf") + " WHERE " + campo + " = " + valor;
                break;
            case 6:
                sql = "SELECT * FROM " + pago.get("archivoDbf");
                break;
            default:
                System.out.println("");
        }
        System.out.println("[PagoFacturaDAO] SQL Generado: " + sql);
        return sql;
    }

    private boolean abrirConexion() {
        boolean done = false;
        System.out.println("[PagoFacturaDAO] Se abrira conexion a la base de datos");
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq7");
        conexion = contpaqConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[PagoFacturaDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }

    private boolean cerrarConexion() {
        boolean done = false;
        System.out.println("[PagoFacturaDAO] Se cerrara la conexion a la base de datos");
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            conexion = null;
        } catch (Exception e) {
            System.out.println("[PagoFacturaDAO] Ocurrio un error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        }
        return done;
    }
}
