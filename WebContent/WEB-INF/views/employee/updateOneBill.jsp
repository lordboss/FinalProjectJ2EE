<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Required login to view this page --%>
<%@ include file="/WEB-INF/views/employee/requiredLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        
        <script type="text/javascript">
        	$(document).ready(function() {
				$("div#billTitle").click(function(){
					$("div#billContainer").toggle("fast");
				});
				$("div#billHelp").click(function() {
					$("div#billHelpContent").slideToggle("fast");
				});
			});
        	function toggle(id) {
				var s1 = "div#viewBillDetail" + id;
				var s2 = "div#billDetailContainer" + id;
				
				$(s2).slideToggle("fast");
			}
			function toggleEditForm(id) {
				var s1 = "div#edit" + id;
				$(s1).toggle("fast");
			}
        </script>
    </head>
    <body>
        <div id="container">
        	<!-- Header -->
            <%@ include file="/WEB-INF/views/include/header.jsp" %>
            
			<!-- Menu -->
			<%@ include file="/WEB-INF/views/include/menu.jsp" %>
			
            <!-- Content -->
            <div id="content-container">
            
            	<!-- Include Left Column -->
                <%@ include file="/WEB-INF/views/include/leftColumn.jsp" %>
            	
                
                
                <!-- Middle Column -->
                <div id="content">
                	
                	<!-- List of bills -->
					<div class="block01">
						<div class="blockTitle" id="billTitle">Danh sách đơn đặt hàng (<c:out value="${fn:length(model)}"/>)</div>
						<div class="contentCenter" id="billContainer">
							<div>
								<div class="billHelp" id="billHelp"><a onmouseover="this.style.cursor='pointer'">Trợ giúp</a></div>
								<div class="billHelpContent" id="billHelpContent">
									Nhân viên có thể xem các đơn đặt hàng <b>chưa hoàn tất</b> cập nhật <b>trạng thái đơn hàng</b>.
								</div>
							</div>
							<c:choose>
								<c:when test="${! empty model.bill}">
									<c:set var="bill" value="${model.bill}"></c:set>
									<div class="billItem">
										<!-- Inner Left Column -->
					                	<div id="billItemInnerLeftColumn">
					                		<!-- Bill Icon -->
											<div class="billIcon">
												<c:choose>
													<c:when test="${bill.trangThai.id == 1}">
														<center><a href="#" ><img src="img/icon/bill.png" width="75px" height="75"/></a></center>
													</c:when>
													<c:when test="${bill.trangThai.id == 2}">
														<center><a href="#" ><img src="img/icon/acceptedBill.png" width="75px" height="75"/></a></center>
													</c:when>
													<c:when test="${bill.trangThai.id == 3}">
														<center><a href="#" ><img src="img/icon/bill.png" width="75px" height="75"/></a></center>
													</c:when>
													<c:when test="${bill.trangThai.id == 4}">
														<center><a href="#" ><img src="img/icon/deliveriedBill.png" width="75px" height="75"/></a></center>
													</c:when>
													<c:when test="${bill.trangThai.id == 5}">
														<center><a href="#" ><img src="img/icon/rejectedBill.png" width="75px" height="75"/></a></center>
													</c:when>
													<c:otherwise>
														<center><a href="#" ><img src="img/icon/bill.png" width="75px" height="75"/></a></center>
													</c:otherwise>
												</c:choose>
												<div class="billStatus">
													<c:out value="${bill.trangThai.trangThai}"/>
												</div>
												<div class="billEditStatus">
													<img src="img/icon/edit.png" width="32" height="32" onclick="toggleEditForm(<c:out value="${bill.id}"/>)" onmouseover="this.style.cursor='pointer'" title="Cập nhật trạng thái đơn hàng"></img>
												</div>
												<c:if test="${model.isSuccess eq '1'}">
													<div class="billUpdateSuccess">
														Cập nhật thành công 
														<br/>
														<%-- 
														<a href="manageBill.html">Xem danh sách đơn hàng</a>
														--%>
														<a href="manageBillPaging.html">Xem danh sách đơn hàng</a>
													</div>
												</c:if>
												<c:if test="${model.isSuccess eq '0'}">
													<div class="billUpdateFail">
														Cập nhật thất bại
													</div>
												</c:if>
												<!-- Edit bill status -->
												<div id="edit<c:out value="${bill.id}"/>" class="billEditForm" style="display: none;">
													<div style="font-weight: bold;color: green">Cập nhật trạng thái</div>
													<div>
														<form method="post" action="updateBillStatus.html">
															<input type="hidden" name="billId" value="<c:out value="${bill.id}"/>">
															<select id="newStatus" name="newStatus">
																<option value="1" <c:if test="${bill.trangThai.id eq 1}">selected</c:if>>Chưa duyệt</option>
																<option value="2" <c:if test="${bill.trangThai.id eq 2}">selected</c:if>>Đã duyệt</option>
																<option value="3" <c:if test="${bill.trangThai.id eq 3}">selected</c:if>>Chưa giao hàng</option>
																<option value="4" <c:if test="${bill.trangThai.id eq 4}">selected</c:if>>Đã giao hàng</option>
																<option value="5" <c:if test="${bill.trangThai.id eq 5}">selected</c:if>>Không được duyệt</option>
															</select>
															<center><input type="submit" value="Cập nhật"></center>
														</form>
													</div>
												</div>
											</div>
					                	</div>
	                	
					                	<!-- Inner Right Column -->
					                	<div id="billItemInnerRightColumn">
					                		<div class="billItemInfo">
					                			<div class="detailTitle">Thông tin đơn đặt hàng</div>
					                			<div class="billInfoContent">
													<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
														<tr>
													    	<td align="right" width="25%"></td>
													    	<td width="40%" align="left"><div><a style="color: green;font-weight: bold;text-decoration: none;text-transform: uppercase">Khách hàng</a></div></td>
													    </tr>
													    <tr>
													    	<td align="right" width="25%">Họ tên khách hàng:</td>
													    	<td width="40%">
													    		<c:out value="${bill.khachHang.ho}"/> <c:out value="${bill.khachHang.dem}"/> <c:out value="${bill.khachHang.ten}"/>
													    	</td>
													    </tr>
													    <tr>
													    	<td align="right">Email:</td>
													    	<td width="40%">
													    		<c:out value="${bill.khachHang.email}"/>
													    	</td>
													    </tr>
														<tr>
													    	<td align="right" width="25%"></td>
													    	<td width="40%" align="left"><div><a style="color: green;font-weight: bold;text-decoration: none;text-transform: uppercase">Thông tin giao hàng</a></div></td>
													    </tr>
														<tr>
													    	<td align="right" width="25%">Họ tên người nhận:</td>
													    	<td width="40%">
													    		<c:out value="${bill.nguoiNhan.hoTen}"/>
													    	</td>
													    </tr>
													    <tr>
													    	<td align="right">Số điện thoại người nhận:</td>
													    	<td width="40%">
													    		<c:out value="${bill.nguoiNhan.soDienThoai}"/>
													    	</td>
													    </tr>
														<tr>
												    		<td align="right">Thời gian giao hàng:</td>
												    		<td width="40%">
												    			<c:set var="t" value="${bill.thoiGianGiaoHang}" />
												    			<c:out value="${t.date}"/> / <c:out value="${t.month + 1}"/> / <c:out value="${t.year + 1900}"/> <c:out value="${t.hours}"/>:<c:out value="${t.minutes}"/>
													    	</td>
														</tr>
													    <tr>
													    	<td align="right">Địa chỉ:</td>
														    <td width="40%">
														    	<c:out value="${bill.diaChiGiaoHang}"/>
														    </td>
													    </tr>
													    <tr>
															<td align="right">Hình thức thanh toán:</td>
															<td width="40%">
																<c:out value="${bill.hinhThucThanhToan.hinhThuc}"/>
															</td>
													    </tr>
													    <tr>
													    	<td align="right"></td>
													    	<td width="40%" align="left">
													    		<div id="viewBillDetail<c:out value="${bill.id}"/>" onclick="toggle(<c:out value="${bill.id}"/>)">
													    			<a onmouseover="this.style.cursor='pointer'" style="color: green;font-weight: bold;text-decoration: none;text-transform: uppercase">Chi tiết đơn hàng</a>
													    		</div>
													    	</td>
													    </tr>
													    <tr>
													    	<td colspan="2">
													    		<div id="billDetailContainer<c:out value="${bill.id}"/>" style="display: none;">
													    			<table width="95%" cellspacing="1" >
													    				<thead>
													    					<tr>
														    					<th>STT</th>
														    					<th>Sản phẩm</th>
														    					<th>Giá</th>
														    					<th>Số lượng</th>
													    					</tr>
													    				</thead>
													    				<tbody>
													    					<c:set var="total" value="0.0" scope="page"/>
													    					<c:forEach var="d" items="${bill.dsChiTietDonHang}" varStatus="loop">
													    						<c:set var="total" value="${total + (d.sanPham.giaHienHanh * d.soLuong)}"/>
													    						<tr>
													    							<td><c:out value="${loop.count}"/></td>
													    							<td><div class="billDetailItemName"><c:out value="${d.sanPham.ten}"/></div></td>
													    							<td style="text-align: right;"><div class="billDetailPrice"><fmt:formatNumber value="${d.sanPham.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/></div></td>
													    							<td style="text-align: right;"><c:out value="${d.soLuong}"/></td>
													    						</tr>
													    					</c:forEach>
													    					<tr><td colspan="4" style="text-align: right;font-weight: bold">Tổng cộng</td></tr>
													    					<tr>
													    						<td colspan="4" style="text-align: right;">
													    							<div class="billDetailTotalPrice"><fmt:formatNumber value="${total}" minFractionDigits="0" maxFractionDigits="0"/> VND</div>
													    						</td>
													    					</tr>
													    				</tbody>
													    			</table>
													    		</div>
													    	</td>
													    </tr>
													</table>
					                			</div>
					                		</div>
					                	</div> <%-- end innner right column --%>
					                	<div style="clear: both;"></div>
									</div>
								</c:when>
								<c:otherwise>
									<div style="margin-bottom: 10px; text-align: left; padding-left: 5px;font-size: 9pt;">Lỗi cập nhật đơn hàng.</div>
								</c:otherwise>
							</c:choose>
							
							
						</div>
					</div>
                </div> <!-- end midlle column -->
                
                <!-- Include Right Column -->
                <%@ include file="/WEB-INF/views/include/rightColumn.jsp" %>
                
            </div> <!-- end content -->
            
            <!-- Footer -->
            <%@include file="/WEB-INF/views/include/footer.jsp" %>
        </div>
    </body>
</html>

