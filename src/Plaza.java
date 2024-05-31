import java.util.ArrayList;
import java.util.Collections;

public class Plaza implements Comparable<Plaza>{
    public enum TipoDePlaza {
        S,D
    }
    private int id;
    private String nombre;
    private TipoDePlaza tipoDePlaza;
    private static int contador;
    private boolean adjudicada;
    private Persona persona;
    private static ArrayList<Plaza> plazas = new ArrayList<Plaza>();

    public Plaza(String nombre, TipoDePlaza tipoDePlaza) {
        this.id = contador;
        this.nombre = nombre;
        this.tipoDePlaza = tipoDePlaza;
        this.adjudicada = false;
        plazas.add(this);
        contador++;
    }
    @Override
    public String toString() {
        return "Plaza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoDePlaza=" + tipoDePlaza +
                ", adjudicada=" + adjudicada +
                ", persona=" + persona +
                '}';
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public TipoDePlaza getTipoDePlaza() {
        return tipoDePlaza;
    }
    public Persona getPersona() {
        return persona;
    }
    public static ArrayList<Plaza> getPlazas() {
        return plazas;
    }
    public static ArrayList<Plaza> getPlazasOrdenadas() {
        ArrayList<Plaza> plazas = new ArrayList<Plaza>(Plaza.plazas);
        Collections.sort(plazas);
        return(plazas);
    }
    public boolean isAdjudicada() {
        return adjudicada;
    }
    public void adjudicar(Persona persona) {
        this.persona = persona;
        this.adjudicada = true;
    }
    public int compareTo(Plaza otraPlaza) {
        return (this.tipoDePlaza == TipoDePlaza.S ? 1 : otraPlaza.tipoDePlaza == TipoDePlaza.S ? -1 : 0);
    }
    public static String getAdjudicacionesOrdenadas() {
        ArrayList<Plaza> adjudicaciones = getPlazasOrdenadas();
        StringBuilder s = new StringBuilder();
        for (Plaza plaza : adjudicaciones) {
            s.append(
                    plaza.id + " (" +
                    plaza.nombre + "): " +
                    plaza.persona.getId() + "\n"
            );
        }
        return s.toString();
    }
}
