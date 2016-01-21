/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service.impl;

import com.ucol.otweb.dao.*;
import com.ucol.otweb.service.IProcesosOtorgamientoMService;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.utils.NumerosUtils;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.vo.*;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "procesosOtorgamientoServiceM")
public class ProcesosOtorgamientoMServiceImpl implements IProcesosOtorgamientoMService {

    @Autowired
    @Qualifier("datosLaborales")
    private IDatosLaborales datosLaboralesDAO;
    @Autowired
    @Qualifier("ramoPagaduriaDao")
    private IRamoPagaduriaDao ramoPagaduriaDao;
    @Autowired
    @Qualifier("transMovWebDao")
    private ITransaccionesMovimientosWebDao transMovWebDao;
    @Autowired
    @Qualifier("parametrosOtorgamientoDao")
    private IParametrosOtorgamientoDao parametrosOtorgamientoDao;
    @Autowired
    @Qualifier("salarioDao")
    private ISalarioDao salarioDao;
    @Autowired
    @Qualifier("credParamDao")
    private ICredParamDao credParamDao;
    @Autowired
    @Qualifier("prestamoOrigDao")
    private IPrestamoOrigDao prestamoOrigDao;
    @Autowired
    @Qualifier("recepcionSolDao")
    private IRecepcionSolicitudDao recepcionSolicitudDao;
    @Autowired
    @Qualifier("folioDao")
    private IFolioDao folioDao;
    @Autowired
    @Qualifier("sQLErrorCodesFactory")
    private SQLErrorCodesFactory sQLErrorCodesFactory;
    PropertyUtils properties = new PropertyUtils("config.properties");

    /**
     * @param sQLErrorCodesFactory the sQLErrorCodesFactory to set
     */
    public void setsQLErrorCodesFactory(SQLErrorCodesFactory sQLErrorCodesFactory) {
        this.sQLErrorCodesFactory = sQLErrorCodesFactory;
    }

    /**
     * 
     * @param derechOtor
     * @param actualizadas
     */
    public void primerValidacFlujoOtorgYSimulac(TransMovOtoWeb derechOtor, boolean actualizadas) {
        //1)	Se evalúa si el derechohabiente tiene algún crédito pendiente.
        int totCredPend = prestamoOrigDao.countNumeroPrestamosByEstatus(derechOtor.getNumIssste(), Constants.ESTATUS_RECIBIDA);
        if (totCredPend > 0) {
            derechOtor.setStatus(OtwExceptionCodes.DERECHO_CON_CREDITOS_PENDIENTES);
            updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DERECHO_CON_CREDITOS_PENDIENTES);
        }
        //2)	Sí el trabajador tiene créditos por cancelar
        int totCredCanc = prestamoOrigDao.countNumeroPrestamosByEstatus(derechOtor.getNumIssste(), Constants.ESTATUS_RECHAZO_VISUAL);
        if (totCredCanc > 0) {
            derechOtor.setStatus(OtwExceptionCodes.DERECHO_CON_CREDITOS_PENDIENTES);
            updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DERECHO_CON_CREDITOS_PENDIENTES);
        }
        //3)	Se valida si el trabajador tiene crédito de auto 
        int totCredAut = prestamoOrigDao.countNumeroPrestamosByEstatusType(derechOtor.getNumIssste(), Constants.TPO_CRED_VIG, Constants.TIPO_PREST_AUTOS);
        if (totCredAut > 0) {
            derechOtor.setStatus(OtwExceptionCodes.DERECHO_CON_CREDITOS_PENDIENTES);
            updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DERECHO_CON_CREDITOS_PENDIENTES);
        }
        //4)	Se valida que el trabajador tenga plaza asignada, y 5) que se encuentre actualizada
        if (!tieneplazasAct(derechOtor.getNumIssste(), actualizadas)) {
            derechOtor.setStatus(OtwExceptionCodes.DERECHO_CON_CREDITOS_PENDIENTES);
            updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DERECHO_CON_CREDITOS_PENDIENTES);
        }

    }

    /**
     * 
     * @param refinancia
     * @param prstamoOrigVO
     * @param saldoRef
     * @return
     */
    public Double calcularImporteLiquido(int refinancia, PrstamoOrigVO prstamoOrigVO, double saldoRef) {
        Double importeLiquido = 0.0;
        //System.out.println("ImporteLiquido"+prstamoOrigVO.getOrigLoanPrin() +">>"+ prstamoOrigVO.getWarrantyPrem() +">>"+ prstamoOrigVO.getRenewalPrem() +">>"+ saldoRef);
        if (refinancia == 1) {
            importeLiquido = prstamoOrigVO.getOrigLoanPrin() - prstamoOrigVO.getWarrantyPrem() - prstamoOrigVO.getRenewalPrem() - saldoRef;
        } else {
            importeLiquido = prstamoOrigVO.getOrigLoanPrin() - prstamoOrigVO.getWarrantyPrem();
        }
        return importeLiquido;
    }

    /**
     * 
     * @param montoOtorgado
     * @param primGar
     * @param primaRen
     * @param saldoRef
     * @return
     */
    public PrimasGarRenVO calcularPrimas(double montoOtorgado, double primGar, double primaRen, double saldoRef) {
        PrimasGarRenVO primGR = new PrimasGarRenVO();
        primGR.setPrimaGarantia(montoOtorgado * primGar);
        if (saldoRef > 0) {
            primGR.setPrimaRenovacion(montoOtorgado * primaRen);
        } else {
            primGR.setPrimaRenovacion(0.0);
        }
        return primGR;
    }

    /**
     * 
     * @param numIssste
     * @return
     */
    public boolean tienePrestamosARefinanciar(Integer numIssste) {
        boolean seRequiereRefinanciar = false;
        int countPrestamos = prestamoOrigDao.countPrestamosRefininanciamiento(numIssste);
        if (countPrestamos > 0) {
            seRequiereRefinanciar = true;
        }
        return seRequiereRefinanciar;
    }

    /**
     * 
     * @param tipoPres
     * @param montoSolicitado
     * @param plazoSol
     * @param montoParam
     * @param plazoParam
     * @param sueldo
     * @return
     */
    public MontoPlazoOtorgadoVO obtenerMontoPlazoOtorgar(int tipoPres, Double montoSolicitado, int plazoSol, double montoParam, int plazoParam, Double sueldo, String vehiculo) {
        double montoOtorgado = 0.0;
        int plazoOtorgado = 0;
        MontoPlazoOtorgadoVO otorgadoVO = new MontoPlazoOtorgadoVO();
        if (tipoPres == Constants.TIPO_PREST_COMPL || tipoPres == Constants.TIPO_PREST_ADQ_BIENES_DURADEROS || tipoPres == Constants.TIPO_PREST_ESPEC
                || tipoPres == Constants.TIPO_PREST_CONM_ANIV) {
            montoParam = montoParam * sueldo;
        }
        if (tipoPres != Constants.TIPO_PREST_ESP_PEN || tipoPres != Constants.TIPO_PREST_DAMNIFICADOS || tipoPres != Constants.TIPO_PREST_EXC_PEN
                || tipoPres != Constants.TIPO_PREST_EXT_DAM) {
            if (montoSolicitado > montoParam) {
                montoOtorgado = montoParam;
            } else {
                montoOtorgado = montoSolicitado;
            }

            if (plazoSol > plazoParam) {
                plazoOtorgado = plazoParam;
            } else {
                plazoOtorgado = plazoSol;
            }

        } else {
            montoOtorgado = montoParam;
            plazoOtorgado = plazoParam;
        }
        
        System.out.println("vehiculo plazo-----"+vehiculo);
        if(vehiculo != null && !vehiculo.isEmpty() && vehiculo.equals("M")){
            plazoOtorgado=48;
        }
        otorgadoVO.setMontoOtorgado(montoOtorgado);
        otorgadoVO.setPlazoOtorgado(plazoOtorgado);
        return otorgadoVO;
    }

    /**
     * 
     * @param coberturaGlobVO
     * @param cramPagVO
     * @return
     */
    public cRamEsp obtenerRamoEspecialSiSuRamoEsEspecial(CoberturaGlobVO coberturaGlobVO, CramPagVO cramPagVO) {
        int banderaEsDF = 0;
        int counRamoEspePorRamoPag = 0;
        int banderaEsRamoEspecial = 0;
        cRamEsp ramEspReg = new cRamEsp();
        List<cRamEsp> ramosEspeciales = null;
        int counRamoEspePorRamo = ramoPagaduriaDao.countRamoEspecial(cramPagVO.getRamoCat(), null);
        if (counRamoEspePorRamo > 0) {
            banderaEsDF = 1;
            banderaEsRamoEspecial = 1;
            counRamoEspePorRamoPag = ramoPagaduriaDao.countRamoEspecial(cramPagVO.getRamoCat(), cramPagVO.getPagaCat());
        } else {
            banderaEsDF = 1;
        }
        if (counRamoEspePorRamoPag > 0) {
            banderaEsRamoEspecial = 1;
            cRamEsp ramoEsp = new cRamEsp();
            ramoEsp.setCveEntidad(coberturaGlobVO.getEntidad().getCveEntidad());
            ramoEsp.setCveDeleg(coberturaGlobVO.getDelegacion().getCveDeleg());
            ramoEsp.setCveUniad(coberturaGlobVO.getUnidad().getCveUniad());
            ramoEsp.setNumRamoAnt(cramPagVO.getRamoCat().doubleValue());
            ramoEsp.setNumPagaduria(cramPagVO.getPagaCat());
            ramosEspeciales = ramoPagaduriaDao.obtenerInfRamoEspecial(ramoEsp);
            if (ramosEspeciales != null && ramosEspeciales.size() > 0) {
                banderaEsDF = 1;
                ramEspReg = ramosEspeciales.get(0);
            } else {
                banderaEsDF = 0;
            }
        } else {
            banderaEsDF = 0;
            banderaEsRamoEspecial = 0;
        }
        ramEspReg.setBandAuxEsDf(banderaEsDF);
        ramEspReg.setBandAuxEsRamEsp(banderaEsRamoEspecial);
        return ramEspReg;
    }

    /**
     * 
     * @param cveTcr
     * @return
     */
    public double obtenerMontoMaximoParaPrestamosSuperioresACienMil(int cveTcr) {
        CParamOtorgaVO paramOtorgaVO = null;
        double montoMaximo = 0.0;
        if (cveTcr == Constants.TIPO_PREST_ADQ_BIENES_DURADEROS || cveTcr == Constants.TIPO_PREST_ESPEC || cveTcr == Constants.TIPO_PREST_EXT_DAM || cveTcr == Constants.TIPO_PREST_CONM_ANIV) {
            if (cveTcr == Constants.TIPO_PREST_ADQ_BIENES_DURADEROS) {
                paramOtorgaVO = parametrosOtorgamientoDao.obtenerParametroByID(Constants.CVE_PARAM_BIENES);
            }
            if (cveTcr == Constants.TIPO_PREST_ESPEC) {
                paramOtorgaVO = parametrosOtorgamientoDao.obtenerParametroByID(Constants.CVE_PARAM_ESP);
            }
            if (cveTcr == Constants.TIPO_PREST_EXT_DAM) {
                paramOtorgaVO = parametrosOtorgamientoDao.obtenerParametroByID(Constants.CVE_PARAM_EXT_D);
            }
            if (cveTcr == Constants.TIPO_PREST_CONM_ANIV) {
                paramOtorgaVO = parametrosOtorgamientoDao.obtenerParametroByID(Constants.CVE_PARAM_CON_ANI);
            }
            montoMaximo = paramOtorgaVO.getValParamOtorga();
        } else {
            //monto para los prestamos no que no rebasan los 100000
            montoMaximo = 100000.0;
        }
        return montoMaximo;
    }

    /**
     * 
     * @param creditoVO
     * @param nombramiento
     * @param sueldoRango
     * @param antiguedad
     * @return
     */
    public CCredParamVO obtenerMontoPlazoCreditoDer(TpoCreditoVO creditoVO, int nombramiento, SueldoAuxVO sueldoRango, int antiguedad) {
        Integer maxAntFin = null;
        List<CCredParamVO> credParams = null;
        //En el caso de que el nombramiento sea pensionado se obtiene la antiguedad Maxima, si no se obtiene se truena la funcion
        if (nombramiento == Constants.C_PENSION) {
            maxAntFin = credParamDao.obtenerMaxAntFin(creditoVO.getCveTcr());
            antiguedad = maxAntFin;
            if (maxAntFin == null) {
                return null;
            }
        }
        //System.out.println(">>>>>>>"+creditoVO.getFactorRango() +">>>>>>>>>"+ creditoVO.getFactorAntig() +">>>>>>>>>"+ sueldoRango.getSalarioRango() +">>>>>>>>>"+  antiguedad);
        //De acuerdo al factorRango y al factorAntiguedad se obtiene los parametos requeridos del Credito con respecto al monto
        CCredParamVO ccpvo = new CCredParamVO();
        ccpvo.setCveTcr(creditoVO.getCveTcr());
        ccpvo.setStatCondic("1");
        if (creditoVO.getFactorRango().trim().equals("1")) {
            if (creditoVO.getFactorAntig().trim().equals("1")) {
                credParams = credParamDao.obtenerCredParam(ccpvo, sueldoRango.getSalarioRango(), antiguedad);
            } else {
                credParams = credParamDao.obtenerCredParam(ccpvo, sueldoRango.getSalarioRango(), 0);
            }
        } else if (creditoVO.getFactorRango().trim().equals("0")) {
            if (creditoVO.getFactorAntig().trim().equals("1")) {
                credParams = credParamDao.obtenerCredParam(ccpvo, 0, antiguedad);
            } else {
                credParams = credParamDao.obtenerCredParam(ccpvo, 0, 0);
            }
        }
        //Si se obtienen los parametros del credito se llena el objeto de lo contrario se termina la funcion
        if (credParams != null && credParams.size() > 0) {
            ccpvo = credParams.get(0);
        } else {
            ccpvo = null;
        }
        //Se obtiene el plazo del credito para damnificados
        if (creditoVO.getCveTcr() == Constants.TIPO_PREST_DAMNIFICADOS || creditoVO.getCveTcr() == Constants.TIPO_PREST_EXT_DAM) {
            Integer plazoDamnificado = null;
            plazoDamnificado = credParamDao.obtenerPlazoDaminificados();
            if (plazoDamnificado != null) {
                ccpvo.setPlazoCre(plazoDamnificado);
            } else {
                ccpvo.setPlazoCre(0);
            }
        }
        return ccpvo;
    }

    /**
     * 
     * @param sueldoDer
     * @return
     */
    public SueldoAuxVO obtenerSueldoDer(Double sueldoDer) {
        Double rangoSalario = 0.0;
        SueldoAuxVO sueldoAuxVO = new SueldoAuxVO();
        CSalarioVO salario = salarioDao.obtenerSalarioMin();
        CParamOtorgaVO paramOtorgaVO = parametrosOtorgamientoDao.obtenerParametroByID(1);
        Double salarioTope = salario.getSalarioMin() * paramOtorgaVO.getValParamOtorga();
        if (sueldoDer > salarioTope) {
            sueldoDer = salarioTope;
        }
        if (salario.getSalarioMin() == 0.0) {
            rangoSalario = 0.0;
        } else {
            rangoSalario = sueldoDer / salario.getSalarioMin();
            rangoSalario = NumerosUtils.redondeoNumero(rangoSalario, Constants.REDONDEO_NUM);
        }
        //Se regresa el sueldo obtenido a travez del salarioTope
        sueldoAuxVO.setSueldoCalDeTope(sueldoDer);
        sueldoAuxVO.setSalarioRango(rangoSalario);
        return sueldoAuxVO;
    }

    /**
     * 
     * @param datosLaboralesVO
     * @return
     */
    public BplazaVO obtenerRamoPagadDer(DatosLaboralesVO datosLaboralesVO, boolean simulado) {
        properties.cargaArchivo();
        BplazaVO bplazaVO = new BplazaVO();
        Double sueldoDer = 0.0;
        List<PzaPenVO> pzaPenDer = datosLaboralesDAO.buscarPlazaPensionado(datosLaboralesVO, properties.getParametro("conection.sipesic"), !simulado);
        if (pzaPenDer != null && pzaPenDer.size() > 0) {
            sueldoDer = datosLaboralesDAO.obtenerSumaSueldoPlazaPen(datosLaboralesVO.getNumIssste(), !simulado);
            bplazaVO.setSueldoDer(sueldoDer);
            bplazaVO.setNumRamo(pzaPenDer.get(0).getNumRamo().intValue());
            bplazaVO.setNumPagaduria(pzaPenDer.get(0).getNumPagaduria());
            bplazaVO.setTnoCve(Constants.C_PENSION);
        } else {
            List<PlazaVO> plazaDer = datosLaboralesDAO.buscarPlazasAct(datosLaboralesVO.getNumIssste(), properties.getParametro("conection.sipesic"), !simulado);
            sueldoDer = datosLaboralesDAO.obtenerSumaSueldoPlaza(datosLaboralesVO.getNumIssste(), !simulado);
            bplazaVO.setSueldoDer(sueldoDer);
            bplazaVO.setNumRamo(plazaDer.get(0).getNumRamo().intValue());
            bplazaVO.setNumPagaduria(plazaDer.get(0).getNumPagaduria());
            bplazaVO.setTnoCve(plazaDer.get(0).getTnoCve().intValue());
        }
        return bplazaVO;
    }

    /**
     * 
     * @param persona
     * @return
     */
    public int obtenerNombramientoPlazaDer(DatosLaboralesVO persona) {
        int nombramiento = 0;
        List<CtnoCveVO> nombSDer = datosLaboralesDAO.obtenerNombEnPlaza(persona);
        if (nombSDer != null && nombSDer.size() > 0) {
            nombramiento = nombSDer.get(0).getTnoCve().intValue();
        } else {
            nombramiento = 30;
        }
        return nombramiento;
    }

    /**
     * 
     * @param numIssste
     * @param actualizadas
     * @return
     */
    public boolean tieneplazasAct(Integer numIssste, boolean actualizadas) {
        properties.cargaArchivo();
        boolean siTiene = false;
        DatosLaboralesVO laboralesVO = new DatosLaboralesVO();
        laboralesVO.setNumIssste(numIssste);
        List<PzaPenVO> plazasPen = datosLaboralesDAO.buscarPlazaPensionado(laboralesVO, properties.getParametro("conection.sipesic"), actualizadas);
        if (plazasPen != null && plazasPen.size() > 0) {
            siTiene = true;
        } else {
            List<PlazaVO> plazasVO = datosLaboralesDAO.buscarPlazasAct(numIssste, properties.getParametro("conection.sipesic"), actualizadas);
            if (plazasVO != null && plazasVO.size() > 0) {
                siTiene = true;
            }
        }
        return siTiene;
    }

    /**
     * 
     * @param numIssste
     * @return
     */
    public PrstamoOrigVO obtenerPrestamosAnteriores(Integer numIssste) {
        DirectoVO directoVO = null;
        PrstamoOrigVO prestamo = null;
        List<PrstamoOrigVO> prestamosAnteriores = null;
        DatosLaboralesVO laboralesVO = new DatosLaboralesVO();
        laboralesVO.setNumIssste(numIssste);
        List<DirectoVO> objListDirecto = datosLaboralesDAO.busquedaDerechohabienteDirecto(laboralesVO);
        if (objListDirecto != null && objListDirecto.size() > 0) {
            directoVO = objListDirecto.get(0);
        }
        if (directoVO.getNumIssste() != null) {
            prestamosAnteriores = prestamoOrigDao.bucarPrestamoWeb(directoVO.getNumIssste());
        }
        if (prestamosAnteriores != null && prestamosAnteriores.size() > 0) {
            DecimalFormat num = new DecimalFormat("###");
            String numPrest = num.format(prestamosAnteriores.get(0).getLoanNbr());
            String fechaPrestamo = DateUtils.fechaPrestamoString(prestamosAnteriores.get(0).getLoanIssue_date());
            prestamo = prestamosAnteriores.get(0);
            prestamo.setAuxNumPrestamo(numPrest);
            prestamo.setAuxFechaPrestamo(fechaPrestamo.toUpperCase());
        }
        return prestamo;
    }

    /**
     * 
     * @param movOtoWeb
     */
    public void updateEstatusFechTransMov(TransMovOtoWeb movOtoWeb) {
        movOtoWeb.setComponente(Constants.OTOWEB);
        transMovWebDao.updatePorIsssteFolio(movOtoWeb);

    }

    /**
     * 
     * @param numPrestamo
     * @param fAltaMod
     * @param tipoCred
     */
    public void actAutorizaPrestamo(Double numPrestamo, int fAltaMod, int tipoCred, String ipMaquina) {
        prestamoOrigDao.updatePrestamo(numPrestamo, fAltaMod, tipoCred, ipMaquina);
        if (fAltaMod == 1) {
            prestamoOrigDao.insertarProcTes(numPrestamo);
        }
    }

    public boolean activarProcesoFolFov(int proceso) {
        properties.cargaArchivo();
        boolean activa = false;
        Integer estatus = null;
        //System.out.println("Proceso" +proceso);
        switch (proceso) {
            case Constants.PROC_FOLIO:
                estatus = folioDao.obtenerEstatusProc(properties.getParametro("funcion.proceso.folios"));
                break;
            case Constants.PROC_AUTOS:
                estatus = folioDao.obtenerEstatusProc(properties.getParametro("funcion.proceso.pautos"));
                break;
            case Constants.PROC_FOVIS:
                estatus = folioDao.obtenerEstatusProc(properties.getParametro("funcion.proceso.foviss"));
                break;
            case Constants.PROC_FIVA:
                estatus = folioDao.obtenerEstatusProc(properties.getParametro("funcion.proceso.fiva"));
                break;
        }

        if (estatus != null && estatus == 1) {
            activa = true;
        }
        
        //System.out.println("activa" +activa);
        return activa;
    }

    public void verificarEliminar(TransMovOtoWeb movOtoWeb) {
        /*int cuentaPrestamos=prestamoOrigDao.countNumeroPrestamosNoCancelados(movOtoWeb.getFolio(), movOtoWeb.getTipo_prst());
        if(cuentaPrestamos>0){
        //Mensaje de Que ya fue otorgado el folio
        }*/
        //Folio Rechazado
        int cuentaMotivos = recepcionSolicitudDao.countMotivosSolFolio(movOtoWeb.getFolio(), movOtoWeb.getTipo_prst());
        if (cuentaMotivos > 0) {
            MotivosSolVO motivosSolVO = new MotivosSolVO();
            motivosSolVO.setFolioSol(movOtoWeb.getFolio());
            motivosSolVO.setCveTcr(movOtoWeb.getTipo_prst());
            boolean eliminar = recepcionSolicitudDao.eliminarMotivoSol(motivosSolVO);
            if (eliminar) {
                RecepcionVO recepcionVO = new RecepcionVO();
                recepcionVO.setAnioSol(DateUtils.anioActual());
                recepcionVO.setFolioSol(movOtoWeb.getFolio());
                recepcionVO.setCveTcr(movOtoWeb.getTipo_prst());
                recepcionVO.setNumIssste(movOtoWeb.getNumIssste());
                recepcionSolicitudDao.eliminarRecepcion(recepcionVO);
            }
            SolicitudVO solicitudVO = new SolicitudVO();
            solicitudVO.setFolio_sol(movOtoWeb.getFolio());
            solicitudVO.setCve_tcr(movOtoWeb.getTipo_prst());
            recepcionSolicitudDao.eliminarSolicitud(solicitudVO);

        }
    }
}
