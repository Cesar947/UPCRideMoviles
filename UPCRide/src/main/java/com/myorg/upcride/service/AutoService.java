package com.myorg.upcride.service;

import com.myorg.upcride.model.Auto;

import java.util.List;

public interface AutoService {

    Auto guardarAuto(Auto auto) throws Exception;
    Auto buscarAutoPorConductor(Integer conductorId) throws Exception;
    List<Auto> mostrarAutos() throws  Exception;
    
}
