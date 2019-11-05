package app.com.universidadanrdoidjr.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.com.universidadanrdoidjr.R;
import app.com.universidadanrdoidjr.entidad.Carrera;

public class AdaptadorCarrera extends RecyclerView.Adapter<AdaptadorCarrera.ViewHolder>{

    public List<Carrera> datos_carrera;

    public AdaptadorCarrera(List<Carrera> datos_carrera) {
        this.datos_carrera = datos_carrera;
    }

    @NonNull
    @Override
    public AdaptadorCarrera.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrera,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCarrera.ViewHolder holder, int position) {
            holder.carrera_tv.setText(datos_carrera.get(position).getNombre_carrera());
    }

    @Override
    public int getItemCount() {
        return datos_carrera.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView carrera_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carrera_tv = itemView.findViewById(R.id.tv_carrera2);
        }

    }


}
