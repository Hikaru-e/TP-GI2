<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String[] descriptions = request.getParameterValues("description");
	String[] quantites = request.getParameterValues("quantite");
	String[] prixs = request.getParameterValues("prix");

	
	float total_net_ht = 0f;
	float total_ht = 0f;
	float tva_factor = 20/100f;
	float tva = 0f;
	float remise = Integer.parseInt(request.getParameter("remise"))/100f;
	float total_ttc = 0f;
	
	String facture = session.getAttribute("facture").toString(); 

%>



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/mdb.min.css">
</head>

<body>
    <div class="container">
        <div class="title mt-5" style="text-align:center">
            <h1>Facture</h1>
        </div>
        <form action="Facture.jsp" method="post">
            <div class="upperForm">
                <div class="mt-2">
                    <label for="nom_c" class="form-label">Nom Client :</label>
                    <input type="text" class="form-control" name="nom_c" id="nom_c" disabled value="<%=request.getParameter("nom_c")%>">
                    <input type="hidden" name="nom_c" id="nom_c" value="<%=request.getParameter("nom_c")%>">
                </div>
                <div class="mt-2">
                    <label for="adr_c" class="form-label">Adresse Client :</label>
                    <input type="text" class="form-control" name="adr_c" id="adr_c" disabled value="<%=request.getParameter("adr_c")%>">
                    <input type="hidden" name="adr_c" id="adr_c" value="<%=request.getParameter("adr_c")%>">
                </div>
                <div class="mt-2">
                    <label for="email_c" class="form-label">Email Client :</label>
                    <input type="email" class="form-control" name="email_c" id="email_c" disabled value="<%=request.getParameter("email_c")%>">
                    <input type="hidden" name="email_c" id="email_c" value="<%=request.getParameter("email_c")%>">
                </div>
            </div>
            <div class="facture_n">
                <div class="mt-5 col-6 offset-6">
                    <label for="nom_c" class="form-label">Facture N° : </label>
                    <input type="text" class="form-control" disabled value="<%=facture%>">
                </div>
            </div>
            <div class="table-responsive mt-3">
                <table class="table table-striped
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
                    <%
                    	for(int i = 0 ; i<descriptions.length;i++){
					%>
                        <tr class="table-secondary">
                            <td scope="row">
                            	<%=descriptions[i] %>
                            	<input type="hidden" name="description" value="<%=descriptions[i] %>">
                            </td>
                            <td>
                            	<input type="number" min="0" max="99" style="width: 80px;" name="quantite"
                                    id="quantite"  value="<%=quantites[i]%>">
                            </td>

                            <td>
                                <input type="number" step="0.01" placeholder="0.00" min="0.00" 
                                    style="width: 100px;" name="prix" id="prix"  value="<%=Float.parseFloat(prixs[i])%>"> DH
                            </td>

							<%total_ht = Integer.parseInt(quantites[i]) * Float.parseFloat(prixs[i]);
							total_net_ht+=total_ht;
							%>
                            <td><%=total_ht%> DH</td>
                        </tr>
                        <%                    		
                    	}
                    	%>

                        <tr class="table-secondary">
                            <td colspan="2" rowspan="5" scope="row" align="center" style="width: 50px;">
                                <strong>Conditions de paiment</strong><br>
                                <p class="mt-2">
                                    Les modes de paiment acceptés incluent le chèque, le virement bancaire et la carte
                                    de
                                    crédit
                                </p>
                            </td>
                        </tr>
                        <tr class="table-secondary">
                            <td><strong>Total net HT</strong></td>
                            <td><%=total_net_ht %> DH</td>
                        </tr>
                        <tr class="table-secondary">
                            <td>TVA</td>
                            <%tva = total_net_ht*tva_factor;%>
                            <td><%=tva%> DH</td>
                        </tr>
                        <tr class="table-secondary">
                            <td>Remise</td>
                            <td><input type="number" min="0" max="100"
								style="width: 50px;" name="remise" id="remise" required value="<%=request.getParameter("remise")%>"> %</td>
                        </tr>
                        <tr class="table-secondary">
                            <td><strong>Total TTC:</strong></td>
                            <td>
                                <strong>
                                <%total_ttc = total_net_ht+tva-((total_net_ht+tva)*remise); %>
                                    <%=String.format("%.2f", total_ttc)%> DH
                                </strong>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div style="text-align: right">
                <button type="submit" class="btn mb-5 btn-primary" style="width: 20%;">Calculer</button>
            </div>
        </form>
    </div>
	<script src="js/mdb.min.js"></script>
	
</body>

</html>