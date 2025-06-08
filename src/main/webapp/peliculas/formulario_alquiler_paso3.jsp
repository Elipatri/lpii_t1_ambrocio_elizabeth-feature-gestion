<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar Equipo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
</head>
<body>
    <div class="container">
        <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
                        <div class="card mt-5">
                            <div class="card-body">
                                <h2>Formulario de registro - Detalle de alquiler</h2>
                                Cliente: <c:out value="${alquiler.cliente.nombre}"></c:out></br>
                                Email: <c:out value="${alquiler.cliente.email}"></c:out></br>
                                Películas:</br>
                                <c:forEach items="${alquiler.detalleAlquiler}" var="detalle">
                                    <c:out value="${detalle.id} - ${detalle.pelicula.titulo} - ${detalle.pelicula.genero}"></c:out></br>
                                </c:forEach>
                                Fecha:  <c:out value="${alquiler.fecha}"></c:out></br>
                                Total películas:  <c:out value="${alquiler.total}"></c:out></br>
                            </div>
                        </div>
        </div>
        </div>
    </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script>

	</script>
</body>
</html>