import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public interface Metodos {
    public static void adjudicarPlazas(HashSet<Persona> personas, ArrayList<Plaza> plazas) {
        ArrayList<Sanitario> sanitarios = new ArrayList<Sanitario>();
        ArrayList<Docente> docentes = new ArrayList<Docente>();
        for (Persona persona : personas) {
            if (persona instanceof Sanitario) {
                sanitarios.add((Sanitario) persona);
            } else {
                docentes.add((Docente) persona);
            }
        }
        Collections.sort(sanitarios);
        Collections.sort(docentes);
        for (Plaza plaza : plazas) {
            if (!plaza.isAdjudicada()) {
                if (plaza.getTipoDePlaza() == Plaza.TipoDePlaza.S && !sanitarios.isEmpty()) {
                    plaza.adjudicar(sanitarios.get(0));
                    sanitarios.remove(0);
                } else {
                    plaza.adjudicar(docentes.get(0));
                    docentes.remove(0);
                }
            }
        }
    }

    public static Object[] generacionDeDatos(int cantidad) {
        HashSet<Persona> personas = new HashSet<Persona>();
        ArrayList<Plaza> plazas = new ArrayList<Plaza>();
        for (int i = 0; i < cantidad; i ++) {
            personas.add(new Sanitario(
                    "Nombre " + Integer.toString((int)(Math.random() * 100)),
                    "Primer apellido " + Integer.toString((int)(Math.random() * 100)),
                    "Segundo apellido " + Integer.toString((int)(Math.random() * 100)),
                    "Especialidad " + Integer.toString((int)(Math.random() * 100)),
                    i));
            personas.add(new Docente(
                    "Nombre " + Integer.toString((int)(Math.random() * 100)),
                    "Primer apellido " + Integer.toString((int)(Math.random() * 100)),
                    "Segundo apellido " + Integer.toString((int)(Math.random() * 100)),
                    "Titulacion " + Integer.toString((int)(Math.random() * 100)),
                    i));
            plazas.add(new Plaza("Nombre " + Integer.toString(i),
                    (((int)(Math.random() * 2)) < 1 ? Plaza.TipoDePlaza.S : Plaza.TipoDePlaza.D)));
        }
        return new Object[]{personas,plazas};
    }
    public static void simularAdjudicacion(int cantidad) {
        Object[] datos = generacionDeDatos(cantidad);
        adjudicarPlazas((HashSet)datos[0],(ArrayList)datos[1]);
    }

}
