/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.model.entity;

import java.io.Serializable;

/**
 *
 * @author Mike
 */
public class Producto implements Serializable{
    
    private long idProducto;
    private String coodigoProducto;
    private String nombreProducto;
    private String descripcionDetallada;
    private double precio;
    private String codigoAlterno;
    private String nombreAlterno;
    private String descripcionCorta;
    private int tipo; // 1 = Producto; 3 = Servicio

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
     * @return the coodigoProducto
     */
    public String getCoodigoProducto() {
        return coodigoProducto;
    }

    /**
     * @param coodigoProducto the coodigoProducto to set
     */
    public void setCoodigoProducto(String coodigoProducto) {
        this.coodigoProducto = coodigoProducto;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the descripcionDetallada
     */
    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    /**
     * @param descripcionDetallada the descripcionDetallada to set
     */
    public void setDescripcionDetallada(String descripcionDetallada) {
        this.descripcionDetallada = descripcionDetallada;
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
     * @return the codigoAlterno
     */
    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    /**
     * @param codigoAlterno the codigoAlterno to set
     */
    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    /**
     * @return the nombreAlterno
     */
    public String getNombreAlterno() {
        return nombreAlterno;
    }

    /**
     * @param nombreAlterno the nombreAlterno to set
     */
    public void setNombreAlterno(String nombreAlterno) {
        this.nombreAlterno = nombreAlterno;
    }

    /**
     * @return the descripcionCorta
     */
    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    /**
     * @param descripcionCorta the descripcionCorta to set
     */
    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
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
    
}
