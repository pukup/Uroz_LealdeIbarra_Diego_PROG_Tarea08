/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Autobus;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lol
 */
public class AutobusTest
{

    Vehiculo v1;

    public AutobusTest()
    {
        v1 = new Autobus("0000XXX", "a", "a", 1, 1, 1);
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
        assertEquals(1, v1.getPrecioEspecifico(), 0);
    }
}
