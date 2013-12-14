/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.ws.pago;

import com.tux.model.PagoFacturaBO;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mike
 */
@WebService(serviceName = "PagoFacturaWS")
public class PagoFacturaWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public List<String> registrarPago(@WebParam(name = "numeroFactura") long numeroFactura, @WebParam(name = "importePagado") double importePagado) {
        List<String> respuesta = new ArrayList<String>();
        try {
            System.out.println("******************************* Entrando a PagoFacturaWS.registrarPago ***************************************");
            System.out.println("PagoFacturaWS.registrarPago --> Se reciben los siguientes parametros:");
            System.out.println("PagoFacturaWS.registrarPago --> numeroFactura: " + numeroFactura);
            System.out.println("PagoFacturaWS.registrarPago --> importePagado: " + importePagado);
            if (numeroFactura > 0 && importePagado > 0) {
                PagoFacturaBO pagoFacturaBO = new PagoFacturaBO();
                respuesta = pagoFacturaBO.registrarPagoFactura(numeroFactura, importePagado);
            }
        } catch (Exception e) {
            System.out.println("PagoFacturaWS.registrarPago: Error al registrar el pago de la factura");
            e.printStackTrace();
        } finally {
            System.out.println("PagoFacturaWS.registrarPago: Regresa la siguiente respuesta: " + respuesta);
            return respuesta;
        }
    }
}
