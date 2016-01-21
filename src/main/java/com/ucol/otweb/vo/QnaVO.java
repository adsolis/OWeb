/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import com.ucol.otweb.utils.Constants;
import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 
 */
public class QnaVO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Date Rango1;
    private Date Rango2;
    private int anio;
    private int mes;
    private int dia;
    private int qna;
    private Date fechQna;
      
    public QnaVO(){
        
    }
    public QnaVO(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        int dec=0;
        this.anio = cal.get(Calendar.YEAR);
        this.mes = cal.get(Calendar.MONTH)+1;
        this.dia = cal.get(Calendar.DAY_OF_MONTH);
        if(dia <= Constants.DIAS_QNA){
            dec = 1;
        }else{
            dec = 2;
        }
        
        qna = (2 * (mes-1)) + dec;
    }
    
    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the qna
     */
    public int getQna() {
        return qna;
    }

    /**
     * @param qna the qna to set
     */
    public void setQna(int qna) {
        this.qna = qna;
    }
    /**
     * Sobrecarga del metodo toString para obtener la quincena en formato ssaaqq
     * solo toma en cuenta quincenas, no como meses
     * @return 
     */
    @Override
    public String toString() {
        String ssaaqq = new Integer(anio).toString()
                + String.format(Constants.FORMATO_DOS_DIGITOS, qna);
        
        return ssaaqq;
    }

    /**
     * @return the Rango1
     */
    public Date getRango1() {
        return Rango1;
    }

    /**
     * @param Rango1 the Rango1 to set
     */
    public void setRango1(Date Rango1) {
        this.Rango1 = Rango1;
    }

    /**
     * @return the Rango2
     */
    public Date getRango2() {
        return Rango2;
    }

    /**
     * @param Rango2 the Rango2 to set
     */
    public void setRango2(Date Rango2) {
        this.Rango2 = Rango2;
    }

    /**
     * @return the fechQna
     */
    public Date getFechQna() {
        return fechQna;
    }

    /**
     * @param fechQna the fechQna to set
     */
    public void setFechQna(Date fechQna) {
        this.fechQna = fechQna;
    }
    
    
    
}
