/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.utils;

import java.math.BigDecimal;

/**
 *
 * @author 
 */
public class NumerosUtils {

    static public double redondeoNumero(double numero, int decimal) {
        BigDecimal bd = new BigDecimal(numero);
        bd = bd.setScale(decimal, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
    public static double truncate(double d, int decimalPlace){
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_DOWN);
        return bd.doubleValue();
    }
}
