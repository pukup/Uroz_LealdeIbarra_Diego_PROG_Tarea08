/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

;

/**
 *
 * @author lol
 */
public class Cliente implements Serializable
{

    private final static long serialVersionUID = 1L;
    private String nombre, dni;
    private DireccionPostal direccionPostal;
    private boolean alquilerVigente;
    private int identificador;
    public static int ultimoIdentificador = 0;

    public Cliente(Cliente cliente)
    {
        nombre = cliente.getNombre();
        dni = cliente.getDni();
        direccionPostal = cliente.getDireccionPostal();
        identificador = cliente.getIdentificador();
    }

    public Cliente(String nombre, String dni, String calle, String localidad, String codigoPostal)
    {
        setNombre(nombre);
        setDni(dni);
        setDireccionPostal(calle, localidad, codigoPostal);
        setIdentificador();
    }

    private void setDni(String dni)
    {
        if (formatoDniCorrecto(dni))
        {
            this.dni = dni;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento dni incorrecto.\n");
        }
    }

    public static boolean formatoDniCorrecto(String dni)
    {
        String patronDni = "[0-9]{8}[A-Z]";
        return comparadorPatron(patronDni, dni);
    }

    public static boolean comparadorPatron(String patron, String cadenaComparada)
    {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadenaComparada);
        return matcher.matches();
    }

    private void setNombre(String nombre)
    {
        if (cadenaLlena(nombre))
        {
            this.nombre = nombre;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento nombre vacío.\n");
        }
    }

    public static boolean cadenaLlena(String string)
    {
        return string != null && !string.equals("");
    }

    private void setDireccionPostal(String calle, String localidad, String codigoPostal)
    {
        direccionPostal = new DireccionPostal(calle, localidad, codigoPostal);
    }

    private void setIdentificador()
    {
        aumentarUltimoIdentificador();
        this.identificador = ultimoIdentificador;
    }

    public static void aumentarUltimoIdentificador()
    {
        ultimoIdentificador++;
    }
    
    public void setAlquilerVigente(boolean vigente)
    {
        alquilerVigente = vigente;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getDni()
    {
        return dni;
    }

    public DireccionPostal getDireccionPostal()
    {
        return new DireccionPostal(direccionPostal);
    }

    public int getIdentificador()
    {
        return identificador;
    }
    
    public boolean getAlquilerVigente()
    {
        return alquilerVigente;
    }

    @Override
    public String toString()
    {
        return String.format("CLIENTE %d%n Nombre: %s%n DNI: %s%n%s", identificador, nombre, dni, direccionPostal.toString());
    }
}
