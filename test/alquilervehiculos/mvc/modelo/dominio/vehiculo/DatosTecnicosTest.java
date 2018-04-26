/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import alquilervehiculos.mvc.modelo.dominio.vehiculo.DatosTecnicos;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lol
 */
public class DatosTecnicosTest
{
    DatosTecnicos d1;
    
    public DatosTecnicosTest()
    {
        d1 = new DatosTecnicos(1, 1, 1);
    }

    @Test
    public void TestvalidarDatoEntero()
    {
        //arrange
        int dato;

        //act
        dato = 1;

        //assert
        assertTrue(DatosTecnicos.datoValido(dato));
    }

    @Test
    public void TestvalidarDatoCero()
    {
        //arrange
        int dato;

        //act
        dato = 0;

        //assert
        assertFalse(DatosTecnicos.datoValido(dato));
    }

    @Test
    public void TestvalidarDatoNegativo()
    {
        //arrange
        int dato;

        //act
        dato = -1;

        //assert
        assertFalse(DatosTecnicos.datoValido(dato));
    }
        
}
