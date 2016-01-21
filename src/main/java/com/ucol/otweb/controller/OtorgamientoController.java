package com.ucol.otweb.controller;

import com.ucol.otweb.service.IOtorgamientoWEB;
import com.ucol.otweb.service.IProcesosOtorgamientoMService;
import com.ucol.otweb.service.ISimulacionWEB;
import com.ucol.otweb.service.IValidacionFolioWeb;
import com.ucol.otweb.service.IValidacionesGeneralesWeb;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.vo.AgenciaAseguradoAutoVO;
import com.ucol.otweb.vo.CAntiguedadVO;
import com.ucol.otweb.vo.CDelegacionVO;
import com.ucol.otweb.vo.COficinaVO;
import com.ucol.otweb.vo.CUnidadVO;
import com.ucol.otweb.vo.CajaPagadoraVO;
import com.ucol.otweb.vo.CoberturaGlobVO;
import com.ucol.otweb.vo.CramPagVO;
import com.ucol.otweb.vo.DatosLaboralesVO;
import com.ucol.otweb.vo.DescuentoProcVO;
import com.ucol.otweb.vo.DirectoVO;
import com.ucol.otweb.vo.EntidadVO;
import com.ucol.otweb.vo.FolioVO;
import com.ucol.otweb.vo.ObjetoCajasVO;
import com.ucol.otweb.vo.PresolicitudVO;
import com.ucol.otweb.vo.PrstamoOrigVO;
import com.ucol.otweb.vo.RefinanciamientoVO;
import com.ucol.otweb.vo.TpoCreditoVO;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class OtorgamientoController extends MultiActionController {

    public OtorgamientoController() {
    }
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    @Qualifier("otorgamientoWeb")
    private IOtorgamientoWEB iOtorgamientoWEB;
    @Autowired
    @Qualifier("simulacionWeb")
    private ISimulacionWEB simulacionWEB;
    @Autowired
    @Qualifier("validacionGeneralWeb")
    private IValidacionesGeneralesWeb validacionesGeneralesWeb;
    @Autowired
    @Qualifier("validacionFolioWeb")
    private IValidacionFolioWeb validacionFolioWeb;
    @Autowired
    @Qualifier("procesosOtorgamientoServiceM")
    private IProcesosOtorgamientoMService procesosOtorgamientoMService;
    @Autowired
    @Qualifier("sQLErrorCodesFactory")
    private SQLErrorCodesFactory sQLErrorCodesFactory;
    int tipoVentana = 0;
    /*
     * Vista principal
     */

    /**
     * @param sQLErrorCodesFactory the sQLErrorCodesFactory to set
     */
    public void setsQLErrorCodesFactory(SQLErrorCodesFactory sQLErrorCodesFactory) {
        this.sQLErrorCodesFactory = sQLErrorCodesFactory;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView tipoOtorgamiento() {
        ModelAndView mav = new ModelAndView("index", "command", new DatosLaboralesVO());

        return mav;
    }

    @RequestMapping(value = "/tipootorgamiento", method = RequestMethod.POST)
    public ModelAndView tipoOtorgamiento(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("datoslaboralesvo") DatosLaboralesVO datoslaboralesvo, ModelMap model) throws Exception {
        DirectoVO persona = validacionesGeneralesWeb.buscarPersona(datoslaboralesvo);
        String nombrePersona = "";
        if (persona != null) {
            nombrePersona = persona.getNombre().trim() + " " + persona.getApellidoPaterno().trim() + " " + persona.getApellidoMaterno().trim();
            datoslaboralesvo.setNombreCompleto(nombrePersona);
        } else {

            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.REG_NO_ENCONTRADO);
            //datoslaboralesvo.setNombreCompleto(nombrePersona);
        }
        request.getSession().setAttribute("datoslaboralesvo", datoslaboralesvo);
        model.addAttribute("personaDirecto", persona);
        ModelAndView mav = new ModelAndView("tipootorgamiento", "command", model);
        return mav;
    }

    @RequestMapping(value = "/caracteristicasPrestamo", method = RequestMethod.GET)
    public String ventanaEmergenteCaracteristicas() {
        EntidadVO user = new EntidadVO();

        return "caracteristicasPrestamo";
    }

    @RequestMapping(value = "/otorgamiento", method = RequestMethod.POST)
    public ModelAndView datosOtorgamiento(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        DatosLaboralesVO datosLaboralesVO = (DatosLaboralesVO) request.getSession().getAttribute("datoslaboralesvo");
        String ipMaquina = request.getRemoteAddr();
        validacionesGeneralesWeb.validacionUsuario(datosLaboralesVO, ipMaquina);
        DirectoVO directoAux = new DirectoVO();
        String numIsssteA = request.getParameter("issste");
        if (numIsssteA != null && !numIsssteA.equals("")) {
            directoAux.setNumIssste(Integer.parseInt(numIsssteA));
        } else {
            directoAux.setNumIssste(0);
        }
        directoAux.setRfc(request.getParameter("rfc"));
        directoAux.setCurp(request.getParameter("curp"));
        directoAux.setNombre(request.getParameter("nombre"));
        directoAux.setApellidoPaterno(request.getParameter("aPaterno"));
        directoAux.setApellidoMaterno(request.getParameter("aMaterno"));
        PrstamoOrigVO prstamoOrigVO = procesosOtorgamientoMService.obtenerPrestamosAnteriores(directoAux.getNumIssste());
        int banderaPrestamos = 0;
        if (prstamoOrigVO != null) {
            banderaPrestamos = 1;
            model.addAttribute("prstamoOrigVO", prstamoOrigVO);
        } else {
            banderaPrestamos = 2;
        }
        model.addAttribute("directoVO", directoAux);
        model.addAttribute("banderaPrestamos", banderaPrestamos);
        ModelAndView mav = new ModelAndView("otorgamiento");
        return mav;
    }

    @RequestMapping(value = "/confirmacionFolio", method = RequestMethod.POST)
    public ModelAndView ingresarFolio(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("folioVO") FolioVO folioVO, ModelMap model) throws Exception {
        ModelAndView mav = null;
        String ipMaquina = request.getRemoteAddr();
        int cveEntidad = 0;
        boolean activaClave = false;
        DirectoVO directoAux = new DirectoVO();
        List<CajaPagadoraVO> cajasPagadorasCob = null;
        String banderaPrestamos = request.getParameter("banderaPrestamos");
        String numIsssteA = request.getParameter("issste");
        directoAux.setNumIssste(Integer.parseInt(numIsssteA));
        directoAux.setRfc(request.getParameter("rfc"));
        directoAux.setCurp(request.getParameter("curp"));
        directoAux.setNombre(request.getParameter("nombre"));
        directoAux.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        directoAux.setApellidoMaterno(request.getParameter("apellidoMaterno"));
        String ventana = request.getParameter("botonAceptarDatos");
        model.addAttribute("banderaPrestamos", banderaPrestamos);
        model.addAttribute("directoVO", directoAux);
        if (ventana != null && !ventana.isEmpty()) {
            tipoVentana = 1;
            model.addAttribute("tipoVentana", tipoVentana);
            activaClave = procesosOtorgamientoMService.activarProcesoFolFov(Constants.PROC_FOLIO);
            model.addAttribute("activaClave", activaClave);
            mav = new ModelAndView("confirmacionFolio", "command", new FolioVO());
        }

        String botonAceptF = request.getParameter("botonAceptarC");
        if (botonAceptF != null && !botonAceptF.isEmpty()) {
            activaClave = false;
            model.addAttribute("activaClave", activaClave);
            TpoCreditoVO tipoCred = validacionFolioWeb.validacionFolioOtorWeb(directoAux.getNumIssste(), Integer.parseInt(folioVO.getFolioSolicitud()), folioVO.getClave());
            ObjetoCajasVO cajasVO = validacionFolioWeb.validacionParaCajas(directoAux.getNumIssste(), Integer.parseInt(folioVO.getFolioSolicitud()), tipoCred.getCveTcr());
            logger.info("cajasVO.getVentanaMostrar()" + cajasVO.getVentanaMostrar());
            logger.info("cajasVO.getRamoDF()" + cajasVO.getValFolioAuxVO().getRamoCat());
            model.addAttribute("tipoCredito", tipoCred);
            cveEntidad = validacionFolioWeb.obtenerEntidadPorFolio(directoAux.getNumIssste(), Integer.parseInt(folioVO.getFolioSolicitud()), tipoCred.getCveTcr());
            logger.info("cveEntidad---" + cveEntidad);
            logger.info("cveEntidad---" + Constants.ENTIDAD_DF);
            logger.info("Afectaciojn---" + cajasVO.isAfectacionPresupuestal());
            logger.info("cajasVO.getVentanaMostrar()---" + cajasVO.getVentanaMostrar());
            logger.info("Constants.VENT_CONFIR_CIUDAD---" + Constants.VENT_CONFIR_CIUDAD);
            logger.info("Constants.VENT_ELIGE_CIUDAD_DF---" + Constants.VENT_ELIGE_CIUDAD_DF);
            logger.info("Constants.VENT_CONFIR_CREDITO---" + Constants.VENT_CONFIR_CREDITO);
            
            
            boolean bandAfec = cajasVO.isAfectacionPresupuestal();
            if (cajasVO.getVentanaMostrar() == Constants.VENT_CONFIR_CIUDAD) {
                logger.info("Constants.VENT_CONFIR_CIUDAD" + Constants.VENT_CONFIR_CIUDAD);
                if (cveEntidad == Constants.ENTIDAD_DF) {
                    if (cajasVO.isAfectacionPresupuestal()) {
                        cajasPagadorasCob = iOtorgamientoWEB.obtenerCajasPagadoras(Constants.ENTIDAD_ESTATO);
                    } else {
                        tipoVentana = 2;
                        model.addAttribute("tipoVentana", tipoVentana);
                        mav = new ModelAndView("confirmacionFolio", "command", folioVO);
                    }
                } else {
                    cajasPagadorasCob = iOtorgamientoWEB.obtenerCajasPagadoras(cveEntidad);
                }

                if (cajasPagadorasCob != null && cajasPagadorasCob.size() > 0) {
                    if (cajasPagadorasCob.size() == 1) {
                        tipoVentana = 2;
                        model.addAttribute("cajaPagar", cajasPagadorasCob.get(0));
                        // model.addAttribute("tipoCredito", tipoCred);
                        model.addAttribute("tipoVentana", tipoVentana);
                        mav = new ModelAndView("confirmacionFolio", "command", folioVO);
                    } else {
                        // model.addAttribute("tipoCredito", tipoCred);
                        model.addAttribute("nombreImagen", cajasPagadorasCob.get(0).getIdEntidad());
                        model.addAttribute("listaCajas", cajasPagadorasCob);
                        model.addAttribute("folioVO", folioVO);
                        mav = new ModelAndView("mapaCajasPagadoras");
                    }
                }
            } else if (cajasVO.getVentanaMostrar() == Constants.VENT_ELIGE_CIUDAD_DF) {
                logger.info("Constants.VENT_ELIGE_CIUDAD_DF" + Constants.VENT_ELIGE_CIUDAD_DF);
                cajasPagadorasCob = iOtorgamientoWEB.obtenerDetalleCajasPagadoras(Constants.ENTIDAD_ESTATO);
                model.addAttribute("folioVO", folioVO);
                // model.addAttribute("tipoCredito", tipoCred);
                model.addAttribute("listaCajas", cajasPagadorasCob);
                mav = new ModelAndView("eligirCiudadDF");
            } else if (cajasVO.getVentanaMostrar() == Constants.VENT_CONFIR_CREDITO) {
                if ((cajasVO.getValFolioAuxVO().getRamoCat() == 26 || cajasVO.getValFolioAuxVO().getRamoCat() == 226 || cajasVO.getValFolioAuxVO().getRamoCat() == 23) && cveEntidad == Constants.ENTIDAD_DF) {
                    cajasPagadorasCob = iOtorgamientoWEB.obtenerCajasPAgadorasRamoDF(cajasVO.getValFolioAuxVO().getRamoCat());
                    model.addAttribute("folioVO", folioVO);
                    // model.addAttribute("tipoCredito", tipoCred);
                    model.addAttribute("ramoDF", cajasVO.getValFolioAuxVO().getRamoCat());
                    model.addAttribute("listaCajas", cajasPagadorasCob);
                    mav = new ModelAndView("eligirCiudadDF");
                } else {
                    tipoVentana = 2;
                    if (cveEntidad != 9) {
                        CajaPagadoraVO cajaEnviar = iOtorgamientoWEB.obtenerCajasPagadorasAuto(cveEntidad);
                        model.addAttribute("cajaPagar", cajaEnviar);
                        //   model.addAttribute("tipoCredito", tipoCred);
                        model.addAttribute("tipoVentana", tipoVentana);
                        mav = new ModelAndView("confirmacionFolio", "command", folioVO);
                    } else {
                        model.addAttribute("tipoVentana", tipoVentana);
                        mav = new ModelAndView("confirmacionFolio", "command", folioVO);
                    }

                }
            }
        }

        String botonCajas = request.getParameter("botonCalculos");
        if (botonCajas != null && !botonCajas.isEmpty()) {
            CajaPagadoraVO cajaPagadoraVO = null;
            String cveTcr = request.getParameter("cveTcrCred");
            String vehiculo = request.getParameter("vehiculo");
            /*if((!cveTcr.isEmpty() && cveTcr.equals("21"))&& (!vehiculo.isEmpty())){
                if(vehiculo.equals("M")){
                    cveTcr = "22";
                }
            }*/
            if (!request.getParameter("idCajaEntidad").equals("")) {
                cajaPagadoraVO = new CajaPagadoraVO();
                cajaPagadoraVO.setIdEntidad(Integer.parseInt(request.getParameter("idCajaEntidad")));
                cajaPagadoraVO.setIdDelegacion(Integer.parseInt(request.getParameter("idCajaDelegacion")));
                cajaPagadoraVO.setIdUniad(Integer.parseInt(request.getParameter("idCajaUnidad")));
                cajaPagadoraVO.setIdOficina(Integer.parseInt(request.getParameter("idCajaOficina")));
                cajaPagadoraVO.setCiudad(request.getParameter("idCajaCiudad"));
            }
            logger.info("Sali validacion" + directoAux.getNumIssste() +"--"+ folioVO.getCveTcr() +"--"+Integer.parseInt(folioVO.getFolioSolicitud()) +"--"+ Integer.parseInt(cveTcr) +"--"+ ipMaquina);
            PresolicitudVO presolicitudVO = simulacionWEB.simulacion(directoAux.getNumIssste(), folioVO, Integer.parseInt(cveTcr), cajaPagadoraVO, ipMaquina, vehiculo);
            String iniciaDescuento = DateUtils.periodoQuincena(presolicitudVO.getPrstamoOrigVO().getFirstPayPerYrD(),
                    presolicitudVO.getPeriodicidad());
            String finDescuento = DateUtils.periodoQuincena(presolicitudVO.getPrstamoOrigVO().getLastPayPerYrDu(),
                    presolicitudVO.getPeriodicidad());
            presolicitudVO.getPrstamoOrigVO().getFirstPayPerYrD();
            model.addAttribute("presolicitudVO", presolicitudVO);
            model.addAttribute("iniciaDescuento", iniciaDescuento);
            model.addAttribute("finDescuento", finDescuento);
            model.addAttribute("vehiculo", vehiculo);
            mav = new ModelAndView("procesoFinalizado");
        }
        /*Botones de Regresar*/
        String cerrarVen = request.getParameter("cerrarVen");
        if (cerrarVen != null && !cerrarVen.equals("")) {
            model.addAttribute("personaDirecto", directoAux);
            mav = new ModelAndView("tipootorgamiento");
        }

        logger.info("banderaPrestamos" + banderaPrestamos + "-" + directoAux.getNombre());

        String regresarUno = request.getParameter("regresarUno");
        if (regresarUno != null && !regresarUno.equals("")) {
            model.addAttribute("banderaPrestamos", banderaPrestamos);
            model.addAttribute("directoVO", directoAux);
            mav = new ModelAndView("otorgamiento");
        }

        String regresarDos = request.getParameter("regresarDos");
        if (regresarDos != null && !regresarDos.equals("")) {
            String imagen = request.getParameter("imagen");
            String ciudad = request.getParameter("ciudadDF");
            String ramoDF = request.getParameter("ramoDF");
            TpoCreditoVO tipoCred = new TpoCreditoVO();
            tipoCred.setCveTcr(Integer.parseInt(request.getParameter("cveTcrCred")));
            folioVO.setClave(request.getParameter("numClave"));
            tipoCred.setNomTcr(request.getParameter("nomTcrCred"));
            int cveEntidadD = 0;
            logger.info("Foliooo" + folioVO.getFolioSolicitud() + "imagen" + imagen + "Ciudad" + ciudad + "ramo" + ramoDF);

            if (!imagen.equals("")) {
                if (!imagen.equals("0")) {
                    cveEntidadD = Integer.parseInt(imagen);
                    cajasPagadorasCob = iOtorgamientoWEB.obtenerCajasPagadoras(cveEntidadD);
                    model.addAttribute("nombreImagen", cajasPagadorasCob.get(0).getIdEntidad());
                } else {
                    cajasPagadorasCob = iOtorgamientoWEB.obtenerCajasPAgadorasRamoDF(Integer.parseInt(ramoDF));
                    model.addAttribute("ramoDF", ramoDF);
                    model.addAttribute("nombreImagen", 0);
                }
                model.addAttribute("ciudadDF", ciudad);
                model.addAttribute("tipoCredito", tipoCred);
                model.addAttribute("folioVO", folioVO);
                model.addAttribute("listaCajas", cajasPagadorasCob);
                mav = new ModelAndView("mapaCajasPagadoras");
            } else {
                if (ciudad != null && ciudad.equals("Distrito")) {
                    cajasPagadorasCob = iOtorgamientoWEB.obtenerDetalleCajasPagadoras(Constants.ENTIDAD_ESTATO);
                    model.addAttribute("folioVO", folioVO);
                    model.addAttribute("tipoCredito", tipoCred);
                    model.addAttribute("listaCajas", cajasPagadorasCob);
                    mav = new ModelAndView("eligirCiudadDF");
                } else {
                    tipoVentana = 1;
                    activaClave = procesosOtorgamientoMService.activarProcesoFolFov(Constants.PROC_FOLIO);
                    folioVO.setConFolioSolici(folioVO.getFolioSolicitud());
                    folioVO.setClave(request.getParameter("numClave"));
                    model.addAttribute("activaClave", activaClave);
                    model.addAttribute("directoVO", directoAux);
                    model.addAttribute("tipoVentana", tipoVentana);
                    logger.info("Tercera Ventana==>> " + tipoVentana);
                    mav = new ModelAndView("confirmacionFolio", "command", folioVO);
                }

            }
        }

        return mav;

    }

    @RequestMapping(value = "/mapaCajasPagadoras", method = RequestMethod.POST)
    public ModelAndView seleccionCajaPagadora(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("folioVO") FolioVO folioVO, ModelMap model) {
        tipoVentana = 2;
        boolean activaClave = false;
        ModelAndView mav = null;
        TpoCreditoVO creditoVO = new TpoCreditoVO();
        DirectoVO directoAux = new DirectoVO();
        CajaPagadoraVO cajaPagar = new CajaPagadoraVO();
        String numIsssteA = request.getParameter("issste");
        String ramoDF = request.getParameter("ramoDF");
        directoAux.setNumIssste(Integer.parseInt(numIsssteA));
        directoAux.setRfc(request.getParameter("rfc"));
        directoAux.setCurp(request.getParameter("curp"));
        directoAux.setNombre(request.getParameter("nombre"));
        directoAux.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        directoAux.setApellidoMaterno(request.getParameter("apellidoMaterno"));
        if (!request.getParameter("idCajaEntidad").equals("")) {
            cajaPagar.setIdEntidad(Integer.parseInt(request.getParameter("idCajaEntidad")));
            cajaPagar.setIdDelegacion(Integer.parseInt(request.getParameter("idCajaDelegacion")));
            cajaPagar.setIdUniad(Integer.parseInt(request.getParameter("idCajaUnidad")));
            cajaPagar.setIdOficina(Integer.parseInt(request.getParameter("idCajaOficina")));
        }

        creditoVO.setCveTcr(Integer.parseInt(request.getParameter("cveTcrCred")));
        creditoVO.setNomTcr(request.getParameter("nomTcrCred"));
        String imagen = request.getParameter("nombreImagen");
        folioVO.setFolioSolicitud(request.getParameter("folioSolicitud"));
        folioVO.setConFolioSolici(request.getParameter("folioSolicitud"));
        folioVO.setClave(request.getParameter("numClave"));
        String ciudadDF = request.getParameter("ciudadDF");
        model.addAttribute("ramoDF", ramoDF);
        model.addAttribute("ciudadDF", ciudadDF);
        model.addAttribute("imagen", imagen);
        model.addAttribute("directoVO", directoAux);
        model.addAttribute("tipoCredito", creditoVO);
        model.addAttribute("tipoVentana", tipoVentana);
        model.addAttribute("cajaPagar", cajaPagar);
        logger.info("Tercera Ventana==>> " + tipoVentana + "Imagen" + imagen + "clave" + folioVO.getClave());
        mav = new ModelAndView("confirmacionFolio", "command", folioVO);

        String regresarMapa = request.getParameter("regresarMapa");
        if (regresarMapa != null && !regresarMapa.equals("")) {
            if (ciudadDF != null && !ciudadDF.equals("")) {
                List<CajaPagadoraVO> cajasPagadorasCob = null;
                model.addAttribute("tipoCredito", creditoVO);
                model.addAttribute("folioVO", folioVO);
                if (creditoVO.getCveTcr() != 21) {
                    cajasPagadorasCob = iOtorgamientoWEB.obtenerDetalleCajasPagadoras(Constants.ENTIDAD_ESTATO);
                } else {
                    cajasPagadorasCob = iOtorgamientoWEB.obtenerCajasPAgadorasRamoDF(Integer.parseInt(ramoDF));
                }
                model.addAttribute("listaCajas", cajasPagadorasCob);
                mav = new ModelAndView("eligirCiudadDF");
            } else {
                tipoVentana = 1;
                activaClave = procesosOtorgamientoMService.activarProcesoFolFov(Constants.PROC_FOLIO);
                model.addAttribute("activaClave", activaClave);
                model.addAttribute("directoVO", directoAux);
                model.addAttribute("tipoVentana", tipoVentana);
                logger.info("Tercera Ventana==>> " + tipoVentana);
                mav = new ModelAndView("confirmacionFolio", "command", folioVO);
            }
        }
        return mav;
    }

    @RequestMapping(value = "/elegirCiudadDF", method = RequestMethod.POST)
    public ModelAndView elegirCiudadDF(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("folioVO") FolioVO folioVO, ModelMap model) {
        ModelAndView mav = null;
        boolean activaClave = false;
        List<CajaPagadoraVO> cajasPagadorasCob = null;
        tipoVentana = 2;
        TpoCreditoVO creditoVO = new TpoCreditoVO();
        DirectoVO directoAux = new DirectoVO();
        String ramoDF = request.getParameter("ramoDF");
        String numIsssteA = request.getParameter("issste");
        directoAux.setNumIssste(Integer.parseInt(numIsssteA));
        directoAux.setRfc(request.getParameter("rfc"));
        directoAux.setCurp(request.getParameter("curp"));
        directoAux.setNombre(request.getParameter("nombre"));
        directoAux.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        directoAux.setApellidoMaterno(request.getParameter("apellidoMaterno"));
        String ciudadDF = (request.getParameter("estadoEscoger"));
        folioVO.setFolioSolicitud(request.getParameter("folioSolicitud"));
        folioVO.setConFolioSolici(request.getParameter("folioSolicitud"));
        folioVO.setClave(request.getParameter("numClave"));
        creditoVO.setCveTcr(Integer.parseInt(request.getParameter("cveTcrCred")));
        creditoVO.setNomTcr(request.getParameter("nomTcrCred"));
        logger.info(ciudadDF);
        logger.info("getCveTcr()"+creditoVO.getCveTcr());
        logger.info("ciudadDF"+tipoVentana);
        if (ciudadDF.equals(Constants.CIUDADEDOMEX)) {
            cajasPagadorasCob = iOtorgamientoWEB.obtenerCajasPagadoras(Constants.ENTIDAD_ESTATO);
            model.addAttribute("ciudadDF", ciudadDF);
            model.addAttribute("directoVO", directoAux);
            model.addAttribute("tipoCredito", creditoVO);
            model.addAttribute("nombreImagen", cajasPagadorasCob.get(0).getIdEntidad());
            model.addAttribute("listaCajas", cajasPagadorasCob);
            mav = new ModelAndView("mapaCajasPagadoras", "command", folioVO);

        } else if (ciudadDF.equals(Constants.CIUDADISTRITO) && creditoVO.getCveTcr() != 21) {
            model.addAttribute("ciudadDF", ciudadDF);
            model.addAttribute("directoVO", directoAux);
            model.addAttribute("tipoCredito", creditoVO);
            model.addAttribute("tipoVentana", tipoVentana);
            logger.info("Tercera Ventana==>> " + tipoVentana + "--");
            mav = new ModelAndView("confirmacionFolio", "command", folioVO);
        } else if (ciudadDF.equals(Constants.CIUDADISTRITO) && creditoVO.getCveTcr() == 21) {
            cajasPagadorasCob = iOtorgamientoWEB.obtenerCajasPAgadorasRamoDF(Integer.parseInt(ramoDF));
            model.addAttribute("ramoDF", ramoDF);
            model.addAttribute("ciudadDF", ciudadDF);
            model.addAttribute("directoVO", directoAux);
            model.addAttribute("tipoCredito", creditoVO);
            model.addAttribute("nombreImagen", 0);
            model.addAttribute("listaCajas", cajasPagadorasCob);
            mav = new ModelAndView("mapaCajasPagadoras", "command", folioVO);
        }
        String regresaElige = request.getParameter("regresarEligCiud");
        if (regresaElige != null && !regresaElige.equals("")) {
            tipoVentana = 1;
            activaClave = procesosOtorgamientoMService.activarProcesoFolFov(Constants.PROC_FOLIO);
            model.addAttribute("activaClave", activaClave);
            model.addAttribute("tipoCredito", creditoVO);
            model.addAttribute("directoVO", directoAux);
            model.addAttribute("tipoVentana", tipoVentana);
            mav = new ModelAndView("confirmacionFolio", "command", folioVO);
        }
        return mav;
    }

    @RequestMapping(value = "/confirmarCredito", method = RequestMethod.POST)
    public ModelAndView confirmarPrestamoFinal(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        ModelAndView mav = null;
        PresolicitudVO presolicitud = new PresolicitudVO();
        String vehiculo = request.getParameter("vehiculo");
        DirectoVO directoAux = new DirectoVO();
        directoAux.setNumIssste(Integer.parseInt(request.getParameter("numIssste")));
        directoAux.setRfc(request.getParameter("rfc"));
        directoAux.setCurp(request.getParameter("curp"));
        directoAux.setNombre(request.getParameter("nombre"));
        directoAux.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        directoAux.setApellidoMaterno(request.getParameter("apellidoMaterno"));
        directoAux.setSexo(request.getParameter("sexo"));
        presolicitud.setDirecto(directoAux);
        presolicitud.setDiaFec(Integer.parseInt(request.getParameter("diaFec")));
        presolicitud.setMesFec(Integer.parseInt(request.getParameter("mesFec")));
        presolicitud.setAnioFEc(Integer.parseInt(request.getParameter("anioFec")));
        String botonAcep = request.getParameter("botonAceptarCredito");
        if (botonAcep != null && !botonAcep.equals("")) {
            FolioVO folioVO = new FolioVO();
            TpoCreditoVO tpoCreditoVO = new TpoCreditoVO();
            CoberturaGlobVO coberturaGlobVO = new CoberturaGlobVO();
            DescuentoProcVO descuentoProcVO = new DescuentoProcVO();
            PrstamoOrigVO prstamoOrigVO = new PrstamoOrigVO();
            CramPagVO cramPagVO = new CramPagVO();
            CAntiguedadVO cAntiguedadVO = new CAntiguedadVO();
            RefinanciamientoVO refinanciamientoVO = new RefinanciamientoVO();
            EntidadVO entidadVO = new EntidadVO();
            CDelegacionVO delegacionVO = new CDelegacionVO();
            CUnidadVO unidadVO = new CUnidadVO();
            COficinaVO oficinaVO = new COficinaVO();
            entidadVO.setCveEntidad(Integer.parseInt(request.getParameter("coberturaGlobVOEnt")));
            delegacionVO.setCveDeleg(Integer.parseInt(request.getParameter("coberturaGlobVODel")));
            unidadVO.setCveUniad(Integer.parseInt(request.getParameter("coberturaGlobVOUni")));
            oficinaVO.setCveOficina(Integer.parseInt(request.getParameter("coberturaGlobVOOfi")));
            coberturaGlobVO.setEntidad(entidadVO);
            coberturaGlobVO.setDelegacion(delegacionVO);
            coberturaGlobVO.setUnidad(unidadVO);
            coberturaGlobVO.setOficina(oficinaVO);
            descuentoProcVO.setDif(Integer.parseInt(request.getParameter("descuentoProcVODif")));
            folioVO.setFolioSolicitud(request.getParameter("folioSolicitud"));
            folioVO.setCveTcr(Integer.parseInt(request.getParameter("tpoCredito")));
            tpoCreditoVO.setCveTcr(Integer.parseInt(request.getParameter("tpoCredito")));
            tpoCreditoVO.setNomTcr(request.getParameter("nomCredito"));
            presolicitud.setDescuentoProcVO(descuentoProcVO);
            presolicitud.setCoberturaGlobVO(coberturaGlobVO);
            presolicitud.setTpoCreditoVO(tpoCreditoVO);
            presolicitud.setNumRamo(Integer.parseInt(request.getParameter("numRamo")));
            presolicitud.setNumPagaduria(request.getParameter("numPagaduria"));
            presolicitud.setCveTrc(tpoCreditoVO.getCveTcr());
            presolicitud.setFolioSol(Integer.parseInt(request.getParameter("folioSolicitud")));
            cramPagVO.setRamoCat(Integer.parseInt(request.getParameter("cramPagVORamoCat")));
            cramPagVO.setPagaCat(request.getParameter("cramPagVOPagaCat"));
            cramPagVO.setNombCat(request.getParameter("cramPagVONombCat"));
            presolicitud.setCramPagVO(cramPagVO);
            presolicitud.setDescRamo(request.getParameter("descRamo"));
            presolicitud.setSueldoDer(Double.parseDouble(request.getParameter("sueldoDer")));
            presolicitud.setCveStatSol(Integer.parseInt(request.getParameter("cveStatSol")));
            prstamoOrigVO.setIsssteNbr(Integer.parseInt(request.getParameter("prstamoOrigVOIsssteNbr")));
            prstamoOrigVO.setAnioFolio(Integer.parseInt(request.getParameter("prstamoOrigVOAnioFolio")));
            if(request.getParameter("prstamoOrigVOOrigLoanP")!=null && !request.getParameter("prstamoOrigVOOrigLoanP").isEmpty()){
                prstamoOrigVO.setOrigLoanPrin(new Double(request.getParameter("prstamoOrigVOOrigLoanP")));
            }
            if(request.getParameter("prstamoOrigVOImpLiquid")!=null && !request.getParameter("prstamoOrigVOImpLiquid").isEmpty()){
                prstamoOrigVO.setImpLiquido(new Double(request.getParameter("prstamoOrigVOImpLiquid")));
            }
            if(request.getParameter("prstamoOrigVOOrigLoanI")!=null && !request.getParameter("prstamoOrigVOOrigLoanI").isEmpty()){
                prstamoOrigVO.setOrigLoanIntAmt(new Double(request.getParameter("prstamoOrigVOOrigLoanI")));
            }
            if(request.getParameter("prstamoOrigVOOrigIva")!=null && !request.getParameter("prstamoOrigVOOrigIva").isEmpty()){
                prstamoOrigVO.setOrigIva(new Double(request.getParameter("prstamoOrigVOOrigIva")));
            }
            if(request.getParameter("prstamoOrigVODeferredI")!=null && !request.getParameter("prstamoOrigVODeferredI").isEmpty()){
                prstamoOrigVO.setDeferredInt(new Double(request.getParameter("prstamoOrigVODeferredI")));
            }
            if(request.getParameter("prstamoOrigVOWarrantyP")!=null && !request.getParameter("prstamoOrigVOWarrantyP").isEmpty()){
                prstamoOrigVO.setWarrantyPrem(new Double(request.getParameter("prstamoOrigVOWarrantyP")));
            }
            if(request.getParameter("prstamoOrigVORenewalPr")!=null && !request.getParameter("prstamoOrigVORenewalPr").isEmpty()){
                prstamoOrigVO.setRenewalPrem(new Double(request.getParameter("prstamoOrigVORenewalPr")));
            }
            if(request.getParameter("prstamoOrigVOIntRate")!=null && !request.getParameter("prstamoOrigVOIntRate").isEmpty()){
                prstamoOrigVO.setIntRate(new Double(request.getParameter("prstamoOrigVOIntRate")));
            }
            if(request.getParameter("prstamoOrigVOivaRate")!=null && !request.getParameter("prstamoOrigVOivaRate").isEmpty()){
                prstamoOrigVO.setIvaRate(new Double(request.getParameter("prstamoOrigVOivaRate")));
            }
            if(request.getParameter("prstamoOrigVOorigNbrPa")!=null && !request.getParameter("prstamoOrigVOorigNbrPa").isEmpty()){
                prstamoOrigVO.setOrigNbrPay(Integer.parseInt(request.getParameter("prstamoOrigVOorigNbrPa")));
            }
            if(request.getParameter("prstamoOrigVOpayAmt")!=null && !request.getParameter("prstamoOrigVOpayAmt").isEmpty()){
                prstamoOrigVO.setPayAmt(new Double(request.getParameter("prstamoOrigVOpayAmt")));
            }
            if(request.getParameter("prstamoOrigVOfirstPayP")!=null && !request.getParameter("prstamoOrigVOfirstPayP").isEmpty()){
                prstamoOrigVO.setFirstPayPerYrD(request.getParameter("prstamoOrigVOfirstPayP"));
            }
            if(request.getParameter("prstamoOrigVOlastPayPe")!=null && !request.getParameter("prstamoOrigVOlastPayPe").isEmpty()){
                prstamoOrigVO.setLastPayPerYrDu(request.getParameter("prstamoOrigVOlastPayPe"));
            }
            if(request.getParameter("prstamoOrigVOnumPrest1")!=null && !request.getParameter("prstamoOrigVOnumPrest1").isEmpty()){
                prstamoOrigVO.setNumPrestRef1(new Double(request.getParameter("prstamoOrigVOnumPrest1")));
            }
            if(request.getParameter("prstamoOrigVOnumPrest2")!=null && !request.getParameter("prstamoOrigVOnumPrest2").isEmpty()){
                prstamoOrigVO.setNumPrestRef2(new Double(request.getParameter("prstamoOrigVOnumPrest2")));
            }
            if(request.getParameter("prstamoOrigVOnumPrest3")!=null && !request.getParameter("prstamoOrigVOnumPrest3").isEmpty()){
                prstamoOrigVO.setNumPrestRef3(new Double(request.getParameter("prstamoOrigVOnumPrest3")));
            }
            if(request.getParameter("prstamoOrigVOtipoPresu")!=null && !request.getParameter("prstamoOrigVOtipoPresu").isEmpty()){
                prstamoOrigVO.setTipoPresup(request.getParameter("prstamoOrigVOtipoPresu"));
            }
            if(request.getParameter("prstamoOrigVOcveAfect")!=null && !request.getParameter("prstamoOrigVOcveAfect").isEmpty()){
                prstamoOrigVO.setCveAfect(Integer.parseInt(request.getParameter("prstamoOrigVOcveAfect")));
            }
            if(request.getParameter("prstamoOrigVOtnoCve")!=null && !request.getParameter("prstamoOrigVOtnoCve").isEmpty()){
                prstamoOrigVO.setTnoCve(request.getParameter("prstamoOrigVOtnoCve"));
            }
            if(request.getParameter("prstamoOrigVOmodoPago")!=null && !request.getParameter("prstamoOrigVOmodoPago").isEmpty()){
                prstamoOrigVO.setModoPago(Integer.parseInt(request.getParameter("prstamoOrigVOmodoPago")));
            }
            if(request.getParameter("prstamoOrigVOtipoCuent")!=null && !request.getParameter("prstamoOrigVOtipoCuent").isEmpty()){
                prstamoOrigVO.setTipoCuenta(Integer.parseInt(request.getParameter("prstamoOrigVOtipoCuent")));
            }
            if(request.getParameter("prstamoOrigVOtipoOd")!=null && !request.getParameter("prstamoOrigVOtipoOd").isEmpty()){
                prstamoOrigVO.setTipoOd(Integer.parseInt(request.getParameter("prstamoOrigVOtipoOd")));
            }
            presolicitud.setPrstamoOrigVO(prstamoOrigVO);
            presolicitud.setIpMaquina(request.getParameter("ipMaquina"));
            presolicitud.setSaldoRef(new Double(request.getParameter("saldoRef")));
            if(request.getParameter("sueldoMensual")!=null && !request.getParameter("sueldoMensual").isEmpty()){
                presolicitud.setSueldoMensual(new Double(request.getParameter("sueldoMensual")));
            }
            if(request.getParameter("deduccionesVO")!=null && !request.getParameter("deduccionesVO").isEmpty()){
                presolicitud.setDeduccionesVO(new Double(request.getParameter("deduccionesVO")));
            }
            presolicitud.setAltaModFluj(Integer.parseInt(request.getParameter("altaModFluj")));
            presolicitud.setPeriodicidad(request.getParameter("periodicidad"));
            cAntiguedadVO.setAnio(Integer.parseInt(request.getParameter("cAntiguedadVOAnio")));
            cAntiguedadVO.setMes(Integer.parseInt(request.getParameter("cAntiguedadVOMes")));
            cAntiguedadVO.setDia(Integer.parseInt(request.getParameter("cAntiguedadVODia")));
            cAntiguedadVO.setAntiguedad(Integer.parseInt(request.getParameter("cAntiguedadVOAntig")));
            presolicitud.setcAntiguedadVO(cAntiguedadVO);
            presolicitud.setRefinancia(Integer.parseInt(request.getParameter("refinancia")));
            if(request.getParameter("refinanciamientoVOldSaldoRef")!=null && !request.getParameter("refinanciamientoVOldSaldoRef").isEmpty()){
                refinanciamientoVO.setLdSaldoRef(new Double(request.getParameter("refinanciamientoVOldSaldoRef")));
            }
            if(request.getParameter("refinanciamientoVOldCapRefin")!=null && !request.getParameter("refinanciamientoVOldCapRefin").isEmpty()){
                refinanciamientoVO.setLdCapRefinanc(new Double(request.getParameter("refinanciamientoVOldCapRefin")));
            }
            if(request.getParameter("refinanciamientoVOldIntRefin")!=null && !request.getParameter("refinanciamientoVOldIntRefin").isEmpty()){
                refinanciamientoVO.setLdIntRefinanc(new Double(request.getParameter("refinanciamientoVOldIntRefin")));
            }
            if(request.getParameter("refinanciamientoVOldIvaRefin")!=null && !request.getParameter("refinanciamientoVOldIvaRefin").isEmpty()){
                refinanciamientoVO.setLdIvaRefinanc(new Double(request.getParameter("refinanciamientoVOldIvaRefin")));
            }
            refinanciamientoVO.setLsQnasf(Integer.parseInt(request.getParameter("refinanciamientoVOlsQnasf")));
            refinanciamientoVO.setLdAmtLastPmt(new Double(request.getParameter("refinanciamientoVOldAmtLastP")));
            
            if(request.getParameter("refinanciamientoVOpagoRef1")!=null && !request.getParameter("refinanciamientoVOpagoRef1").isEmpty()){
                refinanciamientoVO.setPagoRef1(new Double(request.getParameter("refinanciamientoVOpagoRef1")));
            }
            if(request.getParameter("refinanciamientoVOpagoRef2")!=null && !request.getParameter("refinanciamientoVOpagoRef2").isEmpty()){
                refinanciamientoVO.setPagoRef2(new Double(request.getParameter("refinanciamientoVOpagoRef2")));
            }
            if(request.getParameter("refinanciamientoVOpagoRef3")!=null && !request.getParameter("refinanciamientoVOpagoRef3").isEmpty()){
                refinanciamientoVO.setPagoRef3(new Double(request.getParameter("refinanciamientoVOpagoRef3")));
            }
            presolicitud.setRefinanciamientoVO(refinanciamientoVO);
            presolicitud = iOtorgamientoWEB.otorgamientoWeb(presolicitud,directoAux, folioVO, false, 0, vehiculo);

            model.addAttribute("presol", presolicitud);
            if (presolicitud.getTpoCreditoVO().getCveTcr() != Constants.TPO_PRESTAM_AUTO) {
                mav = new ModelAndView("imprimirPlanFinanciamientoS");
            } else {
                mav = new ModelAndView("planFinanciamientoAutos");
            }
        }
        String rechazPrest = request.getParameter("rechazoPrest");
        if (rechazPrest != null && !rechazPrest.equals("")) {
            model.addAttribute("personaDirecto", directoAux);
            mav = new ModelAndView("tipootorgamiento", "command", model);

        }
        return mav;
    }

    @RequestMapping(value = "/ventanaAuxiliar", method = RequestMethod.GET)
    public ModelAndView ventanaAuxiliar(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        ModelAndView mav = null;
        int varAgen = 0, varAseg=0;
        List<AgenciaAseguradoAutoVO> agenciasL = new ArrayList<AgenciaAseguradoAutoVO>();
        List<AgenciaAseguradoAutoVO> aseguradorasL = new ArrayList<AgenciaAseguradoAutoVO>();
        List<AgenciaAseguradoAutoVO> agencias = iOtorgamientoWEB.obtenerAgenciasAutos();      
        
        for(AgenciaAseguradoAutoVO agencia: agencias){
            if(agencia.getContante()==1){
                aseguradorasL.add(agencia);
            }
            if(agencia.getContante()==2){
                agenciasL.add(agencia);
            }
        }
        if(agenciasL.isEmpty()){
            varAgen=1;
        }
        
        if(aseguradorasL.isEmpty()){
            varAseg=1;
        }
        
        model.addAttribute("varAseg", varAseg);
        model.addAttribute("varAgen", varAgen);
        model.addAttribute("agencias", agenciasL);
        model.addAttribute("aseguradoras", aseguradorasL);
        mav = new ModelAndView("vistaAgenciasAseguradoras");
        return mav;
    }

    /**
     * @param iOtorgamientoWEB the iOtorgamientoWEB to set
     */
    public void setiOtorgamientoWEB(IOtorgamientoWEB iOtorgamientoWEB) {
        this.iOtorgamientoWEB = iOtorgamientoWEB;
    }
}
