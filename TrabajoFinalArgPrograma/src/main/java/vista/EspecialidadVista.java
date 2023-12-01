package vista;

import controlador.GestorEspecialidad;
import modelo.Especialidad;
import modelo.Tecnico;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EspecialidadVista {
    public void cargarNuevaEspecialidadTecnico(Tecnico tecnico, Session sesion) throws Exception  {
        GestorEspecialidad gEspecialidad = new GestorEspecialidad(sesion);

        System.out.println("Lista de Especialidades");
        List<Especialidad> especialidades =  gEspecialidad.listar(Especialidad.class);
        for(Especialidad esp : especialidades){
            System.out.println( esp.getId() + " " + esp.getDenominacion());
        }
        List<Long> idEspecialidades = new ArrayList<Long>();

        select_especialidad:
        while(true){
            System.out.println("Seleccione una Especialidad para asignarle al técnico en cuesion.");
            Long idTecnico = new Scanner(System.in).nextLong();

            if(idEspecialidades.contains(idTecnico)){
                System.out.println("La Especialidad ya está asignada.");
                continue select_especialidad;
            }
            idEspecialidades.add(idTecnico);

            Especialidad especialidad = (Especialidad) gEspecialidad.buscarPorId(Especialidad.class, idTecnico);

            if(especialidad != null){
                tecnico.addEspecialidad(especialidad);

            }else {
                System.out.println("Legajo Inexistente. \nPruebe de nuevo.");
                System.out.println("La especialidad " + especialidad.getDenominacion() + " fue agregado.");
            }

            System.out.println("¿Quiere agregar alguna otra especialidad des la lista? S/N");

            String continuar = new Scanner(System.in).nextLine();
            if(!continuar.toUpperCase().equals("S")){
                break select_especialidad;
            }
        }
    }
}
