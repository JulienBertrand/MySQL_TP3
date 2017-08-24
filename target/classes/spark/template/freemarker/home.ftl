html>
	<head>
		<title>Table Demo_HTML</title>		
</head>
<table border collapse> 
	<thead><th>civilite</th><th>Nom</th><th>prenom</th></thead>
	<tbody>
		<#list objets as obj>
		<tr align=center><td>${obj.civilite}</td><td>${obj.nom}</td><td>${obj.prenom}</td></tr>
		</#list>
	</tbody>
</table>
</html>