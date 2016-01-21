/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.ISalarioDao;
import com.ucol.otweb.dao.jdbc.CSalarioVORowMapper;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.CSalarioVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Component
@Repository(value = "salarioDao")
public class SalarioDaoImpl extends GenericDao implements ISalarioDao {
    
    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BSALARIO_MIN = "select salario_min from c_salario WHERE fecha_salario = (SELECT MAX(fecha_salario) FROM c_salario)";
    private static final String BSALARIO_MIN_DIARIO = "SELECT sal_min_diario  FROM c_salario WHERE fecha_salario IN (SELECT MAX(fecha_salario) FROM c_salario)";
    
    public SalarioDaoImpl() {
    }

    /**
     * Se obtiene el salario minimo 
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public CSalarioVO obtenerSalarioMin() {
        List<CSalarioVO> salariosMinimos = null;
        CSalarioVO salarioMin = null;

        salariosMinimos = super.getJdbcTemplate().query(BSALARIO_MIN, new CSalarioVORowMapper() {
            public CSalarioVO mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                CSalarioVO cSalarioVO = new CSalarioVO();
                cSalarioVO.setSalarioMin(rs.getDouble(1));
                return cSalarioVO;
            }
        });

        if (salariosMinimos != null && salariosMinimos.size() > 0) {
            salarioMin = salariosMinimos.get(0);
        }

        return salarioMin;
    }
    
    /**
     * Se obtiene el salario minimo diario
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public CSalarioVO obtenerSalarioMinDiario() {
        List<Serializable> salariosMinimosdiarios = null;
        CSalarioVO salarioMin = null;

        salariosMinimosdiarios= super.getJdbcTemplate().query(BSALARIO_MIN_DIARIO, new SerializableRowMapper() {
        public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                 CSalarioVO cSalarioVO = new CSalarioVO();
                cSalarioVO.setSalMinDiario(rs.getDouble(1));
                return cSalarioVO;
            }
        });
        List<CSalarioVO> salariosMinDiario = (List<CSalarioVO>)(List)salariosMinimosdiarios;
        if (salariosMinDiario != null && salariosMinDiario.size() > 0) {
            salarioMin = salariosMinDiario.get(0);
        }

        return salarioMin;
    }
}
