<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Required login to view this page --%>
<%@ include file="/WEB-INF/views/user/requiredLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%>

<!-- Required at least one product in cart to make bill -->
<c:if test="${fn:length(sessionScope.cart) == 0}">
	<c:redirect url="viewCart.html"/>
</c:if>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/dateValidator.js"></script>
        
        <script type="text/javascript">
        	$(document).ready(function() {
				$("div#regTitle").click(function(){
					$("div#regContainer").toggle("fast");
				});
				
				$("select#dd option:eq(0)").attr('selected', 'selected');
				$("select#mm option:eq(0)").attr('selected', 'selected');
				$("select#yyyy option:eq(0)").attr('selected', 'selected');
				$("select#hour option:eq(0)").attr('selected', 'selected');
				$("select#minute option:eq(0)").attr('selected', 'selected');

				$("div#viewBillDetail").click(function() {
					$("div#billDetailContainer").slideToggle("fast");
				});
			});
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
                	
                	<!-- Register Form -->
					<div class="block01">
						<div class="blockTitle" id="regTitle">Thông tin giao hàng</div>
						<div class="contentCenter" id="regContainer">
							<c:if test="${not empty model.status}">
								<div class="<c:choose><c:when test="${model.success eq '1'}"><c:out value="successInfo"/></c:when><c:otherwise><c:out value="failedInfo"/></c:otherwise></c:choose>">
									<span class="successInfoText"><c:out value="${model.status}"/>   </span>
									<c:if test="${model.success eq '1'}">
										<a href="viewBill.html">Xem đơn hàng</a>
									</c:if>
								</div>
							</c:if>
							<spring:nestedPath path="donHang">
								<form action="addBill.html" method="post" onsubmit="return checkBillForm();">
									<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
										<spring:nestedPath path="nguoiNhan">
											<tr>
										    	<spring:bind path="hoTen">
											    	<td align="right" width="20%">Họ tên người nhận:</td>
											    	<td width="40%">
											    		<input class="regInput01" type="text" name="${status.expression}" value="${status.value}" />
											    		<span class="error"> *</span>
											    	</td>
											    	<td width="40%">
											    		<c:if test="${status.error}">
															<span class="error"><c:out value="${status.errorMessage}"/></span>
														</c:if>
											    	</td>
										    	</spring:bind>
										    </tr>
										    <tr>
										    	<spring:bind path="soDienThoai">
											    	<td align="right" width="20%">Số điện thoại người nhận:</td>
											    	<td width="40%">
											    		<input class="regInput01" type="text" name="${status.expression}" value="${status.value}" />
											    		<span class="error"> *</span>
											    	</td>
											    	<td width="40%">
											    		<c:if test="${status.error}">
															<span class="error"><c:out value="${status.errorMessage}"/></span>
														</c:if>
											    	</td>
										    	</spring:bind>
										    </tr>
									    </spring:nestedPath>
									    <!-- Javascript validation -->
									    <spring:nestedPath path="thoiGianGiaoHang">
										    <tr>
									    		<td align="right" width="20%" rowspan="2">Thời gian giao hàng:</td>
									    		<td width="40%">
										    		<spring:bind path="date">
														<select name="${status.expression}" id="dd" >
															<option value="0" selected >- Ngày -</option>
															<c:forEach var="g" begin="1" end="31">
												           		<option value="${g}" <c:if test="${ status.value == g }">selected</c:if> >${g}</option>
												           	</c:forEach>
														</select>
													</spring:bind>
													<spring:bind path="month">
														<select name="${status.expression}" id="mm" onchange="adaptDay()">
															<option value="-1" selected >- Tháng -</option>
															<c:forEach var="g" begin="0" end="11">
												           		<option value="${g}" <c:if test="${ status.value == g }">selected</c:if> >${g + 1}</option>
												           	</c:forEach>
														</select>
													</spring:bind>
													
													<% Date myCurrent = new Date(); pageContext.setAttribute("d", myCurrent); %>
													
													<spring:bind path="year">
														<select name="${status.expression}"  id="yyyy" onchange="adaptDay()">
															<option value="-1900" selected >- Năm -</option>
															<c:forEach var="y" begin="${d.year}" end="${d.year + 2}" >
												           		<option value="${y}" <c:if test="${ status.value == y }">selected</c:if> >${y + 1900}</option>
												           	</c:forEach>
														</select>
													</spring:bind>
													
													<span class="error"> *</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
													<%-- Javascript validation --%>
													<span class="error" id="dateRequired"></span>
										    	</td>
										    </tr>
										    <tr>
									    		<td width="40%">
										    		<spring:bind path="hours">
														<select name="${status.expression}" id="hour" >
															<option value="-1" selected >- Giờ -</option>
															<c:forEach var="g" begin="0" end="23">
												           		<option value="${g}" <c:if test="${ status.value == g }">selected</c:if> >${g}</option>
												           	</c:forEach>
														</select>
													</spring:bind>
													<spring:bind path="minutes">
														<select name="${status.expression}" id="minute"">
															<option value="-1" selected >- Phút -</option>
															<c:forEach var="g" begin="0" end="59" step="15">
												           		<option value="${g}" <c:if test="${ status.value == g }">selected</c:if> >${g}</option>
												           	</c:forEach>
														</select>
													</spring:bind>
													<span class="error"> *</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
													<%-- Javascript validation --%>
													<span class="error" id="timeRequired"></span>
										    	</td>
										    </tr>
									    </spring:nestedPath>
									    <tr>
									    	<spring:bind path="diaChiGiaoHang">
									    		<td align="right" width="20%">Địa chỉ:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="text" name="${status.expression}" value="${status.value}" />
										    		<span class="error"> *</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<spring:nestedPath path="hinhThucThanhToan">
										    	<spring:bind path="id">
											    	<td align="right" width="20%">Hình thức thanh toán:</td>
											    	<td width="40%">
											    		<select name="${status.expression}">
											    			<option value="-1" selected="selected"> - Hình thức thanh toán - </option>
											    			<option value="1" <c:if test="${status.value == 1}">selected</c:if>>Paypal</option>
											    			<option value="2" <c:if test="${status.value == 2}">selected</c:if>>Chuyển khoản</option>
											    			<option value="3" <c:if test="${status.value == 3}">selected</c:if>>Tiền mặt</option>
											    		</select>
											    		<span class="error"> *</span>
											    	</td>
											    	<td width="40%">
											    		<c:if test="${status.error}">
															<span class="error"><c:out value="${status.errorMessage}"/></span>
														</c:if>
											    	</td>
										    	</spring:bind>
									    	</spring:nestedPath>
									    </tr>
									    <tr>
									    	<td align="right" width="20%"></td>
									    	<td width="40%" align="left"><div id="viewBillDetail"><a href="#" style="color: green;font-weight: bold;text-decoration: none;text-transform: uppercase">Chi tiết đơn hàng</a></div></td>
									    	<td width="40%"></td>
									    </tr>
									    <tr>
									    	<td colspan="2">
									    		<div id="billDetailContainer">
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
									    					<c:forEach var="item" items="${sessionScope.cart}" varStatus="loop">
									    						<c:set var="total" value="${total + (item.value.product.giaHienHanh * item.value.quantity)}"/>
									    						<tr>
									    							<td><c:out value="${loop.count}"/></td>
									    							<td><div class="billDetailItemName"><c:out value="${item.value.product.ten}"/></div></td>
									    							<td style="text-align: right;"><div class="billDetailPrice"><fmt:formatNumber value="${item.value.product.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/></div></td>
									    							<td style="text-align: right;"><c:out value="${item.value.quantity}"/></td>
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
									    	<td></td>
									    </tr>
									    <tr>
									    	<td align="right" width="20%"></td>
									    	<td width="40%" align="right" style="padding-right: 30px;">
									    		<a href="viewCart.html"><input type="button" value="Trở lại"></a>
									    		<input type="submit" value="Đồng ý">
									    	</td>
									    	<td width="40%"></td>
									    </tr>
									</table>
								</form>
							</spring:nestedPath>
							<div><span class="error">( * )</span>: Các trường bắt buộc nhập liệu</div>
						</div>
						<div style="clear:both;"></div>
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

