/**
 * @author tqthe
 */

var asyncRequest;
var pid; 

function changeActivition(url, id) {
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
	var stateLabel = 'stateLabel' + pid;
	var stateButton = 'stateButton' + pid;
	
	if (asyncRequest.readyState == 1) {
		document.body.style.cursor='wait';
	}
	if (asyncRequest.readyState == 2) {
		document.body.style.cursor='wait';
	}
	if (asyncRequest.readyState == 3) {
		document.body.style.cursor='wait';
	}
	if (asyncRequest.readyState == 4 && asyncRequest.status == 200) {
		document.body.style.cursor='default';
		
		// ajax return current account state
		if (asyncRequest.responseText == '1') {
			document.getElementById(stateLabel).innerHTML = "Active";
			document.getElementById(stateButton).value = "Vô hiệu hóa";
		} else {
			document.getElementById(stateLabel).innerHTML = "Chưa kích hoạt";
			document.getElementById(stateButton).value = "Kích hoạt";
		}
	}
}