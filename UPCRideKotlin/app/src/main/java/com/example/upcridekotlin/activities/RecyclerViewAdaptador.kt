package com.example.upcridekotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upcridekotlin.R
import com.example.upcridekotlin.model.Viaje
import com.example.upcridekotlin.model.ViajeModelo


class RecyclerViewAdaptador(var viajeLista: List<Viaje>) :
    RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>(), OnClickListener {


   var  listener : OnClickListener? = null



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),OnClickListener {





        var id: Int
        var nombre: TextView
        var fecha: TextView
        var descripcion: TextView
        var pnt_partida: TextView
        var pnt_destino: TextView
        var n_solis: TextView
        var n_resenias: TextView
        var foto_perfil: ImageView
        var btnSolicitar: ImageButton
        var context: Context
        var pasajero : Int

        init {
            id = 0
            pasajero = 0
            nombre = itemView.findViewById<View>(R.id.n_usuario) as TextView
            fecha = itemView.findViewById<View>(R.id.d_fecha) as TextView
            descripcion = itemView.findViewById<View>(R.id.t_descrip) as TextView
            pnt_partida = itemView.findViewById<View>(R.id.pnt_partida) as TextView
            pnt_destino = itemView.findViewById<View>(R.id.pnt_destino) as TextView
            n_solis = itemView.findViewById<View>(R.id.n_solis) as TextView
            n_resenias = itemView.findViewById<View>(R.id.n_resenias) as TextView
            foto_perfil = itemView.findViewById<View>(R.id.foto_perfil) as ImageView
            btnSolicitar = itemView.findViewById<View>(R.id.btnSolicitar) as ImageButton
            context = itemView.context

        }

        fun setOnClickListeners(){
           btnSolicitar.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when(v!!.id){
                R.id.btnSolicitar -> {

                    var bundle = Bundle()
                    var intent = Intent(context, solicitar_viaje::class.java)

                    bundle.putInt("idViaje",id)
                    intent.putExtras(bundle)

                    context.startActivity(intent)

                }
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viaje, parent, false)
        view.setOnClickListener(this)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id = viajeLista[position].id
        holder.nombre.setText(viajeLista[position].conductor!!.nombres)
        holder.fecha.setText(viajeLista[position].fecha)
        holder.descripcion.setText(viajeLista[position].descripcion)
        holder.pnt_partida.setText(viajeLista[position].puntoPartida)
        holder.pnt_destino.setText(viajeLista[position].puntoDestino)
        holder.n_solis.setText("20")
        holder.n_resenias.setText("20")
        holder.foto_perfil.setImageResource(R.drawable.user)
        holder.setOnClickListeners()
    }

    fun setOnClickListener(listener : OnClickListener )
    {
        this.listener = listener

    }


    override fun onClick(view:View)
    {
        if(listener!=null)

        {
            listener!!.onClick(view)
        }
    }


    override fun getItemCount(): Int {
        return viajeLista.size
    }


}
