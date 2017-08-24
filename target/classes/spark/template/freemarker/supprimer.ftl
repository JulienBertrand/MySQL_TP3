<html>

	<form action="/resultat_supprimer" method="get">
	
	</head>
<table border collapse> 
	<thead><th>nom</th></thead>
	<tbody> 
<#list objets as obj>
<tr align=center><td>${obj.civilite}</td><td>${obj.nom}</td><td>${obj.prenom}</td></tr>
</#list>
</tbody>
</table>	
	
		Id : <input type="text" name="Id">	
		<br>
		
		
		<button type="submit">Valider !</button>
			
	
	</form>


</html>