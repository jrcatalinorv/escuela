package app.com.universidadanrdoidjr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import app.com.universidadanrdoidjr.entidad.Carrera;
import app.com.universidadanrdoidjr.entidad.Materia;
import app.com.universidadanrdoidjr.repositorio.CarreraRepositorio;
import app.com.universidadanrdoidjr.repositorio.CarreraRepositorioDbImpl;
import app.com.universidadanrdoidjr.repositorio.MateriaRepositorio;
import app.com.universidadanrdoidjr.repositorio.MateriaRepositorioDbImpl;

public class FormualrioCarrera extends AppCompatActivity {

    private EditText et_nueva_carrera;
    private Spinner sp_lista_materias;
    private Button cancelar, guardar;
    private CarreraRepositorio carreraRepositorio;
    private MateriaRepositorio materiaRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formualrio_carrera);

        et_nueva_carrera = findViewById(R.id.fc_nombre_carrera);
        cancelar = findViewById(R.id.fc_cancelar);
        guardar = findViewById(R.id.fc_nuevo);
        sp_lista_materias = findViewById(R.id.fc_spinner_materias);
        carreraRepositorio = new CarreraRepositorioDbImpl(this.getBaseContext());


        // Loading spinner data from database
        loadSpinnerData();

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrListaCarreras();
            }
        });


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Carrera nueva_carrera = new Carrera();
                nueva_carrera.setNombre_carrera(et_nueva_carrera.getText().toString());
                carreraRepositorio.Crear(nueva_carrera);

                et_nueva_carrera.setText("");
            }
        });

    }


    public void  IrListaCarreras(){
        Intent intent = new Intent(this, ListaCarreras.class);
        startActivity(intent);
    }


    private void loadSpinnerData() {
        List<Materia> listamaterias;

        materiaRepositorio = new MateriaRepositorioDbImpl(getBaseContext());
        listamaterias = materiaRepositorio.buscar();
        ArrayAdapter<Materia> adapter = new ArrayAdapter<>(this,
               android.R.layout.simple_spinner_item,listamaterias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_lista_materias.setAdapter(adapter);
    }




}
