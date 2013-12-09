/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.utils;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Mike
 */
public class FechaUtils {

    public static Date getFechaActual() {
        Date fechaActual;
        java.util.Date hoy = new java.util.Date();
        fechaActual = new java.sql.Date(hoy.getTime());
        return fechaActual;
    }

    public static Date getFechaLimite(BigDecimal dias) {
        Date fechaLimite;
        Calendar c = Calendar.getInstance();
        c.setTime(new java.util.Date());
        c.add(Calendar.DATE, dias.intValue());
        fechaLimite = new java.sql.Date(c.getTimeInMillis());
        return fechaLimite;
    }
}
