package app.com.universidadanrdoidjr.entidad;

public class Carrera {

    private String nombre_carrera;
    private Integer id;

    public Carrera() {
    }

    public Carrera(String nombre_carrera, Integer id) {
        this.nombre_carrera = nombre_carrera;
        this.id = id;
    }


    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre_carrera;
    }

}
