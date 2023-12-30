<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gestion des étudiants</title>
<link rel="stylesheet" href="css/mdb.min.css">
</head>

<%!String GenerateCNE() {
		double randomNum = Math.random() * 1000;
		return "CNE-" + Math.round(randomNum) + ".0";
	}%>
<%
String GeneratedCNE = GenerateCNE();
%>


<body>
	<header>
		<h1 class="mt-4 text-center">Gestion des étudiants</h1>
	</header>
	<hr class="mt-3">

	<div class="container">
		<c:choose>
			<c:when test="${result}">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					L'étudiant a été ajouté avec success
					<button type="button" class="btn-close ms-2"
						data-mdb-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:when>

			<c:when test="${!(result) and result != null}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					Un problème est survenu
					<button type="button" class="btn-close ms-2"
						data-mdb-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:when>

		</c:choose>


		<section>
			<form action="save_etudiant" method="post">
				<div class="row ">
					<div class="col-4">
						<label for="code" class="form-label">Code :</label>
					</div>
					<div class="col">
						<input type="text" class="form-control" name="code" id="code"
							placeholder="CNE-199.0" value="<%=GeneratedCNE%>">

					</div>
					<hr class="mt-3">
				</div>
				<div class="row ">
					<div class="col-4">
						<label for="nom" class="form-label">Nom :</label>
					</div>
					<div class="col">
						<input type="text" class="form-control" name="nom" id="nom">

					</div>
					<hr class="mt-3">

				</div>
				<div class="row ">
					<div class="col-4">
						<label for="prenom" class="form-label">Prenom :</label>
					</div>
					<div class="col">
						<input type="text" class="form-control" name="prenom" id="prenom">

					</div>
					<hr class="mt-3">

				</div>
				<div class="row ">
					<div class="col-4">
						<label for="age" class="form-label">Age :</label>
					</div>
					<div class="col">
						<input type="number" class="form-control" name="age" id="age"
							min="1" max="99">

					</div>
					<hr class="mt-3">

				</div>
				<div class="row ">
					<div class="col-4">
						<label for="ville" class="form-label">Ville :</label>
					</div>
					<div class="col">
						<input type="text" class="form-control" name="ville" id="ville">
					</div>
					<hr class="mt-3">
				</div>
				<button type="submit" class="mt-2 btn btn-danger">Valider</button>
			</form>
		</section>
		<section></section>
		<c:if test="${listEtd != null}">
			<hr class="mt-3">
			<section>
				<div class="table-responsive mt-3">
					<table class="table table-hover	">
						<thead>
							<tr class="table-secondary">
								<th>Code</th>
								<th>Nom</th>
								<th>Prenom</th>
								<th>Age</th>
								<th>Ville</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listEtd}" var="element">
								<tr>
									<td><c:out value="${element.getCode()}" /></td>
									<td><c:out value="${element.getNom()}" /></td>
									<td><c:out value="${element.getPrenom()}" /></td>
									<td><c:out value="${element.getAge()}" /></td>
									<td><c:out value="${element.getVille()}" /></td>
									<td><c:url value="/delete_etudiant" var="deleteEtudiant">
											<c:param name="code" value="${element.getCode()}" />
										</c:url> <a href="${deleteEtudiant}" onclick="return confirmDelete();">
											<button class="btn btn-warning">Supprimer</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</section>
		</c:if>
	</div>

	<hr class="mt-3">
	<script>
		function confirmDelete() {
			return confirm("Are you sure you want to delete this record?");
		}
	</script>
	<script src="js/mdb.min.js"></script>
</body>
</html>