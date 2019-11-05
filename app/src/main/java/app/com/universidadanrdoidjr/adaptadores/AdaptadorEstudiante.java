package app.com.universidadanrdoidjr.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.com.universidadanrdoidjr.R;
import app.com.universidadanrdoidjr.entidad.Estudiante;

public class AdaptadorEstudiante extends RecyclerView.Adapter<AdaptadorEstudiante.ViewHolder>
      implements View.OnClickListener  {

    public List<Estudiante> datosEstudiante;
    private View.OnClickListener listener;

    public AdaptadorEstudiante(List<Estudiante> datosEstudiante){
        this.datosEstudiante = datosEstudiante;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudiante,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.matricula.setText(datosEstudiante.get(position).getMatricula());
        holder.nombre.setText(datosEstudiante.get(position).getNombre());
        holder.carrera.setText(datosEstudiante.get(position).getCarrera());



    }


    @Override
    public int getItemCount() {  return datosEstudiante.size();  }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }


    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView matricula, nombre, carrera;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            matricula = itemView.findViewById(R.id.tv_matricula);
            nombre = itemView.findViewById(R.id.tv_estudiante);
            carrera = itemView.findViewById(R.id.tv_carrera);



        }



     }

}
