/* *
 * Requerimientos cubiertos: 
 * Descripci�n: 
 * Autor: osanchez
 * Fecha de creaci�n: Feb 3, 2010
 * Correcci�n 1: 
 * Fecha de correcci�n 1: 
 * Correcci�n 2: 
 * Fecha de correcci�n 2: 
 * Correcci�n N: 
 * Fecha de correcci�n N: 
 */
package com.ucol.otweb.utils.exception;

/**
 * Excepcion de negocio para el proyecto<br>
 * No puede crearse una instancia directamente, para obtenerla se debe pedir a
 * <code>ExceptionFactory</code>
 * 
 * @author osanchez
 */
public class OtwException extends RuntimeException {
	private static final long serialVersionUID = -7420168809436879328L;

	/**
	 * Codigo de error
	 */
	private int codigo;

	/**
	 * Privado para asegurar que los mensajes se obtengan de la BD solo a partir de
	 * <code>ExceptionFactory</code>
	 */
	@SuppressWarnings("unused")
	private OtwException() {
	}

	/**
	 * Cosntructor utilizado por ExceptionFactory para inicializar campos
	 * 
	 * @param codigoError
	 *            Codigo de error asociado
	 * @param mensaje
	 *            Descripcion del error
	 */
	protected OtwException(int codigoError, String mensaje) {
		this(codigoError, mensaje, null);
	}

	/**
	 * Cosntructor utilizado por ExceptionFactory para inicializar campos, especificando una
	 * excepcion causa
	 * 
	 * @param codigoError
	 *            Codigo de error asociado
	 * @param mensaje
	 *            Descripcion del error
	 * @param cause
	 *            Excepcion que origino el error
	 */
	protected OtwException(int codigoError, String mensaje, Throwable cause) {
		super(mensaje, cause);
		this.codigo = codigoError;
	}

	/**
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            codigo a establecer
	 */
	protected void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
