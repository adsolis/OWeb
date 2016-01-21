/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.VcPagaduriaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class VCPagaduriaVOExtractor implements ResultSetExtractor<VcPagaduriaVO> {

    public VcPagaduriaVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        VcPagaduriaVO pagaduriaVO = new VcPagaduriaVO();
        pagaduriaVO.setNumRamo(rs.getInt(1));
        pagaduriaVO.setNumPagaduria(rs.getString(2));
        pagaduriaVO.setRamAnt(rs.getDouble(3));
        pagaduriaVO.setDisCve(rs.getDouble(4));
        pagaduriaVO.setEntCve(rs.getString(5));
        pagaduriaVO.setEntDis(rs.getString(6));
        pagaduriaVO.setSecCve(rs.getDouble(7));
        pagaduriaVO.setModCve(rs.getDouble(8));
        pagaduriaVO.setMbaCve(rs.getString(9));
        pagaduriaVO.setResCve(rs.getString(10));
        pagaduriaVO.setResCCve(rs.getString(11));
        pagaduriaVO.setCodigoPostal(rs.getDouble(12));
        pagaduriaVO.setNcoCve(rs.getDouble(13));
        pagaduriaVO.setPagEstado(rs.getString(14));
        pagaduriaVO.settAseguramiento(rs.getString(15));
        pagaduriaVO.settInterInf(rs.getString(16));
        pagaduriaVO.setDistribucion(rs.getString(17));
        pagaduriaVO.setFechaIniciaACt(rs.getDate(18));
        pagaduriaVO.setFechaAlta(rs.getDate(19));
        pagaduriaVO.setFechaBaja(rs.getDate(20));
        pagaduriaVO.setPorcentAporSm(rs.getFloat(21));
        pagaduriaVO.setPorcentAporCre(rs.getFloat(22));
        pagaduriaVO.setPorcentAporSar(rs.getFloat(23));
        pagaduriaVO.setPorcentAporPen(rs.getFloat(24));
        pagaduriaVO.setPorcentAporEst(rs.getFloat(25));
        pagaduriaVO.setPorcentAporFov(rs.getFloat(26));
        pagaduriaVO.setPorcentAporGa(rs.getFloat(27));
        pagaduriaVO.setPorcentAporRt(rs.getFloat(28));
        pagaduriaVO.setPorcentCuoGa(rs.getFloat(29));
        pagaduriaVO.setPorcentCuoCre(rs.getFloat(30));
        pagaduriaVO.setPorcentCuoPen(rs.getFloat(31));
        pagaduriaVO.setPorcentCuoSm(rs.getFloat(32));
        pagaduriaVO.setPorcentCuoEst(rs.getFloat(33));
        pagaduriaVO.setNumExterior(rs.getString(34));
        pagaduriaVO.setNumInterior(rs.getString(35));
        pagaduriaVO.setTelefono(rs.getString(36));
        pagaduriaVO.setCalle(rs.getString(37));
        pagaduriaVO.setNombre(rs.getString(38));
        pagaduriaVO.settPagoAportacn(rs.getString(39));
        pagaduriaVO.settPagoCuota(rs.getString(40));
        pagaduriaVO.settPagoRetencn(rs.getString(41));
        return pagaduriaVO;
    }
    
}
