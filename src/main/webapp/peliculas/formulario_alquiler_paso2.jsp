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
                                <h2>Formulario de registro - Paso 2</h2>
                                <form action="" method="get" >
                                    <div class="row">
                                        <c:forEach var="i" begin="1" end="${nroPeliculas}">
                                            <div class="mb-3">
                                                <label class="form-label">Pelicula Nro. <c:out value="${i}"></c:out></label>
                                                <select class="form-select" name="pelicula${i}">
                                                    <option value="" selected disabled>Seleccione película</option>
                                                    <c:forEach items="${peliculas}" var="pelicula">
                                                       	<option value="${pelicula.id}"><c:out value="${pelicula.titulo} - ${pelicula.genero}"></c:out></option>
                                                    </c:forEach>
                                                    <%--
                                                        	<option value="Marca 1" >Marca 1</option>
                                                     --%>
                                                </select>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <input type="hidden" value="3" name="nroPaso" />
                                    <input type="hidden" value="<%=request.getParameter("idCliente")%>" name="idCliente" />
                                    <input type="hidden" value="<%=request.getParameter("nroPeliculas")%>" name="nroPeliculas" />
                                    <div class="col-4">
                                            	                                <button type="submit" class="btn btn-outline-success">
                                            	                                    <i class="bi bi-search"></i> Registrar
                                            	                                </button>
                                            	                            </div>
                                </form>
                            </div>
                        </div>
        </div>
        </div>
    </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>