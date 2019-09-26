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


public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre, fecha, descripcion, pnt_partida, pnt_destino, n_solis, n_resenias;
        public ImageView foto_perfil;

        public ViewHolder(View itemView){
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.n_usuario);
            fecha = (TextView) itemView.findViewById(R.id.d_fecha);
            descripcion = (TextView) itemView.findViewById(R.id.t_descripcion);
            pnt_partida = (TextView) itemView.findViewById(R.id.pnt_partida);
            pnt_destino = (TextView) itemView.findViewById(R.id.pnt_destino);
            n_solis = (TextView) itemView.findViewById(R.id.n_solis);
            n_resenias = (TextView) itemView.findViewById(R.id.n_resenias);
            foto_perfil = (ImageView) itemView.findViewById(R.id.foto_perfil);
        }
    }

    public List<ViajeModelo> viajeLista;

    public RecyclerViewAdaptador(List<ViajeModelo> viajeLista){
        this.viajeLista = viajeLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viaje, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(viajeLista.get(position).getNombre());
        holder.fecha.setText(viajeLista.get(position).getFecha());
        holder.descripcion.setText(viajeLista.get(position).getDescripcion());
        holder.pnt_partida.setText(viajeLista.get(position).getPnt_partida());
        holder.pnt_destino.setText(viajeLista.get(position).getPnt_destino());
        holder.n_solis.setText(viajeLista.get(position).getN_solis());
        holder.n_resenias.setText(viajeLista.get(position).getN_resenias());
        holder.foto_perfil.setImageResource(viajeLista.get(position).getFoto_perfil());
    }

    @Override
    public int getItemCount() {
        return viajeLista.size();
    }
}
