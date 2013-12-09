package com.tux.utils;

/**
 *
 * @author miklex
 */
import java.util.HashMap;
import java.util.Map;
import net.andesconsulting.dbf.DbfFile;

public class AutoConfig {

    public void configureContpaqTables() {
        Environment ambiente = new Environment(true);
        Map<String, String> tablas;
        try {
            System.out.println("Cargando archivo DBF: " + ambiente.getDbfFilesPath() + "/" + ambiente.getEnterpriseName() + "/" + ambiente.getTableDefinitionDBF());
            DbfFile bfile;
            bfile = new DbfFile(ambiente.getDbfFilesPath() + "/" + ambiente.getEnterpriseName() + "/" + ambiente.getTableDefinitionDBF());
            System.out.println("********** Abriendo archivo DBF ***********");
            bfile.open();
            bfile.getFields();
            System.out.println("******* Registros: " + bfile.getCount() + " *********");
            tablas = new HashMap<String, String>();
            for (int i = 0; i < bfile.getCount(); i++) {
                bfile.go(i);
                Map<String, String> map = bfile.scatter();
                System.out.println(removeBlankSpacesAndAccents(map.get("CNOMBREA01")) + "=" + map.get("CNOMBREN01"));
                tablas.put(removeBlankSpacesAndAccents(map.get("CNOMBREA01")), map.get("CNOMBREN01"));
            }
            ambiente.writePropertiesFile("contpaqTables", tablas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void configureContpaqTable(String propertiesFile,String table, String field, String value) {
        Environment ambiente = new Environment(true);
        Map<String, String> tablas;
        try {
            System.out.println("Cargando archivo DBF: " + ambiente.getDbfFilesPath() + "/" + ambiente.getEnterpriseName() + "/" + table);
            DbfFile bfile;
            bfile = new DbfFile(ambiente.getDbfFilesPath() + "/" + ambiente.getEnterpriseName() + "/" + table);
            System.out.println("********** Abriendo archivo DBF ***********");
            bfile.open();
            bfile.getFields();
            System.out.println("******* Registros: " + bfile.getCount() + " *********");
            tablas = new HashMap<String, String>();
            for (int i = 0; i < bfile.getCount(); i++) {
                bfile.go(i);
                Map<String, String> map = bfile.scatter();
                System.out.println(removeBlankSpacesAndAccents(map.get(field)) + "=" + map.get(value));
                tablas.put(removeBlankSpacesAndAccents(map.get(field)), map.get(value));
            }
            ambiente.writePropertiesFile(propertiesFile, tablas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
    private String removeBlankSpacesAndAccents(String campo) {
        String valor = "";
        valor = campo.replaceAll(" ", "");
        valor = valor.replaceAll("á", "a");
        valor = valor.replaceAll("é", "e");
        valor = valor.replaceAll("í", "i");
        valor = valor.replaceAll("ó", "o");
        valor = valor.replaceAll("u", "u");
        valor = valor.replaceAll("/", "");
        return valor;
    }
}
