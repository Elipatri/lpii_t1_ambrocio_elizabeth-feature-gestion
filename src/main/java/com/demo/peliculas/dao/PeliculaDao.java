package com.demo.peliculas.dao;

import com.demo.peliculas.domain.Cliente;
import com.demo.peliculas.domain.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class PeliculaDao {

    private EntityManager em;

    public PeliculaDao() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public List<Pelicula> listar() {
        Query query = em.createQuery("from Pelicula p");
        List<Pelicula> lista = query.getResultList();
        return lista;
    }

    public Pelicula buscarPorId(Long id) {
        Pelicula pelicula = null;
        try {
            pelicula = em.find(Pelicula.class, id);
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return  pelicula;
    }
}
