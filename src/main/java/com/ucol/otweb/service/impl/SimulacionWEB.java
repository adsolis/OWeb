package com.ucol.otweb.service.impl;

import com.ucol.otweb.dao.IAfectacionDao;
import com.ucol.otweb.dao.ICoberturaDao;
import com.ucol.otweb.dao.IDatosLaborales;
import com.ucol.otweb.dao.IDeduccionesDao;
import com.ucol.otweb.dao.IFolioDao;
import com.ucol.otweb.dao.IParametrosOtorgamientoDao;
import com.ucol.otweb.dao.IPrestamoOrigDao;
import com.ucol.otweb.dao.IProyeccionDao;
import com.ucol.otweb.dao.IRamoPagaduriaDao;
import com.ucol.otweb.dao.IRecepcionSolicitudDao;
import com.ucol.otweb.dao.ITipoCreditoDAO;
import com.ucol.otweb.service.*;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.utils.LetrasUtil;
import com.ucol.otweb.utils.NumerosUtils;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.vo.BplazaVO;
import com.ucol.otweb.vo.CAfectVO;
import com.ucol.otweb.vo.CAntiguedadVO;
import com.ucol.otweb.vo.CCredParamVO;
import com.ucol.otweb.vo.CParamOtorgaVO;
import com.ucol.otweb.vo.CajaPagadoraVO;
import com.ucol.otweb.vo.CalculoDescuentoVO;
import com.ucol.otweb.vo.CoberturaGlobVO;
import com.ucol.otweb.vo.CramPagVO;
import com.ucol.otweb.vo.CtnoCveVO;
import com.ucol.otweb.vo.DatosLaboralesVO;
import com.ucol.otweb.vo.DescuentoProcVO;
import com.ucol.otweb.vo.DescuentoVO;
import com.ucol.otweb.vo.DiferimientoVO;
import com.ucol.otweb.vo.DirectoVO;
import com.ucol.otweb.vo.FolioVO;
import com.ucol.otweb.vo.MontoPlazoOtorgadoVO;
import com.ucol.otweb.vo.PresolicitudVO;
import com.ucol.otweb.vo.PrimasGarRenVO;
import com.ucol.otweb.vo.ProyeccionVO;
import com.ucol.otweb.vo.PrstamoOrigVO;
import com.ucol.otweb.vo.QuinDifVO;
import com.ucol.otweb.vo.RechazoVO;
import com.ucol.otweb.vo.RefinanciamientoVO;
import com.ucol.otweb.vo.SueldoAuxVO;
import com.ucol.otweb.vo.TpoCreditoVO;
import com.ucol.otweb.vo.TransMovOtoWeb;
import com.ucol.otweb.vo.cRamEsp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "simulacionWeb")
public class SimulacionWEB implements ISimulacionWEB {

    @Autowired
    @Qualifier("tipoCreditoDAO")
    private ITipoCreditoDAO tipoCreditoDAO;
    @Autowired
    @Qualifier("datosLaborales")
    private IDatosLaborales datosLaborales;
    @Autowired
    @Qualifier("deduccionesDao")
    private IDeduccionesDao deduccionesDao;
    @Autowired
    @Qualifier("recepcionSolDao")
    private IRecepcionSolicitudDao solicitudDao;
    @Autowired
    @Qualifier("coberturaDao")
    private ICoberturaDao coberturaDao;
    @Autowired
    @Qualifier("ramoPagaduriaDao")
    private IRamoPagaduriaDao ramoPagaduriaDao;
    @Autowired
    @Qualifier("afectacionDao")
    private IAfectacionDao afectacionDao;
    @Autowired
    @Qualifier("prestamoOrigDao")
    private IPrestamoOrigDao prestamoOrigDao;
    @Autowired
    @Qualifier("proyeccionDao")
    private IProyeccionDao proyeccionDao;
    @Autowired
    @Qualifier("folioDao")
    private IFolioDao folioDao;
    @Autowired
    @Qualifier("validacionFolioWeb")
    private IValidacionFolioWeb validacionFolioWeb;
    @Autowired
    @Qualifier("validacionGeneralWeb")
    private IValidacionesGeneralesWeb valGeneralesWeb;
    @Autowired
    @Qualifier("procesosOtorgamientoService")
    private IProcesosOtorgamientoService procesosOtorgamientoService;
    @Autowired
    @Qualifier("parametrosOtorgamientoDao")
    private IParametrosOtorgamientoDao parametrosOtorgamientoDao;
    @Autowired
    @Qualifier("procesosOtorgamientoServiceM")
    private IProcesosOtorgamientoMService procesosOtorgamientoMService;
    @Autowired
    @Qualifier("sQLErrorCodesFactory")
    private SQLErrorCodesFactory sQLErrorCodesFactory;
    PropertyUtils properties = new PropertyUtils("config.properties");
    @Autowired
    @Qualifier("otorgamientoWeb")
    private IOtorgamientoWEB iOtorgamientoWEB;

    /**
     * @param sQLErrorCodesFactory the sQLErrorCodesFactory to set
     */
    public void setsQLErrorCodesFactory(SQLErrorCodesFactory sQLErrorCodesFactory) {
        this.sQLErrorCodesFactory = sQLErrorCodesFactory;
    }

    /**
     * Se obtinene los tipos de credito para otorgamiento via WEB
     *
     * @return
     */
    public List obtenerTiposCreditoWEB() {

        System.out.println("Lista de préstamos ---->>>>");
       // boolean activaClave = procesosOtorgamientoMService.activarProcesoFolFov(Constants.PROC_AUTOS);
        TpoCreditoVO tpoCredMot = new TpoCreditoVO();
        tpoCredMot.setCveTcr(Constants.TIPO_PREST_MOTOCICLETA);
        tpoCredMot.setNomTcr("PARA ADQUISICION DE MOTOCICLETAS");
        List tipoPrestamos = tipoCreditoDAO.obtenerTiposCredito(true);
        tipoPrestamos.add(tpoCredMot);
        return tipoPrestamos;
    }

    /**
     * @param tipoCreditoDAO the tipoCreditoDAO to set
     */
    public void setTipoCreditoDAO(ITipoCreditoDAO tipoCreditoDAO) {
        this.tipoCreditoDAO = tipoCreditoDAO;
    }

    public PresolicitudVO simulacionOtorgamiento(TransMovOtoWeb derechOtor, int altaMod, boolean simulado, String vehiculo) {
        properties.cargaArchivo();
        PresolicitudVO presolicitudVO = new PresolicitudVO();
        PrstamoOrigVO prstamoOrigVO = new PrstamoOrigVO();
        CajaPagadoraVO cajaPagadoraVO = new CajaPagadoraVO();
        List<PrstamoOrigVO> prestamos = null;
        CtnoCveVO ctnoCveVO = null;
        CramPagVO ramPagVO = null;
        CAfectVO afectVO = null;
        FolioVO folioVO = null;
        DirectoVO directoVO = null;
        cRamEsp ramEsp = null;
        DiferimientoVO diferimientoVO = null;
        CoberturaGlobVO coberturaDer = null;
        DatosLaboralesVO laboralesVO = new DatosLaboralesVO();
        laboralesVO.setNumIssste(derechOtor.getNumIssste());
        presolicitudVO.setAnioSol(DateUtils.anioActual());
        presolicitudVO.setFechaSol(new Date());
        presolicitudVO.setFechaAud(new Date());
        presolicitudVO.setIpMaquina(derechOtor.getIp_equipo());
        boolean montoAceptado = true;
        boolean seRequiereRefinanciar = false;
        int validFolio = 0;
        int refinancia = 0;
        double ultPagoRef1 = 0;
        double montoMaximoCred = 0.0;
        boolean banderaPlazas = false;
        double sdoTotCap = 0.0;
        double sdoCapDesQna = 0.0;
        int maximoCreditos = 0;
        String firstPayPer = "";
        String tpoPrestoFolio = "";
        int tipoPrestAuxAuto = 0;
        String fechaFinRef = "0";
        Calendar c = Calendar.getInstance();
        double deduccionesVO = procesosOtorgamientoService.obtenDsctoFovi(derechOtor.getNumIssste(), derechOtor.getRamo(), derechOtor.getPagad());

        presolicitudVO.setDeduccionesVO(deduccionesVO);
        directoVO = valGeneralesWeb.buscarPersona(laboralesVO);
        c.setTime(directoVO.getFecNac());
        presolicitudVO.setDiaFec(c.get(Calendar.DAY_OF_MONTH));
        presolicitudVO.setMesFec(c.get(Calendar.MONTH) + 1);
        presolicitudVO.setAnioFEc(c.get(Calendar.YEAR));

        if (directoVO.getTdirecto().trim().equals("P")) {
            presolicitudVO.setPeriodicidad(Constants.PERIOPEN);
        } else if (directoVO.getTdirecto().trim().equals("T")) {
            presolicitudVO.setPeriodicidad(Constants.PERIOTRA);
        }
        if (!simulado) {
            banderaPlazas = true;
        }
        //Validaciones de otorgamiento
        procesosOtorgamientoMService.primerValidacFlujoOtorgYSimulac(derechOtor, banderaPlazas);
        CAntiguedadVO antiguedadVO = procesosOtorgamientoService.calAnt(directoVO);
        presolicitudVO.setAntiguedad(antiguedadVO);
        //int nombramiento = procesosOtorgamientoMService.obtenerNombramientoPlazaDer(laboralesVO);
        BplazaVO ramPagPlaza = procesosOtorgamientoMService.obtenerRamoPagadDer(laboralesVO, simulado);
        int nombramiento = ramPagPlaza.getTnoCve();
        // System.out.println("Antiguedad==>>>>>>>>" + antiguedadVO.getAntiguedad() + "nombramiento>>" + nombramiento);
        if (nombramiento != Constants.C_PENSION) {
            if (!simulado) {
                if (!antiguedadVO.isAntiguedadPermitida()) {
                    derechOtor.setStatus(OtwExceptionCodes.ANTIGUEDAD_NO_PERMITIDA);
                    procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ANTIGUEDAD_NO_PERMITIDA);
                }
            } else {
                if (antiguedadVO.getAntiguedad() <= 0) {
                    derechOtor.setStatus(OtwExceptionCodes.ES_NECESARIO_ACLARACION_FECHA_ING);
                    procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ES_NECESARIO_ACLARACION_FECHA_ING);
                }
            }
        } else {
            if (antiguedadVO.getAntiguedad() <= 0) {
                derechOtor.setStatus(OtwExceptionCodes.ES_NECESARIO_ACLARACION_FECHA_ING);
                procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ES_NECESARIO_ACLARACION_FECHA_ING);
            }
        }
        //bandera para nuevo registro
        if (altaMod == Constants.TIPO_OPER_ALTA) {
            Integer estSol = solicitudDao.obtenerEstatusSolicitudOtorgada(derechOtor.getNumIssste(), derechOtor.getRfc());
            if (estSol != null) {
                if (estSol == Constants.ESTATUS_RECHAZO_VISUAL || estSol == Constants.ESTATUS_PRESTAMO_OTORGADO) {
                    derechOtor.setStatus(OtwExceptionCodes.SOLICITUD_OTORGADA);
                    procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.SOLICITUD_OTORGADA);
                }
                if (estSol == Constants.ESTATUS_RECHAZO_OTORGAMIENTO) {
                    if (simulado) {
                        presolicitudVO.setAltaModFluj(Constants.TIPO_OPER_MOD_REGRESO);
                        derechOtor.setStatus(OtwExceptionCodes.DERECHO_CON_SOLICITUD_OTORGADA);
                        procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DERECHO_CON_SOLICITUD_OTORGADA);

                    } else {
                        presolicitudVO.setAltaModFluj(Constants.TIPO_OPER_MOD_REGRESO);
                        return presolicitudVO;
                    }
                }
            }
        }
        TpoCreditoVO creditoVO = tipoCreditoDAO.obtenerTipoCredito(derechOtor.getTipo_prst());
        //System.out.println("creditoVO.getOtorgMax();>>><< " + creditoVO.getOtorgMax());
        maximoCreditos = creditoVO.getOtorgMax();

        //Se valida que el folio tenga un valor mayor a 0 y se encuentre en la base
        if (derechOtor.getFolio() != null && derechOtor.getTipo_prst() > 0) {
            validFolio = validacionFolioWeb.validaFolioGeneralSolicitud(derechOtor, nombramiento);
            if (validFolio == 1) {
                derechOtor.setStatus(OtwExceptionCodes.SOLICITUD_OTORGADA);
                procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.SOLICITUD_OTORGADA);
            } else if (validFolio == 2) {
                if (derechOtor.getTipo_prst() == 15 && (derechOtor.getRamo() != 26 && derechOtor.getRamo() != 226 && derechOtor.getRamo() != 389)) {
                    derechOtor.setStatus(OtwExceptionCodes.PRESTAMO_EXCLUSIVO_PARA_PENSIONADO);
                    procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.PRESTAMO_EXCLUSIVO_PARA_PENSIONADO);
                }
            }
        }
        presolicitudVO.setFolioSol(derechOtor.getFolio());
        presolicitudVO.setTpoCreditoVO(creditoVO);
        presolicitudVO.setCveTrc(creditoVO.getCveTcr());
        presolicitudVO.setDirecto(directoVO);
        presolicitudVO.setUsuario(Constants.OPERADOR_WEB);
        presolicitudVO.setComponenteCVE(Constants.OTOWEB);
        prstamoOrigVO.setModoPago(Constants.MODO_PAGO);
        prstamoOrigVO.setTipoCuenta(Constants.TIPO_CUENTA);
        prstamoOrigVO.setAnioFolio(DateUtils.anioActual());
        prstamoOrigVO.setIsssteNbr(presolicitudVO.getDirecto().getNumIssste());

        if (derechOtor.getCveEntidad() > 0 && derechOtor.getCveDeleg() > 0) {
            coberturaDer = valGeneralesWeb.validarCoberturaUsuarioOtorWeb(derechOtor.getCveEntidad(), derechOtor.getCveDeleg(), derechOtor.getCveUniad(), derechOtor.getCveOficina());
        }
        presolicitudVO.setCoberturaGlobVO(coberturaDer);

        // BplazaVO ramPagPlaza = procesosOtorgamientoMService.obtenerRamoPagadDer(laboralesVO);
        if (ramPagPlaza.getNumRamo() != null && ramPagPlaza.getNumPagaduria() != null) {
            ctnoCveVO = datosLaborales.obtenerObjCTCve(ramPagPlaza.getTnoCve());
            ramPagVO = ramoPagaduriaDao.obtenerRamoPagById(ramPagPlaza.getNumRamo(), ramPagPlaza.getNumPagaduria());
            folioVO = validacionFolioWeb.obtenerAfectTPrestoDeFolio(derechOtor.getTipo_prst(), derechOtor.getFolio());
            afectVO = afectacionDao.obtenerCatAfectacionByID(folioVO.getCveAfectaPresup());

        }
        presolicitudVO.setNumRamo(ramPagPlaza.getNumRamo());
        presolicitudVO.setNumPagaduria(ramPagPlaza.getNumPagaduria());
        presolicitudVO.setCtnoCveVO(ctnoCveVO);
        presolicitudVO.setCramPagVO(ramPagVO);
        prstamoOrigVO.setTipoPresup(folioVO.getTpo_presto());
        prstamoOrigVO.setCveAfect(folioVO.getCveAfectaPresup());
        prstamoOrigVO.setTnoCve(String.valueOf(presolicitudVO.getCtnoCveVO().getTnoCveSic()));
        presolicitudVO.setcAfectVO(afectVO);

        SueldoAuxVO sueldoCalculado = procesosOtorgamientoMService.obtenerSueldoDer(ramPagPlaza.getSueldoDer());
        presolicitudVO.setSueldoMensual(sueldoCalculado.getSueldoCalDeTope());
        //System.out.println("-Sueldo-" + sueldoCalculado.getSueldoCalDeTope() + "*SalarioRango**" + sueldoCalculado.getSalarioRango());
        if (!simulado) {
            if ((creditoVO.getFactorRango() == null && Integer.parseInt(creditoVO.getFactorRango()) < 0) || (creditoVO.getFactorAntig() == null && Integer.parseInt(creditoVO.getFactorAntig()) < 0)) {
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_CUMPLE_ANTIGUEDAD);
            }
        }
        CCredParamVO parametrosCredito = procesosOtorgamientoMService.obtenerMontoPlazoCreditoDer(creditoVO, nombramiento, sueldoCalculado, antiguedadVO.getAntiguedad());
        if (parametrosCredito == null) {
            derechOtor.setStatus(OtwExceptionCodes.NO_CUENTA_CON_CAPACIDAD_PAGO);
            procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_CUENTA_CON_CAPACIDAD_PAGO);
        }

        //System.out.println("parametros" + parametrosCredito.getMontoCre() + "*" + parametrosCredito.getPrimaGarant() + "*" + parametrosCredito.getPlazoCre());
        prstamoOrigVO.setIntRate(parametrosCredito.getTasaInt());

        //Cambio del prestamo de 21 a 16
        if (creditoVO.getCveTcr() == Constants.TPO_PRESTAM_AUTO) {
            tipoPrestAuxAuto = creditoVO.getCveTcr();
            creditoVO.setCveTcr(Constants.TIPO_PREST_ADQ_BIENES_DURADEROS);
        }
        //Se obtiene el monto maximo que se tienen para aquellos prestamos mayores a 100000
        montoMaximoCred = procesosOtorgamientoMService.obtenerMontoMaximoParaPrestamosSuperioresACienMil(creditoVO.getCveTcr());

        if (simulado) {
            //Verificacion si es ramoEspecial
            List<FolioVO> foliosAux = folioDao.obtenerFolioSolicitud(folioVO);
            if (foliosAux != null && foliosAux.size() > 0) {
                tpoPrestoFolio = foliosAux.get(0).getTpo_presto();
            }
            if (presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad() == Constants.ENTIDAD_DF && tpoPrestoFolio.trim().equals(Constants.TIPO_PRESTO)) {
                ramEsp = procesosOtorgamientoMService.obtenerRamoEspecialSiSuRamoEsEspecial(presolicitudVO.getCoberturaGlobVO(), presolicitudVO.getCramPagVO());
                if (ramEsp.getBandAuxEsDf() == 0) {
                    if (ramEsp.getBandAuxEsRamEsp() == 0) {
                        derechOtor.setStatus(OtwExceptionCodes.FOLIO_DF_USTED_LABORA_DEPEND_NO_DF);
                        procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.FOLIO_DF_USTED_LABORA_DEPEND_NO_DF);
                    } else {
                        derechOtor.setStatus(OtwExceptionCodes.FOLIO_DIFERENT_A_LA_DELEGACION_QUE_USTED_LABORA);
                        procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.FOLIO_DIFERENT_A_LA_DELEGACION_QUE_USTED_LABORA);
                    }
                } else {
                    if (ramEsp.getBandAuxEsRamEsp() == 1) {
                        if (presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad() != ramEsp.getCveEntidad() || presolicitudVO.getCoberturaGlobVO().getDelegacion().getCveDeleg() != ramEsp.getCveDeleg()
                                || presolicitudVO.getCoberturaGlobVO().getUnidad().getCveUniad() != ramEsp.getCveUniad()) {
                            derechOtor.setStatus(OtwExceptionCodes.FOLIO_DIFERENT_A_LA_DELEGACION_QUE_USTED_LABORA);
                            procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.FOLIO_DIFERENT_A_LA_DELEGACION_QUE_USTED_LABORA);
                        }
                    }
                }
            }
        } else {
            //Se valida cuando la entidad de la solicitud es Entidad 9
            if (presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad() == Constants.ENTIDAD_DF && presolicitudVO.getCoberturaGlobVO().getOficina().getCveOficina() != Constants.OFICINA_DF) {
                ramEsp = procesosOtorgamientoMService.obtenerRamoEspecialSiSuRamoEsEspecial(presolicitudVO.getCoberturaGlobVO(), presolicitudVO.getCramPagVO());
                if (ramEsp.getBandAuxEsDf() == 0) {
                    if (ramEsp.getBandAuxEsRamEsp() == 0) {
                        derechOtor.setStatus(OtwExceptionCodes.FOLIO_DF_USTED_LABORA_DEPEND_NO_DF);
                        procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.FOLIO_DF_USTED_LABORA_DEPEND_NO_DF);
                    } else {
                        derechOtor.setStatus(OtwExceptionCodes.FOLIO_DIFERENT_A_LA_DELEGACION_QUE_USTED_LABORA);
                        procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.FOLIO_DIFERENT_A_LA_DELEGACION_QUE_USTED_LABORA);
                    }
                } else {
                    if (ramEsp.getBandAuxEsRamEsp() == 1) {
                        if (presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad() != ramEsp.getCveEntidad() || presolicitudVO.getCoberturaGlobVO().getDelegacion().getCveDeleg() != ramEsp.getCveDeleg()
                                || presolicitudVO.getCoberturaGlobVO().getUnidad().getCveUniad() != ramEsp.getCveUniad()) {
                            derechOtor.setStatus(OtwExceptionCodes.FOLIO_DIFERENT_A_LA_DELEGACION_QUE_USTED_LABORA);
                            procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.FOLIO_DIFERENT_A_LA_DELEGACION_QUE_USTED_LABORA);
                        }
                    }
                }
            }

        }
        //Se hace el cambio del prestamo 16 a 21
        if (tipoPrestAuxAuto == Constants.TPO_PRESTAM_AUTO && creditoVO.getCveTcr() == Constants.TIPO_PREST_ADQ_BIENES_DURADEROS) {
            tipoPrestAuxAuto = creditoVO.getCveTcr();
            creditoVO.setCveTcr(Constants.TPO_PRESTAM_AUTO);
        }

        //Se obtiene el monto minimo por el tipo de prestamo
        Double montoMinTipCred = tipoCreditoDAO.obtenerMontoMinTipoCred(creditoVO.getCveTcr()/*presolicitudVO.getTpoCreditoVO().getCveTcr()*/);
        if (montoMaximoCred < montoMinTipCred) {
            montoAceptado = false;
        }
        //System.out.println("monto" + montoMinTipCred);
        if (montoAceptado) {
            String montoCreditoSol = LetrasUtil.convertirNumeroALetras(montoMaximoCred);
            presolicitudVO.setDescMontoSol(montoCreditoSol);
        }
        boolean valFolio = validacionFolioWeb.validarFolio(presolicitudVO, nombramiento);
        if (!valFolio) {
            derechOtor.setStatus(OtwExceptionCodes.FOLIO_ASIGNADO_A_OTRA_SOLICITUD);
            procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.FOLIO_ASIGNADO_A_OTRA_SOLICITUD);
        }

        QuinDifVO quinDifVO = procesosOtorgamientoService.obtieneQuincenasDiferimiento(derechOtor.getFechaAud(), presolicitudVO.getNumRamo(), presolicitudVO.getNumPagaduria(), nombramiento);
        firstPayPer = "" + quinDifVO.getQuinFin().getAnio() + String.format(Constants.FORMATO_DOS_DIGITOS, quinDifVO.getQuinFin().getQna());

        prstamoOrigVO.setFirstPayPerYrD(firstPayPer);

        //System.out.println("firstPayPer " + firstPayPer + "---Dif " + quinDifVO.getQuinDif());

        //Cambio del prestamo de 21 a 16
        if (creditoVO.getCveTcr() == Constants.TPO_PRESTAM_AUTO) {
            tipoPrestAuxAuto = creditoVO.getCveTcr();
            creditoVO.setCveTcr(Constants.TIPO_PREST_ADQ_BIENES_DURADEROS);
        }

        //Se obtiene el monto y el plazo que se otorgara
        //System.out.println("MontoPlazoPrestamo" + presolicitudVO.getTpoCreditoVO().getCveTcr() + montoMaximoCred + Constants.PLAZO_SOLICITADO + parametrosCredito.getMontoCre() + parametrosCredito.getPlazoCre() + sueldoCalculado.getSueldoCalDeTope());
        MontoPlazoOtorgadoVO montoPlazoOt = procesosOtorgamientoMService.obtenerMontoPlazoOtorgar(creditoVO.getCveTcr(), montoMaximoCred, Constants.PLAZO_SOLICITADO, parametrosCredito.getMontoCre(), parametrosCredito.getPlazoCre(), sueldoCalculado.getSueldoCalDeTope(), vehiculo);
        prstamoOrigVO.setOrigLoanPrin(montoPlazoOt.getMontoOtorgado());
        prstamoOrigVO.setOrigNbrPay(montoPlazoOt.getPlazoOtorgado());
        if (nombramiento == Constants.C_PENSION) {
            if (montoPlazoOt.getPlazoOtorgado() != 1) {
                prstamoOrigVO.setOrigNbrPay(montoPlazoOt.getPlazoOtorgado() / 2);
            }
        }

        /*System.out.println("montoPlazoOt.getMontoOtorgado()" + montoPlazoOt.getMontoOtorgado());
        System.out.println("montoPlazoOt.getPlazoOtorgado()" + montoPlazoOt.getPlazoOtorgado());*/

        String quincenaFin = DateUtils.obtenerQuincenaFinalPrest(prstamoOrigVO.getFirstPayPerYrD(), prstamoOrigVO.getOrigNbrPay(), nombramiento);
        prstamoOrigVO.setLastPayPerYrDu(quincenaFin);
        //System.out.println("quincenaFin" + quincenaFin);

        seRequiereRefinanciar = procesosOtorgamientoMService.tienePrestamosARefinanciar(derechOtor.getNumIssste());
        RefinanciamientoVO refinanciamientoVO = new RefinanciamientoVO();
        if (seRequiereRefinanciar) {
            if (tipoPrestAuxAuto != Constants.TPO_PRESTAM_AUTO) {
                int banderaSim = 0;
                if (!simulado) {
                    banderaSim = 1;
                }

                refinancia = 1;
                Calendar c1 = Calendar.getInstance();
                ProyeccionVO proyeccionVO = null;
                try {
                    refinanciamientoVO = procesosOtorgamientoService.obtieneRefinanciamiento(presolicitudVO.getDirecto().getNumIssste(), presolicitudVO.getTpoCreditoVO().getCveTcr(), String.valueOf(nombramiento), prstamoOrigVO.getOrigLoanPrin(), prstamoOrigVO.getIntRate(), presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad(), presolicitudVO.getDirecto().getCodigoPostal().intValue(), banderaSim, presolicitudVO.getIpMaquina());
                } catch (ParseException ex) {
                    Logger.getLogger(SimulacionWEB.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*if (refinanciamientoVO.getLdSaldoRef() == 0) {
                if (presolicitudVO.getTpoCreditoVO().getCveTcr() == Constants.TIPO_PREST_DAMNIFICADOS || presolicitudVO.getTpoCreditoVO().getCveTcr() == Constants.TIPO_PREST_EXT_DAM) {
                double orig_loan_prin = prstamoOrigVO.getOrigLoanPrin() + 10000;
                prstamoOrigVO.setOrigLoanPrin(orig_loan_prin);
                }
                }*/
                int i = 0;
                for (Double numPres : refinanciamientoVO.getNumPresRef()) {
                    switch (i) {
                        case 0:
                            prstamoOrigVO.setNumPrestRef1(numPres);
                            break;
                        case 1:
                            prstamoOrigVO.setNumPrestRef2(numPres);
                            break;
                        case 2:
                            prstamoOrigVO.setNumPrestRef3(numPres);
                            break;
                    }
                    i++;
                }

                double ldSaldoRef = refinanciamientoVO.getLdCapRefinanc() + refinanciamientoVO.getLdIntRefinanc() + refinanciamientoVO.getLdIvaRefinanc();
                //System.out.println("SimulacionW"+refinanciamientoVO.getLdCapRefinanc()+" " + refinanciamientoVO.getLdIntRefinanc() +" " + refinanciamientoVO.getLdIvaRefinanc());
                refinanciamientoVO.setLdSaldoRef(NumerosUtils.truncate(ldSaldoRef, 2));
                /*System.out.println("refinanciamientoVOSaldo"+refinanciamientoVO.getLdSaldoRef());
                System.out.println("refinanciamientoVO.>>>>"+refinanciamientoVO.getLdSaldoRef());
                System.out.println("prstamoOrigVO.getNumPrestRef1()---->>>>"+prstamoOrigVO.getNumPrestRef1());
                System.out.println("prstamoOrigVO.getNumPrestRef2()---->>>>"+prstamoOrigVO.getNumPrestRef2());
                System.out.println("prstamoOrigVO.getNumPrestRef3()---->>>>"+prstamoOrigVO.getNumPrestRef3());*/

                if ((prstamoOrigVO.getNumPrestRef1() != null && prstamoOrigVO.getNumPrestRef1() != 0)
                        || (prstamoOrigVO.getNumPrestRef2() != null && prstamoOrigVO.getNumPrestRef2() != 0)
                        || (prstamoOrigVO.getNumPrestRef3() != null && prstamoOrigVO.getNumPrestRef3() != 0)) {
                    prestamos = prestamoOrigDao.obtenerPrestamosVigentes(presolicitudVO.getDirecto().getNumIssste());
                    proyeccionVO = proyeccionDao.obtenerProyeccionByID(prestamos.get(0).getLoanNbr());
                    fechaFinRef = proyeccionVO.getLastPayPerDue();
                    ultPagoRef1 = proyeccionVO.getAmtLastPmt();
                    if (nombramiento == Constants.TNO_CVE_PENSION) {
                        
                        Date fechaF = DateUtils.obtenerUltimaQuincena(proyeccionVO.getLastPayPerDue());
                        
                        c1.setTime(fechaF);
                        String mes = String.format(Constants.FORMATO_DOS_DIGITOS, (c1.get(Calendar.MONTH)+1));
                        String anio= ""+c1.get(Calendar.YEAR);
                        fechaFinRef = anio+mes;
                    }

                    //System.out.println("fechaFinRef-->>" + fechaFinRef + "ultPagoRef1-->>" + ultPagoRef1);
                /* String quinAct="";
                    int anioQ=0, mesQ=0, restaQuincena=0, quinFinR=0, lsDif=0;
                    double lsAbono=0;
                    if (nombramiento != Constants.TNO_CVE_PENSION) {
                    String quincenaFinR = proyeccionVO.getLastPayPerDue();
                    int anioAct = DateUtils.anioActual();
                    quinAct = DateUtils.gConvFechaQuin1(new Date());
                    restaQuincena = Integer.parseInt(quinAct) - (anioAct*100);
                    restaQuincena = (anioAct*24)+restaQuincena;
                    anioQ = Integer.parseInt(quincenaFinR.substring(0, 4));
                    mesQ = Integer.parseInt(quincenaFinR.substring(4, 6));
                    quinFinR=(anioQ*24)+mesQ;
                    lsDif = quinFinR -(restaQuincena-1);
                    if(lsDif<0){
                    lsDif=0;
                    }
                    if(lsDif > quinDifVO.getQuinDif()){
                    lsDif=quinDifVO.getQuinDif();
                    }
                    lsAbono = proyeccionVO.getAmtLastPmt()*lsDif;
                    
                    System.out.println("quin_fin: "+quinFinR+" quin_act: "+restaQuincena+" ls_dif: "+lsDif);
                    
                    }else{
                    Date fechaRef=DateUtils.parseStringDate(Constants.FECHA_REFINANCIAMIENTO);
                    if(prestamos.get(0).getLoanIssue_date().before(fechaRef)){
                    
                    }
                    
                    }*/

                }
                prstamoOrigVO.setTipoOd(Constants.TIPO_ORDEN_P_PREST_CON_REFINAN);
            } else {
                derechOtor.setStatus(OtwExceptionCodes.NO_APLICA_REF_AUTO);
                procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_APLICA_REF_AUTO);
            }

        } else {
            prstamoOrigVO.setTipoOd(Constants.TIPO_ORDEN_P_PREST_SIN_REFINAN);
            refinanciamientoVO.setLdSaldoRef(0.0);//saldoRefinanciado = 0.0;
            sdoCapDesQna = prstamoOrigVO.getOrigLoanPrin();
        }
        presolicitudVO.setSaldoRef(refinanciamientoVO.getLdSaldoRef());
        if (presolicitudVO.getTpoCreditoVO().getCveTcr() == Constants.TIPO_PREST_DAMNIFICADOS || presolicitudVO.getTpoCreditoVO().getCveTcr() == Constants.TIPO_PREST_EXT_DAM) {
            if (refinanciamientoVO.getLdSaldoRef() == 0) {
                creditoVO.setPrimaRenov(0.0);
            }
            double orig_loan_prin = (prstamoOrigVO.getOrigLoanPrin() + refinanciamientoVO.getLdSaldoRef()) / (1 - parametrosCredito.getPrimaGarant() - creditoVO.getPrimaRenov());
            prstamoOrigVO.setOrigLoanPrin(orig_loan_prin);

            //Se calculan las primas para el prestamo a otorgar
            PrimasGarRenVO primasGarRenVO = procesosOtorgamientoMService.calcularPrimas(prstamoOrigVO.getOrigLoanPrin(), parametrosCredito.getPrimaGarant(), creditoVO.getPrimaRenov(), refinanciamientoVO.getLdSaldoRef());
            prstamoOrigVO.setWarrantyPrem(primasGarRenVO.getPrimaGarantia());
            prstamoOrigVO.setRenewalPrem(primasGarRenVO.getPrimaRenovacion());
            diferimientoVO = procesosOtorgamientoService.obtenerIntIvaDif(nombramiento, prstamoOrigVO.getIntRate(), quinDifVO.getQuinDif(), refinancia, prstamoOrigVO.getOrigLoanPrin(), fechaFinRef, ultPagoRef1, presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad(), directoVO.getCodigoPostal().intValue());

        } else {
            diferimientoVO = procesosOtorgamientoService.obtenerIntIvaDif(nombramiento, prstamoOrigVO.getIntRate(), quinDifVO.getQuinDif(), refinancia, prstamoOrigVO.getOrigLoanPrin(), fechaFinRef, ultPagoRef1, presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad(), directoVO.getCodigoPostal().intValue());
            //Se calculan las primas para el prestamo a otorgar
            PrimasGarRenVO primasGarRenVO = procesosOtorgamientoMService.calcularPrimas(prstamoOrigVO.getOrigLoanPrin(), parametrosCredito.getPrimaGarant(), creditoVO.getPrimaRenov(), refinanciamientoVO.getLdSaldoRef());
            prstamoOrigVO.setWarrantyPrem(primasGarRenVO.getPrimaGarantia());
            prstamoOrigVO.setRenewalPrem(primasGarRenVO.getPrimaRenovacion());
        }

        /*System.out.println("prstamoOrigVO.getWarrantyPrem()" + prstamoOrigVO.getWarrantyPrem());
        System.out.println("prstamoOrigVO.getOrigLoanPrin()" + prstamoOrigVO.getRenewalPrem());
        System.out.println("Diferimiento" + quinDifVO.getQuinDif());
        System.out.println("diferimientoVO.getBndUltimoPagoRef()" + diferimientoVO.getBndUltimoPagoRef());*/

        if (diferimientoVO.getBndUltimoPagoRef() > 0) {
            refinanciamientoVO.setLsQnasf(diferimientoVO.getBndUltimoPagoRef());
            refinanciamientoVO.setLdAmtLastPmt(ultPagoRef1);
        } else {
            refinanciamientoVO.setLsQnasf(0);
            refinanciamientoVO.setLdAmtLastPmt(0);
        }

        /*System.out.println("refinanciamientoVO----" + refinanciamientoVO.getLsQnasf());
        System.out.println("refinanciamientoVO>>>>>>>" + refinanciamientoVO.getLdAmtLastPmt());*/

        double capacidadPago = procesosOtorgamientoService.calcularCapacidadPago(directoVO.getNumIssste(), presolicitudVO.getNumRamo(), presolicitudVO.getNumPagaduria(), sueldoCalculado.getSueldoCalDeTope(), nombramiento);
        //System.out.println("capacidadPago-->>" + capacidadPago);
        if (refinancia == 1) {
            sdoTotCap = diferimientoVO.getSaldoCapitalDesQna();
        } else {
            sdoTotCap = prstamoOrigVO.getOrigLoanPrin();
        }

        DescuentoProcVO descuentoProcVO = new DescuentoProcVO();
        descuentoProcVO.setPlazoOtorg(prstamoOrigVO.getOrigNbrPay());
        descuentoProcVO.setTasaInt(prstamoOrigVO.getIntRate());
        descuentoProcVO.setDif(quinDifVO.getQuinDif());
        descuentoProcVO.setCveEntidad(presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad());
        descuentoProcVO.setTnoCve(nombramiento);
        descuentoProcVO.setCp(presolicitudVO.getDirecto().getCodigoPostal().intValue());
        descuentoProcVO.setSdoCapDesQna(diferimientoVO.getSaldoCapitalDesQna());
        descuentoProcVO.setIntPagSdo(diferimientoVO.getIntPagSdo());
        descuentoProcVO.setIvaPagSdo(diferimientoVO.getIvaPagadoSdo());
        descuentoProcVO.setSdoIntdesQna(diferimientoVO.getSdoIntDesQna());
        descuentoProcVO.setSdoIvadesQna(diferimientoVO.getSdoIvaDesQna());
        descuentoProcVO.setCveTcr(presolicitudVO.getTpoCreditoVO().getCveTcr());
        double fiva = procesosOtorgamientoService.calFiva(descuentoProcVO.getCveEntidad(), descuentoProcVO.getCp());
        /*System.out.println("Entrada====>>>>>>>>");
        System.out.println(descuentoProcVO.getPlazoOtorg());
        System.out.println(descuentoProcVO.getTasaInt());
        System.out.println(descuentoProcVO.getDif());
        System.out.println(descuentoProcVO.getCveEntidad());
        System.out.println(descuentoProcVO.getTnoCve());
        System.out.println(descuentoProcVO.getCp());
        System.out.println(descuentoProcVO.getSdoCapDesQna());
        System.out.println(descuentoProcVO.getIntPagSdo());
        System.out.println(descuentoProcVO.getIvaPagSdo());
        System.out.println(descuentoProcVO.getSdoIntdesQna());
        System.out.println(descuentoProcVO.getSdoIvadesQna());
        System.out.println(descuentoProcVO.getCveTcr());*/
        //Se calcula el descuento
        CalculoDescuentoVO caldescuentoVO = procesosOtorgamientoService.calcularDescuento(descuentoProcVO, fiva);

        /*System.out.println("--->>Salida");
        System.out.println(caldescuentoVO.getDescuento());
        System.out.println(caldescuentoVO.getFiva());
        System.out.println(caldescuentoVO.getIntPagSdo());
        System.out.println(caldescuentoVO.getIntOrigSIVA());
        System.out.println(caldescuentoVO.getIvaOrig());
        System.out.println(caldescuentoVO.getR());
        System.out.println(caldescuentoVO.getrPrim());*/

        prstamoOrigVO.setPayAmt(caldescuentoVO.getDescuento());
        prstamoOrigVO.setIvaRate(caldescuentoVO.getFiva());
        prstamoOrigVO.setDeferredInt(caldescuentoVO.getIntPagSdo());
        prstamoOrigVO.setOrigLoanIntAmt(caldescuentoVO.getIntOrigSIVA());
        prstamoOrigVO.setOrigIva(caldescuentoVO.getIvaOrig());

        descuentoProcVO.setR(caldescuentoVO.getR());
        descuentoProcVO.setRprim(caldescuentoVO.getrPrim());
        descuentoProcVO.setCapacidadPago(capacidadPago);
        descuentoProcVO.setDescuento(prstamoOrigVO.getPayAmt());
        descuentoProcVO.setMontoOtorg(prstamoOrigVO.getOrigLoanPrin());
        descuentoProcVO.setRefinancia(refinancia);
        descuentoProcVO.setQnasF(refinanciamientoVO.getLsQnasf());
        descuentoProcVO.setAmtLastPmt(refinanciamientoVO.getLdAmtLastPmt());
        descuentoProcVO.setUltPagoRef(ultPagoRef1);
        descuentoProcVO.setFechaFinRef(fechaFinRef);
        //Se valida el descuento
        DescuentoVO descuentoVO = procesosOtorgamientoService.procesarDscto(descuentoProcVO, fiva);

        //Se hace el cambio del prestamo 16 a 21
        if (tipoPrestAuxAuto == Constants.TPO_PRESTAM_AUTO && creditoVO.getCveTcr() == Constants.TIPO_PREST_ADQ_BIENES_DURADEROS) {
            tipoPrestAuxAuto = creditoVO.getCveTcr();
            creditoVO.setCveTcr(Constants.TPO_PRESTAM_AUTO);
        }

        prstamoOrigVO.setPayAmt(descuentoVO.getDescuento());
        prstamoOrigVO.setOrigLoanPrin(descuentoVO.getMontoOtorgado());
        prstamoOrigVO.setOrigNbrPay((int) descuentoVO.getPlazoOtorgado());
        if (descuentoVO.getCalculoDescuentoVO() != null) {
            prstamoOrigVO.setIvaRate(descuentoVO.getCalculoDescuentoVO().getFiva());
            prstamoOrigVO.setDeferredInt(descuentoVO.getCalculoDescuentoVO().getIntPagSdo());
            prstamoOrigVO.setOrigLoanIntAmt(descuentoVO.getCalculoDescuentoVO().getIntOrigSIVA());
            prstamoOrigVO.setOrigIva(descuentoVO.getCalculoDescuentoVO().getIvaOrig());
        }
        presolicitudVO.setDescuentoProcVO(descuentoProcVO);

        //System.out.println("---Org " + prstamoOrigVO.getOrigLoanPrin());

        refinanciamientoVO.setLsQnasf((int) descuentoVO.getNumPagoAntProy());
        refinanciamientoVO.setLdAmtLastPmt(descuentoVO.getUltimoPagoProy());

        if (descuentoVO.getBndPrimas() == 1) {
            PrimasGarRenVO primasGarRenVO = procesosOtorgamientoMService.calcularPrimas(prstamoOrigVO.getOrigLoanPrin(), parametrosCredito.getPrimaGarant(), creditoVO.getPrimaRenov(), refinanciamientoVO.getLdSaldoRef());
            prstamoOrigVO.setWarrantyPrem(primasGarRenVO.getPrimaGarantia());
            prstamoOrigVO.setRenewalPrem(primasGarRenVO.getPrimaRenovacion());

        }

        /* System.out.println("Desspues---" + prstamoOrigVO.getWarrantyPrem());
        System.out.println(prstamoOrigVO.getRenewalPrem());*/

        if (presolicitudVO.getTpoCreditoVO().getCveTcr() == Constants.TIPO_PREST_DAMNIFICADOS || presolicitudVO.getTpoCreditoVO().getCveTcr() == Constants.TIPO_PREST_EXT_DAM) {
            String quinfinDam = DateUtils.obtenerQuincenaFinalPrest(prstamoOrigVO.getFirstPayPerYrD(), prstamoOrigVO.getOrigNbrPay(), nombramiento);
            prstamoOrigVO.setLastPayPerYrDu(quinfinDam);
            CParamOtorgaVO cpovoAux = parametrosOtorgamientoDao.obtenerParametroByID(Constants.CVE_PARAM_EXT_D);
            if (prstamoOrigVO.getOrigLoanPrin() >= cpovoAux.getValParamOtorga()) {
                derechOtor.setStatus(OtwExceptionCodes.NO_ES_POSIBLE_OTORGAR_PREST_DAMNI);
                procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_ES_POSIBLE_OTORGAR_PREST_DAMNI);
            }
        }
        /*System.out.println("descuentoVOVal-----" + descuentoVO.isValidacionDscto());
        System.out.println("refinancia-----" + refinancia);
        System.out.println("refinanciamientoVO.getLdSaldoRef()-----" + refinanciamientoVO.getLdSaldoRef());*/
        Double importeLiquido = procesosOtorgamientoMService.calcularImporteLiquido(refinancia, prstamoOrigVO, refinanciamientoVO.getLdSaldoRef());

        //System.out.println("importeLiquido-----" + importeLiquido);
        prstamoOrigVO.setImpLiquido(importeLiquido);
        if (!descuentoVO.isValidacionDscto()) {
            presolicitudVO.setCveStatSol(Constants.ESTATUS_RECHAZO_OTORGAMIENTO);
            derechOtor.setStatus(OtwExceptionCodes.NO_CUENTA_CON_CAPACIDAD_PAGO);
            procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_CUENTA_CON_CAPACIDAD_PAGO);
        }
        //System.out.println("prstamoOrigVO.getPayAmt() " + prstamoOrigVO.getPayAmt());
        if (prstamoOrigVO.getPayAmt() <= 0) {
            derechOtor.setStatus(OtwExceptionCodes.NO_CUENTA_CON_CAPACIDAD_PAGO);
            procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_CUENTA_CON_CAPACIDAD_PAGO);
        }
        Integer numPrestAd = folioDao.obtenerNumeroPresAdicFoliosEspeciales(presolicitudVO.getFolioSol(), presolicitudVO.getCveTrc(), presolicitudVO.getAnioSol());
        if (numPrestAd != null && numPrestAd == 0) {
            maximoCreditos = numPrestAd;
        } else if (numPrestAd != 1000 && numPrestAd != 0) {
            maximoCreditos = maximoCreditos + numPrestAd;
        }
        //System.out.println("==========" + maximoCreditos);
        RechazoVO rechazos = procesosOtorgamientoService.generaRechazos(presolicitudVO.getDirecto().getNumIssste(), presolicitudVO.getTpoCreditoVO().getCveTcr(), maximoCreditos, refinanciamientoVO.getLdSaldoRef());

        //System.out.println("--"+rechazos.getBndRechazo()+"***"+ rechazos.getCveRechazo());
        //Se valida el importeLiquido y el rechazo para los prestramos refinanciados
        if (prstamoOrigVO.getImpLiquido() <= 0 && (rechazos.getCveRech() != Constants.RECHAZO_NO_CUBRE_LA_CUARTA_PARTE && rechazos.getCveRech() != Constants.RECHAZO_NO_CUBRE_TOTALIDAD && rechazos.getCveRech() != Constants.RECHAZO_TIENE_UN_ADEUDO_MAYOR_AL_PERMITIDO)) {
            presolicitudVO.setCveStatSol(Constants.ESTATUS_RECHAZO_OTORGAMIENTO);
            derechOtor.setStatus(OtwExceptionCodes.NO_CUENTA_CON_CAPACIDAD_PAGO);
            procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DERECHO_CON_CREDITOS_PENDIENTES);
        }
        if (rechazos != null) {
            if (rechazos.getBndRechazo() == 1) {
                if (rechazos.getError() == 99) {
                    presolicitudVO.setCveRechazo(OtwExceptionCodes.SOLICITUD_SIN_ASIGNACION_PRESUP);
                } else {
                    //System.out.println("RechazoGenera"+ rechazos.getCveRechazo());
                    presolicitudVO.setCveRechazo(rechazos.getCveRechazo());
                }
                presolicitudVO.setCveStatSol(Constants.ESTATUS_RECHAZO_OTORGAMIENTO);
                presolicitudVO.setFecRechOto(new Date());
            } else {
                presolicitudVO.setCveStatSol(Constants.ESTATUS_PRESTAMO_OTORGADO);
            }
        }

        //se valida que la presolicitud sea diferente a un  Estatus con rechazo
        if (simulado) {
            if (presolicitudVO.getCveStatSol() != Constants.ESTATUS_RECHAZO_OTORGAMIENTO) {
                if (prstamoOrigVO.getCvePart() < 0) {
                    prstamoOrigVO.setCvePart(0);
                }
            }
        }
        //System.out.println("----presolicitudVO.getAltaModFluj() " + presolicitudVO.getAltaModFluj());
        refinanciamientoVO.setDirectoVO(directoVO);
        presolicitudVO.setPrstamoOrigVO(prstamoOrigVO);
        presolicitudVO.setRefinanciamientoVO(refinanciamientoVO);
        presolicitudVO.setRefinancia(refinancia);
        //Para el proceso que no es simulado se llama a la funcion de otorga Prestamo
        if (!simulado) {
            presolicitudVO = procesosOtorgamientoService.otorgaPrestamo(presolicitudVO, refinanciamientoVO, presolicitudVO.getAltaModFluj(), refinancia, vehiculo);
        }

        //System.out.println("Sali del metodo---"+cveRechazoSolicAux);
        //rechazo que se va cambiando durante toda la funcion de otorgar, al final se quedara con el valor de otorga_prestamo
        if (presolicitudVO.getCveRechazo() > 0) {
            // System.out.println("Se obtuvo Rechazo >>> " + presolicitudVO.getCveRechazo());
            derechOtor.setStatus(presolicitudVO.getCveRechazo());
            procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
            //procesosOtorgamientoMService.verificarEliminar(derechOtor);
            throw sQLErrorCodesFactory.createException(presolicitudVO.getCveRechazo());
        }
        if (!simulado) {
            DecimalFormat num = new DecimalFormat("###");
            String numPrest = num.format(presolicitudVO.getPrstamoOrigVO().getLoanNbr());
            String fechaPrestamo = DateUtils.fechaPrestamoString(presolicitudVO.getPrstamoOrigVO().getLoanIssue_date());
            presolicitudVO.getPrstamoOrigVO().setAuxNumPrestamo(numPrest);
            presolicitudVO.getPrstamoOrigVO().setAuxFechaPrestamo(fechaPrestamo.toUpperCase());
            presolicitudVO.setDescMontoSol(LetrasUtil.convertirNumeroALetras(presolicitudVO.getPrstamoOrigVO().getOrigLoanPrin()).toUpperCase());
            presolicitudVO.setDescImporteCheque(LetrasUtil.convertirNumeroALetras(presolicitudVO.getPrstamoOrigVO().getImpLiquido()).toUpperCase());
            presolicitudVO.setDescDtoAmt(LetrasUtil.convertirNumeroALetras(presolicitudVO.getPrstamoOrigVO().getPayAmt()).toUpperCase());
        }

        cajaPagadoraVO.setIdEntidad(derechOtor.getCveEntidad());
        cajaPagadoraVO.setIdDelegacion(derechOtor.getCveDeleg());
        cajaPagadoraVO.setIdUniad(derechOtor.getCveUniad());
        cajaPagadoraVO.setIdOficina(derechOtor.getCveOficina());
        if (derechOtor.getFolio() > 0) {
            List<CajaPagadoraVO> cajaPagadoraVOs = coberturaDao.buscarCajasPagadorasSimulacion(cajaPagadoraVO);
            presolicitudVO.setCajaPagadoraVO(cajaPagadoraVOs.get(0));
        }
        presolicitudVO.setAltaModFluj(Constants.TIPO_OPER_NUEVO_REGRESO);
        CramPagVO ramo = ramoPagaduriaDao.obtenerRamoPagById(presolicitudVO.getCramPagVO().getRamoCat(), "");
        presolicitudVO.setDescRamo(ramo.getNombCat());

        return presolicitudVO;
    }

    public PresolicitudVO simulacion(Integer numIssste, FolioVO folioVO, Integer tipoPrestamo, CajaPagadoraVO cajaPagadoraVO, String ipMaquina, String vehiculo) {
        DirectoVO directoVO = new DirectoVO();
        directoVO.setNumIssste(numIssste);
        PresolicitudVO presolicitudVO = null;
        if (folioVO != null) {
            procesosOtorgamientoService.generaRegistroTrans(numIssste, Integer.parseInt(folioVO.getFolioSolicitud()), tipoPrestamo, cajaPagadoraVO, ipMaquina);
            presolicitudVO = iOtorgamientoWEB.otorgamientoWeb(null, directoVO, folioVO, true, 0, vehiculo);

        } else {
            TransMovOtoWeb movOtoWeb = this.procesosOtorgamientoService.generaRegistroTrans(numIssste, -tipoPrestamo, tipoPrestamo, cajaPagadoraVO, ipMaquina);
            FolioVO folio = new FolioVO();
            folio.setFolioSolicitud("" + (-tipoPrestamo));
            presolicitudVO = iOtorgamientoWEB.otorgamientoWeb(null, directoVO, folio, true, 0, vehiculo);
        }
        presolicitudVO.setDescMontoSol(LetrasUtil.convertirNumeroALetras(
                presolicitudVO.getPrstamoOrigVO().getOrigLoanPrin()).toUpperCase());
        presolicitudVO.setDescImporteCheque(
                LetrasUtil.convertirNumeroALetras(
                presolicitudVO.getPrstamoOrigVO().getImpLiquido()).toUpperCase());
        presolicitudVO.setDescDtoAmt(
                LetrasUtil.convertirNumeroALetras(
                presolicitudVO.getPrstamoOrigVO().getPayAmt()).toUpperCase());

        return presolicitudVO;
    }
}
