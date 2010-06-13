<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Right Column -->
<div id="rightAside">

	<div class="block">
	    <div class="blockTitle">Đăng nhập</div>
	    <form method="post" action="login.html">
	       	<!-- username  -->
	       	<div style="padding-left: 10px;">
	       		<label>Tên đăng nhập:</label>
	       	</div>
	    	<input type="text" class="input02" id="username" name="username"/>
	    	
	    	<!-- password  -->
	    	<div style="padding-left: 10px;">
	    		<label>Mật khẩu:</label>
	    	</div>
	    	<input type="password" class="input02" id="password" name="password"/>
	       
		   	<!-- Submit button -->
		   	<center><input type="submit" value="Đăng nhập"/></center>
		   	
		   	<c:if test="${! empty sessionScope.isSuccess}">
		   		<c:if test="${sessionScope.isSuccess eq 'N'}">
		   			<div class="loginError">Đăng nhập thất bại</div>
		   		</c:if>
		   	</c:if>
		   	
		   	<!-- Register -->
	       	<div class="link01">
	       		<a href="register.html">Đăng kí thành viên</a>
	       	</div>
	       	
	       	<%-- 
	       		check to see if user has logged in yet
   				note: login is not part of this application, 
      		    so user is redirected to the login application
			--%>
	       	<c:if test="${! empty sessionScope.userType}">
	       		<hr/>
	       		<div style="padding-left: 10px;font-weight: bold;text-align: center;font-family:Arial,Times New Roman,Tahoma,Verdana;color: #b5cb42;">
	       			<c:out value="${sessionScope.username}" /> đã đăng nhập
	       		</div>
	       		<!-- Register -->
		       	<div class="link01">
		       		<a href="logout.html">Đăng xuất</a>
		       	</div>
	       	</c:if>
	   	 </form>
	</div>
	
	<div class="block">
	    <div class="blockTitle">Thông Tin Đặt Hàng</div>
	    <div class="smallFont">Hướng Dẩn Đặt Hàng</div>
	    <div class="stepOne">
	    	<a href="#">Tìm Chọn Sản Phẩm</a>
	    </div>
	    <div class="stepTwo">
	    	<a href="#">Đăng Kí &amp; Thanh Toán</a>
	    </div>
	    <div class="stepThree">
	    	<a href="#">Xác Nhận</a>
	    </div>
	</div>
	
	<div class="block">
	    <div class="blockTitle">Điện Thoại &amp; Phụ Kiện</div>
	    <div>
	    	<div class="blockSubTitle">Phụ Kiện</div>
	        <div>
	        	<div class="blockLineElement"><a href="searchByAccessoryType.html?id=1">Bao da</a></div>
	            <div class="blockLineElement"><a href="searchByAccessoryType.html?id=2">Vỏ máy</a></div>
	            <div class="blockLineElement"><a href="searchByAccessoryType.html?id=3">Pin</a></div>
	            <div class="blockLineElement"><a href="searchByAccessoryType.html?id=4">Sạc</a></div>
	            <div class="blockLineElement"><a href="searchByAccessoryType.html?id=5">Đồ trang trí</a></div>
	            <div class="blockLineElement"><a href="searchByAccessoryType.html?id=6">Thiết bị kết nối PC</a></div>
	            <div class="blockLineElement"><a href="searchByAccessoryType.html?id=7">Tai nghe</a></div>
	            <div class="blockLineElement"><a href="searchByAccessoryType.html?id=8">Loa</a></div>
	            <div class="blockLineElement"><a href="searchByAccessoryType.html?id=9">Thẻ nhớ &amp; Đầu đọc thẻ</a></div>
	            <div class="blockLineElement"><a href="searchByAccessoryType.html?id=10">Phụ kiện khác</a></div>
	        </div>
	        
	        <div class="blockSubTitle">Điện thoại</div>
	        <div>
		    	<div class="blockLineElement"><a href="searchByPhoneBrand.html?id=1">Hàng siêu cấp</a></div>
		        <div class="blockLineElement"><a href="searchByPhoneBrand.html?id=2">Hàng cao cấp</a></div>
		        <div class="blockLineElement"><a href="searchByPhoneBrand.html?id=3">Hàng trung cấp</a></div>
		        <div class="blockLineElement"><a href="searchByPhoneBrand.html?id=4">Hàng phổ thông</a></div>
			</div>
		</div>            
   	</div>
   	
    <div class="block">
        <div class="blockTitle">So Sánh Nhận Xét Điện Thoại</div>
        <div class="blockSubTitle">Chọn sản phẩm ĐTDĐ bạn cần để xem: Báo giá, Nhận xét, So sánh</div>
        <select class="input01">
        	<option>Chọn nhà sản xuất</option>
        </select>
        <br/>
        <select class="input01">
            <option>Chọn điện thoại</option>
        </select>
    </div>
    <div class="block">
    	<div class="blockTitle">Góp Ý - Liên Hệ</div>
        <div class="lineSuggestion"><a href="addSuggestion.html">Góp Ý</a></div>
        <div class="lineContact"><a href="#">Liên Hệ</a></div>
    </div>
</div> <!-- end right column -->
