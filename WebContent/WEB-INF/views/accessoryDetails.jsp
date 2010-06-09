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
                	<c:choose>
	                	<c:when test="${! empty a}">
		                	<!-- General Info -->
		                	<div class="block02">
								<div class="blockTitle" id="">Thông tin cơ bản về <c:out value="${a.ten}"/></div>
								<div class="contentCenter">
									<!-- Inner Left Column -->
				                	<div id="innerLeftColumn">
				                		<!-- Accessory name -->
				                		<div class="accessoryDetail_Name"><c:out value="${a.ten}"/></div>
				                		<!-- Phone Image -->
				                		<div class="accessoryDetail_Image">
				                			<img src="img/phukien/<c:out value="${a.hinhAnh}"/>" />
				                		</div>
				                		<div class="accessoryDetail_Price"><fmt:formatNumber value="${a.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/> VND</div>
				                		<c:if test="${a.tinhTrangSanPham.id == 4}" >
				                			<div class="na">(Đã hết hàng)</div>
				                		</c:if>
				                		<hr/>
				                		
				                		<div style="text-align: center;">
				                			Màu sắc: <c:out value="${a.mauSac}" />
				                		</div>
				                		
				                		<hr/>
				                		
				                		<div class="bookProduct"><a href="addToCart.html?id=<c:out value="${ a.id }"/>">Đặt mua hàng</a></div>
				                		<div class="compareProduct"><a href="#">So sánh sản phẩm</a></div>
				                		<div class="supportProduct"><a href="#">Hổ trợ khách hàng</a></div>
				                	</div>
		                	
				                	<!-- Inner Right Column -->
				                	<div id="innerRightColumn">
				                	
				                		<!-- Waranty -->
				                		<div class="block03">
				                			<div class="detailTitle">Thời gian bảo hành</div>
				                			<div class="contentCenter01">
				                				<div style="padding-left: 10px;"><c:out value="${a.baoHanh}" /> tháng.</div>
				                			</div>
				                		</div>
				                		
				                		<!-- Promotion -->
				                		<div class="block03">
				                			<div class="detailTitle">Thông tin khuyến mãi dành cho <c:out value="${a.ten}"/></div>
				                			<div class="contentCenter01">
				                				<c:forEach var="g" items="${a.dsTinGiamGiaPhuKien}" varStatus="loop">
				                					<div>
				                						<ul>
				                							<li>Ngày bắt đầu: <c:out value="${g.ngayBatDau.date}" /> / <c:out value="${g.ngayBatDau.month + 1}" /> / <c:out value="${g.ngayBatDau.year + 1990}" /></li>
				                							<li>Ngày kết thúc: <c:out value="${g.ngayKetThuc.date}" /> / <c:out value="${g.ngayKetThuc.month + 1}" /> / <c:out value="${g.ngayKetThuc.year + 1990}" /></li>
				                							<li>Nội dung: <c:out value="${g.chiTiet}" /></li>
				                						</ul>
				                					</div>
				                					<c:if test="${loop.count < fn:length(a.dsTinGiamGiaPhuKien)}">
				                						<hr/>
				                					</c:if>
				                				</c:forEach>
				                			</div>
				                		</div>
				                	</div>
								</div>
								<div style="clear:both;"></div>
							</div>
		                	
		                	<!-- Detail Info -->
							<div class="block02">
								<!-- Title -->
								<div class="blockTitle" id="">TÍNH NĂNG CHI TIẾT</div>
								<!-- Content of block -->
								<div class="contentCenter">
									
									<!-- Features -->
									<div class="block03">
			                			<div class="detailTitle">Tính năng</div>
			                			<div class="contentCenter01">
			                				<c:out value="${a.tinhNang}"/>
			                			</div>
			                		</div>
			                		
			                		<!-- Guide -->
									<div class="block03">
			                			<div class="detailTitle">Hướng dẩn sử dụng</div>
			                			<div class="contentCenter01">
			                				<c:out value="${a.huongDanSuDung}"/>
			                			</div>
			                		</div>
			                	</div>
			                </div>
			                
			                <!-- List of compatable phones -->
							<div class="block02">
								<!-- Title -->
								<div class="blockTitle" id="">Danh sách các điện thoại có thể dùng được với phụ kiện này</div>
								<!-- Content of block -->
								<div class="contentCenter">
									<c:if test="${fn:length(a.dsDienThoaiTuongThich) > 0}">
										<div class="block03">
				                			<div class="detailTitle"></div>
				                			<div class="contentCenter01">
				                				<c:forEach var="p" items="${a.dsDienThoaiTuongThich}">
				                					<div class="compatablePhone"><a href="phoneDetails.html?id=<c:out value="${ p.id }"/>"><c:out value="${p.ten}"/></a></div> 	
				                				</c:forEach>
				                				<div style="clear: both"></div>
				                			</div>
				                		</div>
			                		</c:if>
			                	</div>
			                </div>
						</c:when>
						<c:otherwise>
							<div class="block02">
								<div class="blockTitle" id="">Thông tin chi tiết</div>
								<div class="contentCenter">
									<div class="notFound">Không tìm thấy sản phẩm trong dữ liệu</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
                </div> <!-- end midlle column -->
                
                <!-- Include Right Column -->
                <%@ include file="/WEB-INF/views/include/rightColumn.jsp" %>
                
            </div> <!-- end content -->
            
            <!-- Footer -->
            <%@include file="/WEB-INF/views/include/footer.jsp" %>
        </div>
    </body>
</html>

