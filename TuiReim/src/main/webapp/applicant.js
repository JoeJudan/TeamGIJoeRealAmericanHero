var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1; // January is 0!
var yyyy = today.getFullYear();

if (dd < 10) {
	dd = '0' + dd
}

if (mm < 10) {
	mm = '0' + mm
}

today = yyyy + '-' + mm + '-' + dd;
// https://www.htmlgoodies.com/html5/javascript/calculating-the-difference-between-two-dates-in-javascript.html
// ///////////////////////////////////////////////// FUNCTION TO COUNT # OF DAYS
// Date.daysBetween = function(date1, date2) {
// // Get 1 day in milliseconds
// var one_day = 1000 * 60 * 60 * 24;
//
// // Convert both dates to milliseconds
// var date1_ms = date1.getTime();
// var date2_ms = date2.getTime();
//
// // Calculate the difference in milliseconds
// var difference_ms = date2_ms - date1_ms;
//
// // Convert back to days and return
// return Math.round(difference_ms / one_day);
// }
//
// // Set the two dates
// var y2k = new Date(2000, 0, 1);
// var Jan1st2010 = new Date(y2k.getFullYear() + 10, y2k.getMonth(),
// y2k.getDate());
// var today = new Date();
// // displays 726
// console.log('Days since ' + Jan1st2010.toLocaleDateString() + ': '
// + Date.daysBetween(Jan1st2010, today));

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