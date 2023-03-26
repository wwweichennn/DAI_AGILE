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
			var l_ids = xhr.responseXML.getElementsByTagName("id");
			var l_cours = xhr.responseXML.getElementsByTagName("cours");
			var l_salles = xhr.responseXML.getElementsByTagName("salle");
			var l_dates = xhr.responseXML.getElementsByTagName("date");
		    var l_durees = xhr.responseXML.getElementsByTagName("duree");
			var l_hdebuts = xhr.responseXML.getElementsByTagName("hdebut");
			var l_statuts = xhr.responseXML.getElementsByTagName("statut");

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
									 document.getElementById("1d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("1d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("1d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("1d"+i).style.backgroundColor = "red";
										 break;
									 }
								}
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									 document.getElementById("1d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("2d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("1d"+i).style.backgroundColor = "green";
										 document.getElementById("2d"+i).style.backgroundColor = "green";
									     
										 break;
										 case"enregistrer":
										document.getElementById("1d"+i).style.backgroundColor = "orange";
										 document.getElementById("2d"+i).style.backgroundColor = "orange";
									   
										 break;
										 case"novalide":
										 document.getElementById("1d"+i).style.backgroundColor = "red";
										 document.getElementById("2d"+i).style.backgroundColor = "red";
										 break;
									 }
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									 document.getElementById("1d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 
									 document.getElementById("2d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									
									 document.getElementById("3d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
								switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("1d"+i).style.backgroundColor = "green";
										 document.getElementById("2d"+i).style.backgroundColor = "green";
									     document.getElementById("3d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("1d"+i).style.backgroundColor = "orange";
										 document.getElementById("2d"+i).style.backgroundColor = "orange";
									     document.getElementById("3d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("1d"+i).style.backgroundColor = "red";
										 document.getElementById("2d"+i).style.backgroundColor = "red";
										 document.getElementById("3d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									}
   								break;
   							case "09:30:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("2d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("2d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("2d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("2d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									
									 document.getElementById("2d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
								
									 document.getElementById("3d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									
									switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 
										 document.getElementById("2d"+i).style.backgroundColor = "green";
									     document.getElementById("3d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										
										 document.getElementById("2d"+i).style.backgroundColor = "orange";
									     document.getElementById("3d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										
										 document.getElementById("2d"+i).style.backgroundColor = "red";
										 document.getElementById("3d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									 
									 document.getElementById("2d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									
									 document.getElementById("3d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
							
									 document.getElementById("4d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("2d"+i).style.backgroundColor = "green";
										 document.getElementById("4d"+i).style.backgroundColor = "green";
									     document.getElementById("3d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("4d"+i).style.backgroundColor = "orange";
										 document.getElementById("2d"+i).style.backgroundColor = "orange";
									     document.getElementById("3d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("4d"+i).style.backgroundColor = "red";
										 document.getElementById("2d"+i).style.backgroundColor = "red";
										 document.getElementById("3d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									}
  								break;
  							case "11:00:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("3d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
									     document.getElementById("3d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
									     document.getElementById("3d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("3d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									 
									 document.getElementById("3d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
							
									 document.getElementById("4d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("4d"+i).style.backgroundColor = "green";
									     document.getElementById("3d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("4d"+i).style.backgroundColor = "orange";
									     document.getElementById("3d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("4d"+i).style.backgroundColor = "red";
										 document.getElementById("3d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									
									 document.getElementById("3d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("4d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("5d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("5d"+i).style.backgroundColor = "green";
										 document.getElementById("4d"+i).style.backgroundColor = "green";
									     document.getElementById("3d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("5d"+i).style.backgroundColor = "orange";
										 document.getElementById("4d"+i).style.backgroundColor = "orange";
									     document.getElementById("3d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("5d"+i).style.backgroundColor = "red";
										 document.getElementById("4d"+i).style.backgroundColor = "red";
										 document.getElementById("3d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									}
  								break;
  							case "14:00:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("4d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("4d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("4d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("4d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									
									 document.getElementById("4d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("5d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("4d"+i).style.backgroundColor = "green";
										 document.getElementById("5d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("4d"+i).style.backgroundColor = "orange";
										 document.getElementById("5d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("4d"+i).style.backgroundColor = "red";
										 document.getElementById("5d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									
									}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									
									 document.getElementById("4d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("5d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("6d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("4d"+i).style.backgroundColor = "green";
										 document.getElementById("5d"+i).style.backgroundColor = "green";
									     document.getElementById("6d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("4d"+i).style.backgroundColor = "orange";
										 document.getElementById("5d"+i).style.backgroundColor = "orange";
									     document.getElementById("6d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("4d"+i).style.backgroundColor = "red";
										 document.getElementById("5d"+i).style.backgroundColor = "red";
										 document.getElementById("6d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									}
   								break;
   							case "15:30:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("5d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("5d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("5d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("5d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									
									 document.getElementById("5d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("6d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("5d"+i).style.backgroundColor = "green";
										 document.getElementById("6d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("5d"+i).style.backgroundColor = "orange";
										 document.getElementById("6d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("5d"+i).style.backgroundColor = "red";
										 document.getElementById("6d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									}
								  else if(l_durees[j].firstChild.nodeValue/90==3){
									
									 document.getElementById("5d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("6d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("7d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("5d"+i).style.backgroundColor = "green";
										 document.getElementById("6d"+i).style.backgroundColor = "green";
									     document.getElementById("7d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("5d"+i).style.backgroundColor = "orange";
										 document.getElementById("6d"+i).style.backgroundColor = "orange";
									     document.getElementById("7d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("5d"+i).style.backgroundColor = "red";
										 document.getElementById("6d"+i).style.backgroundColor = "red";
										 document.getElementById("7d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									}
  								break;
  							case "17:00:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("6d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("6d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("6d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("6d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									 }
								  else if(l_durees[j].firstChild.nodeValue/90==2){
									 
									 document.getElementById("6d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 document.getElementById("7d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("6d"+i).style.backgroundColor = "green";
										 document.getElementById("7d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("6d"+i).style.backgroundColor = "orange";
										 document.getElementById("7d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("6d"+i).style.backgroundColor = "red";
										 document.getElementById("7d"+i).style.backgroundColor = "red";
										 break;
									 }
								
									}
								  
  								break;
  							case "18:30:00":
  								  if(l_durees[j].firstChild.nodeValue/90==1){
									 document.getElementById("7d"+i).innerHTML="<a href='CtrlFicheAppel?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue+"&date="+l_dates[j].firstChild.nodeValue+"'>"+l_cours[j].firstChild.nodeValue+"<div>"+
									 l_salles[j].firstChild.nodeValue+"</div></a>";
									 switch(l_statuts[j].firstChild.nodeValue){
										 case"valide":
										 document.getElementById("7d"+i).style.backgroundColor = "green";
										 break;
										 case"enregistrer":
										 document.getElementById("7d"+i).style.backgroundColor = "orange";
										 break;
										 case"novalide":
										 document.getElementById("7d"+i).style.backgroundColor = "red";
										 break;
									 }
								
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