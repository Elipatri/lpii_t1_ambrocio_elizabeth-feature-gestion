package com.demo.peliculas.service;

import com.demo.peliculas.dao.PeliculaDao;
import com.demo.peliculas.domain.Pelicula;

import java.util.List;

public class PeliculaService {

    private PeliculaDao peliculaDao;


    public PeliculaService() {
        peliculaDao = new PeliculaDao();
    }

    public List<Pelicula> listar() {
        return peliculaDao.listar();
    }

    public Pelicula buscarPorId(Long id) {
        return peliculaDao.buscarPorId(id);
    }

}
