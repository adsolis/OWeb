/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service;

import com.ucol.otweb.vo.*;
/**
 *
 * @author 
 */
public interface IProcesosOtorgamientoMService {

    public void primerValidacFlujoOtorgYSimulac(TransMovOtoWeb derechOtor, boolean actualizadas);

    public Double calcularImporteLiquido(int refinancia, PrstamoOrigVO prstamoOrigVO, double saldoRef);

    public PrimasGarRenVO calcularPrimas(double montoOtorgado, double primGar, double primaRen, double saldoRef);

    public boolean tienePrestamosARefinanciar(Integer numIssste);

    public MontoPlazoOtorgadoVO obtenerMontoPlazoOtorgar(int tipoPres, Double montoSolicitado, int plazoSol, double montoParam, int plazoParam, Double sueldo,String vehiculo);

    public cRamEsp obtenerRamoEspecialSiSuRamoEsEspecial(CoberturaGlobVO coberturaGlobVO, CramPagVO cramPagVO);

    public double obtenerMontoMaximoParaPrestamosSuperioresACienMil(int cveTcr);

    public CCredParamVO obtenerMontoPlazoCreditoDer(TpoCreditoVO creditoVO, int nombramiento, SueldoAuxVO sueldoRango, int antiguedad);

    public SueldoAuxVO obtenerSueldoDer(Double sueldoDer);

    public BplazaVO obtenerRamoPagadDer(DatosLaboralesVO datosLaboralesVO, boolean simulado);

    public int obtenerNombramientoPlazaDer(DatosLaboralesVO persona);

    public boolean tieneplazasAct(Integer numIssste, boolean actualizadas);

    public PrstamoOrigVO obtenerPrestamosAnteriores(Integer numIssste);

    public void updateEstatusFechTransMov(TransMovOtoWeb movOtoWeb);

    public void actAutorizaPrestamo(Double numPrestamo, int fAltaMod, int tipoCred, String ipMaquina);
    
    public boolean activarProcesoFolFov(int proceso);
    
    public void verificarEliminar(TransMovOtoWeb movOtoWeb);
}
