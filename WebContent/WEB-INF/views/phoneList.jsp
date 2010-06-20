<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/productVisibility.js"></script>
    </head>
    <body>
        <div id="container">
        	<!-- Header -->
            <%@ include file="/WEB-INF/views/include/header.jsp" %>
            
			<!-- Menu -->
			<%@ include file="/WEB-INF/views/include/menu.jsp" %>
			
            <!-- Content -->
            <div id="content-container">
            
            	<!-- Left column -->
            	<%@ include file="/WEB-INF/views/include/leftColumn.jsp" %>
                
                
                <!-- Middle Column -->
                <div id="content">
					<div class="block01">
						<div class="blockTitle" id="phoneListTitle">Danh sách điện thoại</div>
						<div class="contentCenter" id="phoneListContainer">
							<c:forEach var="p" items="${model.pageList}" varStatus="loop">
								<c:set var="v" value="${true}"/>
								<c:if test="${(p.hienThi eq false) and ((empty sessionScope.userType) or (sessionScope.userType eq 'KhachHang'))}">
									<c:set var="v" value="${false}"/>
								</c:if>
								<c:if test="${v eq true}">
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
										
										<!-- Function for employees -->
										<c:if test="${(sessionScope.userType eq 'NhanVien') or (sessionScope.userType eq 'NhanVienQuanLy') or (sessionScope.userType eq 'NhanVienBanHang')}">
											<div class="employeeTaskBox">
											
												<input type="button" value="Cập nhật"/>
												 
												<c:set var="v" value="Hiển thị"/>
												<c:if test="${p.hienThi eq true}">
													<c:set var="v" value="Ẩn"/>
												</c:if>
												<input id="<c:out value="v${p.id}"/>" type="button" value="${v}" onclick="setVisibility('setVisibility.html?pid=${p.id}', ${p.id})"/>
											</div>
										</c:if>
									</div>
								</c:if>
							</c:forEach>
						</div>
						
						<!-- Paging content -->
						<div class="paging">
							<a href="?page=first"><b>First</b></a>
							<c:if test="${!model.firstPage}">
								<a href="?page=prev">&lt;&lt; Prev</a>
							</c:if> 
							<c:forEach var="currentPage" begin="${model.firstLinkedPage}" end="${model.lastLinkedPage}">
								<c:choose>
									<c:when test="${currentPage == model.page}">
										<b><c:out value="${currentPage + 1}"/></b>
									</c:when>
									<c:otherwise>
										<a href="?page=<c:url value="${currentPage}"></c:url>"><c:out value="${currentPage+1}"/></a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${!model.lastPage}">
								<a href="?page=next">Next &gt;&gt;</a>
							</c:if>
							<a href="?page=last">Last</a>
						</div>
					</div>
                </div> <!-- end midlle column -->
                
                
                <!-- Right Column -->
                <%@ include file="/WEB-INF/views/include/rightColumn.jsp" %>
            </div> <!-- end content -->
            
            <!-- Footer -->
            <%@ include file="/WEB-INF/views/include/footer.jsp" %>
        </div>
    </body>
</html>

