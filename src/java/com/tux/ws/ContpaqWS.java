package com.tux.ws;

import com.tux.model.ClienteBO;
import com.tux.model.PagoFacturaBO;
import com.tux.model.ProductoBO;
import com.tux.model.dao.ClienteDAO;
import com.tux.model.dao.ContpaqConfigDAO;
import com.tux.model.dao.DetalleFacturaDAO;
import com.tux.model.dao.DireccionDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.tux.model.dao.FacturaDAO;
import com.tux.model.dao.FolioDigitalDAO;
import com.tux.model.dao.ProductoDAO;
import com.tux.model.entity.Cliente;
import com.tux.model.entity.DireccionCliente;
import com.tux.model.entity.Producto;
import com.tux.utils.ContpaqTableMapper;
import com.tux.utils.AutoConfig;

/**
 *
 * @author miklex
 */
@WebService(serviceName = "ContpaqWS")
public class ContpaqWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String name) {
        AutoConfig config = new AutoConfig();
        FacturaDAO factura = new FacturaDAO();
        ProductoDAO producto = new ProductoDAO();
        ClienteDAO cliente = new ClienteDAO();
        ClienteBO  cliBO = new ClienteBO();
        //ContpaqConfigDAO config = new ContpaqConfigDAO();
        DireccionDAO direccion = new DireccionDAO();
        DetalleFacturaDAO detalle = new DetalleFacturaDAO();
        Cliente cli = new Cliente();
        Producto prod = new Producto();
        ProductoBO pr = new ProductoBO();
        PagoFacturaBO pagoBO = new PagoFacturaBO();
        DireccionCliente dir = new DireccionCliente();
        FolioDigitalDAO folio = new FolioDigitalDAO();
        try {
            //config.consultarConfiguracion("CIDDOCUM01", "4", 0);
            //factura.consultarFactura("CFOLIO", "4");
            //folio.consultarFolioDigital("CIDFOLDIG", "1");
            //producto.consultarProducto("CIDPRODU01", "3");
            //cli.setIdCliente(9);
            //cli.setCodigoCliente("9");
            //cli.setRfc("PRUE000000BAS");
            //cli.setCurp("");
            //cli.setDenominacionComercial("DENOMINACION");
            //cli.setDiasDeCredito(20);
            //cli.setEmail("mail@mail.com");
            //cli.setLimiteDeCredito(1245);
            //cli.setRazonSocial("MI RAZON SOCIAL");
            //cli.setRepresentanteLegal("REPRESENTANTE LEGAL");
            //dir.setCalle("LA CALLE");
            //dir.setCodigoPostal("52100");
            //dir.setColonia("LA COLONIA");
            //dir.setEstado("EL ESTADO");
            //dir.setMunicipio("EL MUNICIPIO");
            //dir.setNumeroExterior("NUMEXT");
            //cliBO.crearCliente(cli,dir);
            cliente.consultarCliente("CIDCLIEN01", "1");
            //direccion.consultarDireccion("CIDDIREC01", "5");
            //detalle.consultarDetalleFactura("CIDDOCUM01", "14");
            /*prod.setIdProducto(7);
            prod.setCoodigoProducto("7");
            prod.setNombreProducto("Servicio X");
            prod.setDescripcionDetallada("Descripcion detallada");
            prod.setPrecio(45.99);
            prod.setTipo(3);
            prod.setCodigoAlterno("Codigo Alterno");
            prod.setDescripcionCorta("Descripcion Corta");
            prod.setNombreAlterno("Nombre alterno del producto");*/
            //pr.crearProducto(prod);
           // System.out.println("Respuesta a enviar: " + pagoBO.registrarPagoFactura(3, 550.00));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Hello " + name + " !";
    }
}
