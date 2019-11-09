package com.example.upcridekotlin.activities.homefragmentactivity


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
import androidx.core.view.isVisible

import com.example.upcridekotlin.R
import com.example.upcridekotlin.activities.ViajeDetalleFragment
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Viaje
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    val TAG_LOGS = "Bryan Miramira"



    private var recyclerViewViaje: RecyclerView? = null
    private var adaptadorViaje: RecyclerViewAdaptador? = null
    private var viajeService: ViajeApiService? = null
    private var btnAgregarViaje : FloatingActionButton? = null
    private var viajeDetalleFragment: ViajeDetalleFragment? = null


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
        viajeDetalleFragment = ViajeDetalleFragment()



        btnAgregarViaje = vista.findViewById(R.id.btnAgregarViaje)

        //Log.i(TAG_LOGS, arguments.toString())

        var id = arguments!!.getInt("id",0)
        var rol = arguments!!.getChar("rol",'P')

        Log.i(TAG_LOGS, rol.toString())

        if(rol=='C')
        {
            btnAgregarViaje!!.isVisible = true
        }

        btnAgregarViaje!!.setOnClickListener {

            val intent = Intent(activity, publicar_viaje::class.java)
            var miBundle = Bundle()
            miBundle.putInt("id", id)
            miBundle.putChar("rol", rol)
            intent.putExtras(miBundle)
            startActivity(intent)
        }




        recyclerViewViaje = vista.findViewById(R.id.viajes_recycler)
        recyclerViewViaje!!.layoutManager = LinearLayoutManager(context)

        Toast.makeText(activity, id.toString(), Toast.LENGTH_LONG).show()

        viajeService!!.getAllViajes().enqueue(object: Callback<List<Viaje>> {
            override fun onResponse(call: Call<List<Viaje>>, response: Response<List<Viaje>>) {
                val viajesaux = response.body()

                var sorted = viajesaux!!.sortedWith(compareByDescending ({it.id}))


                adaptadorViaje =
                    RecyclerViewAdaptador(
                        sorted!!
                    )

                adaptadorViaje!!.setOnClickListener( object : View.OnClickListener{
                    override fun onClick(view:View){

                        Toast.makeText(activity,viajesaux.get(recyclerViewViaje!!.getChildAdapterPosition(view)).id.toString(),Toast.LENGTH_LONG).show()
                        var miBundleViaje = Bundle()

                        miBundleViaje.putInt("idViaje",viajesaux.get(recyclerViewViaje!!.getChildAdapterPosition(view)).id)
                        miBundleViaje.putInt("idPasajero",id)
                        miBundleViaje.putChar("rol",rol)
                        viajeDetalleFragment!!.arguments = miBundleViaje
                        fragmentManager!!.beginTransaction().replace(R.id.main_frame,viajeDetalleFragment!!).commit()

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



}