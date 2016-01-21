package com.ucol.otweb.dao;

/**
 *
 * @author 
 */
public interface IMinMaxDao {
    public Object getMinimo(String campo,String tabla, String base);
    public Object getMaximo(String campo,String tabla, String base);
}
