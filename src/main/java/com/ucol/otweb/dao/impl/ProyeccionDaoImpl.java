/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IProyeccionDao;
import com.ucol.otweb.dao.jdbc.PrestamoProyeccionExtractor;
import com.ucol.otweb.dao.jdbc.ProyeccionExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.PrestamoProyeccionVO;
import com.ucol.otweb.vo.ProyeccionVO;
import com.ucol.otweb.vo.QnaVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Component
@Repository(value = "proyeccionDao")
public class ProyeccionDaoImpl extends GenericDao implements IProyeccionDao {
    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */

    private static final String BSLADO_ACTUAL_X_PRESTAMO = "SELECT curr_prin_bal ,(int_earned_to_date - tot_int_pd),(tot_iva_gan - tot_iva_pag)  FROM proyeccion WHERE loan_nbr = ?";
    private static final String BPROYECCION = "SELECT curr_prin_bal,int_earned_to_date, tot_int_pd,tot_iva_gan,tot_iva_pag,curr_prin_bal,date_last_pay,amt_last_pmt, last_pay_per_due, loan_nbr FROM PROYECCION WHERE LOAN_NBR =? ";
    private static final String BPROYECCION_PRESTAMOS_ACTIVOS =
            "SELECT a.loan_nbr, a.loan_issue_date, a.pay_amt, b.stat_convenio, b.curr_prin_bal, b.stat_cobr, b.date_last_pay, "
            + " b.int_earned_to_date, b.tot_int_pd, b.tot_iva_gan, b.tot_iva_pag, b.num_difer, b.amt_last_pmt  "
            + " FROM  prstamo_orig a, proyeccion b "
            + " WHERE a.loan_stat_cd IN (3,5,8) AND a.loan_nbr = b.loan_nbr AND b.curr_prin_bal > 0 AND b.loan_nbr = ? ";
    private static final String PRESTAMO_CERO =
            "SELECT a.loan_nbr, a.loan_issue_date, a.pay_amt, b.stat_convenio, b.curr_prin_bal, b.stat_cobr, b.date_last_pay, "
            + " b.int_earned_to_date, b.tot_int_pd, b.tot_iva_gan, b.tot_iva_pag, b.num_difer, b.amt_last_pmt  "
            + " FROM  prstamo_orig a, proyeccion b "
            + " WHERE a.loan_stat_cd IN (3,5,8) AND a.loan_nbr = b.loan_nbr AND b.curr_prin_bal > 0";
    private static final String PROYECTA_PRESTAMO = " SELECT "
            + " proyeccion.date_last_pay,proyeccion.first_pay_per_due, "
            + " proyeccion.curr_prin_bal,proyeccion.int_earned_to_date, "
            + " proyeccion.tot_int_pd,proyeccion.tot_iva_gan, "
            + " proyeccion.tot_iva_pag,proyeccion.per_int_earned, "
            + " proyeccion.per_int_pd,proyeccion.per_princ_pd, "
            + " proyeccion.per_iva_gan,proyeccion.per_iva_pag, "
            + " proyeccion.amt_last_pmt,proyeccion.imp_pago_ant_proy, "
            + " proyeccion.num_pago_ant_proy, proyeccion.tot_prin_paid_to_d,"
            + " prstamo_orig.loan_issue_date,"
            + " prstamo_orig.tno_cve,prstamo_orig.int_rate, "
            + " prstamo_orig.iva_rate,prstamo_orig.loan_type_cd, "
            + " prstamo_orig.orig_loan_int_amt,prstamo_orig.orig_nbr_pay,prstamo_orig.pay_amt "
            + " FROM prstamo_orig,proyeccion "
            + " WHERE prstamo_orig.loan_nbr = proyeccion.loan_nbr AND proyeccion.loan_nbr = ? ";
    private static final String EXISTE_REGULARIZACION = " SELECT COUNT(*) FROM regularizacion WHERE regularizacion.loan_nbr = ? ";
    private static final String RANGO_FECHAS = "select first 1 (MDY(MONTH(TODAY),1,YEAR(TODAY)) - 1) ,(MDY(MONTH(TODAY),16,YEAR(TODAY)) - 1) from c_entidades ";
    private static final String TASA_INTERES = " select tasa_tasa from llavtas where qq_tasa = ? ";

    /*
     * Se obtiene el saldo actual con respecto a la tabla de Proyeccion
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ProyeccionVO> obtenerSaldoActualProy(Double numPrestamo) {
        List<Serializable> saldosActuales = null;
        saldosActuales = super.getJdbcTemplate().query(BSLADO_ACTUAL_X_PRESTAMO, new Object[]{numPrestamo}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                ProyeccionVO proyeccionVO = new ProyeccionVO();
                proyeccionVO.setCurrPrinBal(rs.getDouble(1));
                proyeccionVO.setDifInteres(rs.getDouble(2));
                proyeccionVO.setDifIvas(rs.getDouble(3));
                return proyeccionVO;
            }
        });
        return (List<ProyeccionVO>) (List) saldosActuales;
    }

    /**
     * regresa los datos de la proyeccion asociados al loan_nbr
     *
     * @param loanNbr
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public ProyeccionVO obtenerProyeccionByID(Double loanNbr) {
        ProyeccionVO vo = null;
        List<ProyeccionVO> proyecciones = (List)super.getJdbcTemplate().query(BPROYECCION, new Object[]{loanNbr}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                ProyeccionExtractor extractor = new ProyeccionExtractor();
                return extractor.extractData(rs);
            }
        });
        if(proyecciones!=null && proyecciones.size()>0){
            vo = proyecciones.get(0);
        }
        return vo;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrestamoProyeccionVO> obtenerPrestamosVigentes(Double numPrestamo) {
        List<PrestamoProyeccionVO> listaPrestamos = null;
        listaPrestamos = (List) super.getJdbcTemplate().query(BPROYECCION_PRESTAMOS_ACTIVOS, new Object[]{numPrestamo},
                new SerializableRowMapper() {

                    public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                        PrestamoProyeccionExtractor extractor = new PrestamoProyeccionExtractor();
                        return extractor.extractData(rs);
                    }
                });
        return listaPrestamos;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrestamoProyeccionVO> obtenerPrestamosCero() {
        List<PrestamoProyeccionVO> listaPrestamos = null;
        
        listaPrestamos = (List) super.getJdbcTemplate().query(PRESTAMO_CERO,
                new SerializableRowMapper() {

                    public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                        PrestamoProyeccionExtractor extractor = new PrestamoProyeccionExtractor();
                        return extractor.extractData(rs);
                    }
                });
        return listaPrestamos;
    }
    /*
     * Obtiene las proyecciones de un prestamo de cualquier estatus
     */

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrestamoProyeccionVO> obtenerProyeccionPrestamo(Double numPrestamo) {

        List<PrestamoProyeccionVO> lsProy = (List) super.getJdbcTemplate().query(PROYECTA_PRESTAMO, new Object[]{numPrestamo},
                new SerializableRowMapper() {

                    public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                        PrestamoProyeccionExtractor extractor = new PrestamoProyeccionExtractor();
                        return extractor.extractDataAll(rs);
                    }
                });

        return lsProy;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public int existeRegularizaion(Double numPrestamo) {

        int banRegul = super.getJdbcTemplate().queryForInt(EXISTE_REGULARIZACION, new Object[]{numPrestamo});

        return banRegul;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public QnaVO ontieneRangoFechas() {

        List<QnaVO> listQnaVO = (List) super.getJdbcTemplate().query(RANGO_FECHAS,
                new SerializableRowMapper() {

                    public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                        PrestamoProyeccionExtractor extractor = new PrestamoProyeccionExtractor();
                        return extractor.extractDataAll(rs);
                    }
                });

        return listQnaVO.get(0);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Double tasaInteres(String qnaInteres) {
        List<Double> tasaInteres = (List) super.getJdbcTemplate().query(TASA_INTERES, new Object[]{qnaInteres},
                new SerializableRowMapper() {

                    public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                        PrestamoProyeccionExtractor extractor = new PrestamoProyeccionExtractor();
                        return extractor.extractDataInteres(rs);
                    }
                });
        return new Double(0.0);
    }

    public void actualizaProy(PrestamoProyeccionVO proy) {

        String strUpdate = "UPDATE proyeccion SET curr_prin_bal= ? ,int_earned_to_date= ? ,tot_int_pd= ? ,tot_iva_gan= ? ,"
                + "tot_iva_pag= ? ,date_last_pay= ? ,per_int_earned= ? ,per_int_pd= ? ,per_princ_pd= ? ,per_iva_gan= ? ,per_iva_pag= ? ,"
                + "hora_aud= ? ,componente_cve= ? ,tot_prin_paid_to_d= ? ,ip_equipo= ? where loan_nbr =  ? ";
        Object params[]=new Object[16];
        params[0]=proy.getProyeccion().getCurrPrinBal(); 
        params[1]=proy.getProyeccion().getIntEarnedToDate(); 
        params[2]=proy.getProyeccion().getTotIntPd(); 
        params[3]=proy.getProyeccion().getTotIvaGan();
        params[4]=proy.getProyeccion().getTotIvaPag(); 
        params[5]=proy.getProyeccion().getDatePastPay(); 
        params[6]=proy.getProyeccion().getPerIntEarned(); 
        params[7]=proy.getProyeccion().getPerIntPd(); 
        params[8]=proy.getProyeccion().getPerPrincPd();
        params[9]=proy.getProyeccion().getPerIvaGan(); 
        params[10]=proy.getProyeccion().getPerIvaPag();
        params[11]=proy.getProyeccion().getHoraAud(); 
        params[12]=proy.getProyeccion().getComponenteCve();
        params[13]=proy.getProyeccion().getTotPrinPaidToD();
        params[14]=proy.getProyeccion().getIpEquipo();
        params[15]=proy.getPrestamo().getLoanNbr();
        super.getJdbcTemplate().update(strUpdate, params);

    }

    public void actualizaProyCU(PrestamoProyeccionVO proy) {

        String strUpdate = "UPDATE proyeccion SET amt_last_pmt=?,cve_oper_dt_fin_on=?,dt_mod_dat_fin_onl=? where loan_nbr = ?";

        super.getJdbcTemplate().update(
                strUpdate, new Object[]{proy.getProyeccion().getAmtLastPmt(), proy.getProyeccion().getCveOperDtFinOn(), proy.getPrestamo().getLoanNbr()});

    }

    public void actualizaProyCD(PrestamoProyeccionVO proy) {

        String strUpdate = "UPDATE proyeccion SET cve_oper_dt_fin_bt=?,dt_mod_dat_fin_btc=? where loan_nbr = ?";

        super.getJdbcTemplate().update(
                strUpdate, new Object[]{proy.getProyeccion().getCve_operDtFinBt(), proy.getProyeccion().getDt_modDatFinBtc(), proy.getPrestamo().getLoanNbr()});

    }

    public void actualizaProyIVA(ProyeccionVO proy) {

        String strUpdate = "UPDATE proyeccion SET per_int_mrto_gan=?,per_int_mrto_pag=? where loan_nbr = ?";

        super.getJdbcTemplate().update(
                strUpdate, new Object[]{proy.getPerIntMrtoGan(), proy.getPerIntMrtoPag(), proy.getLoanNbr()});

    }

    public void insert(ProyeccionVO proyeccionVO) {
        String insert = "INSERT INTO proyeccion("
                + " loan_nbr, first_pay_per_due, last_pay_per_due, curr_prin_bal, int_earned_to_date, tot_int_pd,"
                + " tot_iva_gan, tot_iva_pag, date_last_pay, per_int_earned, per_int_pd, per_princ_pd, per_iva_gan, per_iva_pag, tot_int_mrto_gan,"
                + " tot_int_mrto_pag, per_int_mrto_gan, per_int_mrto_pag, amt_last_pmt, plazo, imp_pago_ant_proy, num_pago_ant_proy, num_difer, "
                + " tot_prin_paid_to_d, iva_pag_proy_opt, iva_gan_proy_opt, tot_int_proy_opt, int_earned_pro_opt, saldo_cap_proy_opt, "
                + " fecha_stat, stat_cobr, num_citatorio, dt_last_citat, stat_convenio, num_convenio, dt_first_conv, num_meses_conv, "
                + " dt_last_conv, cve_oper_dt_fin_on, cve_oper_dt_fin_bt, dt_mod_dat_fin_onl, dt_mod_dat_fin_btc, hora_aud, componente_cve, ip_equipo) "
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[45];
        params[0] = proyeccionVO.getLoanNbr();
        params[1] = proyeccionVO.getFirstPayPerDue();
        params[2] = proyeccionVO.getLastPayPerDue();
        params[3] = proyeccionVO.getCurrPrinBal();
        params[4] = proyeccionVO.getIntEarnedToDate();
        params[5] = proyeccionVO.getTotIntPd();
        params[6] = proyeccionVO.getTotIvaGan();
        params[7] = proyeccionVO.getTotIvaPag();
        params[8] = proyeccionVO.getDatePastPay();
        params[9] = proyeccionVO.getPerIntEarned();
        params[10] = proyeccionVO.getPerIntPd();
        params[11] = proyeccionVO.getPerPrincPd();
        params[12] = proyeccionVO.getPerIvaGan();
        params[13] = proyeccionVO.getPerIvaPag();
        params[14] = proyeccionVO.getTotIntMrtoGan();
        params[15] = proyeccionVO.getTotIntMrtoPag();
        params[16] = proyeccionVO.getPerIntMrtoGan();
        params[17] = proyeccionVO.getPerIntMrtoPag();
        params[18] = proyeccionVO.getAmtLastPmt();
        params[19] = proyeccionVO.getPlazo();
        params[20] = proyeccionVO.getImpPagoAntProy();
        params[21] = proyeccionVO.getNum_pagoAntProy();
        params[22] = proyeccionVO.getNum_difer();
        params[23] = proyeccionVO.getTotPrinPaidToD();
        params[24] = proyeccionVO.getIvaPagProyOpt();
        params[25] = proyeccionVO.getIvaGanProyOpt();
        params[26] = proyeccionVO.getTotIntProyOpt();
        params[27] = proyeccionVO.getIntEarnedProOpt();
        params[28] = proyeccionVO.getSaldoCapProyOpt();
        params[29] = proyeccionVO.getFechaStat();
        params[30] = proyeccionVO.getStatCobr();
        params[31] = proyeccionVO.getNumCitatorio();
        params[32] = proyeccionVO.getDtLastCitat();
        params[33] = proyeccionVO.getStatConvenio();
        params[34] = proyeccionVO.getNumConvenio();
        params[35] = proyeccionVO.getDtFirstConv();
        params[36] = proyeccionVO.getNumMesesConv();
        params[37] = proyeccionVO.getDtLastConv();
        params[38] = proyeccionVO.getCveOperDtFinOn();
        params[39] = proyeccionVO.getCve_operDtFinBt();
        params[40] = proyeccionVO.getDt_modDatFinOnl();
        params[41] = proyeccionVO.getDt_modDatFinBtc();
        params[42] = proyeccionVO.getHoraAud();
        params[43] = proyeccionVO.getComponenteCve();
        params[44] = proyeccionVO.getIpEquipo();

        super.getJdbcTemplate().update(insert, params);
    }
}
