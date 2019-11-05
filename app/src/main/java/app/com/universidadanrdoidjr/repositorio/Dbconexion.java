package app.com.universidadanrdoidjr.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbconexion  extends SQLiteOpenHelper {

    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "tech_android_university";

    public Dbconexion(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS estudiantes(matricula TEXT PRIMARY KEY, nombre TEXT, carrera_id INTEGER )");
        db.execSQL("CREATE TABLE IF NOT EXISTS carreras(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nombre_carrera TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS materias(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nombre_materia TEXT NOT NULL, creditos INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS carrera_materia(carrera_id INTEGER NOT NULL, materia_id INTEGER NOT NULL, FOREIGN KEY(\"carrera_id\") REFERENCES \"carrera\"(\"id\"))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1){
                /* nada escrito en esta parte del codigo */
        }
    }
}
