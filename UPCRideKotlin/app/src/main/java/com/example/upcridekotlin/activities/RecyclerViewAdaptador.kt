package com.example.upcridekotlin.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upcridekotlin.R


class RecyclerViewAdaptador(var viajeLista: List<ViajeModelo>) :
    RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nombre: TextView
        var fecha: TextView
        var descripcion: TextView
        var pnt_partida: TextView
        var pnt_destino: TextView
        var n_solis: TextView
        var n_resenias: TextView
        var foto_perfil: ImageView

        init {
            nombre = itemView.findViewById<View>(R.id.n_usuario) as TextView
            fecha = itemView.findViewById<View>(R.id.d_fecha) as TextView
            descripcion = itemView.findViewById<View>(R.id.t_descrip) as TextView
            pnt_partida = itemView.findViewById<View>(R.id.pnt_partida) as TextView
            pnt_destino = itemView.findViewById<View>(R.id.pnt_destino) as TextView
            n_solis = itemView.findViewById<View>(R.id.n_solis) as TextView
            n_resenias = itemView.findViewById<View>(R.id.n_resenias) as TextView
            foto_perfil = itemView.findViewById<View>(R.id.foto_perfil) as ImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viaje, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.setText(viajeLista[position].nombre  )
        holder.fecha.setText(viajeLista[position].fecha)
        holder.descripcion.setText(viajeLista[position].descripcion)
        holder.pnt_partida.setText(viajeLista[position].pnt_partida)
        holder.pnt_destino.setText(viajeLista[position].pnt_destino)
        holder.n_solis.setText(viajeLista[position].n_solis)
        holder.n_resenias.setText(viajeLista[position].n_resenias)
        holder.foto_perfil.setImageResource(viajeLista[position].foto_perfil)
    }

    override fun getItemCount(): Int {
        return viajeLista.size
    }
}
