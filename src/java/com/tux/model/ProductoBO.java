/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.model;

import com.tux.dto.ContpaqProducto;
import com.tux.model.dao.ProductoDAO;
import com.tux.model.entity.Producto;
import com.tux.utils.FechaUtils;
import java.math.BigDecimal;

/**
 *
 * @author Mike
 */
public class ProductoBO {

    public Producto consultarProducto(long idProducto) {
        Producto producto = null;
        ContpaqProducto contpaqProducto;
        ProductoDAO productoDAO;
        try {
            productoDAO = new ProductoDAO();
            contpaqProducto = productoDAO.consultarProducto("CIDCLIEN01", "" + idProducto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return producto;
        }
    }

    public boolean crearProducto(Producto producto) {
        boolean respuesta = false;
        ContpaqProducto contpaqProducto = null;
        ProductoDAO productoDAO = null;
        try {
            int tipo = producto.getTipo();
            contpaqProducto = new ContpaqProducto();
            contpaqProducto.setCidprodu01(BigDecimal.valueOf(producto.getIdProducto()));
            contpaqProducto.setCcodigop01(producto.getCoodigoProducto());
            contpaqProducto.setCnombrep01(producto.getNombreProducto());
            contpaqProducto.setCtipopro01(BigDecimal.valueOf(tipo));
            contpaqProducto.setCfechaal01(FechaUtils.getFechaActual());
            contpaqProducto.setCcontrol01((tipo==1)? BigDecimal.valueOf(3) : BigDecimal.valueOf(0));
            contpaqProducto.setCidfotop01(BigDecimal.valueOf(0));
            contpaqProducto.setCdescrip01(producto.getDescripcionDetallada());
            contpaqProducto.setCmetodoc01((tipo==1)? BigDecimal.valueOf(1) : BigDecimal.valueOf(7));
            contpaqProducto.setCpesopro01((tipo==1)? Double.valueOf(3) : Double.valueOf(0));//
            contpaqProducto.setCcomvent01(Double.valueOf(0));
            contpaqProducto.setCcomcobr01(Double.valueOf(0));
            contpaqProducto.setCcostoes01(Double.valueOf(0));
            contpaqProducto.setCmargenu01(Double.valueOf(0));
            contpaqProducto.setCstatusp01(BigDecimal.valueOf(1));
            contpaqProducto.setCidunida01((tipo==1)? BigDecimal.valueOf(1) : BigDecimal.valueOf(7));//
            contpaqProducto.setCidunida02(BigDecimal.valueOf(0));
            contpaqProducto.setCfechabaja(FechaUtils.getFechaActual());
            contpaqProducto.setCimpuesto1(Double.valueOf(0));
            contpaqProducto.setCimpuesto2(Double.valueOf(0));
            contpaqProducto.setCimpuesto3(Double.valueOf(0));
            contpaqProducto.setCretenci01(Double.valueOf(0));
            contpaqProducto.setCretenci02(Double.valueOf(0));
            contpaqProducto.setCidpadre01((tipo==1)? BigDecimal.valueOf(1) : BigDecimal.valueOf(0));
            contpaqProducto.setCidpadre02(BigDecimal.valueOf(0));
            contpaqProducto.setCidpadre03(BigDecimal.valueOf(0));
            contpaqProducto.setCidvalor01((tipo==1)? BigDecimal.valueOf(1) : BigDecimal.valueOf(0));
            contpaqProducto.setCidvalor02(BigDecimal.valueOf(0));
            contpaqProducto.setCidvalor03(BigDecimal.valueOf(0));
            contpaqProducto.setCidvalor04(BigDecimal.valueOf(0));
            contpaqProducto.setCidvalor05(BigDecimal.valueOf(0));
            contpaqProducto.setCidvalor06(BigDecimal.valueOf(0));
            contpaqProducto.setCsegcont01(null);
            contpaqProducto.setCsegcont02(null);
            contpaqProducto.setCsegcont03(null);
            contpaqProducto.setCtextoex01(null);
            contpaqProducto.setCtextoex02(null);
            contpaqProducto.setCtextoex03(null);
            contpaqProducto.setCfechaex01(null);
            contpaqProducto.setCimporte01(Double.valueOf(0));
            contpaqProducto.setCimporte02(Double.valueOf(0));
            contpaqProducto.setCimporte03(Double.valueOf(0));
            contpaqProducto.setCimporte04(Double.valueOf(0));
            contpaqProducto.setCprecio1(Double.valueOf(producto.getPrecio()));
            contpaqProducto.setCprecio2(Double.valueOf(0));
            contpaqProducto.setCprecio3(Double.valueOf(0));
            contpaqProducto.setCprecio4(Double.valueOf(0));
            contpaqProducto.setCprecio5(Double.valueOf(0));
            contpaqProducto.setCprecio6(Double.valueOf(0));
            contpaqProducto.setCprecio7(Double.valueOf(0));
            contpaqProducto.setCprecio8(Double.valueOf(0));
            contpaqProducto.setCprecio9(Double.valueOf(0));
            contpaqProducto.setCprecio10(Double.valueOf(0));
            contpaqProducto.setCbanunid01(null);
            contpaqProducto.setCbancara01(null);
            contpaqProducto.setCbanmeto01(null);
            contpaqProducto.setCbanmaxmin(null);
            contpaqProducto.setCbanprecio(null);
            contpaqProducto.setCbanimpu01(BigDecimal.valueOf(1));
            contpaqProducto.setCbancodi01(null);
            contpaqProducto.setCbancomp01(null);
            contpaqProducto.setCtimestamp(null);
            contpaqProducto.setCerrorco01((tipo==1)? BigDecimal.valueOf(3) : BigDecimal.valueOf(0));
            contpaqProducto.setCfechaer01(FechaUtils.getFechaActual());
            contpaqProducto.setCprecioc01(Double.valueOf(0));
            contpaqProducto.setCestadop01(null);
            contpaqProducto.setCbanubic01(null);
            contpaqProducto.setCesexento(BigDecimal.valueOf(0));
            contpaqProducto.setCexisten01(null);
            contpaqProducto.setCcostoext1(Double.valueOf(0));
            contpaqProducto.setCcostoext2(Double.valueOf(0));
            contpaqProducto.setCcostoext3(Double.valueOf(0));
            contpaqProducto.setCcostoext4(Double.valueOf(0));
            contpaqProducto.setCcostoext5(Double.valueOf(0));
            contpaqProducto.setCfeccosex1(null);
            contpaqProducto.setCfeccosex2(null);
            contpaqProducto.setCfeccosex3(null);
            contpaqProducto.setCfeccosex4(null);
            contpaqProducto.setCfeccosex5(null);
            contpaqProducto.setCmoncosex1(null);
            contpaqProducto.setCmoncosex2(null);
            contpaqProducto.setCmoncosex3(null);
            contpaqProducto.setCmoncosex4(null);
            contpaqProducto.setCmoncosex5(null);
            contpaqProducto.setCbancosex(null);
            contpaqProducto.setCescuotai2(BigDecimal.valueOf(0));
            contpaqProducto.setCescuotai3(BigDecimal.valueOf(0));
            contpaqProducto.setCidunicom(BigDecimal.valueOf(0));
            contpaqProducto.setCiduniven(BigDecimal.valueOf(0));
            contpaqProducto.setCsubtipo(null);
            contpaqProducto.setCcodaltern(producto.getCodigoAlterno());
            contpaqProducto.setCnomaltern(producto.getNombreAlterno());
            contpaqProducto.setCdesccorta(producto.getDescripcionCorta());
            contpaqProducto.setCidmoneda(null);
            contpaqProducto.setCusabascu(null);
            contpaqProducto.setCtipopaque(null);
            contpaqProducto.setCprecselec(null);
            contpaqProducto.setCdesglosai(BigDecimal.valueOf(1));
            contpaqProducto.setCsegcont04(null);
            contpaqProducto.setCsegcont05(null);
            contpaqProducto.setCsegcont06(null);
            contpaqProducto.setCsegcont07(null);
            contpaqProducto.setCnomodcomp(null);
            productoDAO = new ProductoDAO();
            respuesta = productoDAO.crearProductoServicio(contpaqProducto);
            System.out.println("ProductoBO.crearProducto: Se va a insertar el registro del producto");
        } catch (Exception e) {
            System.out.println("ProductoBO.crearProducto: Ocurrio un error al guardar al producto");
            e.printStackTrace();
        } finally {
            System.out.println("ProductoBO.crearProducto: Se regresa como respuesta --> " + respuesta);
            return respuesta;
        }
    }
}
