/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import java.io.Serializable;

/**
 *
 * @author lol
 */
public class DeCarga extends Vehiculo
{

    public DeCarga(Vehiculo vehiculo)
    {
        super(vehiculo);
    }

    public DeCarga(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma)
    {
        super(matricula, marca, modelo, cilindrada, numeroPlazas, pma);
    }

    public TipoVehiculo getTipoVehiculo()
    {
        return TipoVehiculo.DE_CARGA;
    }

    public double getPrecioEspecifico()
    {
        return getDatosTecnicos().getPma() / FACTOR_PMA;
    }
}
