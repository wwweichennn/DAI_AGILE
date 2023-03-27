var maj_cpt = new Event("majcpt");

function valider(){
    // 获取学生列表元素
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

		    // 发送表单数据到Servlet
		    var xhr = new XMLHttpRequest();
		    xhr.open('POST', 'CtrlActionFicheAppel');
		    
	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
				var btnValider=document.getElementById("btnValider");
			    btnValider.disabled = "disabled";
				
					}
				}
			
	// Envoi de la requête.
	 xhr.send(formData);
	
}


document.addEventListener("DOMContentLoaded", () => {

	document.getElementById("btnValider").addEventListener("click",valider);


	

});