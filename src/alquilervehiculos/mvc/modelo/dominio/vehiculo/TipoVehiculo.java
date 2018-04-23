/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author lol
 */
public enum TipoVehiculo
{
    TURISMO("Turismo")
    {
        @Override
        public Turismo getInstancia(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma)
        {
            return new Turismo(matricula, marca, modelo, cilindrada, numeroPlazas, pma);
        }
    },
    DE_CARGA("DeCarga")
    {
        @Override
        public DeCarga getInstancia(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma)
        {
            return new DeCarga(matricula, marca, modelo, cilindrada, numeroPlazas, pma);
        }
    },
    AUTOBUS("Autobus")
    {

        public Autobus getInstancia(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma)
        {
            return new Autobus(matricula, marca, modelo, cilindrada, numeroPlazas, pma);
        }
    };

    private String tipoVehiculo;

    private TipoVehiculo(String tipoVehiculo)
    {
        this.tipoVehiculo = tipoVehiculo;
    }

    public abstract Vehiculo getInstancia(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma);

    public static TipoVehiculo getTipoVehiculoSegunOrdinal(int ordinal)
    {
        if (ordinalValido(ordinal))
        {
            return values()[ordinal];
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Tipo de vehículo inexsistente.\n");
        }
    }

    public static boolean ordinalValido(int ordinal)
    {
        return (ordinal >= 0 && ordinal < values().length);
    }

    public String toString()
    {
        return tipoVehiculo;
    }
}
