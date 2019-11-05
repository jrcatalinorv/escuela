package app.com.universidadanrdoidjr.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.com.universidadanrdoidjr.entidad.Estudiante;

public class EstudianteRepositorioDbImpl implements EstudianteRepositorio {

    private static final String TABLE = "estudiantes";
    private Dbconexion dbconexion;
    private Context context;


    public EstudianteRepositorioDbImpl() {
    }

    public EstudianteRepositorioDbImpl(Context context) {
        this.dbconexion = new Dbconexion(context);
        this.context = context;
    }

    @Override
    public void crear(Estudiante estudiante) {

        ContentValues cv = new ContentValues();
        cv.put("matricula",estudiante.getMatricula());
        cv.put("nombre", estudiante.getNombre());
        cv.put("carrera_id",estudiante.getCarrera());

        SQLiteDatabase db =  dbconexion.getWritableDatabase();
        long eletment = db.insert(TABLE,null,cv);

        if(eletment<=0){
            Toast toast;
            toast = Toast.makeText(context.getApplicationContext(), "Hubo un error! No se pudo guardar el estudiante!!", Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
        }else{
            Toast toast;
            toast = Toast.makeText(context.getApplicationContext(), "El estuadiante fue almacenado con exito", Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
        }

    }

    @Override
    public void actualizar(Estudiante estudiante) {
        /* NO hay nada escrito aqui debajo */
    }

    @Override
    public void borrar(Estudiante estudiante) {

    }

    @Override
    public Estudiante buscar(int id) {
        return null;
    }

    @Override
    public List<Estudiante> buscar() {
        List<Estudiante> estudiantes = new ArrayList();
        SQLiteDatabase db = dbconexion.getReadableDatabase();

        /*
        Cursor c = db.query(TABLE,new String[]{"matricula","nombre","carrera_id"},

                null,
                null,
                null,
                null,
                null);
*/
        Cursor c = db.rawQuery("SELECT  e.matricula, e.nombre, c.nombre_carrera  from \n" +
                "estudiantes e INNER JOIN carreras c ON e.carrera_id = c.id",null);

        Estudiante est;

        while(c.moveToNext()){

            String matricula = c.getString(c.getColumnIndex("matricula"));
            String nombre = c.getString(c.getColumnIndex("nombre"));
            String carrera = c.getString(c.getColumnIndex("nombre_carrera"));

            est = new Estudiante();
            est.setMatricula(matricula);
            est.setNombre(nombre);
            est.setCarrera(carrera);
            estudiantes.add(est);
        }
        c.close();
        return  estudiantes;
    }
}
