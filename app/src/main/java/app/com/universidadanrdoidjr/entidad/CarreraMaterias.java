package app.com.universidadanrdoidjr.entidad;

public class CarreraMaterias {

    private Integer carrera_id, materia_id;

    public CarreraMaterias() {
    }

    public CarreraMaterias(Integer carrera_id, Integer materia_id) {
        this.carrera_id = carrera_id;
        this.materia_id = materia_id;
    }

    public Integer getCarrera_id() {
        return carrera_id;
    }

    public void setCarrera_id(Integer carrera_id) {
        this.carrera_id = carrera_id;
    }

    public Integer getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(Integer materia_id) {
        this.materia_id = materia_id;
    }
}
