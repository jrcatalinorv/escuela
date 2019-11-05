package app.com.universidadanrdoidjr.repositorio;

import android.content.Context;

import java.util.List;

import app.com.universidadanrdoidjr.entidad.CarreraMaterias;

public class CarreraMateriasRepositorioDbImpl implements CarreraMateriasRepositorio {

    private static final String TABLE = "carrera_materia";
    private Dbconexion dbConexion;
    private Context context;

    public CarreraMateriasRepositorioDbImpl() {
    }

    public CarreraMateriasRepositorioDbImpl(Context context) {
        this.dbConexion = dbConexion;
        this.context = context;
    }

    @Override
    public void Crear(CarreraMaterias carrera_materias) {

    }

    @Override
    public void Actualizar(CarreraMaterias carrera_materias) {

    }

    @Override
    public void Borrar(CarreraMaterias carrera_materias) {

    }

    @Override
    public CarreraMaterias Buscar(int id_carrera, int id_materia) {
        return null;
    }

    @Override
    public List<CarreraMaterias> Buscar() {
        return null;
    }
}
