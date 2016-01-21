/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service.impl;

import com.ucol.otweb.dao.ICoberturaDao;
import com.ucol.otweb.dao.IDatosLaborales;
import com.ucol.otweb.dao.IDeduccionesDao;
import com.ucol.otweb.dao.ISalarioDao;
import com.ucol.otweb.dao.ITransaccionesMovimientosWebDao;
import com.ucol.otweb.service.IValidacionesGeneralesWeb;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.vo.CDelegacionVO;
import com.ucol.otweb.vo.COficinaVO;
import com.ucol.otweb.vo.CSalarioVO;
import com.ucol.otweb.vo.CUnidadVO;
import com.ucol.otweb.vo.CoberturaGlobVO;
import com.ucol.otweb.vo.CtnoCveVO;
import com.ucol.otweb.vo.DatosLaboralesVO;
import com.ucol.otweb.vo.DeduccionesVO;
import com.ucol.otweb.vo.DirectoAVVO;
import com.ucol.otweb.vo.DirectoVO;
import com.ucol.otweb.vo.EntidadVO;
import com.ucol.otweb.vo.OtorgamWebContad;
import com.ucol.otweb.vo.PlazaVO;
import com.ucol.otweb.vo.PzaPenVO;
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
@Repository(value = "validacionGeneralWeb")
public class ValidacionesGeneralesWebSI implements IValidacionesGeneralesWeb {

    @Autowired
    @Qualifier("datosLaborales")
    private IDatosLaborales datosLaborales;
    @Autowired
    @Qualifier("transMovWebDao")
    private ITransaccionesMovimientosWebDao transaccionesMovimientosWebDao;
    @Autowired
    @Qualifier("coberturaDao")
    private ICoberturaDao coberturaDao;
    @Autowired
    @Qualifier("salarioDao")
    private ISalarioDao salarioDao;
    @Autowired
    @Qualifier("deduccionesDao")
    private IDeduccionesDao deduccionesDao;
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
     */
    public ValidacionesGeneralesWebSI() {
        properties.cargaArchivo();
    }

    /**
     * Se hace la busqueda de la persona en Sipesic 
     * @param persona
     * @return
     */
    public DirectoVO buscarPersona(DatosLaboralesVO persona) {
        DirectoVO personaBusqueda = null;
        List<DirectoVO> personaDirecto = datosLaborales.busquedaDerechohabienteDirecto(persona);
        if (personaDirecto != null && personaDirecto.size() > 0) {
            personaBusqueda = personaDirecto.get(0);
        }
        return personaBusqueda;
    }

    /**
     * Se valida al usuario con respecto a la informacion en Directo en AV o en Sipesic
     * @param laboralesVO
     * @param ipMaquina 
     * @return  
     */
    public int validacionUsuario(DatosLaboralesVO laboralesVO, String ipMaquina) {
        DirectoAVVO derecOtorWeb = null;
        boolean registroEncontradoAV = false;
        int resultoValPT = 0;
        //Se valida el día 
        boolean diaActivo = validarDiaActivoOtorgamientoWeb();
        if (!diaActivo) {
            List<DirectoAVVO> derechohabientesAV = datosLaborales.busquedaDerechohabienteAVDirecto(laboralesVO, false);
            if (derechohabientesAV != null && derechohabientesAV.size() > 0) {
                if (derechohabientesAV.size() == 1) {
                    derecOtorWeb = derechohabientesAV.get(0);
                    registroEncontradoAV = true;
                } else {
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ACLARAR_SITUACION_AFILIATORIA);
                }
            } else {
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.REG_NO_ENCONTRADO);
            }
            //Si el registro se encontro en Sipesic se valida que este como dado de alta
            if (registroEncontradoAV) {
                if (derecOtorWeb.getDtoEstado().trim().equals(Constants.DTOESTADO)) {
                    //Se valida las plazas en caso de que el derechohabiente sea activo, y tambien que solo tenga una plaza
                    if (derecOtorWeb.getTdirecto().trim().equals(Constants.PENSIONADO)) {
                        resultoValPT = validacionPensionado(derecOtorWeb, ipMaquina);
                    } else //Se valida las plazas en caso de que el derechohabiente sea activo, y tambien que solo tenga una plaza
                    if (derecOtorWeb.getTdirecto().trim().equals(Constants.TRABAJADOR)) {
                        resultoValPT = validacionTrabajador(derecOtorWeb, ipMaquina);
                    } else {
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ACLARAR_SITUACION_AFILIATORIA);
                    }
                    if (resultoValPT == 0) {
                        System.out.println("Validacion Existosa");
                    }
                } else {
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DADO_DE_BAJA);
                }
            }
        } else {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.SIN_SERVICIO);
        }
        return resultoValPT;

    }

    /**
     *Se hace la validacion del usuario si es pensionado
     */
    private int validacionPensionado(DirectoAVVO derecOtoWEb, String ipMaquina) {
        DatosLaboralesVO personaPen = new DatosLaboralesVO();
        personaPen.setNumIssste(derecOtoWEb.getNumIssste());
        DirectoVO personaPenD = new DirectoVO();
        Double sueldoPen;
        int correcto = 0;
        List<PzaPenVO> plazaPensionado = datosLaborales.buscarPlazaPensionado(personaPen, properties.getParametro("conection.dsipe"), false);
        if (plazaPensionado != null && plazaPensionado.size() > 0) {
            if (!validarderechohabienteConMasDeUnaPlaza(derecOtoWEb.getNumIssste())) {
                List<PlazaVO> plazaTrabajador = datosLaborales.buscarPlazas(personaPen, properties.getParametro("conection.dsipe"), true);
                List<PlazaVO> plazaTrabajadorS = datosLaborales.buscarPlazas(personaPen, properties.getParametro("conection.sipesic"), true);
                if ((plazaTrabajador != null && plazaTrabajador.size() > 0) || (plazaTrabajadorS != null && plazaTrabajadorS.size() > 0)) {
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ACLARAR_SITUACION_AFILIATORIA);
                } else {
                    personaPenD = buscarPersona(personaPen);
                    if (personaPenD != null && personaPenD.getNumIssste() != null) {
                        if ( personaPenD.getEligProc()!=null && personaPenD.getEligProc().trim().equals(Constants.CHEQUE)) {
                            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.PRESTAMO_PROCESO_EMISION_CHEQUE);
                        }
                    }
                    List<PzaPenVO> plazaPenFiltro = datosLaborales.obtenerPlzaPenByNumIsssteFiltrado(derecOtoWEb.getNumIssste());
                    if (plazaPenFiltro != null && plazaPenFiltro.size() > 0) {
                        //Se obtiene la plaza en sipesic con respecto a la llave que es el ramo anterior y la pagaduria de Av
                        PzaPenVO pensionadoSi = obtenerPlazaPenConRamAnt(plazaPenFiltro.get(0));
                        if (pensionadoSi != null) {
                            //si existe plaza en sipesic
                            PzaPenVO pzaPenVOEnAV = plazaPenFiltro.get(0);
                            CSalarioVO salarioMin = salarioDao.obtenerSalarioMin();
                            if (pzaPenVOEnAV.getImptPension() > (salarioMin.getSalarioMin() * 10)) {
                                sueldoPen = salarioMin.getSalarioMin() * 10;
                            } else {
                                sueldoPen = pensionadoSi.getImptPension();
                            }
                            boolean seActualizo = actualizarPlaza(null, pensionadoSi, sueldoPen, Constants.OPERADOR_WEB, Constants.ACTWEB, ipMaquina);
                            if (seActualizo) {
                                //Al agregar la deduccion va con respecto al ramoAnterior, donde no se conoce donde lo obtiene
                                Integer ramoAnt = coberturaDao.buscarRamoAnterior(pzaPenVOEnAV.getNumRamo().intValue(), pzaPenVOEnAV.getNumPagaduria(), properties.getParametro("conection.dsipe"));
                                pzaPenVOEnAV.setNumRamoAnt(ramoAnt);
                                DeduccionesVO deduccionesVO = generarDeduccion(pzaPenVOEnAV.getNumIssste().intValue(), pzaPenVOEnAV.getNumRamoAnt().intValue(), pzaPenVOEnAV.getNumPagaduria(), pzaPenVOEnAV.getNumRamo().intValue());
                                if (!deduccionesVO.isBanderaGuardar()) {
                                    boolean insertDed = agregarDeduccion(deduccionesVO);
                                    if (!insertDed) {
                                        correcto = 1;
                                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
                                    }
                                }
                            } else {
                                correcto = 1;
                                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
                            }

                        } else {
                            PzaPenVO pzaPenVONoSipesic = plazaPenFiltro.get(0);
                            CSalarioVO salarioMin = salarioDao.obtenerSalarioMin();
                            if (pzaPenVONoSipesic.getImptPension() > (salarioMin.getSalarioMin() * 10)) {
                                sueldoPen = salarioMin.getSalarioMin() * 10;
                            } else {
                                sueldoPen = pzaPenVONoSipesic.getImptPension();
                            }
                            Integer ramAntPlaFilt = coberturaDao.buscarRamoAnterior(pzaPenVONoSipesic.getNumRamo().intValue(), pzaPenVONoSipesic.getNumPagaduria(), properties.getParametro("conection.dsipe"));
                            pzaPenVONoSipesic.setIpMaquina(ipMaquina);
                            pzaPenVONoSipesic.setNumRamoAnt(ramAntPlaFilt);
                            pzaPenVONoSipesic.setUsuario(Constants.OPERADOR_WEB);
                            pzaPenVONoSipesic.setComponenteCve(Constants.ALTAWEB);
                            pzaPenVONoSipesic.setImptPension(sueldoPen);
                            boolean seAgrego = insertarPlaza(null, pzaPenVONoSipesic);
                            if (seAgrego) {
                                DeduccionesVO deduccionesVO = generarDeduccion(pzaPenVONoSipesic.getNumIssste().intValue(), pzaPenVONoSipesic.getNumRamoAnt(), pzaPenVONoSipesic.getNumPagaduria(), pzaPenVONoSipesic.getNumRamo().intValue());
                                if (!deduccionesVO.isBanderaGuardar()) {
                                    boolean insertedD = agregarDeduccion(deduccionesVO);
                                    if (!insertedD) {
                                        correcto = 1;
                                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
                                    }
                                }
                            } else {
                                correcto = 1;
                                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
                            }

                        }
                        if (personaPenD == null) {
                            derecOtoWEb.setUsuario(Constants.OPERADOR_WEB);
                            derecOtoWEb.setComponenteCve(Constants.ALTAWEB);
                            derecOtoWEb.setIpMaquina(ipMaquina);
                            boolean insertoDir = insertarDirecto(derecOtoWEb);
                            if (!insertoDir) {
                                correcto = 1;
                                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
                            }
                        }
                    } else {
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.REALIZAR_TRAMITE_OFIC_ISSSSTE);
                    }


                }
            } else {
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.REALIZAR_TRAMITE_OFIC_ISSSSTE);
            }
        } else {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.PLAZA_NO_ENCONTRO);
        }
        return correcto;
    }

    /**
     *Se hace la validacion del usuario si es trabajador
     */
    private int validacionTrabajador(DirectoAVVO derecOtoWEb, String ipMaquina) {
        int correcto = 0;
        int contPlazaModCve = 0;
        DatosLaboralesVO datosLaboralesVO = new DatosLaboralesVO();
        datosLaboralesVO.setNumIssste(derecOtoWEb.getNumIssste());
        DirectoVO trabajDirecto = new DirectoVO();
        if (DateUtils.fechasDiferenciaEnDias(derecOtoWEb.getFechaIngreso()) < 183) {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_CUMPLE_ANTIGUEDAD);
        } else {
            List<PlazaVO> plazaTrabajadorAv = datosLaborales.buscarPlazas(datosLaboralesVO, properties.getParametro("conection.dsipe"), true);
            if (plazaTrabajadorAv != null && plazaTrabajadorAv.size() > 0) {
                if (!validarderechohabienteConMasDeUnaPlaza(derecOtoWEb.getNumIssste())) {
                    List<PzaPenVO> trabajadorPen = datosLaborales.buscarPlazaPensionado(datosLaboralesVO, properties.getParametro("conection.dsipe"), false);
                    List<PzaPenVO> trabajadorPenS = datosLaborales.buscarPlazaPensionado(datosLaboralesVO, properties.getParametro("conection.sipesic"), false);
                    if ((trabajadorPen != null && trabajadorPen.size() > 0) || (trabajadorPenS != null && trabajadorPenS.size() > 0)) {
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ACLARAR_SITUACION_AFILIATORIA);
                    } else {
                        trabajDirecto = buscarPersona(datosLaboralesVO);
                        if (trabajDirecto != null) {
                            if (trabajDirecto.getNumIssste() != null) {
                                if(trabajDirecto.getEligProc()!=null && trabajDirecto.getEligProc().trim().equals(Constants.CHEQUE)){
                                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.PRESTAMO_PROCESO_EMISION_CHEQUE);
                                }
                            }
                        }
                        contPlazaModCve = datosLaborales.countPlazasPorModCve(derecOtoWEb.getNumIssste(), properties.getParametro("conection.dsipe"));
                        if (contPlazaModCve == 0) {
                            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_TIENE_DERECHO_PRESTAMOS_PERSONAL);
                        } else {
                            //Se actualiza la plaza del trabajador siempre y cuando sea mayor a cero el ModCve
                            int seActualizoC = actualizarPlazaTrabajador(plazaTrabajadorAv.get(0), ipMaquina);
                            /*  if (validarderechohabienteConMasDeUnaPlaza(derecOtoWEb.getNumIssste())) {
                                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.REALIZAR_TRAMITE_OFIC_ISSSSTE);
                            }*/
                            if (seActualizoC == 0) {
                                DirectoVO directoVOSipesic = null;
                                directoVOSipesic = buscarPersona(datosLaboralesVO);
                                if (directoVOSipesic == null) {
                                    derecOtoWEb.setUsuario(Constants.OPERADOR_WEB);
                                    derecOtoWEb.setComponenteCve(Constants.ALTAWEB);
                                    derecOtoWEb.setIpMaquina(ipMaquina);
                                    boolean insertoDir = insertarDirecto(derecOtoWEb);
                                    if (!insertoDir) {
                                        correcto = 1;
                                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
                                    }
                                }
                            } else {
                                correcto = seActualizoC;
                            }
                        }

                    }
                } else {
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.REALIZAR_TRAMITE_OFIC_ISSSSTE);
                }
            } else {
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DATOS_EMPLEO_NO_REGISTRADO);
            }
        }
        return correcto;
    }

    /**
     *Se actualiza el trabajador
     */
    private int actualizarPlazaTrabajador(PlazaVO plazaAV, String ipMaquina) {
        int actualizar = 0;
        Double sueldoIssste = 0.0;

        //Se obtiene la plaza en sipesic con respecto a la llave que es el ramo anterior y la pagaduria de Av
        PlazaVO plazaTrabCSipe = obtenerPlazaconRamoAnt(plazaAV);
        if (plazaTrabCSipe != null) {
            CSalarioVO salarioMin = salarioDao.obtenerSalarioMin();
            CtnoCveVO nombPzaTrabAV = datosLaborales.obtenerClaveSicNombramientoTrabajador(plazaAV.getTnoCve().intValue());
            if (nombPzaTrabAV.getTnoCveSic().intValue() == 0) {
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_EXISTEN_PLAZAS_EN_AFILIACION_Y_VIGENCIA);
            }
            plazaAV.setTnoCve(nombPzaTrabAV.getTnoCveSic());
            //Se cambia la obtencion del ramo anterior para la actualizacion y la deduccion se puedan hacer por ramo Anterior
            Integer ramAnteSipe = coberturaDao.buscarRamoAnterior(plazaAV.getNumRamo().intValue(), plazaAV.getNumPagaduria(), properties.getParametro("conection.dsipe"));
            plazaAV.setRamoAnterior(ramAnteSipe);
            if (plazaAV.getSueldoIssste() > (salarioMin.getSalarioMin() * 10)) {
                sueldoIssste = salarioMin.getSalarioMin() * 10;
            } else {
                sueldoIssste = plazaTrabCSipe.getSueldoIssste();
            }
            boolean seActualizo = actualizarPlaza(plazaAV, null, sueldoIssste, Constants.OPERADOR_WEB, Constants.ACTWEB, ipMaquina);
            if (seActualizo) {
                //Al agregar la deduccion va con respecto al ramoAnterior, donde no se conoce donde lo obtiene
                DeduccionesVO deduccionesVO = generarDeduccion(plazaAV.getNumIssste().intValue(), plazaAV.getRamoAnterior().intValue(), plazaAV.getNumPagaduria(), plazaAV.getNumRamo().intValue()
                        );
                if (!deduccionesVO.isBanderaGuardar()) {
                    boolean insertB = agregarDeduccion(deduccionesVO);
                    if (!insertB) {
                        actualizar = 1;
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
                    }
                }

            } else {
                actualizar = 1;
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
            }
        } else {
            CSalarioVO salarioMin = salarioDao.obtenerSalarioMin();
            CtnoCveVO nombPzaTrabAV = datosLaborales.obtenerClaveSicNombramientoTrabajador(plazaAV.getTnoCve().intValue());
            if (plazaAV.getSueldoIssste() > (salarioMin.getSalarioMin() * 10)) {
                sueldoIssste = salarioMin.getSalarioMin() * 10;
                plazaAV.setSueldoIssste(sueldoIssste);
            }
            if (nombPzaTrabAV.getTnoCveSic().intValue() == 0) {
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.NO_EXISTEN_PLAZAS_EN_AFILIACION_Y_VIGENCIA);
            }
            //Al agregar la deduccion va con respecto al ramoAnterior, donde no se conoce donde lo obtiene, por lo tanto se seteara el dato antes de insertar la plaza
            Integer ramoAnt = coberturaDao.buscarRamoAnterior(plazaAV.getNumRamo().intValue(), plazaAV.getNumPagaduria(), properties.getParametro("conection.dsipe"));
            plazaAV.setRamoAnterior(ramoAnt);
            plazaAV.setTnoCve(nombPzaTrabAV.getTnoCveSic());
            plazaAV.setUsuario(Constants.OPERADOR_WEB);
            plazaAV.setComponenteCve(Constants.ALTAWEB);
            plazaAV.setIpMaquina(ipMaquina);
            boolean seAgrego = insertarPlaza(plazaAV, null);
            if (seAgrego) {
                DeduccionesVO deduccionesVO = generarDeduccion(plazaAV.getNumIssste().intValue(), plazaAV.getRamoAnterior().intValue(), plazaAV.getNumPagaduria(), plazaAV.getNumRamo().intValue());
                if (!deduccionesVO.isBanderaGuardar()) {
                    boolean insertedD = agregarDeduccion(deduccionesVO);
                    if (!insertedD) {
                        actualizar = 1;
                        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);
                    }
                }
            } else {
                actualizar = 1;
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.ERROR_INESPERADO);

            }
        }
        return actualizar;
    }

    /**
     *Se hace la busqueda con respecto a la llave de AV, que es el ramo anterior y se obtiene la pza_pen
     */
    private PzaPenVO obtenerPlazaPenConRamAnt(PzaPenVO plazaFiltro) {
        DatosLaboralesVO personaPen = new DatosLaboralesVO();
        PzaPenVO plazaPensionado = null;
        personaPen.setNumIssste(plazaFiltro.getNumIssste().intValue());
        personaPen.setPagaduria(plazaFiltro.getNumPagaduria());
        Integer ramoAnterior = coberturaDao.buscarRamoAnterior(plazaFiltro.getNumRamo().intValue(), plazaFiltro.getNumPagaduria(), properties.getParametro("conection.sipesic"));
        if (ramoAnterior != null && ramoAnterior > 0) {
            personaPen.setRamo(ramoAnterior);
            List<PzaPenVO> pensionadoS = datosLaborales.buscarPlazaPensionado(personaPen, properties.getParametro("conection.sipesic"), false);
            if (pensionadoS != null && pensionadoS.size() > 0) {
                plazaPensionado = new PzaPenVO();
                plazaPensionado.setNumIssste(pensionadoS.get(0).getNumIssste());
                plazaPensionado.setNumRamo(pensionadoS.get(0).getNumRamo().intValue());
                plazaPensionado.setNumPagaduria(pensionadoS.get(0).getNumPagaduria());
                plazaPensionado.setImptPension(pensionadoS.get(0).getImptPension());
            }
        }

        return plazaPensionado;
    }

    /**
     *Se hace la busqueda con respecto a la llave de AV, que es el ramo anterior y se obtiene la plaza
     */
    private PlazaVO obtenerPlazaconRamoAnt(PlazaVO plazaVO) {
        DatosLaboralesVO personaPen = new DatosLaboralesVO();
        PlazaVO plazaTrabajador = null;
        personaPen.setNumIssste(plazaVO.getNumIssste().intValue());
        personaPen.setPagaduria(plazaVO.getNumPagaduria());
        Integer ramoAnterior = coberturaDao.buscarRamoAnterior(plazaVO.getNumRamo().intValue(), plazaVO.getNumPagaduria(), properties.getParametro("conection.dsipe"));
            if (ramoAnterior != null && ramoAnterior > 0) {
                personaPen.setRamo(ramoAnterior);
                List<PlazaVO> trajadorA = datosLaborales.buscarPlazas(personaPen, properties.getParametro("conection.sipesic"), false);
                if (trajadorA != null && trajadorA.size() > 0) {
                    plazaTrabajador = new PlazaVO();
                    plazaTrabajador.setNumIssste(trajadorA.get(0).getNumIssste());
                    plazaTrabajador.setNumRamo(trajadorA.get(0).getNumRamo());
                    plazaTrabajador.setNumPagaduria(trajadorA.get(0).getNumPagaduria());
                    plazaTrabajador.setSueldoIssste(trajadorA.get(0).getSueldoIssste());
                }
            }
        
        return plazaTrabajador;
    }

    /**
     * Se valida que el derechohabiente solo tenga una plaza en AV y en Sipesic
     */
    private boolean validarderechohabienteConMasDeUnaPlaza(Integer numIssste) {
        DatosLaboralesVO persona = new DatosLaboralesVO();
        persona.setNumIssste(numIssste);
        boolean conMasPlazas = false;
        List<PlazaVO> plazasAV = datosLaborales.buscarPlazas(persona, properties.getParametro("conection.dsipe"), true);
        if (plazasAV != null && plazasAV.size() > 0) {
            if (plazasAV.size() > 1) {
                conMasPlazas = true;
            } else if (plazasAV.size() == 1) {
                List<PzaPenVO> plazasPenAV = datosLaborales.buscarPlazaPensionado(persona, properties.getParametro("conection.dsipe"), false);
                if (plazasPenAV != null) {
                    if (plazasPenAV.size() >= 1) {
                        conMasPlazas = true;
                    }
                }
            }
        } else {
            List<PzaPenVO> plazasPenAV = datosLaborales.buscarPlazaPensionado(persona, properties.getParametro("conection.dsipe"), false);
            if (plazasPenAV != null && plazasPenAV.size() > 0) {
                if (plazasPenAV.size() > 1) {
                    conMasPlazas = true;
                }
            }
        }

        if (!conMasPlazas) {
            List<PlazaVO> plazasS = datosLaborales.buscarPlazas(persona, properties.getParametro("conection.sipesic"), true);
            if (plazasS != null && plazasS.size() > 0) {
                if (plazasS.size() > 1) {
                    conMasPlazas = true;
                } else if (plazasS.size() == 1) {
                    List<PzaPenVO> plazasPenS = datosLaborales.buscarPlazaPensionado(persona, properties.getParametro("conection.sipesic"), false);
                    if (plazasPenS != null) {
                        if (plazasPenS.size() >= 1) {
                            conMasPlazas = true;
                        }
                    }
                }
            } else {
                List<PzaPenVO> plazasPenS = datosLaborales.buscarPlazaPensionado(persona, properties.getParametro("conection.sipesic"), false);
                if (plazasPenS != null && plazasPenS.size() > 0) {
                    if (plazasPenS.size() > 1) {
                        conMasPlazas = true;
                    }
                }
            }
        }
        return conMasPlazas;
    }

    private DeduccionesVO generarDeduccion(Integer numIssste, Integer ramoPen, String Pagaduria, Integer ramo) {
        
        DeduccionesVO deduccionesVO = new DeduccionesVO();
        deduccionesVO.setIsssteNbr202(numIssste);
        deduccionesVO.setPagaduria(Pagaduria);
        if(ramoPen!=null && ramoPen>0){
            deduccionesVO.setRamo(ramoPen);
        }else{
            deduccionesVO.setRamo(ramo);
        }
        deduccionesVO.setDsctoFovissste(0.0);
        deduccionesVO.setLoanNbrSityf(0.0);
        deduccionesVO.setDsctoSityf(0.0);
        deduccionesVO.setLoanNbrIssste(0.0);
        deduccionesVO.setDsctoIssste(0.0);
        deduccionesVO.setUsuario(Constants.OPERADOR_WEB);
        deduccionesVO.setComponenteCve(Constants.ALTAWEB);
        deduccionesVO.setIpEquipo(null);
        DeduccionesVO dvo = deduccionesDao.obtenerDeduccion(deduccionesVO.getIsssteNbr202(), deduccionesVO.getRamo(), deduccionesVO.getPagaduria());
        if (dvo != null) {
            deduccionesVO.setBanderaGuardar(true);
        } else {
            deduccionesVO.setBanderaGuardar(false);
        }
        return deduccionesVO;
    }

    /** 
     * Se valida que el dia, en el que se hace el otorgamiento Web no sea festivo
     * @return 
     */
    public boolean validarDiaActivoOtorgamientoWeb() {
        boolean diaFestivo = false;
        OtorgamWebContad otoWebNoDisp = transaccionesMovimientosWebDao.obtenerDiaFestivoAlDia();
        if (otoWebNoDisp != null && otoWebNoDisp.getFecha() != null) {
            diaFestivo = true;
        }
        return diaFestivo;
    }

    /**
     *Aqui empiezan las actualizaciones, así como las inserciones, de acuerdo al flujo de validacion usuario
     */
    private boolean actualizarPlaza(PlazaVO plazaVO, PzaPenVO penVO, Double sueldo, String usuario, String componente, String ipMaquina) {
        boolean actualizo = false;
        if (plazaVO != null) {
            try {
                actualizo = datosLaborales.updatePlaza(plazaVO, sueldo, usuario, componente, ipMaquina);
            } catch (Exception e) {
                actualizo = false;
            }
        }
        if (penVO != null) {
            try {
                actualizo = datosLaborales.updatePlazaPen(penVO, sueldo, usuario, componente, ipMaquina);
            } catch (Exception e) {
                actualizo = false;
            }
        }
        return actualizo;
    }

    private boolean agregarDeduccion(DeduccionesVO deduccionesVO) {
        boolean inserto = false;
        try {
            inserto = deduccionesDao.insertDeduccion(deduccionesVO);
        } catch (Exception e) {
            inserto = false;
        }
        return inserto;
    }

    private boolean insertarPlaza(PlazaVO plazaVO, PzaPenVO penVO) {
        boolean inserto = false;
        if (penVO != null) {
            try {
                inserto = datosLaborales.insertPlazaPen(penVO);
            } catch (Exception e) {
                inserto = false;
            }
        }
        if (plazaVO != null) {
            try {
                inserto = datosLaborales.insertPlaza(plazaVO);
            } catch (Exception e) {
                inserto = false;
            }
        }
        return inserto;
    }

    private boolean insertarDirecto(DirectoAVVO directoAVVO) {
        boolean inserto = false;
        try {
            inserto = datosLaborales.insertDirecto(directoAVVO);
        } catch (Exception e) {
            inserto = false;
        }
        return inserto;
    }

    /**
     * 
     * @param cveEntidad
     * @param cveDelegacion
     * @param cveUniad
     * @param cveOficina
     * @return
     */
    public CoberturaGlobVO validarCoberturaUsuarioOtorWeb(int cveEntidad, int cveDelegacion, int cveUniad, int cveOficina) {
        CoberturaGlobVO coberturaGlobVO = new CoberturaGlobVO();
        EntidadVO enti = coberturaDao.obtenerEntidadPorCobertura(cveEntidad);
        CDelegacionVO del = coberturaDao.obtenerDelegacionPorCobertura(cveEntidad, cveDelegacion);
        CUnidadVO unid = coberturaDao.obtenerUnidadPorCobertura(cveEntidad, cveDelegacion, cveUniad);
        COficinaVO ofic = coberturaDao.obtenerOficinaBPorCobertura(cveEntidad, cveDelegacion, cveUniad, cveOficina);
        coberturaGlobVO.setEntidad(enti);
        coberturaGlobVO.setDelegacion(del);
        coberturaGlobVO.setUnidad(unid);
        coberturaGlobVO.setOficina(ofic);

        return coberturaGlobVO;
    }
}
