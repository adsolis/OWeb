/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.ICalPensDao;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.vo.CCalPensVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "calPensDao")
public class CalPensDaoImpl extends GenericDao implements ICalPensDao {

    private static final String BQUINCENAS_CAL = "SELECT qnas_a_diferir, ssaa_ord_dscto, fecha_fin_otorga FROM c_cal_pens WHERE to_date(?,'%d/%m/%Y') BETWEEN fecha_ini_otorga AND fecha_fin_otorga ";
    
    /**
     * 
     * @param fecha
     * @return
     */
    @Override
    public List<CCalPensVO> obtenerQuincenasOtorgamiento(Date fecha) {
        List<CCalPensVO> listCal = null;
        listCal = (List) super.getJdbcTemplate().query(BQUINCENAS_CAL, new Object[]{DateUtils.formatFechaToString(fecha)},
                new SerializableRowMapper() {
                    
                    public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                        CCalPensVO cCalPensVO = new CCalPensVO();
                        cCalPensVO.setQnasADiferir(rs.getInt(1));
                        cCalPensVO.setSsaaOrdDscto(rs.getString(2));
                        cCalPensVO.setFechaFinOtorga(rs.getDate(3));
                        return cCalPensVO;
                    }
                });
        return listCal;        
    }
}
