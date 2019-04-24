<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personne</title>
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/bootstrap.css" />
</head>
<body>
            <section class="container">
                <div>
                    <form action="Servlet">
                        <div class="form-group row">
                        	<input type="hidden" name="id" value="${id}" />
                        	<label for="prenom">Prénom</label>
                        	<input id="prenom" class="form-control" placeholder="Entrer prénom" type="text" name="prenom" value="${prenom}" required/>
                        </div>
                        <div class="form-group row">
                        	<label for="nom">Nom</label>
                        	<input id="nom" class="form-control" placeholder="Entrer nom" type="text" name="nom" value="${nom}" required/>
                        </div>
                        <div class="form-group row">
                        	<label for="age">Age</label>
                        	<input id="age" class="form-control" placeholder="Entrer age" type="number" name="age" value="${age}" required/>
  						</div> 
  						                        <div class="form-group row">
                        	<label for="login">Login</label>
                        	<input id="login" class="form-control" placeholder="Entrer login" type="text" name="login" value="${login}" required/>
  						</div>
  						  						</div> 
  						                        <div class="form-group row">
                        	<label for="mdp">pass</label>
                        	<input id="mdp" class="form-control" placeholder="Entrer mdp" type="password" name="mdp" value="${mdp}" required/>
  						</div> 
  												<div>
                            
                            <select name="idAdresses">
                            <optgroup>
                            <option value="0">---</option>
                            <c:if test="${! empty adresses}">
            			<c:forEach items="${adresses}" var="a">
            			<option value="${a.idAdresse}"><c:out value="${a.numRue},${a.nomRue},${a.ville}"/></option>
            			</c:forEach>
            			</c:if>
                            
                            </optgroup>
                            
                            </select>

						</div>
						<div>
                            
                            <button type="submit" name="ajouter" >Valider</button>

						</div>
						<div>
                            
                            <button type="submit" name="modifier" >Modifier</button>

						</div>

	
					</form>
				</div>
            </section>
            <section class="container">
            <h2> Liste des personnes en BDD</h2>
            	<table class = "table">
            		<thead>
            		<tr>
            			<th>idPersonne</th>
            			<th>Nom</th>
            			<th>Prénom</th>
            			<th>Age</th>
            			<th>SUPPRIMER</th>
            			<th>MODIFIER</th>
            			<th>idAdresse</th>
            			<th>idConnexion</th>
            		</tr>
            		</thead>
            		<tbody>
            		<c:if test="${! empty personne}">
            			<c:forEach items="${personne}" var="x">
            			<tr>
            				<td><c:out value="${x.idPersonne}"/></td>
            				<td><c:out value="${x.nom}"/></td>
            				<td><c:out value="${x.prenom}"/></td>
            				<td><c:out value="${x.age}"/></td>
            		
            				<td><a href="SupprimerPersonne?id=${x.idPersonne}">Supprimer</a></td>
            				<td><a href="ModifierPersonne?id=${x.idPersonne}">Modifier</a></td>
            						<td><c:out value="${x.adresse.idAdresse}"/></td>
            						<td><c:out value="${x.connexion.idConnexion}"/></td>
            			</tr>
            			</c:forEach>
            			</c:if>
            		</tbody>
            	</table>
            </section>
</body>
</html>