/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
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
public class ClienteTest
{

    Cliente c1, c2;

    public ClienteTest()
    {
        c1 = new Cliente("a", "00000000A", "a", "a", "00000");
        c2 = new Cliente("a", "00000000A", "a", "a", "00000");
    }

    @Test
    public void testConstructorTrampa()
    {
        //arrange        
        System.out.println("Excepción constructor vacio:");
        //act
        try
        {
            c1 = new Cliente("", "", "", "", "");
            fail("Excepción no lanzada.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);;
        }

        //assert
        assertNotNull(c1);
    }

    @Test
    public void testCompruebaDniCorrecto()
    {
        //arrange
        String dni;

        //act
        dni = "00000000A";

        //assert
        assertTrue(Cliente.formatoDniCorrecto(dni));

    }

    @Test
    public void testCompruebaDniIncorrecto()
    {
        //arrang
        String dni;

        //act
        dni = "000000000";

        //assert
        assertFalse(Cliente.formatoDniCorrecto(dni));

    }

    @Test
    public void testCadenaLlenaConTexto()
    {
        //arrange
        String stringLlena;

        //act
        stringLlena = "Llena";

        //assert
        assertTrue(Cliente.cadenaLlena(stringLlena));
    }

    @Test
    public void testCadenaLlenaSinTexto()
    {
        //arrange
        String stringVacia;

        //act
        stringVacia = "";

        //assert
        assertFalse(Cliente.cadenaLlena(stringVacia));
    }

    @Test
    public void testCadenaLlenaNula()
    {
        //arrange
        String stringNula;

        //act
        stringNula = null;

        //assert
        assertFalse(Cliente.cadenaLlena(stringNula));
        System.out.println(c1.toString());
    }
}
