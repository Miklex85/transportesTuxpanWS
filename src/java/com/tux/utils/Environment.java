package com.tux.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author miklex
 */
public final class Environment implements Serializable{

    private String operatingSystem = null;
    private String userHome = null;
    private String dbfFilesPath;
    private String enterpriseName;
    private String tableDefinitionDBF;
    private String tableNameColumn;
    private String separador;

    public Environment(boolean loadGeneralConfig) {
        Properties props = new Properties();
        try {
            setSeparador();
            if (loadGeneralConfig) {
                props = loadConfigFile("contpaqi");
                dbfFilesPath = props.getProperty("dbfFilesPath");
                enterpriseName = props.getProperty("enterpriseName");
                tableDefinitionDBF = props.getProperty("tableDefinitionDbf");
                tableNameColumn = props.getProperty("tableNameColumn");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSystemProperties() {
        System.getProperties().list(System.out);
    }

    public String getOsName() {
        if (operatingSystem == null) {
            operatingSystem = System.getProperty("os.name");
        }
        return operatingSystem;
    }

    public String getUserHome() {
        if (userHome == null) {
            userHome = System.getProperty("user.home");
        }
        return userHome;
    }

    public String getDbfFilesPath() {
        return dbfFilesPath;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public String getTableDefinitionDBF() {
        return tableDefinitionDBF;
    }

    public String getTableNameColumn() {
        return tableNameColumn;
    }

    public boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    public boolean isMac() {
        return getOsName().startsWith("Mac");
    }

    public boolean isUnix() {
        return getOsName().startsWith("Linux");
    }

    public Properties loadConfigFile(String propsFile) throws IOException {
        Properties props = new Properties();
        System.out.println("Leyendo archivo properties en la ruta: " + (getUserHome() + separador + "ContpaqWS" + separador + "conf" + separador + propsFile + ".properties"));
        FileInputStream fis = new FileInputStream(getUserHome() + separador + "ContpaqWS" + separador + "conf" + separador + propsFile + ".properties");
        props.load(fis);
        fis.close();
        return props;
    }

    public boolean writePropertiesFile(String fileName, Map<String, String> attributes) throws IOException {
        Properties prop = new Properties();
        boolean ok = false;
        try {
            if (!propertiesFileExists(fileName)) {
                Set<Map.Entry<String, String>> set = attributes.entrySet();
                for (Map.Entry<String, String> entry : set) {
                    prop.put(entry.getKey(), entry.getValue());
                }
                prop.store(new FileOutputStream((getUserHome() + separador + "ContpaqWS" + separador + "conf" + separador + fileName + ".properties")), null);
                System.out.println("Creando Archivo " + fileName + ".properties");
            } else {
                System.out.println("El archivo " + fileName + ".properties ya existe");
            }
            ok = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            return ok;
        }
    }

    private boolean propertiesFileExists(String fileName) {
        boolean exists = false;
        exists = new File((getUserHome() + separador + "ContpaqWS" + separador + "conf" + separador + fileName + ".properties")).exists();
        return exists;
    }

    private void setSeparador() {
        if (isWindows()) {
            separador = "\\";
        } else if (isMac() || isUnix()) {
            separador = "/";
        } else {
            separador = "/";
        }
    }
}