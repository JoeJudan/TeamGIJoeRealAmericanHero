
function loadString(jString){

	let table = document.getElementById("lefttable");
	
	if(jString != null){
		for(i in jString){
		let newRow = document.createElement("tr");
		document.getElementById.innerHTML=jString[i].firstName;
		document.getElementById.innerHTML=jString[i].lastName;	
		document.getElementById.innerHTML=jString[i].applicationId;
		document.getElementById.innerHTML=jString[i].eventType;
		document.getElementById.innerHTML=jString[i].appDate;
		document.getElementById.innerHTML=jString[i].eventTime;
		document.getElementById.innerHTML="$"+jString[i].amount;
		document.getElementById.innerHTML=jString[i].approvallevel;
		document.getElementById.innerHTML=jString[i].status;
		document.getElementById.innerHTML=jString[i].reason;
	
	    newRow.innerHTML =
	    	
	    `<tr id="cell">
	    <td>${jString[i].firstName}</td>
	    <td>${jString[i].lastName}</td>
	    <td>${jString[i].applicationId}</td>
	    <td>${jString[i].eventType}</td>
	    <td>${jString[i].appDate}</td>
	    <td>${jString[i].eventTime}</td>
	    <td>${"$"+jString[i].amount}</td>
	    <td><a href="#">${jString[i].approvallevel}</a></td>
	    <td>${jString[i].status}</td>
	    <td>${jString[i].reason}</td>
	    </tr>`;
	    
	    table.appendChild(newRow);
		}
	}else 
		alert("There is no request for this option yet");	
}

function allPending(){
	
	var  pend ="pending";
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("This is being called");
		if(xhr.readyState==4 && xhr.status==200){
			console.log("The if statement has been reached");
			var jString = JSON.parse(xhr.responseText);
			loadString(jString);		
		}
	}
	xhr.open("POST", "manager?status="+pend, true);
	xhr.send();
}

function deniedRequests(){
	
	var  denied ="denied";
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("This is being called");
		if(xhr.readyState==4 && xhr.status==200){
			console.log("The if statement has been reached");
			var jString = JSON.parse(xhr.responseText);
			loadString(jString);		
		}
	}
	xhr.open("POST", "manager?status="+denied, true);
	xhr.send();
}

function approvedRequests(){
	var approved = "approved";
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("This is being called");
		if(xhr.readyState==4 && xhr.status==200){
			console.log("The if statement has been reached");
			var jString = JSON.parse(xhr.responseText);
			loadString(jString);		
		}
	}
	xhr.open("POST", "manager?status="+approved, true);
	xhr.send();
}

function allRequests(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("This is being called");
		if(xhr.readyState==4 && xhr.status==200){
			console.log("The if statement has been reached");
			var jString = JSON.parse(xhr.responseText);
			loadString(jString);		
		}
	}
	xhr.open("POST", "manager?status="+"", true);
	xhr.send();
}

function approvedRequests(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("This is being called");
		if(xhr.readyState==4 && xhr.status==200){
			console.log("The if statement has been reached");
			var jString = JSON.parse(xhr.responseText);
			loadString(jString);		
		}
	}
	xhr.open("POST", "manager?status="+"", true);
	xhr.send();
}

//function singleRequest(){
//	var aid = document.getElementById("eid").value; 
//	
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		console.log("This is being called");
//		if(xhr.readyState==4 && xhr.status==200){
//			console.log("The if statement has been reached");
//			var jString = JSON.parse(xhr.responseText);
//			loadString(jString);		
//		}
//	}
//	xhr.open("POST", "allrequests?eid="+eid, true);
//	xhr.send();
//}

 window.addEventListener("load", allRequests, false);


window.onload = function(){
	document.getElementById("allRequests").addEventListener("click", allRequests, false);
	document.getElementById("Denied").addEventListener("click", deniedRequests, false);
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