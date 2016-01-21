/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service.impl;

import com.ucol.otweb.dao.IDatosLaborales;
import com.ucol.otweb.service.IOtorgamientoWEB;
import com.ucol.otweb.utils.exception.OtwException;
import com.ucol.otweb.utils.exception.OtwExceptionCodes;
import com.ucol.otweb.utils.exception.SQLErrorCodesFactory;
import com.ucol.otweb.vo.EntidadVO;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
public class TransactionalTest {
    @Autowired
    private IDatosLaborales datosLaborales;
    private ApplicationContext context;
    @Autowired
    private SQLErrorCodesFactory sQLErrorCodesFactory;
    @Autowired
    private IOtorgamientoWEB iOtorgamientoWEB;

    
    public TransactionalTest(){
        
    }
    @Before
    public void setUp() throws Exception {

        context = new ClassPathXmlApplicationContext("file:E:\\sipesic-otorgamiento\\OtorgamientoWEB\\src\\test\\java\\resources\\test-context.xml");
        //context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        datosLaborales = (IDatosLaborales) context.getBean("datosLaborales");
        sQLErrorCodesFactory = (SQLErrorCodesFactory)context.getBean("sQLErrorCodesFactory");
        iOtorgamientoWEB = (IOtorgamientoWEB) context.getBean("iOtorgamientoWEB");
        
    }
//    @Test
//    @Transactional(rollbackFor=Exception.class)
    public void testTransactional(){
        EntidadVO vo=null;
        for(int i=0; i<=3;i++){
            vo=new EntidadVO();
            vo.setAbvEntidad("T"+i);
            vo.setComponenteCve("Test OTW");
            vo.setCveEntidad(44+i);
            vo.setDescEntidad("Test Trans");
            vo.setFechaAud(new Date(2014, 11, 12));
            vo.setIpEquipo("no-ip");
            vo.setUsuario("test");
            datosLaborales.insertData(vo);
        }
        throw sQLErrorCodesFactory.createException(OtwExceptionCodes.DADO_DE_BAJA);
    }
    @Test
    public void testTransactionalWEB(){
        try{
            iOtorgamientoWEB.insertDataRecursivo();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
