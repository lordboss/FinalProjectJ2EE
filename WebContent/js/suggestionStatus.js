/**
 * @author tqthe
 */

var asyncRequest;
var pid; // unique id of <span> tag that contains suggestion status

function setStatus(url, id) {
	pid = id;
	var newStatus = "newStatus" + id;
	// get new suggestion status id
	var sid = document.getElementById(newStatus).value;
	// append as request parameter
	url = url + "&sid=" + sid;
	
	try {
    	asyncRequest = new XMLHttpRequest();
		
    	// register event handler 
    	asyncRequest.onreadystatechange = stateChange;
    	asyncRequest.open('GET', url, true);
    	asyncRequest.send(null);
	} catch ( exception ) {
    	alert('Send request failed');
    	document.body.style.cursor='default';
	}
}

function stateChange() {
	var vSpan = 'v' + pid;
	
	if (asyncRequest.readyState == 1) {
		//document.getElementById("debug").innerText = "Request is loading";
		document.body.style.cursor='wait';
	}
	if (asyncRequest.readyState == 2) {
		//document.getElementById("debug").innerText = "Request has been loaded";
		document.body.style.cursor='wait';
	}
	if (asyncRequest.readyState == 3) {
		//document.getElementById("debug").innerText = "Data is actively being sent from the server";
		document.body.style.cursor='wait';
	}
	if (asyncRequest.readyState == 4 && asyncRequest.status == 200) {
    	document.getElementById(vSpan).innerHTML = '<b>' + asyncRequest.responseText + '</b>';
    	document.body.style.cursor='default';
    	//document.getElementById("debug").innerText = "Done! responseText = " + asyncRequest.responseText;
	}
}