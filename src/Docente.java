import java.util.Comparator;

public class Docente extends Persona implements Comparable<Docente> {
    private String titulacion;
    private double puntos;

    public Docente(String nombre, String primerApellido, String segundoApellido, String titulacion, double puntos) {
        super(nombre, primerApellido, segundoApellido);
        this.titulacion = titulacion;
        this.puntos = puntos;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", titulacion='" + titulacion + '\'' +
                ", puntos=" + puntos +
                "} ";
    }
    public int compareTo(Docente otroDocente) {
        return Double.compare(this.puntos, otroDocente.puntos);
    }
}
