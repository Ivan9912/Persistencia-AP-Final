package controlador;

import modelo.Tecnico;
import org.hibernate.Query;
import persistencia.ConfigHibernate;

public class GestorTecnico extends Gestor {
    public GestorTecnico() {
        sesion = ConfigHibernate.openSession();
    }

    public Tecnico getTecnicoXLegajo(Long legajo){
        try {

            Query consulta = sesion.createQuery("SELECT tecnico FROM Tecnico tecnico WHERE tecnico.legajo = :legajo");
            consulta.setParameter("legajo", legajo);

            Tecnico tecnico = (Tecnico) consulta.uniqueResult();
            return tecnico;

        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
}