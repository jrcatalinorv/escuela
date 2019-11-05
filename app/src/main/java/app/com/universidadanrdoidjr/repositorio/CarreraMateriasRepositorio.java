package app.com.universidadanrdoidjr.repositorio;

import java.util.List;

import app.com.universidadanrdoidjr.entidad.CarreraMaterias;

public interface CarreraMateriasRepositorio {

    void Crear(CarreraMaterias carrera_materias);
    void Actualizar(CarreraMaterias carrera_materias);
    void Borrar(CarreraMaterias carrera_materias);
    CarreraMaterias Buscar(int id_carrera, int id_materia);
    List<CarreraMaterias> Buscar();


}
