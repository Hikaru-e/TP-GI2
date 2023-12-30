<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TP1 JEE</title>
    <link rel="stylesheet" href="css/mdb.min.css">
</head>

<body>
    <div class="container mt-5" style="width: 768px;">
        <div class="text-center" style="background-color: gainsboro; border: 1px black solid; border-radius:10px">
            <h1 class="mt-2">
                Formulaire d'inscription
            </h1>
            <p>
                (tous les champs sont obligatoires)
            </p>
        </div>
        <div class="mt-2" style="background-color: gainsboro; border: 1px black solid; border-radius:10px">
            <form action="signin" method="POST">
                <div class="m-4">
                    <div class="m-2" style="display: flex; justify-content: space-between;">
                        <div class="m-1">
                            <label class="forma-label" for="civilite">Civilité</label>
                            <input type="text" class="form-control" name="civilite" id="civilite" />
                        </div>

                        <div class="m-1">
                            <label class="forma-label" for="cp">CP</label>
                            <input type="text" class="form-control" name="cp" id="cp" />
                        </div>
                        <div class="m-1">
                            <label class="forma-label" for="ville">Ville</label>
                            <input type="text" class="form-control" name="ville" id="ville" />
                        </div>

                    </div>
                    <div class="m-3">
                            <div class="row">
                                <div class="col-6">
                                    <label class="forma-label" for="nom">Nom de famille</label>
                                    <input type="text" class="form-control" name="nom" id="nom" />
                                </div>
                                <div class="col-6">
                                    <label class="forma-label" for="prenom">Prenom</label>
                                    <input type="text" class="form-control" name="prenom" id="prenom" />
                                </div>
                            </div>
                    </div>
                    <div class="m-3">
                            <label class="forma-label" for="adresse">Adresse</label>
                            <input type="text" class="form-control" class="form-control" name="adresse" id="adresse" />
                    </div>
                    <div class="m-2" style="display: flex; justify-content: space-between;">
                        <div class="m-1">
                            <label class="forma-label" for="naissance">Naissance</label>
                            <input type="date" class="form-control" name="naissance" id="naissance" />
                        </div>
                        <div class="m-1">
                            <label class="forma-label" for="mail">Mail</label>
                            <input type="email" class="form-control" name="mail" id="mail" />
                        </div>
                        <div class="m-1">
                            <label class="forma-label" for="telephone">Téléphone</label>
                            <input type="text" class="form-control" name="telephone" id="telephone" />
                        </div>
                    </div>
                    <div class="m-2" style="text-align: right">
                        <input class="btn btn-primary" type="submit" name="soumettre" id="soumettre"  />
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script src="js/mdb.min.js"></script> 
</body>

</html>