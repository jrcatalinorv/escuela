package app.com.universidadanrdoidjr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import app.com.universidadanrdoidjr.adaptadores.AdaptadorCarrera;
import app.com.universidadanrdoidjr.entidad.Carrera;
import app.com.universidadanrdoidjr.repositorio.CarreraRepositorio;
import app.com.universidadanrdoidjr.repositorio.CarreraRepositorioDbImpl;
import app.com.universidadanrdoidjr.repositorio.EstudianteRepositorio;

public class ListaCarreras extends AppCompatActivity {

    private Button cancelar, nuevo;
    private RecyclerView rvCarreras;
    private CarreraRepositorio carreraRepositorio;
    private List<Carrera> carreras;
    private AdaptadorCarrera adaptadorCarrera;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carreras);


        cancelar = findViewById(R.id.carr_cancelar);
        nuevo = findViewById(R.id.carr_nuevo);
        rvCarreras = findViewById(R.id.lc_rv_carreras);

        carreraRepositorio = new CarreraRepositorioDbImpl(this.getBaseContext());

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PantallaInicio();
            }
        });

        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormularioNuevaCarrera();
            }
        });

        /* Inicia con el llenado de la lista de Carreras */
        carreras = carreraRepositorio.Buscar();
        rvCarreras.setLayoutManager(new LinearLayoutManager(this));
        adaptadorCarrera = new AdaptadorCarrera(carreras);
        rvCarreras.setAdapter(adaptadorCarrera);
    }


    public void  FormularioNuevaCarrera(){
        Intent intent = new Intent(this, FormualrioCarrera.class);
        startActivity(intent);
    }


    public void  PantallaInicio(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}