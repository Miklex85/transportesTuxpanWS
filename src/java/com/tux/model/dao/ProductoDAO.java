package com.tux.model.dao;

import com.tux.dto.ContpaqProducto;
import com.tux.dto.ContpaqServicio;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mike
 */
public class ProductoDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> producto;

    public boolean crearProductoServicio(ContpaqProducto producto) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(1, null, null));
                sentencia.setBigDecimal(1, producto.getCidprodu01());
                sentencia.setString(2, producto.getCcodigop01());
                sentencia.setString(3, producto.getCnombrep01());
                sentencia.setBigDecimal(4, producto.getCtipopro01());
                sentencia.setDate(5, producto.getCfechaal01());
                sentencia.setBigDecimal(6, producto.getCcontrol01());
                sentencia.setBigDecimal(7, producto.getCidfotop01());
                sentencia.setString(8, producto.getCdescrip01());
                sentencia.setBigDecimal(9, producto.getCmetodoc01());
                sentencia.setDouble(10, producto.getCpesopro01());
                sentencia.setDouble(11, producto.getCcomvent01());
                sentencia.setDouble(12, producto.getCcomcobr01());
                sentencia.setDouble(13, producto.getCcostoes01());
                sentencia.setDouble(14, producto.getCmargenu01());
                sentencia.setBigDecimal(15, producto.getCstatusp01());
                sentencia.setBigDecimal(16, producto.getCidunida01());
                sentencia.setBigDecimal(17, producto.getCidunida02());
                sentencia.setDate(18, producto.getCfechabaja());
                sentencia.setDouble(19, producto.getCimpuesto1());
                sentencia.setDouble(20, producto.getCimpuesto2());
                sentencia.setDouble(21, producto.getCimpuesto3());
                sentencia.setDouble(22, producto.getCretenci01());
                sentencia.setDouble(23, producto.getCretenci02());
                sentencia.setBigDecimal(24, producto.getCidpadre01());
                sentencia.setBigDecimal(25, producto.getCidpadre02());
                sentencia.setBigDecimal(26, producto.getCidpadre03());
                sentencia.setBigDecimal(27, producto.getCidvalor01());
                sentencia.setBigDecimal(28, producto.getCidvalor02());
                sentencia.setBigDecimal(29, producto.getCidvalor03());
                sentencia.setBigDecimal(30, producto.getCidvalor04());
                sentencia.setBigDecimal(31, producto.getCidvalor05());
                sentencia.setBigDecimal(32, producto.getCidvalor06());
                //sentencia.setString(33, producto.getCsegcont01());
                //sentencia.setString(34, producto.getCsegcont02());
                //sentencia.setString(35, producto.getCsegcont03());
                //sentencia.setString(36, producto.getCtextoex01());
                //sentencia.setString(37, producto.getCtextoex02());
                //sentencia.setString(38, producto.getCtextoex03());
                //sentencia.setDate(39, producto.getCfechaex01());
                sentencia.setDouble(33, producto.getCimporte01());
                sentencia.setDouble(34, producto.getCimporte02());
                sentencia.setDouble(35, producto.getCimporte03());
                sentencia.setDouble(36, producto.getCimporte04());
                sentencia.setDouble(37, producto.getCprecio1());
                sentencia.setDouble(38, producto.getCprecio2());
                sentencia.setDouble(39, producto.getCprecio3());
                sentencia.setDouble(40, producto.getCprecio4());
                sentencia.setDouble(41, producto.getCprecio5());
                sentencia.setDouble(42, producto.getCprecio6());
                sentencia.setDouble(43, producto.getCprecio7());
                sentencia.setDouble(44, producto.getCprecio8());
                sentencia.setDouble(45, producto.getCprecio9());
                sentencia.setDouble(46, producto.getCprecio10());
                //sentencia.setBigDecimal(54, producto.getCbanunid01());
                //sentencia.setBigDecimal(55, producto.getCbancara01());
                //sentencia.setBigDecimal(56, producto.getCbanmeto01());
                //sentencia.setBigDecimal(57, producto.getCbanmaxmin());
                //sentencia.setBigDecimal(58, producto.getCbanprecio());
                sentencia.setBigDecimal(47, producto.getCbanimpu01());
                //sentencia.setBigDecimal(60, producto.getCbancodi01());
                //sentencia.setBigDecimal(61, producto.getCbancomp01());
                //sentencia.setString(62, producto.getCtimestamp());
                sentencia.setBigDecimal(48, producto.getCerrorco01());
                sentencia.setDate(49, producto.getCfechaer01());
                sentencia.setDouble(50, producto.getCprecioc01());
                //sentencia.setBigDecimal(66, producto.getCestadop01());
                //sentencia.setBigDecimal(67, producto.getCbanubic01());
                sentencia.setBigDecimal(51, producto.getCesexento());
                //sentencia.setBigDecimal(69, producto.getCexisten01());
                sentencia.setDouble(52, producto.getCcostoext1());
                sentencia.setDouble(53, producto.getCcostoext2());
                sentencia.setDouble(54, producto.getCcostoext3());
                sentencia.setDouble(55, producto.getCcostoext4());
                sentencia.setDouble(56, producto.getCcostoext5());
                //sentencia.setDate(75, producto.getCfeccosex1());
                //sentencia.setDate(76, producto.getCfeccosex2());
                //sentencia.setDate(77, producto.getCfeccosex3());
                //sentencia.setDate(78, producto.getCfeccosex4());
                //sentencia.setDate(79, producto.getCfeccosex5());
                //sentencia.setBigDecimal(80, producto.getCmoncosex1());
                //sentencia.setBigDecimal(81, producto.getCmoncosex2());
                //sentencia.setBigDecimal(82, producto.getCmoncosex3());
                //sentencia.setBigDecimal(83, producto.getCmoncosex4());
                //sentencia.setBigDecimal(84, producto.getCmoncosex5());
                //sentencia.setBigDecimal(85, producto.getCbancosex());
                sentencia.setBigDecimal(57, producto.getCescuotai2());
                sentencia.setBigDecimal(58, producto.getCescuotai3());
                sentencia.setBigDecimal(59, producto.getCidunicom());
                sentencia.setBigDecimal(60, producto.getCiduniven());
                //sentencia.setBigDecimal(90, producto.getCsubtipo());
                sentencia.setString(61, producto.getCcodaltern());
                sentencia.setString(62, producto.getCnomaltern());
                sentencia.setString(63, producto.getCdesccorta());
                //sentencia.setBigDecimal(94, producto.getCidmoneda());
                //sentencia.setBigDecimal(95, producto.getCusabascu());
                //sentencia.setBigDecimal(96, producto.getCtipopaque());
                //sentencia.setBigDecimal(97, producto.getCprecselec());
                sentencia.setBigDecimal(64, producto.getCdesglosai());
                //sentencia.setString(99, producto.getCsegcont04());
                //sentencia.setString(100, producto.getCsegcont05());
                //sentencia.setString(101, producto.getCsegcont06());
                //sentencia.setString(102, producto.getCsegcont07());
                //sentencia.setBigDecimal(103, producto.getCnomodcomp());
                sentencia.execute();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
                String textDate = df.format(producto.getCfechaal01());
                sentencia = conexion.prepareStatement("INSERT INTO MGW10004(CIDPRODU01,CTIPOPRO01,CTIMESTAMP) VALUES (?,?,?)");
                sentencia.setBigDecimal(1, producto.getCidprodu01());
                sentencia.setBigDecimal(2, BigDecimal.valueOf(0));
                sentencia.setString(3, textDate);
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[ProductoDAO] No se pudo guardar el producto/servicio");
            }
        } catch (Exception e) {
            if (conexion != null) {
                conexion.rollback();
            }
            System.out.println("[ProductoDAO] Ocurrio un error al guardar el producto/servicio");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public boolean actualizarProductoServicio(String campo, String valor) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(2, campo, valor));
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[ProductoDAO] No se pudo actualizar el producto/servicio");
            }
        } catch (Exception e) {
            System.out.println("[ProductoDAO] Ocurrio un error al actualizar el producto/servicio");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public ContpaqProducto consultarProducto(String criterio, String valor) {
        ContpaqProducto producto = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                producto = construirProducto(resultado);
                System.out.println("[ProductoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[ProductoDAO] No se pudo consultar el producto");
            }
        } catch (Exception e) {
            System.out.println("[ProductoDAO] Ocurrio un error al consultar el producto");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return producto;
        }
    }

    public List<ContpaqProducto> consultarTodosLosProductos() {
        List<ContpaqProducto> productos = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(4, null, null));
                sentencia.execute();
                conexion.commit();
            } else {
                System.out.println("[ProductoDAO] No se pudo obtener la lista de productos/servicios");
            }
        } catch (Exception e) {
            System.out.println("[ProductoDAO] Ocurrio un error al consultar los productos/servicios");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return productos;
        }
    }

    public ContpaqServicio consultarServicio(String criterio, String valor) {
        ContpaqServicio servicio = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                //servicio = construirProducto(resultado);
                System.out.println("[ProductoDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[ProductoDAO] No se pudo consultar el producto/servicio");
            }
        } catch (Exception e) {
            System.out.println("[ProductoDAO] Ocurrio un error al consultar el producto/servicio");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return servicio;
        }
    }

    public List<ContpaqServicio> consultarTodosLosServicios() {
        List<ContpaqServicio> servicios = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(4, null, null));
                sentencia.execute();
                conexion.commit();
            } else {
                System.out.println("[ProductoDAO] No se pudo g");
            }
        } catch (Exception e) {
            System.out.println("[ProductoDAO] Ocurrio un error al consultar los servicios");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return servicios;
        }
    }

    private ContpaqProducto construirProducto(ResultSet rs) {
        ContpaqProducto prod = null;
        String clase;
        String[][] columnas;
        try {
            getColumnNames(rs);
            if (rs.next()) {
                prod = new ContpaqProducto();
                Field[] attributes = prod.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                //columnas = getColumnNames(attributes);
                for (Field field : attributes) {
                    //for (int i = 0; i < columnas.length; i++) {
                    //clase = columnas[i][1];
                    field.setAccessible(true);
                    clase = field.getType().getCanonicalName();
                    System.out.println("ProductoDAO.construirCliente: Obteniendo y seteando propiedad --> " + field.getName());
                    if (clase.equals("java.math.BigDecimal")) {
                        field.set(prod, rs.getBigDecimal(field.getName()));
                    } else if (clase.equals("java.lang.String")) {
                        field.set(prod, rs.getString(producto.get(field.getName())));
                    } else if (clase.equals("java.lang.Double")) {
                        field.set(prod, rs.getDouble(producto.get(field.getName())));
                    } else if (clase.equals("java.sql.Date")) {
                        field.set(prod, rs.getDate(producto.get(field.getName())));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prod;
    }

    private String[][] getColumnNames(Field[] campos) {
        String[][] respuesta = new String[campos.length][2];
        for (int x = 0; x < campos.length; x++) {
            respuesta[x][0] = ((Field) campos[x]).getName();
            respuesta[x][1] = ((Field) campos[x]).getType().getCanonicalName();
            //System.out.println("-----> " + respuesta[x][0] + " - " + respuesta[x][1]);
        }
        return respuesta;
    }

    private void getColumnNames(ResultSet rs) {
        try {
            ResultSetMetaData metadatos = rs.getMetaData();
            metadatos.getClass().getSimpleName();
            for (int i = 1; i <= metadatos.getColumnCount(); i++) {
                System.out.println("contpaqProducto.set" + metadatos.getColumnLabel(i) + "();");
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
        producto = tableMapper.mapDbfTable("productoServicio");
        switch (opcion) {
            case 1:
                sql = "INSERT INTO " + producto.get("archivoDbf") + "(CIDPRODU01,CCODIGOP01,CNOMBREP01,CTIPOPRO01,CFECHAAL01,CCONTROL01,CIDFOTOP01,CDESCRIP01,CMETODOC01,CPESOPRO01,"
                        + "CCOMVENT01,CCOMCOBR01,CCOSTOES01,CMARGENU01,CSTATUSP01,CIDUNIDA01,CIDUNIDA02,CFECHABAJA,CIMPUESTO1,CIMPUESTO2,CIMPUESTO3,CRETENCI01,CRETENCI02,CIDPADRE01,"
                        + "CIDPADRE02,CIDPADRE03,CIDVALOR01,CIDVALOR02,CIDVALOR03,CIDVALOR04,CIDVALOR05,CIDVALOR06,"
                        + "CIMPORTE01,CIMPORTE02,CIMPORTE03,CIMPORTE04,CPRECIO1,CPRECIO2,CPRECIO3,CPRECIO4,CPRECIO5,CPRECIO6,CPRECIO7,CPRECIO8,CPRECIO9,CPRECIO10,"
                        + "CBANIMPU01,CERRORCO01,CFECHAER01,CPRECIOC01,CESEXENTO,"
                        + "CCOSTOEXT1,CCOSTOEXT2,CCOSTOEXT3,CCOSTOEXT4,CCOSTOEXT5,"
                        + "CESCUOTAI2,CESCUOTAI3,CIDUNICOM,CIDUNIVEN,CCODALTERN,CNOMALTERN,CDESCCORTA,CDESGLOSAI)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                break;
            case 2:
                sql = "UPDATE " + producto.get("archivoDbf") + " SET " + campo + " = " + valor;
                break;
            case 3:
                sql = "SELECT * FROM " + producto.get("archivoDbf") + " WHERE " + campo + " = " + valor;
                break;
            case 4:
                sql = "SELECT * FROM " + producto.get("archivoDbf");
                break;
            default:
                System.out.println("");
        }
        System.out.println("[ProductoDAO] SQL Generado: " + sql);
        return sql;
    }

    private boolean abrirConexion() {
        boolean done = false;
        System.out.println("[ProductoDAO] Se abrira conexion a la base de datos");
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq");
        conexion = contpaqConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[ProductoDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }

    private boolean cerrarConexion() {
        boolean done = false;
        System.out.println("[ProductoDAO] Se cerrara la conexion a la base de datos");
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            conexion = null;
        } catch (Exception e) {
            System.out.println("[ProductoDAO] Ocurrio un error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        }
        return done;
    }
}
