package com.example.upcridekotlin.activities


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.upcridekotlin.R

/**
 * A simple [Fragment] subclass.
 */
class ViajeDetalleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_viaje_detalle, container, false)
    }


}
