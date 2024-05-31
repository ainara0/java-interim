abstract class Persona {
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private static int contador;

    public Persona(String nombre, String primerApellido, String segundoApellido) {
        this.id = contador;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        contador++;
    }
    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                '}';
    }
    public int getId() {
        return id;
    }
}
