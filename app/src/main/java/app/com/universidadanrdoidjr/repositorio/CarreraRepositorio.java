package app.com.universidadanrdoidjr.repositorio;

import java.util.List;

import app.com.universidadanrdoidjr.entidad.Carrera;

public interface CarreraRepositorio {

    void Crear(Carrera carrera);
    void Actualizar(Carrera carrera);
    void Borrar(Carrera carrera);
    Carrera Buscar(Integer id);
    List<Carrera> Buscar();

}
