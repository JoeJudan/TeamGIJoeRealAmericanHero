function loadString(jString){
    document.getElementById("applicationid").innerHTML=jString.applicationId;
    document.getElementById("eventtype").innerHTML=jString.eventType;
    document.getElementById("appdate").innerHTML=jString.appDate;
    document.getElementById("eventdate").innerHTML=jString.eventTime;
    document.getElementById("amount").innerHTML="$"+jString.amount;
    document.getElementById("grade").innerHTML=jString.grade;
    document.getElementById("status").innerHTML=jString.status;
    document.getElementById("reason").innerHTML=jString.reason;
    document.getElementById("firstname", "lastname").innerHTML=jString.firstName+" "+jString.lastName;

}
function handleEvent(jString2){
	
	var  uname =jString2;
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("This is being called");
		if(xhr.readyState==4 && xhr.status==200){
			console.log("The if statement has been reached");
			var jString = JSON.parse(xhr.responseText);
			loadString(jString);		
		}
	
	}	
	xhr.open("POST", "home?username="+uname, true);	
	xhr.send();
}

function loadEvent(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("This is being called");
		if(xhr.readyState==4 && xhr.status==200){
			console.log("The if statement has been reached");
			var jString2 = JSON.parse(xhr.responseText);
			handleEvent(jString2);	
		}
	}
		xhr.open("GET", "home", true);
	
		xhr.send();
}

function getUpdate(){
	document.getElementById("upDate").addEventListener("hidden", getUpdate, false);
	let table = document.getElementById("righttable");
	let newRow = document.createElement("tr");
	
    newRow.innerHTML =
    	
    	`<table>
    	<tr id="cell">
	    	<td>
		    	<label for="lname">
		    		<b>Update Grade</b>
		    	</label>
		    	<input type="text" class="form-control" id="lname" placeholder="Enter Grade" 
				name="grade" required="required">
			</td>
	    </tr>
	    
    	<tr id="cell">
		    <td>
		    	<label for="attachedfile">
		    		<b>Attachments Supporting Docs:</b>
		    	</label> 
		    		<input	type="file" id="attachedfile" name="attachedfile"
								accept=".pdf, .png, .jpeg, .jpg, .txt, .doc, .msg" /> <br />
			</td>
		</tr>
		</table>				
	<button type="submit" class="btn btn-primary btn-block">Submit</button>`;
    
    table.appendChild(newRow);
}

window.onload = function(){

	document.getElementById("myBtn").addEventListener("click", loadEvent, false);
	document.getElementById("upDate").addEventListener("click", getUpdate, false);
}
