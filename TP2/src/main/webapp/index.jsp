<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%!int billNumber = 1000;%>
<%
session.setAttribute("facture", billNumber);
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TP2 JEE</title>
<link rel="stylesheet" href="css/mdb.min.css">
</head>

<body>
	<div class="container">
		<div class="title mt-5" style="text-align: center">
			<h1>Facture</h1>
		</div>
		<form action="Facture.jsp" method="post">
			<div class="upperForm">
				<div class="mt-2">
					<label for="nom_c" class="form-label">Nom Client :</label> <input
						type="text" class="form-control" name="nom_c" id="nom_c" required>
				</div>
				<div class="mt-2">
					<label for="adr_c" class="form-label">Adresse Client :</label> <input
						type="text" class="form-control" name="adr_c" id="adr_c" required>
				</div>
				<div class="mt-2">
					<label for="email_c" class="form-label">Email Client :</label> <input
						type="email" class="form-control" name="email_c" id="email_c"
						placeholder="abc@mail.com" required>
				</div>
			</div>
			<div class="facture_n">
				<div class="mt-5 col-6 offset-6">
					<label for="nom_c" class="form-label">Facture N° : </label> <input
						type="text" class="form-control" disabled
						value="<%=billNumber++%>">
				</div>
			</div>
			<div class="table-responsive mt-3">
				<table
					class="table table-striped
            table-hover	
            table-borderless
            table-primary
            align-middle">
					<thead class="table-light">
						<caption>Facture</caption>
						<tr>
							<th>Description</th>
							<th>Quantite</th>
							<th>Prix Unitaire</th>
							<th>Total HT</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<tr class="table-secondary">
							<td scope="row">Ordinateur portable, Macbook Pro M2 <input
								type="hidden" name="description"
								value="Ordinateur portable, Macbook Pro M2">
							</td>
							<td><input type="number" min="0" max="99"
								style="width: 80px;" name="quantite" id="quantite" required></td>

							<td><input type="number" step="0.01" placeholder="0.00"
								min="0.00" required style="width: 100px;" name="prix" id="prix">
								DH</td>

							<td></td>
						</tr>
						<tr class="table-secondary">
							<td scope="row">Imprimante Hp Pro 7740 <input type="hidden"
								name="description" value="Imprimante Hp Pro 7740">
							</td>
							<td><input type="number" min="0" max="99"
								style="width: 80px;" name="quantite" id="quantite" required></td>
							<td><input type="number" step="0.01" placeholder="0.00"
								min="0.00" required style="width: 100px;" name="prix" id="prix">
								DH</td>
							<td></td>
						</tr>
						<tr class="table-secondary">
							<td scope="row">Disque dur SSD 500Go <input type="hidden"
								name="description" value="Disque dur SSD 500Go">
							</td>
							<td><input type="number" min="0" max="99"
								style="width: 80px;" name="quantite" id="quantite" required></td>
							<td><input type="number" step="0.01" placeholder="0.00"
								min="0.00" required style="width: 100px;" name="prix" id="prix">
								DH</td>
							<td></td>
						</tr>
						<tr class="table-secondary">
							<td colspan="2" rowspan="5" scope="row" align="center"
								style="width: 50px;"><strong>Conditions de paiment</strong><br>
								<p class="mt-2">Les modes de paiment acceptés incluent le
									chèque, le virement bancaire et la carte de crédit</p></td>

						</tr>
						<tr class="table-secondary">
							<td><strong>Total net HT</strong></td>
							<td></td>
						</tr>
						<tr class="table-secondary">
							<td>TVA</td>
							<td></td>
						</tr>
						<tr class="table-secondary">
							<td>Remise</td>
							<td><input type="number" min="0" max="100"
								style="width: 50px;" name="remise" id="remise" required>
								%</td>
						</tr>
						<tr class="table-secondary">
							<td><strong>Total TTC:</strong></td>
							<td><strong> 0.00DH </strong></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div style="text-align: right">
				<button type="submit" class="btn mb-5 btn-primary"
					style="width: 20%;">Calculer</button>
			</div>
		</form>
	</div>
	<script src="js/mdb.min.js"></script>
</body>

</html>