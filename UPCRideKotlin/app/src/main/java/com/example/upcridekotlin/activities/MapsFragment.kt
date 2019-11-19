package com.example.upcridekotlin.activities

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.example.upcridekotlin.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.maps.android.PolyUtil
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.Polyline





// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MapsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MapsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapsFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMapClickListener,
    GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener,GoogleMap.OnPolygonClickListener,GoogleMap.OnPolylineClickListener{

    override fun onPolygonClick(p0: Polygon?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPolylineClick(p0: Polyline?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var marker: Marker? = null


    override fun onMyLocationButtonClick(): Boolean {
        return false
    }

    override fun onMyLocationClick(p0: Location) {

    }

    override fun onMapClick(p0: LatLng?) {

        marker?.remove()

        marker = map.addMarker(p0?.let { MarkerOptions().position(it) })

        //map.moveCamera(CameraUpdateFactory.newLatLng(p0))
    }

    fun getLat(): Double? {
        return marker?.position?.latitude
    }

    fun getLng(): Double? {
        return marker?.position?.longitude
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var map: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_maps, container, false)
        val mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.solicitarMap) as SupportMapFragment

        mapFragment.getMapAsync(this)
        return view
    }
    override fun onMapReady(p0: GoogleMap?) {

        //p0.moveCamera(CameraUpdateFactory.newLatLng(LatLng()))


        comprobarPermisos()


        map = p0!!


        map?.setOnMapClickListener(this)
        map.setMyLocationEnabled(true);
        map.setOnMyLocationButtonClickListener(this);
        map.setOnMyLocationClickListener(this);
        map?.setOnPolylineClickListener(this);
        map?.setOnPolygonClickListener(this);

       /*map.addPolyline(
            PolylineOptions()
                .clickable(true)
                .add(
                    LatLng(-35.016, 143.321),
                    LatLng(-34.747, 145.592),
                    LatLng(-34.364, 147.891),
                    LatLng(-33.501, 150.217),
                    LatLng(-32.306, 149.248),
                    LatLng(-32.491, 147.309)
                )
        )*/

        // Position the map's camera near Alice Springs in the center of Australia,
        // and set the zoom factor so most of Australia shows on the screen.
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-23.684, 133.903), 4f))



        map.moveCamera( CameraUpdateFactory.newLatLngZoom(LatLng(-12.06731,-77.13084) , 16.0f) )

    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun trazarRuta(jso : JsonObject)
    {
        var jRoutes : JsonArray
        var jLegs : JsonArray
        var jSteps : JsonArray

        try{

            jRoutes = jso.getAsJsonArray("routes")
            for (i in 0 until jRoutes.size())
            {
                jLegs = ((jRoutes.get(i))as JsonObject).getAsJsonArray("legs")

                for (j in 0 until jLegs.size())
                {
                    jSteps = ((jLegs.get(j))as JsonObject).getAsJsonArray("steps")

                    for (k in 0 until jSteps.size())
                    {
                        var polyline = ((((jSteps.get(k) as JsonObject).get("polyline")) as JsonObject).get("points"))


                        var aaa = polyline.asString

                        var string :String = PolyUtil.decode(aaa).toString()
                        var list : List<LatLng> = PolyUtil.decode(aaa)

                        Log.i("string",string);
                        Log.i("polylines",polyline.toString());
                        Log.i("list",list.toString());

                        var tamaño = 10.toFloat()
                        map.addPolyline(PolylineOptions().addAll(list).color(Color.BLACK).width(tamaño))

                    }

                }

            }
        }
        finally{

        }


    }

    fun comprobarPermisos()
    {
        if (ContextCompat.checkSelfPermission(context!!,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED  &&  ContextCompat.checkSelfPermission(context!!,
                android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED ) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(activity!!,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(activity!!,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),1
                    )
            }

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity!!,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(activity!!,
                    arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),1
                )
            }

        }
    }


    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            1 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                } else {

                }
                return
            }
            else -> {
            }
        }
    }






    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MapsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MapsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
