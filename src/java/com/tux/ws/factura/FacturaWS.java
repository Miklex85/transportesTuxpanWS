/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.ws.factura;

import com.tux.model.FacturaBO;
import com.tux.model.entity.Cliente;
import com.tux.model.entity.Factura;
import com.tux.model.entity.DetalleFactura;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mike
 */
@WebService(serviceName = "FacturaWS")
public class FacturaWS {

    /**
     * @param datosFactura Se refiere a los datos quer permitiran dar
     * seguimiento a la factura, y deberán seguir la siguiente
     * estructura:<br/><br/>
     * datosFactura[0]=Referencia<br/>
     * datosFactura[1]=Observaciones<br/>
     * datosFactura[2]=Nombre del destinatario<br/>
     * datosFactura[3]=Número de guía<br/>
     * datosFactura[4]=Mensajeria o Transportista<br/>
     * datosFactura[5]=Número de cajas<br/>
     * datosFactura[6]=Fecha de entrega/envio<br/>
     * datosFactura[7]=Número de cuenta de la mensajeria<br/>
     * datosFactura[8]=Peso<br/>
     * datosFactura[9]=Lugar de Expedicion<br/>
     * datosFactura[10]=Metodo de Pago (Efectivo, Tarjeta de Crédito,Debito,
     * Cheque,etc..)<br/>
     * datosFactura[11]=Cantidad de Parcialidades<br/>
     * datosFactura[12]=Condciones de pago<br/>
     * datosFactura[13]=Numero de cuenta de pago<br/>
     * Si alguno de los datos no se tiene, enviar una cadena vacia o un guion
     * medio (-)<br/>
     * @param tipo Se refiere al tipo de factura a enviar: 0=Contado ;
     * 1=Crédito<br/>
     * @param idCliente Se refiere al id de cliente que se tiene registrado en
     * la tabla MGW10005 de la BD de Contpaq-i<br/>
     * @param listaProductos Se refiere a la lista de productos que componen la
     * factura:<br/><br/>
     * listaProductos[0]=id del producto<br/>
     * listaProductos[1]=codigo del producto<br/>
     * listaProductos[2]=tipo<br/>
     * listaProductos[3]=cantidad<br/>
     * listaProductos[4]=precio<br/>
     * listaProductos[5]=iva<br/>
     * listaProductos[6]=retencion<br/>
     * listaProductos[7]=descuento<br/>
     * listaProductos[8]=gasto<br/><br/>
     * @return regresa una lista con la siguiente estructura<br/>
     * respuesta[0]=Codigo de mensaje/Error<br/>
     * respuesta[1]=Folio de la Factura / Mensaje de Error
     */
    @WebMethod(operationName = "crearFactura")
    public List<String> crearFactura(@WebParam(name = "datosFactura") List<String> datosFactura, int tipo, long idCliente, List<DetalleFactura> listaProductos) {
        List<String> respuesta = new ArrayList<String>();
        try {
            System.out.println("******************************* Entrando a FacturaWS.crearFactura ***************************************");
            System.out.println("FacturaWS.crearFactura --> Se reciben los siguientes parametros:");
            System.out.println("FacturaWS.crearFactura --> datosFactura: " + datosFactura);
            System.out.println("FacturaWS.crearFactura --> tipo: " + tipo);
            System.out.println("FacturaWS.crearFactura --> idCliente: " + idCliente);
            System.out.println("FacturaWS.crearFactura --> Producto: " + listaProductos);
            if (datosFactura != null && (tipo == 0 || tipo == 1) && idCliente > 0 && listaProductos != null && listaProductos.size() > 0) {
                FacturaBO facturaBO = new FacturaBO();
                respuesta = facturaBO.crearFactura(datosFactura, tipo, idCliente, listaProductos);
            } else {
                respuesta.add("501");
                respuesta.add("Los datos enviados no son correctos. Verifiquelos e intente nuevamente");
            }
        } catch (Exception e) {
            respuesta.add("502");
            respuesta.add("Ocurrio un error al generar al envíar los datos de la factura");
            System.out.println("FacturaWS.crearFactura: Error al crear la factura");
            e.printStackTrace();
        } finally {
            System.out.println("FacturaWS.crearFactura: Regresa la siguiente respuesta: " + respuesta);
            System.out.println("******************************* Saliendo de FacturaWS.crearFactura ***************************************");
            return respuesta;
        }
    }

    @WebMethod(operationName = "cancelarFactura")
    public List<String> cancelarFactura(@WebParam(name = "factura") long factura) {
        List<String> respuesta = null;
        try {
            System.out.println("******************************* Entrando a FacturaWS.cancelarFactura ***************************************");
            System.out.println("FacturaWS.cancelarFactura --> Se reciben los siguientes parametros:");
            System.out.println("FacturaWS.cancelarFactura --> Factura: " + factura);
            if (factura > 0) {
                FacturaBO facturaBO = new FacturaBO();
                respuesta = facturaBO.cancelarFactura(factura);
            } else {
                respuesta.add("501");
                respuesta.add("Los datos enviados no son correctos. Verifiquelos e intente nuevamente");
            }
        } catch (Exception e) {
            respuesta.add("503");
            respuesta.add("Ocurrio un error al cancelar la factura " + factura);
            System.out.println("FacturaWS.cancelarFactura: Error al cancelar la factura");
            e.printStackTrace();
        } finally {
            System.out.println("FacturaWS.cancelarFactura: Regresa la siguiente respuesta: " + respuesta);
            return respuesta;
        }
    }

    @WebMethod(operationName = "consultarFactura")
    public Factura consultarFactura(@WebParam(name = "factura") long factura) {
        Factura facturaContpaq = null;
        try {
            System.out.println("******************************* Entrando a FacturaWS.consultarFactura ***************************************");
            System.out.println("FacturaWS.consultarFactura --> Se reciben los siguientes parametros:");
            System.out.println("FacturaWS.consultarFactura --> Factura: " + factura);
            if (factura > 0) {
                FacturaBO facturaBO = new FacturaBO();
                facturaContpaq = facturaBO.consultarFactura(factura);
            }
        } catch (Exception e) {
            System.out.println("FacturaWS.consultarFactura: Error al crear la factura");
            e.printStackTrace();
        } finally {
            System.out.println("FacturaWS.consultarFactura: Regresa la siguiente respuesta: " + facturaContpaq);
            return facturaContpaq;
        }
    }
}
