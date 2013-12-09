/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.ws;

import com.tux.model.ProductoBO;
import com.tux.model.entity.DetalleFactura;
import com.tux.model.entity.Producto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mike
 */
@WebService(serviceName = "ProductoServicioWS")
public class ProductoServicioWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "registrarProducto")
    public boolean registrarProducto(@WebParam(name = "producto") Producto producto) {
        boolean respuesta = false;
        try {
            System.out.println("******************************* Entrando a ProductoServicioWS.consultarCliente ***************************************");
            System.out.println("ProductoServicioWS.consultarCliente --> Se reciben los siguientes parametros:");
            System.out.println("ProductoServicioWS.consultarCliente --> Producto: " + producto);
            if (producto != null) {
                ProductoBO productoBO = new ProductoBO();
                respuesta = productoBO.crearProducto(producto);
            }
        } catch (Exception e) {
            System.out.println("ProductoServicioWS.consultarCliente: Error al registrar el producto");
            e.printStackTrace();
        } finally {
            System.out.println("ProductoServicioWS.consultarCliente: Regresa la siguiente respuesta: " + respuesta);
            return respuesta;
        }
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultarProducto")
    public Producto consultarProducto(@WebParam(name = "producto") long idProducto) {
        Producto producto = null;
        try {
            System.out.println("******************************* Entrando a ProductoServicioWS.consultarProducto ***************************************");
            System.out.println("ProductoServicioWS.consultarProducto --> Se reciben los siguientes parametros:");
            System.out.println("ProductoServicioWS.consultarProducto --> idProducto: " + idProducto);
            if (idProducto > 0) {
                ProductoBO clienteBO = new ProductoBO();
                producto = clienteBO.consultarProducto(idProducto);
            }
        } catch (Exception e) {
            System.out.println("ProductoServicioWS.consultarProducto: Error al consultar el producto");
            e.printStackTrace();
        } finally {
            System.out.println("ProductoServicioWS.consultarProducto: Regresa la siguiente respuesta: " + producto);
            return producto;
        }
    }
}
