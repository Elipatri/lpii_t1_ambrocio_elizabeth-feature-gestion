package com.demo.peliculas.dao;

import com.demo.peliculas.domain.Alquiler;
import com.demo.peliculas.domain.DetalleAlquiler;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AlquilerDao {

    private EntityManager em;

    public AlquilerDao() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public Alquiler registrar(Alquiler alquiler) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(alquiler);
        em.flush();
        tx.commit();
        return alquiler;
    }

    public DetalleAlquiler registarDetalle(DetalleAlquiler detalle) {
        EntityTransaction tx = em.getTransaction();
        //tx.begin();
        em.persist(detalle);
        em.flush();
        //tx.commit();
        return detalle;
    }
}
