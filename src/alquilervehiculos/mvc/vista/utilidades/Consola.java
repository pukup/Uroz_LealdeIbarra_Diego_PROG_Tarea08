/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.vista.utilidades;

import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilervehiculos.mvc.vista.Opcion;

/**
 *
 * @author lol
 */
public class Consola {

    public static void mostrarMenu() {
        mostrarCabecera("Alquiler vehículos");
        for (Opcion value : Opcion.values()) {
            System.out.println(value);
        }
    }

    public static void mostrarCabecera(String mensaje) {
        System.out.printf("%n%s%n", mensaje);
        System.out.println(String.format("%0" + mensaje.length() + "d%n", 0).replace("0", "-"));
    }

    public static int elegirOpcion() {
        int ordinalOpcion;
        do {
            System.out.println("Elija una opción.");
            ordinalOpcion = Entrada.entero();
        } while (!Opcion.ordinalValido(ordinalOpcion));
        return ordinalOpcion;
    }

    public static Cliente leerCliente() {
        System.out.print("Nombre: ");
        String nombre = Entrada.cadena();
        System.out.print("Calle: ");
        String calle = Entrada.cadena();
        System.out.print("Localidad: ");
        String localidad = Entrada.cadena();
        System.out.print("Código postal: ");
        String codigoPostal = Entrada.cadena();
        System.out.print("DNI: ");
        String dni = Entrada.cadena();
        Cliente cliente = new Cliente(nombre, dni, calle, localidad, codigoPostal);
        return cliente;
    }

    public static String leerDni() {
        System.out.println("Introduzca DNI.");
        String dni = Entrada.cadena();
        return dni;
    }

    public static Vehiculo leerVehiculo() {
        Vehiculo vehiculo = null;
        int ordinalTipoVehiculo = elegirTipoVehiculo();
        System.out.print("Matrícula: ");
        String matricula = Entrada.cadena();
        System.out.print("Marca: ");
        String marca = Entrada.cadena();
        System.out.print("Modelo: ");
        String modelo = Entrada.cadena();
        System.out.print("Cilindrada: ");
        int cilindrada = Entrada.entero();
        System.out.print("Número de plazas: ");
        int numeroPlazas = Entrada.entero();
        System.out.print("PMA: ");
        int pma = Entrada.entero();
        vehiculo = TipoVehiculo.getTipoVehiculoSegunOrdinal(ordinalTipoVehiculo).getInstancia(matricula, marca, modelo, cilindrada, numeroPlazas, pma);
        return vehiculo;
    }

    private static int elegirTipoVehiculo() {
        int ordinalTipoVehiculo;
        do {
            System.out.printf("Tipo vehículo: %s", obtenerTiposVehiculo());
            ordinalTipoVehiculo = Entrada.entero();
        } while (!TipoVehiculo.ordinalValido(ordinalTipoVehiculo));
        return ordinalTipoVehiculo;
    }

    private static String obtenerTiposVehiculo() {
        StringBuilder TiposVehiculos = new StringBuilder("");
        for (TipoVehiculo tipoVechiculo : TipoVehiculo.values()) {
            TiposVehiculos.append(tipoVechiculo.ordinal()).append(".- ").append(tipoVechiculo).append(" ");
        }
        return TiposVehiculos.toString();
    }

    public static String leerMatricula() {
        System.out.println("Introduzca Matrícula.");
        String matricula = Entrada.cadena();
        return matricula;
    }

}
