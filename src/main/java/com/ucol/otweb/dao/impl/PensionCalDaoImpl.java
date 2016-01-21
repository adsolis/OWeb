/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IPensionCalDao;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.DeudosVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */

@Component
@Repository(value = "pensionCalDao")
public class PensionCalDaoImpl extends GenericDao implements IPensionCalDao{
    
    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BPENSION_GRUPO_X_NUMISSSTE="SELECT a.num_pen,count(*) FROM pension_cal:deudos a, pension_cal:datospen b WHERE a.num_issste = ? AND a.num_pen = b.num_pen  AND a.vigencia IN (0, 9) GROUP BY a.num_pen ";
    public PensionCalDaoImpl(){
    }
    
    /*
     * Se obtiene el numero de pension y el total de los pensionados relacionados al numIssste
     */
    public List<DeudosVO> obtenerSaldoActualProy(Integer numIssste){
        List<Serializable> saldosActuales=null;
        saldosActuales= super.getJdbcTemplate().query(BPENSION_GRUPO_X_NUMISSSTE,new Object[]{numIssste}, new SerializableRowMapper() {
        public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                DeudosVO deudosVO = new DeudosVO();
                deudosVO.setNumPen(rs.getInt(1));
                deudosVO.setTotal(rs.getInt(2));
                return deudosVO;
            }
        });
        return (List<DeudosVO>)(List)saldosActuales;
    }
}
