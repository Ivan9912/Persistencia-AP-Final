package controlador;

import modelo.Especialidad;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.ConfigHibernate;
import java.util.List;

public class GestorEspecialidad extends Gestor {

    public GestorEspecialidad(){ sesion = ConfigHibernate.openSession();}
    public GestorEspecialidad(Session sesionParam){ sesion = sesionParam;}

    public int getListEspecialidades () {
        Query query = sesion.createQuery("FROM Especialidad ORDER BY denominacion DESC");
        List<Especialidad> especialidades = query.list();

        return especialidades.size();
    }
    public void getEspecialidadesList (){
        Query query = sesion.createQuery("FROM Especialidad ORDER BY denominacion DESC");
        List<Especialidad> especialidades = query.list();

        for (Especialidad especialidad : especialidades) {
            System.out.println(especialidad.getId() + " -" + especialidad.getDenominacion() + ".");
        }
    }
    public void addEspecialidades() {
        Transaction transaction = null;

        try {
            transaction = sesion.beginTransaction();

            addEspecialidad("Windows");
            addEspecialidad("Linux");
            addEspecialidad("Java");
            addEspecialidad("Hardware");
            addEspecialidad("Office");

            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    protected void addEspecialidad(String nombre) {
        Especialidad especialidad = new Especialidad();
        especialidad.setDenominacion(nombre);
        sesion.save(especialidad);
    }

    public Especialidad getEspecialidadXID( Long idEspecialidad){
        try {
            Query consulta = sesion.createQuery("From especialidad WHERE id = :idEspecialidad");
            consulta.setParameter("idEspecialidad", idEspecialidad);

            Especialidad especialidad = (Especialidad) consulta.uniqueResult();
            return especialidad;

        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
}