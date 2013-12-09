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
public class Cliente  implements Serializable{
 
    private long idCliente;
    private String codigoCliente;
    private String razonSocial;
    private String rfc;
    private String curp;
    private String representanteLegal;
    private double limiteDeCredito;
    private int diasDeCredito;
    private String denominacionComercial;
    private String email;

    /**
     * @return the idCliente
     */
    public long getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the codigoCliente
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp the curp to set
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return the representanteLegal
     */
    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    /**
     * @param representanteLegal the representanteLegal to set
     */
    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    /**
     * @return the limiteDeCredito
     */
    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    /**
     * @param limiteDeCredito the limiteDeCredito to set
     */
    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    /**
     * @return the diasDeCredito
     */
    public int getDiasDeCredito() {
        return diasDeCredito;
    }

    /**
     * @param diasDeCredito the diasDeCredito to set
     */
    public void setDiasDeCredito(int diasDeCredito) {
        this.diasDeCredito = diasDeCredito;
    }

    /**
     * @return the denominacionComercial
     */
    public String getDenominacionComercial() {
        return denominacionComercial;
    }

    /**
     * @param denominacionComercial the denominacionComercial to set
     */
    public void setDenominacionComercial(String denominacionComercial) {
        this.denominacionComercial = denominacionComercial;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
