/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.controller;

import com.ucol.otweb.service.IProcesosOtorgamientoService;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.vo.ReporteVO;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author 
 */
@Controller
public class ReportController extends MultiActionController {

    public ReportController() {
    }
    @Autowired
    @Qualifier("procesosOtorgamientoService")
    private IProcesosOtorgamientoService procesosOtorgamientoService;
    @Autowired
    @Qualifier("sQLErrorCodesFactory")
    private SQLErrorCodesFactory sQLErrorCodesFactory;
    protected URL headerURL = null;

    public ModelAndView handleArmaPDF(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String reporte = "PlanFinanciamiento";
        String descargar = request.getParameter("descargar");
        Map model = new HashMap();
        ReporteVO reporteVO = new ReporteVO();
        if (descargar != null && descargar.equals("save")) {
            reporte = "PlanFinanciamientoDescargar";
        }

        reporteVO.setAPATERNO(request.getParameter("apPaterno"));
        reporteVO.setAMATERNO(request.getParameter("apMaterno"));
        reporteVO.setNOMBRE(request.getParameter("nombre"));
        reporteVO.setRFC(request.getParameter("rfc"));
        reporteVO.setCURP(request.getParameter("curp"));
        reporteVO.setNUM_ISSSTE(new Integer(request.getParameter("numIssste")));
        reporteVO.setCRAM0(new Integer(request.getParameter("cveCat")));
        reporteVO.setNRAMO(request.getParameter("descRamo"));
        reporteVO.setSUELDO_BASICO(new Double(request.getParameter("sueldoMensual")));
        reporteVO.setCPAGADURIA(request.getParameter("cvePag"));
        reporteVO.setNPAGADURIA(request.getParameter("descPag"));
        reporteVO.setDFOVISSSTE(new Double(request.getParameter("dsctoFovissste")));
        reporteVO.setNUM_PRESTAMO(new Double(request.getParameter("numeroPrestamo")));
        reporteVO.setFECHA_PRESTAMO(new Date());
        reporteVO.setIMPORTE_PRESTAMO(new Double(request.getParameter("montoSol")));
        reporteVO.setIMPORTE_PRES_LETRA(request.getParameter("descMontoSol"));
        reporteVO.setSALDO_ANTERIOR(new Double(request.getParameter("saldoAnt")));
        reporteVO.setPRIMA_GARANTIA(new Double(request.getParameter("primaGarantia")));
        reporteVO.setPRIMA_RENOVACION(new Double(request.getParameter("primaRenovacion")));
        reporteVO.setIMPORTE_CHEQUE_NUM(new Double(request.getParameter("impCheque")));
        reporteVO.setIMP_CHEQ_LETRA(request.getParameter("descImporteCheque"));
        reporteVO.setDESC_AMORTIZACION(new Double(request.getParameter("desctoAmt")));
        reporteVO.setTASA_INTERES(new Double(request.getParameter("tasaInt")));
        reporteVO.setPLAZO(new Integer(request.getParameter("plazoAmort")));
        reporteVO.setINICIO_DESC(new Integer(request.getParameter("iniDesc")));
        reporteVO.setFIN_DESC(new Integer(request.getParameter("finDesc")));
        reporteVO.setCALLE(request.getParameter("calle"));
        reporteVO.setCOLONIA(request.getParameter("colonia"));
        reporteVO.setCP(request.getParameter("codigo"));
        reporteVO.setCIUDAD(request.getParameter("ciudad"));
        reporteVO.setESTADO(request.getParameter("entidad"));
        reporteVO.setCAJA(Integer.parseInt(request.getParameter("caja")));
        reporteVO.setAFEC_PRES(Integer.parseInt(request.getParameter("cveAfect")));
        reporteVO.setNUMERO_FOLIO(Integer.parseInt(request.getParameter("folioSol")));
        reporteVO.setTP_PRESTAMO(request.getParameter("tipoPrest"));



        return new ModelAndView(reporte, getModel(reporteVO, false));
    }

    public ModelAndView handleArmaPDFSimulacion(HttpServletRequest request,
            HttpServletResponse response) throws Exception {


        String reporte = "SimulacionCredito";
        Map model = new HashMap();
        ReporteVO reporteVO = new ReporteVO();
        String descargar = request.getParameter("descargar");
        if (descargar != null && descargar.equals("save")) {
            reporte = "SimulacionCreditoDescargar";
        }
        reporteVO.setAPATERNO(request.getParameter("apPaterno"));
        reporteVO.setAMATERNO(request.getParameter("apMaterno"));
        reporteVO.setNOMBRE(request.getParameter("nombre"));
        reporteVO.setRFC(request.getParameter("rfc"));
        reporteVO.setANTIGUEDAD_ANIO(request.getParameter("anio"));
        reporteVO.setANTIGUEDAD_MES(request.getParameter("mes"));
        reporteVO.setANTIGUEDAD_DIAS(request.getParameter("dias"));
        reporteVO.setNUM_ISSSTE(new Integer(request.getParameter("numIssste")));
        reporteVO.setCRAM0(new Integer(request.getParameter("cveCat")));
        reporteVO.setNRAMO(request.getParameter("descRamo"));
        reporteVO.setSUELDO_BASICO(new Double(request.getParameter("sueldoMensual" )));
        reporteVO.setCPAGADURIA(request.getParameter("cvePag" ));
        reporteVO.setNPAGADURIA(request.getParameter("descPag" ));
        reporteVO.setDFOVISSSTE(new Double(request.getParameter("dsctoFovissste" )));
        reporteVO.setIMPORTE_PRESTAMO(new Double(request.getParameter("montoSol" )));
        reporteVO.setIMPORTE_PRES_LETRA(request.getParameter("descMontoSol" ));
        reporteVO.setSALDO_ANTERIOR(new Double(request.getParameter("saldoAnt" )));
        reporteVO.setPRIMA_GARANTIA(new Double(request.getParameter("primaGarantia" )));
        reporteVO.setPRIMA_RENOVACION(new Double(request.getParameter("primaRenovacion" )));
        reporteVO.setIMPORTE_CHEQUE_NUM(new Double(request.getParameter("impCheque" )));
        reporteVO.setIMP_CHEQ_LETRA(request.getParameter("descImporteCheque" ));
        reporteVO.setDESC_AMORTIZACION(new Double(request.getParameter("desctoAmt")));
        reporteVO.setTASA_INTERES(new Double(request.getParameter("tasaInt" )));
        reporteVO.setPLAZO(new Integer(request.getParameter("plazoAmort" )));
        reporteVO.setINICIO_DESC(new Integer(request.getParameter("iniDesc" )));
        reporteVO.setFIN_DESC(new Integer(request.getParameter("finDesc" )));
        reporteVO.setDESC_DTO_AMTO(request.getParameter("descDtoAmt"));
        reporteVO.setTP_PRESTAMO(request.getParameter("tipoPrest"));
        return new ModelAndView(reporte, getModel(reporteVO, true));
    }

    public ModelAndView handleArmaPDFPrestamosAutos(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String reporte = "PlanFinanciamientoAutos";
        String descargar = request.getParameter("descargar");
        Map model = new HashMap();
        ReporteVO reporteVO = new ReporteVO();
        if (descargar != null && descargar.equals("save")) {
            reporte = "PlanFinanciamientoAutosDescargar";
        }

        reporteVO.setAPATERNO(request.getParameter("apPaterno"));
        reporteVO.setAMATERNO(request.getParameter("apMaterno"));
        reporteVO.setNOMBRE(request.getParameter("nombre"));
        reporteVO.setRFC(request.getParameter("rfc"));
        reporteVO.setCURP(request.getParameter("curp"));
        reporteVO.setNUM_ISSSTE(new Integer(request.getParameter("numIssste")));
        reporteVO.setCRAM0(new Integer(request.getParameter("cveCat")));
        reporteVO.setNRAMO(request.getParameter("descRamo"));
        reporteVO.setSUELDO_BASICO(new Double(request.getParameter("sueldoMensual")));
        reporteVO.setCPAGADURIA(request.getParameter("cvePag"));
        reporteVO.setNPAGADURIA(request.getParameter("descPag"));
        reporteVO.setDFOVISSSTE(new Double(request.getParameter("dsctoFovissste")));
        reporteVO.setNUM_PRESTAMO(new Double(request.getParameter("numeroPrestamo")));
        reporteVO.setFECHA_PRESTAMO(new Date());
        reporteVO.setIMPORTE_PRESTAMO(new Double(request.getParameter("montoSol")));
        reporteVO.setIMPORTE_PRES_LETRA(request.getParameter("descMontoSol"));
        reporteVO.setSALDO_ANTERIOR(new Double(request.getParameter("saldoAnt")));
        reporteVO.setPRIMA_GARANTIA(new Double(request.getParameter("primaGarantia")));
        reporteVO.setPRIMA_RENOVACION(new Double(request.getParameter("primaRenovacion")));
        reporteVO.setIMPORTE_CHEQUE_NUM(new Double(request.getParameter("impCheque")));
        reporteVO.setIMP_CHEQ_LETRA(request.getParameter("descImporteCheque"));
        reporteVO.setDESC_AMORTIZACION(new Double(request.getParameter("desctoAmt")));
        reporteVO.setTASA_INTERES(new Double(request.getParameter("tasaInt")));
        reporteVO.setPLAZO(new Integer(request.getParameter("plazoAmort")));
        reporteVO.setINICIO_DESC(new Integer(request.getParameter("iniDesc")));
        reporteVO.setFIN_DESC(new Integer(request.getParameter("finDesc")));
        reporteVO.setCALLE(request.getParameter("calle"));
        reporteVO.setCOLONIA(request.getParameter("colonia"));
        reporteVO.setCP(request.getParameter("codigo"));
        reporteVO.setCIUDAD(request.getParameter("ciudad"));
        reporteVO.setESTADO(request.getParameter("entidad"));
        reporteVO.setCAJA(Integer.parseInt(request.getParameter("caja")));
        reporteVO.setAFEC_PRES(Integer.parseInt(request.getParameter("cveAfect")));
        reporteVO.setNUMERO_FOLIO(Integer.parseInt(request.getParameter("folioSol")));
        reporteVO.setTP_PRESTAMO(request.getParameter("tipoPrest"));
        return new ModelAndView(reporte, getModel(reporteVO, false));
    
    }
    public ModelAndView handleArmaPDFPrestamosAnt(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String reporte = "PrestamoAnterior";
        Map model = new HashMap();
        ReporteVO reporteVO = new ReporteVO();
        String issste = request.getParameter("num_issste");
        Double numIssste = null;
        if (issste != null) {
            numIssste = new Double(issste);
        } else {
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.SIN_SERVICIO);
        }
        reporteVO = this.procesosOtorgamientoService.getPrestamosAnterior(numIssste);
        return new ModelAndView(reporte, getModel(reporteVO, false));
    }

    private Map getModel(ReporteVO reporteVO, boolean isSimulado) {

        Map model = new HashMap();

        PropertyUtils prop = new PropertyUtils("config.properties");
        prop.cargaArchivo();

        /*reporteVO.setTP_PRESTAMO("EXTRAORDINARIO PARA DAMNIFICADOS");
        reporteVO.setNUMERO_FOLIO(7068928);
        reporteVO.setAFEC_PRES(0);
        reporteVO.setCAJA(20);
        reporteVO.setAPATERNO("MARTINEZ");
        reporteVO.setAMATERNO("JUAN");
        reporteVO.setNOMBRE("MARTHA");
        reporteVO.setCURP("MAJM670926MOCRNR03");
        reporteVO.setRFC("MAJM670926");
        reporteVO.setNUM_ISSSTE(2730195);
        reporteVO.setNUM_PRESTAMO(20110437818.0);
        reporteVO.setIMPORTE_PRESTAMO(56119.67);
        reporteVO.setCRAM0(20);
        reporteVO.setNRAMO("INST. DE SEG. Y SERVS. SOCLS. DE LOS TRABJS. DEL E");
        reporteVO.setSUELDO_BASICO(8116.30);
        reporteVO.setCPAGADURIA("20000");
        reporteVO.setNPAGADURIA("ISSSTE. DELEG. OAXACA");
        reporteVO.setDFOVISSSTE(0.00);
        reporteVO.setIMPORTE_PRES_LETRA("CINCUENTA Y SEIS MIL CIENTO DIECINUEVE PESOS 37/100 M.N.");
        reporteVO.setSALDO_ANTERIOR(24996.98);
        reporteVO.setPRIMA_GARANTIA(562.21);
        reporteVO.setPRIMA_RENOVACION(562.21);
        reporteVO.setIMPORTE_CHEQUE_NUM(30000.01);
        reporteVO.setDESC_AMORTIZACION(889.95);
        reporteVO.setTASA_INTERES(9.0);
        reporteVO.setPLAZO(36);
        reporteVO.setINICIO_DESC(201419);
        reporteVO.setFIN_DESC(201420);
        reporteVO.setFECHA_PRESTAMO(new Date());
        reporteVO.setIMP_CHEQ_LETRA("TREINTA MIL PESOS 01/100 M.N.");
        reporteVO.setCALLE("GARDENIAS 613 2°PISO ESQUINA HEROICO ESCUELA NAVAL MILITAR");
        reporteVO.setCOLONIA("REFORMA");
        reporteVO.setCIUDAD("OAXACA");
        reporteVO.setNUMERO(20);
        reporteVO.setCP("06510");
        reporteVO.setESTADO("OAXACA");*/

        model.put("dataSource", getData());
        model.put("TP_PRESTAMO", reporteVO.getTP_PRESTAMO());
        model.put("NUMERO_FOLIO", reporteVO.getNUMERO_FOLIO());
        model.put("AFEC_PRES", reporteVO.getAFEC_PRES());
        model.put("CAJA", reporteVO.getCAJA());
        model.put("APATERNO", reporteVO.getAPATERNO());
        model.put("AMARTENO", reporteVO.getAMATERNO());
        model.put("NOMBRE", reporteVO.getNOMBRE());
        model.put("CURP", reporteVO.getCURP());
        model.put("RFC", reporteVO.getRFC());
        model.put("NUM_ISSSTE", reporteVO.getNUM_ISSSTE());
        model.put("NUM_PRESTAMO", reporteVO.getNUM_PRESTAMO());
        model.put("IMPORTE_PRESTAMO", reporteVO.getIMPORTE_PRESTAMO());
        model.put("CRAMO", reporteVO.getCRAM0());
        model.put("NRAMO", reporteVO.getNRAMO());
        model.put("SUELDO_BASICO", reporteVO.getSUELDO_BASICO());
        model.put("NPAGADURIA", reporteVO.getNPAGADURIA());
        model.put("CPAGADURIA", reporteVO.getCPAGADURIA());
        model.put("DFOVISSSTE", reporteVO.getDFOVISSSTE());
        model.put("IMPORTE_PRES_LETRA", reporteVO.getIMPORTE_PRES_LETRA());
        model.put("SALDO_ANTERIOR", reporteVO.getSALDO_ANTERIOR());
        model.put("PRIMA_GARANTIA", reporteVO.getPRIMA_GARANTIA());
        model.put("PRIMA_RENOVACION", reporteVO.getPRIMA_RENOVACION());
        model.put("IMPORTE_CHEQUE_NUM", reporteVO.getIMPORTE_CHEQUE_NUM());
        model.put("DESC_AMORTIZACION", reporteVO.getDESC_AMORTIZACION());
        model.put("TASA_INTERESES", reporteVO.getTASA_INTERES());
        model.put("PLAZO", reporteVO.getPLAZO());
        model.put("INICIO_DESC", reporteVO.getINICIO_DESC());
        model.put("FIN_DESC", reporteVO.getFIN_DESC());
        model.put("FECHA_PRESTAMO", reporteVO.getFECHA_PRESTAMO());
        model.put("IMP_CHEQUE_LETRA", reporteVO.getIMP_CHEQ_LETRA());
        model.put("CALLE", reporteVO.getCALLE());
        model.put("COLONIA", reporteVO.getCOLONIA());
        model.put("CIUDAD", reporteVO.getCIUDAD());
        model.put("NUMERO", reporteVO.getNUMERO());
        model.put("CP", reporteVO.getCP());
        model.put("ESTADO", reporteVO.getESTADO());
        model.put(JRParameter.REPORT_LOCALE, new Locale("ES", "MX"));
        try {
            if (isSimulado) {
                model.put("HEADER_IMAGE_1", headerURL = new URL(prop.getParametro("reports.PathimgISSSTE")));
                model.put("ANTIGUEDAD_ANIO", reporteVO.getANTIGUEDAD_ANIO());
                model.put("ANTIGUEDAD_MES", reporteVO.getANTIGUEDAD_MES());
                model.put("ANTIGUEDAD_DIAS", reporteVO.getANTIGUEDAD_DIAS());
                model.put("DESC_DTO_AMTO",reporteVO.getDESC_DTO_AMTO());

            }else{
                model.put("HEADER_IMAGE_1", headerURL = new URL(prop.getParametro("reports.PathimgIzq")));
                headerURL = null;
                model.put("HEADER_IMAGE_4", headerURL = new URL(prop.getParametro("reports.PathimgEnc")));
            }
            headerURL = null;
            model.put("HEADER_IMAGE_2", headerURL = new URL(prop.getParametro("reports.PathimgLogIzq")));
            headerURL = null;
            model.put("HEADER_IMAGE_3", headerURL = new URL(prop.getParametro("reports.PathimgLogDer")));




        } catch (MalformedURLException e) {
            System.out.println("== e" + e.getMessage());
        }
        return model;
    }

    private List getData() {
        List list = new ArrayList();
        ReporteVO sol = new ReporteVO();
        for (int x = 0; x < 10; x++) {
            sol = new ReporteVO();
            sol.setCAJA(9);
            sol.setCPAGADURIA("20000");

            list.add(sol);
        }

        return list;
    }
}