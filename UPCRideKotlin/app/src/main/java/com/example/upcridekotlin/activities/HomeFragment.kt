package com.example.upcridekotlin.activities


import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Viaje
import com.example.upcridekotlin.model.ViajeModelo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    val TAG_LOGS = "Bryan Miramira"

    var ViajesAux : ArrayList<ViajeModelo> = ArrayList()

    private var recyclerViewViaje: RecyclerView? = null
    private var adaptadorViaje: RecyclerViewAdaptador? = null
    private var viajeService: ViajeApiService? = null
    private var btnAgregarViaje : FloatingActionButton? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_home, container, false)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        viajeService = retrofit.create(ViajeApiService::class.java)



        btnAgregarViaje = vista.findViewById(R.id.btnAgregarViaje)
        //Log.i(TAG_LOGS, arguments.toString())

        var id = arguments!!.getInt("id",0)


        btnAgregarViaje!!.setOnClickListener {

            val intent = Intent(activity, publicar_viaje::class.java)
            var miBundle = Bundle()
            miBundle.putInt("id", id)
            intent.putExtras(miBundle)
            startActivity(intent)
        }




        recyclerViewViaje = vista.findViewById(R.id.viajes_recycler)
        recyclerViewViaje!!.layoutManager = LinearLayoutManager(context)

        Toast.makeText(activity, id.toString(), Toast.LENGTH_LONG).show()

        viajeService!!.getAllViajes().enqueue(object: Callback<List<Viaje>> {
            override fun onResponse(call: Call<List<Viaje>>, response: Response<List<Viaje>>) {
                val viajesaux = response.body()

                //Log.i(TAG_LOGS, Gson().toJson(ViajesAux))
                adaptadorViaje = RecyclerViewAdaptador(viajesaux!!)

                adaptadorViaje!!.setOnClickListener( object : View.OnClickListener{
                    override fun onClick(view:View){
                        Toast.makeText(activity,ViajesAux.get(recyclerViewViaje!!.getChildAdapterPosition(view)).nombre,Toast.LENGTH_LONG).show()
                    }
                })

                recyclerViewViaje!!.adapter = adaptadorViaje
            }
            override fun onFailure(call: Call<List<Viaje>>?, t: Throwable?) {
                t?.printStackTrace()

            }

        })





        return vista
    }



   /* fun anadir (lista:List<Viaje>){

        for(item : Viaje in lista)
        {
            var id = item?.id
            var nombre = item?.conductor?.nombres.toString();
            var fecha =  item?.fecha.toString();
            var descripcion =  item?.descripcion.toString();
            var ptoPartida=  item?.puntoPartida.toString();
            var ptoDestino=  item?.puntoDestino.toString();
            var n_solis =  "20"
            var n_reseñas = "10"

            ViajesAux.add(
                ViajeModelo(id,
                    nombre, fecha, descripcion, ptoPartida, ptoDestino,
                    n_solis, n_reseñas, R.drawable.queso
                )
            )

        }
    }*/

}