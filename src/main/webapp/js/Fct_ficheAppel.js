function valider(){
		    var nb = document.getElementById("nb").innerHTML;
		    var seanceID = document.getElementById("id").innerHTML;
		    var studentItems = [];

		    for (let i = 0; i < nb; i++) {
		        const text = document.getElementById("text" + i);
		        if (text.innerHTML === "absent") {
		            studentItems.push(document.getElementById("etu_id" + i));
		        }
		    }

		    // 创建一个包含所有学生值的数组
		    var students = [];
		    for (var i = 0; i < studentItems.length; i++) {
		        students.push(studentItems[i].getAttribute('value'));
		    }

		    // 将学生数组添加到表单数据中
		    var formData = new FormData();
		    for (var j = 0; j < students.length; j++) {
		        formData.append('students[]', students[j]);
		    }
		    formData.append('seance_id', seanceID);
		    
		    var xhr = new XMLHttpRequest();
		    xhr.open('POST', 'CtrlValiderFicheAppel', true);

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
		
			var l_ids = xhr.responseXML.getElementsByTagName("id");
			var l_seanceids = xhr.responseXML.getElementsByTagName("seanceid");
			
			var test=document.getElementById("test");
					test.innnerHTML=l_seanceids[0].firstChild.nodeValue
				}
			
	// Envoi de la requête.
	xhr.send(formData);
	
}
}

document.addEventListener("DOMContentLoaded", () => {

	document.getElementById("btnValider").addEventListener("click",valider);


	

});