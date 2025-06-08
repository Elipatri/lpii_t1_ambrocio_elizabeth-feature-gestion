package com.demo.peliculas;

import com.demo.peliculas.domain.Alquiler;
import com.demo.peliculas.domain.Cliente;
import com.demo.peliculas.domain.DetalleAlquiler;
import com.demo.peliculas.domain.Pelicula;
import com.demo.peliculas.service.AlquilerService;
import com.demo.peliculas.service.ClienteService;
import com.demo.peliculas.service.PeliculaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "peliculas", urlPatterns = { "/peliculas" })
public class EquipoServlet extends HttpServlet {

    private ClienteService clienteService;
    private PeliculaService peliculaService;
    private AlquilerService alquilerService;

    public EquipoServlet() {
        super();
        clienteService = new ClienteService();
        peliculaService = new PeliculaService();
        alquilerService = new AlquilerService();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nroPaso = request.getParameter("nroPaso");
        System.out.println("paso: " + nroPaso);
        if(nroPaso == null) {
            irFormularioAlquilerpaso1(request, response);
        }
        if("2".equals(nroPaso)) {
            irFormularioAlquilerpaso2(request, response);
        }
        if("3".equals(nroPaso)) {
            irFormularioAlquilerpaso3(request, response);
        }

    }

    protected void irFormularioAlquilerpaso1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Cliente> clientes = clienteService.listar();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("/peliculas/formulario_alquiler_paso1.jsp").forward(request, response);
    }

    protected void irFormularioAlquilerpaso2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Pelicula> peliculas = peliculaService.listar();
        request.setAttribute("peliculas", peliculas);
        Integer nroPeliculas = Integer.parseInt(request.getParameter("nroPeliculas"));
        request.setAttribute("nroPeliculas", nroPeliculas);
        Long idCliente = Long.parseLong(request.getParameter("idCliente"));
        request.setAttribute("idCliente", idCliente);
        request.getRequestDispatcher("/peliculas/formulario_alquiler_paso2.jsp").forward(request, response);
    }

    protected void irFormularioAlquilerpaso3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer nroPeliculas = Integer.parseInt(request.getParameter("nroPeliculas"));
        Long idCliente = Long.parseLong(request.getParameter("idCliente"));
        Cliente clienteSeleccionado = clienteService.buscarPorId(idCliente);
        List<DetalleAlquiler> detalles = new ArrayList<>();
        for (int i = 0; i < nroPeliculas; i++) {
            long idPelicula = Long.parseLong(request.getParameter("pelicula" + (i + 1)));
            Pelicula pelicula = peliculaService.buscarPorId(idPelicula);
            DetalleAlquiler detalle = new DetalleAlquiler();
            detalle.setPelicula(pelicula);
            detalles.add(detalle);
        }
        Alquiler alquiler = new Alquiler();
        alquiler.setCliente(clienteSeleccionado);
        alquiler.setFecha(new Date(new java.util.Date().getTime()));
        alquiler.setTotal(nroPeliculas);
        alquiler.setDetalleAlquiler(detalles);
        alquiler = alquilerService.registrar(alquiler);
        request.setAttribute("alquiler", alquiler);
        request.getRequestDispatcher("/peliculas/formulario_alquiler_paso3.jsp").forward(request, response);
    }
}
