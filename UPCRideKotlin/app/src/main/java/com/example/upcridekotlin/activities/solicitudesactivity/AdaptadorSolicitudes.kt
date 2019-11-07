package com.example.upcridekotlin.activities.solicitudesactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.upcridekotlin.R
import com.example.upcridekotlin.model.SolicitudModelo

class AdaptadorSolicitudes(var solicitudLista: List<SolicitudModelo>) :
    RecyclerView.Adapter<AdaptadorSolicitudes.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nombre: TextView
        var fecha: TextView
        var descripcion: TextView
        var foto_perfil: ImageView

        init {
            nombre = itemView.findViewById<View>(R.id.n_usuario) as TextView
            fecha = itemView.findViewById<View>(R.id.d_fecha) as TextView
            descripcion = itemView.findViewById<View>(R.id.t_descripcion) as TextView
            foto_perfil = itemView.findViewById<View>(R.id.foto_perfil) as ImageView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_solicitud, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.setText(solicitudLista[position].nombre)
        holder.fecha.setText(solicitudLista[position].fecha)
        holder.descripcion.setText(solicitudLista[position].descripcion)
        holder.foto_perfil.setImageResource(solicitudLista[position].foto_perfil)
    }

    override fun getItemCount(): Int {
        return solicitudLista.size
    }
}
