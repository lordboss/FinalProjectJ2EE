/**
 * @author tqthe
 */

var asyncRequest;
var pid; // unique id of vButton

function setVisibility(url, id) {
	pid = id;
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
	var vButton = 'v' + pid;
	
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
    	document.getElementById(vButton).value = asyncRequest.responseText;
    	document.body.style.cursor='default';
    	//document.getElementById("debug").innerText = "Done! responseText = " + asyncRequest.responseText;
	}
}