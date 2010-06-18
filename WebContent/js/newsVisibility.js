/**
 * @author tqthe
 */

var asyncRequest2;
var pid2; // unique id of vButton

function changeVisibility(url, id) {
	pid2 = id;
	try {
    	asyncRequest2 = new XMLHttpRequest();
		
    	// register event handler 
    	asyncRequest2.onreadystatechange = stateChange2;
    	asyncRequest2.open('GET', url, true);
    	asyncRequest2.send(null);
	} catch ( exception ) {
    	alert('Send request failed');
    	document.body.style.cursor='default';
	}
}

function stateChange2() {
	var vButton2 = 'v' + pid2;
	
	if (asyncRequest2.readyState == 1) {
		//document.getElementById("debug").innerText = "Request is loading";
		document.body.style.cursor='wait';
	}
	if (asyncRequest2.readyState == 2) {
		//document.getElementById("debug").innerText = "Request has been loaded";
		document.body.style.cursor='wait';
	}
	if (asyncRequest2.readyState == 3) {
		//document.getElementById("debug").innerText = "Data is actively being sent from the server";
		document.body.style.cursor='wait';
	}
	if (asyncRequest2.readyState == 4 && asyncRequest2.status == 200) {
    	document.getElementById(vButton2).value = asyncRequest2.responseText;
    	document.body.style.cursor='default';
    	//document.getElementById("debug").innerText = "Done! responseText = " + asyncRequest.responseText;
	}
}