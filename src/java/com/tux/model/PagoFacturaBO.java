package com.tux.model;

import com.tux.dto.ContpaqCliente;
import com.tux.dto.ContpaqDetalleFactura;
import com.tux.dto.ContpaqFactura;
import com.tux.dto.ContpaqPagoFactura;
import com.tux.model.dao.ClienteDAO;
import com.tux.model.dao.ContpaqConfigDAO;
import com.tux.model.dao.DetalleFacturaDAO;
import com.tux.model.dao.FacturaDAO;
import com.tux.model.dao.PagoFacturaDAO;
import com.tux.model.entity.DetalleFactura;
import com.tux.model.entity.Factura;
import com.tux.utils.FechaUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mike
 */
public class PagoFacturaBO {

    public List<String> registrarPagoFactura(long numeroFactura, double importePago) {
        List<String> respuesta = new ArrayList<String>();
        ContpaqFactura contpaqFactura;
        ContpaqDetalleFactura detalle;
        ContpaqPagoFactura pago;
        FacturaDAO facturaDAO;
        PagoFacturaDAO pagoFacturaDAO;
        boolean hecho = false;
        ContpaqFactura factura;
        double restante = 0;
        try {
            facturaDAO = new FacturaDAO();
            factura = facturaDAO.consultarFactura("CFOLIO", "" + numeroFactura);
            restante = (factura.getCpendiente() - Double.valueOf(importePago));
            if (restante >= 0) {
                contpaqFactura = new ContpaqFactura();
                contpaqFactura.setCiddocum02(BigDecimal.valueOf(9));
                contpaqFactura.setCidconce01(BigDecimal.valueOf(10));
                contpaqFactura.setCseriedo01(null);//
                contpaqFactura.setCfecha(FechaUtils.getFechaActual());
                contpaqFactura.setCidclien01(factura.getCidclien01());
                contpaqFactura.setCrazonso01(factura.getCrazonso01());
                contpaqFactura.setCrfc(factura.getCrfc());
                contpaqFactura.setCidagente(BigDecimal.valueOf(0));
                contpaqFactura.setCfechave01(FechaUtils.getFechaActual());
                contpaqFactura.setCfechapr01(FechaUtils.getFechaActual());
                contpaqFactura.setCfechaen01(FechaUtils.getFechaActual());//
                contpaqFactura.setCfechaul01(FechaUtils.getFechaActual());
                contpaqFactura.setCidmoneda(BigDecimal.valueOf(1));
                contpaqFactura.setCtipocam01(Double.valueOf(1));
                contpaqFactura.setCreferen01("");//
                contpaqFactura.setCobserva01("");//
                contpaqFactura.setCnatural01(BigDecimal.valueOf(1));
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
                contpaqFactura.setCneto(Double.valueOf(importePago));
                contpaqFactura.setCimpuesto1(Double.valueOf(0));
                contpaqFactura.setCimpuesto2(Double.valueOf(0));
                contpaqFactura.setCimpuesto3(Double.valueOf(0));
                contpaqFactura.setCretenci01(Double.valueOf(0));
                contpaqFactura.setCretenci02(Double.valueOf(0));
                contpaqFactura.setCdescuen01(Double.valueOf(0));
                contpaqFactura.setCdescuen02(Double.valueOf(0));
                contpaqFactura.setCdescuen03(Double.valueOf(0));
                contpaqFactura.setCgasto1(Double.valueOf(0));
                contpaqFactura.setCgasto2(Double.valueOf(0));
                contpaqFactura.setCgasto3(Double.valueOf(0));
                contpaqFactura.setCtotal(Double.valueOf(importePago));
                contpaqFactura.setCpendiente(Double.valueOf(0));
                contpaqFactura.setCtotalun01(Double.valueOf(0));
                contpaqFactura.setCdescuen04(Double.valueOf(0));
                contpaqFactura.setCporcent01(Double.valueOf(0));
                contpaqFactura.setCporcent02(Double.valueOf(0));
                contpaqFactura.setCporcent03(Double.valueOf(0));
                contpaqFactura.setCporcent04(Double.valueOf(0));
                contpaqFactura.setCporcent05(Double.valueOf(0));
                contpaqFactura.setCporcent06(Double.valueOf(0));
                contpaqFactura.setCtextoex01(null);//
                contpaqFactura.setCtextoex02(null);//
                contpaqFactura.setCtextoex03(null);//
                contpaqFactura.setCfechaex01(FechaUtils.getFechaActual());//fecha pago contado
                contpaqFactura.setCimporte01(Double.valueOf(0));
                contpaqFactura.setCimporte02(Double.valueOf(0));
                contpaqFactura.setCimporte03(Double.valueOf(0));
                contpaqFactura.setCimporte04(Double.valueOf(0));
                contpaqFactura.setCdestina01("");
                contpaqFactura.setCnumerog01("");
                contpaqFactura.setCmensaje01("");
                contpaqFactura.setCcuentam01("");
                contpaqFactura.setCnumeroc01(Double.valueOf(0));
                contpaqFactura.setCpeso(Double.valueOf(0));
                contpaqFactura.setCbanobse01(BigDecimal.valueOf(1));//
                contpaqFactura.setCbandato01(BigDecimal.valueOf(0));//
                contpaqFactura.setCbancond01(BigDecimal.valueOf(0));//
                contpaqFactura.setCbangastos(BigDecimal.valueOf(0));//
                contpaqFactura.setCunidade01(Double.valueOf(0));
                contpaqFactura.setCtimestamp(null);//
                contpaqFactura.setCimpcheq01(Double.valueOf(0));
                contpaqFactura.setCsistorig(BigDecimal.valueOf(0));//
                contpaqFactura.setCidmonedca(BigDecimal.valueOf(0));//
                contpaqFactura.setCtipocamca(Double.valueOf(0));
                contpaqFactura.setCescfd(BigDecimal.valueOf(0));
                contpaqFactura.setCtienecfd(BigDecimal.valueOf(0));//
                contpaqFactura.setCfolio((facturaDAO.getSiguientePago() != null) ? (facturaDAO.getSiguientePago() + 1) : (Double.valueOf(1)));
                contpaqFactura.setCiddocum01((facturaDAO.getMaxId() != null) ? (BigDecimal.valueOf(facturaDAO.getMaxId().intValue() + 1)) : (BigDecimal.valueOf(1)));
                detalle = getDetalleFactura(contpaqFactura.getCiddocum01(), importePago);
                pago = getPagoFactura(contpaqFactura.getCiddocum01(), factura.getCiddocum01(), importePago);
                pagoFacturaDAO = new PagoFacturaDAO();
                hecho = pagoFacturaDAO.crearPagoFactura(restante, contpaqFactura, detalle, pago);
                if (hecho) {
                    respuesta.add("601");
                    respuesta.add("El pago se registro correctamente.");
                    respuesta.add("El saldo es de : $" + restante);
                } else {
                    respuesta.add("602");
                    respuesta.add("Ocurrio un error al registrar el pago. Favor de reportarlo");
                }
            } else if (importePago > factura.getCpendiente()) {
                respuesta.add("603");
                respuesta.add("El importe proporcionado es mayor que el de la deuda. Verifique por favor");
                respuesta.add("El saldo es de : $" + factura.getCpendiente());
            } else {
                respuesta.add("604");
                respuesta.add("El cliente ya no tiene saldo pendiente sobre la factura indicada");
            }
        } catch (Exception e) {
            System.out.println("PagoFacturaBO.registrarPagoFactura:  Ocurrio un error al registrar el pago de la factura ");
            respuesta.add("605");
            respuesta.add("Error fatal: La factura no pudo guardarse.");
            e.printStackTrace();
        } finally {
            System.out.println("PagoFacturaBO.registrarPagoFactura: Regresa la siguiente respuesta: " + respuesta);
            return respuesta;
        }
    }

    private ContpaqDetalleFactura getDetalleFactura(BigDecimal factura, double importePago) {
        ContpaqDetalleFactura detalle;
        DetalleFacturaDAO detalleFacturaDAO;
        detalle = new ContpaqDetalleFactura();
        detalleFacturaDAO = new DetalleFacturaDAO();
        int lastId = ((detalleFacturaDAO.getMaxId() != null) ? (detalleFacturaDAO.getMaxId().intValue()) : (1));
        detalle.setCidmovim01(BigDecimal.valueOf(lastId));//id
        detalle.setCiddocum01(factura);//id de factura
        detalle.setCnumerom01(Double.valueOf(1));
        detalle.setCiddocum02(BigDecimal.valueOf(9));
        detalle.setCidprodu01(BigDecimal.valueOf(0));
        detalle.setCidalmacen(BigDecimal.valueOf(0));
        detalle.setCunidades(Double.valueOf(0));
        detalle.setCunidade01(Double.valueOf(0));
        detalle.setCunidade02(Double.valueOf(0));
        detalle.setCidunidad(BigDecimal.valueOf(0));
        detalle.setCidunida01(BigDecimal.valueOf(0));
        detalle.setCprecio(Double.valueOf(0));
        detalle.setCprecioc01(Double.valueOf(0));
        detalle.setCcostoca01(Double.valueOf(0));
        detalle.setCcostoes01(Double.valueOf(0));
        detalle.setCneto(importePago);
        detalle.setCimpuesto1(Double.valueOf(0));
        detalle.setCporcent01(Double.valueOf(0));
        detalle.setCimpuesto2(Double.valueOf(0));
        detalle.setCporcent02(Double.valueOf(0));
        detalle.setCimpuesto3(Double.valueOf(0));
        detalle.setCporcent03(Double.valueOf(0));
        detalle.setCretenci01(Double.valueOf(0));
        detalle.setCporcent04(Double.valueOf(0));
        detalle.setCretenci02(Double.valueOf(0));
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
        detalle.setCtotal(Double.valueOf(importePago));
        detalle.setCporcent11(Double.valueOf(0));
        detalle.setCreferen01(null);
        detalle.setCobserva01(null);
        detalle.setCafectae01(BigDecimal.valueOf(3));
        detalle.setCafectad01(BigDecimal.valueOf(1));
        detalle.setCafectad02(BigDecimal.valueOf(0));
        detalle.setCfecha(FechaUtils.getFechaActual());
        detalle.setCmovtooc01(BigDecimal.valueOf(0));
        detalle.setCidmovto01(BigDecimal.valueOf(0));
        detalle.setCidmovto02(BigDecimal.valueOf(0));
        detalle.setCunidade03(detalle.getCunidades());
        detalle.setCunidade04(Double.valueOf(0));
        detalle.setCunidade05(Double.valueOf(0));
        detalle.setCunidade06(Double.valueOf(0));
        detalle.setCtipotra01(null);//
        detalle.setCidvalor01(null);//
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
        return detalle;
    }

    private ContpaqPagoFactura getPagoFactura(BigDecimal idPago, BigDecimal idFactura, double importePagado) {
        ContpaqPagoFactura pago = new ContpaqPagoFactura();
        pago.setCiddocum01(idPago);
        pago.setCiddocum02(idFactura);
        pago.setCimporte01(Double.valueOf(importePagado));
        pago.setCimporte02(Double.valueOf(importePagado));
        pago.setCfechaab01(FechaUtils.getFechaActual());
        pago.setCidutili01(BigDecimal.valueOf(0));
        pago.setCidajusiva(BigDecimal.valueOf(0));
        return pago;
    }
}
