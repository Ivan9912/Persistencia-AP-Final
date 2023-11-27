package vista;

import java.util.Scanner;

import modelo.Empleado;
import modelo.DatosContacto;
public class EmpleadoVista {

    public Empleado cargarEmpleadoNuevo(){
        Empleado empleado = new Empleado();

        infoEmpleado(empleado);

        return empleado;
    }

    public Empleado modificarEmpleado(Empleado empleado){
        infoEmpleado(empleado);

        return empleado;
    }

    public Empleado infoEmpleado (Empleado empleado){
        System.out.println("Ingrese el Legajo del Técnico: ");
        empleado.setLegajo(new Scanner(System.in).nextLong());
        System.out.println("Ingrese el Nombre del Técnico: ");
        empleado.setNombre(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el Apellido del Técnico: ");
        empleado.setNombre(new Scanner(System.in).nextLine());

        DatosContacto datosContacto = empleado.getDatosContacto();

        System.out.println("Ingrese el celular del Técnico: ");
        datosContacto.setCelular(new Scanner(System.in).nextLong());
        System.out.println("Ingrese el Email del Técnica: ");
        datosContacto.setEmail(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el telefono del Técnica: ");
        datosContacto.setTelefono(new Scanner(System.in).nextLong());

        empleado.setDatosContacto(datosContacto);

        return empleado;
    }
}