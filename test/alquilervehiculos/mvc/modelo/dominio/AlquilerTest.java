/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Turismo;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lol
 */
public class AlquilerTest
{

    Cliente c1;
    Vehiculo v1;
    Alquiler a1;

    public AlquilerTest()
    {
        c1 = new Cliente("c", "00000000C", "c", "c", "00000");
        v1 = new Turismo("0000CCC", "c", "c", 1, 1, 1);
        a1 = new Alquiler(c1, v1);
    }

    @Test
    public void testOpen()
    {
        //arrange
        //act        
        //assert
        assertTrue(a1.getAlquilerAbierto());
        assertNotNull(a1.getCliente());
        assertNotNull(a1.getVehiculo());
        System.out.println(a1.getFechaInicioAlquiler());
    }

    @Test
    public void testOpenVehiculoNoDisponible()
    {
        //arrange
        System.out.println("Prueba excepción constructor:\n");
        Alquiler a2;

        //act    
        try
        {
            a2 = new Alquiler(c1, v1);

        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }
        //assert
        assertFalse(v1.getDisponible());
    }

    @Test
    public void testClose()
    {
        //arrange
        //act        
        a1.close();
        //assert
        assertFalse(a1.getAlquilerAbierto());
        assertTrue(v1.getDisponible());
        System.out.println(a1.getFechaFinAlquiler());
    }

    @Test
    public void testCloseAlquilerCerrado()
    {
        //arrange
        System.out.println("Prueba excepción método close:\n");
        //act        
        a1.close();
        try
        {
            a1.close();
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }
        //assert
        assertFalse(a1.getAlquilerAbierto());
        assertTrue(v1.getDisponible());
    }

    @Test
    public void testPrecioSegunDias()
    {
        //arrange
        //act        
        a1.close();
        //assert
        assertEquals(30.02, a1.getPrecioSegunDias(a1.getDuracionAlquiler()), 0);
    }

    @Test
    public void testPrecioSegunDiasRandom()
    {
        //arrange
        //act        
        //assert
        assertEquals(3000.02,Alquiler.getPrecioSegunDias(100,v1),0);
    }

    @Test
    public void testDuracionAlquiler()
    {
        //arrange
        //act        
        a1.close();
        //assert
        assertEquals(0, a1.getDuracionAlquiler());
        //System.out.println(a1.getPrecioSegunDias(a1.getDuracionAlquiler()));
    }

    @Test
    public void testDuracionAlquilerAbierto()
    {
        //arrange
        System.out.println("Prueba excepción método duracionAlquiler:\n");
        //act        
        try
        {
            a1.getDuracionAlquiler();
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }
        //assert

    }

    @Test
    public void testToStringAbierto()
    {
        //arrange
        //act        
        System.out.println(a1.toString());
        //assert

    }

    @Test
    public void testToStringCerrado()
    {
        //arrange
        a1.close();
        //act        
        System.out.println(a1.toString());
        //assert

    }

    @Test
    public void testToStringEstado()
    {
        //arrange
        //act        
        System.out.println(a1.getEstadoAlquilerString());
        //assert

    }

    @Test
    public void testToStringEstadoCerrado()
    {
        //arrange
        a1.close();
        //act        
        System.out.println(a1.getEstadoAlquilerString());
        //assert

    }
}
