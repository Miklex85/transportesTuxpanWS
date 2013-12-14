/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.ws.cliente;

import com.tux.model.ClienteBO;
import com.tux.model.entity.Cliente;
import com.tux.model.entity.DireccionCliente;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mike
 */
@WebService(serviceName = "ClienteWS")
public class ClienteWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "registrarCliente")
    public boolean registrarCliente(@WebParam(name = "cliente") Cliente cliente, DireccionCliente direccion) {
        boolean respuesta = false;
        try {
            System.out.println("******************************* Entrando a ClienteWS.consultarCliente ***************************************");
            System.out.println("ClienteWS.consultarCliente --> Se reciben los siguientes parametros:");
            System.out.println("ClienteWS.consultarCliente --> idCliente: " + cliente);
             System.out.println("ClienteWS.consultarCliente --> idCliente: " + direccion);
            if (cliente != null) {
                ClienteBO clienteBO = new ClienteBO();
                respuesta = clienteBO.crearCliente(cliente, direccion);
            }
        } catch (Exception e) {
            System.out.println("ClienteWS.consultarCliente: Error al consultar el cliente");
            e.printStackTrace();
        } finally {
            System.out.println("ClienteWS.consultarCliente: Regresa la siguiente respuesta: " + respuesta);
            return respuesta;
        }
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultarCliente")
    public Cliente consultarCliente(@WebParam(name = "idCliente") long idCliente) {
        Cliente cliente = null;
        try {
            System.out.println("******************************* Entrando a ClienteWS.consultarCliente ***************************************");
            System.out.println("ClienteWS.consultarCliente --> Se reciben los siguientes parametros:");
            System.out.println("ClienteWS.consultarCliente --> idCliente: " + idCliente);
            if (idCliente > 0) {
                ClienteBO clienteBO = new ClienteBO();
                cliente = clienteBO.consultarCliente(idCliente);
            }
        } catch (Exception e) {
            System.out.println("ClienteWS.consultarCliente: Error al consultar el cliente");
            e.printStackTrace();
        } finally {
            System.out.println("ClienteWS.consultarCliente: Regresa la siguiente respuesta: " + cliente);
            return cliente;
        }
    }
}
