var maj_cpt = new Event("majcpt");

function afficher(){
	
	// Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	
    var param = "id=" + document.getElementById("idenseignant").innerHTML;
    var url = "ServletPlanning";
	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET",url + "?" + param);

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
			var l_cours = xhr.responseXML.getElementsByTagName("cours");
			var l_salles = xhr.responseXML.getElementsByTagName("salle");
			var l_dates = xhr.responseXML.getElementsByTagName("date");
		    var l_durees = xhr.responseXML.getElementsByTagName("duree");
			var l_hdebuts = xhr.responseXML.getElementsByTagName("hdebut");

			for (var i=0;i<6;i++){
				var date =new Date(document.getElementById("datecheck"+i).innerHTML);
				date.setHours(0, 0, 0, 0); 
				for(var j=0; j<l_dates.length; j++){
					var dateacheck=new Date(l_dates[j].firstChild.nodeValue);
					dateacheck.setHours(0, 0, 0, 0);
					if(dateacheck.getTime()===date.getTime()){
						switch (l_hdebuts[j].firstChild.nodeValue) {
  							case "08:00:00":
								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("1d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									 document.getElementById("1d"+i).rowSpan = 2;
									 let cell =document.getElementById("2d"+i);
									 let row = cell.parentNode;
									 row.removeChild(cell);
									 document.getElementById("1d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									 document.getElementById("1d"+i).rowSpan = 3;
									 let cell =document.getElementById("2d"+i);
									 let cell2 =document.getElementById("3d"+i);
									 let row = cell.parentNode;
									 let row2 = cell.parentNode;
									 row.removeChild(cell);
									 row2.removeChild(cell2);
									 document.getElementById("1d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
   								break;
   							case "09:30:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("2d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									 document.getElementById("2d"+i).rowSpan = 2;
									 let cell =document.getElementById("3d"+i);
									 let row = cell.parentNode;
									 row.removeChild(cell);
									 document.getElementById("2d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									 document.getElementById("2d"+i).rowSpan = 3;
									 let cell =document.getElementById("3d"+i);
									 let cell2 =document.getElementById("4d"+i);
									 let row = cell.parentNode;
									 let row2 = cell.parentNode;
									 row.removeChild(cell);
									 row2.removeChild(cell2);
									 document.getElementById("2d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
  								break;
  							case "11:00:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("3d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									 document.getElementById("3d"+i).rowSpan = 2;
									 let cell =document.getElementById("4d"+i);
									 let row = cell.parentNode;
									 row.removeChild(cell);
									 document.getElementById("3d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									 document.getElementById("3d"+i).rowSpan = 3;
									 let cell =document.getElementById("4d"+i);
									 let cell2 =document.getElementById("5d"+i);
									 let row = cell.parentNode;
									 let row2 = cell.parentNode;
									 row.removeChild(cell);
									 row2.removeChild(cell2);
									 document.getElementById("3d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
  								break;
  							case "14:00:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("4d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									 document.getElementById("4d"+i).rowSpan = 2;
									 let cell =document.getElementById("5d"+i);
									 let row = cell.parentNode;
									 row.removeChild(cell);
									 document.getElementById("4d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									 document.getElementById("4d"+i).rowSpan = 3;
									 let cell =document.getElementById("5d"+i);
									 let cell2 =document.getElementById("6d"+i);
									 let row = cell.parentNode;
									 let row2 = cell.parentNode;
									 row.removeChild(cell);
									 row2.removeChild(cell2);
									 document.getElementById("4d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
   								break;
   							case "15:30:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("5d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									 document.getElementById("5d"+i).rowSpan = 2;
									 let cell =document.getElementById("6d"+i);
									 let row = cell.parentNode;
									 row.removeChild(cell);
									 document.getElementById("5d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									 document.getElementById("5d"+i).rowSpan = 3;
									 let cell =document.getElementById("6d"+i);
									 let cell2 =document.getElementById("7d"+i);
									 let row = cell.parentNode;
									 let row2 = cell.parentNode;
									 row.removeChild(cell);
									 row2.removeChild(cell2);
									 document.getElementById("5d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
  								break;
  							case "17:00:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("6d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									 document.getElementById("6d"+i).rowSpan = 2;
									 let cell =document.getElementById("7d"+i);
									 let row = cell.parentNode;
									 row.removeChild(cell);
									 document.getElementById("6d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									 document.getElementById("6d"+i).rowSpan = 3;
									 let cell =document.getElementById("7d"+i);
									 let cell2 =document.getElementById("8d"+i);
									 let row = cell.parentNode;
									 let row2 = cell.parentNode;
									 row.removeChild(cell);
									 row2.removeChild(cell2);
									 document.getElementById("6d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									}
  								break;
  							case "18:30:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("7d"+i).innerHTML=l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div>";
									 }
   								break;
  							default:
								
  							 	break;
  							}
						

						
					}
				}
			}
			}
		};

	// Envoi de la requête.
	xhr.send();
	
}


document.addEventListener("DOMContentLoaded", () => {

	document.getElementById("afficher").addEventListener("click",afficher);


	

});