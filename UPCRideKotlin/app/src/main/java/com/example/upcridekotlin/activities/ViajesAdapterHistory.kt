package com.example.upcridekotlin.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.upcridekotlin.R
import com.example.upcridekotlin.model.ViajeModelo

class ViajesAdapterHistory(var viajeLista: List<ViajeModelo>) :
    RecyclerView.Adapter<ViajesAdapterHistory.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nombre: TextView
        var fecha: TextView
        var pnt_partida: TextView
        var pnt_destino: TextView
        var n_resenias: TextView
        var foto_perfil: ImageView

        init {
            nombre = itemView.findViewById<View>(R.id.n_usuario) as TextView
            fecha = itemView.findViewById<View>(R.id.fechita) as TextView
            foto_perfil = itemView.findViewById<View>(R.id.foto_perfil) as ImageView
            pnt_partida = itemView.findViewById<View>(R.id.pnt_partida) as TextView
            pnt_destino = itemView.findViewById<View>(R.id.pnt_destino) as TextView
            n_resenias = itemView.findViewById<View>(R.id.n_resenias) as TextView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViajesAdapterHistory.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viaje_historial, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViajesAdapterHistory.ViewHolder, position: Int) {
        holder.nombre.text = viajeLista[position].nombre
        holder.fecha.text = viajeLista[position].fecha
        holder.pnt_partida.text = viajeLista[position].pnt_partida
        holder.pnt_destino.text = viajeLista[position].pnt_destino
        holder.n_resenias.text = viajeLista[position].n_resenias
        holder.foto_perfil.setImageResource(viajeLista[position].foto_perfil)
    }

    override fun getItemCount(): Int {
        return viajeLista.size
    }
}
