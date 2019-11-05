package app.com.universidadanrdoidjr.repositorio;

import java.util.List;

import app.com.universidadanrdoidjr.entidad.Estudiante;

public interface EstudianteRepositorio {

    void  crear(Estudiante estudiante);
    void actualizar(Estudiante estudiante);
    void borrar(Estudiante estudiante);
    Estudiante buscar (int id);
    List<Estudiante> buscar();
}
