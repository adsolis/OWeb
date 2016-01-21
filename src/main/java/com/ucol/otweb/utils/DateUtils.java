/*
 * Clase de utilidades para las fechas
 * 
 */
package com.ucol.otweb.utils;

import com.ucol.otweb.vo.QnaVO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class DateUtils {

    /**
     *
     * @return String regresa una cadena que representa la fecha actual con el
     * formato predefinido en el archivo de propiedades
     */
    static public String fechaActualToString() {
        Date fechaAcual = new Date();
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        String formato = properties.getParametro("formatoFechaBase");
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(fechaAcual);
    }

    static public String fechaPrestamoString(Date fechaP) {
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        String formato = properties.getParametro("formatoFechaVista");
        SimpleDateFormat format = new SimpleDateFormat(formato, new Locale("es", "MX"));
        String fechaForma = format.format(fechaP);
        return fechaForma;
    }

    static public int anioActual() {
        Calendar cal = Calendar.getInstance();
        int anioAct = cal.get(Calendar.YEAR);
        return anioAct;
    }

    static public String horaActual() {
        Calendar cal = Calendar.getInstance();
        String tiempo = "";
        String hora;
        String minutos;
        String segundos;
        hora = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
        minutos = String.valueOf(cal.get(Calendar.MINUTE));
        segundos = String.valueOf(cal.get(Calendar.SECOND));
        if (hora.length() == 1) {
            hora = "0" + hora;
        }
        if (minutos.length() == 1) {
            minutos = "0" + minutos;
        }
        if (segundos.length() == 1) {
            segundos = "0" + segundos;
        }
        tiempo = hora + ":" + minutos + ":" + segundos;
        return tiempo;

    }

    static public String formatFechaToString(Date fecha) {
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        String formato = properties.getParametro("formatoFechaBase");
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(fecha);
    }

    public static Date calculaFechaCorte() {
//        Calendar fechaActual = Calendar.getInstance();
        Calendar fecCorte = Calendar.getInstance();
        fecCorte.add(Calendar.DAY_OF_MONTH, -15);
        if(fecCorte.get(Calendar.DAY_OF_MONTH)>15){
            fecCorte.set(Calendar.DAY_OF_MONTH, fecCorte.getActualMaximum(Calendar.DAY_OF_MONTH));
        }else{
            fecCorte.set(Calendar.DAY_OF_MONTH, 15);
        }
//        int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
//        int mes = fechaActual.get(Calendar.MONTH);
//        int anio = fechaActual.get(Calendar.YEAR);
//        int qna =mes*2;
//        int diaq =0;
//        if(dia<16){
//            if(mes==0){
//                qna=24;
//                anio--;
//            }else{
//                qna=qna-2;
//            }
//        }else{
//            qna--;
//        }
//        if(qna%2 == 0){
//            diaq = 30;
//        }else{
//            diaq = 15;
//        }
//        int mesq = qna/2;
//        fecCorte.set(anio, mesq, diaq);
        return fecCorte.getTime();
    }

    public int FechaCorte() {
        Calendar cal = Calendar.getInstance();
        int qna = 0;
        Date fecAct = new Date();
        DateUtils.anioActual();
        int anio = DateUtils.anioActual();;
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int qnaNum = mes * 2;

        String cadenaQna = null;

        if (dia < 16) {
            if (mes == 1) {
                qnaNum = 24;
                anio = anio - 1;
            } else {
                qnaNum = qnaNum - 2;
            }
        } else {
            qnaNum = qnaNum - 1;
        }

        return qna;
    }

    static public int fechasDiferenciaEnDias(Date fechaIngreso) {
        DateFormat df = DateFormat.getDateInstance();
        String fechaInicialDer = df.format(fechaIngreso);
        try {
            fechaIngreso = df.parse(fechaInicialDer);
        } catch (ParseException parse) {
            parse.getMessage();
        }
        Date fechaActual = Calendar.getInstance().getTime();
        long fechaInicIng = fechaIngreso.getTime();
        long fechaFinAct = fechaActual.getTime();

        long difernciaDias = fechaFinAct - fechaInicIng;
        double diasD = Math.floor(difernciaDias / 0x5265c00L);
        return (int) diasD;
    }

    static public int fechasDiferenciaEnDias(Date fecha1, Date fecha2) {
        DateFormat df = DateFormat.getDateInstance();
        String fechaInicialDer = df.format(fecha1);
        try {
            fecha1 = df.parse(fechaInicialDer);
        } catch (ParseException parse) {
            parse.getMessage();
        }
        //Date fechaActual = Calendar.getInstance().getTime();
        long fecha1L = fecha1.getTime();
        long fecha2L = fecha2.getTime();

        long difernciaDias = fecha1L - fecha2L;
        double diasD = Math.floor(difernciaDias / 0x5265c00L);
        return (int) diasD;
    }

    /**
     * obtiene la diferencia entre dos fechas como resultado regresa una fecha
     *
     * @param fecha1
     * @param fecha2
     * @return
     */
    static public Date fechasDiferencia(Date fecha1, Date fecha2) {
        //int diferenciaEnDias = 1;
        /*long tiempo1 = fecha1.getTime();
        long tiempo2 = fecha2.getTime();
        
        
        //long unDia = diferenciaEnDias * 24 * 60 * 60 * 1000;
        long tiempoDiferencia = tiempo2 - tiempo1;
        Date fecha = new Date(tiempoDiferencia);**/
        int dias = fechasDiferenciaEnDias(fecha1);
        Calendar calf2 = Calendar.getInstance();
        calf2.setTime(fecha2);
        calf2.add(Calendar.DATE, dias);
        Date fecha = calf2.getTime();
        return fecha;
    }

    /**
     * Función para obtener la quincena a partir de una fecha
     *
     * @param date
     * @return quincena en formato ssaaqq (siglo, anio,qna)
     */
    public static String formatoFechaQuincena(Date fecha) {
        int dec = 0;
        int qna = 0;
        String ssaaqq = null;
        int dia;

        Calendar fechaC = Calendar.getInstance();
        int mes = fechaC.get(Calendar.MONTH) + 1;
        fechaC.setTime(fecha);
        dia = fechaC.get(Calendar.DAY_OF_MONTH);

        if (dia <= Constants.DIAS_QNA) {
            dec = 1;
        }

        qna = 2 * (fechaC.get(Calendar.MONTH) + 1) - dec;
        ssaaqq = (new Integer(fechaC.get(Calendar.YEAR))).toString()
                + String.format(Constants.FORMATO_DOS_DIGITOS, qna);
        return ssaaqq;
    }

    public static String formatoAnioQuincena(Date fecha) {
        Integer mes = 0;
        String anioQuin = "";
        String mesFinal = "";
        Calendar fechaC = Calendar.getInstance();
        fechaC.setTime(fecha);
        mes = fechaC.get(Calendar.MONTH) + 1;
        if (mes.toString().length() < 2) {
            mesFinal = "0" + mes.toString();
        } else {
            mesFinal = mes.toString();
        }
        anioQuin = (new Integer(fechaC.get(Calendar.YEAR))).toString() + mesFinal;
        return anioQuin;
    }

    /**
     * Incrementa la quincena a la fecha en formato ssyyqq
     *
     * @param ssyyqq
     * @return
     */
    static public String incrementaQuincena(String ssyyqq) {
        int anio = new Short(ssyyqq.substring(0, 3));
        int quin = new Short(ssyyqq.substring(4, 5)) + 1;
        StringBuilder incQuin = new StringBuilder();
        if (quin > Constants.QUINCENAS_ANIO) {
            quin = quin - Constants.QUINCENAS_ANIO;
            anio++;
        }
        incQuin.append(anio);
        incQuin.append(String.format(Constants.FORMATO_DOS_DIGITOS, quin));
        return incQuin.toString();
    }

    /**
     * Incrementa un mes a la fecha en quincena en formato ssyyqq
     *
     * @param ssyyqq
     * @return
     */
    public static String incrementaMes(String ssyyqq) {
        int anio = new Short(ssyyqq.substring(0, 3));
        int quin = new Short(ssyyqq.substring(4, 5)) + 1;
        StringBuilder incQuin = new StringBuilder();
        if (quin > Constants.MESES_ANIO) {
            quin = quin - Constants.MESES_ANIO;
            anio++;
        }
        incQuin.append(anio);
        incQuin.append(String.format(Constants.FORMATO_DOS_DIGITOS, quin));
        return incQuin.toString();
    }

    static public List<QnaVO> qnasTranscurridas(Date proy, Date actual) {

        Calendar fechaProy = Calendar.getInstance();
        fechaProy.setTime(proy);
        Calendar fechaActual = Calendar.getInstance();
        fechaActual.setTime(actual);
        QnaVO qna = new QnaVO();
        List<QnaVO> listQnaAux = new ArrayList<QnaVO>();

        Calendar cal = Calendar.getInstance();

        int anioIni = fechaProy.get(Calendar.YEAR);
        int anioFin = fechaActual.get(Calendar.YEAR);
        int difAnios = anioFin - anioIni;
        int qnaActual = DateUtils.getQuincena(actual);
        int qnaProy = DateUtils.getQuincena(proy);
        int anioAux = 0;
        int qnaAux = 24;

        if (difAnios == 0) {

            for (int i = anioIni; i <= anioFin; i++) {
                anioAux = anioFin;
                for (int j = qnaProy; j <= qnaActual; j++) {
                    qna.setAnio(anioAux);

                    if (j % 2 == 0) {
                        qna.setMes(j / 2);
                    } else {
                        Double cc = new Double(((j / 2) + 1));
                        qna.setMes(cc.intValue());
                    }

                    qna.setQna(j);
                    cal.set(qna.getAnio(), qna.getMes() - 1, qna.getDia() - 1);
                    qna.setFechQna(cal.getTime());
                    listQnaAux.add(qna);
                    qna = new QnaVO();
                }

            }

        } else {

            for (int i = 0; i <= difAnios; i++) {
                anioAux = anioIni + i;
                if (i == difAnios) {
                    qnaAux = qnaActual;
                }

                if (i > 0) {
                    qnaProy = 1;
                }
                for (int j = qnaProy; j <= qnaAux; j++) {
                    qna.setAnio(anioAux);
                    qna.setQna(j);

                    if (j % 2 == 0) {
                        qna.setMes(j / 2);
                    } else {
                        Double cc = new Double(((j / 2 + 1)));
                        qna.setMes(cc.intValue());
                    }

                    cal.set(qna.getAnio(), (qna.getMes() - 1), (qna.getDia() - 1));
                    qna.setFechQna(cal.getTime());
                    listQnaAux.add(qna);
                    qna = new QnaVO();
                }

            }
        }

        return listQnaAux;
    }

    static public List<QnaVO> qnasTranscurridasVO(QnaVO proy, QnaVO actual) {
        QnaVO qna = new QnaVO();
        List<QnaVO> listQnaAux = new ArrayList<QnaVO>();

        int anioIni = proy.getAnio();
        int anioFin = actual.getAnio();
        int difAnios = anioFin - anioIni;
        int qnaActual = actual.getQna();
        int qnaProy = proy.getQna();
        int anioAux = 0;
        int qnaAux = 24;
        if (difAnios == 0) {

            for (int i = anioIni; i <= anioFin; i++) {
                anioAux = anioFin;
                for (int j = qnaProy; j <= qnaActual; j++) {
                    qna.setAnio(anioAux);

                    if (j % 2 == 0) {
                        qna.setMes(j / 2);
                    } else {
                        Double cc = new Double(((j / 2) + 1));
                        qna.setMes(cc.intValue());
                    }
                    qna.setQna(j);
                    listQnaAux.add(qna);
                    qna = new QnaVO();
                }

            }

        } else {

            for (int i = 0; i <= difAnios; i++) {
                anioAux = anioIni + i;
                if (i == difAnios) {
                    qnaAux = qnaActual;
                }

                if (i > 0) {
                    qnaProy = 1;
                }
                for (int j = qnaProy; j <= qnaAux; j++) {
                    qna.setAnio(anioAux);
                    qna.setQna(j);

                    if (j % 2 == 0) {
                        qna.setMes(j / 2);
                    } else {
                        Double cc = new Double(((j / 2 + 1)));
                        qna.setMes(cc.intValue());
                    }

                    listQnaAux.add(qna);
                    qna = new QnaVO();
                }

            }
        }
        return listQnaAux;
    }

    public static int getQuincena(Date fecha) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH);
        mes = (mes + 1) * 2;
        return (dia < 16) ? mes - 1 : mes;
    }

    public static QnaVO incrementaQuincena(QnaVO qna) {
        if ((qna.getQna() + 1) > 24) {
            int difAnio = 1 + qna.getAnio();
            qna.setQna(1);
            qna.setAnio(difAnio);
        }
        return qna;
    }

    /**
     * Se obtiene la quincena final
     * @param quinDif
     * @param plazo
     * @param nombramiento
     * @return 
     */
    public static String obtenerQuincenaFinalPrest(String quinDif, int plazo, int nombramiento) {
        String quincenaFin = "";
        String qquinF = "";
        Integer qanio = Integer.parseInt(quinDif.substring(0, 4));
        Integer qquince = Integer.parseInt(quinDif.substring(4, 6));
        for (int i = 1; i <= plazo; i++) {
            if (nombramiento != Constants.C_PENSION) {
                if (qquince >= Constants.QUINCENAS_ANIO) {
                    qquince = 01;
                    qanio = qanio + 1;
                } else {
                    qquince = qquince + 1;
                }
            } else {
                if (qquince >= Constants.MESES_ANIO) {
                    qquince = 01;
                    qanio = qanio + 1;
                } else {
                    qquince = qquince + 1;
                }
            }
        }
        qquince = qquince - 1;
        if (qquince == 0) {
            if (nombramiento != Constants.C_PENSION) {
                qquince = 24;
            } else {
                qquince = 12;
            }
            qanio = qanio - 1;
        }
        if (qquince.toString().length() < 2) {
            qquinF = "0" + qquince.toString();
        }
        if (qquinF.equals("")) {
            quincenaFin = qanio.toString() + qquince.toString();
        } else {
            quincenaFin = qanio.toString() + qquinF;
        }
        return quincenaFin;
    }

    public static Date parse(String ssaaqq) {
        int anio = new Short(ssaaqq.substring(0, 4));
        int quin = new Short(ssaaqq.substring(4, 6));
        int dia = 0;
        int mes = 0;
        Calendar cal = Calendar.getInstance();
        if (quin % 2 == 0) {
            dia = 16;
            mes = (quin / 2);
        } else {
            dia = 1;
            mes = (quin + 1) / 2;
        }
        cal.set(anio, mes-1, dia);
        return cal.getTime();
    }

    /**
     * se genera la etiqueta para la previsualizacion de los calculos
     * con el formato "En el periodo de pago de su nómina del 'dd' al 'dd' de 'MMM' de 'YYYY' "
     * @param yyyyqq
     * @return 
     */
    public static String periodoQuincena(String yyyyqq, String periodicidad) {
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        String etiqueta = properties.getParametro("reports.label.prev.periodo");
        int anio = new Short(yyyyqq.substring(0, 4));
        int quin = new Integer(yyyyqq.substring(4, 6));
        int dia = 0;
        int mes = 0;
        int diaF = 0;
        Calendar cal = Calendar.getInstance();

        if (periodicidad.trim().equals("MENSUAL")) {
            dia = 1;
            mes = quin - 1;
        } else {
            if (quin % 2 == 0) {
                dia = 16;
                mes = (quin / 2) - 1;
            } else {
                dia = 1;
                diaF = 15;
                mes = ((quin - 1) / 2);
                
            }
        }
        cal.set(anio, mes, dia);
        if (diaF == 0) {
            diaF = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        etiqueta = etiqueta + " "
                + String.format(Constants.FORMATO_DOS_DIGITOS, dia)
                + " al " + String.format(Constants.FORMATO_DOS_DIGITOS, diaF)
                + " de " + cal.getDisplayName(Calendar.MONTH, Calendar.MONTH, new Locale("ES", "MX"))
                + " de " + anio;
        return etiqueta;
    }

    public static Date obtenerUltimaQuincena(String fecha) {
        String fechaDos = "";
        Date d = null;
        Integer dia = 0;
        DateFormat df = DateFormat.getDateInstance();
        Integer anio = Integer.parseInt(fecha.substring(0, 4));
        Integer mes = Integer.parseInt(fecha.substring(4, 6)) / 2 + 1;
        if (mes > 12) {
            mes = mes - 12;
            anio = anio + 1;
        }
        if ((Integer.parseInt(fecha.substring(4, 6)) % 2) == 0) {
            dia = 16;
        } else {
            dia = 1;
        }
        fechaDos = ""+dia+"/"+ mes+"/"+ anio;
        d = parseStringDate(fechaDos);
        return d;
    }

    public static String gConvFechaQuin1(Date fecha) {
        String quincena = "";
        String mesCad = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        int anio = 0;
        int mes = 0;
        int dia = 0;
        anio = cal.get(Calendar.YEAR);
        mes = cal.get(Calendar.MONTH) + 1;
        dia = cal.get(Calendar.DAY_OF_MONTH);

        quincena = "" + anio;

        mes = (mes - 1) * 2;

        if (dia >= 16) {
            dia = 2;
        } else {
            dia = 1;
        }

        mes += dia;
        // mesCad = ""+mes;
        quincena += "" + mes;
        return quincena;
    }

    public static Date parseStringDate(String fecha) {
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        String formato = properties.getParametro("formatoFechaBase");
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        Date fechaRef = null;
        try {
            fechaRef = sdf.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaRef;
    }
    public static int compararFechas(Date fecha1, Date fecha2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        int fechaInt1 = new Integer(sdf.format(fecha1));
        int fechaInt2 = new Integer(sdf.format(fecha2));
        if(fechaInt1==fechaInt2){
            return 0;
        }else if(fechaInt1>fechaInt2){
            return 1;
        }else{
            return -1;
        }
    }
}
