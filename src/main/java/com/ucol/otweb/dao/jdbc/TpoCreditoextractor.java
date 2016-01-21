/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CatDelegVO;
import com.ucol.otweb.vo.TipoPrestamoVO;
import com.ucol.otweb.vo.TpoCreditoVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class TpoCreditoextractor implements ResultSetExtractor<TpoCreditoVO>{

    public TpoCreditoVO extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        TpoCreditoVO tpoCred = new TpoCreditoVO();

        tpoCred.setCveTcr(resultSet.getInt(1));
        tpoCred.setNomTcr(resultSet.getString(2));
        tpoCred.setOtorgMax(resultSet.getInt(3));
        tpoCred.setMontoMin(resultSet.getDouble(4));
        tpoCred.setPrimaRenov(resultSet.getDouble(5));
        tpoCred.setFactorRango(resultSet.getString(6));
        tpoCred.setFactorAntig(resultSet.getString(7));
        tpoCred.setDescChq1(resultSet.getString(8));
        tpoCred.setDescChq2(resultSet.getString(9));
        tpoCred.setDescChq3(resultSet.getString(10));
        tpoCred.setCodAutor(resultSet.getString(11));
        tpoCred.setCodCan(resultSet.getString(12));
        tpoCred.setStatTcr(resultSet.getString(13));
        return tpoCred;
    }
    
}
