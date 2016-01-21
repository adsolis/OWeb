/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service.impl;

import com.ucol.otweb.dao.IAgenciasDao;
import com.ucol.otweb.dao.ICoberturaDao;
import com.ucol.otweb.dao.IDatosLaborales;
import com.ucol.otweb.dao.ITransaccionesMovimientosWebDao;
import com.ucol.otweb.service.IOtorgamientoWEB;
import com.ucol.otweb.service.IProcesosOtorgamientoMService;
import com.ucol.otweb.service.IProcesosOtorgamientoService;
import com.ucol.otweb.service.ISimulacionWEB;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.utils.LetrasUtil;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.utils.exception.OtwException;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.vo.AgenciaAseguradoAutoVO;
import com.ucol.otweb.vo.BplazaVO;
import com.ucol.otweb.vo.CajaPagadoraVO;
import com.ucol.otweb.vo.DatosLaboralesVO;
import com.ucol.otweb.vo.DirectoVO;
import com.ucol.otweb.vo.EntidadVO;
import com.ucol.otweb.vo.FolioVO;
import com.ucol.otweb.vo.PresolicitudVO;
import com.ucol.otweb.vo.PzaPenVO;
import com.ucol.otweb.vo.TransMovOtoWeb;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Component
@Repository(value = "otorgamientoWeb")
public class OtorgamientoWEB implements IOtorgamientoWEB {

    @Autowired
    @Qualifier("datosLaborales")
    private IDatosLaborales datosLaborales;
    @Autowired
    @Qualifier("coberturaDao")
    private ICoberturaDao coberturaDao;
    @Autowired
    @Qualifier("transMovWebDao")
    private ITransaccionesMovimientosWebDao movimientosWebDao;
    @Autowired
    @Qualifier("agenciasDao")
    private IAgenciasDao agenciasDao;
    @Autowired
    @Qualifier("simulacionWeb")
    private ISimulacionWEB simulacionWEB;
    @Autowired
    @Qualifier("procesosOtorgamientoServiceM")
    private IProcesosOtorgamientoMService procesosOtorgamientoMService;
    @Autowired
    @Qualifier("procesosOtorgamientoService")
    private IProcesosOtorgamientoService procesosOtorgamientoService;
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

    public List<BplazaVO> BPlaza(Integer issste) {
        String str = null;
        List<BplazaVO> lstStr = null;
        lstStr = this.datosLaborales.busquedaRamoPagaduriaPlaza(issste);

        return lstStr;
    }

    //@ Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertData(EntidadVO ent) {
//        try {
        this.datosLaborales.insertData(ent);
//        } catch (Exception e) {
//            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DADO_DE_BAJA);
//        }
    }

    /**solo para pruebas, se borrara***/
    @Transactional(rollbackFor = Exception.class)
    public void insertDataRecursivo() {
        EntidadVO vo = null;
        for (int i = 0; i <= 3; i++) {
            vo = new EntidadVO();
            vo.setAbvEntidad("T" + i);
            vo.setComponenteCve("Test OTW");
            vo.setCveEntidad(44 + i);
            vo.setDescEntidad("Test Trans");
            vo.setFechaAud(new java.sql.Date(2014, 11, 12));
            vo.setIpEquipo("no-ip");
            vo.setUsuario("test");
            datosLaborales.insertData(vo);
        }
        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DADO_DE_BAJA);
    }

    public void deleteData(Integer id) {

        this.datosLaborales.deleteData(666);
    }

    public void updateData(EntidadVO ent) {

        ent = new EntidadVO();


        ent.setCveEntidad(33);
        ent.setDescEntidad("-----");
//        ent.setFechaAud((java.sql.Date) new Date());
        ent.setUsuario("----");

        this.datosLaborales.updateData(ent);
    }

    /**
     * 
     * @param caja
     * @return
     */
    public List<CajaPagadoraVO> obtenerCajasPagadoras(int cveEntidad) {
        List<CajaPagadoraVO> listaCajas = null;
        CajaPagadoraVO caja = new CajaPagadoraVO();
        caja.setIdEntidad(cveEntidad);
        listaCajas = this.coberturaDao.buscarCajasPagadorasPorEntidad(caja);
        return listaCajas;
    }

    /**
     * 
     * @param caja
     * @return
     */
    public CajaPagadoraVO obtenerCajasPagadorasAuto(int cveEntidad) {
        CajaPagadoraVO caja = this.coberturaDao.obtenerCajaPorEntidadAutos(cveEntidad);
        return caja;
    }

    /**
     * 
     * @param caja
     * @return
     */
    public List<CajaPagadoraVO> obtenerCajasPAgadorasRamoDF(int ramoDF) {
        List<CajaPagadoraVO> cajasDF = coberturaDao.obtenerCajaRamoDF(ramoDF);
        if (cajasDF == null && cajasDF.isEmpty()) {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DATOS_EMPLEO_NO_REGISTRADO);
        }
        return cajasDF;
    }

    public List<CajaPagadoraVO> obtenerDetalleCajasPagadoras(int cveEntidad) {
        List<CajaPagadoraVO> listaCajas = null;
        CajaPagadoraVO caja = new CajaPagadoraVO();
        caja.setIdEntidad(cveEntidad);
        listaCajas = this.coberturaDao.buscarCajasPagadorasSimulacion(caja);
        return listaCajas;
    }

    public List<AgenciaAseguradoAutoVO> obtenerAgenciasAutos() {
        List<AgenciaAseguradoAutoVO> agencias = null;
        agencias = agenciasDao.buscarAgencias();
        return agencias;
    }

    /**
     * Funcion principal que de acuerdo al flujo del que venga de la aplicación hara calculos simulados u otorgara
     * @param perOtorgW
     * @param folioVO
     * @param simulado
     */
    public PresolicitudVO otorgamientoWeb(PresolicitudVO presolicitudVO, DirectoVO perOtorgW, FolioVO folioVO, boolean simulado, int altaMod, String vehiculo) {
        TransMovOtoWeb movOtoWeb = new TransMovOtoWeb();
        PresolicitudVO presolicitudAux = null;
        movOtoWeb.setNumIssste(perOtorgW.getNumIssste());
        movOtoWeb.setFolio(Integer.parseInt(folioVO.getFolioSolicitud()));
        movOtoWeb = movimientosWebDao.obtenerTransMovWeb(movOtoWeb);
        if ((movOtoWeb.getRamo() == 0 && movOtoWeb.getPagad() == null) || (movOtoWeb.getRamo() == 0 && movOtoWeb.getPagad().equals(""))) {
            movOtoWeb.setStatus(OtwExceptionCodes.PLAZA_NO_ENCONTRO);
            procesosOtorgamientoMService.updateEstatusFechTransMov(movOtoWeb);
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.PLAZA_NO_ENCONTRO);
        }
        //En el documento dice que antes de esta validacion iria el calculo de la antiguedad
        if (folioVO.getCveTcr() == 15) {
            DatosLaboralesVO persPensio = new DatosLaboralesVO();
            persPensio.setNumIssste(perOtorgW.getNumIssste());
            List<PzaPenVO> plazasPens = datosLaborales.buscarPlazaPensionado(persPensio, properties.getParametro("conection.sipesic"), false);
            if (plazasPens != null && plazasPens.size() > 0) {
                PzaPenVO plazaPensionado = plazasPens.get(0);
                if (plazaPensionado.getNumRamo().intValue() != 26 || plazaPensionado.getNumRamo().intValue() != 226 || plazaPensionado.getNumRamo().intValue() != 389) {
                    movOtoWeb.setStatus(OtwExceptionCodes.PRESTAMO_EXCLUSIVO_PARA_PENSIONADO);
                    procesosOtorgamientoMService.updateEstatusFechTransMov(movOtoWeb);
                    throw sQLErrorCodesFactory.createException(OtwExceptionCodes.PRESTAMO_EXCLUSIVO_PARA_PENSIONADO);
                }
            }
        }
        //En el documento dice que antes de esta validacion iria el calculo de la antiguedad
        if (!simulado) {
            presolicitudVO = otorgar(presolicitudVO, movOtoWeb, vehiculo);
            /*if (presolicitudVO.getAltaModFluj() == Constants.TIPO_OPER_MOD_REGRESO) {
            //presolicitudVO = simulacionWEB.simulacionOtorgamiento(movOtoWeb, Constants.TIPO_OPER_MOD, simulado);
            presolicitudVO.setNombreMonto(LetrasUtil.convertirNumeroALetras(presolicitudVO.getPrstamoOrigVO().getOrigLoanPrin()));
            presolicitudVO.setNombreImporte(LetrasUtil.convertirNumeroALetras(presolicitudVO.getPrstamoOrigVO().getImpLiquido()));
            }*/
            if (presolicitudVO.getPrstamoOrigVO().getLoanNbr() != null && presolicitudVO.getPrstamoOrigVO().getLoanNbr() > 0) {
                movOtoWeb.setStatus(Constants.PROCESO_OTO_WEB_SIN_RECHAZO);
                procesosOtorgamientoMService.updateEstatusFechTransMov(movOtoWeb);
            }
            procesosOtorgamientoMService.actAutorizaPrestamo(presolicitudVO.getPrstamoOrigVO().getLoanNbr(), Constants.TIPO_OPER_NUEVO_REGRESO, movOtoWeb.getTipo_prst(), presolicitudVO.getIpMaquina());
        } else {
            presolicitudVO = simulacionWEB.simulacionOtorgamiento(movOtoWeb, Constants.TIPO_OPER_ALTA, simulado, vehiculo);
            //Convetir a letras el monto y el importe
        }
        return presolicitudVO;
    }

    public PresolicitudVO otorgar(PresolicitudVO presolicitudVO, TransMovOtoWeb derechOtor,String vehiculo) {
        CajaPagadoraVO cajaPagadoraVO = new CajaPagadoraVO();
        presolicitudVO.setUsuario(Constants.OPERADOR_WEB);
        presolicitudVO.setComponenteCVE(Constants.OTOWEB);
        presolicitudVO.setAnioSol(DateUtils.anioActual());
        presolicitudVO.setFechaSol(new Date());
        try {

            presolicitudVO = procesosOtorgamientoService.otorgaPrestamo(presolicitudVO, presolicitudVO.getRefinanciamientoVO(), Constants.TIPO_OPER_ALTA, presolicitudVO.getRefinancia(), vehiculo);
            
        } catch (OtwException otwE) {
            System.out.println("Error" + otwE.getCodigo());
            derechOtor.setStatus(otwE.getCodigo());
            procesosOtorgamientoMService.updateEstatusFechTransMov(derechOtor);
            throw sQLErrorCodesFactory.createException(otwE.getCodigo());
        }
        //Informacion para la vista 
        DecimalFormat num = new DecimalFormat("###");
        String numPrest = num.format(presolicitudVO.getPrstamoOrigVO().getLoanNbr());
        String fechaPrestamo = DateUtils.fechaPrestamoString(presolicitudVO.getPrstamoOrigVO().getLoanIssue_date());
        presolicitudVO.getPrstamoOrigVO().setAuxNumPrestamo(numPrest);
        presolicitudVO.getPrstamoOrigVO().setAuxFechaPrestamo(fechaPrestamo.toUpperCase());
        presolicitudVO.setDescMontoSol(LetrasUtil.convertirNumeroALetras(presolicitudVO.getPrstamoOrigVO().getOrigLoanPrin()).toUpperCase());
        presolicitudVO.setDescImporteCheque(LetrasUtil.convertirNumeroALetras(presolicitudVO.getPrstamoOrigVO().getImpLiquido()).toUpperCase());
        presolicitudVO.setDescDtoAmt(LetrasUtil.convertirNumeroALetras(presolicitudVO.getPrstamoOrigVO().getPayAmt()).toUpperCase());

        cajaPagadoraVO.setIdEntidad(derechOtor.getCveEntidad());
        cajaPagadoraVO.setIdDelegacion(derechOtor.getCveDeleg());
        cajaPagadoraVO.setIdUniad(derechOtor.getCveUniad());
        cajaPagadoraVO.setIdOficina(derechOtor.getCveOficina());
        if (derechOtor.getFolio() > 0) {
            List<CajaPagadoraVO> cajaPagadoraVOs = coberturaDao.buscarCajasPagadorasSimulacion(cajaPagadoraVO);
            presolicitudVO.setCajaPagadoraVO(cajaPagadoraVOs.get(0));
        }
        presolicitudVO.setAltaModFluj(Constants.TIPO_OPER_NUEVO_REGRESO);

        return presolicitudVO;
    }
}
