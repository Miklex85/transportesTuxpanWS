package com.tux.model.entity;

import java.io.Serializable;

/**
 *
 * @author Mike
 */
public class DetalleFactura implements Serializable{
    
    private long idProducto;
    private long codigoProducto;
    private int tipo;
    private long cantidad;
    private double precio;
    private double iva;
    private double retencion;
    private double descuento;
    private double gasto;

    /**
     * @return the idProducto
     */
    public long getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the codigoProducto
     */
    public long getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(long codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cantidad
     */
    public long getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the retencion
     */
    public double getRetencion() {
        return retencion;
    }

    /**
     * @param retencion the retencion to set
     */
    public void setRetencion(double retencion) {
        this.retencion = retencion;
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the gasto
     */
    public double getGasto() {
        return gasto;
    }

    /**
     * @param gasto the gasto to set
     */
    public void setGasto(double gasto) {
        this.gasto = gasto;
    }
}
