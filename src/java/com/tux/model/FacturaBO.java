package com.tux.model;

import com.tux.dto.ContpaqCliente;
import com.tux.dto.ContpaqDetalleFactura;
import com.tux.model.entity.Factura;
import com.tux.dto.ContpaqFactura;
import com.tux.model.dao.ClienteDAO;
import com.tux.model.dao.ContpaqConfigDAO;
import com.tux.model.dao.DetalleFacturaDAO;
import com.tux.model.dao.FacturaDAO;
import com.tux.model.entity.DetalleFactura;
import com.tux.utils.FechaUtils;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mike
 */
public class FacturaBO {

    private Double otrasLineas = Double.valueOf(0);
    private Double retenciones = Double.valueOf(0);

    public List<String> crearFactura(List<String> datosFactura, int tipo, long idCliente, List<DetalleFactura> listaProductos) {//List<String> listaProductos) {
        List<String> respuesta = null;
        ContpaqFactura contpaqFactura = null;
        ContpaqCliente contpaqCliente = null;
        ContpaqDetalleFactura detalle = null;
        List<ContpaqDetalleFactura> detalleFactura = null;
        FacturaDAO facturaDAO = null;
        DetalleFacturaDAO detalleFacturaDAO = null;
        ClienteDAO clienteDAO = null;
        boolean hecho = false;
        boolean actualizado = false;
        //Double retenciones = Double.valueOf(datosFactura.get(14));
        if (datosFactura.size() > 14) {
            retenciones = Double.valueOf(datosFactura.get(14));
        }
        try {
            clienteDAO = new ClienteDAO();
            respuesta = new ArrayList<String>();
            contpaqCliente = clienteDAO.consultarCliente("CIDCLIEN01", "" + idCliente);
            if (contpaqCliente != null) {
                contpaqFactura = new ContpaqFactura();
                contpaqFactura.setCiddocum02(BigDecimal.valueOf(4));
                contpaqFactura.setCidconce01((tipo == 0) ? (BigDecimal.valueOf(5)) : (BigDecimal.valueOf(4)));
                contpaqFactura.setCseriedo01(null);//
                contpaqFactura.setCfecha(FechaUtils.getFechaActual());
                contpaqFactura.setCidclien01(BigDecimal.valueOf(idCliente));
                contpaqFactura.setCrazonso01(contpaqCliente.getCrazonso01());
                contpaqFactura.setCrfc(contpaqCliente.getCrfc());
                contpaqFactura.setCidagente(BigDecimal.valueOf(0));
                contpaqFactura.setCfechave01(FechaUtils.getFechaLimite(contpaqCliente.getCdiascre01()));
                contpaqFactura.setCfechapr01(FechaUtils.getFechaActual());
                contpaqFactura.setCfechaen01(FechaUtils.getFechaActual());
                contpaqFactura.setCfechaul01(FechaUtils.getFechaLimite(contpaqCliente.getCdiascre01()));
                contpaqFactura.setCidmoneda(BigDecimal.valueOf(1));
                contpaqFactura.setCtipocam01(Double.valueOf(1));
                contpaqFactura.setCreferen01(datosFactura.get(0));
                contpaqFactura.setCobserva01(datosFactura.get(1));
                contpaqFactura.setCnatural01(BigDecimal.valueOf(0));
                contpaqFactura.setCiddocum03(BigDecimal.valueOf(0));//
                contpaqFactura.setCplantilla(BigDecimal.valueOf(0));//
                contpaqFactura.setCusaclie01(BigDecimal.valueOf(1));
                contpaqFactura.setCusaprov01(BigDecimal.valueOf(0));
                contpaqFactura.setCafectado(BigDecimal.valueOf(1));
                contpaqFactura.setCimpreso(BigDecimal.valueOf(0));
                contpaqFactura.setCcancelado(BigDecimal.valueOf(0));
                contpaqFactura.setCdevuelto(BigDecimal.valueOf(0));
                contpaqFactura.setCidprepo01(null);//
                contpaqFactura.setCidprepo02(null);//
                contpaqFactura.setCestadoc01(BigDecimal.valueOf(1));
                contpaqFactura.setCneto(calcularImporteNeto(listaProductos));
                contpaqFactura.setCimpuesto1(calcularImpuestos(listaProductos));
                contpaqFactura.setCimpuesto2(Double.valueOf(0));
                contpaqFactura.setCimpuesto3(Double.valueOf(0));
                contpaqFactura.setCretenci01(Double.valueOf(0));//(retenciones));
                contpaqFactura.setCretenci02(Double.valueOf(retenciones));
                contpaqFactura.setCdescuen01(Double.valueOf(0));
                contpaqFactura.setCdescuen02(Double.valueOf(0));
                contpaqFactura.setCdescuen03(Double.valueOf(0));
                contpaqFactura.setCgasto1(Double.valueOf(0));
                contpaqFactura.setCgasto2(Double.valueOf(0));
                contpaqFactura.setCgasto3(Double.valueOf(0));
                contpaqFactura.setCtotal(((contpaqFactura.getCneto() + contpaqFactura.getCimpuesto1()) - retenciones));
                contpaqFactura.setCpendiente(contpaqFactura.getCtotal());//(tipo == 0) ? Double.valueOf(0) : contpaqFactura.getCtotal());
                contpaqFactura.setCtotalun01(contarProductos(listaProductos));
                contpaqFactura.setCdescuen04(Double.valueOf(0));
                contpaqFactura.setCporcent01(Double.valueOf(0));
                contpaqFactura.setCporcent02(Double.valueOf(0));
                contpaqFactura.setCporcent03(Double.valueOf(0));
                contpaqFactura.setCporcent04(Double.valueOf(0.04));
                contpaqFactura.setCporcent05(Double.valueOf(0));
                contpaqFactura.setCporcent06(Double.valueOf(0));
                contpaqFactura.setCtextoex01(null);//
                contpaqFactura.setCtextoex02(null);//
                contpaqFactura.setCtextoex03(null);//
                contpaqFactura.setCfechaex01((tipo == 0) ? FechaUtils.getFechaActual() : null);//fecha pago contado
                contpaqFactura.setCimporte01(Double.valueOf(0));
                contpaqFactura.setCimporte02(Double.valueOf(0));
                contpaqFactura.setCimporte03(Double.valueOf(0));
                contpaqFactura.setCimporte04(Double.valueOf(0));
                contpaqFactura.setCdestina01(datosFactura.get(2));
                contpaqFactura.setCnumerog01(datosFactura.get(3));
                contpaqFactura.setCmensaje01(datosFactura.get(4));
                contpaqFactura.setCcuentam01(datosFactura.get(7));
                contpaqFactura.setCnumeroc01(Double.valueOf(datosFactura.get(5)));
                contpaqFactura.setCpeso(Double.valueOf(datosFactura.get(8)));
                contpaqFactura.setCbanobse01((tipo == 0) ? (BigDecimal.valueOf(1)) : (BigDecimal.valueOf(0)));//
                contpaqFactura.setCbandato01((tipo == 0) ? (BigDecimal.valueOf(1)) : (BigDecimal.valueOf(0)));//
                contpaqFactura.setCbancond01((tipo == 0) ? (BigDecimal.valueOf(1)) : (BigDecimal.valueOf(0)));//
                contpaqFactura.setCbangastos(BigDecimal.valueOf(0));//
                contpaqFactura.setCunidade01(contpaqFactura.getCtotalun01());
                contpaqFactura.setCtimestamp(null);//
                contpaqFactura.setCimpcheq01(contpaqFactura.getCtotal());
                contpaqFactura.setCsistorig(BigDecimal.valueOf(0));//
                contpaqFactura.setCidmonedca(BigDecimal.valueOf(0));//
                contpaqFactura.setCtipocamca(Double.valueOf(0));
                contpaqFactura.setCescfd((tipo == 0) ? (BigDecimal.valueOf(1)) : (BigDecimal.valueOf(0)));
                contpaqFactura.setCtienecfd(BigDecimal.valueOf(0));//
                facturaDAO = new FacturaDAO();
                contpaqFactura.setCfolio(facturaDAO.getSiguienteFactura(tipo));
                contpaqFactura.setCiddocum01(facturaDAO.getMaxId());
                System.out.println("FacturaBO.crearFactura: Se va a guardar el registro de la factura ... ");
                if (facturaDAO.crearFactura(contpaqFactura)) {
                    detalleFactura = getDetalleFactura(contpaqFactura.getCiddocum01(), idCliente, listaProductos);
                    int y = 0;
                    detalleFacturaDAO = new DetalleFacturaDAO();
                    while (y < detalleFactura.size()) {
                        System.out.println("FacturaBO.crearFactura: Se va a guardar el producto " + (y + 1));
                        detalle = detalleFactura.get(y);
                        hecho = detalleFacturaDAO.crearDetalleFactura(detalle);
                        if (hecho) {
                            y++;
                        } else {
                            y = detalleFactura.size();
                        }
                    }
                    if (hecho) {
                        ContpaqConfigDAO contpaq = new ContpaqConfigDAO();
                        actualizado = contpaq.actualizarConfiguracion(tipo, "CNOFOLIO", "" + contpaqFactura.getCfolio(), ((tipo == 0) ? (5) : (4))); //tipo: 0 = contado ; 1 = credito ---- 4 = Factura Credito; 5 = Factura Contado
                        if (actualizado) {
                            if (tipo == 1) {
                                //boolean cfdi = false;
                                //FolioDigitalBO folioBO = new FolioDigitalBO();
                                //cfdi = folioBO.registrarFolioDigital(contpaqFactura);
                                //if (cfdi) {
                                respuesta.add("100");
                                respuesta.add("" + contpaqFactura.getCfolio());
                                respuesta.add("La factura se ha creado correctamente.");
                                //} else {
                                //    respuesta.add("107");
                                //    respuesta.add("" + contpaqFactura.getCfolio());
                                //    respuesta.add("La factura se ha creado correctamente. Pero no pudo registrarse el folio digital");
                                //}
                            } else {
                                List<String> resp;
                                boolean cfdi = false;
                                PagoFacturaBO pagoFacturaBO = new PagoFacturaBO();
                                resp = pagoFacturaBO.registrarPagoFactura(contpaqFactura.getCfolio().longValue(), contpaqFactura.getCtotal());
                                if (resp != null && resp.get(0).equals("601")) {
                                    FolioDigitalBO folioBO = new FolioDigitalBO();
                                    cfdi = folioBO.registrarFolioDigital(contpaqFactura);
                                    if (cfdi) {
                                        respuesta.add("100");
                                        respuesta.add("" + contpaqFactura.getCfolio());
                                        respuesta.add("La factura se ha creado correctamente.");
                                    } else {
                                        respuesta.add("107");
                                        respuesta.add("" + contpaqFactura.getCfolio());
                                        respuesta.add("La factura se ha creado correctamente. Pero no pudo registrarse el folio digital");
                                    }
                                } else {
                                    respuesta.add("102");
                                    respuesta.add("" + contpaqFactura.getCfolio());
                                    respuesta.add("La factura se ha creado correctamente. Pero no pudo registrarse el pago de contado");
                                }
                            }
                        }
                    } else {
                        respuesta.add("104");
                        respuesta.add("Ocurrio un error al guardar los detalles de la factura.");
                    }
                } else {
                    respuesta.add("103");
                    respuesta.add("Ocurrio una error al guardar la factura.");
                }
            } else {
                respuesta.add("108");
                respuesta.add("El cliente porporcionado no esta registrado en Contpaq-i");
            }
        } catch (Exception e) {
            System.out.println("FacturaBO.crearFactura: Regresa la siguiente respuesta: " + respuesta);
            respuesta.add("106");
            respuesta.add("Error fatal: La factura no pudo guardarse.");
            e.printStackTrace();
        } finally {
            return respuesta;
        }
    }

    public List<ContpaqDetalleFactura> getDetalleFactura(BigDecimal factura, long idCliente, List<DetalleFactura> listaProductos) {
        List<ContpaqDetalleFactura> lista = new ArrayList<ContpaqDetalleFactura>();
        ContpaqDetalleFactura detalle;
        DetalleFactura producto;
        DetalleFacturaDAO detalleFacturaDAO;
        int x = 0;
        detalleFacturaDAO = new DetalleFacturaDAO();
        //int lastId = detalleFacturaDAO.getMaxId().intValue();
        Double retencion = Double.valueOf(0);
        while (x < listaProductos.size()) {
            producto = listaProductos.get(x);
            if (producto.getIdProducto() == 7) {
                //producto.setPrecio(producto.getPrecio() * (-1));
                retencion = retenciones;
            }
            detalle = new ContpaqDetalleFactura();
            detalle.setCidmovim01(BigDecimal.valueOf(detalleFacturaDAO.getMaxId().intValue()));//id
            detalle.setCiddocum01(factura);//id de factura
            detalle.setCnumerom01(Double.valueOf(100 * (x + 1)));
            detalle.setCiddocum02(BigDecimal.valueOf(4));
            detalle.setCidprodu01(BigDecimal.valueOf(producto.getIdProducto()));
            detalle.setCidalmacen(BigDecimal.valueOf(1));
            detalle.setCunidades(Double.valueOf(producto.getCantidad()));
            detalle.setCunidade01(Double.valueOf(0));
            detalle.setCunidade02(Double.valueOf(producto.getCantidad()));
            detalle.setCidunidad(BigDecimal.valueOf(0));
            detalle.setCidunida01(BigDecimal.valueOf(0));
            detalle.setCprecio(Double.valueOf(producto.getPrecio()));
            detalle.setCprecioc01(Double.valueOf(producto.getPrecio()));
            detalle.setCcostoca01(Double.valueOf(0));
            detalle.setCcostoes01(Double.valueOf(0));
            detalle.setCneto(producto.getCantidad() * producto.getPrecio());
            detalle.setCimpuesto1(detalle.getCneto() * producto.getIva());
            detalle.setCporcent01(producto.getIva());
            detalle.setCimpuesto2(Double.valueOf(0));
            detalle.setCporcent02(Double.valueOf(0));
            detalle.setCimpuesto3(Double.valueOf(0));
            detalle.setCporcent03(Double.valueOf(0));
            detalle.setCretenci01(Double.valueOf(0));
            detalle.setCporcent04(Double.valueOf(0));
            detalle.setCretenci02(Double.valueOf(retencion));///retencion
            detalle.setCporcent05(Double.valueOf(0));
            detalle.setCdescuen01(Double.valueOf(0));
            detalle.setCporcent06(Double.valueOf(0));
            detalle.setCdescuen02(Double.valueOf(0));
            detalle.setCporcent07(Double.valueOf(0));
            detalle.setCdescuen03(Double.valueOf(0));
            detalle.setCporcent08(Double.valueOf(0));
            detalle.setCdescuen04(Double.valueOf(0));
            detalle.setCporcent09(Double.valueOf(0));
            detalle.setCdescuen05(Double.valueOf(0));
            detalle.setCporcent10(Double.valueOf(0));
            detalle.setCtotal((detalle.getCneto() + detalle.getCimpuesto1()) - retencion);
            detalle.setCporcent11(Double.valueOf(0));
            detalle.setCreferen01(null);
            detalle.setCobserva01(null);
            detalle.setCafectae01(BigDecimal.valueOf(2));
            detalle.setCafectad01(BigDecimal.valueOf(1));
            detalle.setCafectad02(BigDecimal.valueOf(1));
            detalle.setCfecha(FechaUtils.getFechaActual());
            detalle.setCmovtooc01(BigDecimal.valueOf(0));
            detalle.setCidmovto01(null);
            detalle.setCidmovto02(null);
            detalle.setCunidade03(detalle.getCunidades());
            detalle.setCunidade04(Double.valueOf(0));
            detalle.setCunidade05(Double.valueOf(0));
            detalle.setCunidade06(Double.valueOf(0));
            detalle.setCtipotra01(BigDecimal.valueOf(1));
            detalle.setCidvalor01(BigDecimal.valueOf(0));
            detalle.setCtextoex01(null);
            detalle.setCtextoex02(null);
            detalle.setCtextoex03(null);
            detalle.setCfechaex01(null);
            detalle.setCimporte01(Double.valueOf(0));
            detalle.setCimporte02(Double.valueOf(0));
            detalle.setCimporte03(Double.valueOf(0));
            detalle.setCimporte04(Double.valueOf(0));
            detalle.setCtimestamp(null);
            detalle.setCgtomovto(Double.valueOf(0));
            detalle.setCscmovto(null);
            detalle.setCcomventa(Double.valueOf(0));
            detalle.setCidmovdest(null);
            detalle.setCnumconsol(null);
            lista.add(detalle);
            x++;
        }
        return lista;
    }

    public List<String> cancelarFactura(long factura) {
        List<String> respuesta = null;
        ContpaqFactura contFactura = null;
        FacturaDAO facturaDAO = null;
        try {
            //contFactura. = factura.
            facturaDAO = new FacturaDAO();
            facturaDAO.cancelarFactura();
        } catch (Exception e) {
            System.out.println("FacturaBO.cancelarFactura: Regresa la siguiente respuesta: " + respuesta);
            e.printStackTrace();
        } finally {
            return respuesta;
        }
    }

    public Factura consultarFactura(long factura) {
        Factura facturaContpaq = null;
        FacturaDAO facturaDAO = null;
        try {
            //contFactura. = factura.
            facturaDAO = new FacturaDAO();
            facturaDAO.consultarFactura("", "");
        } catch (Exception e) {
            System.out.println("FacturaBO.consultarFactura: Regresa la siguiente respuesta: " + facturaContpaq);
            e.printStackTrace();
        } finally {
            return facturaContpaq;
        }
    }

    private Double calcularImporteNeto(List<DetalleFactura> listaProductos) {
        double neto = 0;
        int x = 0;
        otrasLineas = Double.valueOf(0);
        while (x < listaProductos.size()) {
            //if (listaProductos.get(x).getIdProducto() != 2) {
            neto += (listaProductos.get(x)).getCantidad() * ((listaProductos.get(x).getIdProducto() != 8) ? ((listaProductos.get(x)).getPrecio()) : ((listaProductos.get(x)).getPrecio() * (-1)));
            //} else {
            //  otrasLineas += (listaProductos.get(x)).getCantidad() * (listaProductos.get(x)).getPrecio();
            //}
            x++;
        }
        System.out.println("************************************************************ Neto: " + neto);
        return Double.valueOf(neto);
    }

    private Double calcularImpuestos(List<DetalleFactura> listaProductos) {
        double impuestos = 0;
        int x = 0;
        while (x < listaProductos.size()) {
            if (listaProductos.get(x).getIdProducto() != 2) {
                System.out.println("cantidad :" + listaProductos.get(x).getCantidad() + ", precio: " + listaProductos.get(x).getPrecio() + ", iva: " + (listaProductos.get(x)).getIva());
                impuestos += (((listaProductos.get(x)).getCantidad() * (listaProductos.get(x)).getPrecio())) * (listaProductos.get(x)).getIva();
            }
            x++;
        }
        System.out.println("*********************************************************** Impuestos: " + impuestos);
        return Double.valueOf(impuestos);
    }

    private Double contarProductos(List<DetalleFactura> listaProductos) {
        double impuestos = 0;
        int x = 0;
        while (x < listaProductos.size()) {
            impuestos += (listaProductos.get(x)).getCantidad();
            x++;
        }
        return Double.valueOf(impuestos);
    }
}
