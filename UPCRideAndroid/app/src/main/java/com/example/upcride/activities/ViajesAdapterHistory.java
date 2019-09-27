package com.example.upcride.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.upcride.R;
import com.example.upcride.model.Viaje;

import java.util.List;

public class ViajesAdapterHistory extends RecyclerView.Adapter<ViajesAdapterHistory .ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre, fecha, pnt_partida, pnt_destino, n_resenias;
        public ImageView foto_perfil;

        public ViewHolder(View itemView){
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.n_usuario);
            fecha = (TextView) itemView.findViewById(R.id.fechita);
            foto_perfil = (ImageView) itemView.findViewById(R.id.foto_perfil);
            pnt_partida = (TextView) itemView.findViewById(R.id.pnt_partida);
            pnt_destino = (TextView) itemView.findViewById(R.id.pnt_destino);
            n_resenias = (TextView) itemView.findViewById(R.id.n_resenias);
        }
    }

    public List<ViajeModelo> viajeLista;

    public ViajesAdapterHistory (List<ViajeModelo> viajeLista){
        this.viajeLista = viajeLista;
    }

    @Override
    public ViajesAdapterHistory .ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viaje_historial, parent, false);
        ViajesAdapterHistory .ViewHolder viewHolder = new ViajesAdapterHistory .ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViajesAdapterHistory .ViewHolder holder, int position) {
        holder.nombre.setText(viajeLista.get(position).getNombre());
        holder.fecha.setText(viajeLista.get(position).getFecha());
        holder.pnt_partida.setText(viajeLista.get(position).getPnt_partida());
        holder.pnt_destino.setText(viajeLista.get(position).getPnt_destino());
        holder.n_resenias.setText(viajeLista.get(position).getN_resenias());
        holder.foto_perfil.setImageResource(viajeLista.get(position).getFoto_perfil());
    }

    @Override
    public int getItemCount() {
        return viajeLista.size();
    }
}
