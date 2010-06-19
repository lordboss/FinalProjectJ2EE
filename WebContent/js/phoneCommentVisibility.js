/**
 * Author: tqthe
 * 
 * Raw ajax to set the phone's comments visibility
 */

var asyncRequest;
var cid; // unique id of vButton

function setCommentVisibility(url, id) {
	cid = id;
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
	var vButton = 'button' + cid;
	var vSpan = 'span' + cid; 
	
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
    	document.getElementById(vButton).value = asyncRequest.responseText;
    	document.getElementById(vSpan).innerText = asyncRequest.responseText != 'Hiển thị' ? 'Hiển thị' : 'Không hiển thị';
    	document.body.style.cursor='default';
	}
}

