/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tux.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import com.tux.utils.Environment;

/**
 *
 * @author miklex
 */
public class ContpaqTableMapper {

    private Environment ambiente;
    private String campos;

    public ContpaqTableMapper() {
        ambiente = new Environment(false);
        ambiente.getSystemProperties();
        campos = "";
    }

    public Map<String, String> mapDbfTable(String tabla) {
        Map<String, String> tablaMapeada = null;
        try {
            tablaMapeada = propertiesToMap(ambiente.loadConfigFile(tabla));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return tablaMapeada;
        }
    }

    private Map<String, String> propertiesToMap(Properties props) {
        HashMap<String, String> hm = new HashMap<String, String>();
        Enumeration<Object> e = props.keys();
        while (e.hasMoreElements()) {
            String s = (String) e.nextElement();
            System.out.println("[ContpaqTableMapper] Mapeando propiedad: " + s + " --> " + props.getProperty(s));
            setCampos(props.getProperty(s));
            hm.put(s, props.getProperty(s));
        }
        return hm;
    }

    public void setCampos(String campo) {
        campos = "," + campo;
    }

    public String getCampos() {
        System.out.println("Campos: " + campos);
        return campos;
    }
}
