package app.com.universidadanrdoidjr.entidad;

public class Materia {

    private Integer id, creditos;
    private String nombre_materia;

    public Materia() {
    }

    public Materia(Integer id, Integer creditos, String nombre_materia) {
        this.id = id;
        this.creditos = creditos;
        this.nombre_materia = nombre_materia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    @Override
    public String toString() {
        return nombre_materia;
    }

}
