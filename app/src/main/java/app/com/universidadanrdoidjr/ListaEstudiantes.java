package app.com.universidadanrdoidjr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import app.com.universidadanrdoidjr.adaptadores.AdaptadorEstudiante;
import app.com.universidadanrdoidjr.entidad.Estudiante;
import app.com.universidadanrdoidjr.repositorio.EstudianteRepositorio;
import app.com.universidadanrdoidjr.repositorio.EstudianteRepositorioDbImpl;

public class ListaEstudiantes extends AppCompatActivity {

    private Button cancelar, nuevo;
    private RecyclerView rvEstudiante;
    private EstudianteRepositorio estudianteRepositorio;
    private List<Estudiante> estudianteList;
    public static final String EXTRA_NOMBRE ="app.com.universidadanrdoidjr.EXTRA_NOMBRE";
    public static final String EXTRA_MATRICULA ="app.com.universidadanrdoidjr.EXTRA_MATRICULA";
    public static final String EXTRA_CARRERA ="app.com.universidadanrdoidjr.EXTRA_CARRERA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);

        cancelar = findViewById(R.id.le_cancelar);
        nuevo = findViewById(R.id.le_nuevo);
        rvEstudiante = findViewById(R.id.rvListaEstudiantes);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LePantallaInicio();
            }
        });
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormularioNuevoEstudiante();
            }
        });

        rvEstudiante.setLayoutManager(new LinearLayoutManager(this));
        estudianteRepositorio = new EstudianteRepositorioDbImpl(this.getBaseContext());
        estudianteList = estudianteRepositorio.buscar();



        AdaptadorEstudiante adaptadorEstudiante = new AdaptadorEstudiante(estudianteList);
        adaptadorEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FichaEstuante(estudianteList.get(rvEstudiante.getChildAdapterPosition(v)).getNombre(),
                        estudianteList.get(rvEstudiante.getChildAdapterPosition(v)).getMatricula(),
                        estudianteList.get(rvEstudiante.getChildAdapterPosition(v)).getCarrera());
            }
        });
        rvEstudiante.setAdapter(adaptadorEstudiante);
    }



    public void  FormularioNuevoEstudiante(){
        Intent intent = new Intent(this, FormularioEstudiante.class);
        startActivity(intent);
    }

    public void  LePantallaInicio(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void FichaEstuante(String name, String mat, String carr){
        Intent intent = new Intent(this,VistaEstudiante.class);
        intent.putExtra(EXTRA_NOMBRE,name);
        intent.putExtra(EXTRA_MATRICULA,mat);
        intent.putExtra(EXTRA_CARRERA,carr);
        startActivity(intent);
    }

}
