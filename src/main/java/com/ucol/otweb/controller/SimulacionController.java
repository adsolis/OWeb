/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.controller;

import com.ucol.otweb.service.ISimulacionWEB;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.vo.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author ucol
 */
@Controller
public class SimulacionController extends MultiActionController {

    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private ISimulacionWEB iSimulacionWEB;
    @Autowired
    @Qualifier("sQLErrorCodesFactory")
    private SQLErrorCodesFactory sQLErrorCodesFactory;

    public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response)
            throws Exception, ServletException {
        ArrayList prestamos = (ArrayList) this.iSimulacionWEB.obtenerTiposCreditoWEB();

        ModelAndView mav = new ModelAndView("seleccionPrestamo", "command", new DatosLaboralesVO());
        mav.getModel().put("prestamosList", prestamos);
        return mav;
    }

    public ModelAndView validaPrestamoSimulado(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        DatosLaboralesVO datosLaboralesVO=(DatosLaboralesVO)request.getSession().getAttribute("datoslaboralesvo");
        String parametro = request.getParameter("tipoPrestamo");
        Integer tipoPrestamo= null;
        
        String vehiculo = "";
        if(datosLaboralesVO==null){
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DADO_DE_BAJA);
        }
        if(parametro==null){
            throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DADO_DE_BAJA);
        }else{
            if(parametro.equals("22")){
                tipoPrestamo=Constants.TIPO_PREST_AUTOS;
                vehiculo="M";
            }else{
                tipoPrestamo= new Integer(parametro);
            }
            
        }
        DatosLaboralesVO datoslaboralesvo=(DatosLaboralesVO)request.getSession().getAttribute("datoslaboralesvo");
        String ipMaquina = request.getRemoteAddr();
        PresolicitudVO presol=this.iSimulacionWEB.simulacion(datoslaboralesvo.getNumIssste(), null,tipoPrestamo,null,ipMaquina, vehiculo);
        
        ModelAndView mav = new ModelAndView("simulacion", "command", new DatosLaboralesVO());
        mav.getModel().put("presol", presol);
        return mav;

    }
    
    public ModelAndView regresa(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("redirect:/tipootorgamiento.htm");
//        mav.
        return mav;
    }
    /**
     * @param iSimulacionWEB the iSimulacionWEB to set
     */
    public void setiSimulacionWEB(ISimulacionWEB iSimulacionWEB) {
        this.iSimulacionWEB = iSimulacionWEB;
    }

}
