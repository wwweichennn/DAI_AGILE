var maj_cpt = new Event("majcpt");

var date = {
    isDuringDate: function (beginDateStr, endDateStr) {
        var curDate = new Date(),
            beginDate = new Date(beginDateStr),
            endDate = new Date(endDateStr);
        if (curDate >= beginDate && curDate <= endDate) {
            return true;
        }
        return false;
    }
}

function afficherCours(){
	
	// Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	
    var param = "id=" + document.getElementById("idenseignant").innerHTML;
    var url = "CtrlCoursAnnee";
	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET",url + "?" + param);
	
	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
				var l_cours = xhr.responseXML.getElementsByTagName("cours");
				var l_date = xhr.responseXML.getElementsByTagName("date");
				
				for(var i=0;i<5;i++){
					var date = new Date(document.getElementById("datecheck"+i).innerHTML);
					
					if(date.isDuringDate('2022/09/01', '2023/08/31')){
						document.getElementById(nomc).insertAdjacentHTML('afterbegin',"<a href='CrtlCoursAnnee?id="+l_ids[j].firstChild.nodeValue+"&cours="+l_cours[j].firstChild.nodeValue</li>")
					}
	
	
				}
			}
			
			
		};
		
	// Envoi de la requête.
	xhr.send();
	
}


document.addEventListener("DOMContentLoaded", () => {

	document.getElementById("afficher").addEventListener("click",afficherCours);

});