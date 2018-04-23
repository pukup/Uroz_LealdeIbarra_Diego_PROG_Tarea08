/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import java.io.Serializable;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author lol
 */
class DatosTecnicos implements Serializable
{

    private final static long serialVersionUID = 1L;
    private int cilindrada, numeroPlazas, pma;

    public DatosTecnicos(DatosTecnicos datosTecnicos)
    {
        cilindrada = datosTecnicos.getCilindrada();
        numeroPlazas = datosTecnicos.getNumeroPlazas();
        pma = datosTecnicos.getPma();
    }

    public DatosTecnicos(int cilindrada, int numeroPlazas, int pma)
    {
        setCilindrada(cilindrada);
        setNumeroPlazas(numeroPlazas);
        setPma(pma);
    }

    private void setCilindrada(int cilindrada)
    {
        if (datoValido(cilindrada))
        {
            this.cilindrada = cilindrada;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento cilindrada debe superar cero.\n");
        }
    }

    private void setNumeroPlazas(int numeroPlazas)
    {
        if (datoValido(numeroPlazas))
        {
            this.numeroPlazas = numeroPlazas;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento número de plazas debe superar cero.\n");
        }
    }

    private void setPma(int pma)
    {
        if (datoValido(pma))
        {
            this.pma = pma;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Argumento peso máximo autorizado debe superar cero.\n");
        }
    }

    public static boolean datoValido(int dato)
    {
        return dato > 0;
    }

    public int getCilindrada()
    {
        return cilindrada;
    }

    public int getNumeroPlazas()
    {
        return numeroPlazas;
    }

    public int getPma()
    {
        return pma;
    }

    @Override
    public String toString()
    {
        return String.format("Cilindrada: %d%n Número de plazas: %d%n Peso máximo autorizado: %d%n", cilindrada, numeroPlazas, pma);
    }
}
