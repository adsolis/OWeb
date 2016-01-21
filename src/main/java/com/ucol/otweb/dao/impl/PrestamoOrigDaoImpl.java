/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IPrestamoOrigDao;
import com.ucol.otweb.dao.jdbc.PrestamoOrigExtractor;
import com.ucol.otweb.dao.jdbc.PrestamoOrigExtractorWeb;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.utils.LetrasUtil;
import com.ucol.otweb.vo.PrstamoOrigVO;
import com.ucol.otweb.vo.ReporteVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
@Repository(value = "prestamoOrigDao")
public class PrestamoOrigDaoImpl extends GenericDao implements IPrestamoOrigDao {
    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */

    private static final String CPRESTAMO_ORGINAL_SELECT = "select count(issste_nbr) from prstamo_orig where issste_nbr = ? and loan_stat_cd = ? ";
    private static final String CPRESTAMO_NO_CANCELADO_SELECT = "SELECT COUNT(*) FROM prstamo_orig WHERE anio_folio = ? AND  nbr_folio  = ? AND loan_type_cd = ? AND loan_stat_cd <> 10 ";
    private static final String CPRESTAMOS_REFINANCIAMIENTO = "SELECT COUNT(*) FROM prstamo_orig WHERE issste_nbr = ? AND loan_stat_cd IN (3,5,8) AND loan_type_cd <> 13";
    private static final String BPRESTAMOS_VIGENTES = "SELECT loan_nbr,loan_issue_date FROM prstamo_orig WHERE issste_nbr = ? AND loan_stat_cd IN (3,5,8 ) AND loan_type_cd in (1,2,3,4,5,6,7,8,11,12,14,15,16,17,18,19,20) ORDER BY loan_issue_date desc ";
    private static final String BNUMPREST_X_NUMISSSTE_SELECT = "SELECT loan_nbr FROM prstamo_orig WHERE issste_nbr = ? AND loan_stat_cd IN (3,5)AND loan_type_cd NOT IN (10,13)";
    private static final String BLOAN_AUTH_CD_X_NUMISSSTE_SELECT = "SELECT loan_auth_cd FROM prstamo_orig WHERE issste_nbr =?  AND loan_stat_cd <> 10 ";
    private static final String CLOAN_AUTH_CD_X_NUMISSSTE_SELECT = "SELECT count(*) FROM prstamo_orig WHERE issste_nbr =?  AND loan_stat_cd <> 10 ";
    private static final String BPRESTORIG_X_NUMISSSTE_SELECT = "SELECT loan_nbr,loan_type_cd,loan_stat_cd,loan_issue_date, orig_loan_prin,orig_nbr_pay,first_pay_per_yr_d,tno_cve "
            + " FROM prstamo_orig WHERE issste_nbr = ? AND loan_stat_cd IN (3,5,8) AND loan_type_cd  <> 13 ORDER BY loan_issue_date ";
    private static final String BNUMPRESTAMO_X_NUMISSSTE_SELECT = "SELECT loan_nbr  FROM prstamo_orig  WHERE loan_stat_cd in (3,5,8) ";
    private static final String BPRESTAMO_GENERADO_USUARIO_PORTAL = "select loan_nbr, loan_stat_cd, loan_type_cd,first_pay_per_yr_d, last_pay_per_yr_du,loan_issue_date, nbr_folio from PRSTAMO_ORIG "
            + " where issste_nbr = ? and (tipo_cuenta=4 or oper_id_online='9999')  and (loan_stat_cd=1 or loan_stat_cd=3 or loan_stat_cd=5) order by loan_nbr desc ";
    private static final String BPRESTAMOS_POR_ESTATUS_TIPO = " SELECT count(loan_nbr) FROM prstamo_orig  WHERE issste_nbr = ? ";
    private static final String UPDATE_AUTORIZACION_PRESTAMO = "Update prstamo_orig Set del_ads= ?, loan_auth_cd=?, hora_aud=?, fecha_aud=?, componente_cve=?, ip_equipo=? Where loan_nbr=? ";
    private static final String INSERT_PROC_TESORE = "Insert Into proc_tesore(loan_nbr, usu_aut, fec_aut) Values(?,?,?) ";
    private static final String IPRSTAMO_ORIG = "INSERT INTO [TABLA](issste_nbr, loan_nbr, anio_folio, loan_type_cd, nbr_folio, loan_issue_date, loan_stat_cd, num_ref_pmp, bad_loan_flg, orig_loan_prin, imp_liquido, orig_loan_int_amt, orig_iva, deferred_int, warranty_prem, renewal_prem, int_rate, iva_rate, orig_nbr_pay, loan_auth_cd, pay_amt, first_pay_per_yr_d, last_pay_per_yr_du, num_prest_ref_1, num_prest_ref_2, num_prest_ref_3, tot_sdo_cap_ref, tot_sdo_int_ref, tot_sdo_iva_ref, num_cheque, dt_cheque, oper_id_issuing_cl, oper_disb, date_disb, del_ads, tipo_presup, cve_entidad, cve_deleg, cve_uniad, cve_oficina, cve_afect, cve_gposind, cve_part, tno_cve, ramo_otorg, pagad_otorg, dt_last_status_btc, dt_last_status_onl, oper_id_btch, oper_id_online, special_aproval_te, modo_pago, tipo_cuenta, num_cta_banc, cve_banco, tipo_od, fecha_aud, hora_aud, componente_cve, ip_equipo) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPRSTAMO_ORIG_STAT = " UPDATE prstamo_orig SET loan_stat_cd = ?, "
            + " dt_last_status_onl = ?, "
            + " oper_id_online = ?, "
            + " fecha_aud = ?, "
            + " hora_aud = ?, "
            + " componente_cve = ?, "
            + " ip_equipo = ? "
            + " WHERE loan_nbr = ?  AND issste_nbr = ? ";
    private static final String BPRESTAMO_ANT_REPORT = "select "
            + " tcr.nom_tcr, po.nbr_folio as folio, cp.ciudad, po.loan_issue_date fecha_prestamo, "
            + " po.cve_afect, trim(dir.nombre) as nombre, trim(dir.apellido_paterno) as ap_paterno, trim(dir.apellido_materno) as ap_materno, "
            + " dir.rfc,dir.curp, dir.num_issste, "
            + " po.ramo_otorg, po.pagad_otorg, rm.nomb_cat as desc_pag, rm2.nomb_cat as desc_ramo, "
            + " po.loan_nbr as num_prestamo, po.orig_loan_prin as importe, "
            + " po.tot_sdo_cap_ref + po.tot_sdo_int_ref + po.tot_sdo_iva_ref saldo_prest_anterior, "
            + " po.warranty_prem prima_garantia, po.renewal_prem as prima_renovacion , "
            + " po.imp_liquido as importe_cheque,  po.pay_amt as descuento_amortizac, "
            + " po.int_rate as tasa_int, po.orig_nbr_pay as plazo_amortiz, po.first_pay_per_yr_d as inicio_desc, "
            + " po.last_pay_per_yr_du as fin_desc, cp.calle,cp.colonia, cp.codigo_postal, "
            + " cp.ciudad, cp.entidad, p.sueldo_issste sueldo_bas_mens, (ded.dscto_fovissste) ded_adicional "
            + " from PRSTAMO_ORIG po join directo dir on dir.num_issste=po.issste_nbr "
            + " join caja_pagadora cp on po.cve_entidad=cp.id_entidad and "
            + " po.cve_deleg=cp.id_delegacion and "
            + " po.cve_uniad=cp.id_uniad and "
            + " po.cve_oficina=cp.id_oficina "
            + " join tpo_credito tcr on tcr.cve_tcr=po.loan_type_cd "
            + " join crampag rm on rm.ramo_cat=po.ramo_otorg and rm.paga_cat=po.pagad_otorg "
            + " join crampag rm2 on rm2.ramo_cat=po.ramo_otorg and rm2.paga_cat='' "
            + " left join plaza p on p.num_issste = po.issste_nbr  "
            + " left join deducciones ded on ded.loan_nbr_issste = po.loan_nbr "
            + " where issste_nbr = ? "
            + " and (tipo_cuenta=4 or oper_id_online='9999')  and (loan_stat_cd=1 or loan_stat_cd=3 or loan_stat_cd=5) order by loan_nbr desc";

    public PrestamoOrigDaoImpl() {
    }

    /**
     * Obtiene el numero de prestamos por determinado estatus
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countNumeroPrestamosByEstatus(int numIssste, int estatus) {
        Integer count = super.getJdbcTemplate().queryForInt(CPRESTAMO_ORGINAL_SELECT,
                new Object[]{numIssste, estatus});
        return count;

    }

    /**
     * Se obtiene el total de los prestamos por numIssste, estatus vigente y el
     * tipo de credito
     *
     * @param numIssste
     * @param estatus
     * @param tipoCred
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countNumeroPrestamosByEstatusType(int numIssste, String estatus, int tipoCred) {
        String where = "";
        if (tipoCred > 0) {
            where += " AND loan_type_cd = " + tipoCred;
        }
        if (estatus != null && !estatus.equals("")) {
            where += " AND loan_stat_cd IN (" + estatus + ")";
        }

        Integer count = super.getJdbcTemplate().queryForInt(BPRESTAMOS_POR_ESTATUS_TIPO + where,
                new Object[]{numIssste});
        return count;

    }

    /**
     * Obtiene el numero de prestamos no cancelados para el folio
     *
     * @param folio
     * @param typeCd
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countNumeroPrestamosNoCancelados(int folio, int typeCd) {
        Integer count = super.getJdbcTemplate().queryForInt(CPRESTAMO_NO_CANCELADO_SELECT,
                new Object[]{DateUtils.anioActual(), folio, typeCd});
        return count;

    }

    /**
     * Obtiene el numeroPrestamo de los préstamos vigentes que no sean
     * hipotecarios ni adicionales por numISSSTE
     *
     * @param numIssste
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrstamoOrigVO> obtenerPrestamosVigentesXNumIssste(Integer numIssste) {
        List<Serializable> listaPrestamosVigentes = null;
        listaPrestamosVigentes = super.getJdbcTemplate().query(BNUMPREST_X_NUMISSSTE_SELECT, new Object[]{numIssste}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PrstamoOrigVO prstamoOrigVO = new PrstamoOrigVO();
                prstamoOrigVO.setLoanNbr(rs.getDouble(1));
                return prstamoOrigVO;
            }
        });
        return (List<PrstamoOrigVO>) (List) listaPrestamosVigentes;
    }

    /**
     * Obtiene el loan_auth_cd de todos los prestamos por numeroIssste, que no
     * sean cancelados
     *
     * @param numIssste
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrstamoOrigVO> obtenerLoanAuthCdXNumIssste(Integer numIssste) {
        List<Serializable> listaLoanAuthCd = null;
        listaLoanAuthCd = super.getJdbcTemplate().query(BLOAN_AUTH_CD_X_NUMISSSTE_SELECT, new Object[]{numIssste}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PrstamoOrigVO prstamoOrigVO = new PrstamoOrigVO();
                prstamoOrigVO.setLoanAuthCd(rs.getInt(1));
                return prstamoOrigVO;
            }
        });
        return (List<PrstamoOrigVO>) (List) listaLoanAuthCd;
    }

    /**
     * Obtiene el loan_auth_cd de todos los prestamos por numeroIssste, que no
     * sean cancelados
     *
     * @param numIssste
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countLoanAuthCdXNumIssste(Integer numIssste, int cveTcr) {
        Integer count = null;
        String and = "";
        if (cveTcr == 18) {
            and = " AND loan_auth_cd IN (18,7) ";
        } else if (cveTcr == 20) {
            and = " AND loan_auth_cd = 20 ";
        }
        count = super.getJdbcTemplate().queryForInt(CLOAN_AUTH_CD_X_NUMISSSTE_SELECT + and, new Object[]{numIssste});
        return count;
    }

    /**
     * Obtiene la información de los prestamos diferentes a adicionales con
     * respecto al numIssste
     *
     * @param numIssste
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrstamoOrigVO> obtenerPrestamoOrigenXNumIssste(Integer numIssste) {
        List<Serializable> listaPrestamoOrig = null;
        listaPrestamoOrig = super.getJdbcTemplate().query(BPRESTORIG_X_NUMISSSTE_SELECT, new Object[]{numIssste}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PrestamoOrigExtractor extractor = new PrestamoOrigExtractor();
                return extractor.extractData(rs);
            }
        });
        return (List<PrstamoOrigVO>) (List) listaPrestamoOrig;
    }

    /**
     * Obtiene el numero de prestamo por numero de issste y depende de si se
     * buscan adicionales o no
     *
     * @param numIssste
     * @param adicional
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrstamoOrigVO> obtenerNumPrestamo(Integer numIssste, boolean adicional) {
        List<Serializable> listaPrestamoOrig = null;
        String sql = "";
        if (numIssste != null && numIssste > 0) {
            sql += " AND  issste_nbr = " + numIssste;
        }
        if (adicional) {
            sql += " AND loan_type_cd = 13 ";
        } else {
            sql += " AND loan_type_cd <> 13 ";
        }
        listaPrestamoOrig = super.getJdbcTemplate().query(BNUMPRESTAMO_X_NUMISSSTE_SELECT + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PrstamoOrigVO prstamoOrigVO = new PrstamoOrigVO();
                prstamoOrigVO.setLoanNbr(rs.getDouble(1));
                return prstamoOrigVO;
            }
        });
        return (List<PrstamoOrigVO>) (List) listaPrestamoOrig;
    }

    /**
     * Obtener el numero de prestamos para refinanciamiento
     *
     * @param numIssste
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countPrestamosRefininanciamiento(int numIssste) {
        Integer count = super.getJdbcTemplate().queryForInt(CPRESTAMOS_REFINANCIAMIENTO, new Object[]{numIssste});
        return count;
    }

    /**
     * Obtiene los prestamos vigentes con respecto al numero de issste
     *
     * @param numIssste
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrstamoOrigVO> obtenerPrestamosVigentes(int numIssste) {
        List<PrstamoOrigVO> listaPrestamos = null;
        listaPrestamos = (List) super.getJdbcTemplate().query(BPRESTAMOS_VIGENTES, new Object[]{numIssste}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PrstamoOrigVO vo = new PrstamoOrigVO();
                vo.setLoanNbr(rs.getDouble(1));
                vo.setLoanIssue_date(rs.getDate(2));
                return vo;
            }
        });
        return listaPrestamos;
    }

    /**
     * Se buscan los prestamos Anteriores o actuales del Derechohabiente por
     * ISSSTE
     *
     * @param numIssste
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrstamoOrigVO> bucarPrestamoWeb(Integer numIssste) {
        List<PrstamoOrigVO> prestamosWeb = null;
        prestamosWeb = (List) super.getJdbcTemplate().query(BPRESTAMO_GENERADO_USUARIO_PORTAL, new Object[]{numIssste}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PrestamoOrigExtractorWeb extractor = new PrestamoOrigExtractorWeb();
                return extractor.extractData(rs);
            }
        });
        return prestamosWeb;
    }

    public void updatePrestamo(Double prestamo, int faltaMod, int tipoCred,String ipMaquina) {
        Object[] params = new Object[7];
        params[0] = faltaMod;
        params[1] = tipoCred;
        params[2] = DateUtils.horaActual();
        params[3] = new Date();
        params[4] = Constants.AUTWEB;
        params[5] = ipMaquina;//--- ipEquipo ---
        params[6] = prestamo;

        super.getJdbcTemplate().update(
                UPDATE_AUTORIZACION_PRESTAMO, params);

    }

    public void insertarProcTes(Double prestamo) {
        Object[] params = new Object[3];
        params[0] = prestamo;
        params[1] = Constants.OPERADOR_WEB;
        params[2] = new Date();

        super.getJdbcTemplate().update(
                INSERT_PROC_TESORE, params);

    }

    public void insert(PrstamoOrigVO prstamoOrigVO) {
        String query=null;
        Object[] params = new Object[60];
        params[0] = prstamoOrigVO.getIsssteNbr();
        params[1] = prstamoOrigVO.getLoanNbr();
        params[2] = prstamoOrigVO.getAnioFolio();
        params[3] = prstamoOrigVO.getLoanTypeCd();
        params[4] = prstamoOrigVO.getNbrFolio();
        params[5] = prstamoOrigVO.getLoanIssue_date();
        params[6] = prstamoOrigVO.getLoanStatCd();
        params[7] = prstamoOrigVO.getNumRefPmp();
        params[8] = prstamoOrigVO.getBadLoanFlg();
        params[9] = prstamoOrigVO.getOrigLoanPrin();
        params[10] = prstamoOrigVO.getImpLiquido();
        params[11] = prstamoOrigVO.getOrigLoanIntAmt();
        params[12] = prstamoOrigVO.getOrigIva();
        params[13] = prstamoOrigVO.getDeferredInt();
        params[14] = prstamoOrigVO.getWarrantyPrem();
        params[15] = prstamoOrigVO.getRenewalPrem();
        params[16] = prstamoOrigVO.getIntRate();
        params[17] = prstamoOrigVO.getIvaRate();
        params[18] = prstamoOrigVO.getOrigNbrPay();
        params[19] = prstamoOrigVO.getLoanAuthCd();
        params[20] = prstamoOrigVO.getPayAmt();
        params[21] = prstamoOrigVO.getFirstPayPerYrD();
        params[22] = prstamoOrigVO.getLastPayPerYrDu();
        params[23] = prstamoOrigVO.getNumPrestRef1();
        params[24] = prstamoOrigVO.getNumPrestRef2();
        params[25] = prstamoOrigVO.getNumPrestRef3();
        params[26] = prstamoOrigVO.getTotSdoCapRef();
        params[27] = prstamoOrigVO.getTotSdoIntRef();
        params[28] = prstamoOrigVO.getTotSdoIvaRef();
        params[29] = prstamoOrigVO.getNumCheque();
        params[30] = prstamoOrigVO.getDtCheque();
        params[31] = prstamoOrigVO.getOperIdIssuingCl();
        params[32] = prstamoOrigVO.getOperDisb();
        params[33] = prstamoOrigVO.getDateDisb();
        params[34] = prstamoOrigVO.getDelAds();
        params[35] = prstamoOrigVO.getTipoPresup();
        params[36] = prstamoOrigVO.getCveEntidad();
        params[37] = prstamoOrigVO.getCveDeleg();
        params[38] = prstamoOrigVO.getCveUniad();
        params[39] = prstamoOrigVO.getCveOficina();
        params[40] = prstamoOrigVO.getCveAfect();
        params[41] = prstamoOrigVO.getCveGposind();
        params[42] = prstamoOrigVO.getCvePart();
        params[43] = prstamoOrigVO.getTnoCve();
        params[44] = prstamoOrigVO.getRamoOtorg();
        params[45] = prstamoOrigVO.getPagadOtorg();
        params[46] = prstamoOrigVO.getDt_lastStatusBtc();
        params[47] = prstamoOrigVO.getDtLastStatusOnl();
        params[48] = prstamoOrigVO.getOperIdBtch();
        params[49] = prstamoOrigVO.getOperIdOnline();
        params[50] = prstamoOrigVO.getSpecialAprovalTe();
        params[51] = prstamoOrigVO.getModoPago();
        params[52] = prstamoOrigVO.getTipoCuenta();
        params[53] = prstamoOrigVO.getNumCtaBanc();
        params[54] = prstamoOrigVO.getCveBanco();
        params[55] = prstamoOrigVO.getTipoOd();
        params[56] = prstamoOrigVO.getFechaAud();
        params[57] = prstamoOrigVO.getHoraAud();
        params[58] = prstamoOrigVO.getComponenteCve();
        params[59] = prstamoOrigVO.getIpEquipo();
        if(prstamoOrigVO.getLoanTypeCd()!=21){
            query = IPRSTAMO_ORIG.replace("[TABLA]", Constants.TABLA_PRSTAM);
        }else{
            query = IPRSTAMO_ORIG.replace("[TABLA]", Constants.TABLA_PRSTAM_AUTO);
        }
        super.getJdbcTemplate().update(query, params);
    }
    
    /**
     *
     * @param prestamo
     */
    public void updateEstatusCd(PrstamoOrigVO prestamo) {
        List<Object> params = new ArrayList<Object>();
        params.add(prestamo.getLoanStatCd());
        params.add(prestamo.getDtLastStatusOnl());
        params.add(prestamo.getOperIdOnline());
        params.add(prestamo.getFechaAud());
        params.add(prestamo.getHoraAud());
        params.add(prestamo.getComponenteCve());
        params.add(prestamo.getIpEquipo());
        params.add(prestamo.getLoanNbr());
        params.add(prestamo.getIsssteNbr());
        super.getJdbcTemplate().update(UPRSTAMO_ORIG_STAT, params.toArray());
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public ReporteVO getPrestamosAnterior(Double numIssste) {
        List<ReporteVO> prestamos = (List<ReporteVO>) (List) super.getJdbcTemplate().query(BPRESTAMO_ANT_REPORT, new Object[]{numIssste}, new SerializableRowMapper() {

            public ReporteVO mapRow(ResultSet rs, int i) throws SQLException {
                ReporteVO vo = new ReporteVO();
                vo.setTP_PRESTAMO(rs.getString("nom_tcr"));
                vo.setNUMERO_FOLIO(rs.getInt("folio"));
                vo.setAFEC_PRES(rs.getInt("cve_afect"));
                vo.setCAJA(20);
                vo.setAPATERNO(rs.getString("ap_paterno"));
                vo.setAMATERNO(rs.getString("ap_materno"));
                vo.setNOMBRE(rs.getString("nombre"));
                vo.setCURP(rs.getString("curp"));
                vo.setRFC(rs.getString("rfc"));
                vo.setNUM_ISSSTE(rs.getInt("num_issste"));
                vo.setNUM_PRESTAMO(rs.getDouble("num_prestamo"));
                vo.setIMPORTE_PRESTAMO(rs.getDouble("importe"));

                vo.setCRAM0(rs.getInt("ramo_otorg"));
                vo.setNRAMO(rs.getString("desc_ramo"));
                vo.setSUELDO_BASICO(rs.getDouble("sueldo_bas_mens"));
                vo.setCPAGADURIA(rs.getString("pagad_otorg"));
                vo.setNPAGADURIA(rs.getString("desc_pag"));
                vo.setDFOVISSSTE(rs.getDouble("ded_adicional"));
                String importe = LetrasUtil.convertirNumeroALetras(rs.getDouble("importe")).toUpperCase();
                vo.setIMPORTE_PRES_LETRA(importe);
                vo.setSALDO_ANTERIOR(rs.getDouble("saldo_prest_anterior"));
                vo.setPRIMA_GARANTIA(rs.getDouble("prima_garantia"));
                vo.setPRIMA_RENOVACION(rs.getDouble("prima_renovacion"));
                vo.setIMPORTE_CHEQUE_NUM(rs.getDouble("importe_cheque"));
                vo.setDESC_AMORTIZACION(rs.getDouble("descuento_amortizac"));
                vo.setTASA_INTERES(rs.getDouble("tasa_int"));
                vo.setPLAZO(rs.getInt("plazo_amortiz"));
                vo.setINICIO_DESC(rs.getInt("inicio_desc"));
                vo.setFIN_DESC(rs.getInt("fin_desc"));
                vo.setFECHA_PRESTAMO(rs.getDate("fecha_prestamo"));
                String importecheque = LetrasUtil.convertirNumeroALetras(rs.getDouble("importe_cheque")).toUpperCase();
                vo.setIMP_CHEQ_LETRA(importecheque);
                vo.setCALLE(rs.getString("calle"));
                vo.setCOLONIA(rs.getString("colonia"));
                vo.setCIUDAD(rs.getString("ciudad"));
//                vo.setNUMERO(null);
                vo.setCP(rs.getString("codigo_postal"));
                vo.setESTADO(rs.getString("entidad"));
                return vo;
            }
        });
//        ReporteVO prestamo =null;
        for (ReporteVO vo : prestamos) {
//            prestamo=
            return vo;
        }
        return null;
    }
}
