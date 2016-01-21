/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service.impl;

import com.ucol.otweb.dao.ICoberturaDao;
import com.ucol.otweb.dao.IDatosLaborales;
import com.ucol.otweb.dao.IFolioDao;
import com.ucol.otweb.dao.IPrestamoOrigDao;
import com.ucol.otweb.dao.IRamoPagaduriaDao;
import com.ucol.otweb.dao.IRecepcionSolicitudDao;
import com.ucol.otweb.dao.ITipoCreditoDAO;
import com.ucol.otweb.service.IProcesosOtorgamientoMService;
import com.ucol.otweb.service.IValidacionFolioWeb;
import com.ucol.otweb.service.IValidacionesGeneralesWeb;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.MD5;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.vo.DatosLaboralesVO;
import com.ucol.otweb.vo.DirectoVO;
import com.ucol.otweb.vo.FolioClaveVO;
import com.ucol.otweb.vo.FolioVO;
import com.ucol.otweb.vo.ObjetoCajasVO;
import com.ucol.otweb.vo.PlazaVO;
import com.ucol.otweb.vo.PresolicitudVO;
import com.ucol.otweb.vo.PzaPenVO;
import com.ucol.otweb.vo.RecepcionVO;
import com.ucol.otweb.vo.TpoCreditoVO;
import com.ucol.otweb.vo.TransMovOtoWeb;
import com.ucol.otweb.vo.ValFolioAuxVO;
import com.ucol.otweb.vo.cRamEsp;
import java.security.NoSuchAlgorithmException;
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
@Repository(value = "validacionFolioWeb")
public class ValidacionFolioWebSI implements IValidacionFolioWeb {

    @Autowired
    @Qualifier("datosLaborales")
    private IDatosLaborales datosLaborales;
    @Autowired
    @Qualifier("coberturaDao")
    private ICoberturaDao coberturaDao;
    @Autowired
    @Qualifier("folioDao")
    private IFolioDao folioDao;
    @Autowired
    @Qualifier("tipoCreditoDAO")
    private ITipoCreditoDAO tipoCreditoDAO;
    @Autowired
    @Qualifier("ramoPagaduriaDao")
    private IRamoPagaduriaDao ramoPagaduriaDao;
    @Autowired
    @Qualifier("recepcionSolDao")
    private IRecepcionSolicitudDao solicitudDao;
    @Autowired
    @Qualifier("prestamoOrigDao")
    private IPrestamoOrigDao prestamoOrigDao;
    @Autowired
    @Qualifier("validacionGeneralWeb")
    private IValidacionesGeneralesWeb valGeneralesWeb;
    @Autowired
    @Qualifier("procesosOtorgamientoServiceM")
    private IProcesosOtorgamientoMService procesosOtorgamientoMService;
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
     *Se valida el folio que el usuario ha insertado desde la pantalla
     */
    public TpoCreditoVO validacionFolioOtorWeb(Integer numIssste, Integer numFolio, String clave) {
        boolean folioPermitido = false;
        TpoCreditoVO tipoCredito = null;
        List<FolioVO> foliosEncontrados = folioDao.consultaFolioXPrestamo(null, numFolio);
        if (foliosEncontrados != null && foliosEncontrados.size() > 0) {
            if (foliosEncontrados.get(0).getCveTcr() != Constants.TIPO_PREST_ADQ_BIENES_DURADEROS) {
                folioPermitido = true;
            }
            if(foliosEncontrados.get(0).getCveTcr() == Constants.TPO_PRESTAM_AUTO){
                boolean activaClave = procesosOtorgamientoMService.activarProcesoFolFov(Constants.PROC_AUTOS);
                System.out.println("activaClave--"+activaClave);
                if(!activaClave){
                    folioPermitido=false;
                }
            }
            if (folioPermitido) {
                tipoCredito = tipoCreditoDAO.obtenerTipoCredito(foliosEncontrados.get(0).getCveTcr());
                if (clave != null && !clave.equals("")) {
                    FolioVO folio = new FolioVO();
                    folio.setFolioSolicitud(String.valueOf(numFolio));
                    folio.setCveTcr(foliosEncontrados.get(0).getCveTcr());
                    folio.setClave(clave);
                    validacionClaveFolio(folio);
                }
            } else {
                System.out.println("Me quede aqui!----"+foliosEncontrados.get(0).getCveTcr()+"folioPermitido+--"+ folioPermitido );
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.PRESTAMO_SOLO_EN_OFIC_ISSSTE);

            }
        } else {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.FOLIO_NO_REGISTRADO);
        }
        return tipoCredito;
    }

    public ObjetoCajasVO validacionParaCajas(Integer numIssste, Integer numFolio, int tpoCredito) {
        ObjetoCajasVO mapaMotrar = new ObjetoCajasVO();
        ValFolioAuxVO cramPagVO = validaFolioYAfectacionPresupuestal(numIssste, numFolio);
        boolean activaClave = procesosOtorgamientoMService.activarProcesoFolFov(Constants.PROC_AUTOS);
        if (activaClave && tpoCredito== Constants.TPO_PRESTAM_AUTO) {
            mapaMotrar.setVentanaMostrar(Constants.VENT_CONFIR_CREDITO);
            mapaMotrar.setValFolioAuxVO(cramPagVO);
        } else {
            if (cramPagVO.isAfectacionPresuspuestal()) {
                if (cramPagVO.getRamoCat() == 26 || cramPagVO.getRamoCat() == 226 || cramPagVO.getRamoCat() == 23) {
                    mapaMotrar.setVentanaMostrar(Constants.VENT_CONFIR_CREDITO);//EligeCiudadDF
                } else {
                    cramPagVO.setAfectacionPresuspuestal(false);
                    if (cramPagVO.isBanderaEdoMEx()) {
                        mapaMotrar.setVentanaMostrar(Constants.VENT_ELIGE_CIUDAD_DF);
                    } else {
                        mapaMotrar.setVentanaMostrar(Constants.VENT_CONFIR_CIUDAD);
                    }
                }
            } else {
                if (cramPagVO.isBanderaEdoMEx()) {
                    mapaMotrar.setVentanaMostrar(Constants.VENT_ELIGE_CIUDAD_DF);
                } else {
                    mapaMotrar.setVentanaMostrar(Constants.VENT_CONFIR_CIUDAD);
                }
            }
            mapaMotrar.setValFolioAuxVO(cramPagVO);
        }
        return mapaMotrar;
    }

    /**
     *Se valida el folio, se obtiene la afectación Presupuestal y con respecto a esto se obtiene el ramo
     */
    public ValFolioAuxVO validaFolioYAfectacionPresupuestal(Integer numIssste, Integer numFolio) {
        properties.cargaArchivo();
        DatosLaboralesVO persona = new DatosLaboralesVO();
        ValFolioAuxVO valFolioAuxVO = new ValFolioAuxVO();
        boolean banderaEstMex = false;
        persona.setNumIssste(numIssste);
        DirectoVO directoVO = valGeneralesWeb.buscarPersona(persona);
        Integer entidadesPersona = coberturaDao.buscarEntidadPorCodigoPostal(directoVO.getCodigoPostal().intValue());
        TpoCreditoVO tpoCreditoVO = validacionFolioOtorWeb(numIssste, numFolio, null);
        List<FolioVO> folioAfec = folioDao.consultaFolioXPrestamo(tpoCreditoVO.getCveTcr(), numFolio);

        if (folioAfec.get(0).getCveAfectaPresup() == 0) {
            valFolioAuxVO.setAfectacionPresuspuestal(false);
        } else {
            valFolioAuxVO.setAfectacionPresuspuestal(true);
        }
        if ((entidadesPersona == Constants.ENTIDAD_ESTATO || entidadesPersona == Constants.ENTIDAD_DF) && (folioAfec.get(0).getCveEntidad() == Constants.CVE_ENTIDAD_GLOBAL)) {
            List<PlazaVO> plazasDer = datosLaborales.buscarPlazas(persona, properties.getParametro("conection.sipesic"), true);
            if (plazasDer != null && plazasDer.size() > 0) {
                PlazaVO plazaVO = plazasDer.get(0);
                //numRamo = plazaVO.getNumRamo().intValue();
                valFolioAuxVO.setRamoCat(plazaVO.getNumRamo().intValue());
                //pagaduria = plazaVO.getNumPagaduria();
                valFolioAuxVO.setPagaduriaCat(plazaVO.getNumPagaduria());

            } else {
                List<PzaPenVO> plazasPenDer = datosLaborales.buscarPlazaPensionado(persona, properties.getParametro("conection.sipesic"), false);
                PzaPenVO pzaPenVO = plazasPenDer.get(0);
                //numRamo = pzaPenVO.getNumRamo().intValue();
                valFolioAuxVO.setRamoCat(pzaPenVO.getNumRamo().intValue());
                //pagaduria = pzaPenVO.getNumPagaduria();
                valFolioAuxVO.setPagaduriaCat(pzaPenVO.getNumPagaduria());
            }
            banderaEstMex = validarRamoDFEstadoMex(valFolioAuxVO.getRamoCat(), valFolioAuxVO.getPagaduriaCat());

        } else {
            valFolioAuxVO.setRamoCat(0);
            valFolioAuxVO.setPagaduriaCat("");
        }
        valFolioAuxVO.setBanderaEdoMEx(banderaEstMex);
        return valFolioAuxVO;
    }

    /**
     *Se obtiene la entidad de acuerdo al folioy al numero de issste
     */
    public int obtenerEntidadPorFolio(Integer numIssste, Integer numFolio, Integer tipoPrestamo) {

        DatosLaboralesVO vO = new DatosLaboralesVO();
        vO.setNumIssste(numIssste);
        int cveEntidad = 0;
        List<FolioVO> foliosVO = folioDao.consultaFolioXPrestamo(tipoPrestamo, numFolio);
        if (foliosVO.get(0).getCveEntidad() == 0) {
            DirectoVO directoVO = valGeneralesWeb.buscarPersona(vO);
            cveEntidad = coberturaDao.buscarEntidadPorCodigoPostal(directoVO.getCodigoPostal().intValue());
        } else {
            cveEntidad = foliosVO.get(0).getCveEntidad();
        }
        if (cveEntidad == 0) {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DATOS_EMPLEO_NO_REGISTRADO);
        }
        return cveEntidad;
    }

    /**
     * En caso de que no se tenga afectacion presupuestal, se valida el ramo para para ver si pasa a la seleccion de ciudad
     */
    public boolean validarRamoDFEstadoMex(int ramo, String pagaduria) {
        boolean ramoAcep = false;
        cRamEsp ramoEsp = null;
        if (ramo == 23 || ramo == 26 || ramo == 226) {
            ramoAcep = true;
        } else {
            List<cRamEsp> ramosExpecial = ramoPagaduriaDao.obtenerRamoEspecial(ramo, pagaduria);
            if (ramosExpecial != null && ramosExpecial.size() > 0) {
                ramoEsp = ramosExpecial.get(0);
                if (ramoEsp.getNumRamoAnt() != null) {
                    ramoAcep = true;
                }
            }
        }
        return ramoAcep;
    }

    /**
     *Métodos de validación del folio de la solicitud en la función otorga del service OtorgamientoWeb
     */
    public int validaFolioGeneralSolicitud(TransMovOtoWeb movOtoWeb, int nombramiento) {
        int valFolioInc = 0;
        RecepcionVO recepcionVO = new RecepcionVO();
        recepcionVO.setFolioSol(movOtoWeb.getFolio());
        recepcionVO.setCveTcr(movOtoWeb.getTipo_prst());
        Integer cFolBloq = folioDao.countFoliosBloqueados(recepcionVO);
        //System.out.println("ValidacionFolioGeneral<<<<"+ cFolBloq);
        if (cFolBloq > 0) {
            return valFolioInc = 1;
        }
        if ((movOtoWeb.getTipo_prst() == Constants.TIPO_PREST_ESP_PEN || movOtoWeb.getTipo_prst() == Constants.TIPO_PREST_EXC_PEN) && nombramiento != Constants.C_PENSION) {
            return valFolioInc = 2;
        }
        boolean numIsssteDif = solicitudOcupadaNumIssste(movOtoWeb.getNumIssste(), movOtoWeb.getFolio(), movOtoWeb.getTipo_prst());
        //System.out.println("ValidacionFolioGeneral<<<<"+ numIsssteDif);
        if (numIsssteDif) {
            return valFolioInc = 1;
        }
        Integer prestFoli = prestamoOrigDao.countNumeroPrestamosNoCancelados(movOtoWeb.getFolio(), movOtoWeb.getTipo_prst());
        //System.out.println("ValidacionFolioGeneral>>>"+ prestFoli);
        if (prestFoli > 0) {
            return valFolioInc = 1;
        }
        return valFolioInc;

    }

    public FolioVO obtenerAfectTPrestoDeFolio(int tpoCve, Integer folioSol) {
        FolioVO folioVO = new FolioVO();
        folioVO.setFolioSolicitud(folioSol.toString());
        folioVO.setCveTcr(tpoCve);
        List<FolioVO> listaFolios = folioDao.obtenerFolioSolicitud(folioVO);
        if (listaFolios != null && listaFolios.size() > 0) {
            folioVO = listaFolios.get(0);
        }
        return folioVO;
    }

    private boolean solicitudOcupadaNumIssste(Integer numIssste, Integer numFolio, int tipoCred) {
        boolean ocupadaPorOtroIssste = false;
        Integer solOcupa = solicitudDao.obtenerSolicitudOcupada(numFolio, tipoCred);
        if (solOcupa != null && solOcupa > 0) {
            if (solOcupa == numIssste) {
                ocupadaPorOtroIssste = false;
            } else {
                ocupadaPorOtroIssste = true;
            }
        }
        return ocupadaPorOtroIssste;
    }

    public boolean validarFolio(PresolicitudVO presolicitudVO, int nombramiento) {
        boolean valFol = true;
        FolioVO folio = new FolioVO();
        folio.setCveTcr(presolicitudVO.getTpoCreditoVO().getCveTcr());
        folio.setFolioSolicitud(presolicitudVO.getFolioSol().toString());
        if (nombramiento == Constants.TNO_CVE_HON) {
            nombramiento = Constants.TNO_CVE_BASE;
        }
        List<FolioVO> folios = folioDao.obtenerFolioSolicitud(folio);
        if (folios != null && folios.size() > 0) {
            folio = folios.get(0);
            if (folio.getTpo_presto().trim().equals("D") && folio.getCveAfectaPresup() == 0) {
                if (presolicitudVO.getCoberturaGlobVO().getEntidad().getCveEntidad() != folio.getCveEntidad() || presolicitudVO.getCoberturaGlobVO().getDelegacion().getCveDeleg() != folio.getCveDeleg()
                        || presolicitudVO.getCoberturaGlobVO().getUnidad().getCveUniad() != folio.getCveUniad()) {
                    valFol = false;
                }
            }
            if (folio.getNumRamoAnt() > 0) {
                if (folio.getNumRamoAnt() != presolicitudVO.getCramPagVO().getRamoCat()) {
                    int counDistFolRam = folioDao.countFolioRamo(folio.getNumRamoAnt(), presolicitudVO.getCramPagVO().getRamoCat());
                    if (counDistFolRam == 0) {
                        valFol = false;
                    }

                }
            }
            if (folio.getTnoCve() > 0) {
                if (folio.getTnoCve() != nombramiento) {
                    valFol = false;
                }
            }
            //Parte del codigo que no creo que vaya 
            if (folio.getTpo_presto().trim().equals("I") && (folio.getCveAfectaPresup() == 9 || folio.getCveAfectaPresup() == 1)) {
                List foliosPresuI = folioDao.obtenerFolioSolicitud(folio);
                if (foliosPresuI == null && foliosPresuI.isEmpty()) {
                    valFol = false;
                }
            }
        } /*else {
        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.FOLIO_INEXISTENTE);
        }*/
        return valFol;
    }

    public void validacionClaveFolio(FolioVO folioClave) {
        String claveM = folioClave.getClave().trim();
        byte[] arreglo = claveM.getBytes();
        String cadEncrip = "";
        try {
            cadEncrip = MD5.getInstance().hashData(arreglo);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ValidacionFolioWebSI.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<FolioClaveVO> folioClaves = folioDao.obtenerClaveFolio(folioClave);
        if (folioClaves != null && folioClaves.size() > 0) {
            FolioClaveVO folioClaveAux = folioClaves.get(0);
            if (cadEncrip.trim().toUpperCase().compareTo(folioClaveAux.getClave().trim().toUpperCase()) != 0) {
                throw sQLErrorCodesFactory.createException(OtwExceptionCodes.CLAVE_FOLIO_NO_COINCIDE);
            }
        } else {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.CLAVE_FOLIO_NO_COINCIDE);
        }

    }
}
