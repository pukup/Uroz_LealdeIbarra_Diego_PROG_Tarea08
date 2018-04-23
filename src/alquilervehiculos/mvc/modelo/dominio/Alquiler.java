/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author lol
 * Dudo si el acceso a algunos métodos debería ser privado.
 */
public class Alquiler implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Date fechaInicioAlquiler, fechaFinAlquiler;
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private boolean alquilerAbierto;
    private final int MS_DIA = 1000 * 60 * 60 * 24;
    private static final double PRECIO_DIA = 30;
    private Vehiculo vehiculo;
    private Cliente cliente;

    public Alquiler(Alquiler alquiler)
    {
        alquilerAbierto = alquiler.getAlquilerAbierto();
        cliente = alquiler.getCliente();
        vehiculo = alquiler.getVehiculo();
        fechaInicioAlquiler = alquiler.getFechaInicioAlquiler();
    }

    public Alquiler(Cliente cliente, Vehiculo vehiculo)
    {
        if (vehiculo.getDisponible())
        {
            AlquilerAbierto(true);
            setCliente(cliente);
            setVehiculo(vehiculo);
            setFechaInicioALquiler();
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Vehiculo no disponible.\n");
        }
    }

    private void AlquilerAbierto(boolean abierto)
    {
        alquilerAbierto = abierto;
    }

    private void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
        cliente.setAlquilerVigente(true);
        
    }

    private void setVehiculo(Vehiculo vehiculo)
    {
        this.vehiculo = vehiculo;
        vehiculo.setDisponible(false);
    }

    private void setFechaInicioALquiler()
    {
        fechaInicioAlquiler = new Date();
    }

    public void close()
    {
        if (getAlquilerAbierto())
        {
            vehiculo.setDisponible(true);
            AlquilerAbierto(false);
            cliente.setAlquilerVigente(false);
            setFechaFinAlquiler();
        } else
        {
            throw new ExcepcionAlquilerVehiculos("El alquiler está cerrado.\n");
        }
    }

    private void setFechaFinAlquiler()
    {
        fechaFinAlquiler = new Date();
    }

    public double getPrecioSegunDias(int duracionAlquilerDias)
    {
        if (duracionAlquilerDias < 1)
        {
            return PRECIO_DIA + vehiculo.getPrecioEspecifico();
        } else
        {
            return PRECIO_DIA * duracionAlquilerDias + vehiculo.getPrecioEspecifico();
        }
    }
    
        public static double getPrecioSegunDias(int duracionAlquilerDias, Vehiculo vehiculo)
    {
            return PRECIO_DIA * duracionAlquilerDias + vehiculo.getPrecioEspecifico();
    }

    public int getDuracionAlquiler()
    {
        if (!alquilerAbierto)
        {
            long duracionAlquilerMS = getFechaFinAlquiler().getTime() - getFechaInicioAlquiler().getTime();
            long duracionAlquilerDias = duracionAlquilerMS / MS_DIA;
            return (int) duracionAlquilerDias;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Primero debe cerrar el alquiler.\n");
        }

    }

    public boolean getAlquilerAbierto()
    {
        return alquilerAbierto;
    }

    public Cliente getCliente()
    {
        return new Cliente(cliente);
    }

    public Vehiculo getVehiculo()
    {
        return vehiculo;
    }

    public Date getFechaInicioAlquiler()
    {
        return fechaInicioAlquiler;
    }

    public Date getFechaFinAlquiler()
    {
        if (alquilerAbierto)
        {
            System.out.print("Hasta no cerrar el alquiler la fecha será: ");
            return fechaFinAlquiler; //null
        } else
        {
            return fechaFinAlquiler;
        }
    }

    @Override
    public String toString()
    {
        if (alquilerAbierto) //Sin fecha de fin de alquiler.
        {
            return String.format("ALQUILER %s%n Fecha inicio: %s%n Vehículo: %s%n Cliente: %s%n Fecha fin: El alquiler sigue vigente.%n", getEstadoAlquilerString(), fechaInicioAlquiler.toString(), vehiculo.getMatricula(), cliente.getDni());
        } else              //Con fecha de fin de alquiler.
        {
            return String.format("ALQUILER %s%n Fecha inicio: %s%n Vehículo: %s%n Cliente: %s%n Fecha fin: %s%n", getEstadoAlquilerString(), fechaInicioAlquiler.toString(), vehiculo.getMatricula(), cliente.getDni(), getFechaFinAlquiler().toString());
        }

    }

    public String getEstadoAlquilerString()
    {
        String estadoAlquiler = alquilerAbierto ? "ABIERTO" : "CERRADO";
        return estadoAlquiler;
    }

}
