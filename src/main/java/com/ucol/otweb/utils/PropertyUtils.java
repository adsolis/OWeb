package com.ucol.otweb.utils;



import java.io.*;
import java.util.*;

/**
 * 
 * @author 
 */
public class PropertyUtils {
  String nombreArchivo = "";

  Class configurationClass;
  ClassLoader classLoader;
  InputStream inputStream;
  Properties properties;

  /**
   * Constructor publico de la clase
   * @param nomArchivo: nombre del archivo de propiedades que sera cargado.
   */
  public PropertyUtils(String nomArchivo) {
    nombreArchivo = nomArchivo;
  }
 
  /**
   * funcion para inicializar el archivo de propiedades
   */
  public void cargaArchivo() {

    try {
      configurationClass = PropertyUtils.class;
      classLoader = configurationClass.getClassLoader();
      inputStream = classLoader.getResourceAsStream(nombreArchivo);
      properties = new Properties();
      properties.load(inputStream);
      inputStream.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Busca en el archivo de propiedades el parametro solicitado
   * @param nombreParametro - es la clave con la que esta identificada dicha propiedad en el archivo de propiedades
   * @return Valor de la propiedad solicitada
   */
  public String getParametro(String nombreParametro) {
    String value = "";
    value = properties.getProperty(nombreParametro);
    return value.trim();
  }
  

}
