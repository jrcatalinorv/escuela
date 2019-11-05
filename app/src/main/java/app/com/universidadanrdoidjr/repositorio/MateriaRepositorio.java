package app.com.universidadanrdoidjr.repositorio;

import java.util.List;

import app.com.universidadanrdoidjr.entidad.Materia;

public interface MateriaRepositorio {

    void Crear(Materia materia);
    void Actualizar(Materia materia );
    void Borror (Materia materia);
    Materia Buscar(int id);
    List<Materia> buscar();

}
