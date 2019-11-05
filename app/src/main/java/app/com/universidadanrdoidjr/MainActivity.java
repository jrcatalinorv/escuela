package app.com.universidadanrdoidjr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ls_estudiantes, ls_carreras, ls_materias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ls_estudiantes = findViewById(R.id.main_estudiantes);
        ls_carreras = findViewById(R.id.main_carreras);
        ls_materias = findViewById(R.id.main_materias);



        ls_estudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaRstudiantes();
            }
        });

        ls_carreras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaCarreras();
            }
        });

        ls_materias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaMaterias();
            }
        });



    }

/*
* Metodos en minuscula
* */
    public void  ListaRstudiantes(){
        Intent intent = new Intent(this, ListaEstudiantes.class);
        startActivity(intent);
    }

    public void  ListaCarreras(){
        Intent intent = new Intent(this, ListaCarreras.class);
        startActivity(intent);
    }


    public void  ListaMaterias(){
        Intent intent = new Intent(this, ListaMaterias.class);
        startActivity(intent);
    }



}
