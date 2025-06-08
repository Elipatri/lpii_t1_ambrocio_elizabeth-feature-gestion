package com.demo.peliculas.dao;

import com.demo.peliculas.domain.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ClienteDao {

    private EntityManager em;

    public ClienteDao() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public List<Cliente> listar() {
        Query query = em.createQuery("from Cliente c");
        List<Cliente> lista = query.getResultList();
        return lista;
    }

    public Cliente buscarPorId(Long id) {
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return  cliente;
    }
}
