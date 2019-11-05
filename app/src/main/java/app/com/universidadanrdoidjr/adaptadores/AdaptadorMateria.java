package app.com.universidadanrdoidjr.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.com.universidadanrdoidjr.R;
import app.com.universidadanrdoidjr.entidad.Materia;

public class AdaptadorMateria extends RecyclerView.Adapter<AdaptadorMateria.ViewHolder> {


    public List<Materia>  datosMateria;

    public AdaptadorMateria(List<Materia> datosMateria) {
        this.datosMateria = datosMateria;
    }

    @NonNull
    @Override
    public AdaptadorMateria.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materia,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMateria.ViewHolder holder, int position) {
        holder.materia_tv.setText(datosMateria.get(position).getNombre_materia());
        holder.creditos_tv.setText(datosMateria.get(position).getCreditos().toString());
    }

    @Override
    public int getItemCount() { return datosMateria.size();  }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView materia_tv, creditos_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            materia_tv = itemView.findViewById(R.id.tv_materia_card);
            creditos_tv = itemView.findViewById(R.id.tv_creditos_card);
        }

    }





}
