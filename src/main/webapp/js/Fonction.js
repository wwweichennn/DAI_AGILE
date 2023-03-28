/**
 *  Possède des fonctions javaScript 
 */


let validationValue= document.getElementById("setJustif");
let count = 0;

const data = [];
var nb=document.getElementById("nbJ").innerHTML;
let id;
for (let i = 0; i < nb; i++) {
  id = "btn_validate_" + i;
  data.push({ id: id });
}

 function changeButton() {
	 
	 for(let i=0; i<nb; i++) 
	 {
		const button = document.getElementById("btn_validate_"+i);
    	button.addEventListener("click", () => {
			 
        count++; // Incrémentation du compteur
        
        
        // Changement de la couleur du bouton en fonction du compteur
        if (count === 1) {
            button.style.backgroundColor = "green";			//Bouton devient vert
            button.innerHTML = "Valider";					//Ecris Valider
            validationValue.innerHTML = "justificatif.setValidation(true)";	//Va inserer dans la jsp la fonction
            console.log(validationValue);					//affiche simplement dans la console la fonction
        } else if (count === 2) {
            button.style.backgroundColor = "red";
            button.innerHTML = "Refuser";
            validationValue.innerHTML = "justificatif.setValidation(false)";
            console.log("count " + count);
        } else {
            count = 0; // Réinitialisation du compteur
            button.style.backgroundColor = "";
            button.innerHTML = "Attente";
            validationValue.innerHTML = "justificatif.setValidation(false)";
            console.log(validationValue);
        }
    }); 
	 }

}

 
document.addEventListener("DOMContentLoaded", () => {
	var nb=document.getElementById("nbJ").innerHTML;
	 console.log("nombre" + nb);
	 
	 for(let i=0; i<nb; i++)
	document.getElementById("btn_validate_"+i).addEventListener("click", changeButton);
 });