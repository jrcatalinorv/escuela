package app.com.universidadanrdoidjr.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import app.com.universidadanrdoidjr.entidad.Carrera;
import app.com.universidadanrdoidjr.entidad.Materia;

public class CarreraRepositorioDbImpl implements CarreraRepositorio {

    private static final String TABLE = "carreras";
    private Dbconexion dbconexion;
    private Context context;

    public CarreraRepositorioDbImpl() {
    }


    public CarreraRepositorioDbImpl(Context context) {
        this.dbconexion = new Dbconexion(context);
        this.context = context;
    }

    @Override
    public void Crear(Carrera carrera) {
        ContentValues cv = new ContentValues();
        cv.put("nombre_carrera",carrera.getNombre_carrera());

        SQLiteDatabase db =  dbconexion.getWritableDatabase();
        long eletment = db.insert(TABLE,null,cv);

        if(eletment<=0){
            /* El insert ha fallado  */
            Toast toast;
            toast = Toast.makeText(context.getApplicationContext(), "Hubo un error! No se pudo guardar la carrera", Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
           // Log.i("Materia Rrpositorio ", "Ocurrio un error al crear Materia");

        }else{
            Toast toast;
            toast = Toast.makeText(context.getApplicationContext(), "La Carrera fue creada con exito", Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
        }
    }

    @Override
    public void Actualizar(Carrera carrera) {

    }

    @Override
    public void Borrar(Carrera carrera) {

    }

    @Override
    public Carrera Buscar(Integer id) {
        Carrera carrera = null;
        SQLiteDatabase db = dbconexion.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT nombre_carrera FROM carreras where id = "+id,null);
        if (c.moveToFirst()) {
            String StrCarrera = c.getString(c.getColumnIndex("nombre_carrera"));
            carrera = new Carrera();
            carrera.setNombre_carrera(StrCarrera);
            carrera.setId(id);
        }
        c.close();


        return carrera;
    }

    @Override
    public List<Carrera> Buscar() {
        List<Carrera> carreras = new ArrayList<>();
        SQLiteDatabase db = dbconexion.getReadableDatabase();
        Carrera carrera;

        Cursor c = db.query(TABLE,new String[]{"id","nombre_carrera" },
                null,
                null,
                null,
                null,
                null);

            while(c.moveToNext()){
                int id = c.getInt(c.getColumnIndex("id"));
                String nc = c.getString(c.getColumnIndex("nombre_carrera"));

                carrera = new Carrera();
                carrera.setId(id);
                carrera.setNombre_carrera(nc);
                carreras.add(carrera);
            }
            c.close();
            return carreras;
    }
}
