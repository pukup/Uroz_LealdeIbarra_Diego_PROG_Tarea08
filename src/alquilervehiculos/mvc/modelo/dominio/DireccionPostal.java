/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lol
 */
class DireccionPostal implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String calle, localidad, codigoPostal;

    public DireccionPostal(DireccionPostal direccionPostal)
    {
        calle = direccionPostal.getCalle();
        localidad = direccionPostal.getLocalidad();
        codigoPostal = direccionPostal.getCodigoPostal();
    }

    public DireccionPostal(String calle, String localidad, String codigoPostal)
    {
        setCalle(calle);
        setLocalidad(localidad);
        setCodigoPostal(codigoPostal);
    }

    private void setCalle(String calle)
    {
        if (cadenaLlena(calle))
        {
            this.calle = calle;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento calle vacío.\n");
        }
    }

    private void setLocalidad(String localidad)
    {
        if (cadenaLlena(localidad))
        {
            this.localidad = localidad;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento localidad vacío.\n");
        }
    }

    public static boolean cadenaLlena(String cadena)
    {
        return cadena != null && !cadena.equals("");
    }

    private void setCodigoPostal(String codigoPostal)
    {
        if (codigoPostalCorrecto(codigoPostal))
        {
            this.codigoPostal = codigoPostal;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento código postal incorrecto.\n");
        }
    }

    public static boolean codigoPostalCorrecto(String codigoPostal)
    {
        String patronCodigo = "[0-9]{5}";
        return comparadorPatron(patronCodigo, codigoPostal);
    }

    public static boolean comparadorPatron(String patron, String cadenaComparada)
    {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadenaComparada);
        return matcher.matches();
    }

    public String getCalle()
    {
        return calle;
    }

    public String getLocalidad()
    {
        return localidad;
    }

    public String getCodigoPostal()
    {
        return codigoPostal;
    }

    @Override
    public String toString()
    {
        return String.format(" Calle: %s%n Localidad: %s%n Código postal: %s%n", calle, localidad, codigoPostal);
    }
}
