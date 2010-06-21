/**
 * @author tqthe
 */

var aid;

function changeBackground(id) {
	var checkBox = document.getElementById("account" + id);
	var table = document.getElementById("table" + id);
 
 	if (checkBox.checked == true) {
		table.bgColor = "ffffcc";
	} else {
		table.bgColor = "f8f8ff";
	}
}