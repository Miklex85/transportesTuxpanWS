package com.tux.model.dao;

import com.tux.dto.ContpaqCliente;
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
import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author miklex
 */
public class ClienteDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;
    private Map<String, String> cliente;

    public boolean crearCliente(ContpaqCliente cliente) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                int i = 1;
                sentencia = conexion.prepareStatement(construirSQL(1, null, null));
                sentencia.setBigDecimal(1, cliente.getCidclien01());
                sentencia.setString(2, cliente.getCcodigoc01());
                sentencia.setString(3, cliente.getCrazonso01());
                sentencia.setDate(4, cliente.getCfechaalta());
                sentencia.setString(5, cliente.getCrfc());
                sentencia.setString(6, cliente.getCcurp());
                sentencia.setString(7, cliente.getCdencome01());
                sentencia.setString(8, cliente.getCreplegal());
                sentencia.setBigDecimal(9, cliente.getCidmoneda());
                sentencia.setBigDecimal(10, cliente.getClistapr01());
                sentencia.setDouble(11, cliente.getCdescuen01());
                sentencia.setDouble(12, cliente.getCdescuen02());
                sentencia.setBigDecimal(13, cliente.getCbanvent01());
                sentencia.setBigDecimal(14, cliente.getCidvalor01());
                sentencia.setBigDecimal(15, cliente.getCidvalor02());
                sentencia.setBigDecimal(16, cliente.getCidvalor03());
                sentencia.setBigDecimal(17, cliente.getCidvalor04());
                sentencia.setBigDecimal(18, cliente.getCidvalor05());
                sentencia.setBigDecimal(19, cliente.getCidvalor06());
                sentencia.setBigDecimal(20, cliente.getCtipocli01());
                sentencia.setBigDecimal(21, cliente.getCestatus());
                sentencia.setDate(22, cliente.getCfechabaja());
                sentencia.setDate(23, cliente.getCfechaul01());
                sentencia.setDouble(24, cliente.getClimitec01());
                sentencia.setBigDecimal(25, cliente.getCdiascre01());
                sentencia.setBigDecimal(26, cliente.getCbanexce01());
                sentencia.setDouble(27, cliente.getCdescuen03());
                sentencia.setBigDecimal(28, cliente.getCdiaspro01());
                sentencia.setDouble(29, cliente.getCinteres01());
                sentencia.setBigDecimal(30, cliente.getCdiapago());
                sentencia.setBigDecimal(31, cliente.getCdiasrev01());
                //sentencia.setString(32, cliente.getCmensaje01());
                //sentencia.setString(33, cliente.getCcuentam01());
                sentencia.setBigDecimal(32, cliente.getCdiasemb01());
                sentencia.setBigDecimal(33, cliente.getCidalmacen());
                //sentencia.setBigDecimal(36, cliente.getCidagent01());
                //sentencia.setBigDecimal(37, cliente.getCidagent02());
                //sentencia.setBigDecimal(38, cliente.getCrestric01());
                sentencia.setDouble(34, cliente.getCimpuesto1());
                sentencia.setDouble(35, cliente.getCimpuesto2());
                sentencia.setDouble(36, cliente.getCimpuesto3());
                sentencia.setDouble(37, cliente.getCretenci01());
                sentencia.setDouble(38, cliente.getCretenci02());
                sentencia.setBigDecimal(39, cliente.getCidvalor07());
                sentencia.setBigDecimal(40, cliente.getCidvalor08());
                sentencia.setBigDecimal(41, cliente.getCidvalor09());
                sentencia.setBigDecimal(42, cliente.getCidvalor10());
                sentencia.setBigDecimal(43, cliente.getCidvalor11());
                sentencia.setBigDecimal(44, cliente.getCidvalor12());
                sentencia.setDouble(45, cliente.getClimitec02());
                //sentencia.setBigDecimal(51, cliente.getCdiascre02());
                //sentencia.setBigDecimal(52, cliente.getCtiempoe01());
                sentencia.setBigDecimal(46, cliente.getCdiasemb02());
                sentencia.setDouble(47, cliente.getCimpuest01());
                sentencia.setDouble(48, cliente.getCimpuest02());
                sentencia.setDouble(49, cliente.getCimpuest03());
                sentencia.setDouble(50, cliente.getCretenci03());
                sentencia.setDouble(51, cliente.getCretenci04());
                //sentencia.setBigDecimal(59, cliente.getCbaninte01());
                sentencia.setDouble(52, cliente.getCcomvent01());
                sentencia.setDouble(53, cliente.getCcomcobr01());
                //sentencia.setBigDecimal(62, cliente.getCbanprod01());
                //sentencia.setString(63, cliente.getCsegcont01());
                //sentencia.setString(64, cliente.getCsegcont02());
                //sentencia.setString(65, cliente.getCsegcont03());
                //sentencia.setString(66, cliente.getCsegcont04());
                //sentencia.setString(67, cliente.getCsegcont05());
                //sentencia.setString(68, cliente.getCsegcont06());
                //sentencia.setString(69, cliente.getCsegcont07());
                //sentencia.setString(70, cliente.getCsegcont08());
                //sentencia.setString(71, cliente.getCsegcont09());
                //sentencia.setString(72, cliente.getCsegcont10());
                //sentencia.setString(73, cliente.getCsegcont11());
                //sentencia.setString(74, cliente.getCsegcont12());
                //sentencia.setString(75, cliente.getCsegcont13());
                //sentencia.setString(76, cliente.getCsegcont14());
                //sentencia.setString(77, cliente.getCtextoex01());
                //sentencia.setString(78, cliente.getCtextoex02());
                //sentencia.setString(79, cliente.getCtextoex03());
                //sentencia.setDate(80, cliente.getCfechaex01());
                sentencia.setDouble(54, cliente.getCimporte01());
                sentencia.setDouble(55, cliente.getCimporte02());
                sentencia.setDouble(56, cliente.getCimporte03());
                sentencia.setDouble(57, cliente.getCimporte04());
                sentencia.setBigDecimal(58, cliente.getCbandomi01());
                sentencia.setBigDecimal(59, cliente.getCbancred01());
                sentencia.setBigDecimal(60, cliente.getCbanenvio());
                sentencia.setBigDecimal(61, cliente.getCbanagente());
                sentencia.setBigDecimal(62, cliente.getCbanimpu01());
                //sentencia.setBigDecimal(90, cliente.getCbanprecio());
                //sentencia.setString(91, cliente.getCtimestamp());
                sentencia.setBigDecimal(63, cliente.getCfacterc01());
                sentencia.setDouble(64, cliente.getCcomventa());
                sentencia.setDouble(65, cliente.getCcomcobro());
                sentencia.setBigDecimal(66, cliente.getCidmoneda2());
                sentencia.setString(67, cliente.getCemail1());
                //sentencia.setString(97, cliente.getCemail2());
                //sentencia.setString(98, cliente.getCemail3());
                //sentencia.setBigDecimal(99, cliente.getCtipoentre());
                //sentencia.setBigDecimal(100, cliente.getCconcteema());
                //sentencia.setBigDecimal(101, cliente.getCftoaddend());
                //sentencia.setBigDecimal(102, cliente.getCidcertcte());
                //sentencia.setBigDecimal(103, cliente.getCencripent());
                sentencia.setBigDecimal(68, cliente.getCbancfd());
                //sentencia.setString(105, cliente.getCtextoex04());
                //sentencia.setString(106, cliente.getCtextoex05());
                sentencia.setDouble(69, cliente.getCimporte05());
                sentencia.setBigDecimal(70, cliente.getCidaddenda());
                //sentencia.setBigDecimal(109, cliente.getCcodprovco());
                //sentencia.setBigDecimal(110, cliente.getCenvacuse());
                //sentencia.setString(111, cliente.getCcon1nom());
                //sentencia.setString(112, cliente.getCcon1tel());
                //sentencia.setBigDecimal(113, cliente.getCquitablan());
                //sentencia.setBigDecimal(114, cliente.getCfmtoentre());
                sentencia.setBigDecimal(71, cliente.getCidcomplem());
                sentencia.setBigDecimal(72, cliente.getCdesglosai());
                System.out.println(i);
                //sentencia.setBigDecimal(117, cliente.getClimdoctos());
                //sentencia.setString(118, cliente.getCsitioftp());
                //sentencia.setString(119, cliente.getCusrftp());
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[ClienteDAO] No se pudo guardar el cliente");
            }
        } catch (Exception e) {
            System.out.println("[ClienteDAO] Ocurrio un error al guardar el cliente");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public boolean actualizarCliente(String campo, String valor) {
        boolean done = false;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(2, campo, valor));
                sentencia.execute();
                conexion.commit();
                done = true;
            } else {
                System.out.println("[ClienteDAO] No se pudo actualizar el cliente");
            }
        } catch (Exception e) {
            System.out.println("[ClienteDAO] Ocurrio un error al actualizar el cliente");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return done;
        }
    }

    public ContpaqCliente consultarCliente(String criterio, String valor) {
        ContpaqCliente cliente = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(3, criterio, valor));
                resultado = sentencia.executeQuery();
                cliente = construirCliente(resultado);
                System.out.println("[ClienteDAO] Termina ejecucion de metodo");
            } else {
                System.out.println("[ClienteDAO] No se pudo consultar el cliente");
            }
        } catch (Exception e) {
            System.out.println("[ClienteDAO] Ocurrio un error al consultar el cliente");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return cliente;
        }
    }

    public List<ContpaqCliente> consultarTodosLosClientes() {
        List<ContpaqCliente> facturas = null;
        try {
            if (abrirConexion()) {
                sentencia = conexion.prepareStatement(construirSQL(4, null, null));
                sentencia.execute();
                conexion.commit();
            } else {
                System.out.println("[ClienteDAO] No se pudo obtener la lista de clientes");
            }
        } catch (Exception e) {
            System.out.println("[ClienteDAO] Ocurrio un error la lista de clientes");
            e.printStackTrace();
        } finally {
            cerrarConexion();
            return facturas;
        }
    }

    private ContpaqCliente construirCliente(ResultSet rs) {
        ContpaqCliente client = null;
        String clase;
        //String[][] columnas;
        try {
            getColumnNames(rs);
            if (rs.next()) {
                client = new ContpaqCliente();
                Field[] attributes = client.getClass().getDeclaredFields();
                System.out.println("Detectados " + attributes.length + " atributos");
                //columnas = getColumnNames(attributes);
                for (Field field : attributes) {
                    //for (int i = 0; i < columnas.length; i++) {
                    //clase = columnas[i][1];
                    field.setAccessible(true);
                    clase = field.getType().getCanonicalName();
                    System.out.println("ClienteDAO.construirCliente: Obteniendo y seteando propiedad --> " + field.getName());
                    if (clase.equals("java.math.BigDecimal")) {
                        field.set(client, rs.getBigDecimal(field.getName()));
                    } else if (clase.equals("java.lang.String")) {
                        field.set(client, rs.getString(cliente.get(field.getName())));
                    } else if (clase.equals("java.lang.Double")) {
                        field.set(client, rs.getDouble(cliente.get(field.getName())));
                    } else if (clase.equals("java.sql.Date")) {
                        field.set(client, rs.getDate(cliente.get(field.getName())));
                    }
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
            //System.out.println("-----> " + respuesta[x][0] + " - " + respuesta[x][1]);
        }
        return respuesta;
    }

    private void getColumnNames(ResultSet rs) {
        try {
            ResultSetMetaData metadatos = rs.getMetaData();
            metadatos.getClass().getSimpleName();
            for (int i = 1; i <= metadatos.getColumnCount(); i++) {
                //System.out.println("private "+metadatos.getColumnClassName(i) + " " + metadatos.getColumnLabel(i)+";");
                System.out.println("contpaqCliente.get" + metadatos.getColumnLabel(i) + "();");
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
        cliente = tableMapper.mapDbfTable("cliente");
        switch (opcion) {
            case 1:
                sql = "INSERT INTO " + cliente.get("archivoDbf") + "(CIDCLIEN01,CCODIGOC01,CRAZONSO01,CFECHAALTA,CRFC,CCURP,CDENCOME01,CREPLEGAL,CIDMONEDA,CLISTAPR01,CDESCUEN01,"
                        + "CDESCUEN02,CBANVENT01,CIDVALOR01,CIDVALOR02,CIDVALOR03,CIDVALOR04,CIDVALOR05,CIDVALOR06,CTIPOCLI01,CESTATUS,CFECHABAJA,CFECHAUL01,CLIMITEC01,CDIASCRE01,"
                        + "CBANEXCE01,CDESCUEN03,CDIASPRO01,CINTERES01,CDIAPAGO,CDIASREV01,CDIASEMB01,CIDALMACEN,CIMPUESTO1,"
                        + "CIMPUESTO2,CIMPUESTO3,CRETENCI01,CRETENCI02,CIDVALOR07,CIDVALOR08,CIDVALOR09,CIDVALOR10,CIDVALOR11,CIDVALOR12,CLIMITEC02,CDIASEMB02,"
                        + "CIMPUEST01,CIMPUEST02,CIMPUEST03,CRETENCI03,CRETENCI04,CCOMVENT01,CCOMCOBR01,"
                        + "CIMPORTE01,"
                        + "CIMPORTE02,CIMPORTE03,CIMPORTE04,CBANDOMI01,CBANCRED01,CBANENVIO,CBANAGENTE,CBANIMPU01,CFACTERC01,CCOMVENTA,CCOMCOBRO,CIDMONEDA2,CEMAIL1,"
                        + "CBANCFD,CIMPORTE05,CIDADDENDA,"
                        + "CIDCOMPLEM,CDESGLOSAI)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                break;
            case 2:
                sql = "UPDATE " + cliente.get("archivoDbf") + " SET " + campo + " = " + valor;
                break;
            case 3:
                sql = "SELECT * FROM " + cliente.get("archivoDbf") + " WHERE " + campo + " = " + valor;
                break;
            case 4:
                sql = "SELECT * FROM " + cliente.get("archivoDbf");
                break;
            default:
                System.out.println("");
        }
        System.out.println("[ClienteDAO] SQL Generado: " + sql);
        return sql;
    }

    private boolean abrirConexion() {
        boolean done = false;
        System.out.println("[ClienteDAO] Se abrira conexion a la base de datos");
        ContpaqConnection contpaqConnection = new ContpaqConnection("Contpaq");
        conexion = contpaqConnection.getConnection();
        if (conexion != null) {
            done = true;
        } else {
            System.out.println("[ClienteDAO] No se pudo obtener la conexion a la base de datos");
        }
        return done;
    }

    private boolean cerrarConexion() {
        boolean done = false;
        System.out.println("[ClienteDAO] Se cerrara la conexion a la base de datos");
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            conexion = null;
        } catch (Exception e) {
            System.out.println("[ClienteDAO] Ocurrio un error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        }
        return done;
    }
}
