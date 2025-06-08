package com.demo.peliculas.service;

import com.demo.peliculas.dao.AlquilerDao;
import com.demo.peliculas.domain.Alquiler;
import com.demo.peliculas.domain.DetalleAlquiler;

public class AlquilerService {

    private AlquilerDao alquilerDao;

    public AlquilerService() {
        alquilerDao = new AlquilerDao();
    }

    public Alquiler registrar(Alquiler alquiler) {

        for(DetalleAlquiler detalle : alquiler.getDetalleAlquiler()) {
            detalle.setAlquiler(alquiler);
            //alquilerDao.registarDetalle(detalle);
        }
        alquiler = alquilerDao.registrar(alquiler);
        return alquiler;
    }
}
