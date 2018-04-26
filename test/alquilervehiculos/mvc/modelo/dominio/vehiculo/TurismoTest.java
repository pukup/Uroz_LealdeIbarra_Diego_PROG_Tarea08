/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import alquilervehiculos.mvc.modelo.dominio.vehiculo.Turismo;
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
public class TurismoTest
{

    Turismo t1;

    public TurismoTest()
    {
        t1 = new Turismo("0000CCC", "c", "c", 1, 1, 1);
    }

    @Test
    public void TestTipoVehiculo()
    {
        //arrange
        //act
        //assert
        //Ni idea.
    }

    @Test
    public void TestGetPrecioEspecifico()
    {
        //arrange
        //act
        //assert
        assertEquals(1.02, t1.getPrecioEspecifico(), 0);
    }

}
