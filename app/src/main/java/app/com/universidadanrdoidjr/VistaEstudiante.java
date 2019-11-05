package app.com.universidadanrdoidjr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VistaEstudiante extends AppCompatActivity {

    private TextView nombre,matricula, carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_estudiante);

        nombre = findViewById(R.id.detalleNombre);
        matricula = findViewById(R.id.detalleMatricula);
        carrera = findViewById(R.id.detalleCarrera);

        Intent intent = getIntent();
        nombre.setText(intent.getStringExtra(ListaEstudiantes.EXTRA_NOMBRE));
        matricula.setText(intent.getStringExtra(ListaEstudiantes.EXTRA_MATRICULA));
        carrera.setText(intent.getStringExtra(ListaEstudiantes.EXTRA_CARRERA));

    }
}
