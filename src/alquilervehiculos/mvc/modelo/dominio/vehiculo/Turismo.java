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
public class Turismo extends Vehiculo
{

    private static final long serialVersionUID = 1L;

    public Turismo(Vehiculo vehiculo)
    {
        super(vehiculo);
    }

    public Turismo(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma)
    {
        super(matricula, marca, modelo, cilindrada, numeroPlazas, pma);
    }

    public TipoVehiculo getTipoVehiculo()
    {
        return TipoVehiculo.TURISMO;
    }

    public double getPrecioEspecifico()
    {
        return getDatosTecnicos().getCilindrada() / FACTOR_CILINDRADA;
    }
}
