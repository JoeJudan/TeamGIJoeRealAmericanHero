function loadString(jString){
    document.getElementById("decision").innerHTML=jString;


}

function handleEvent(){
	var etype=document.getElementById("etype").value;
	var grade=document.getElementById("grade").value;
	console.log("This is being called");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("This is being called");
		if(xhr.readyState==4 && xhr.status==200){
			console.log("The if statement has been reached");
			var jString = JSON.parse(xhr.responseText);
			loadString(jString);
	
		}	
	}
	xhr.open("POST", "gradeformat?etype="+etype+"&grade="+grade, true);	
	xhr.send();
	
}

window.onload = function(){
	document.getElementById("myBtn").addEventListener("click", handleEvent, false);
}
