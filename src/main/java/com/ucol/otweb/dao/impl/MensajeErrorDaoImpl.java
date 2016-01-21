package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IMensajeErrorDao;
import com.ucol.otweb.dao.jdbc.CRechazoWebExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.CRechazoWebVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "mensajeErrorDao")
public class MensajeErrorDaoImpl extends GenericDao implements IMensajeErrorDao{
    private static final String BMENSAJE_ERROR="SELECT  cve_motivo, desc_motivo, tipo_motivo, stat_motivo  FROM c_rechazo_web WHERE cve_motivo=? ";
    
    /**
     * Recuperar la informacion de el error desde la BD
     * @param cveMotivo
     * @return
     */
    @Override
    public CRechazoWebVO obtenerMensaje(int cveMotivo){
        CRechazoWebVO rechazo = null;
        rechazo = (CRechazoWebVO) super.getJdbcTemplate().queryForObject(BMENSAJE_ERROR, new Object[]{cveMotivo}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CRechazoWebExtractor extractor = new CRechazoWebExtractor();
                return extractor.extractData(rs);
            }
        });
        return rechazo;
    }
}
