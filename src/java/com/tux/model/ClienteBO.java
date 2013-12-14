/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.model;

import com.tux.dto.ContpaqCliente;
import com.tux.dto.ContpaqDireccion;
import com.tux.model.dao.ClienteDAO;
import com.tux.model.dao.DireccionDAO;
import com.tux.model.entity.Cliente;
import com.tux.model.entity.DireccionCliente;
import com.tux.utils.FechaUtils;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mike
 */
public class ClienteBO {
    
    public Cliente consultarCliente(long idCliente) {
        Cliente cliente = null;
        ContpaqCliente contpaqCliente = null;
        ClienteDAO clienteDAO = null;
        try {
            clienteDAO = new ClienteDAO();
            contpaqCliente = clienteDAO.consultarCliente("CIDCLIEN01", "" + idCliente);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return cliente;
        }
    }
    
    public boolean crearCliente(Cliente cliente, DireccionCliente direccion) {
        boolean respuesta = false;
        ContpaqCliente contpaqCliente = null;
        ClienteDAO clienteDAO = null;
        try {
            if (consultarCliente(cliente.getIdCliente()) == null) {
                contpaqCliente = new ContpaqCliente();
                contpaqCliente.setCidclien01(BigDecimal.valueOf(cliente.getIdCliente()));
                contpaqCliente.setCcodigoc01(cliente.getCodigoCliente());
                contpaqCliente.setCrazonso01(cliente.getRazonSocial());
                contpaqCliente.setCfechaalta(FechaUtils.getFechaActual());
                contpaqCliente.setCrfc(cliente.getRfc());
                contpaqCliente.setCcurp(cliente.getCurp());
                contpaqCliente.setCdencome01(cliente.getDenominacionComercial());
                contpaqCliente.setCreplegal(cliente.getRepresentanteLegal());
                contpaqCliente.setCidmoneda(BigDecimal.valueOf(1));
                contpaqCliente.setClistapr01(BigDecimal.valueOf(1));
                contpaqCliente.setCdescuen01(Double.valueOf(0));
                contpaqCliente.setCdescuen02(Double.valueOf(0));
                contpaqCliente.setCbanvent01(BigDecimal.valueOf(1));
                contpaqCliente.setCidvalor01(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor02(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor03(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor04(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor05(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor06(BigDecimal.valueOf(0));
                contpaqCliente.setCtipocli01(BigDecimal.valueOf(1));
                contpaqCliente.setCestatus(BigDecimal.valueOf(1));
                contpaqCliente.setCfechabaja(FechaUtils.getFechaActual());
                contpaqCliente.setCfechaul01(FechaUtils.getFechaActual());
                contpaqCliente.setClimitec01(Double.valueOf(cliente.getLimiteDeCredito()));
                contpaqCliente.setCdiascre01(BigDecimal.valueOf(cliente.getDiasDeCredito()));
                contpaqCliente.setCbanexce01(BigDecimal.valueOf(0));
                contpaqCliente.setCdescuen03(Double.valueOf(0));
                contpaqCliente.setCdiaspro01(BigDecimal.valueOf(0));
                contpaqCliente.setCinteres01(Double.valueOf(0));
                contpaqCliente.setCdiapago(BigDecimal.valueOf(31));
                contpaqCliente.setCdiasrev01(BigDecimal.valueOf(31));
                contpaqCliente.setCmensaje01(null);
                contpaqCliente.setCcuentam01(null);
                contpaqCliente.setCdiasemb01(BigDecimal.valueOf(31));
                contpaqCliente.setCidalmacen(BigDecimal.valueOf(0));
                contpaqCliente.setCidagent01(null);
                contpaqCliente.setCidagent02(null);
                contpaqCliente.setCrestric01(null);
                contpaqCliente.setCimpuesto1(Double.valueOf(0));
                contpaqCliente.setCimpuesto2(Double.valueOf(0));
                contpaqCliente.setCimpuesto3(Double.valueOf(0));
                contpaqCliente.setCretenci01(Double.valueOf(0));
                contpaqCliente.setCretenci02(Double.valueOf(0));
                contpaqCliente.setCidvalor07(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor08(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor09(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor10(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor11(BigDecimal.valueOf(0));
                contpaqCliente.setCidvalor12(BigDecimal.valueOf(0));
                contpaqCliente.setClimitec02(Double.valueOf(0));
                contpaqCliente.setCdiascre02(null);
                contpaqCliente.setCtiempoe01(null);
                contpaqCliente.setCdiasemb02(BigDecimal.valueOf(31));
                contpaqCliente.setCimpuest01(Double.valueOf(0));
                contpaqCliente.setCimpuest02(Double.valueOf(0));
                contpaqCliente.setCimpuest03(Double.valueOf(0));
                contpaqCliente.setCretenci03(Double.valueOf(0));
                contpaqCliente.setCretenci04(Double.valueOf(0));
                contpaqCliente.setCbaninte01(null);
                contpaqCliente.setCcomvent01(Double.valueOf(0));
                contpaqCliente.setCcomcobr01(Double.valueOf(0));
                contpaqCliente.setCbanprod01(null);
                contpaqCliente.setCsegcont01(null);
                contpaqCliente.setCsegcont02(null);
                contpaqCliente.setCsegcont03(null);
                contpaqCliente.setCsegcont04(null);
                contpaqCliente.setCsegcont05(null);
                contpaqCliente.setCsegcont06(null);
                contpaqCliente.setCsegcont07(null);
                contpaqCliente.setCsegcont08(null);
                contpaqCliente.setCsegcont09(null);
                contpaqCliente.setCsegcont10(null);
                contpaqCliente.setCsegcont11(null);
                contpaqCliente.setCsegcont12(null);
                contpaqCliente.setCsegcont13(null);
                contpaqCliente.setCsegcont14(null);
                contpaqCliente.setCtextoex01(null);
                contpaqCliente.setCtextoex02(null);
                contpaqCliente.setCtextoex03(null);
                contpaqCliente.setCfechaex01(null);
                contpaqCliente.setCimporte01(Double.valueOf(0));
                contpaqCliente.setCimporte02(Double.valueOf(0));
                contpaqCliente.setCimporte03(Double.valueOf(0));
                contpaqCliente.setCimporte04(Double.valueOf(0));
                contpaqCliente.setCbandomi01(BigDecimal.valueOf(1));
                contpaqCliente.setCbancred01(BigDecimal.valueOf(1));
                contpaqCliente.setCbanenvio(BigDecimal.valueOf(1));
                contpaqCliente.setCbanagente(BigDecimal.valueOf(0));
                contpaqCliente.setCbanimpu01(BigDecimal.valueOf(1));
                contpaqCliente.setCbanprecio(null);
                contpaqCliente.setCtimestamp(null);//;
                contpaqCliente.setCfacterc01(BigDecimal.valueOf(1));
                contpaqCliente.setCcomventa(Double.valueOf(0));
                contpaqCliente.setCcomcobro(Double.valueOf(0));
                contpaqCliente.setCidmoneda2(BigDecimal.valueOf(1));
                contpaqCliente.setCemail1(cliente.getEmail());
                contpaqCliente.setCemail2(null);
                contpaqCliente.setCemail3(null);
                contpaqCliente.setCtipoentre(null);
                contpaqCliente.setCconcteema(null);
                contpaqCliente.setCftoaddend(null);
                contpaqCliente.setCidcertcte(null);
                contpaqCliente.setCencripent(null);
                contpaqCliente.setCbancfd(BigDecimal.valueOf(0));
                contpaqCliente.setCtextoex04(null);
                contpaqCliente.setCtextoex05(null);
                contpaqCliente.setCimporte05(Double.valueOf(0));
                contpaqCliente.setCidaddenda(BigDecimal.valueOf(0));
                contpaqCliente.setCcodprovco(null);
                contpaqCliente.setCenvacuse(null);
                contpaqCliente.setCcon1nom(null);
                contpaqCliente.setCcon1tel(null);
                contpaqCliente.setCquitablan(null);
                contpaqCliente.setCfmtoentre(null);
                contpaqCliente.setCidcomplem(BigDecimal.valueOf(-1));
                contpaqCliente.setCdesglosai(BigDecimal.valueOf(1));
                contpaqCliente.setClimdoctos(null);
                contpaqCliente.setCsitioftp(null);
                contpaqCliente.setCusrftp(null);
                clienteDAO = new ClienteDAO();
                respuesta = clienteDAO.crearCliente(contpaqCliente, getDireccionCliente(direccion,contpaqCliente.getCidclien01()));
                System.out.println("ClienteBO.crearCliente: Se va a insertar el registro del cliente");
            }
        } catch (Exception e) {
            System.out.println("ClienteBO.crearCliente: Ocurrio un error al guardar al cliente");
            e.printStackTrace();
        } finally {
            System.out.println("ClienteBO.crearCliente: Se regresa como respuesta --> " + respuesta);
            return respuesta;
        }
    }
    
    private ContpaqDireccion getDireccionCliente(DireccionCliente dir, BigDecimal idCliente) {
        ContpaqDireccion direccion = new ContpaqDireccion();
        DireccionDAO direccionDAO = new DireccionDAO();
        direccion.setCiddirec01(BigDecimal.valueOf(direccionDAO.getMaxId().intValue() + 1));
        direccion.setCidcatal01(idCliente);
        direccion.setCtipocat01(BigDecimal.valueOf(1));
        direccion.setCtipodir01(BigDecimal.valueOf(0));
        direccion.setCnombrec01(dir.getCalle());
        direccion.setCnumeroe01(dir.getNumeroExterior());
        direccion.setCnumeroi01("");//
        direccion.setCcolonia(dir.getColonia());
        direccion.setCcodigop01(dir.getCodigoPostal());
        direccion.setCtelefono1("");//
        direccion.setCtelefono2("");//
        direccion.setCtelefono3("");//
        direccion.setCtelefono4("");//
        direccion.setCemail("");//
        direccion.setCdirecci01("");//
        direccion.setCpais("MEXICO");
        direccion.setCestado(dir.getEstado());
        direccion.setCciudad(dir.getMunicipio());
        direccion.setCtextoex01("");//
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
        String textDate = df.format(FechaUtils.getFechaActual());
        direccion.setCtimestamp(textDate);
        direccion.setCmunicipio(dir.getMunicipio());
        direccion.setCsucursal("");//
        return direccion;
    }
}
