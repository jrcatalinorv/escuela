package app.com.universidadanrdoidjr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import app.com.universidadanrdoidjr.adaptadores.AdaptadorMateria;
import app.com.universidadanrdoidjr.entidad.Materia;
import app.com.universidadanrdoidjr.repositorio.MateriaRepositorio;
import app.com.universidadanrdoidjr.repositorio.MateriaRepositorioDbImpl;

public class ListaMaterias extends AppCompatActivity {

    private Button cancelar, nuevo;
    private RecyclerView rv_materias;
    private AdaptadorMateria adaptadorMateria;
    private List<Materia> materias;
    private MateriaRepositorio materiaRepositorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_materias);

        cancelar = findViewById(R.id.mat_cancelar);
        nuevo = findViewById(R.id.mat_nuevo);
        rv_materias = findViewById(R.id.rv_materiasLista);
        materiaRepositorio = new MateriaRepositorioDbImpl(getBaseContext());

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inicio();
            }
        });
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormularioNuevaMateria();
            }
        });

        /* inicia con el llenado de la lista de materias */
        materias = materiaRepositorio.buscar();

        rv_materias.setLayoutManager(new LinearLayoutManager(this));
        adaptadorMateria = new AdaptadorMateria(materias); //Pasar los parametros
        rv_materias.setAdapter(adaptadorMateria);

    }


    public void  FormularioNuevaMateria(){
        Intent intent = new Intent(this, FormularioMateria.class);
        startActivity(intent);
    }

    public void  Inicio(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
