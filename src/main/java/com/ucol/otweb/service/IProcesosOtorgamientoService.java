/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service;

import com.ucol.otweb.vo.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 
 */
public interface IProcesosOtorgamientoService {

    void actualizaCanRec(int folioSol, int cveTcr, int numIssste, int anioSol);

    void actualizaContador();

    /**
     *
     * @param directo
     * @return
     */
    CAntiguedadVO calAnt(DirectoVO directo);

    double calFiva(int cveEntidad, int cp);

    double calIvaDif(double intDif, double fiva);

    /**
     * calcula la tasa de las primas
     *
     * @param tasa
     * @param fiva
     * @return
     */
    double calRPrim(double tasa, double fiva);

    /**
     * Calcula la taza quincenal aplicable por porveedor (R)
     *
     * @param tazaInt Tasa de Interes Anual Nominal.
     * @param tnoCve
     * @return
     */
    double calTasa(double tasaInt, int tnoCve);

    double calcIntDia(int tnoCve, double ipf, double tasa);

    double calcularCapacidadPago(int numIssste, int cveRamo, String cvePagaduria, double sueldoIssste, int tnoCve);
    
    double obtenDsctoFovi(int numIssste, int cveRamo, String cvePagaduria);

    CalculoDescuentoVO calcularDescuento(DescuentoProcVO condiciones, double fiva);

    boolean existeFolio(int folio, int cveTcr, CoberturaGlobVO cobertura);

    RechazoVO generaRechazos(int numeroIssste, int cveTcr, int maxCred, double sdoTotCap);

    TransMovOtoWeb generaRegistroTrans(Integer numIssste, Integer numFolio, Integer CveTcr, CajaPagadoraVO cajaPagadoraVO, String ipMaquina);

    DiferimientoVO obtenerIntIvaDif(int tnoCve, double tazaInt, int qnaDiferimiento, int refinancia, double montoOto, String fechaFinRef, double ultPagoRef, int cveEntidad, int cp);

    double obtenerSalarioTope();

    RangoSalVO obtenerSueldo(double numIssste, int tnoCve, boolean simulado);

    QuinDifVO obtieneQuincenasDiferimiento(Date fecha, int cveRamo, String cvePagaduria, int tnoCve);

    public PresolicitudVO otorgaPrestamo(PresolicitudVO presol, RefinanciamientoVO refinanciamientoVO, int funcion, int isRef, String vehiculo);

    /**
     * el proceso de desuento realiza las validaciones y obtiene los calculos de
     * los descuentos
     *
     * @param aProcesar informacion necesaria para calcular los descuentos
     * @return
     */
    DescuentoVO procesarDscto(DescuentoProcVO aProcesar,double fiva);

    int registroRecepcion(PresolicitudVO presolicitudVO);

    public ReporteVO getPrestamosAnterior(Double numIssste);
    public RefinanciamientoVO obtieneRefinanciamiento(int numIssste, int tpoCredito, String tnoCve, double origLoanPrin,
            double intRate, int cveEntidad, int ldCodigoPos, int simulacion, String ipEquipo) throws ParseException ;
}
