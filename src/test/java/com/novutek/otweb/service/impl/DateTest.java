/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service.impl;

import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.utils.NumerosUtils;
import com.ucol.otweb.vo.QnaVO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author 
 */
public class DateTest {
//    @Test

    public void testfechaCorte() {
        System.out.println("Inicia prueba...");
        Date fechaCorte = DateUtils.calculaFechaCorte();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha Corte:::" + sdf.format(fechaCorte));
    }
//    @Test

    public void testComparaFechas() {
        System.out.println("Inicia prueba...");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c2.add(Calendar.DAY_OF_MONTH, 15);
//        int fechComp = DateUtils.compararFechas(c1.getTime(), c2.getTime());
        System.out.println("primera validacion:::" + c1.getTime() + "::" + c2.getTime() + "::" + DateUtils.compararFechas(c1.getTime(), c2.getTime()));
        System.out.println("segunda validacion:::" + c2.getTime() + "::" + c2.getTime() + "::" + DateUtils.compararFechas(c2.getTime(), c2.getTime()));
        System.out.println("tercera validacion:::" + c2.getTime() + "::" + c1.getTime() + "::" + DateUtils.compararFechas(c2.getTime(), c1.getTime()));
    }
//    @Test
//    public void testQuincenasTrancurridas(){
//        System.out.println("Inicia prueba... Quincenas transcurridas::");
//        Calendar fecha1=Calendar.getInstance();
//        Calendar fecha2=Calendar.getInstance();
//        fecha2.add(Calendar.YEAR, amount)
//        System.out.println("qnas transcurridas:::");
//    }
//    @Test

    public void testParseQuincena() {
        System.out.println("Inicia prueba...");
        String qna = "200622";
        System.out.println("parse:::" + DateUtils.parse(qna));
    }

//    @Test
    public void testQnaVo() {
        System.out.println("Inicia prueba...");
        Calendar fecha = Calendar.getInstance();
        QnaVO qna = null;
        for (int i = 0; i < 12;i++) {
            fecha.set(Calendar.MONTH, i);
            fecha.set(Calendar.DAY_OF_MONTH, 1);
            qna = new QnaVO(fecha.getTime());
            System.out.println("parse:::" + qna.getAnio()+""+String.format(Constants.FORMATO_DOS_DIGITOS, qna.getQna()));
            fecha.set(Calendar.DAY_OF_MONTH, 16);
            qna = new QnaVO(fecha.getTime());
            System.out.println("parse:::" + qna.getAnio()+""+String.format(Constants.FORMATO_DOS_DIGITOS, qna.getQna()));
        }
    }
    @Test
    public void testNumber(){
        System.out.println("Inicia prueba");
        double valor=536.5455531;//3.9999999;
        System.out.println("Valor truncado:::"+NumerosUtils.truncate(valor, 2));
    } 
}
