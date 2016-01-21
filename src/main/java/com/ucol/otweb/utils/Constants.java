/*
 * Clase para contener las constantes usadas en la aplicacion
 * and open the template in the editor.
 */
package com.ucol.otweb.utils;

/**
 *
 * @author 
 */
public interface Constants {
    public static int TNO_CVE_CONFIANSA=20;
    public static int GRUPO_CONFIANSA=4;

    /**
     * definicion de las constantes de manera publica
     */
    String TPO_CREDITO_IN = "14, 18, 15, 19, 20, 17";
    String TPO_CRED_VIG = "3,5,8";
    public static final int ESTATUS_INICIAL_TRANS_MOV_OTO = 0;
    public static final String TIPO_PRESTO = "D";
    public static final String ESPACIO = " ";
    public static final String PENSIONADO = "P";
    public static final String TRABAJADOR = "T";
    public static final String CHEQUE = "Y";
    public static final String DTOESTADO = "A";
    public static final String BASE = "[BASE]";
    public static final String OPERADOR_WEB = "9999";
    public static final String ACTWEB = "ACTWEB";
    public static final String ALTAWEB = "ALTAWEB";
    public static final String OTOWEB = "OTOWEB";
    public static final String AUTWEB = "AutWEB";
    public static final int C_PENSION = 30;
    public static final int ENTIDAD_ESTATO = 15;
    public static final int ENTIDAD_DF = 9;
    public static final int OFICINA_DF = 4;
    public static final int DELEG_SUBDIR_OTOCRED=40;
    public static final int TIPO_PREST_ESP_PEN = 4;
    public static final int TIPO_PREST_COMPL = 11;
    public static final int TIPO_PREST_DAMNIFICADOS = 12;
    public static final int TIPO_PREST_EXC_PEN = 15;
    public static final int TIPO_PREST_ADQ_BIENES_DURADEROS = 16;
    public static final int TIPO_PREST_ESPEC = 18;
    public static final int TIPO_PREST_EXT_DAM = 19;
    public static final int TIPO_PREST_CONM_ANIV = 20;
    public static final int TIPO_PREST_AUTOS = 21;
    public static final int CVE_ENTIDAD_GLOBAL = 0;
    public static final int ESTATUS_RECIBIDA = 1;
    public static final int ESTATUS_RECHAZO_VISUAL = 2;
    public static final int ESTATUS_RECHAZO_OTORGAMIENTO = 3;
    public static final int ESTATUS_PRESTAMO_OTORGADO = 4;
    public static final int MODO_PAGO = 1;
    public static final int TIPO_CUENTA = 4;
    public static final int TIPO_OPER_ALTA = 0;
    public static final int TIPO_OPER_MOD = 1;
    public static final int TIPO_OPER_NUEVO_REGRESO=1;
    public static final int TIPO_OPER_MOD_REGRESO = 2;
    public static final int CVE_PARAM_BIENES = 6;
    public static final int CVE_PARAM_ESP = 5;
    public static final int CVE_PARAM_EXT_D = 4;
    public static final int CVE_PARAM_CON_ANI = 7;
    public static final int TNO_CVE_HON = 25;
    public static final int TNO_CVE_BASE = 10;
    public static final int PLAZO_SOLICITADO=120;
    public static final int TIPO_ORDEN_P_PREST_SIN_REFINAN=1;
    public static final int TIPO_ORDEN_P_PREST_CON_REFINAN=3;
    public static final int RECHAZO_NO_CUBRE_LA_CUARTA_PARTE=22;
    public static final int RECHAZO_NO_CUBRE_TOTALIDAD=50;
    public static final int RECHAZO_TIENE_UN_ADEUDO_MAYOR_AL_PERMITIDO=60;
    public static final int PROCESO_OTO_WEB_SIN_RECHAZO=0;
    public static final int VENT_ELIGE_CIUDAD_DF=1;
    public static final int VENT_CONFIR_CIUDAD=2;
    public static final int VENT_CONFIR_CREDITO=3;
    public static final String CIUDADEDOMEX= "EdoMex";
    public static final String CIUDADISTRITO= "Distrito";
    public static final String PERIOPEN= "MENSUAL";
    public static final String PERIOTRA= "QUINCENAL";
    public static final int PROC_FOLIO=1;
    public static final int PROC_FOVIS=2;
    public static final int PROC_AUTOS=3;
    public static final int PROC_FIVA=4;
    public static final int TPO_PRESTAM_AUTO=21;
    public static final String TABLA_PRSTAM_AUTO="prstamo_orig_creauto_paso";
    public static final String TABLA_PRSTAM="prstamo_orig";
    public static final String PARAMETRO_TABLA="loan_nbr";
    int CONTADOR_WEB_NUEVO = 1;
    int PARAM_ANT_MIN_PERM = 2;
    int TNO_CVE_PENSION = 30;
    int T_ANUAL = 2400;
    int P_ANUAL = 1200;
    int DIAS_QNA = 15;
    int DIAS_MES = 30;
    int DIAS_MES_LRG = 31;
    int QUINCENAS_ANIO = 24;
    int MESES_ANIO = 12;
    String FORMAT_SSYYMM = "yyyyMM";
    int ANUAL = 36000;
    int SSYYQQ_ENERO_2010 = 201001;
    int ANIO_2010 = 2010;
    int CVE_TIPO_IVA_MET_ANT = 2;
    int CVE_TIPO_IVA_FRON_ANT = 1;
    int CVE_TIPO_IVA_MET_ACT = 4;
    int CVE_TIPO_IVA_FRON_ACT = 3;
    String FORMATO_DOS_DIGITOS = "%02d";
    String FORMATO_SIETE_DIGITOS = "%07d";
    String FECHA_REFINANCIAMIENTO="20/09/2004";
    
    public static final int TIPO_PREST_MOTOCICLETA = 22;
    
    int DIAS_SALARIO_MINIMO=1;
    int REDONDEO_NUM=2;
    String PESOS=" pesos";
    String FORMATO_PESOS_MEX="/100 M.N";
    String CENTAVOS =" centavos";
    public static int ESTATUS_RECEPCION=1;
    String ESTATUS_PRESTO_MEN ="V";
    String TPO_PRESTO = "A";
    String COND_CRED_NORMAL = "N";
    int TPO_PAGO_REF = 3;
    

}
