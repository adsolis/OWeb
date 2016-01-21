/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.cws;

import com.ucol.otweb.dao.IDatosLaborales;
import com.ucol.otweb.vo.DatosLaboralesVO;
import com.ucol.otweb.vo.DirectoVO;
import java.rmi.RemoteException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.tempuri.ArrayOfRespuesta;
import org.tempuri.Respuesta;

/**
 *
 * @author Uriel
 */

@Component
@Service(value = "iWebService")
public class WebServiceImpl implements IWebService {
    
    @Autowired
    @Qualifier("datosLaborales")
    private IDatosLaborales datosLaborales;    
    
/*   @Autowired
    @Qualifier("webServiceOtorgamiento")
    private IWebService iWebService;    */
    
    public ArrayOfRespuesta getDatosPorCURP(java.lang.String curp) {
        org.tempuri.Tabla49Campos service = new org.tempuri.Tabla49Campos();
        org.tempuri.Tabla49CamposSoap port = service.getTabla49CamposSoap();
        return port.getDatosPorCURP(curp);
    }   
    
    public ArrayOfRespuesta getDatosPorRFC(java.lang.String rfc) {
        org.tempuri.Tabla49Campos service = new org.tempuri.Tabla49Campos();
        org.tempuri.Tabla49CamposSoap port = service.getTabla49CamposSoap();
        return port.getDatosPorRFC(rfc);
    }    

    public WebServiceImpl() {

    }
    
    public double getUltPgoReal (int issste) 
    {

        double ultPagoReal    = 0;
        double entraCondicion = 0;
        try
        {

             DatosLaboralesVO laboralesVO= new DatosLaboralesVO();
             laboralesVO.setNumIssste(issste);
             List<DirectoVO> myList = datosLaborales.busquedaDerechohabienteDirecto(laboralesVO);

             DirectoVO directoVO = myList.get(0);
             String    myRfc     = directoVO.getRfc();
             String    myCurp    = directoVO.getCurp();

             ArrayOfRespuesta nombres = getDatosPorCURP(myCurp);

             List<Respuesta> hg = nombres.getRespuesta();       

             for(int x=0;x<hg.size();x++)
             {

                 Respuesta ob = hg.get(x);
                 String nombre = ob.getNombre();
                 String rfc = ob.getRfc();
                 String curp = ob.getCurp();
                 String ultPagoRealStr = ob.getMontoUltPgoReal();
                 
                 if(!myRfc.trim().equals(rfc.trim()))continue;

                 if((ultPagoRealStr != null)&&(!ultPagoRealStr.equals("")))
                 {
                     ultPagoReal = Double.parseDouble(ultPagoRealStr);
                     entraCondicion = 1;
                     break;
                 }  
             }
         
        }
        catch(Exception d)
        {
            System.out.println("ERROR EN MÉTODO DE WEB SERVICE ");
            //d.printStackTrace();
        }
            
        //Si no encontro registro de último pago
        if(ultPagoReal==0&&entraCondicion==0)ultPagoReal = -1;
         
         return ultPagoReal;

    }

    /*
    public IDatosLaborales getDatosLaborales() {
        return datosLaborales;
    }


    public void setDatosLaborales(IDatosLaborales datosLaborales) {
        this.datosLaborales = datosLaborales;
    }
*/
}
