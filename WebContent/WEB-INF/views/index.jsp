<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript">
        	$(document).ready(function() {
				$("div#phoneListTitle").click(function(){
					$("div#phoneListContainer").toggle("fast");
				});
				$("div#accessoryListTitle").click(function(){
					$("div#accessoryListContainer").toggle("fast");
				});
			});
        </script>
    </head>
    <body>
        <div id="container">
        	<!-- Header -->
            <div id="header">
                <h1 class="pageTittle"><a href="#">Thế Giới Di Động</a></h1>
            </div>
            
			<!-- Menu -->
            <div id="navigation">
                <ul>
                    <li>
                        <a href="index.jsp">TRANG CHỦ</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="phoneList.html">ĐIỆN THOẠI</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="accesoryList.html">PHỤ KIỆN</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="#">GÓP Ý</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="#">LIÊN HỆ</a>
                    </li>
                </ul>
            </div> <!-- end menu -->
			
            <!-- Content -->
            <div id="content-container">
            
            	<!-- Left column -->
            	<div id="leftAside">
                    <div class="block">
                        <div class="blockTitle">Tìm kiếm nhanh ĐTDD</div>
                        <input type="text" id="phoneName" name="phoneName" class="input02" value="Tên Điện Thoại"/>
                        <select class="input01">
                            <option value="-1">Hãng Điện Thoại</option>
                            <option value="1">Nokia</option>
                            <option value="2">LG</option>
                        </select>
                        <select class="input01">
                            <option value="">Giá từ</option>
                            <option value="">1 triệu</option>
                            <option value="">2 triệu</option>
                            <option value="">3 triệu</option>
                        </select>
                        <br/>
                        <select class="input01">
                            <option value="">Đến</option>
                            <option value="">1 triệu</option>
                            <option value="">2 triệu</option>
                            <option value="">3 triệu</option>
                        </select>
                        <center><input type="submit" value="Tìm Kiếm"/></center>
                    </div>
                    <div class="block">
                        <div class="blockTitle">Tìm kiếm chuyên sâu</div>
                        <div>
                        	<div class="blockSubTitle">Phong Cách</div>
                            <div>
                            	<div class="blockLineElement"><a href="#">Doanh Nhân</a></div>
                                <div class="blockLineElement"><a href="#">Cá Tính</a></div>
                                <div class="blockLineElement"><a href="#">Nam Tính</a></div>
                                <div class="blockLineElement"><a href="#">Nữ Tính</a></div>
                                <div class="blockLineElement"><a href="#">Thời Trang</a></div>
                                <div class="blockLineElement"><a href="#">Trẻ Trung</a></div>
                            </div>
                            
                            <div class="blockSubTitle">Kiểu Dáng</div>
                            <div>
                            	<div class="blockLineElement"><a href="#">Kiểu Nắp Gập</a></div>
                                <div class="blockLineElement"><a href="#">Kiểu Thanh</a></div>
                                <div class="blockLineElement"><a href="#">Kiểu Trượt</a></div>
                                <div class="blockLineElement"><a href="#">Kiểu Cảm Ứng</a></div>
                                <div class="blockLineElement"><a href="#">Kiểu Nắp Xoay</a></div>
                                <div class="blockLineElement"><a href="#">Kiểu Thân Xoay</a></div>
                            </div>
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
                
                
                <!-- Middle Column -->
                <div id="content">
                	
                	<!-- List of phones -->
					<div class="block01">
						<div class="blockTitle" id="phoneListTitle">Danh sách điện thoại</div>
						<div class="contentCenter" id="phoneListContainer">
							<c:forEach var="p" items="${model.dsDienThoai}" varStatus="loop">
								<div class="<c:choose><c:when test="${ loop.index eq 0 }"><c:out value="itemLeft"/></c:when><c:otherwise><c:out value="itemCenter"/></c:otherwise></c:choose>">
									<!-- New model or not -->
									<c:choose>
										<c:when test="${p.tinhTrangSanPham.id eq 3}">
											<div class="isNewModel"></div>
										</c:when>
										<c:otherwise>
											<div class="isNotNewModel"></div>
										</c:otherwise>
									</c:choose>
									<!-- Image and Name -->
									<div class="itemImageAndName">
										<div class="itemImage">
											<c:if test="${fn:length(p.dsHinhAnh) > 0}">
												<c:forEach var="img" items="${p.dsHinhAnh}" begin="1" end="1" varStatus="loopCount">
											        <c:if test="${loopCount.index eq 1}">
											         	<a href="#"><img src="img/dienthoai/<c:out value="${ img.hinhAnh }"/>" width="50px" height="75px"/></a>
											        </c:if>
											    </c:forEach>
											</c:if>
										</div>
										<div class="itemName"><c:out value="${p.ten}"/></div>
									</div>
									<!-- Price -->
									<div class="itemPrice"><fmt:formatNumber value="${p.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/> VND</div>
								</div>
							</c:forEach>
						</div>
						<div style="clear:both;"></div>
					</div>
					
					<!-- List of accessories -->
					<!-- 
					<div class="block01">
						<div class="blockTitle" id="accessoryListTitle">Danh sách phụ kiện</div>
						<div class="contentCenter" id="accessoryListContainer">
							<c:forEach var="a" items="${model.dsPhuKien}" varStatus="loop">
								<div class="<c:choose><c:when test="${ loop.index eq 0 }"><c:out value="itemLeft"/></c:when><c:otherwise><c:out value="itemCenter"/></c:otherwise></c:choose>">
									
									<c:choose>
										<c:when test="${a.tinhTrangSanPham.id eq 3}">
											<div class="isNewModel"></div>
										</c:when>
										<c:otherwise>
											<div class="isNotNewModel"></div>
										</c:otherwise>
									</c:choose>
									
									<div class="itemImageAndName">
										
										<div class="itemImage">
											<c:forEach var="img" items="${a.dsHinhAnh}" begin="0" end="1" varStatus="loopCount">
										        <c:if test="${loopCount.index eq 0}">
										         	<a href="#"><img src="img/phukien/<c:out value="${ img.hinhAnh }"/>" width="50px" height="75px"/></a>
										        </c:if>
										    </c:forEach>
									    </div>
									    
										<div class="itemName01"><c:out value="${a.ten}"/></div>
									</div>
									
									<div class="itemPrice"><fmt:formatNumber value="${a.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/> VND</div>
								</div>
							</c:forEach>
						</div>
						<div style="clear:both;"></div>
					</div>
					 -->
					 
					<!-- List of accessories with sub categories -->
					<div class="block01">
						<div class="blockTitle" id="accessoryListTitle">Danh sách phụ kiện</div>
							<div class="contentCenter" id="accessoryListContainer">
								<c:forEach var="aType" items="${model.dsLoaiPhuKien}">
									<div class="subContent">
										<div class="blockSubTitle01"><c:out value="${aType.ten}"/></div>
										<div class="subContent">
											<c:forEach var="a" items="${aType.dsPhuKien}" varStatus="loop">
												<div class="<c:choose><c:when test="${ loop.index eq 0 }"><c:out value="itemLeft"/></c:when><c:otherwise><c:out value="itemCenter"/></c:otherwise></c:choose>">
													<!-- New model or not -->
													<c:choose>
														<c:when test="${a.tinhTrangSanPham.id eq 3}">
															<div class="isNewModel"></div>
														</c:when>
														<c:otherwise>
															<div class="isNotNewModel"></div>
														</c:otherwise>
													</c:choose>
													<!-- Image & Name-->
													<div class="itemImageAndName">
														<!-- Choose one image from list -->
														<div class="itemImage">
															<c:forEach var="img" items="${a.dsHinhAnh}" begin="0" end="1" varStatus="loopCount">
														        <c:if test="${loopCount.index eq 0}">
														         	<a href="#"><img src="img/phukien/<c:out value="${ img.hinhAnh }"/>" width="50px" height="75px"/></a>
														        </c:if>
														    </c:forEach>
													    </div>
													    <!-- Name -->
														<div class="itemName01"><c:out value="${a.ten}"/></div>
													</div>
													<!-- Price -->
													<div class="itemPrice"><fmt:formatNumber value="${a.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/> VND</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</c:forEach>
							</div>
						<div style="clear:both;"></div>
					</div>
                </div> <!-- end midlle column -->
                
                
                <!-- Right Column -->
                <div id="rightAside">
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
                            	<div class="blockLineElement"><a href="#">Bao da</a></div>
                                <div class="blockLineElement"><a href="#">Vỏ máy</a></div>
                                <div class="blockLineElement"><a href="#">Pin</a></div>
                                <div class="blockLineElement"><a href="#">Sạc</a></div>
                                <div class="blockLineElement"><a href="#">Đồ trang trí</a></div>
                                <div class="blockLineElement"><a href="#">Thiết bị kết nối PC</a></div>
                                <div class="blockLineElement"><a href="#">Tai nghe</a></div>
                                <div class="blockLineElement"><a href="#">Loa</a></div>
                                <div class="blockLineElement"><a href="#">Thẻ nhớ &amp; Đầu đọc thẻ</a></div>
                                <div class="blockLineElement"><a href="#">Phụ kiện khác</a></div>
                            </div>
                            
                            <div class="blockSubTitle">Điện thoại</div>
                            <div>
                            	<div class="blockLineElement"><a href="#">Hàng siêu cấp</a></div>
                                <div class="blockLineElement"><a href="#">Hàng cao cấp</a></div>
                                <div class="blockLineElement"><a href="#">Hàng trung cấp</a></div>
                                <div class="blockLineElement"><a href="#">Hàng phổ thông</a></div>
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
                        <div class="lineSuggestion"><a href="#">Góp Ý</a></div>
                        <div class="lineContact"><a href="#">Liên Hệ</a></div>
                    </div>
            	</div> <!-- end right column -->
            </div> <!-- end content -->
            
            <!-- Fotter -->
            <div id="footer">
                Owner: Trần Quang Thể
                <br/>
                StudentID: 0612431
                <br/>
                Email: <a href="mailto:tran.q.the@gmail.com">tran.q.the@gmail.com</a>
            </div>
        </div>
    </body>
</html>

