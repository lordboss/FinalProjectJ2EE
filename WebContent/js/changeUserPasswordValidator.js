

function checkForm() {
	var oldPassword = document.getElementById("oldPassword").value;
	var password = document.getElementById("password").value;
	var password2 = document.getElementById("password2").value;
	
	if (!oldPassword) {
		var oldPasswordError = document.getElementById("oldPasswordError"); 
		oldPasswordError.innerText = "Chưa nhập mật khẩu hiện tại";
		return false;
	}
	
	if (!password) {
		var passwordError = document.getElementById("passwordError"); 
		passwordError.innerText = "Chưa nhập mật khẩu mới BUOI";
		return false;
	}
	
	if (!password2) {
		var password2Error = document.getElementById("password2Error");
		password2Error.innerText = "Chưa xác nhận lại mật khẩu BUOI";
		return false;
	}
	
	if (password != password2) {
		var password2Error = document.getElementById("password2Error");
		password2Error.innerText = "Xác nhận mật khẩu chưa đúng BUOI";
		return false;
	}
	
	return true;
}