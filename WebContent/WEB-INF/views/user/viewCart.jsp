<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript">
        	$(document).ready(function() {
				$("div#cartTitle").click(function(){
					$("div#cartContainer").toggle("fast");
				});
			});
        </script>
    </head>
    <body>
        <div id="container">
        	<!-- Header -->
            <%@ include file="/WEB-INF/views/include/header.jsp" %>
            
			<!-- Menu -->
			<c:choose>
				<c:when test="${empty sessionScope.userType}">
					<%@ include file="/WEB-INF/views/include/defaultMenu.jsp" %>
				</c:when>
				<c:when test="${sessionScope.userType eq 'KhachHang'}">
					<%@ include file="/WEB-INF/views/include/userMenu.jsp" %>
				</c:when>
				<c:when test="${sessionScope.userType eq 'NhanVien'}">
					<%@ include file="/WEB-INF/views/include/employeeMenu.jsp" %>
				</c:when>
				<c:when test="${sessionScope.userType eq 'NhanVienQuanLy'}">
					<%@ include file="/WEB-INF/views/include/managerMenu.jsp" %>
				</c:when>
				<c:when test="${sessionScope.userType eq 'NhanVienQuanTri'}">
					<%@ include file="/WEB-INF/views/include/adminMenu.jsp" %>
				</c:when>
				<c:otherwise>
					<%@ include file="/WEB-INF/views/include/defaultMenu.jsp" %>
				</c:otherwise>
			</c:choose>
			
            <!-- Content -->
            <div id="content-container">
            
            	<!-- Include Left Column -->
                <%@ include file="/WEB-INF/views/include/leftColumn.jsp" %>
            	
                
                
                <!-- Middle Column -->
                <div id="content">
                	
                	<!-- List of phones -->
					<div class="block01">
						<div class="blockTitle" id="cartTitle">Thông tin giỏ hàng</div>
						<div class="contentCenter" id="cartContainer">
							<c:choose>
								<c:when test="${! empty sessionScope.cart}">
									<c:forEach var="item" items="${sessionScope.cart}">
										<div class="cartItem">
											<!-- Inner Left Column -->
						                	<div id="cartItemInnerLeftColumn">
						                		<!-- Image -->
												<div class="cartItemImage">
													<c:choose>
														<c:when test="${item.value.product.class.simpleName == 'DienThoai'}">
															<center><a href="phoneDetails.html?id=<c:out value="${ item.key }"/>" ><img src="img/dienthoai/<c:out value="${item.value.product.hinhAnh}"/>" width="75px" height="125px"/></a></center>
														</c:when>
														<c:otherwise>
															<center><a href="accessoryDetails.html?id=<c:out value="${ item.key }"/>" ><img src="img/phukien/<c:out value="${item.value.product.hinhAnh}"/>" width="75px" height="75px"/></a></center>
														</c:otherwise>
													</c:choose>
												</div>
						                	</div>
		                	
						                	<!-- Inner Right Column -->
						                	<div id="cartItemInnerRightColumn">
						                		<!-- Images List -->
						                		<div class="cartItemInfo">
						                			<div class="detailTitle">Thông tin sản phẩm</div>
						                			<div class="cartItemInfoContent">
						                				<div class="cartItemName"><a href="phoneDetails.html?id=<c:out value="${ item.key }"/>"><c:out value="${item.value.product.ten}"/></a></div>
						                				<div class="cartItemPrice"><fmt:formatNumber value="${item.value.product.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/> VND</div>
						                				<table>
															<tbody>
																<tr>
																	<td>
									                					<form method="post" action="updateCartItem.html">
									                						<input type="hidden" name="id" value="<c:out value="${ item.key }"/>">
									                						Số lượng: <input type="text" name="quantity" value="<c:out value="${ item.value.quantity }"/>" />
											                				<input type="submit" value="Cập nhật số lượng"/>
										                				</form>
										                			</td>
										                			<td>
											                			<form method="post" action="removeFromCart.html">
											                				<input type="hidden" name="id" value="<c:out value="${ item.key }"/>">
											                				<input type="submit" value="Xóa khỏi giỏ hàng"/>
											                			</form>
									                				</td>
									                			</tr>
								                			</tbody>
							                			</table>
						                			</div>
						                		</div>
						                	</div>
						                	<div style="clear: both;"></div>
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<div class="notFound">Giỏ hàng hiện tại chưa có sản phẩm nào.</div>
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

