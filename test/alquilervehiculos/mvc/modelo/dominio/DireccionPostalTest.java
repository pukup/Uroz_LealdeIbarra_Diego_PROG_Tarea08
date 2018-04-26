/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.DireccionPostal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lol
 */
public class DireccionPostalTest
{

    public DireccionPostal d1;

    public DireccionPostalTest()
    {
        d1 = new DireccionPostal("calle", "localidad", "00000");
    }

    @Test
    public void testConstructor()
    {
        //arrange        
        //act
        //assert
        assertNotNull(d1);
    }

    @Test
    public void testConstructorCopia()
    {
        //arrange        
        DireccionPostal d2;
        //act
        d2 = new DireccionPostal(d1);
        //assert
        assertNotNull(d2);
        System.out.println(d2);
    }

    @Test
    public void testConstructorTrampa()
    {
        //arrange        
        System.out.println("Excepción constructor vacio: ");
        //act
        try
        {
            d1 = new DireccionPostal("", "", "");
            fail("Excepción no lanzada.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }

        //assert
        assertNotNull(d1);
    }

    @Test
    public void testCadenaLlenaConTexto()
    {
        //arrange
        String stringLlena;

        //act
        stringLlena = "Llena";

        //assert
        assertTrue(DireccionPostal.cadenaLlena(stringLlena));
    }

    @Test
    public void testCadenaLlenaSinTexto()
    {
        //arrange
        String stringVacia;

        //act
        stringVacia = "";

        //assert
        assertFalse(DireccionPostal.cadenaLlena(stringVacia));
    }

    @Test
    public void testCadenaLlenaNula()
    {
        //arrange
        String stringNula;

        //act
        stringNula = null;

        //assert
        assertFalse(DireccionPostal.cadenaLlena(stringNula));
    }

    @Test
    public void testFormatoCodigoPostalCorrecto()
    {
        //arrange
        String codigoPostal;

        //act
        codigoPostal = "00000";

        //assert
        assertTrue(DireccionPostal.codigoPostalCorrecto(codigoPostal));

    }

    @Test
    public void testFormatoCodigoPostalIncorrecto()
    {
        //arrange
        String codigoPostal;

        //act
        codigoPostal = "00 000";

        //assert
        assertFalse(DireccionPostal.codigoPostalCorrecto(codigoPostal));

    }

    @Test
    public void testToString()
    {
        //arrange
        String cadenaDireccion;

        //act
        cadenaDireccion = " Calle: calle\n Localidad: localidad\n Código postal: 00000\n";

        //assaert        
        assertEquals(cadenaDireccion, d1.toString());
    }
}
