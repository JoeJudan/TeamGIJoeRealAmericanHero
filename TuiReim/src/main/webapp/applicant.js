

document.getElementById("amount").addEventListener("change", alerter);
document.getElementById("etype").addEventListener("change", alerter);
document.getElementById("currentDate").value = today;

function alerter() {
	document.getElementById("amount").value = parseFloat(
			document.getElementById("amount").value).toFixed(2);
	var amount2 = document.getElementById("amount").value;

	var event = document.getElementById("etype").value;

	switch (event) {
	case "University_Courses":
		if(parseFloat((amount2 * .80))>1000){
			document.getElementById("ramount").value=1000.00;
		}
		else{
			document.getElementById("ramount").value = parseFloat((amount2 * .80)).toFixed(2);
		}
		break;
	case "Seminars":
		if(parseFloat((amount2 * .60))>1000){
			document.getElementById("ramount").value=1000.00;
		}
		else{
			document.getElementById("ramount").value = parseFloat((amount2 * .60)).toFixed(2);
		}
		break;
	case "Certification_Preparation_Classes":
		if(parseFloat((amount2 * .75))>1000){
			document.getElementById("ramount").value=1000.00;
		}
		else{
			document.getElementById("ramount").value = parseFloat((amount2 * .75)).toFixed(2);
		}
		break;
	case "Certification":
		if(parseFloat(amount2)>1000){
			document.getElementById("ramount").value=1000.00;
		}
		else{
			document.getElementById("ramount").value = parseFloat(amount2).toFixed(2);
		}
		break;
	case "Technical_Training":
		if(parseFloat((amount2 * .90))>1000){
			document.getElementById("ramount").value=1000.00;
		}
		else{
			document.getElementById("ramount").value = parseFloat((amount2 * .90)).toFixed(2);
		}
		break;
	case "Others":
		if(parseFloat((amount2 * .30))>1000){
			document.getElementById("ramount").value=1000.00;
		}
		else{
			document.getElementById("ramount").value = parseFloat((amount2 * .30)).toFixed(2);
		}
		break;
	default:
		console.log("Error caught calculating reimbursement amount in form.js");
	}
}