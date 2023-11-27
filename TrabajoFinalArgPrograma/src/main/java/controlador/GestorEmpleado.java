package controlador;

import modelo.Empleado;
import org.hibernate.Query;
import persistencia.ConfigHibernate;

public class GestorEmpleado extends Gestor {
    public GestorEmpleado() {
        sesion = ConfigHibernate.openSession();
    }

    public Empleado getEmpleadoXLegajo(Long legajo){
        try {

            Query consulta = sesion.createQuery("SELECT tecnico FROM Tecnico tecnico WHERE tecnico.legajo = :legajo");
            consulta.setParameter("legajo", legajo);

            Empleado empleado = (Empleado) consulta.uniqueResult();
            return empleado;

        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
}