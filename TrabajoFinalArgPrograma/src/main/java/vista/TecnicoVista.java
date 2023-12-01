package vista;

import java.util.Scanner;

import modelo.Tecnico;
import modelo.DatosContacto;
public class TecnicoVista {

    public Tecnico cargarTecnicoNuevo(Tecnico tecnico, Long legajo){

        infoTecnico(tecnico, legajo);

        return tecnico;
    }

    public Tecnico modificarTecnico(Tecnico tecnico, Long legajo){
        infoTecnico(tecnico, legajo);

        return tecnico;
    }

    public Tecnico infoTecnico (Tecnico tecnico, Long legajo){
        System.out.println("Ingrese el Legajo del Técnico: ");
        tecnico.setLegajo(legajo);
        System.out.println("Ingrese el Nombre del Técnico: ");
        tecnico.setNombre(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el Apellido del Técnico: ");
        tecnico.setApellido(new Scanner(System.in).nextLine());

        DatosContacto datosContacto = tecnico.getDatosContacto();

        System.out.println("Ingrese el celular del Técnico: ");
        datosContacto.setCelular(new Scanner(System.in).nextLong());
        System.out.println("Ingrese el Email del Técnica: ");
        datosContacto.setEmail(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el telefono del Técnica: ");
        datosContacto.setTelefono(new Scanner(System.in).nextLong());

        tecnico.setDatosContacto(datosContacto);

        return tecnico;
    }
}