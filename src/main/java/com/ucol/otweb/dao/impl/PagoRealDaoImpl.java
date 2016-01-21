/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IPagoRealDao;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.PagoRealVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Component
@Repository(value = "pagoRealDao")
public class PagoRealDaoImpl extends GenericDao implements IPagoRealDao {
    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */

    private static final String BSALDO_REAL_X_PRESTAMO = "SELECT dt_saldo_real FROM pago_real WHERE loan_nbr = ?";

    public PagoRealDaoImpl() {
    }

    /*
     * Se obtiene el dt_saldo_real por el numero de préstamo
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PagoRealVO> obtenerDTSaldoRealPorPrestamo(Double numPrestamo) {
        List<Serializable> saldoPorPagos = null;
        saldoPorPagos = super.getJdbcTemplate().query(BSALDO_REAL_X_PRESTAMO, new Object[]{numPrestamo}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PagoRealVO pagoRealVO = new PagoRealVO();
                pagoRealVO.setDtSaldoReal(rs.getString(1));
                return pagoRealVO;
            }
        });
        return (List<PagoRealVO>) (List) saldoPorPagos;
    }
}
