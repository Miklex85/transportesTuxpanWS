package com.tux.model.dao;

import com.tux.dto.ContpaqAcumulado;
import com.tux.dto.ContpaqFolioDigital;
import com.tux.utils.ContpaqTableMapper;
import com.tux.utils.db.ContpaqConnection;
import com.tux.utils.db.FirebirdConnection;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mike
 */
public class AcumuladoDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> folioDigital;
    private Calendar currentDate;
    private BigDecimal ejercicio;

    public AcumuladoDAO() {
        currentDate = Calendar.getInstance();
        ejercicio = getEjercicioFiscalActual();
    }

    public boolean registrarAcumulado(List<ContpaqAcumulado> acumulados) {
        boolean done = false;
        try {
            int x = 0;
            if (abrirConexion()) {
                conexion.setAutoCommit(done);
                while (x < acumulados.size()) {
                    sentencia = conexion.prepareStatement(construirSQL(1, null, null));
                    sentencia.execute();
                    x++;
                }
                conexion.commit();
                done = true;
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            if (conexion != null) {
                conexion.rollback();
                System.out.println("[AcumuladoDAO] Haciendo rollback");
            }
            System.out.println("[AcumuladoDAO] Ocurrio un error al guardar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public Double consultarVentasCliente(long idCliente) { // 16
        Double acum = null;
        int mes = (currentDate.get(Calendar.MONTH) + 3);
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement("SELECT CIMPORTE" + ((mes < 10) ? ("0" + mes) : (mes)) + " FROM MGW10018 WHERE CIDOWNER01 = " + idCliente + " AND CIDEJERC01 = " + ejercicio + " AND CIDTIPOA01 = 16" );
                resultado = sentencia.executeQuery();
                //acum = construirAcumulado(resultado);
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return acum;
        }
    }

    public Double consultarDeudasCliente(String criterio, String valor) { // 57
        Double acum = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                //acum = construirAcumulado(resultado);
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return acum;
        }
    }

    public Double consultarPagosCliente(String criterio, String valor) { // 47
        Double acum = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                //acum = construirAcumulado(resultado);
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return acum;
        }
    }

    public Double consultarVentasGenerales(String criterio, String valor) { // 15
        Double acum = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                //acum = construirAcumulado(resultado);
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return acum;
        }
    }

    public Double consultarVentasProducto(String criterio, String valor) { // 18 y 21
        Double acum = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                //acum = construirAcumulado(resultado);
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return acum;
        }
    }

    public boolean actualizarAcumuladoProducto(double total, long idProducto) { // 18 y 21
        boolean hecho = false;
        try {
            if (abrirConexion()) {
                //sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                //acum = construirAcumulado(resultado);
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return hecho;
        }
    }

    public boolean actualizarVentasCliente(double total, long idCliente) { // 16
        boolean hecho = false;
        try {
            if (abrirConexion()) {
                //sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                //acum = construirAcumulado(resultado);
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return hecho;
        }
    }

    public boolean actualizarDeudasCliente(double total, long idCliente) { // 57
        boolean hecho = false;
        try {
            if (abrirConexion()) {
                //sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                //acum = construirAcumulado(resultado);
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return hecho;
        }
    }

    public boolean actualizarAcumuladoGeneral(double total) { // 15
        boolean hecho = false;
        try {
            if (abrirConexion()) {
                //sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                //acum = construirAcumulado(resultado);
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return hecho;
        }
    }

    public BigDecimal getEjercicioFiscalActual() {
        BigDecimal ejercicioActual = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement("SELECT CIDEJERC01 FROM MGW10031 WHERE CEJERCICIO = " + currentDate.get(Calendar.YEAR));
                resultado = sentencia.executeQuery();
                if (resultado.next()) {
                    ejercicioActual = resultado.getBigDecimal(1);
                }
                System.out.println("[AcumuladoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[AcumuladoDAO] No se pudo guardar el acumulado");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al consultar el acumulado");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return ejercicioActual;
        }
    }

    public BigDecimal getMaxId() {
        BigDecimal numeroFactura = null;
        try {
            if (abrirConexionFirebird()) {
                sentencia = conexion.prepareStatement(construirSQL(6, "seq_acumulado_id", null));
                resultado = sentencia.executeQuery();
                if (resultado.next()) {
                    numeroFactura = resultado.getBigDecimal(1);
                }
            } else {
                System.out.println("[AcumuladoDAO] No se pudo obtener el siguiente ID");
            }
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al obtener el siguiente ID");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return numeroFactura;
        }
    }

    private ContpaqAcumulado construirAcumulado(ResultSet rs) {
        ContpaqAcumulado fact = null;
        String clase;
        //String[][] columnas;
        try {
            getColumnNames(rs);
            if (rs.next()) {
                fact = new ContpaqAcumulado();
                Field[] attributes = fact.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                //columnas = getColumnNames(attributes);
                for (Field field : attributes) {
                    //for (int i = 0; i < columnas.length; i++) {
                    //clase = columnas[i][1];
                    field.setAccessible(true);
                    clase = field.getType().getCanonicalName();
                    //System.out.println("AcumuladoDAO.construirFactura: Obteniendo y seteando propiedad --> " + field.getName());
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
            System.out.println("AcumuladoDAO.construirAcumulado: Ocurrio un error al construir el acumulado");
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
        System.out.println("[AcumuladoDAO] SQL Generado: " + sql);
        return sql;
    }

    private boolean abrirConexion() {
        boolean done = false;
        System.out.println("[AcumuladoDAO] Se abrira conexion a la base de datos");
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq7");
        conexion = contpaqConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[AcumuladoDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }

    private boolean cerrarConexion() {
        boolean done = false;
        System.out.println("[AcumuladoDAO] Se cerrara la conexion a la base de datos");
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            conexion = null;
        } catch (Exception e) {
            System.out.println("[AcumuladoDAO] Ocurrio un error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        }
        return done;
    }

    private boolean abrirConexionFirebird() {
        boolean done = false;
        System.out.println("[AcumuladoDAO] Se abrira conexion a la base de datos");
        FirebirdConnection firebirdConnection = new FirebirdConnection();
        conexion = firebirdConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[AcumuladoDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }
}
