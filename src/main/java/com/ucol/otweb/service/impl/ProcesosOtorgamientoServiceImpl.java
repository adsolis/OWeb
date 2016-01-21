package com.ucol.otweb.service.impl;

import com.ucol.otweb.dao.*;
import com.ucol.otweb.enums.MesEnum;
import com.ucol.otweb.enums.RamoEspecialEnum;
import com.ucol.otweb.service.IProcesosOtorgamientoService;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.utils.NumerosUtils;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.utils.exception.OtwException;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.vo.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.ucol.otweb.cws.*;
import com.ucol.otweb.service.IProcesosOtorgamientoMService;
import org.springframework.transaction.annotation.Isolation;

/**
 *
 * @author 
 */
@Component
@Repository(value = "procesosOtorgamientoService")
@Transactional
public class ProcesosOtorgamientoServiceImpl implements IProcesosOtorgamientoService {

    @Autowired
    @Qualifier("iWebService")
    private IWebService iWebService;
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
    @Qualifier("folioDao")
    private IFolioDao folioDao;
    @Autowired
    @Qualifier("coberturaDao")
    private ICoberturaDao coberturaDao;
    @Autowired
    @Qualifier("antiguedadDao")
    private IAntiguedadDao antiguedadDao;
    @Autowired
    @Qualifier("parametrosOtorgamientoDao")
    private IParametrosOtorgamientoDao parametrosOtorgamientoDao;
    @Autowired
    @Qualifier("ivasDao")
    private IIvaDao ivasDao;
    @Autowired
    @Qualifier("deduccionesDao")
    private IDeduccionesDao deduccionesDao;
    @Autowired
    @Qualifier("prestamoOrigDao")
    private IPrestamoOrigDao prestamoOrigDao;
    @Autowired
    @Qualifier("proyeccionDao")
    private IProyeccionDao proyeccionDao;
    @Autowired
    @Qualifier("salarioDao")
    private ISalarioDao salarioDao;
    @Autowired
    @Qualifier("credParamDao")
    private ICredParamDao credParamDao;
    @Autowired
    @Qualifier("recepcionSolDao")
    private IRecepcionSolicitudDao recepcionSolDao;
    @Autowired
    @Qualifier("calPensDao")
    private ICalPensDao calPensDao;
    @Autowired
    @Qualifier("diferimientoDao")
    private IDiferimientoDao diferimietoDao;
    @Autowired
    @Qualifier("pagoRealDao")
    private IPagoRealDao pagoRealDao;
    @Autowired
    @Qualifier("cCompatibleDao")
    private ICCompatibleDao compatibleDao;
    @Autowired
    @Qualifier("partidaDao")
    private IPartidaDao partidaDao;
    @Autowired
    @Qualifier("presupuestoDao")
    private IPresupuestoDao presupuestoDao;
    @Autowired
    @Qualifier("procesosOtorgamientoServiceM")
    private IProcesosOtorgamientoMService procesosOtorgamientoMService;
    PropertyUtils properties = new PropertyUtils("config.properties");
    @Autowired
    @Qualifier("nominaDao")
    private INominaDao nominaDao;
    @Autowired
    @Qualifier("minMaxDao")
    private IMinMaxDao minMaxDao;
    @Autowired
    @Qualifier("procesosOtorgamientoServiceM")
    private IProcesosOtorgamientoMService mService;
    TransMovOtoWeb transMovOtoWeb = new TransMovOtoWeb();
    @Autowired
    @Qualifier("sQLErrorCodesFactory")
    private SQLErrorCodesFactory sQLErrorCodesFactory;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public TransMovOtoWeb generaRegistroTrans(Integer numIssste, Integer numFolio,
            Integer CveTcr, CajaPagadoraVO cajaPagadoraVO, String ipMaquina) {
        List<DirectoAVVO> listaDirectoAV = null;
        TransMovOtoWeb existTrans = null;
        DatosLaboralesVO datosLaboralesVO = new DatosLaboralesVO();
        DirectoAVVO directoAV = null;
        Integer ramoAnt = null;
        Integer idOficina = null;
        StringBuilder nombre = new StringBuilder();
        PropertyUtils prop = new PropertyUtils("config.properties");
        prop.cargaArchivo();
        /*
         * Obtener la informacion del derechohabiente
         */
//        se genera la caja pagadora para simulacion
        if (numFolio < 0) {
            cajaPagadoraVO = new CajaPagadoraVO();
            cajaPagadoraVO.setIdEntidad(1);
            cajaPagadoraVO.setIdDelegacion(1);
            cajaPagadoraVO.setIdUniad(0);
            cajaPagadoraVO.setIdOficina(36);
        }
        datosLaboralesVO.setNumIssste(numIssste);
        listaDirectoAV = this.datosLaboralesDAO.busquedaDerechohabienteAVDirecto(datosLaboralesVO, false);
        if (listaDirectoAV != null && listaDirectoAV.size() > 0) {
            directoAV = listaDirectoAV.get(0);
            transMovOtoWeb.setIp_equipo(ipMaquina);
            transMovOtoWeb.setRfc(directoAV.getRfc());
            transMovOtoWeb.setCurp(directoAV.getCurp());
            transMovOtoWeb.setNss(directoAV.getNss().toString());
            transMovOtoWeb.setNumIssste(directoAV.getNumIssste());
            nombre.append(directoAV.getApellidoPaterno().trim());
            nombre.append(Constants.ESPACIO);
            nombre.append(directoAV.getApellidoMaterno().trim());
            nombre.append(Constants.ESPACIO);
            nombre.append(directoAV.getNombre().trim());
            transMovOtoWeb.setFolio(numFolio);
            transMovOtoWeb.setTipo_prst(CveTcr);
            transMovOtoWeb.setNombre(nombre.toString());
            //transMovOtoWeb.setc(directoAV.getNss().toString());
            transMovOtoWeb.setStatus(Constants.ESTATUS_INICIAL_TRANS_MOV_OTO);
            if (directoAV.getTdirecto().trim().equals(Constants.PENSIONADO)) {
                DatosLaboralesVO vo = new DatosLaboralesVO();
                vo.setNumIssste(directoAV.getNumIssste());
                List<PzaPenVO> LPzaPen = datosLaboralesDAO.buscarPlazaPensionado(vo, prop.getParametro("conection.dsipe"), false);
                if (LPzaPen != null && LPzaPen.size() > 0) {
                    PzaPenVO pzaPenVO = LPzaPen.get(0);
                    ramoAnt = this.ramoPagaduriaDao.obtenerRamoAnt((Integer) pzaPenVO.getNumRamo(), pzaPenVO.getNumPagaduria(), "dsipe");
                    transMovOtoWeb.setPagad(pzaPenVO.getNumPagaduria());
                } else {
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.PLAZA_NO_ENCONTRO);
                }

            } else if (directoAV.getTdirecto().trim().equals(Constants.TRABAJADOR)) {
                DatosLaboralesVO vo = new DatosLaboralesVO();
                vo.setNumIssste(numIssste);
                List<PlazaVO> listPlaza = datosLaboralesDAO.buscarPlazas(vo, prop.getParametro("conection.dsipe"), false);
                if (listPlaza != null && listPlaza.size() > 0) {
                    PlazaVO plazaVO = listPlaza.get(0);
                    ramoAnt = this.ramoPagaduriaDao.obtenerRamoAnt(plazaVO.getNumRamo().intValue(), plazaVO.getNumPagaduria(), "dsipe");
                    transMovOtoWeb.setPagad(plazaVO.getNumPagaduria());
                } else {
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DATOS_EMPLEO_NO_REGISTRADO);
                }
            }
        } else {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.REG_NO_ENCONTRADO);
        }
        if (ramoAnt <= 0) {
            //Error: Se encontró un error en el proceso de su información
            /**
             * TODO: Generar el error correspondiente
             */
            throw SQLErrorCodesFactory.getInstance().createException(OtwExceptionCodes.CODIGO_ERROR_NO_VALIDO);

        } else {
            transMovOtoWeb.setRamo(ramoAnt);
        }
        idOficina = this.obtenerOficina(directoAV);

        if (idOficina == 0) {
            if (transMovOtoWeb.getCveEntidad() == 0
                    || transMovOtoWeb.getCveEntidad() == 9) {
                if (cajaPagadoraVO != null) {
                    transMovOtoWeb.setCveEntidad(cajaPagadoraVO.getIdEntidad());
                    transMovOtoWeb.setCveDeleg(cajaPagadoraVO.getIdDelegacion());
                    transMovOtoWeb.setCveUniad(cajaPagadoraVO.getIdUniad());
                    transMovOtoWeb.setCveOficina(cajaPagadoraVO.getIdOficina());
                } else {
                    cajaPagadoraVO = new CajaPagadoraVO();
                    cajaPagadoraVO.setIdEntidad(transMovOtoWeb.getCveEntidad());
                    cajaPagadoraVO.setIdDelegacion(transMovOtoWeb.getCveDeleg());
                    cajaPagadoraVO.setIdUniad(transMovOtoWeb.getCveUniad());
                    cajaPagadoraVO.setIdOficina(transMovOtoWeb.getCveOficina());
                }
            } else {
                transMovOtoWeb.setCveEntidad(cajaPagadoraVO.getIdEntidad());
                transMovOtoWeb.setCveDeleg(cajaPagadoraVO.getIdDelegacion());
                transMovOtoWeb.setCveUniad(cajaPagadoraVO.getIdUniad());
                transMovOtoWeb.setCveOficina(cajaPagadoraVO.getIdOficina());
            }
            transMovOtoWeb.setOperador(Constants.OPERADOR_WEB);
            existTrans = this.transMovWebDao.obtenerTransMovWeb(transMovOtoWeb);
            if (existTrans != null) {
                transMovOtoWeb.setComponente(Constants.ACTWEB);
                this.transMovWebDao.update(transMovOtoWeb);
            } else {
                transMovOtoWeb.setComponente(Constants.ALTAWEB);
                this.transMovWebDao.insertData(transMovOtoWeb);
            }


        } else if (idOficina == 1) {
            /**
             * Favor de verificar el número de folio
             * TODO: Generar el error correspondiente
             */
            throw SQLErrorCodesFactory.getInstance().createException(OtwExceptionCodes.CODIGO_ERROR_NO_VALIDO);
        } else {
            /**
             * ERR:Se encontró el Error://Busca el rechazo de acuerdo al id de la oficina
             * TODO: Generar el error correspondiente
             */
            throw SQLErrorCodesFactory.getInstance().createException(OtwExceptionCodes.CODIGO_ERROR_NO_VALIDO);
        }
        return transMovOtoWeb;
    }

    private Integer obtenerOficina(DirectoAVVO directo) {
        FolioVO folio = null;
        int cveEntidad = 0;
        int ofic = 0;
        cRamEsp ramoEsp = null;
        List<FolioVO> listaFolios = folioDao.consultaFolioXPrestamo(transMovOtoWeb.getTipo_prst(), transMovOtoWeb.getFolio());
        List<cRamEsp> listaRamoEsp = null;
        if (listaFolios != null && !listaFolios.isEmpty()) {
            folio = listaFolios.get(0);
            if (folio.getAnio() == 0) {
                return 1;
            }
            if (folio.getCveEntidad() == 0) {
                cveEntidad = coberturaDao.buscarEntidadPorCodigoPostal((Integer) directo.getCodigoPostal());

                if (cveEntidad == 9 || cveEntidad == 15) {
                    if (transMovOtoWeb.getRamo() == 23
                            || transMovOtoWeb.getRamo() == 26
                            || transMovOtoWeb.getRamo() == 226) {
                        transMovOtoWeb.setCveEntidad(RamoEspecialEnum.ramoEsp(transMovOtoWeb.getRamo()).getCveEntidad());
                        transMovOtoWeb.setCveDeleg(RamoEspecialEnum.ramoEsp(transMovOtoWeb.getRamo()).getCveDelegacion());
                        transMovOtoWeb.setCveUniad(RamoEspecialEnum.ramoEsp(transMovOtoWeb.getRamo()).getCveUniad());
                        transMovOtoWeb.setCveOficina(RamoEspecialEnum.ramoEsp(transMovOtoWeb.getRamo()).getCveOficina());
                    } else {
                        listaRamoEsp = ramoPagaduriaDao.obtenerRamoEspecial(transMovOtoWeb.getRamo(), transMovOtoWeb.getPagad());
                        if ((listaRamoEsp == null && listaRamoEsp.isEmpty()) && cveEntidad == 9) {
                            return 27;
                        } else if ((listaRamoEsp == null && listaRamoEsp.isEmpty()) && cveEntidad == 15) {
                            int oficina = obtenerOficinaRamEspecial(cveEntidad, cveEntidad, 0);
                            if (oficina > 0) {
                                transMovOtoWeb.setCveEntidad(cveEntidad);
                                transMovOtoWeb.setCveDeleg(cveEntidad);
                                transMovOtoWeb.setCveUniad(0);
                            } else {
                                COficinaVO oficinaDos = coberturaDao.obtenerOficinaBPorCobertura(cveEntidad, cveEntidad, null, null);
                                transMovOtoWeb.setCveEntidad(oficinaDos.getCveEntidad());
                                transMovOtoWeb.setCveDeleg(oficinaDos.getCveDeleg());
                                transMovOtoWeb.setCveUniad(oficinaDos.getCveUniad());
                                transMovOtoWeb.setCveUniad(oficinaDos.getCveOficina());
                            }

                        }
                        ramoEsp = listaRamoEsp.get(0);
                        transMovOtoWeb.setCveEntidad(ramoEsp.getCveEntidad());
                        transMovOtoWeb.setCveDeleg(ramoEsp.getCveDeleg());
                        transMovOtoWeb.setCveUniad(ramoEsp.getCveUniad());
                        ofic = obtenerOficinaRamoYFolio(ramoEsp.getCveEntidad(), ramoEsp.getCveDeleg(), ramoEsp.getCveUniad());

                    }
                } else {
                    int oficina = obtenerOficinaRamEspecial(cveEntidad, cveEntidad, 0);
                    if (oficina > 0) {
                        transMovOtoWeb.setCveEntidad(cveEntidad);
                        transMovOtoWeb.setCveDeleg(cveEntidad);
                        transMovOtoWeb.setCveUniad(0);
                    } else {
                        COficinaVO oficinaDos = coberturaDao.obtenerOficinaBPorCobertura(cveEntidad, cveEntidad, null, null);
                        transMovOtoWeb.setCveEntidad(oficinaDos.getCveEntidad());
                        transMovOtoWeb.setCveDeleg(oficinaDos.getCveDeleg());
                        transMovOtoWeb.setCveUniad(oficinaDos.getCveUniad());
                        transMovOtoWeb.setCveUniad(oficinaDos.getCveOficina());
                    }
                }

            } else {
                ofic = obtenerOficinaRamoYFolio(folio.getCveEntidad(), folio.getCveDeleg(), folio.getCveUniad());
                transMovOtoWeb.setCveEntidad(folio.getCveEntidad());
                transMovOtoWeb.setCveDeleg(folio.getCveDeleg());
                transMovOtoWeb.setCveUniad(folio.getCveUniad());
            }

        }
        return 0;
    }

    private int obtenerOficinaRamoYFolio(int cveEntidad, int cveDelegacion, int cveUnidad) {
        int ofic = 0;
        if (cveEntidad == RamoEspecialEnum.RAMO_226.getCveEntidad()
                && cveDelegacion == RamoEspecialEnum.RAMO_226.getCveDelegacion()
                && cveUnidad == RamoEspecialEnum.RAMO_226.getCveUniad()) {
            ofic = 1;
        } else if (cveEntidad == 9
                && cveDelegacion == 36
                && cveUnidad == 4) {
            ofic = 8;
        } else {
            ofic = obtenerOficinaRamEspecial(cveEntidad, cveDelegacion, cveUnidad);
            if (ofic > 0) {
                return ofic;
            } else {
                COficinaVO vo = coberturaDao.obtenerOficinaPorCobertura(cveEntidad,
                        cveDelegacion, cveUnidad);
                ofic = vo.getCveOficina();
            }
        }
        transMovOtoWeb.setCveOficina(ofic);
        return ofic;
    }

    private int obtenerOficinaRamEspecial(int cveEntidad, int cveDelegacion, int cveUnidad) {
        int ofic = 0;
        if (cveEntidad == 5
                && cveDelegacion == 5
                && cveUnidad == 0) {
            transMovOtoWeb.setCveOficina(30);
            ofic = 30;
        } else if (cveEntidad == 2
                && cveDelegacion == 2
                && cveUnidad == 0) {
            transMovOtoWeb.setCveOficina(36);
            ofic = 36;
        }
        return ofic;
    }

    @Override
    public void actualizaContador() {
        OtorgamWebContad resultado = null;
        OtorgamWebContad contador = null;
        contador.setFecha(new Date());
        contador.setContador(Constants.CONTADOR_WEB_NUEVO);
        contador.setComponente_cve(Constants.ALTAWEB);
        contador.setFecha_aud(new Date());
        contador.setUsuario(Constants.OPERADOR_WEB);
        resultado = transMovWebDao.obtenerContadorVisitasWeb();
        if (resultado.getContador() == 0) {
            transMovWebDao.insertContador(contador);
        } else {
            transMovWebDao.incrementaContador(contador);
        }
    }

    /**
     *
     * @param directo
     * @return
     */
    @Override
    public CAntiguedadVO calAnt(DirectoVO directo) {
        CAntiguedadVO resultadoAnt = new CAntiguedadVO();
        boolean antiguedadPermitida;
        Date antiguedadCalculada = null;
        int antiguedadCalculadaDias;
        AntiguedadVO antiguedad = antiguedadDao.obtenerAntiguedad(directo.getNumIssste());
        CParamOtorgaVO paramOt = parametrosOtorgamientoDao.obtenerParametroByID(Constants.PARAM_ANT_MIN_PERM);
        DatosLaboralesVO datosLaborales = new DatosLaboralesVO();
        datosLaborales.setNumIssste(directo.getNumIssste());
        resultadoAnt = new CAntiguedadVO();
        resultadoAnt.setConsistenciaParamOtorg(paramOt != null && paramOt.getValParamOtorga() < 0);

        if (antiguedad == null) {
            /**
             * no se encuentra el registro de antiguedad
             */
            resultadoAnt.setAntiguedadPermitida(true);
            //return resultadoAnt;
        } else {
            antiguedadPermitida = datosLaboralesDAO.countAntiguedadPermitida(directo.getNumIssste()) > 0;
            resultadoAnt.setAntiguedadPermitida(antiguedadPermitida);
        }
        if (directo.getFechaIngreso() == null) {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ES_NECESARIO_ACLARACION_FECHA_ING);
        }
        antiguedadCalculada = DateUtils.fechasDiferencia(new Date(), directo.getFechaIngreso());
        antiguedadCalculadaDias = DateUtils.fechasDiferenciaEnDias(directo.getFechaIngreso()) + 1;
        Calendar calenAnt = Calendar.getInstance();

        calenAnt.setTime(antiguedadCalculada);

        resultadoAnt.setAntiguedad(antiguedadCalculadaDias);

        double anio = NumerosUtils.redondeoNumero(((double) antiguedadCalculadaDias / 365), 2);
        double m1 = anio - Math.floor(anio);
        double mes = NumerosUtils.redondeoNumero((m1 * 12), 2);
        
        double dias = NumerosUtils.redondeoNumero((((double) mes -  Math.floor(mes)) * 30), 2);
        resultadoAnt.setAnio((int)anio);
        resultadoAnt.setMes((int) mes);
        resultadoAnt.setDia((int) dias);
        return resultadoAnt;
    }
    
    @Override
    public DiferimientoVO obtenerIntIvaDif(int tnoCve, double tazaInt, int qnaDiferimiento, int refinancia,
            double montoOto, String fechaFinRef, double ultPagoRef, int cveEntidad, int cp) {
        DiferimientoVO diferimiento = null;
        double ivaOrig, ivaPagSdo = 0, intPagSdo = 0, intGanado, ivaGanDesQuin, restoDesQna = 0, sdoIvaDesQna = 0, sdoIntDesQna = 0,
                pagoIva, pagoInt, sdoCapDesQna, sdoTotCap;
        int numPagAntProy = 0, diasDesQna = 0, bndUltPagoRef = 0;
        double tzaDesQna;
//        double ultPagoProy = 0D;
        String qnaDesDif;
//        int aplica;
        Calendar fechaActual = Calendar.getInstance();
        SimpleDateFormat sdf = null;
        if (tnoCve == Constants.TNO_CVE_PENSION) {
            tzaDesQna = tazaInt / Constants.P_ANUAL;
            sdf = new SimpleDateFormat(Constants.FORMAT_SSYYMM);
            qnaDesDif = sdf.format(new Date());
            qnaDiferimiento = qnaDiferimiento + 1;
//            aplica = Constants.QUINCENAS_ANIO;
        } else {
            tzaDesQna = tazaInt / Constants.T_ANUAL;
            qnaDesDif = DateUtils.formatoFechaQuincena(new Date());
//            aplica = Constants.MESES_ANIO;
        }

        sdoCapDesQna = new Double(montoOto);
        ivaOrig = calFiva(cveEntidad, cp);
        sdoTotCap = new Double(sdoCapDesQna);
        sdoTotCap = NumerosUtils.redondeoNumero(sdoTotCap, Constants.REDONDEO_NUM);
        int qnadesdifI = new Integer(qnaDesDif);
        int qnarefI = new Integer(fechaFinRef.trim());
        for (int qna = 1; qna <= qnaDiferimiento; qna++) {
            restoDesQna = 0D;
            if (refinancia != 0
                    && qnadesdifI <= qnarefI) {
                restoDesQna = new Double(ultPagoRef);
                numPagAntProy++;
                bndUltPagoRef++;
            }
            if (qna == 1) {
                if (tnoCve != Constants.TNO_CVE_PENSION) {
                    if (fechaActual.get(Calendar.DAY_OF_MONTH) <= Constants.DIAS_QNA) {
                        diasDesQna = Constants.DIAS_QNA - fechaActual.get(Calendar.DAY_OF_MONTH) + 1;
                    } else if (fechaActual.get(Calendar.DAY_OF_MONTH) != Constants.DIAS_MES_LRG) {
                        diasDesQna = Constants.DIAS_MES - fechaActual.get(Calendar.DAY_OF_MONTH) + 1;
                    } else {
                        diasDesQna = 0;
                    }
                } else {
                    if (fechaActual.get(Calendar.DAY_OF_MONTH) != Constants.DIAS_MES_LRG) {
                        diasDesQna = Constants.DIAS_MES - fechaActual.get(Calendar.DAY_OF_MONTH) + 1;
                    } else {
                        diasDesQna = 0;
                    }
                }
                intGanado = sdoTotCap * diasDesQna * tazaInt / Constants.ANUAL;
                intGanado = NumerosUtils.redondeoNumero(intGanado, Constants.REDONDEO_NUM);

            } else {
                intGanado = sdoTotCap * tzaDesQna;
                intGanado = NumerosUtils.redondeoNumero(intGanado, Constants.REDONDEO_NUM);
            }
            if (qnadesdifI >= Constants.SSYYQQ_ENERO_2010) {
                if (ivaOrig < 15) {
                    ivaOrig = 11;
                } else {
                    ivaOrig = 16;
                }
            }

            ivaGanDesQuin = intGanado * ivaOrig / 100;
            ivaGanDesQuin = NumerosUtils.redondeoNumero(ivaGanDesQuin, Constants.REDONDEO_NUM);
            pagoIva = new Double(restoDesQna);
            restoDesQna = restoDesQna - ivaGanDesQuin;
            restoDesQna = NumerosUtils.redondeoNumero(restoDesQna, Constants.REDONDEO_NUM);

            if (restoDesQna > 0) {
                pagoInt = new Double(restoDesQna);
                restoDesQna = restoDesQna - intGanado;
                ivaPagSdo = ivaPagSdo + ivaGanDesQuin;
                sdoIvaDesQna = 0;
                if (restoDesQna > 0) {
                    sdoIntDesQna = 0;
                    sdoCapDesQna = sdoCapDesQna - restoDesQna;
                    intPagSdo = intPagSdo + intGanado;
                } else {
                    sdoIntDesQna = sdoIntDesQna - restoDesQna;
                    intPagSdo = intPagSdo + pagoInt;
                    sdoTotCap = sdoCapDesQna + sdoIntDesQna;
                    restoDesQna = 0;
                }
            } else {
                sdoIvaDesQna = sdoIvaDesQna - restoDesQna;
                sdoIntDesQna = sdoIntDesQna + intGanado;
                restoDesQna = 0;
                ivaPagSdo = ivaPagSdo + pagoIva;
                sdoTotCap = sdoTotCap + sdoIvaDesQna + sdoIntDesQna;
            }
            if (tnoCve != Constants.TNO_CVE_PENSION) {
                qnaDesDif = DateUtils.incrementaQuincena(qnaDesDif);
            } else {
                qnaDesDif = DateUtils.incrementaMes(qnaDesDif);
            }
        }

        diferimiento = new DiferimientoVO();
        diferimiento.setSaldoCapitalDesQna(NumerosUtils.redondeoNumero(sdoCapDesQna, Constants.REDONDEO_NUM));
        diferimiento.setIntPagSdo(NumerosUtils.redondeoNumero(intPagSdo, Constants.REDONDEO_NUM));
        diferimiento.setIvaPagadoSdo(NumerosUtils.redondeoNumero(ivaPagSdo, Constants.REDONDEO_NUM));
        diferimiento.setSdoIntDesQna(NumerosUtils.redondeoNumero(sdoIntDesQna, Constants.REDONDEO_NUM));
        diferimiento.setSdoIvaDesQna(NumerosUtils.redondeoNumero(sdoIvaDesQna, Constants.REDONDEO_NUM));

        /*System.out.println(diferimiento.getSaldoCapitalDesQna());
        System.out.println(diferimiento.getIntPagSdo());
        System.out.println(diferimiento.getIvaPagadoSdo());
        System.out.println(diferimiento.getSdoIntDesQna());
        System.out.println(diferimiento.getSdoIvaDesQna());
        diferimiento.setBndUltimoPagoRef(bndUltPagoRef);*/
        return diferimiento;
    }

    @Override
    public double calFiva(int cveEntidad, int cp) {
        double fiva = 0D;
        int cveTipoIva=0;
        boolean actProc = procesosOtorgamientoMService.activarProcesoFolFov(Constants.PROC_FIVA);
        if (!actProc) {
            CIvaFrontVO ivaFront = ivasDao.obtenerIvaFronterizo(cveEntidad, cp);
            Calendar fechaActual = Calendar.getInstance();
            if (ivaFront == null) {
                if (fechaActual.get(Calendar.YEAR) >= Constants.ANIO_2010) {//aqui ya no deberia de entrar debido a que ya estamos en 2014 pero se conserva para integridad
                    cveTipoIva = Constants.CVE_TIPO_IVA_MET_ACT;
                } else {
                    cveTipoIva = Constants.CVE_TIPO_IVA_MET_ANT;
                }
            } else {
                if (fechaActual.get(Calendar.YEAR) >= Constants.ANIO_2010) {//aqui ya no deberia de entrar debido a que ya estamos en 2014 pero se conserva para integridad
                    cveTipoIva = Constants.CVE_TIPO_IVA_FRON_ACT;
                } else {
                    cveTipoIva = Constants.CVE_TIPO_IVA_FRON_ANT;
                }
            }
        }
        fiva = ivasDao.obtenerPorcTipIva(cveTipoIva);
        return fiva;
    }

    @Override
    public double calcularCapacidadPago(int numIssste, int cveRamo, String cvePagaduria, double sueldoIssste, int tnoCve) {
        double capacidadPago = 0;
        double dsctoFovi = 0;
        DeduccionesVO deduccion = null;
        if (tnoCve == Constants.TNO_CVE_PENSION) {
            capacidadPago = sueldoIssste * .5;
        } else {
            capacidadPago = sueldoIssste * .25;
        }

        //Código cliente webService AMS

        dsctoFovi = obtenDsctoFovi(numIssste, cveRamo, cvePagaduria);
        /*
        boolean myBoolean = mService.activarProcesoFolFov(Constants.PROC_FOVIS); 
        double ultPago = iWebService.getUltPgoReal(numIssste);
        if(myBoolean&&ultPago!=-1)
        {
        dsctoFovi = ultPago;
        }
        else
        {
        deduccion = deduccionesDao.obtenerDeduccion(numIssste, cveRamo, cvePagaduria);
        if (deduccion != null) {
        dsctoFovi = deduccion.getDsctoFovissste();
        }        
        }
         */
        capacidadPago = capacidadPago - dsctoFovi;
        return NumerosUtils.redondeoNumero(capacidadPago, Constants.REDONDEO_NUM);
    }

    public double obtenDsctoFovi(int numIssste, int cveRamo, String cvePagaduria) {
        double dsctoFovi = 0;
        double ultPago = -1;
        DeduccionesVO deduccion = null;

        boolean myBoolean = mService.activarProcesoFolFov(Constants.PROC_FOVIS);
        if (myBoolean) {
            ultPago = iWebService.getUltPgoReal(numIssste);
        }
        if (ultPago != -1) {
            dsctoFovi = ultPago;

        } else {
            deduccion = deduccionesDao.obtenerDeduccion(numIssste, cveRamo, cvePagaduria);
            if (deduccion != null) {
                dsctoFovi = deduccion.getDsctoFovissste();
            }
        }

        return dsctoFovi;
    }

    @Override
    public CalculoDescuentoVO calcularDescuento(DescuentoProcVO condiciones, double fiva) {
        CalculoDescuentoVO resultadoDescuento = new CalculoDescuentoVO();
        double tasa = 0;
        //double fiva = 0;
        double intDif = 0;
        double ivaDif = 0;
        double rPrim = 0;
        double descuento = 0;
        double intOrigSIva = 0;
        double intOrigCIva = 0;
        double ivaOrig = 0;
        tasa = calTasa(condiciones.getTasaInt(), condiciones.getTnoCve());
        intDif = calIntDiferimiento(condiciones.getMontoOtorg(), tasa, condiciones.getDif(), condiciones.getTnoCve());
//        fiva = calFiva(condiciones.getCveEntidad(), condiciones.getCp());
        ivaDif = calIvaDif(intDif, fiva);
        rPrim = calRPrim(tasa, fiva);

        /*System.out.println("tasa" + tasa);
        System.out.println("intDif" + intDif);
        System.out.println("ivaDif" + ivaDif);
        System.out.println("fiva" + fiva);
        System.out.println("rPrim" + rPrim);*/
        descuento = (condiciones.getSdoCapDesQna() + condiciones.getSdoIntdesQna() + condiciones.getSdoIvadesQna()) * rPrim
                / (1 - Math.pow(1 + rPrim, -1 * condiciones.getPlazoOtorg()));
        descuento = NumerosUtils.redondeoNumero(descuento, Constants.REDONDEO_NUM);
        intOrigCIva = (descuento * condiciones.getPlazoOtorg()) - condiciones.getSdoCapDesQna();
        intOrigCIva = NumerosUtils.redondeoNumero(intOrigCIva, Constants.REDONDEO_NUM);
        intOrigSIva = intOrigCIva / (1 + (fiva / 100));
        intOrigSIva = NumerosUtils.redondeoNumero(intOrigSIva, Constants.REDONDEO_NUM);
        ivaOrig = intOrigCIva - intOrigSIva;
        ivaOrig = NumerosUtils.redondeoNumero(ivaOrig, Constants.REDONDEO_NUM);
        intOrigSIva += condiciones.getIntPagSdo();
        intOrigSIva = NumerosUtils.redondeoNumero(intOrigSIva, Constants.REDONDEO_NUM);
        ivaOrig += condiciones.getIvaPagSdo();
        ivaOrig = NumerosUtils.redondeoNumero(ivaOrig, Constants.REDONDEO_NUM);
        resultadoDescuento.setDescuento(descuento);
        resultadoDescuento.setFiva(fiva);
        resultadoDescuento.setIntPagSdo(condiciones.getIntPagSdo());
        resultadoDescuento.setIntOrigSIVA(intOrigSIva);
        resultadoDescuento.setIvaOrig(ivaOrig);
        resultadoDescuento.setR(tasa);
        resultadoDescuento.setrPrim(rPrim);
        resultadoDescuento.setIntDif(intDif);
        resultadoDescuento.setIvaDif(ivaDif);
        return resultadoDescuento;
    }

    /**
     * el proceso de desuento realiza las validaciones y obtiene los calculos de
     * los descuentos
     *
     * @param aProcesar informacion necesaria para calcular los descuentos
     * @return
     */
    @Override
    public DescuentoVO procesarDscto(DescuentoProcVO aProcesar, double fiva) {
        DescuentoVO descuento = new DescuentoVO();
        int bndPrimas = 0;
        double ultPagAntProy = new Double(aProcesar.getAmtLastPmt());
        int numPagoAntProy = new Integer(aProcesar.getQnasF());
        double montoOtorg = new Double(aProcesar.getMontoOtorg());
        double sdoCapDesQna = new Double(aProcesar.getSdoCapDesQna());
        double desctuento = aProcesar.getDescuento();
        double plazoOtorg = aProcesar.getPlazoOtorg();
        DiferimientoVO diferimiento = new DiferimientoVO();
        CalculoDescuentoVO resCalculo = null;
        descuento.setUltimoPagoProy(new Double(aProcesar.getUltPagoRef()));
        descuento.setNumPagoAntProy(numPagoAntProy);
//        double fiva = calFiva(aProcesar.getCveEntidad(), aProcesar.getCp());
        //System.out.println("desctuento > aProcesar.getCapacidadPago()" + desctuento + " " + aProcesar.getCapacidadPago());

        if (desctuento > aProcesar.getCapacidadPago()) {

            if (aProcesar.getCveTcr() != 12//cambiar por la constante
                    && aProcesar.getCveTcr() != 19) {
                bndPrimas = 1;
                int i = 0;
                //System.out.println("aProcesar.getDescuento() > aProcesar.getCapacidadPago()" + aProcesar.getDescuento() + " " + aProcesar.getCapacidadPago());
                while (aProcesar.getDescuento() > aProcesar.getCapacidadPago()) {
                    //borrar
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");
                    System.out.println("Hora ::iteracion::" + i + "::" + sdf.format(new Date()));
                    i++;
                    //fin borrar
                    montoOtorg -= 50;
                    sdoCapDesQna -= 50;
                    //obtenerIntIvaDif(aProcesar.getTnoCve(), aProcesar.getTasaInt(), aProcesar.getDif(),aProcesar.getRefinancia(), montoOtorg, aProcesar.getFechaFinRef(), aProcesar.getUltPagoRef());

                    aProcesar.setMontoOtorg(montoOtorg);
                    aProcesar.setSdoCapDesQna(sdoCapDesQna);
                    diferimiento = obtenerIntIvaDif(aProcesar.getTnoCve(), aProcesar.getTasaInt(), aProcesar.getDif(),
                            aProcesar.getRefinancia(), montoOtorg, aProcesar.getFechaFinRef(), aProcesar.getUltPagoRef(),
                            aProcesar.getCveEntidad(), aProcesar.getCp());
                    aProcesar.setSdoCapDesQna(diferimiento.getSaldoCapitalDesQna());
                    aProcesar.setIntPagSdo(diferimiento.getIntPagSdo());
                    aProcesar.setIvaPagSdo(diferimiento.getIvaPagadoSdo());
                    aProcesar.setSdoIntdesQna(diferimiento.getSdoIntDesQna());
                    aProcesar.setSdoIvadesQna(diferimiento.getSdoIvaDesQna());
                    /*System.out.println(aProcesar.getSdoCapDesQna());
                    System.out.println(aProcesar.getIntPagSdo());
                    System.out.println(aProcesar.getIvaPagSdo());
                    System.out.println(aProcesar.getSdoIntdesQna());
                    System.out.println(aProcesar.getSdoIvadesQna());
                    System.out.println(aProcesar.getDif());*/
                    resCalculo = calcularDescuento(aProcesar, fiva);
                    desctuento = resCalculo.getDescuento();
                    aProcesar.setDescuento(desctuento);

                }
            } else {
                /**
                 * # Para damnificados * Si el descuento es mayor a la capacidad
                 * de pago, se aumenta el plazo*
                 */
                // plazoOtorg = aProcesar.getPlazoOtorg();
                List<Integer> plazos = (List<Integer>) (List) credParamDao.obtenerPlazoCredParaDamnificados();
                for (int plazo : plazos) {
                    plazoOtorg = plazo;
                    if (aProcesar.getTnoCve() == Constants.TNO_CVE_PENSION) {
                        plazoOtorg = plazoOtorg / 2;
                    }
                    aProcesar.setPlazoOtorg(plazoOtorg);
                    /* System.out.println(aProcesar.getPlazoOtorg());
                    System.out.println(aProcesar.getMontoOtorg());
                    System.out.println(aProcesar.getTasaInt());
                    System.out.println(aProcesar.getDif());
                    System.out.println(aProcesar.getSdoCapDesQna());
                    System.out.println(aProcesar.getIntPagSdo());
                    System.out.println(aProcesar.getIvaPagSdo());
                    System.out.println(aProcesar.getSdoIntdesQna());
                    System.out.println(aProcesar.getSdoIvadesQna());*/
                    resCalculo = calcularDescuento(aProcesar, fiva);
                    if (resCalculo.getDescuento() < aProcesar.getCapacidadPago()) {
                        break;
                    }
                }
                /**
                 * cuando aún a 120 quincenas no es capaz de pagar los 30 mil
                 * pesos*
                 */
                /* System.out.println("Monto Final " + aProcesar.getMontoOtorg());
                System.out.println("Descuento---Final-" + resCalculo.getDescuento());
                System.out.println("Descuento---Final-" + resCalculo.getFiva());
                System.out.println("Descuento---Final-" + resCalculo.getIntPagSdo());
                System.out.println("Descuento---Final-" + resCalculo.getIntOrigSIVA());
                System.out.println("Descuento---Final-" + resCalculo.getIvaOrig());
                System.out.println("Descuento---Final-" + resCalculo.getR());
                System.out.println("Descuento---Final-" + resCalculo.getrPrim());*/
                if (resCalculo.getDescuento() > aProcesar.getCapacidadPago()) {
                    /**
                     * si no le alcanza para pagar con el plazo de 120 entonces
                     * le empieza a disminuir el monto del préstamo
                     */
                    bndPrimas = 1;
                    while (resCalculo.getDescuento() > aProcesar.getCapacidadPago()) {
                        montoOtorg -= 50;
                        sdoCapDesQna -= 50;

                        aProcesar.setMontoOtorg(montoOtorg);
                        //aProcesar.setSdoCapDesQna(sdoCapDesQna);
                        diferimiento = obtenerIntIvaDif(aProcesar.getTnoCve(), aProcesar.getTasaInt(), aProcesar.getDif(),
                                aProcesar.getRefinancia(), montoOtorg, aProcesar.getFechaFinRef(), aProcesar.getUltPagoRef(),
                                aProcesar.getCveEntidad(), aProcesar.getCp());
                        aProcesar.setSdoCapDesQna(diferimiento.getSaldoCapitalDesQna());
                        aProcesar.setIntPagSdo(diferimiento.getIntPagSdo());
                        aProcesar.setIvaPagSdo(diferimiento.getIvaPagadoSdo());
                        aProcesar.setSdoIntdesQna(diferimiento.getSdoIntDesQna());
                        aProcesar.setSdoIvadesQna(diferimiento.getSdoIvaDesQna());

                        resCalculo = calcularDescuento(aProcesar, fiva);
                        desctuento = resCalculo.getDescuento();
                        aProcesar.setDescuento(desctuento);

                    }//fin de while
                }//fin de if
            }//fin de if
        }//fin de if

        /*System.out.println("Monto---Final-" + aProcesar.getMontoOtorg());
        System.out.println("Descuento---Final-" + aProcesar.getDescuento());
        System.out.println("Descuento---Final-" + resCalculo.getFiva());
        System.out.println("Descuento---Final-" + resCalculo.getIntPagSdo());
        System.out.println("Descuento---Final-" + resCalculo.getIntOrigSIVA());
        System.out.println("Descuento---Final-" + resCalculo.getIvaOrig());
        System.out.println("Descuento---Final-" + resCalculo.getR());
        System.out.println("Descuento---Final-" + resCalculo.getrPrim());*/

        if (aProcesar.getCapacidadPago() <= 0) {
            descuento.setValidacionDscto(false);
        } else {
            descuento.setValidacionDscto(true);
        }
        if (aProcesar.getCveTcr() == 12
                || aProcesar.getCveTcr() == 19) {
            descuento.setMontoOtorgado(sdoCapDesQna);
        } else {
            descuento.setMontoOtorgado(montoOtorg);
        }
        descuento.setDescuento(desctuento);
        descuento.setPlazoOtorgado(plazoOtorg);
        descuento.setNumPagoAntProy(numPagoAntProy);
        descuento.setUltimoPagoProy(ultPagAntProy);
        descuento.setBndPrimas(bndPrimas);
        descuento.setBndUltimoPagoRef((int) diferimiento.getBndUltimoPagoRef());
        if (resCalculo != null) {
            descuento.setCalculoDescuentoVO(resCalculo);
        }
        descuento.setDescuentoProcVO(aProcesar);
        return descuento;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = OtwException.class)
    public RefinanciamientoVO obtieneRefinanciamiento(int numIssste, int tpoCredito, String tnoCve, double origLoanPrin,
            double intRate, int cveEntidad, int ldCodigoPos, int simulacion, String ipEquipo) throws ParseException {

        RefinanciamientoVO prsRef = new RefinanciamientoVO();
        List<PrstamoOrigVO> listaPrestamos = null;
        ProyeccionVO voProy = null;
        Integer cntRef = 0;
        double opSaldoInteres = 0.0;
        double opSaldIva = 0.0;
        double opSaldoProy = 0.0;
        DateUtils dtUtl = new DateUtils();
        Date fechaActual = new Date();
        List<QnaVO> listQna = new ArrayList<QnaVO>();
        List<PrestamoProyeccionVO> lsPrsProyeccion = null;
        dtUtl.FechaCorte();
        ProyeccionVO proy = new ProyeccionVO();

        int lsRef = 0;
        Double ldSaldoRefTot = 0d;
        double CapTotRef = 0;
        double IntTotRef = 0;
        double IvaTotRef = 0;
        Double ldMtoOtorg = origLoanPrin;
        Double lcIpEquipo;
        Double pagoRef1 = 0D;
        Double pagoRef2 = 0D;
        Double pagoRef3 = 0D;
        double idDia = 0;
        double ID1qna = 0;
        double ldSaldoRef;
        double ldCapRefinanc;
        double ldIntRefinanc = 0D;
        double ldIvaRefinanc = 0D;
        double ivaDif;
        double ldDesc = 0;
        double id = 0D;
        Date fechaProy;
        Date fechaCorte = DateUtils.calculaFechaCorte();
        double ldAmtLastPmt = 0D;
        double fIva = 0;
        int diasProy = 0;
        int diasAct = 0;
        double lsDias = 0;
        int lsQdif = 0;
        double idDIas;
        int comparaFecha;
        List<Double> numPresRef = new ArrayList<Double>();

        double tasaInteres = this.cal_r(intRate, tnoCve);
        QnaVO fecActual = DateUtils.qnasTranscurridas(fechaActual, fechaActual).get(0);
        int qnaActual = (fecActual.getAnio() * 100) + fecActual.getQna();
        int lsQnas = 0;

        //indica si existen creditos a refinanciar
        boolean bandera = false;

        //Valida si existen Prestamos a refinanciar
        cntRef = prestamoOrigDao.countPrestamosRefininanciamiento(numIssste);

        if (cntRef > 0) {
            prsRef.setBandera(bandera = true);
            //obtiene prestamos vigentes por numero de issste
            listaPrestamos = prestamoOrigDao.obtenerPrestamosVigentes(numIssste);

            for (PrstamoOrigVO lsVig : listaPrestamos) {

                if (lsRef < 3) {
                    numPresRef.add(lsVig.getLoanNbr());
                }

                //Obtiene proyeccion por numero de prestamo
                //System.out.println("lsVig.getLoanNbr()"+lsVig.getLoanNbr());
                voProy = proyeccionDao.obtenerProyeccionByID(lsVig.getLoanNbr());

                //valida exista proyeccion
                if (voProy != null) {
                    //System.out.println("voProy.getCurrPrinBal()" + voProy.getCurrPrinBal() + voProy.getIntEarnedToDate() + voProy.getTotIntPd()+voProy.getTotIvaGan() + voProy.getTotIvaPag());

                    ldSaldoRef = voProy.getCurrPrinBal() + (voProy.getIntEarnedToDate() - voProy.getTotIntPd()) + (voProy.getTotIvaGan() - voProy.getTotIvaPag());
                    ldCapRefinanc = voProy.getCurrPrinBal();
                    ldIntRefinanc = voProy.getIntEarnedToDate() - voProy.getTotIntPd();
                    ldIvaRefinanc = voProy.getTotIvaGan() - voProy.getTotIvaPag();
                    fechaProy = voProy.getDatePastPay();
                    ldAmtLastPmt = voProy.getAmtLastPmt();
                    //Se calcula el numero de quinsenas transcurridas
                    lsQnas = DateUtils.qnasTranscurridas(fechaProy, fechaCorte).size();
                    //System.out.println("ldSaldoRef" + ldSaldoRef);
                    if (ldSaldoRef < 0) {
                        ldSaldoRef = 0;
                    } else {
                        //System.out.println("fechaProy" + fechaProy + "fechaCorte" + fechaCorte);
                        //comparaFecha = fechaCorte.compareTo(fechaProy);
                        // comparaFecha = DateUtils.compararFechas(fechaCorte, fechaProy);
                        /*if (comparaFecha > 0) {
                        //qna transcurridas.
                        listQna = DateUtils.qnasTranscurridas(fechaProy, fechaCorte);
                        
                        //obtiene proyeccion
                        
                        //System.out.println("voProy.getLoanNbr()>>>>>>>>>>" + voProy.getLoanNbr());
                        if (voProy.getLoanNbr() > 0) {
                        lsPrsProyeccion = proyeccionDao.obtenerPrestamosVigentes(voProy.getLoanNbr());
                        } else {
                        lsPrsProyeccion = proyeccionDao.obtenerPrestamosCero();
                        }
                        System.out.println("lsPrsProyeccion>>>>>>>" + lsPrsProyeccion.size());
                        proy = this.proyeccionPrs(fechaActual, lsPrsProyeccion, simulacion, listQna, ldAmtLastPmt, ipEquipo);
                        
                        System.out.println("lsPrsProyeccion>>>>>>>" + lsPrsProyeccion.size());
                        
                        if (proy.getCurrPrinBal() == null) {
                        proy.setCurrPrinBal(0.0);
                        }
                        
                        if (proy.getIntEarnedToDate() == null) {
                        proy.setIntEarnedToDate(0.0);
                        }
                        
                        if (proy.getTotIntPd() == null) {
                        proy.setTotIntPd(0.0);
                        }
                        
                        if (proy.getTotIvaGan() == null) {
                        proy.setTotIvaGan(0.0);
                        }
                        
                        if (proy.getTotIvaPag() == null) {
                        proy.setTotIvaPag(0.0);
                        }
                        
                        ldSaldoRef = proy.getCurrPrinBal() + (proy.getIntEarnedToDate() - proy.getTotIntPd()) + ((proy.getTotIvaGan() - proy.getTotIvaPag()));
                        ldCapRefinanc = proy.getCurrPrinBal();
                        ldIntRefinanc = proy.getIntEarnedToDate() - proy.getTotIntPd();
                        ldIvaRefinanc = proy.getTotIvaGan() - proy.getTotIvaPag();
                        
                        fechaProy = fechaCorte;
                        }*/
                    }

                    //comparaFecha = DateUtils.compararFechas(fechaCorte, fechaProy);
                    // if (comparaFecha == 0) {
                    ID1qna = NumerosUtils.redondeoNumero(ldSaldoRef * tasaInteres, 9);

                    //System.out.println("tnoCve" + tnoCve + "IDQ---" + ID1qna);
                    //Calcular interes diario
                    if (tnoCve.trim().equals("30")) {
                        idDia = ID1qna / Constants.DIAS_MES;
                    } else {
                        idDia = ID1qna / Constants.DIAS_QNA;
                    }

                    diasProy = fechaProy.getDate();
                    diasAct = fechaActual.getDate();
                    lsDias = 0;
                    /*Dias para proyectar el diferimiento*/
                    if (diasProy > diasAct) {
                        lsDias = diasAct - 1;
                    } else {
                        lsDias = (diasProy - diasAct) - 1;
                    }
                    lsDias = NumerosUtils.truncate(lsDias, 9);
                    //System.out.println("lsDias" + lsDias);

                    /*Se calcula el factor de iva revisar si se puede mandar como parametro encaso de ya tenerlo calculado*/
                    fIva = this.calFiva(cveEntidad, ldCodigoPos);

                    //System.out.println("fiva" + fIva + "I_dia" + idDia);
                        /*Se calcula el interes por el numero de dias*/
                    idDIas = NumerosUtils.truncate(idDia * lsDias, 9);
                    /*Calcular el iva de diferimiento*/
                    ivaDif = NumerosUtils.truncate(this.calIvaDif(idDIas, fIva), 12);
                    //System.out.println("idDIas" + idDIas + "ivaDif" + ivaDif);

//                        ProyeccionVO pr = new ProyeccionVO();
                    proy.setLoanNbr(voProy.getLoanNbr());
                    proy.setPerIntMrtoGan(idDIas);
                    proy.setPerIntMrtoPag(ivaDif);
                    this.proyeccionDao.actualizaProyIVA(proy);

                    ldIntRefinanc = ldIntRefinanc + idDIas;
                    ldIvaRefinanc = ldIvaRefinanc + ivaDif;
                    ldSaldoRef = ldCapRefinanc + ldIntRefinanc + ldIvaRefinanc;
                    CapTotRef = NumerosUtils.redondeoNumero(CapTotRef + ldCapRefinanc, 2);
                    IntTotRef = NumerosUtils.redondeoNumero(IntTotRef + ldIntRefinanc, 2);
                    IvaTotRef = NumerosUtils.redondeoNumero(IvaTotRef + ldIvaRefinanc, 2);
                    ldDesc = ldAmtLastPmt;
                    ldSaldoRefTot = ldSaldoRef;
                    /*System.out.println("R" + tasaInteres);
                    System.out.println("Capitales" + ldCapRefinanc + "---" + ldIntRefinanc + "---" + ldIvaRefinanc);
                    System.out.println("ldSaldoRefTot>>>>" + ldSaldoRefTot);*/
                    if (lsQnas <= 0) {
                        ldAmtLastPmt = 0;
                    }
                    //TODO: se revisara este bloque de codigo
                    for (int i = 1; i <= lsQdif; i++) {
                        if (i == 1) {
                            id = NumerosUtils.truncate(calcIntDia(new Integer(tnoCve), ldMtoOtorg, tasaInteres), 2);
                        } else {
                            id = NumerosUtils.truncate(ldMtoOtorg * tasaInteres, 2);
                        }
                        ivaDif = NumerosUtils.truncate(calIvaDif(id, fIva), 2);
                        if (ldAmtLastPmt > 0) {
                            if (ldDesc > ivaDif) {
                                ldDesc -= ivaDif;
                            } else {
                                ldDesc += ivaDif;
                            }
                            if (ldDesc > id) {
                                ldDesc -= id;
                            } else {
                                ldDesc += id;
                            }
                            origLoanPrin -= ldDesc;
                        } else {
                            ldDesc = ldDesc + id + ivaDif;
                        }
                        ldDesc = ldAmtLastPmt;
                    }
                    //  }

                }

                lsRef = lsRef + 1;
                switch (lsRef) {
                    case 0:
                        pagoRef1 = ldSaldoRefTot;
                        break;
                    case 1:
                        pagoRef2 = ldSaldoRefTot;
                        break;
                    case 2:
                        pagoRef3 = ldSaldoRefTot;
                        break;

                }
            }

            ldSaldoRefTot = pagoRef1 + pagoRef2 + pagoRef3;
            ldSaldoRefTot = NumerosUtils.truncate(ldSaldoRefTot, 2);
        }

        prsRef.setBandera(bandera);

        prsRef.setLdSaldoRef(ldSaldoRefTot);
        prsRef.setLdCapRefinanc(CapTotRef);
        prsRef.setLdIntRefinanc(ldIntRefinanc);
        prsRef.setLdIvaRefinanc(ldIvaRefinanc);
        prsRef.setLsQnasf(lsQnas);
        prsRef.setLdAmtLastPmt(ldAmtLastPmt);
        //prsRef.setPrstamoOrigVO();
        prsRef.setPagoRef1(pagoRef1);
        prsRef.setPagoRef2(pagoRef2);
        prsRef.setPagoRef3(pagoRef3);
        prsRef.setNumPresRef(numPresRef);

        return prsRef;
    }

    public ProyeccionVO proyeccionPrs(Date fechCorte, List<PrestamoProyeccionVO> lsPrsProyeccion, int actualiza, List<QnaVO> listQna, double ldAmtLastPmt, String ipEquipo) {
        int cntConvenios = 0;
        int cntLiquidados = 0;
        int cntCarteraVenc = 0;
        int numQnas = 0;
        int cntPrimeraVez = 0;
        int cntPrestamo = 0;
        int cntQnaPaso = 0;
        int cntEnproceso = 0;
        int bndPen = 0;
        int lsCero = 0;
        int primProy = 1;

        int diaDatePastPay = 0;
        int difAnio = 0;
        int periodoDif = 0;
        int comparaFecha = 0;
        int proyParam = 0;

        RefinanciamientoVO refVO = new RefinanciamientoVO();


        double interesAcumulado = 0.0;
        double interesPagado = 0.0;
        double interesGanado;
        double ivaAcumulado = 0.0;
        double ivaPagado = 0.0;
        double ivaGanado = 0;
        double saldoCapital = 0;
        double montoPago = 0;
        double capAplicado = 0;
        double intAplicado = 0;
        double ivaAplicado = 0;
        double rinteresGanado = 0;
        double rivaGanado = 0;
        double rcapAplicado = 0;
        double rintAplicado = 0;
        double rivaAplicado = 0;
        double rmontoPago = 0;
        double winteresGanado = 0;
        double wivaGanado = 0;
        double wcapAplicado = 0;
        double wintAplicado = 0;
        double wivaAplicado = 0;
        double wsSaldo = 0.0;
        double wsSald1 = 0.0;
        double lsPagov = 0.0;
        int liPrimeravez = 0;
        int li_enproceso = 0;
        QnaVO lcQnaPaso = null;
        int cntForX = 0;
        QnaVO qnaProy = null;
        QnaVO qnaUltPago = null;
        QnaVO qnaOtorga = null;

        int liPrestamos = 0;
        double ldCappagado = 0;
        double ldIntganado = 0;
        double ldIntpagado = 0;
        double ldIvaganado = 0;
        double ldIvapagado = 0;
        int idPosicion = 0;
        ProyeccionVO proyVO = new ProyeccionVO();
        Calendar cal = Calendar.getInstance();

        cal.set(2004, 8, 20);
        Date fechaNoRefi = cal.getTime();

        ProyAuxVO proyAuxVO = new ProyAuxVO();
        List<ProyAuxVO> lstAux = new ArrayList<ProyAuxVO>();

        for (PrestamoProyeccionVO ls : lsPrsProyeccion) {

            // System.out.println("ls.getPrestamo().getLoanNbr()>>>>>>>>" + ls.getPrestamo().getLoanNbr());
            cntPrestamo = cntPrestamo + 1;
            if (ls.getProyeccion().getStatConvenio() != null) {
                if (ls.getProyeccion().getStatConvenio().trim().equals("A")) {
                    cntConvenios = cntConvenios + 1;
                }
            }

            if (ls.getProyeccion().getCurrPrinBal() < 0) {
                cntLiquidados = cntLiquidados + 1;
            }

            if (ls.getProyeccion().getStatCobr() >= 4) {
                cntCarteraVenc = cntCarteraVenc + 1;
            }

            //Verifica si es la primera proyeccion
            qnaProy = DateUtils.qnasTranscurridas(fechCorte, fechCorte).get(0);
            //fecha de último pago de la tabla de proyeccion
            qnaUltPago = DateUtils.qnasTranscurridas(ls.getProyeccion().getDatePastPay(), ls.getProyeccion().getDatePastPay()).get(0);
            //fecha de otorgamiento del préstamo de prstamo_original
            qnaOtorga = DateUtils.qnasTranscurridas(ls.getPrestamo().getLoanIssue_date(), ls.getPrestamo().getLoanIssue_date()).get(0);

            //encontrar la diferencia entre qnaproyectada y qna existente en proyeccion
            numQnas = DateUtils.qnasTranscurridas(ls.getProyeccion().getDatePastPay(), fechCorte).size();
            int proyQna = (qnaProy.getAnio() * 100) + qnaProy.getQna() - 1;

            //qnaTasa = qnaUltPago;

            comparaFecha = ls.getPrestamo().getLoanIssue_date().compareTo(ls.getProyeccion().getDatePastPay());

            numQnas = numQnas - 1;

            if (comparaFecha == 0) {
                liPrimeravez = liPrimeravez + 1;
                numQnas = numQnas + 1;
                lcQnaPaso = qnaUltPago;
            } else {
                lcQnaPaso = DateUtils.incrementaQuincena(qnaUltPago);
            }

            if (numQnas > 0) {

                fechCorte = qnaProy.getFechQna();
                li_enproceso = li_enproceso + 1;
                interesAcumulado = ls.getProyeccion().getIntEarnedToDate();
                interesPagado = ls.getProyeccion().getTotIntPd();
                ivaAcumulado = ls.getProyeccion().getTotIvaGan();
                ivaPagado = ls.getProyeccion().getTotIvaPag();
                wsSaldo = ls.getProyeccion().getCurrPrinBal();
                wsSald1 = ls.getProyeccion().getCurrPrinBal();

                for (int x = 0; x < numQnas; x++) {

                    if (actualiza == 0) {
                        lsPagov = ldAmtLastPmt;
                    }

                    ProyeccionVO proyVoPrs = this.proyeccionPrestamo(ls.getPrestamo().getLoanNbr(), lsCero, lsPagov, fechCorte, actualiza, interesAcumulado, interesPagado, ivaAcumulado, ivaPagado, wsSald1, ipEquipo);

                    saldoCapital = proyVoPrs.getCurrPrinBal();
                    interesAcumulado = proyVoPrs.getIntEarnedToDate();
                    interesPagado = proyVoPrs.getTotIntPd();
                    ivaAcumulado = proyVoPrs.getTotIvaGan();
                    ivaPagado = proyVoPrs.getTotIvaPag();
                    periodoDif = proyVoPrs.getPeriodoDif();
                    winteresGanado = proyVoPrs.getPerIntEarned();;
                    wivaGanado = proyVoPrs.getPerIvaGan();
                    wcapAplicado = proyVoPrs.getPerPrincPd();
                    wintAplicado = proyVoPrs.getIntPer();
                    wivaAplicado = proyVoPrs.getIvaPer();
                    rinteresGanado = rinteresGanado + winteresGanado;
                    rivaGanado = rivaGanado + wivaGanado;
                    rcapAplicado = rcapAplicado + wcapAplicado;
                    rintAplicado = rintAplicado + wintAplicado;
                    rivaAplicado = rivaAplicado + wivaAplicado;
                    montoPago = proyVoPrs.getMtoPago();

                    wsSaldo = saldoCapital + (interesAcumulado - interesPagado);
                    wsSald1 = saldoCapital;

                    proyAuxVO = new ProyAuxVO();
                    proyAuxVO.setIdPosicion(11);
                    liPrestamos = liPrestamos + 1;
                    ldCappagado = ldCappagado + rcapAplicado;
                    ldIntganado = ldIntganado + rinteresGanado;
                    ldIntpagado = ldIntpagado + rintAplicado;
                    ldIvaganado = ldIvaganado + rivaGanado;
                    ldIvapagado = ldIvapagado + rivaGanado;
                    proyAuxVO.setLiPrestamos(liPrestamos);
                    proyAuxVO.setLdCappagado(ldCappagado);
                    proyAuxVO.setLdIntganado(ldIntganado);
                    proyAuxVO.setLdIntpagado(ldIntpagado);
                    proyAuxVO.setLdIvaganado(ldIvaganado);
                    proyAuxVO.setLdIvapagado(ldIvapagado);
                    lstAux.add(proyAuxVO);
                }

                proyAuxVO = new ProyAuxVO();
                proyAuxVO.setIdPosicion(10);
                liPrestamos = liPrestamos + 1;
                ldCappagado = ldCappagado + rcapAplicado;
                ldIntganado = ldIntganado + rinteresGanado;
                ldIntpagado = ldIntpagado + rintAplicado;
                ldIvaganado = ldIvaganado + rivaGanado;
                ldIvapagado = ldIvapagado + rivaGanado;
                proyAuxVO.setLiPrestamos(liPrestamos);
                proyAuxVO.setLdCappagado(ldCappagado);
                proyAuxVO.setLdIntganado(ldIntganado);
                proyAuxVO.setLdIntpagado(ldIntpagado);
                proyAuxVO.setLdIvaganado(ldIvaganado);
                proyAuxVO.setLdIvapagado(ldIvapagado);
                lstAux.add(proyAuxVO);

                if (periodoDif == 1) {
                    proyAuxVO = new ProyAuxVO();
                    proyAuxVO.setIdPosicion(3);
                    liPrestamos = liPrestamos + 1;
                    ldCappagado = ldCappagado + rcapAplicado;
                    ldIntganado = ldIntganado + rinteresGanado;
                    ldIntpagado = ldIntpagado + rintAplicado;
                    ldIvaganado = ldIvaganado + rivaGanado;
                    ldIvapagado = ldIvapagado + rivaGanado;
                    proyAuxVO.setLiPrestamos(liPrestamos);
                    proyAuxVO.setLdCappagado(ldCappagado);
                    proyAuxVO.setLdIntganado(ldIntganado);
                    proyAuxVO.setLdIntpagado(ldIntpagado);
                    proyAuxVO.setLdIvaganado(ldIvaganado);
                    proyAuxVO.setLdIvapagado(ldIvapagado);
                    lstAux.add(proyAuxVO);


                    if (montoPago == 0) {
                        proyAuxVO = new ProyAuxVO();
                        proyAuxVO.setIdPosicion(1);
                        liPrestamos = liPrestamos + 1;
                        ldCappagado = ldCappagado + rcapAplicado;
                        ldIntganado = ldIntganado + rinteresGanado;
                        ldIntpagado = ldIntpagado + rintAplicado;
                        ldIvaganado = ldIvaganado + rivaGanado;
                        ldIvapagado = ldIvapagado + rivaGanado;
                        proyAuxVO.setLiPrestamos(liPrestamos);
                        proyAuxVO.setLdCappagado(ldCappagado);
                        proyAuxVO.setLdIntganado(ldIntganado);
                        proyAuxVO.setLdIntpagado(ldIntpagado);
                        proyAuxVO.setLdIvaganado(ldIvaganado);
                        proyAuxVO.setLdIvapagado(ldIvapagado);
                        lstAux.add(proyAuxVO);
                    } else {
                        proyAuxVO = new ProyAuxVO();
                        proyAuxVO.setIdPosicion(2);
                        liPrestamos = liPrestamos + 1;
                        ldCappagado = ldCappagado + rcapAplicado;
                        ldIntganado = ldIntganado + rinteresGanado;
                        ldIntpagado = ldIntpagado + rintAplicado;
                        ldIvaganado = ldIvaganado + rivaGanado;
                        ldIvapagado = ldIvapagado + rivaGanado;
                        proyAuxVO.setLiPrestamos(liPrestamos);
                        proyAuxVO.setLdCappagado(ldCappagado);
                        proyAuxVO.setLdIntganado(ldIntganado);
                        proyAuxVO.setLdIntpagado(ldIntpagado);
                        proyAuxVO.setLdIvaganado(ldIvaganado);
                        proyAuxVO.setLdIvapagado(ldIvapagado);
                        lstAux.add(proyAuxVO);
                    }
                } else {

                    proyAuxVO = new ProyAuxVO();
                    proyAuxVO.setIdPosicion(9);
                    liPrestamos = liPrestamos + 1;
                    ldCappagado = ldCappagado + rcapAplicado;
                    ldIntganado = ldIntganado + rinteresGanado;
                    ldIntpagado = ldIntpagado + rintAplicado;
                    ldIvaganado = ldIvaganado + rivaGanado;
                    ldIvapagado = ldIvapagado + rivaGanado;
                    proyAuxVO.setLiPrestamos(liPrestamos);
                    proyAuxVO.setLdCappagado(ldCappagado);
                    proyAuxVO.setLdIntganado(ldIntganado);
                    proyAuxVO.setLdIntpagado(ldIntpagado);
                    proyAuxVO.setLdIvaganado(ldIvaganado);
                    proyAuxVO.setLdIvapagado(ldIvapagado);
                    lstAux.add(proyAuxVO);

                    if (montoPago == 0) {
                        proyAuxVO = new ProyAuxVO();
                        proyAuxVO.setIdPosicion(4);
                        liPrestamos = liPrestamos + 1;
                        ldCappagado = ldCappagado + rcapAplicado;
                        ldIntganado = ldIntganado + rinteresGanado;
                        ldIntpagado = ldIntpagado + rintAplicado;
                        ldIvaganado = ldIvaganado + rivaGanado;
                        ldIvapagado = ldIvapagado + rivaGanado;
                        proyAuxVO.setLiPrestamos(liPrestamos);
                        proyAuxVO.setLdCappagado(ldCappagado);
                        proyAuxVO.setLdIntganado(ldIntganado);
                        proyAuxVO.setLdIntpagado(ldIntpagado);
                        proyAuxVO.setLdIvaganado(ldIvaganado);
                        proyAuxVO.setLdIvapagado(ldIvapagado);
                        lstAux.add(proyAuxVO);
                    } else {

                        if (montoPago == 0) {
                            proyAuxVO = new ProyAuxVO();
                            proyAuxVO.setIdPosicion(5);
                            liPrestamos = liPrestamos + 1;
                            ldCappagado = ldCappagado + rcapAplicado;
                            ldIntganado = ldIntganado + rinteresGanado;
                            ldIntpagado = ldIntpagado + rintAplicado;
                            ldIvaganado = ldIvaganado + rivaGanado;
                            ldIvapagado = ldIvapagado + rivaGanado;
                            proyAuxVO.setLiPrestamos(liPrestamos);
                            proyAuxVO.setLdCappagado(ldCappagado);
                            proyAuxVO.setLdIntganado(ldIntganado);
                            proyAuxVO.setLdIntpagado(ldIntpagado);
                            proyAuxVO.setLdIvaganado(ldIvaganado);
                            proyAuxVO.setLdIvapagado(ldIvapagado);
                            lstAux.add(proyAuxVO);
                        }

                        if (montoPago > ls.getPrestamo().getPayAmt()) {
                            proyAuxVO = new ProyAuxVO();
                            proyAuxVO.setIdPosicion(6);
                            liPrestamos = liPrestamos + 1;
                            ldCappagado = ldCappagado + rcapAplicado;
                            ldIntganado = ldIntganado + rinteresGanado;
                            ldIntpagado = ldIntpagado + rintAplicado;
                            ldIvaganado = ldIvaganado + rivaGanado;
                            ldIvapagado = ldIvapagado + rivaGanado;
                            proyAuxVO.setLiPrestamos(liPrestamos);
                            proyAuxVO.setLdCappagado(ldCappagado);
                            proyAuxVO.setLdIntganado(ldIntganado);
                            proyAuxVO.setLdIntpagado(ldIntpagado);
                            proyAuxVO.setLdIvaganado(ldIvaganado);
                            proyAuxVO.setLdIvapagado(ldIvapagado);
                            lstAux.add(proyAuxVO);
                        }

                        if (montoPago == ls.getPrestamo().getPayAmt()) {
                            proyAuxVO = new ProyAuxVO();
                            proyAuxVO.setIdPosicion(7);
                            liPrestamos = liPrestamos + 1;
                            ldCappagado = ldCappagado + rcapAplicado;
                            ldIntganado = ldIntganado + rinteresGanado;
                            ldIntpagado = ldIntpagado + rintAplicado;
                            ldIvaganado = ldIvaganado + rivaGanado;
                            ldIvapagado = ldIvapagado + rivaGanado;
                            proyAuxVO.setLiPrestamos(liPrestamos);
                            proyAuxVO.setLdCappagado(ldCappagado);
                            proyAuxVO.setLdIntganado(ldIntganado);
                            proyAuxVO.setLdIntpagado(ldIntpagado);
                            proyAuxVO.setLdIvaganado(ldIvaganado);
                            proyAuxVO.setLdIvapagado(ldIvapagado);
                            lstAux.add(proyAuxVO);
                        } else {
                            if (montoPago > ls.getPrestamo().getPayAmt()) {
                                proyAuxVO = new ProyAuxVO();
                                proyAuxVO.setIdPosicion(8);
                                liPrestamos = liPrestamos + 1;
                                ldCappagado = ldCappagado + rcapAplicado;
                                ldIntganado = ldIntganado + rinteresGanado;
                                ldIntpagado = ldIntpagado + rintAplicado;
                                ldIvaganado = ldIvaganado + rivaGanado;
                                ldIvapagado = ldIvapagado + rivaGanado;
                                proyAuxVO.setLiPrestamos(liPrestamos);
                                proyAuxVO.setLdCappagado(ldCappagado);
                                proyAuxVO.setLdIntganado(ldIntganado);
                                proyAuxVO.setLdIntpagado(ldIntpagado);
                                proyAuxVO.setLdIvaganado(ldIvaganado);
                                proyAuxVO.setLdIvapagado(ldIvapagado);
                                lstAux.add(proyAuxVO);
                            }
                        }
                    }
                }
            } else {
                proyVO.setCurrPrinBal(ls.getProyeccion().getCurrPrinBal());
                proyVO.setIntEarnedToDate(ls.getProyeccion().getIntEarnedToDate());
                proyVO.setTotIntPd(ls.getProyeccion().getTotIntPd());
                proyVO.setTotIvaGan(ls.getProyeccion().getTotIvaGan());
                proyVO.setTotIvaPag(ls.getProyeccion().getTotIvaPag());
                proyVO.setNum_difer(ls.getProyeccion().getNum_difer());
                proyVO.setAmtLastPmt(ls.getProyeccion().getAmtLastPmt());
                proyVO.setIntEarnedToDate(ls.getProyeccion().getIntEarnedToDate());
                proyVO.setTotIvaGan(ls.getProyeccion().getTotIvaGan());
                proyVO.setCurrPrinBal(ls.getProyeccion().getCurrPrinBal());
                proyVO.setTotIntPd(ls.getProyeccion().getTotIntPd());
                //proyVO.setTotIvaPag(ls.getProyeccion().getTotIvaPag());

            }
        }
        return proyVO;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = OtwException.class)
    public ProyeccionVO proyeccionPrestamo(double loanNbr, int lsCero, double lsPagov, Date ldProyeccion, int liActualiza, double ldInteresAcumulado,
            double ldInteresPagado, double ldIvaAcumulado, double ldIvaPagado, double wsSald1, String ipEquipo) {

        int cntForX = 0;
        QnaVO qnaProy = null;
        QnaVO qnaUltPago = null;
        QnaVO qnaOtorga = null;
        double MtoPago = 0;
        int comparaFecha = 0;
        int periodoDif = 0;
        int numQnas = 0;
        int primProy = 0;
        int diaDatePastPay;
        ProyeccionVO proy = new ProyeccionVO();
        Date nuevoViejo = new Date();
        //TODO:esta mandando error
        Date fechaCorte = DateUtils.calculaFechaCorte();
        QnaVO qnaTasa = new QnaVO(fechaCorte);
        double saldoTotal = 0.0;
        double saldoTotalTasa = 0.0;
        double tasaInteres = 0.0;
        double saldoPorDia = 0.0;
        double intGan = 0.0;
        double ivaGan = 0.0;
        double ivaRate = 0.0;
        double difInt = 0.0;
        double difIva = 0.0;
        double ivaPer = 0.0;
        double intPer = 0.0;
        double capPer = 0.0;
        double perIntGan = 0.0;
        double perIntPag = 0.0;
        double perSdo = 0.0;
        double perIvaGan = 0.0;
        double perIvaPag = 0.0;
        double saldoAux = 0.0;
        RefinanciamientoVO tsRef = null;
        int diasAProy = 0;
        int bndPen = 0;
        Calendar cal = Calendar.getInstance();
        cal.set(2004, 8, 20);
        Date fechaNoRefi = cal.getTime();
        double wsSaldo = 0.0;
        double lsPago = 0.0;

        int compara = 0;
        List<PrestamoProyeccionVO> lsPrsProy = this.proyeccionDao.obtenerProyeccionPrestamo(loanNbr);

        for (PrestamoProyeccionVO proyVO : lsPrsProy) {
            cntForX = cntForX + 1;

            //Obtiene quincenas yyyyqq
            qnaProy = DateUtils.qnasTranscurridas(ldProyeccion, ldProyeccion).get(0);
            int intQnaProy = (qnaProy.getAnio() * 100) + qnaProy.getQna();

            qnaUltPago = DateUtils.qnasTranscurridas(proyVO.getProyeccion().getDatePastPay(), proyVO.getProyeccion().getDatePastPay()).get(0);
            int intQnaUltPago = (qnaUltPago.getAnio() * 100) + qnaUltPago.getQna();

            qnaOtorga = DateUtils.qnasTranscurridas(proyVO.getPrestamo().getLoanIssue_date(), proyVO.getPrestamo().getLoanIssue_date()).get(0);
            int intQnaOtorga = (qnaOtorga.getAnio() * 100) + qnaOtorga.getQna();

            //qnaMes Pensionados
            int qnaProyMes = 0;
            Integer payPerDue = Integer.parseInt(proyVO.getProyeccion().getFirstPayPerDue());

            int qnaPar = (qnaProy.getQna() % 2);
            int bandRegul = 0;

            if (proyVO.getPrestamo().getTnoCve().equals("30")) {
                qnaProyMes = (qnaProy.getAnio() * 100) + qnaProy.getMes();
            } else {
                qnaProyMes = intQnaProy;
            }

            if (liActualiza != 0) {
                MtoPago = proyVO.getProyeccion().getAmtLastPmt();
            } else {
                proy.setIntEarnedToDate(ldInteresAcumulado);
                proy.setTotIntPd(ldInteresPagado);
                proy.setTotIvaGan(ldIvaAcumulado);
                proy.setTotIvaPag(ldIvaPagado);
                proy.setCurrPrinBal(lsPagov);
            }

            if (proyVO.getPrestamo().getTnoCve().trim().equals("30")) {

                bandRegul = this.proyeccionDao.existeRegularizaion(proyVO.getPrestamo().getLoanNbr());
                comparaFecha = proyVO.getPrestamo().getLoanIssue_date().compareTo(fechaNoRefi);

                if ((comparaFecha >= 0) || (bandRegul > 0) && (qnaPar != 0)) {
                    proy = proyVO.getProyeccion();
                    proy.setMtoPago(MtoPago);
                    proy.setNum_difer(periodoDif);
                    return proy;
                }
            }

            if ((intQnaProy >= intQnaOtorga) && (qnaProyMes < payPerDue)) {
                periodoDif = 1;
                MtoPago = proyVO.getProyeccion().getImpPagoAntProy();

                if (intQnaProy == intQnaOtorga) {
                    primProy = 1;
                    numQnas = 1;

                    diaDatePastPay = proyVO.getProyeccion().getDatePastPay().getDate();

                    if (diaDatePastPay == 31) {
                        diasAProy = diaDatePastPay - proyVO.getPrestamo().getLoanIssue_date().getDate();
                    } else {
                        diasAProy = (diaDatePastPay - proyVO.getPrestamo().getLoanIssue_date().getDate()) + 1;
                    }
                }
            }

            qnaUltPago = DateUtils.incrementaQuincena(qnaUltPago);
            if (numQnas == 0) {
                numQnas = DateUtils.qnasTranscurridasVO(qnaUltPago, qnaProy).size();
            }

            if (proyVO.getPrestamo().getTnoCve().equals("30")) {

                compara = proyVO.getPrestamo().getLoanIssue_date().compareTo(fechaNoRefi);

                if (compara >= 0 || bandRegul > 0) {
                    nuevoViejo = this.proyeccionDao.ontieneRangoFechas().getRango1();
                } else {
                    if (qnaPar != 0) {
                        nuevoViejo = this.proyeccionDao.ontieneRangoFechas().getRango2();
                    } else {
                        nuevoViejo = this.proyeccionDao.ontieneRangoFechas().getRango1();
                    }
                }

                compara = proyVO.getProyeccion().getDatePastPay().compareTo(nuevoViejo);
                if (compara < 0) {
                    numQnas = 1;
                } else {
                    proy = proyVO.getProyeccion();
                    proy.setMtoPago(MtoPago);
                    proy.setNum_difer(periodoDif);
                    return proy;
                }
            } else {
                if (numQnas < 1) {

                    proy = proyVO.getProyeccion();
                    proy.setMtoPago(MtoPago);
                    proy.setNum_difer(periodoDif);
                    return proy;
                } else {
                    numQnas = 1;
                }
            }

            for (int i = 0; i < numQnas; i++) {

                tsRef = new RefinanciamientoVO();
                compara = proyVO.getPrestamo().getLoanIssue_date().compareTo(fechaNoRefi);

                if ((proyVO.getPrestamo().getTnoCve().trim().equals("30")) && (compara >= 0) || (bandRegul > 0)) {
                    bndPen = 1;
                } else {
                    bndPen = 0;
                }

                tasaInteres = this.calcTasasProyec(proyVO.getPrestamo().getLoanTypeCd(), qnaTasa, proyVO.getPrestamo().getIntRate(), qnaOtorga, proyVO.getPrestamo().getTnoCve(), bndPen);

                saldoTotal = (wsSaldo) + (ldInteresAcumulado - ldInteresPagado);

                if (saldoTotal < 0) {
                    break;
                }

                saldoTotalTasa = saldoTotal * tasaInteres;

                if (periodoDif == 1) {

                    if (primProy == 1) {
                        if (proyVO.getPrestamo().getTnoCve().trim().equals("30")) {
                            saldoPorDia = saldoTotalTasa / 30;
                        } else {
                            saldoPorDia = saldoTotalTasa / 15;
                        }
                        if (proyVO.getPrestamo().getLoanTypeCd() == 13) {
                            diasAProy = 15;
                        }

                        intGan = saldoPorDia * diasAProy;
                    } else {
                        intGan = saldoPorDia * diasAProy;
                    }

                    cal = Calendar.getInstance();
                    cal.set(2008, 4, 15);
                    Date date = cal.getTime();
                    comparaFecha = proyVO.getPrestamo().getLoanIssue_date().compareTo(date);

                    if ((proyVO.getPrestamo().getLoanTypeCd() == 13) && (comparaFecha > 0)) {
                        saldoPorDia = 0.0;
                        intGan = 0.0;
                    }
                } else {
                    intGan = saldoPorDia;
                }

                if ((lsPago <= 0) && (proyVO.getPrestamo().getLoanTypeCd() > 13) && (comparaFecha > 0) && (periodoDif != 1)) {
                    if (proyVO.getPrestamo().getTnoCve().trim().equals("30")) {
                        intGan = intGan + (wsSaldo * (proyVO.getPrestamo().getIntRate() / 1200));
                    } else {
                        intGan = intGan + (wsSaldo * (proyVO.getPrestamo().getIntRate() / 2400));
                    }
                }

                int intQnaTasa = (qnaTasa.getAnio() * 100) + qnaTasa.getQna();

                if (intQnaTasa >= 201001) {
                    if (proyVO.getPrestamo().getIvaRate() == 10) {
                        ivaRate = 11.0;
                    } else {
                        ivaRate = 16.0;
                    }
                }

                ivaGan = intGan * (ivaRate / 100);

                ldInteresAcumulado = ldInteresAcumulado + intGan;
                ldIvaAcumulado = ldIvaAcumulado + ivaGan;
                difInt = ldInteresAcumulado - ldInteresPagado;
                difIva = ldIvaAcumulado - ldIvaPagado;
                ivaPer = 0.0;
                intPer = 0.0;
                capPer = 0.0;

                if (MtoPago > 0) {

                    if (MtoPago > difIva) {
                        saldoAux = MtoPago - difIva;
                        ldIvaPagado = ldIvaPagado + difIva;
                        ivaPer = difIva;
                    } else {
                        ldIvaPagado = ldIvaPagado + MtoPago;
                        saldoAux = 0.0;
                        ivaPer = MtoPago;
                    }

                    if (saldoAux > difInt) {
                        saldoAux = MtoPago - difInt;
                        ldIvaPagado = ldIvaPagado + difInt;
                        intPer = difInt;
                    } else {
                        ldInteresPagado = ldInteresPagado + saldoAux;
                        saldoAux = 0.0;
                        intPer = saldoAux;
                    }

                    if (saldoAux > 0) {

                        wsSaldo = wsSaldo - saldoAux;
                        capPer = saldoAux;
                    }
                } else {
                    saldoAux = 0.0;
                }

                qnaPar = (qnaUltPago.getQna() % 2);

                if (qnaPar == 0) {
                    perIntGan = perIntGan + intGan;
                    perIntPag = perIntPag + intPer;
                    perSdo = perSdo + capPer;
                    perIvaGan = perIvaGan + ivaGan;
                    perIvaPag = perIvaPag + ldIvaPagado;
                } else {
                    perIntGan = intGan;
                    perIntPag = intPer;
                    perSdo = capPer;
                    perIvaGan = ivaGan;
                    perIvaPag = ldIvaPagado;
                }

                qnaTasa = DateUtils.incrementaQuincena(qnaTasa);

                if (wsSaldo < 0) {
                    wsSaldo = 0.0;
                }
            }
            if (liActualiza == 1) {
                proyVO.getProyeccion().setCurrPrinBal(wsSaldo);
                proyVO.getProyeccion().setIntEarnedToDate(ldInteresAcumulado);
                proyVO.getProyeccion().setTotIntPd(ldInteresPagado);
                proyVO.getProyeccion().setTotIvaGan(ldIvaAcumulado);
                proyVO.getProyeccion().setTotIvaPag(ldIvaPagado);
                proyVO.getProyeccion().setDatePastPay(ldProyeccion);
                proyVO.getProyeccion().setPerIntEarned(perIntGan);
                proyVO.getProyeccion().setPerIntPd(perIntPag);
                proyVO.getProyeccion().setPerPrincPd(perSdo);
                proyVO.getProyeccion().setPerIvaGan(perIvaGan);
                proyVO.getProyeccion().setPerIvaPag(perIvaPag);
                proyVO.getProyeccion().setHoraAud(DateUtils.horaActual());
                proyVO.getProyeccion().setComponenteCve(Constants.OTOWEB);
                proyVO.getProyeccion().setTotPrinPaidToD(proyVO.getProyeccion().getTotPrinPaidToD() + saldoAux);
                proyVO.getProyeccion().setIpEquipo(ipEquipo);

                this.proyeccionDao.actualizaProy(proyVO);
                if (lsCero == 1) {
                    proyVO.getProyeccion().setAmtLastPmt(MtoPago);
                    proyVO.getProyeccion().setCve_operDtFinBt(Constants.OPERADOR_WEB);
                    proyVO.getProyeccion().setDt_modDatFinBtc(new Date());

                    this.proyeccionDao.actualizaProyCU(proyVO);
                } else {

                    proyVO.getProyeccion().setCve_operDtFinBt(Constants.OPERADOR_WEB);
                    proyVO.getProyeccion().setDt_modDatFinBtc(new Date());
                    this.proyeccionDao.actualizaProyCD(proyVO);
                }
            }

        }

        proy.setCurrPrinBal(wsSaldo);
        proy.setIntEarnedToDate(ldInteresAcumulado);
        proy.setTotIntPd(ldInteresPagado);
        proy.setTotIvaGan(ldIvaAcumulado);
        proy.setTotIvaPag(ldIvaPagado);
        proy.setDatePastPay(ldProyeccion);
        proy.setPerIntEarned(perIntGan);
        proy.setPerIntPd(perIntPag);
        proy.setPerPrincPd(perSdo);
        proy.setPerIvaGan(perIvaGan);
        proy.setPerIvaPag(perIvaPag);
        proy.setMtoPago(MtoPago);
        proy.setPeriodoDif(periodoDif);
        proy.setIntPer(intPer);
        proy.setIntPer(ivaPer);

        return proy;
    }

    public double cal_r(double rate, String tnoCve) {
        double r = 0;

        if (tnoCve.trim().equals("30")) {
            r = rate / 1200;
        } else {
            r = rate / 2400;
        }

        return r;
    }

    public Double calcTasasProyec(int loanTypeCd, QnaVO qnaTasa, Double intRate, QnaVO qnaOtorga, String tnoCve, int band) {

        int intQnaTasa = (qnaTasa.getAnio() * 100) + qnaTasa.getQna();
        int intQnaOtorga = (qnaOtorga.getAnio() * 100) + qnaOtorga.getQna();;
        Double tasaInteres = 0.0;
        Double tasaInteresAux = 0.0;
        Double tasaInteresFin = 0.0;

        if (loanTypeCd == 2) {
            if ((intQnaTasa >= 198901) && (intQnaTasa <= 199524) && (intQnaOtorga >= 198901)) {
                tasaInteres = this.proyeccionDao.tasaInteres(qnaTasa.toString());
            }

            if (intQnaTasa <= 199424) {
                tasaInteresAux = tasaInteres;
            } else {
                tasaInteresAux = ((tasaInteres - 5) * .71);
            }
        }

        if (loanTypeCd == 11) {
            if (intQnaOtorga <= 199511) {
                tasaInteresAux = 10.00;
            } else {
                if ((intQnaOtorga >= 199511) && (intQnaOtorga < 199608)) {
                    tasaInteres = this.proyeccionDao.tasaInteres(qnaTasa.toString());
                }

                if (intQnaTasa <= 199424) {
                    tasaInteresAux = ((tasaInteres - 5) * .71);
                } else {
                    tasaInteresAux = 20.00;
                }
            }
        }

        tasaInteres = tasaInteresAux / 2400;

        if (band == 1) {
            tasaInteresFin = tasaInteres * 2;
        }


        return tasaInteresFin;
    }

    /**
     * Calcula la taza quincenal aplicable por porveedor (R)
     *
     * @param tazaInt Tasa de Interes Anual Nominal.
     * @param tnoCve
     * @return
     */
    @Override
    public double calTasa(double tasaInt, int tnoCve) {
        double r = 0;
        if (tnoCve == Constants.TNO_CVE_PENSION) {
            r = tasaInt / 1200;
        } else {
            r = tasaInt / 2400;
        }
        return r;
    }

    private double calIntDiferimiento(double ipf, double tasa, int diferimiento, int tnoCve) {
        double intDif = 0;
        double diasIntDif;
        diasIntDif = calcIntDia(tnoCve, ipf, tasa);

        ipf += diasIntDif;
        if (diferimiento > 1) {
            diferimiento--;
            intDif = ipf * (Math.pow(1 + tasa, diferimiento) - 1);

        }
        return intDif;
    }

    /**
     * calcula la tasa de las primas
     *
     * @param tasa
     * @param fiva
     * @return
     */
    @Override
    public double calRPrim(double tasa, double fiva) {
        double rPrim;
        rPrim = tasa * (1 + (fiva / 100));
        return rPrim;
    }

    @Override
    public double calcIntDia(int tnoCve, double ipf, double tasa) {
        double intDia;
        double intDifPer;
        double intDifDia;
        int diaAct;
        int diaFin;
        int dias;
        Calendar fechaC = Calendar.getInstance();
        fechaC.setTime(new Date());
        diaFin = fechaC.getActualMaximum(Calendar.DAY_OF_MONTH);
        diaAct = fechaC.get(Calendar.DAY_OF_MONTH);
        dias = diaFin - diaAct + 1;
        intDifPer = ipf * tasa;
        if (tnoCve == Constants.TNO_CVE_PENSION) {
            intDifDia = intDifPer / Constants.DIAS_MES;
        } else {
            intDifDia = intDifPer / Constants.DIAS_QNA;
        }
        intDia = intDifDia * dias;
        return intDia;
    }

    @Override
    public double calIvaDif(double intDif, double fiva) {
        return intDif * fiva / 100;
    }

    @Override
    public RangoSalVO obtenerSueldo(double numIssste, int tnoCve, boolean simulado) {
        double sueldoIssste;
        double salarioTope;
        CSalarioVO salarioMinDiario;
        double rangoSal;
        RangoSalVO rangoSalVO;

        if (tnoCve == Constants.TNO_CVE_PENSION) {
            sueldoIssste = datosLaboralesDAO.obtenerSumaSueldoPlazaPen((int) numIssste, simulado);
        } else {
            sueldoIssste = datosLaboralesDAO.obtenerSumaSueldoPlaza((int) numIssste, simulado);
        }
        salarioTope = obtenerSalarioTope();
        salarioMinDiario = salarioDao.obtenerSalarioMinDiario();

        /**
         * Cuando el salario excede el salario tope el sueldo_issste debe
         * limitarse al salario tope
         */
        if (sueldoIssste > salarioTope) {
            sueldoIssste = salarioTope;
        }
        if (salarioMinDiario.getSalarioMin() == 0) {
            rangoSal = 0;
        } else {
            rangoSal = sueldoIssste / salarioMinDiario.getSalarioMin();
        }
        rangoSalVO = new RangoSalVO(sueldoIssste, rangoSal);
        return rangoSalVO;
    }

    @Override
    public double obtenerSalarioTope() {
        CSalarioVO salarioMinMsl;
        CParamOtorgaVO diasSalMin;
        double salarioTope = 0;
        salarioMinMsl = salarioDao.obtenerSalarioMin();
        diasSalMin = parametrosOtorgamientoDao.obtenerParametroByID(Constants.DIAS_SALARIO_MINIMO);
        salarioTope = salarioMinMsl.getSalarioMin() * diasSalMin.getValParamOtorga();
        return salarioTope;
    }

    @Override
    public void actualizaCanRec(int folioSol, int cveTcr, int numIssste, int anioSol) {
        RecepcionVO recepcion = new RecepcionVO();
        recepcion.setFolioSol(folioSol);
        recepcion.setCveTcr(cveTcr);
        recepcion.setNumIssste(numIssste);
        recepcion.setAnioSol(anioSol);
        recepcionSolDao.eliminarRecepcion(recepcion);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, OtwException.class, Throwable.class}, propagation = Propagation.REQUIRED, value = "transactionManager")
    public PresolicitudVO otorgaPrestamo(PresolicitudVO presol, RefinanciamientoVO refinanciamientoVO, int funcion, int isRef, String vehiculo) {
        /*if (presol.getDirecto().getEligProc().toUpperCase().equals(Constants.CHEQUE)) {
        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.PRESTAMO_PROCESO_EMISION_CHEQUE);
        }*/
        System.out.println("vehiculo Final......."+ vehiculo);
        //TODO:Este fragmento de codigo si funciona pero debe hacerlo spring
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        int cveRechavo = 0;

        try {
//           this.insertDataRecursivo();
            if (presol.getCveTrc() != 21) {
                presol = verificaPresupuesto(presol);
            }
            if (presol.getCveRechazo() == 0 && presol.getCveStatSol() != 3) {
                /**
                 * Si se produce un error se generara una excepcion con clave 14
                 * sera necesario hacer rollback
                 */
                cveRechavo = registroRecepcion(presol);
                if (cveRechavo > 0) {
                    presol.setCveStatSol(Constants.ESTATUS_RECHAZO_OTORGAMIENTO);
                    throw sQLErrorCodesFactory.createException(cveRechavo);
                } else {
                    presol.setCveStatSol(Constants.ESTATUS_PRESTAMO_OTORGADO);
                    actualizaSolicitud(funcion, presol, presol.getCveRechazo());
                    if (refinanciamientoVO.getLdCapRefinanc() != null && refinanciamientoVO.getLdCapRefinanc() < 0) {
                        refinanciamientoVO.setLdCapRefinanc(0.0);
                        refinanciamientoVO.setLdIntRefinanc(0.0);
                        refinanciamientoVO.setLdIvaRefinanc(0.0);
                    } else if (isRef == 0) {
                        refinanciamientoVO.setLdCapRefinanc(null);
                        refinanciamientoVO.setLdIntRefinanc(null);
                        refinanciamientoVO.setLdIvaRefinanc(null);
                    }
                    PrstamoOrigVO prstamoOrigVO = actualizaPrestamo(presol, refinanciamientoVO, isRef, vehiculo);
                    presol.setPrstamoOrigVO(prstamoOrigVO);
                    actualizarDirecto(presol);
                    generaProyTran(presol, refinanciamientoVO);

                }

            } else {
                presol.setCveStatSol(Constants.ESTATUS_RECHAZO_OTORGAMIENTO);
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.SOLICITUD_SIN_ASIGNACION_PRESUP);
            }
            if (presol.getCveRechazo() > 0) {
                transactionManager.rollback(status);
            } else {
                transactionManager.commit(status);
            }
        } catch (OtwException e) {
            System.out.println("Error Uno" + e.getMessage());
            transactionManager.rollback(status);
            throw e;
        } catch (Exception e) {
            transactionManager.rollback(status);
            System.out.println("Error Dos" + e.getMessage());
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
        }
        return presol;
    }
    /*TODO:Borrar, solo es para pruebas*/
    /*private void insertDataRecursivo(){
    EntidadVO vo= null;
    for(int i=0; i<=3;i++){
    vo=new EntidadVO();
    vo.setAbvEntidad("T"+i);
    vo.setComponenteCve("Test OTW");
    vo.setCveEntidad(44+i);
    vo.setDescEntidad("Test Trans");
    vo.setFechaAud(new java.sql.Date(2014, 11, 12));
    vo.setIpEquipo("no-ip");
    vo.setUsuario("test");
    datosLaboralesDAO.insertData(vo);
    System.out.println("Insercion"+i);
    }
    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DADO_DE_BAJA);
    }*/

    public void actualizarDirecto(PresolicitudVO presolicitudVO) {
        DirectoVO directoVO = presolicitudVO.getDirecto();
        directoVO.setEligProc(Constants.CHEQUE);
        directoVO.setUsuario(Constants.OPERADOR_WEB);
        directoVO.setComponenteCve(Constants.OTOWEB);
        directoVO.setIpMaquina(presolicitudVO.getIpMaquina());
        datosLaboralesDAO.updateDirecto(directoVO);
    }

    @Override
    public int registroRecepcion(PresolicitudVO presolicitudVO) {
        int error = 0;
        RecepcionVO recepcion = new RecepcionVO();
        recepcion.setCveOperadorRec(new Integer(Constants.OPERADOR_WEB));
        recepcion.setDtFechaRec(new Date());
        recepcion.setAnioSol(DateUtils.anioActual());
        recepcion.setFolioSol(presolicitudVO.getFolioSol());
        recepcion.setCveTcr(presolicitudVO.getCveTrc());
        recepcion.setNumIssste(presolicitudVO.getDirecto().getNumIssste());
        recepcion.setStatRec(Constants.ESTATUS_RECEPCION);
        recepcion.setCveDeleg(presolicitudVO.getCoberturaGlobVO().getDelegacion().getCveDeleg());
        recepcion.setCveDelegOrigen(presolicitudVO.getCoberturaGlobVO().getDelegacion().getCveDeleg());
        recepcion.setCveEntidad(presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad());
        recepcion.setCveEntidadOrigen(presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad());
        recepcion.setCveOficina(presolicitudVO.getCoberturaGlobVO().getOficina().getCveOficina());
        recepcion.setCveOficinaOrigen(presolicitudVO.getCoberturaGlobVO().getOficina().getCveOficina());
        recepcion.setCveUniad(presolicitudVO.getCoberturaGlobVO().getUnidad().getCveUniad());
        recepcion.setCveUniadOrigen(presolicitudVO.getCoberturaGlobVO().getUnidad().getCveUniad());
        recepcion.setUsuario(Constants.OPERADOR_WEB);
        recepcion.setFechaAud(new Date());
        recepcion.setComponenteCve(Constants.OTOWEB);
        recepcion.setIpEquipo(presolicitudVO.getIpMaquina());

        error = validarRecepcionAInsertar(recepcion);

        if (presolicitudVO.getCveStatSol() != 3) {
            boolean seInsertRec = recepcionSolDao.insert(recepcion);
            if (seInsertRec) {
                presolicitudVO.getDirecto().setEntAds(presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad());
                datosLaboralesDAO.updateDirectoEntRec(presolicitudVO.getDirecto());
            }
        } else {
            error = OtwExceptionCodes.SOLICITUD_SIN_ASIGNACION_PRESUP;


        }

        return error;
    }

    private int validarRecepcionAInsertar(RecepcionVO recepcion) {
        int error = 0;
        int cuentaRecep = 0;
        cuentaRecep = recepcionSolDao.countRecepcionSolicitud(recepcion);
        if (cuentaRecep > 0) {
            return error = OtwExceptionCodes.DERECHO_CON_SOLICITUD_OTORGADA;

        }
        List<RecepcionVO> recepciones = recepcionSolDao.obtenerCoberturaSolicitudCredito(recepcion);
        if (recepciones != null && recepciones.size() > 0) {
            return error = OtwExceptionCodes.SOLICITUD_OTORGADA;
        }
        cuentaRecep = recepcionSolDao.countRechazosSolicitud(recepcion);
        if (cuentaRecep > 0) {
            return error = OtwExceptionCodes.DERECHO_CON_SOLICITUD_OTORGADA;
        }
        cuentaRecep = recepcionSolDao.countRecepcionSolicitudesPorIssste(recepcion.getNumIssste());
        if (cuentaRecep > 0) {
            return error = OtwExceptionCodes.DERECHO_CON_SOLICITUD_OTORGADA;
        }
        cuentaRecep = recepcionSolDao.countRecepcionPorOperador(recepcion);

        if (cuentaRecep > 0) {
            return error = OtwExceptionCodes.DERECHO_CON_SOLICITUD_OTORGADA;
        }
        return error;
    }

    @Override
    public QuinDifVO obtieneQuincenasDiferimiento(Date fecha, int cveRamo, String cvePagaduria, int tnoCve) {
        QuinDifVO quinRes = new QuinDifVO();
        QnaVO quin = new QnaVO(fecha);
        QnaVO quinr = new QnaVO();

        int mes = 0;
        int quinDif = 0;

        int anio = quin.getAnio();
        int dias = 0;
        List<CCalPensVO> listaCalendarioPensionado = null;
        List<CDiferimientoVO> listaCDiferimiento = null;
        CCalPensVO calPen = null;
        CDiferimientoVO cDif = null;
        if (tnoCve == Constants.C_PENSION) {
            listaCalendarioPensionado = this.calPensDao.obtenerQuincenasOtorgamiento(fecha);
            if (listaCalendarioPensionado.isEmpty()) {
                return null;
            }
            calPen = listaCalendarioPensionado.get(0);
            quinDif = calPen.getQnasADiferir();
            mes = MesEnum.valueOf(calPen.getSsaaOrdDscto().trim().toUpperCase()).ordinal() + 1;
            if (mes == 1 || mes == 2) {
                anio++;
            }
            quinr.setAnio(anio);
            quinr.setQna(mes);
            quinRes.setQuinDif(quinDif);
            quinRes.setQuinFin(quinr);
            quinRes.setDias(dias);
            return quinRes;

        } else {
            if (quin.getQna() == 20) {
                quinDif = 5;
            } else {
                CDiferimientoVO cdif = new CDiferimientoVO();
                cdif.setQnaEmis(quin.getQna());
                cdif.setRamoDif(cveRamo);
                cdif.setPagad(cvePagaduria);
                listaCDiferimiento = this.diferimietoDao.obtenerCatDiferimiento(cdif);
                if (listaCDiferimiento.isEmpty()) {
                    quinDif = 4;
                } else {
                    cDif = listaCDiferimiento.get(0);
                    quinDif = cDif.getNumQuinDif();
                }
            }
            for (int q = 1; q <= quinDif; q++) {
                if (quin.getQna() >= Constants.QUINCENAS_ANIO) {
                    quin.setQna(1);
                    quin.setAnio(quin.getAnio() + 1);
                } else {
                    quin.setQna(quin.getQna() + 1);
                }
            }
            quinRes.setQuinDif(quinDif);
            quinRes.setQuinFin(quin);
            quinRes.setDias(dias);
            return quinRes;
        }

    }

    @Override
    public boolean existeFolio(int folio, int cveTcr, CoberturaGlobVO cobertura) {
        boolean resultado = false;
        FolioVO folioVO = null;
        int cFolios = 0;

        folioVO = folioDao.obtenerFolios(folio, cveTcr, folio);
        if (folioVO.getTpo_presto().trim().equals(Constants.TIPO_PRESTO)
                && folioVO.getCveAfectaPresup() == 0) {
            FolioVO params = new FolioVO();
            params.setFolioSolicitud(new Integer(folio).toString());
            params.setCveTcr(cveTcr);
            params.setCveEntidad(cobertura.getEntidad().getCveEntidad());
            params.setCveEntidad(cobertura.getDelegacion().getCveDeleg());
            params.setCveEntidad(cobertura.getUnidad().getCveUniad());
            params.setAnio(DateUtils.anioActual());
            cFolios = folioDao.countFolios(params, false);
            return !(cFolios == 0);
        } else if (folioVO.getTpo_presto().trim().equals(Constants.TIPO_PRESTO)
                && folioVO.getCveAfectaPresup() == 6) {
            FolioVO params = new FolioVO();
            params.setFolioSolicitud(new Integer(folio).toString());
            params.setCveTcr(cveTcr);
            params.setCveEntidad(cobertura.getEntidad().getCveEntidad());
            params.setCveEntidad(cobertura.getDelegacion().getCveDeleg());
            params.setCveEntidad(cobertura.getUnidad().getCveUniad());
            params.setAnio(DateUtils.anioActual());
            cFolios = folioDao.countFolios(params, false);
            if (cFolios == 0) {
                params = new FolioVO();
                params.setFolioSolicitud(new Integer(folio).toString());
                params.setCveTcr(cveTcr);
                params.setAnio(DateUtils.anioActual());
                cFolios = folioDao.countFolios(params, true);
                return !(cFolios == 0);
            }
            return true;
        }
        return resultado;
    }

    @Override
    public RechazoVO generaRechazos(int numeroIssste, int cveTcr, int maxCred, double sdoTotCap) {
        RechazoVO rechazo = null;
        int bndOk = 0;
        int countCred = 0;
        /**
         * Genera rechazo por pago real*
         */
        bndOk = pagoRealTCrVigenteIsOk(numeroIssste);
        if (bndOk > 0) {
            switch (bndOk) {
                case 1:
                case 2:
                    rechazo = new RechazoVO(0, 1, 101, 3);
                    break;
                case 3:
                    rechazo = new RechazoVO(0, 1, 102, 3);
                    break;
            }
        } else {
            countCred = cuentaCreditos(numeroIssste, cveTcr);
            if (cveTcr == 18 && maxCred == 0) {
                if (countCred > maxCred) {
                    rechazo = new RechazoVO(0, 1, 0, 33);
                }
            } else if (cveTcr == 18 && maxCred == 4) {
                if (countCred != 3) {
                    rechazo = new RechazoVO(0, 1, 0, 32);
                }
            } else if (countCred >= maxCred) {
                rechazo = new RechazoVO(0, 1, 0, 30);
            }
        }
        if (prestamoOrigDao.countNumeroPrestamosByEstatus(numeroIssste, 88) > 0) {
            /**
             * Si se tiene prestamos en despacho externo *
             */
            rechazo = new RechazoVO(0, 1, 16, 30);
        }
        if (rechazo == null) {
            rechazo = validaCompat(numeroIssste, cveTcr, sdoTotCap);
        }
        return rechazo;
    }

    private int cuentaCreditos(int numeroIssste, int cveTcr) {
        int cuentaCred = 0;
        if (cveTcr == Constants.TIPO_PREST_ESPEC && cveTcr == Constants.TIPO_PREST_CONM_ANIV) {
            cuentaCred = this.prestamoOrigDao.countLoanAuthCdXNumIssste(numeroIssste, cveTcr);
        }
        return cuentaCred;
    }

    private int pagoRealTCrVigenteIsOk(int numIssste) {
        List<PrstamoOrigVO> listaPrestamos = this.prestamoOrigDao.obtenerPrestamoOrigenXNumIssste(numIssste);
        List<PagoRealVO> listaPagos = null;
        CParamOtorgaVO param = parametrosOtorgamientoDao.obtenerParametroByID(3);
        if (param == null && param.getValParamOtorga() < 0) {
            return 1;
        }
        for (PrstamoOrigVO pres : listaPrestamos) {
            listaPagos = pagoRealDao.obtenerDTSaldoRealPorPrestamo(pres.getLoanNbr());
            for (PagoRealVO pago : listaPagos) {
                if (pago.getDtSaldoReal() == null || pago.getDtSaldoReal().equals(" ")) {
                    return 2;
                } else if (pago.getDtSaldoReal().equals("31/12/1899") || pago.getDtSaldoReal().equals("000000")) {
                    return 1;
                } else {
//                   DateUtils.fechaCorte();
                    //System.out.println("pago.getDtSaldoReal(" + pago.getDtSaldoReal());
                    Date fechaSaldoReal = DateUtils.parse(pago.getDtSaldoReal());
                    //System.out.println("fechaSaldoReal" + fechaSaldoReal);
                    QnaVO quincenaSaldo = new QnaVO(fechaSaldoReal);
                    QnaVO quincenaCorte = new QnaVO(DateUtils.calculaFechaCorte());
                    List<QnaVO> qnas = DateUtils.qnasTranscurridasVO(quincenaSaldo, quincenaCorte);
                    if (qnas.size() > param.getValParamOtorga()) {
                        return 3;
                    }
                }
            }
        }
        return 0;
    }

    private RechazoVO validaCompat(int numeroIssste, int cveTcr, double sdoTotCap) {
        List<PrstamoOrigVO> listaPrestamos = prestamoOrigDao.obtenerPrestamoOrigenXNumIssste(numeroIssste);
        RechazoVO error = new RechazoVO();
        CCompatibleVO compatible = null;
        Double saldoAct = null;
        double avancePzo = 0;
        int numQuin = 0;
        double salMinDiario = 0;
        double factor = 0;
        double adeudoPermitido = 0;
        List<CCompatibleVO> listaComp = null;
        for (PrstamoOrigVO prestamo : listaPrestamos) {
            try {
                CCompatibleVO compatibleP = new CCompatibleVO();
                compatibleP.setCveTrcSol(cveTcr);
                compatibleP.setCveTrcAnt(prestamo.getLoanTypeCd());
                listaComp = compatibleDao.obtenerCompatibilidadCredito(compatibleP);
                if (listaComp.isEmpty()) {
                    error.setError(1);
                    error.setCveRechazo(4);
                } else {
                    compatible = listaComp.get(0);
                }

                saldoAct = saldoActual(prestamo.getLoanNbr().doubleValue());
                saldoAct = sdoTotCap;
            } catch (OtwException otwE) {
                error.setError(otwE.getCodigo());
                error.setCveRechazo(3);
                return error;
            }
            //System.out.println("prestamo.getTnoCve()" + prestamo.getTnoCve());
            if (prestamo.getTnoCve().trim().equals("" + Constants.TNO_CVE_PENSION)) {
                prestamo.setOrigNbrPay(prestamo.getOrigNbrPay() * 2);
            }
            //System.out.println("prestamo.getOrigNbrPay()" + prestamo.getOrigNbrPay());
            //System.out.println("compatible.getPorPlazo()" + compatible.getPorPlazo());

            Date ssssqq = DateUtils.parse(prestamo.getFirstPayPerYrD());
            QnaVO qnaFirs = new QnaVO(ssssqq);
            /*int anio = new Short(prestamo.getFirstPayPerYrD().substring(0, 4));
            int quin = new Short(prestamo.getFirstPayPerYrD().substring(4, 6));
            qnaFirs.setAnio(anio);
            qnaFirs.setQna(quin);*/
            QnaVO qnaCort = new QnaVO(DateUtils.calculaFechaCorte());

            numQuin = DateUtils.qnasTranscurridasVO(qnaFirs, qnaCort).size();

            avancePzo = prestamo.getOrigNbrPay() * compatible.getPorPlazo() / 100;
            //System.out.println("numQuin" + numQuin);
            //System.out.println("avancePzo" + avancePzo);

            if (numQuin < avancePzo) {
                if (compatible.getPorPlazo().doubleValue() == 25
                        || compatible.getPorPlazo().doubleValue() == 50
                        || compatible.getPorPlazo().doubleValue() == 6.25
                        || compatible.getPorPlazo().doubleValue() == 4.17
                        || compatible.getPorPlazo().doubleValue() == 2.5) {
                    error.setCveRechazo(4);
                    error.setError(0);
                    error.setCveRech(14);
                    error.setBndRechazo(1);
                } else if (compatible.getPorPlazo().doubleValue() == 100) {
                    error.setCveRechazo(4);
                    error.setError(0);
                    error.setCveRech(51);
                    error.setBndRechazo(1);
                }
            }
            try {
                salMinDiario = salarioDao.obtenerSalarioMinDiario().getSalMinDiario();
            } catch (Exception e) {
                error.setError(3);
                return error;
            }
            adeudoPermitido = salMinDiario * compatible.getNumSalMin();

            /*System.out.println("adeudoPerminito" + adeudoPermitido);
            System.out.println("saldoAct" + saldoAct);
            System.out.println("compatible.getPorMonto()" + compatible.getPorMonto());*/

            if (saldoAct > adeudoPermitido && compatible.getNumSalMin()>0) {
                error.setError(0);
                error.setBndRechazo(1);
                error.setCveRech(60);
                error.setCveRechazo(4);
                return error;
            }

            factor = 100 - compatible.getPorMonto();
            if (factor != 0) {
                adeudoPermitido = prestamo.getOrigLoanPrin() * factor / 100;
            }
            if (adeudoPermitido < saldoAct
                    && compatible.getPorMonto() > 0) {
                if (compatible.getPorMonto() == 100) {
                    error.setCveRechazo(4);
                    error.setError(0);
                    error.setCveRech(50);
                    error.setBndRechazo(1);
                } else {
                    error.setCveRechazo(4);
                    error.setError(0);
                    error.setCveRech(22);
                    error.setBndRechazo(1);

                }
            }

        }
        return error;
    }

    private double saldoActual(Double loanNbr) {
        RechazoVO error = new RechazoVO();
        double resSaldoActual = 0;
        ProyeccionVO proy = this.proyeccionDao.obtenerProyeccionByID(loanNbr);
        if (proy == null) {
            throw sQLErrorCodesFactory.createException(2);
        }
        /*System.out.println("--"+loanNbr
        + "--" + proy.getCurrPrinBal()
        + "--" + proy.getIntEarnedToDate()
        + "--" + proy.getTotIntPd()
        + "--" + proy.getTotIvaGan()
        + "--" + proy.getTotIvaPag());*/

        resSaldoActual = proy.getCurrPrinBal()
                + (proy.getIntEarnedToDate() - proy.getTotIntPd())
                + (proy.getTotIvaGan() - proy.getTotIvaPag());

        return resSaldoActual;
    }

    private PresolicitudVO verificaPresupuesto(PresolicitudVO presol) {
        Integer grupo = null;
        grupo = determinaGrupo(presol);
        presol.getPrstamoOrigVO().setCveGposind(grupo);
        presol = transferenciasAutomaticas(presol);
        return presol;
    }

    private Integer determinaGrupo(PresolicitudVO presol) {
        Integer grupoind = null;
        if (Integer.valueOf(
                presol.getPrstamoOrigVO().getTnoCve().trim()).intValue() == Constants.TNO_CVE_CONFIANSA) {
            grupoind = Constants.GRUPO_CONFIANSA;
        } else {
            grupoind = coberturaDao.obtenerGrupoRamoAnt(presol.getNumRamo());
        }
        return grupoind;
    }

    private PresolicitudVO transferenciasAutomaticas(PresolicitudVO presol) {
        int cveRechazo = 0;
        String tipoPresup = null;
        List<CPartidaVO> listPartidas = null;
        List<PrestoMensualVO> listaPresto = null;
        PrestoMensualVO prestoMensualDestino = null;
        Integer mesActual = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int grupoSind = presol.getPrstamoOrigVO().getCveGposind();
        int seActualizo = 0;
        Integer tnoCve = new Integer(presol.getPrstamoOrigVO().getTnoCve().toString());
        if (presol.getPrstamoOrigVO().getCveAfect() == 1
                || presol.getPrstamoOrigVO().getCveAfect() == 9) {
            tipoPresup = "I";
        } else {
            tipoPresup = "D";
        }
        if (tnoCve.intValue() == Constants.TNO_CVE_HON) {
            tnoCve = Constants.TNO_CVE_BASE;
        }

        listPartidas = partidaDao.obtenerCVECPartida();
        if ((presol.getPrstamoOrigVO().getCveAfect() == 0)
                && presol.getCveTrc() != 19
                && presol.getCveTrc() != 17
                && presol.getCveTrc() != 16) {
            //System.out.println("Prestamo if");

            PrestoMensualVO params = new PrestoMensualVO();
            try {
                params.setTpoPart(tipoPresup);
                params.setCveAfect(presol.getPrstamoOrigVO().getCveAfect());
                params.setCveTcr(presol.getCveTrc());
                params.setNumMes(mesActual);
                params.setCveEntidad(presol.getCoberturaGlobVO().getEntidad().getCveEntidad());
                params.setCveDeleg(presol.getCoberturaGlobVO().getDelegacion().getCveDeleg());
                params.setCveUniad(presol.getCoberturaGlobVO().getUnidad().getCveUniad());
                params.setCveRamo(presol.getNumRamo());
                params.setTnoCve(tnoCve.toString());
            } catch (Exception e) {
                System.out.println("Error Try Trans --->>>>" + e.getMessage());
            }
            for (CPartidaVO partida : listPartidas) {
                params.setCvePart(partida.getCvePartida());
                listaPresto = presupuestoDao.obtenerDatosPresupMensual(params);
                if (!listaPresto.isEmpty()) {
                    PrestoMensualVO presto = listaPresto.get(0);
                    presol.getPrstamoOrigVO().setCvePart(partida.getCvePartida());
                    presol.getPrstamoOrigVO().setCveGposind(presto.getCveGposind());
                    if (presto.getCredDisp() > 0) {
                        presto.setCredDisp(presto.getCredDisp() - 1);
                        presto.setCredComp(presto.getCredComp() + 1);
                        presto.setUsuario(presol.getUsuario());
                        presto.setFechaAud(new Date());
                        presto.setComponenteCve(presol.getComponenteCVE());
                        presto.setIpEquipo(presol.getIpMaquina());
                        try {
                            presupuestoDao.update(presto);
                            seActualizo = 1;
                        } catch (Exception e) {
                            /**
                             * implementar rollbak
                             */
                            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.TRANSFERENCIA_AUTOMATICA);
                        } finally {
                            break;
                        }
                    } else {
                        cveRechazo = 70;
                    }
                }
            }
        } else {

            //System.out.println("Prestamo else");
            PrestoAutoVO params = new PrestoAutoVO();
            params.setCveAfect(presol.getPrstamoOrigVO().getCveAfect());
            params.setCveTcr(presol.getCveTrc());
            params.setTnoCve(tnoCve);
            params.setCveEntidad(presol.getCoberturaGlobVO().getEntidad().getCveEntidad());
            params.setCveDeleg(presol.getCoberturaGlobVO().getDelegacion().getCveDeleg());
            params.setCveUniad(presol.getCoberturaGlobVO().getUnidad().getCveUniad());
            params.setRamo(presol.getNumRamo());

            List<PrestoAutoVO> listPresupuestoAuto = presupuestoDao.obtenerPresupuestosTranAuto(params);
            if (!listPresupuestoAuto.isEmpty()) {
                for (PrestoAutoVO prestoAuto : listPresupuestoAuto) {
                    if (prestoAuto.getCveUniadOri() != null) {
                        for (CPartidaVO partida : listPartidas) {
                            PrestoMensualVO paramsPrestoMensual = new PrestoMensualVO();
                            paramsPrestoMensual.setCveTcr(presol.getCveTrc());
                            paramsPrestoMensual.setNumMes(Calendar.getInstance().get(Calendar.MONTH) + 1);
                            paramsPrestoMensual.setCveEntidad(Constants.ENTIDAD_DF);
                            paramsPrestoMensual.setCveDeleg(Constants.DELEG_SUBDIR_OTOCRED);
                            paramsPrestoMensual.setCveUniad(prestoAuto.getCveUniadOri());
                            paramsPrestoMensual.setCvePart(partida.getCvePartida());
                            paramsPrestoMensual.setTpoPart(tipoPresup);

                            if (presol.getPrstamoOrigVO().getCveAfect() == 1
                                    || presol.getPrstamoOrigVO().getCveAfect() == 9) {
                                paramsPrestoMensual.setCveAfect(1);
                            } else {
                                paramsPrestoMensual.setCveAfect(presol.getPrstamoOrigVO().getCveAfect());

                            }

                            if (presol.getPrstamoOrigVO().getCveAfect() == 2
                                    || presol.getPrstamoOrigVO().getCveAfect() == 7) {
                                paramsPrestoMensual.setCveRamo(presol.getNumRamo());
                                paramsPrestoMensual.setTnoCve(tnoCve.toString());
                            } else {
                                paramsPrestoMensual.setCveRamo(0);
                                paramsPrestoMensual.setTnoCve(null);
                            }
                            List<PrestoMensualVO> listaPresMensualOrigen = presupuestoDao.obtenerDatosPresupMensual(paramsPrestoMensual);
                            if (listaPresMensualOrigen != null && listaPresMensualOrigen.size() > 0) {
                                for (PrestoMensualVO prestoOrigen : listaPresMensualOrigen) {
                                    presol.getPrstamoOrigVO().setCvePart(partida.getCvePartida());
                                    presol.getPrstamoOrigVO().setCveGposind(prestoOrigen.getCveGposind());
                                    if (prestoOrigen.getCredDisp() != null && prestoOrigen.getCredDisp() > 0) {
                                        prestoOrigen.setCredDisp(prestoOrigen.getCredDisp() - 1);
                                        prestoOrigen.setCredTrf(prestoOrigen.getCredTrf() - 1);
                                        prestoOrigen.setUsuario(presol.getUsuario());
                                        prestoOrigen.setFechaAud(new Date());
                                        prestoOrigen.setComponenteCve(presol.getComponenteCVE());
                                        prestoOrigen.setIpEquipo(presol.getIpMaquina());
                                        /*PrestoMensualVO paramsPrestoDestino = new PrestoMensualVO();
                                        paramsPrestoDestino.setTpoPart(tipoPresup);
                                        paramsPrestoDestino.setCveAfect(presol.getPrstamoOrigVO().getCveAfect());
                                        paramsPrestoDestino.setCveTcr(presol.getCveTrc());
                                        paramsPrestoDestino.setNumMes(mesActual);
                                        paramsPrestoDestino.setCveEntidad(presol.getCoberturaGlobVO().getEntidad().getCveEntidad());
                                        paramsPrestoDestino.setCveDeleg(presol.getCoberturaGlobVO().getDelegacion().getCveDeleg());
                                        paramsPrestoDestino.setCveUniad(presol.getCoberturaGlobVO().getUnidad().getCveUniad());
                                        paramsPrestoDestino.setCveRamo(presol.getNumRamo());
                                        paramsPrestoDestino.setCvePart(partida.getCvePartida());
                                         */
                                        // presupuestoDao.update(prestoOrigen);
                                        paramsPrestoMensual.setCveEntidad(presol.getCoberturaGlobVO().getEntidad().getCveEntidad());
                                        paramsPrestoMensual.setCveDeleg(presol.getCoberturaGlobVO().getDelegacion().getCveDeleg());
                                        paramsPrestoMensual.setCveUniad(presol.getCoberturaGlobVO().getUnidad().getCveUniad());
                                        paramsPrestoMensual.setCveRamo(presol.getNumRamo());
                                        paramsPrestoMensual.setTnoCve(tnoCve.toString());
                                        List<PrestoMensualVO> listaPresMensualDestino = presupuestoDao.obtenerDatosPresupMensual(paramsPrestoMensual);
                                        /*
                                         * se obtiene el presupuesto destino Si no se
                                         * encuentra, se generara uno nuevo
                                         */

                                        if (!listaPresMensualDestino.isEmpty()) {
                                            //System.out.println("ifffffffPRes");
                                            prestoMensualDestino = listaPresMensualDestino.get(0);
                                            prestoMensualDestino.setCredComp(prestoMensualDestino.getCredComp() + 1);
                                            prestoMensualDestino.setCredTrf(prestoMensualDestino.getCredTrf() + 1);
                                            prestoMensualDestino.setUsuario(Constants.OPERADOR_WEB);
                                            prestoMensualDestino.setFechaAud(new Date());
                                            prestoMensualDestino.setComponenteCve(Constants.OTOWEB);
                                            prestoMensualDestino.setIpEquipo(presol.getIpMaquina());
                                            presupuestoDao.update(prestoMensualDestino);
                                            seActualizo = 1;

                                        } else {

                                            //System.out.println("elsePres");
                                            prestoMensualDestino = new PrestoMensualVO();
                                            PrestoAnualVO prestoAn = new PrestoAnualVO();
                                            prestoAn.setEntTcr(0);
                                            prestoAn.setNumMes(0);
                                            List<PrestoAnualVO> lstPresAn = presupuestoDao.obtenerVersionPresAnu(prestoAn);
                                            PrestoAnualVO version = null;
                                            if (!lstPresAn.isEmpty()) {
                                                version = lstPresAn.get(0);
                                            } else {
                                                version = new PrestoAnualVO();
                                                version.setNumVersion(0);
                                            }
                                            prestoMensualDestino.setNumVersion(version.getNumVersion());
                                            prestoMensualDestino.setCredTot(0);
                                            prestoMensualDestino.setCredComp(1);
                                            prestoMensualDestino.setCredDisp(0);
                                            prestoMensualDestino.setCredEjer(0);
                                            prestoMensualDestino.setCredTrf(1);
                                            prestoMensualDestino.setImpoEjer(0D);
                                            prestoMensualDestino.setStatus(Constants.ESTATUS_PRESTO_MEN);
                                            prestoMensualDestino.setTpoPresto(Constants.TPO_PRESTO);
                                            prestoMensualDestino.setTpoPart(presol.getPrstamoOrigVO().getTipoPresup());
                                            prestoMensualDestino.setCveAfect(presol.getPrstamoOrigVO().getCveAfect());
                                            prestoMensualDestino.setCveTcr(presol.getCveTrc());
                                            prestoMensualDestino.setCveGposind(grupoSind);
                                            prestoMensualDestino.setNumMes(mesActual);
                                            prestoMensualDestino.setCveEntidad(presol.getCoberturaGlobVO().getEntidad().getCveEntidad());
                                            prestoMensualDestino.setCveDeleg(presol.getCoberturaGlobVO().getDelegacion().getCveDeleg());
                                            prestoMensualDestino.setCveUniad(presol.getCoberturaGlobVO().getUnidad().getCveUniad());
                                            prestoMensualDestino.setCveRamo(presol.getNumRamo());
                                            prestoMensualDestino.setTnoCve(presol.getPrstamoOrigVO().getTnoCve());
                                            prestoMensualDestino.setCvePart(partida.getCvePartida());
                                            prestoMensualDestino.setUsuario(Constants.OPERADOR_WEB);
                                            prestoMensualDestino.setFechaAud(new Date());
                                            prestoMensualDestino.setComponenteCve(Constants.OTOWEB);
                                            prestoMensualDestino.setIpEquipo(presol.getIpMaquina());
                                            presupuestoDao.insert(prestoMensualDestino);
                                            presol.getPrstamoOrigVO().setCveGposind(prestoMensualDestino.getCveGposind());
                                        }
                                        try {
                                            presupuestoDao.updatePresto(prestoOrigen);
                                            seActualizo = 1;
                                            break;
                                        } catch (Exception e) {
                                            /**
                                             * implementar rollbak
                                             */
                                            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.TRANSFERENCIA_AUTOMATICA);
                                        }
                                    }
                                }
                            }
                            if (seActualizo != 0) {
                                break;
                            }
                        }

                    } else {
                        cveRechazo = 72;
                    }
                    if (seActualizo != 0) {
                        break;
                    }
                }
            }
        }

        if (seActualizo == 0) {
            System.out.println("No existe PResupuesto");
            cveRechazo = 70;
        }
        presol.setCveRechazo(cveRechazo);
        return presol;
    }

    /**
     * metodo encargado de actualizar la el registro de solicitud
     *
     * @param funcion 0 para cuando se tenga que insertar una nuva solicitud y
     * otro valor para la actualizar el registro existente
     * @param rechazo
     * @param cveRech
     */
    private int actualizaSolicitud(int funcion, PresolicitudVO presol, int cveRech) {
        int cveRechazo = 0;
        SolicitudVO sol = new SolicitudVO();
        sol.setAnio_sol(presol.getAnioSol());
        sol.setFolio_sol(presol.getFolioSol());
        sol.setCve_tcr(presol.getCveTrc());
        sol.setFecha_sol(presol.getFechaSol());
        sol.setNum_issste(presol.getDirecto().getNumIssste());
        sol.setRfc(presol.getDirecto().getRfc());
        sol.setCve_entidad(presol.getCoberturaGlobVO().getEntidad().getCveEntidad());
        sol.setCve_deleg(presol.getCoberturaGlobVO().getDelegacion().getCveDeleg());
        sol.setCve_uniad(presol.getCoberturaGlobVO().getUnidad().getCveUniad());
        sol.setCve_oficina(presol.getCoberturaGlobVO().getOficina().getCveOficina());
        sol.setNum_ramo(presol.getNumRamo());
        sol.setNum_pagaduria(presol.getNumPagaduria());
        if (presol.getTpoCreditoVO().getCveTcr() != 21) {
            sol.setCve_stat_sol(presol.getCveStatSol());
        } else {
            sol.setCve_stat_sol(Constants.ESTATUS_RECIBIDA);
        }
        sol.setUsuario(Constants.OPERADOR_WEB);
        sol.setFecha_aud(new Date());
        sol.setComponente_cve(Constants.OTOWEB);
        sol.setIp_equipo(presol.getIpMaquina());

        if (funcion == 0) {
            sol.setFec_recepci(recepcionSolDao.obtenerFechaRec(presol.getFolioSol(), presol.getCveTrc()));
            sol.setFec_rechvis(recepcionSolDao.rechazoVisual(presol.getFolioSol(), presol.getCveTrc()));
            if (sol.getCve_stat_sol() == 3) {
                sol.setFec_rechoto(new Date());
            } else {
                sol.setFec_otorga(new Date());
            }
            recepcionSolDao.insert(sol);
        } else {
            recepcionSolDao.update(sol);
        }
        //if (sol.getCve_stat_sol() == 3) {
        //  actualizaRechazos(sol, cveRech);
        //}
        return cveRechazo;

    }

    private PrstamoOrigVO actualizaPrestamo(PresolicitudVO presol, RefinanciamientoVO refinanciamientoVO, int isRefinan, String vehiculo) {
        PrstamoOrigVO prstamoOrigVO = presol.getPrstamoOrigVO();
        properties.cargaArchivo();
        Double[] pagoRef = new Double[3];
        prstamoOrigVO.setLoanTypeCd(presol.getTpoCreditoVO().getCveTcr());
        prstamoOrigVO.setNbrFolio(presol.getFolioSol());
        prstamoOrigVO.setLoanIssue_date(new Date());
        prstamoOrigVO.setLoanStatCd(1);
        prstamoOrigVO.setNumRefPmp(null);
        prstamoOrigVO.setBadLoanFlg(Constants.COND_CRED_NORMAL);
        prstamoOrigVO.setTotSdoCapRef(refinanciamientoVO.getLdCapRefinanc());
        prstamoOrigVO.setTotSdoIntRef(refinanciamientoVO.getLdIntRefinanc());
        prstamoOrigVO.setTotSdoIvaRef(refinanciamientoVO.getLdIvaRefinanc());
        prstamoOrigVO.setCveEntidad(presol.getCoberturaGlobVO().getEntidad().getCveEntidad());
        prstamoOrigVO.setCveDeleg(presol.getCoberturaGlobVO().getDelegacion().getCveDeleg());
        prstamoOrigVO.setCveUniad(presol.getCoberturaGlobVO().getUnidad().getCveUniad());
        prstamoOrigVO.setOperIdOnline(Constants.OPERADOR_WEB);
        prstamoOrigVO.setCveOficina(presol.getCoberturaGlobVO().getOficina().getCveOficina());
        prstamoOrigVO.setRamoOtorg(presol.getNumRamo());
        prstamoOrigVO.setPagadOtorg(presol.getNumPagaduria());
        prstamoOrigVO.setDtLastStatusOnl(new Date());
        prstamoOrigVO.setOperIdIssuingCl(Integer.parseInt(Constants.OPERADOR_WEB));
        prstamoOrigVO.setFechaAud(new Date());
        prstamoOrigVO.setHoraAud(DateUtils.horaActual());
        prstamoOrigVO.setComponenteCve(Constants.OTOWEB);
        prstamoOrigVO.setIpEquipo(presol.getIpMaquina());
        if (isRefinan == 1) {
            pagoRef[0] = refinanciamientoVO.getLdCapRefinanc() + refinanciamientoVO.getLdIntRefinanc() + refinanciamientoVO.getLdIvaRefinanc();
            pagoRef[1] = refinanciamientoVO.getPagoRef2();
            pagoRef[2] = refinanciamientoVO.getPagoRef3();
            actualizaRefinanciamiento(presol, pagoRef);
        }
        if (presol.getTpoCreditoVO().getCveTcr() != 21) {
            prstamoOrigVO.setLoanNbr(obtenerNumPrestamo(presol.getIpMaquina()));
            prestamoOrigDao.insert(prstamoOrigVO);
        } else {
            double nuevofolio;
            Object object = minMaxDao.getMaximo(Constants.PARAMETRO_TABLA, Constants.TABLA_PRSTAM_AUTO, properties.getParametro("conection.sipesic"));
            if (object == null) {
                nuevofolio = 0;
            } else {

                nuevofolio = Double.parseDouble(object.toString());
            }
            if(vehiculo != null && !vehiculo.isEmpty() && vehiculo.equals("A")){
                prstamoOrigVO.setLoanAuthCd(Constants.TIPO_PREST_AUTOS);
            }else{
                prstamoOrigVO.setLoanAuthCd(Constants.TIPO_PREST_MOTOCICLETA);
            }
            prstamoOrigVO.setLoanNbr(nuevofolio + 1);
            prestamoOrigDao.insert(prstamoOrigVO);
        }
        return prstamoOrigVO;
    }

    private void generaProyTran(PresolicitudVO presol, RefinanciamientoVO refinanciamientoVO) {
        String fechaNac = presol.getDiaFec() + "/" + presol.getMesFec() + "/" + presol.getAnioFEc();
        presol.getDirecto().setFecNac(DateUtils.parseStringDate(fechaNac));
        int dias = DateUtils.fechasDiferenciaEnDias(new Date(), presol.getDirecto().getFecNac());
        int meses = (dias % 365) / 30;
        int anios = dias / 365;
        String edad = "" + anios;
        TransOtoVO transOto = new TransOtoVO();
        ProyeccionVO proyeccionVO = new ProyeccionVO();

        transOto.setDtTrans(new Date());
        transOto.setRfcTrans(presol.getDirecto().getRfc());
        transOto.setNombreTrans(presol.getDirecto().getApellidoPaterno().trim() + " "
                + presol.getDirecto().getApellidoMaterno().trim()
                + " " + presol.getDirecto().getNombre().trim());
        transOto.setSalarioTrans(NumerosUtils.redondeoNumero(presol.getSueldoMensual(), Constants.REDONDEO_NUM));
        transOto.setTipoNombTrans(new Integer(presol.getPrstamoOrigVO().getTnoCve()));
        transOto.setSexoTrans(presol.getDirecto().getSexo().trim());
        transOto.setEdadTrans(edad);
        transOto.setAntigTrans(presol.getcAntiguedadVO().getAntiguedad());
        transOto.setEntOperTrans(String.valueOf(presol.getCoberturaGlobVO().getEntidad().getCveEntidad()));
        transOto.setNbrOperTrans(new Integer(Constants.OPERADOR_WEB));
        transOto.setIsssteNbrTrans(presol.getPrstamoOrigVO().getIsssteNbr());
        transOto.setLoanNbrTrans(presol.getPrstamoOrigVO().getLoanNbr());
        transOto.setNbrFolioTrans(presol.getPrstamoOrigVO().getNbrFolio());
        transOto.setLoanIssueDate(presol.getPrstamoOrigVO().getLoanIssue_date());
        transOto.setLoanTypePrs(presol.getPrstamoOrigVO().getLoanTypeCd());
        transOto.setLoanStatPrs(presol.getPrstamoOrigVO().getLoanStatCd());
        transOto.setOrigLoanPrin(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getOrigLoanPrin(), Constants.REDONDEO_NUM));
        transOto.setLoanDisbAmt(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getImpLiquido(), Constants.REDONDEO_NUM));
        transOto.setImpRefinanc(NumerosUtils.redondeoNumero(refinanciamientoVO.getLdSaldoRef(), Constants.REDONDEO_NUM));
        if (refinanciamientoVO.getLdCapRefinanc() != null) {
            transOto.setCapRefinanc(NumerosUtils.redondeoNumero(refinanciamientoVO.getLdCapRefinanc(), Constants.REDONDEO_NUM));
            transOto.setIntRefinanc(NumerosUtils.redondeoNumero(refinanciamientoVO.getLdIntRefinanc(), Constants.REDONDEO_NUM));
            transOto.setIvaRefinanc(NumerosUtils.redondeoNumero(refinanciamientoVO.getLdIvaRefinanc(), Constants.REDONDEO_NUM));
        }
        transOto.setOrigLoanIntAmt(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getOrigLoanIntAmt(), Constants.REDONDEO_NUM));
        transOto.setOrigIva(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getOrigIva(), Constants.REDONDEO_NUM));
        transOto.setDeferredInt(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getDeferredInt(), Constants.REDONDEO_NUM));
        transOto.setWarrantyPrem(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getWarrantyPrem(), Constants.REDONDEO_NUM));
        transOto.setRenewalPrem(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getRenewalPrem(), Constants.REDONDEO_NUM));
        transOto.setIntRate(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getIntRate(), Constants.REDONDEO_NUM));
        transOto.setIvaRate(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getIvaRate(), Constants.REDONDEO_NUM));
        transOto.setOrigNbrPay(presol.getPrstamoOrigVO().getOrigNbrPay());
        transOto.setLoanAuthCd(presol.getPrstamoOrigVO().getLoanAuthCd());
        transOto.setPayAmt(NumerosUtils.redondeoNumero(presol.getPrstamoOrigVO().getPayAmt(), Constants.REDONDEO_NUM));
        transOto.setFirstPayPerYrD(presol.getPrstamoOrigVO().getFirstPayPerYrD());
        transOto.setLastPayPerYrDu(presol.getPrstamoOrigVO().getLastPayPerYrDu());
        transOto.setModoPago(presol.getPrstamoOrigVO().getModoPago());
        transOto.setTipoCta(presol.getPrstamoOrigVO().getTipoCuenta());
        transOto.setCveBanco(presol.getPrstamoOrigVO().getCveBanco());
        if (presol.getPrstamoOrigVO().getNumCtaBanc() != null) {
            transOto.setNumCtaBanc(new Double(presol.getPrstamoOrigVO().getNumCtaBanc()));
        } else {
            transOto.setNumCtaBanc(null);
        }
        transOto.setTipoPresup(presol.getPrstamoOrigVO().getTipoPresup());
        transOto.setEntidOtor(presol.getPrstamoOrigVO().getCveEntidad());
        transOto.setDelegOtor(presol.getPrstamoOrigVO().getCveDeleg());
        transOto.setUniadOtor(presol.getPrstamoOrigVO().getCveUniad());
        transOto.setOffOtor(presol.getPrstamoOrigVO().getCveOficina());
        transOto.setRamoOtor(presol.getPrstamoOrigVO().getRamoOtorg());
        transOto.setPagadOtor(presol.getPrstamoOrigVO().getPagadOtorg());
        transOto.setCveAfect(presol.getPrstamoOrigVO().getCveAfect());
        transOto.setCvePart(presol.getPrstamoOrigVO().getCvePart());
        transOto.setHoraAud(DateUtils.horaActual());
        transOto.setComponenteCve(Constants.OTOWEB);
        transOto.setUsuario(Constants.OPERADOR_WEB);
        transOto.setIpEquipo(presol.getIpMaquina());

        proyeccionVO.setLoanNbr(presol.getPrstamoOrigVO().getLoanNbr());
        proyeccionVO.setFirstPayPerDue(presol.getPrstamoOrigVO().getFirstPayPerYrD());
        proyeccionVO.setLastPayPerDue(presol.getPrstamoOrigVO().getLastPayPerYrDu());
        proyeccionVO.setCurrPrinBal(presol.getPrstamoOrigVO().getOrigLoanPrin());
        proyeccionVO.setIntEarnedToDate(0D);
        proyeccionVO.setTotIntPd(0D);
        proyeccionVO.setTotIvaGan(0D);
        proyeccionVO.setTotIvaPag(0D);
        proyeccionVO.setDatePastPay(presol.getPrstamoOrigVO().getLoanIssue_date());
        proyeccionVO.setPerIntEarned(0D);
        proyeccionVO.setPerIntPd(0D);
        proyeccionVO.setPerPrincPd(0D);
        proyeccionVO.setPerIvaGan(0D);
        proyeccionVO.setPerIvaPag(0D);
        proyeccionVO.setTotIntMrtoGan(0D);
        proyeccionVO.setTotIntMrtoPag(0D);
        proyeccionVO.setPerIntMrtoGan(0D);
        proyeccionVO.setPerIntMrtoPag(0D);
        proyeccionVO.setAmtLastPmt(0D);
        proyeccionVO.setPlazo((double) presol.getPrstamoOrigVO().getOrigNbrPay());
        proyeccionVO.setImpPagoAntProy(refinanciamientoVO.getLdAmtLastPmt());
        proyeccionVO.setNum_pagoAntProy(refinanciamientoVO.getLsQnasf());
        proyeccionVO.setNum_difer(presol.getDescuentoProcVO().getDif());
        proyeccionVO.setTotPrinPaidToD(0D);
        proyeccionVO.setIvaPagProyOpt(0D);
        proyeccionVO.setIvaGanProyOpt(0D);
        proyeccionVO.setTotIntProyOpt(0D);
        proyeccionVO.setIntEarnedProOpt(0D);
        proyeccionVO.setSaldoCapProyOpt(0D);
        proyeccionVO.setFechaStat(null);
        proyeccionVO.setStatCobr(0);
        proyeccionVO.setNumCitatorio(0);
        proyeccionVO.setCveOperDtFinOn(Constants.OPERADOR_WEB);
        proyeccionVO.setHoraAud(DateUtils.horaActual());
        proyeccionVO.setComponenteCve(Constants.OTOWEB);
        proyeccionVO.setIpEquipo(presol.getIpMaquina());
        proyeccionDao.insert(proyeccionVO);
        transMovWebDao.insert(transOto);

    }

    private void actualizaRefinanciamiento(PresolicitudVO presol, Double[] pagoRef) {
        long hoy = (new Date()).getTime();
        long quinenaAnt = 15 * 24 * 60 * 60 * 1000;
        Date fechaCorte = new Date(hoy - quinenaAnt);
        QnaVO qnaCorte = new QnaVO(fechaCorte);
        String qnaString = null;
        Double loanNbr = null;
        PagoNomVO pagoNomVO = new PagoNomVO();
        pagoNomVO.setTpoPago(Constants.TPO_PAGO_REF);
        pagoNomVO.setOperIdMant(Constants.OPERADOR_WEB);
        pagoNomVO.setDtLastMant(new Date());
        pagoNomVO.setComponente_cve(Constants.OTOWEB);
        pagoNomVO.setIpEquipo(presol.getIpMaquina());
        for (int indicePago = 0; indicePago < pagoRef.length; indicePago++) {
            switch (indicePago) {
                case 0:
                    loanNbr = presol.getPrstamoOrigVO().getNumPrestRef1();
                    break;
                case 1:
                    loanNbr = presol.getPrstamoOrigVO().getNumPrestRef2();
                    break;
                case 2:
                    loanNbr = presol.getPrstamoOrigVO().getNumPrestRef3();
                    break;
                default:
                    loanNbr = null;

            }

            //System.out.println("loanNbr" + loanNbr);
            if (loanNbr != null) {
                PrstamoOrigVO prestamo = new PrstamoOrigVO();
                prestamo.setLoanStatCd(20);
                prestamo.setDtLastStatusOnl(new Date());
                prestamo.setOperIdOnline(Constants.OPERADOR_WEB);
                prestamo.setFechaAud(new Date());
                prestamo.setHoraAud(DateUtils.horaActual());
                prestamo.setComponenteCve(Constants.OTOWEB);
                prestamo.setIpEquipo(presol.getIpMaquina());
                prestamo.setLoanNbr(loanNbr);
                prestamo.setIsssteNbr(presol.getDirecto().getNumIssste());
                prestamoOrigDao.updateEstatusCd(prestamo);

                pagoNomVO.setLoanNbr(loanNbr);
                pagoNomVO.setImportePago(presol.getSaldoRef());
                pagoNomVO.setRamo(presol.getPrstamoOrigVO().getRamoOtorg());
                pagoNomVO.setPagad(presol.getPrstamoOrigVO().getPagadOtorg());
                if (loanNbr.doubleValue() >= 20040858709D
                        && (presol.getPrstamoOrigVO().getRamoOtorg() == 226
                        || presol.getPrstamoOrigVO().getRamoOtorg() == 26
                        || presol.getPrstamoOrigVO().getRamoOtorg() == 389)) {
                    qnaString = qnaCorte.getAnio() + String.format(Constants.FORMATO_DOS_DIGITOS, qnaCorte.getQna());
                } else {
                    qnaString = qnaCorte.toString();
                }
                pagoNomVO.setQnaFinal(qnaString);
                pagoNomVO.setQnaInicio(qnaString);
                pagoNomVO.setHoraAud(DateUtils.horaActual());
                nominaDao.insert(pagoNomVO);

            }
        }

    }

    private Double obtenerNumPrestamo(String ipMaquina) {
        Date fechaActual = Calendar.getInstance().getTime();
        long fechaFinAct = fechaActual.getTime();
        CSicParamVO cSicParamVO = new CSicParamVO();
        cSicParamVO.setNumSic(0);
        cSicParamVO.setUsuario(new Integer(Constants.OPERADOR_WEB));
        cSicParamVO.setFechaAud(new java.sql.Date(fechaFinAct));
        cSicParamVO.setComponenteCve(Constants.OTOWEB);
        cSicParamVO.setIpEquipo(ipMaquina);
        Integer key = parametrosOtorgamientoDao.insert(cSicParamVO);
        String numPrestamo = "" + DateUtils.anioActual()
                + String.format(Constants.FORMATO_SIETE_DIGITOS, key);
        return new Double(numPrestamo);
    }

    public ReporteVO getPrestamosAnterior(Double numIssste) {
        return this.prestamoOrigDao.getPrestamosAnterior(numIssste);
    }

    public void actualizaRechazos(SolicitudVO sol, int cveRechazo) {
        MotivosSolVO motivosSolVO = new MotivosSolVO();
        motivosSolVO.setStatMotivo(0);
        motivosSolVO.setUsuario(sol.getUsuario());
        motivosSolVO.setFechaAud(new Date());
        motivosSolVO.setComponenteCve(sol.getComponente_cve());
        motivosSolVO.setAnioSol(sol.getAnio_sol());
        motivosSolVO.setCveMotivo(cveRechazo);
        motivosSolVO.setCveTcr(sol.getCve_tcr());
        motivosSolVO.setFolioSol(sol.getFolio_sol());
        motivosSolVO.setIpEquipo(sol.getIp_equipo());
        List<MotivosSolVO> listaMotivos = this.recepcionSolDao.obtenerClaveMotivoSol(motivosSolVO);
        for (MotivosSolVO motVO : listaMotivos) {
            this.recepcionSolDao.update(motVO);
        }
        this.recepcionSolDao.insertMotSol(motivosSolVO);
    }
}
