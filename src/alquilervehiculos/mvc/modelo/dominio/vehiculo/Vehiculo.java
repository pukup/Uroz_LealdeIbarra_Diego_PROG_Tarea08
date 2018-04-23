/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author lol Las subclases implementan la interface Serializable por defecto
 * pero el atributo serialVersionUID si debe definirse en cada subclase.
 */
public abstract class Vehiculo implements Serializable
{

    private final static long serialVersionUID = 1L;
    private String matricula, marca, modelo;
    private DatosTecnicos datosTecnicos;
    private boolean disponible;
    protected final double FACTOR_CILINDRADA = 50;
    protected final double FACTOR_NUMERO_PLAZAS = 1;
    protected final double FACTOR_PMA = 20;

    public abstract TipoVehiculo getTipoVehiculo();

    public abstract double getPrecioEspecifico();

    public Vehiculo(Vehiculo vehiculo)
    {
        matricula = getMatricula();
        marca = getMarca();
        modelo = getModelo();
        datosTecnicos = getDatosTecnicos();
        disponible = getDisponible();
    }

    public Vehiculo(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma)
    {
        setMatricula(matricula);
        setMarca(marca);
        setModelo(modelo);
        setDatosTecnicos(cilindrada, numeroPlazas, pma);
        setDisponible(true);
    }

    private void setMatricula(String matricula)
    {
        if (compruebaMatricula(matricula))
        {
            this.matricula = matricula;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento matrícula incorrecto.\n");
        }
    }

    public static boolean compruebaMatricula(String matricula)
    {
        String patronMatricula = "[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}";
        if (matricula == null)
        {
            return false;
        } else
        {
            return comparadorPatron(patronMatricula, matricula);
        }
    }

    public static boolean comparadorPatron(String patron, String cadenaComparada)
    {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadenaComparada);
        return matcher.matches();
    }

    private void setMarca(String marca)
    {
        if (cadenaLlena(marca))
        {
            this.marca = marca;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento marca incompleto.\n");
        }
    }

    private void setModelo(String modelo)
    {
        if (cadenaLlena(modelo))
        {
            this.modelo = modelo;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento modelo incompleto.\n");
        }
    }

    public static boolean cadenaLlena(String string)
    {
        return string != null && !string.equals("");
    }

    private void setDatosTecnicos(int cilindrada, int numeroPlazas, int pma)
    {
        this.datosTecnicos = new DatosTecnicos(cilindrada, numeroPlazas, pma);
    }

    public void setDisponible(boolean disponible)
    {
        this.disponible = disponible;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public String getMarca()
    {
        return marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    public DatosTecnicos getDatosTecnicos()
    {
        return datosTecnicos;
    }

    public boolean getDisponible()
    {
        return disponible;
    }

    @Override
    public String toString()
    {
        return String.format("Vehículo %s %s%n Marca: %s%n Modelo: %s%n %s ", matricula, getDisponibleToString(), marca, modelo, datosTecnicos);
    }

    public String getDisponibleToString()
    {
        String disponibilidad;
        return disponibilidad = (disponible) ? "DISPONIBLE." : "OCUPADO.";
    }
}
