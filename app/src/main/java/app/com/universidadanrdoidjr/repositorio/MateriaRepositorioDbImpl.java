package app.com.universidadanrdoidjr.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.com.universidadanrdoidjr.entidad.Materia;

public class MateriaRepositorioDbImpl implements MateriaRepositorio {


    private static final String TABLE = "materias";
    private Dbconexion dbconexion;
    private Context context;

    public MateriaRepositorioDbImpl() {
    }

    public MateriaRepositorioDbImpl(Context context) {
        this.dbconexion = new Dbconexion(context);
        this.context = context;
    }


    @Override
    public void Crear(Materia materia) {
        ContentValues cv = new ContentValues();
        cv.put("nombre_materia",materia.getNombre_materia());
        cv.put("creditos",materia.getCreditos());

        SQLiteDatabase db =  dbconexion.getWritableDatabase();
        long eletment = db.insert(TABLE,null,cv);

        if(eletment<=0){
            /* El insert ha fallado  */
            Toast toast;
            toast = Toast.makeText(context.getApplicationContext(), "Hubo un error! No se pudo guardar la Materia", Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
            Log.i("Materia Rrpositorio ", "Ocurrio un error al crear Materia");

        }else{
            Toast toast;
            toast = Toast.makeText(context.getApplicationContext(), "La Materia fue creada con exito", Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
        }
    }

    @Override
    public void Actualizar(Materia materia) {

    }

    @Override
    public void Borror(Materia materia) {

    }

    @Override
    public Materia Buscar(int id) {
        return null;
    }

    @Override
    public List<Materia> buscar() {
         List<Materia> materias = new ArrayList();
         SQLiteDatabase db = dbconexion.getReadableDatabase();
         Materia mat;

        Cursor c = db.query(TABLE,new String[]{"id","nombre_materia","creditos"},
                null,
                null,
                null,
                null,
                null);

        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String nm = c.getString(c.getColumnIndex("nombre_materia"));
            int cred = c.getInt(c.getColumnIndex("creditos"));

            mat = new Materia();
            mat.setId(id);
            mat.setNombre_materia(nm);
            mat.setCreditos(cred);
            materias.add(mat);
        }
        c.close();
        return materias;
    }
}
