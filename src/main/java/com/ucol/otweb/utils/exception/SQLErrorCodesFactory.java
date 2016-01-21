/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.utils.exception;

import com.ucol.otweb.vo.CRechazoWebVO;
import java.text.MessageFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.ucol.otweb.dao.IMensajeErrorDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "sQLErrorCodesFactory")
public class SQLErrorCodesFactory {

    private static final Log log = LogFactory.getLog(SQLErrorCodesFactory.class);
    @Autowired
    @Qualifier("mensajeErrorDao")
    private IMensajeErrorDao mensajeErrorDao;
    
    private SQLErrorCodesFactory() {
	}

    /**
     * @param mensajeErrorDao the mensajeErrorDao to set
     */
    public void setMensajeErrorDao(IMensajeErrorDao mensajeErrorDao) {
        this.mensajeErrorDao = mensajeErrorDao;
    }

    /**
     * @param iMsgErr the iMsgErr to set
     */
  
  
    /**
	 * Singleton, Clase de ayuda para contener la instancia
	 * 
	 */
	private static class FactoryHolder {
		private static final SQLErrorCodesFactory INSTANCE = new SQLErrorCodesFactory();
	}

	/**
	 * Singleton, Unica forma de obtener la instancia
	 * 
	 * @return ExceptionFactory instancia
	 */
	public static SQLErrorCodesFactory getInstance() {
		return FactoryHolder.INSTANCE;
	}

	/**
	 * Factory, obtiene una OtwException construida con mensaje traducido
	 * 
	 * @param codigoError
	 *            codigo de error a buscar en BD
	 * @return OtwException con mensaje traducido
	 */
	public OtwException createException(int codigoError) throws OtwException {
		return createException(codigoError, null, null);
	}
	
	/**
	 * Factory, obtiene una OtwException construida con mensaje traducido
	 * 
	 * @param codigoError
	 *            codigo de error a buscar en BD
	 * @param parametros
	 *            parametros que seran remplazados en el texto de la excepcion
	 * @return OtwException con mensaje traducido
	 */
	public OtwException createException(int codigoError, Object[] parametros) throws OtwException {
		return createException(codigoError, null, parametros);
	}

	/**
	 * Factory, obtiene una OtwException construida con mensaje traducido y especificando una
	 * excepcion causante del error
	 * 
	 * @param codigoError
	 *            codigo de error a buscar en BD
	 * @param cause
	 *            Excepcion que origino el error
	 * @return OtwException con mensaje traducido
	 */
	public OtwException createException(int codigoError, Throwable cause) throws OtwException {
		return createException(codigoError, cause, null);
	}
	
	/**
	 * Factory, obtiene una OtwException construida con mensaje traducido con parametros, especificando una
	 * excepcion causante del error
	 * @param codigoError codigo de error a buscar en BD
	 * @param cause Excepcion que origino el error
	 * @param parametros parametros que seran remplazados en el texto de la excepcion
	 * @return OtwException con mensaje traducido
	 * @throws OtwException
	 */
	public OtwException createException(int codigoError, Throwable cause, Object[] parametros) throws OtwException {
		if (codigoError <= 0) {
			throw new OtwException(OtwExceptionCodes.CODIGO_ERROR_NO_VALIDO, "El codigo de error es incorrecto", cause);
		}

		String m = convertMessage(codigoError, parametros);

		return new OtwException(codigoError, m, cause);
	}

	/**
	 * Convierte el codigo de error en un mensaje de la BD, utilizando parametros si están
	 * disponibles
	 * 
	 * @param codigoError
	 *            codigo de error a buscar en BD
	 * @param parametros
	 *            parametros que seran remplazados en el texto de la excepcion
	 * @return String de acuerdo a lo especificado por java.text.MessageFormat
	 */
	private String convertMessage(int codigoError, Object[] parametros) {
		String m="";
                
		CRechazoWebVO msg = this.mensajeErrorDao.obtenerMensaje(codigoError);
		
                if (msg != null && msg.getDescRechazo() != null) {
			if (parametros != null && parametros.length > 0) {
				m = MessageFormat.format(msg.getDescRechazo(), parametros);
			} else {
				m = msg.getDescRechazo();
			}
			if (m == null) {
				log.warn("No se ha definido en la BD el mensaje para el codigo de error " + codigoError);
				m = String.valueOf(codigoError);
			}
		} else {
			log.warn("No se ha definido en la BD el codigo de error " + codigoError);
			m = String.valueOf(codigoError);
		}
		return m;
	}
}
