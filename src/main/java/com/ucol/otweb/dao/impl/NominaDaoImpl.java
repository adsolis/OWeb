/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.INominaDao;
import com.ucol.otweb.vo.PagoNomVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "nominaDao")
public class NominaDaoImpl extends GenericDao implements INominaDao {

    private static final String UPAGO_NOMINA = "SELECT  DISTINCT tno_cve_sic,descripcion_sic FROM c_tno_cve WHERE  c_tno_cve.tno_cve_sic = ?";
    private static final String IPAGO_NOMINA = "INSERT INTO pago_nom(loan_nbr, qna_inicio, ramo, pagad, qna_final, importe_pago, tpo_pago, oper_id_mant, dt_last_mant, hora_aud, componente_cve, ip_equipo) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /**
     *
     * @param cveTipoNombramiento
     * @return
     */
    @Override
//    public int update(PagoNomVO pagoNomVO){
//       return super.getJdbcTemplate().update(UPAGO_NOMINA, args); 
//    }
    public void insert(PagoNomVO pagoNomVO) {
        //loan_nbr, qna_inicio, ramo, pagad, qna_final, importe_pago, tpo_pago, oper_id_mant, dt_last_mant, 
        //hora_aud, componente_cve, ip_equipo
        Object args[]= new Object[12];
        args[0] = pagoNomVO.getLoanNbr();
        args[1] = pagoNomVO.getQnaInicio();
        args[2] = pagoNomVO.getRamo();
        args[3] = pagoNomVO.getPagad();
        args[4] = pagoNomVO.getQnaFinal();
        args[5] = pagoNomVO.getImportePago();
        args[6] = pagoNomVO.getTpoPago();
        args[7] = pagoNomVO.getOperIdMant();
        args[8] = pagoNomVO.getDtLastMant();
        args[9] = pagoNomVO.getHoraAud();
        args[10] = pagoNomVO.getComponente_cve();
        args[11] = pagoNomVO.getIpEquipo();
//        args[12]=;
        super.getJdbcTemplate().update(IPAGO_NOMINA, args); 
    }
}
