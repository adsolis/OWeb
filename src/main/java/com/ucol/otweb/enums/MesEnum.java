/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.enums;

/**
 *
 * @author 
 */
public enum MesEnum {
    ENERO,FEBRERO,MARZO,ABRIL,MAYO,JUNIO,JULIO,AGOSTO,SEPTIEMBRE,OCTUBRE,NOVIEMBRE, DICIEMBRE;
    private MesEnum(){
    }
    public static MesEnum getMes(String nombre){
        if(nombre.equals(ENERO.name())){
            return ENERO;
        }
        if(nombre.equals(FEBRERO.name())){
            return FEBRERO;
        }if(nombre.equals(MARZO.name())){
            return MARZO;
        }if(nombre.equals(ABRIL.name())){
            return ABRIL;
        }if(nombre.equals(MAYO.name())){
            return MAYO;
        }if(nombre.equals(JUNIO.name())){
            return JUNIO;
        }if(nombre.equals(JULIO.name())){
            return JULIO;
        }if(nombre.equals(AGOSTO.name())){
            return AGOSTO;
        }if(nombre.equals(SEPTIEMBRE.name())){
            return SEPTIEMBRE;
        }if(nombre.equals(OCTUBRE.name())){
            return OCTUBRE;
        }
        if(nombre.equals(NOVIEMBRE.name())){
            return NOVIEMBRE;
        }
        if(nombre.equals(DICIEMBRE.name())){
            return DICIEMBRE;
        }
        return null;
    }
}
