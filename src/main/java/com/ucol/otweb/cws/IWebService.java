/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.cws;

import java.rmi.Remote;

import java.rmi.RemoteException;
import javax.jws.WebService;
import org.tempuri.ArrayOfRespuesta;

/**
 *
 * @author Uriel
 */

@WebService
public interface IWebService extends Remote {
    
    public ArrayOfRespuesta getDatosPorCURP(java.lang.String curp);
    public ArrayOfRespuesta getDatosPorRFC(java.lang.String rfc);
    public double getUltPgoReal (int issste);
    
}
