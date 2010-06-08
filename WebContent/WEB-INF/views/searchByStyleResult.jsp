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
				$("div#listTitle").click(function(){
					$("div#listContainer").toggle("fast");
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
						<div class="blockTitle" id="listTitle">Kết quả tìm kiếm theo phong cách <c:out value="${ model.style }"/> (<c:out value="${fn:length(model.result)}"/> kết quả)</div>
						<div class="contentCenter" id="listContainer">
							<c:choose>
								<c:when test="${fn:length(model.result) > 0}">
									<c:forEach var="p" items="${model.result}" varStatus="loop">
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
													<a href="phoneDetails.html?id=<c:out value="${ p.id }"/>" ><img src="img/dienthoai/<c:out value="${p.hinhAnh}"/>" width="50px" height="75px"/></a>
												</div>
												<div class="itemName"><a href="phoneDetails.html?id=<c:out value="${ p.id }"/>"><c:out value="${p.ten}"/></a></div>
											</div>
											<!-- Price -->
											<div class="itemPrice"><fmt:formatNumber value="${p.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/> VND</div>
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<div class="notFound">Không tìm thấy dữ liệu!</div>
								</c:otherwise>
							</c:choose>
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

