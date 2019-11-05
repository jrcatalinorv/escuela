package app.com.universidadanrdoidjr;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.com.universidadanrdoidjr.entidad.Carrera;
import app.com.universidadanrdoidjr.entidad.Estudiante;
import app.com.universidadanrdoidjr.repositorio.CarreraRepositorio;
import app.com.universidadanrdoidjr.repositorio.CarreraRepositorioDbImpl;
import app.com.universidadanrdoidjr.repositorio.EstudianteRepositorio;
import app.com.universidadanrdoidjr.repositorio.EstudianteRepositorioDbImpl;

public class FormularioEstudiante extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView matricula, nombre;
    private Spinner spListaCcarreras;
    private Button cancelar, guardar, agregarCarrera;
    private EstudianteRepositorio estudianteRepositorio;
    private CarreraRepositorio carreraRepositorio;
    private List<Carrera> listacarreras;
    private String carreraID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formualrio_estudiante);

        cancelar = findViewById(R.id.fe_cancelar);
        guardar = findViewById(R.id.fe_guardar);
        agregarCarrera = findViewById(R.id.fe_btn_add);
        spListaCcarreras = findViewById(R.id.spinner);
        estudianteRepositorio = new EstudianteRepositorioDbImpl(this.getBaseContext());

        nombre = findViewById(R.id.txt_nombre);
        matricula = findViewById(R.id.txt_matricula);


        GetSpinnerData();


        spListaCcarreras.setOnItemSelectedListener(this);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaRstudiantes();
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Estudiante nuevo_est = new Estudiante();
                nuevo_est.setNombre(nombre.getText().toString());
                nuevo_est.setMatricula(matricula.getText().toString());
                nuevo_est.setCarrera(carreraID);
                estudianteRepositorio.crear(nuevo_est);

                /* Limpiar los campos del formualrio */


            }
        });

        agregarCarrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NuevaCarrera();
            }
        });
    }


    public void GetSpinnerData(){

        carreraRepositorio = new CarreraRepositorioDbImpl(getBaseContext());
        listacarreras = carreraRepositorio.Buscar();

        ArrayAdapter<Carrera> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,listacarreras);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spListaCcarreras.setAdapter(adapter);

    }

    public void  ListaRstudiantes(){
        Intent intent = new Intent(this, ListaEstudiantes.class);
        startActivity(intent);
    }

    public void NuevaCarrera(){
       Intent intent = new Intent(this, FormualrioCarrera.class);
       startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

           long miid = parent.getItemIdAtPosition((int) id+1);
            carreraID = Long.toString(miid);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void verMensaje(){

        String texto = String.valueOf(carreraID);
        Toast.makeText(this, texto, Toast.LENGTH_SHORT ).show();
    }

}
