package com.demo.peliculas.service;

import com.demo.peliculas.dao.ClienteDao;
import com.demo.peliculas.domain.Cliente;
import com.demo.peliculas.domain.Pelicula;

import java.util.List;

public class ClienteService {

    private ClienteDao clienteDao;

    public ClienteService() {
        clienteDao = new ClienteDao();
    }

    public List<Cliente> listar() {
        return clienteDao.listar();
    }

    public Cliente buscarPorId(Long id) {
        return clienteDao.buscarPorId(id);
    }
}
