package app.com.universidadanrdoidjr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.com.universidadanrdoidjr.entidad.Materia;
import app.com.universidadanrdoidjr.repositorio.MateriaRepositorio;
import app.com.universidadanrdoidjr.repositorio.MateriaRepositorioDbImpl;

public class FormularioMateria extends AppCompatActivity {

    private Button cancelar, nuevo;
    private EditText et_materia, et_creditos;
    MateriaRepositorio materiaRepositorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_materia);

        materiaRepositorio = new MateriaRepositorioDbImpl(this.getBaseContext());
        cancelar = findViewById(R.id.fm_cancelar);
        nuevo = findViewById(R.id.fm_nuevo);
        et_materia = findViewById(R.id.et_nombre_materia);
        et_creditos = findViewById(R.id.et_creditos_materia);


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolverListaMaterias();
            }
        });

        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Materia nueva_materia = new Materia();
                nueva_materia.setNombre_materia(et_materia.getText().toString());
                nueva_materia.setCreditos(Integer.valueOf(et_creditos.getText().toString()));
                materiaRepositorio.Crear(nueva_materia);

                et_materia.setText("");
                et_creditos.setText("");

            }
        });



    }


    public void  VolverListaMaterias(){
        Intent intent = new Intent(this, ListaMaterias.class);
        startActivity(intent);
    }

}
