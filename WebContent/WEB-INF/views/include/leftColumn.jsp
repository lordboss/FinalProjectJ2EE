<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Left column -->
<div id="leftAside">
    <div class="block">
	    <div class="blockTitle">Tìm kiếm nhanh ĐTDD</div>
	    <form method="get" action="quickSearch.html">
	       	<!-- Phone name  -->
	    	<input type="text" class="input02" id="ten" name="ten"/>
	    
	    	<!-- Manufacture id -->
		    <select class="input01" id="hangDienThoai" name="hangDienThoai">
		    	<option value="-1">Chọn Hãng Điện Thoại</option>
		        <option value="1">Nokia</option>
		        <option value="2">LG</option>
		        <option value="3">Samsung</option>
		        <option value="4">Sony Ericssion</option>
		        <option value="5">HTC</option>
		        <option value="6">Motorola</option>
		        <option value="7">K-Touch</option>
		        <option value="8">Mobell</option>
		        <option value="9">F-Mobile</option>
		        <option value="10">Philips</option>
		        <option value="11">eTouch</option>
		        <option value="12">Apple</option>
		        <option value="13">Blackberry</option>
		        <option value="14">S-Fone</option>
		        <option value="15">Khác</option>
		    </select>
	       
	       	<!-- Min price -->
	       	<select class="input01" id="giaTu" name="giaTu">
	       		<option value="-1">Giá từ</option>
	       		<c:forEach var="g" begin="1" end="10">
	           		<option value="${g * 1000000.0}">${g} triệu</option>
	           	</c:forEach>
	           	<option value="900000000">&gt; 10 triệu</option>
	      	</select>
	       
	       <!-- Max price -->
	       <select class="input01" id="giaDen" name="giaDen">
	       		<option value="-1">Đến</option>
	       		<c:forEach var="g" begin="1" end="10">
	           		<option value="${g * 1000000.0}">${g} triệu</option>
	           	</c:forEach>
	           	<option value="900000000">&gt; 10 triệu</option>
	       </select>
	       
		   <!-- Submit button -->
		   <center><input type="submit" value="Tìm Kiếm"/></center>
	       </form>
	</div>
	
	<!-- Tìm kiếm chuyên sâu -->
	<div class="block">
        <div class="blockTitle">Tìm kiếm chuyên sâu</div>
        <div>
        	<!-- Theo phong cách -->
        	<div class="blockSubTitle">Phong Cách</div>
            <div>
            	<div class="blockLineElement"><a href="#">Doanh Nhân</a></div>
                <div class="blockLineElement"><a href="#">Cá Tính</a></div>
                <div class="blockLineElement"><a href="#">Nam Tính</a></div>
                <div class="blockLineElement"><a href="#">Nữ Tính</a></div>
                <div class="blockLineElement"><a href="#">Thời Trang</a></div>
                <div class="blockLineElement"><a href="#">Trẻ Trung</a></div>
            </div>
            
            <!-- Theo kiểu dáng -->
            <div class="blockSubTitle">Kiểu Dáng</div>
            <div>
            	<div class="blockLineElement"><a href="#">Kiểu Nắp Gập</a></div>
                <div class="blockLineElement"><a href="#">Kiểu Thanh</a></div>
                <div class="blockLineElement"><a href="#">Kiểu Trượt</a></div>
                <div class="blockLineElement"><a href="#">Kiểu Cảm Ứng</a></div>
                <div class="blockLineElement"><a href="#">Kiểu Nắp Xoay</a></div>
                <div class="blockLineElement"><a href="#">Kiểu Thân Xoay</a></div>
            </div>
            
            <!-- Theo kiểu dáng -->
            <div class="blockSubTitle">Chức Năng</div>
            <table style="width:100%">
            	<tbody>
                	<tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_cam.gif"/>Camera
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                    <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_nhac.gif"/>Nghe Nhạc
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                    <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_FM.gif"/>Đài FM
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                    <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_the.gif"/>Hổ Trợ Thẻ Nhớ
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                    <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_wifi.gif"/>Wifi
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                     <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_3G.gif"/>Mạng 3G
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                     <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_bt.gif"/>Bluetooth
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                     <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_office.gif"/>Ứng Dụng Văn Phòng
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                     <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_GPS.gif"/>Định Vị
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                     <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_touchscreen.gif"/>Cảm Ứng
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                     <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_TV.gif"/>Xem Tivi
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                     <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_java.gif"/>Ứng dụng Java
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                     <tr>
                    	<td class="blockSearchFunction_Line">
                        	<img class="blockSearchFunction_Image" src="img/icon/icon_2SIM.gif"/>2 SIM
                        </td>
                       	<td class="blockSearchFunction_Line">
                        	<input type="checkbox"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <center><input type="submit" value="Tìm Kiếm"/></center>
        </div>
    </div>
</div> <!-- end left column -->