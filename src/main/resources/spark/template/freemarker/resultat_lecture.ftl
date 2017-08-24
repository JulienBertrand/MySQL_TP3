html>
	<head>
		<title>Table Demo_HTML</title>
		
</head>
<table border collapse> 
	<thead><th>civilite</th><th>Nom</th><th>prenom</th></thead>
	<tbody>
		<#list Demo as demoModifier>
		<tr align=center><td>${demoModifier.civilite}</td><td>${demoModifier.nom}</td><td>${demoModifier.prenom}</td></tr>
		</#list>
	</tbody>
</table>
</html>