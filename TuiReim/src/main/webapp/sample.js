

function loadString(jString){
    document.getElementById("applicationid").innerHTML=jString.applicationId;
    document.getElementById("eventtype").innerHTML=jString.eventType;
    document.getElementById("eventdate").innerHTML=jString.eventTime;
    document.getElementById("amount").innerHTML=jString.amount;
    document.getElementById("status").innerHTML=jString.status;
    document.getElementById("reason").innerHTML=jString.reason;
}


/*function viewInfo()
{
	window.open('http://localhost:8080/TuiReim/HomeServlet');
}*/


function handleEvent(){
	
	//var  uname =document.getElementById("username").value;

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("This is being called");
		if(xhr.readyState==4 && xhr.status==200){
			console.log("The if statement has been reached");
			var jString = JSON.parse(xhr.responseText);
			loadString(jString);		
		}
	}
	
	xhr.open("POST", "home", true);
//	xhr.open("POST", "home?username="+uname, true);
	
	xhr.send();
}


window.onload = function(){
	
	handleEvent();
	//document.getElementById("myBtn").addEventListener("click", handleEvent, false);
}














/*function loadCharacter(character){
    document.getElementById("name").innerHTML=character.name;
}
function getCharacter(){
    console.log("test check number 1");
    var characterID = document.getElementById("swID").value;
    //Step 1
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function(){
        console.log("test check number 2");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var character= JSON.parse(xhr.responseText);
            loadCharacter(character);
        }
    }
    //Step 3
    xhr.open("GET","/dataBase"+characterID,true);
    //Step 4
    xhr.send();
}
window.onload= function(){
    console.log("in onload");
    document.getElementById("starwarssubmit").addEventListener("click",getCharacter,false);
}*/