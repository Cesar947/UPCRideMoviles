package com.example.upcride.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.upcride.R;

import java.util.List;

public class AdaptadorSolicitudes extends RecyclerView.Adapter<AdaptadorSolicitudes.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre, fecha, descripcion;
        public ImageView foto_perfil;

        public ViewHolder(View itemView){
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.n_usuario);
            fecha = (TextView) itemView.findViewById(R.id.d_fecha);
            descripcion = (TextView) itemView.findViewById(R.id.t_descripcion);
            foto_perfil = (ImageView) itemView.findViewById(R.id.foto_perfil);
        }
    }

    public List<SolicitudModelo> solicitudLista;

    public AdaptadorSolicitudes(List<SolicitudModelo> solicitudListaLista){
        this.solicitudLista = solicitudListaLista;
    }

    @Override
    public AdaptadorSolicitudes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solicitud, parent, false);
        AdaptadorSolicitudes.ViewHolder viewHolder = new AdaptadorSolicitudes.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorSolicitudes.ViewHolder holder, int position) {
        holder.nombre.setText(solicitudLista.get(position).getNombre());
        holder.fecha.setText(solicitudLista.get(position).getFecha());
        holder.descripcion.setText(solicitudLista.get(position).getDescripcion());
        holder.foto_perfil.setImageResource(solicitudLista.get(position).getFoto_perfil());
    }

    @Override
    public int getItemCount() {
        return solicitudLista.size();
    }
}
