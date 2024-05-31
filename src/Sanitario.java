import java.util.Comparator;

public class Sanitario extends Persona implements Comparable<Sanitario> {
    private String specialidad;
    private int diasTrabajados;

    public Sanitario(String nombre, String primerApellido, String segundoApellido, String specialidad, int diasTrabajados) {
        super(nombre, primerApellido, segundoApellido);
        this.specialidad = specialidad;
        this.diasTrabajados = diasTrabajados;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", specialidad='" + specialidad + '\'' +
                ", diasTrabajados=" + diasTrabajados +
                "} ";
    }
    public int compareTo(Sanitario otroSanitario) {
        return Integer.compare(this.diasTrabajados, otroSanitario.diasTrabajados);
    }
}
