/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.DirectoAVVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class BDirectoAVExtractor implements ResultSetExtractor<DirectoAVVO> {

    public DirectoAVVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        DirectoAVVO directo = new DirectoAVVO();
        directo.setNumIssste(rs.getInt(1));
        directo.setUversion(rs.getString(2));
        directo.setCodigoPostal(rs.getInt(3));
        directo.setNcoCve(rs.getInt(4));
        directo.setEntCve(rs.getString(5));
        directo.setCurp(rs.getString(6));
        directo.setNss(rs.getLong(7));
        directo.setClinica(rs.getString(8));
        directo.setDtoEstado(rs.getString(9));
        directo.setSexo(rs.getString(10));
        directo.setEstadoCivil(rs.getString(11));
        directo.setTdirecto(rs.getString(12));
        directo.setFechaAlta(rs.getDate(13));
        directo.setFechaBaja(rs.getDate(14));
        directo.setFechaEmiVd1(rs.getDate(15));
        directo.setFechaIngreso(rs.getDate(16));
        directo.setNumExterior(rs.getString(17));
        directo.setNumInterior(rs.getString(18));
        directo.setRfc(rs.getString(19));
        directo.setTelefono(rs.getString(20));
        directo.setApellidoPaterno(rs.getString(21));
        directo.setApellidoMaterno(rs.getString(22));
        directo.setNombre(rs.getString(23));
        directo.setCalle(rs.getString(24));
        directo.setPoblacion(rs.getString(25));
        directo.setFecNac(rs.getDate(26));
        directo.setFlagHomo(rs.getString(27));
        directo.setEligProc(rs.getString(28));
        directo.setUsuario(rs.getString(29));
        directo.setFechaAud(rs.getDate(30));
        directo.setHoraAud(rs.getString(31));
        directo.setComponenteCve(rs.getString(32));
        directo.setIpMaquina(rs.getString(33));
        
        return directo;
    }
    
}
