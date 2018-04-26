/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.vista;

import alquilervehiculos.mvc.controlador.ControladorAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilervehiculos.mvc.vista.utilidades.Consola;

/**
 *
 * @author lol
 */
public class IUTextual implements IVistaAlquilerVehiculos
{

    ControladorAlquilerVehiculos controlador;

    public IUTextual()
    {
        Opcion.setVista(this);
    }

    @Override
    public void setControlador(ControladorAlquilerVehiculos controlador)
    {
        this.controlador = controlador;
    }

    @Override
    public void comenzar()
    {
        int ordinalOpcion;
        do
        {
            Consola.mostrarMenu();
            ordinalOpcion = Consola.elegirOpcion();
            Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
            opcion.ejecutar();
        } while (ordinalOpcion != Opcion.SALIR.ordinal());
    }

    @Override
    public void salir()
    {
        controlador.salir();
        System.out.println("Nos vemos en la tele.");
    }

    @Override

    public void abrirAlquiler()
    {
        Consola.mostrarCabecera("Abrir alquiler.");
        try
        {
            String matricula = Consola.leerMatricula();
            String dni = Consola.leerDni();
            Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
            Cliente cliente = controlador.buscarCliente(dni);
            if (vehiculo != null)
            {
                controlador.abrirAlquiler(cliente, vehiculo);
                System.out.println("Alquiler abierto.");
            } else
            {
                System.out.println("Vehículo no encontrado.");
            }
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void cerrarAlquiler()
    {
        Consola.mostrarCabecera("Cerrar alquiler.");
        try
        {
            String matricula = Consola.leerMatricula();
            Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
            if (vehiculo != null)
            {
                controlador.cerrarAlquiler(matricula);
                System.out.println("Alquiler cerrado.");
            } else
            {
                System.out.println("Vehículo no encontrado.");
            }
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void anadirCliente()
    {
        Consola.mostrarCabecera("Añadir cliente.");
        try
        {
            Cliente cliente = Consola.leerCliente();
            controlador.anadirCliente(cliente);
            System.out.println("Cliente añadido.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void anadirVehiculo()
    {
        Consola.mostrarCabecera("Añadir vehículo.");
        try
        {
            Vehiculo vehiculo = Consola.leerVehiculo();
            controlador.anadirVehiculo(vehiculo);
            System.out.println("Vehículo añadido.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void borrarCliente()
    {
        Consola.mostrarCabecera("Borrar cliente.");
        try
        {
            String dni = Consola.leerDni();
            controlador.borrarCliente(dni);
            System.out.println("Cliente eliminado.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void borrarVehiculo()
    {
        Consola.mostrarCabecera("Borrar vehículo.");
        try
        {
            String matricula = Consola.leerMatricula();
            controlador.borrarVehiculo(matricula);
            System.out.println("Vehículo eliminado.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void buscarCliente()
    {
        Consola.mostrarCabecera("Buscar cliente.");
        try
        {
            String dni = Consola.leerDni();
            Cliente cliente = controlador.buscarCliente(dni);
            String mensaje = (cliente != null) ? cliente.toString() : "Cliente no encontrado.";
            System.out.printf("%n%s%n", mensaje);
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void buscarVehiculo()
    {
        Consola.mostrarCabecera("Buscar vehículo.");
        try
        {
            String matricula = Consola.leerMatricula();
            Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
            String mensaje = (vehiculo != null) ? vehiculo.toString() : "Turismo no encontrado.";
            System.out.printf("%n%s%n", mensaje);
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void listarAlquileres()
    {
        Consola.mostrarCabecera("Listado de alquileres.");
        for (Alquiler alquiler : controlador.obtenerAlquileres())
        {
            if (alquiler != null)
            {
                System.out.println(alquiler);
            }
        }
        System.out.println("");
    }

    @Override
    public void listarAlquileresAbiertos()
    {
        Consola.mostrarCabecera("Alquileres abiertos.");
        for (Alquiler alquiler : controlador.obtenerAlquileresAbiertos())
        {
            System.out.println(alquiler);
        }
        System.out.println("");
    }

    @Override
    public void listarAlquileresCliente()
    {
        String dni = Consola.leerDni();
        Consola.mostrarCabecera("Alquileres de cliente.");
        try
        {
            for (Alquiler alquiler : controlador.obtenerAlquileresCliente(dni))
            {
                    System.out.println(alquiler);
            }
            System.out.println("");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }
    }
    
        @Override
    public void listarAlquileresVehiculo()
    {
        String matricula = Consola.leerMatricula();
        Consola.mostrarCabecera("Alquileres de vehículo.");
        try
        {
            for (Alquiler alquiler : controlador.obtenerAlquileresVehiculo(matricula))
            {
                    System.out.println(alquiler);
            }
            System.out.println("");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void listarClientes()
    {
        Consola.mostrarCabecera("Listado de clientes.");
        for (Cliente cliente : controlador.obtenerClientes())
        {
            if (cliente != null)
            {
                System.out.println(cliente);
            }
        }
        System.out.println("");
    }

    @Override
    public void listarVehiculos()
    {
        Consola.mostrarCabecera("Listado de Vehículos.");
        for (Vehiculo vehiculo : controlador.obtenerVehiculos())
        {
            if (vehiculo != null)
            {
                System.out.println(vehiculo);
            }
        }
        System.out.println("");
    }

}
