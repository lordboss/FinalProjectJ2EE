<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>

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
				$("div#subTitle0").click(function(){
					$("div#subContent0").toggle("fast");
				});
				$("div#subTitle1").click(function(){
					$("div#subContent1").toggle("fast");
				});
				$("div#subTitle2").click(function(){
					$("div#subContent2").toggle("fast");
				});
				$("div#subTitle3").click(function(){
					$("div#subContent3").toggle("fast");
				});
				$("div#subTitle4").click(function(){
					$("div#subContent4").toggle("fast");
				});
				$("div#subTitle5").click(function(){
					$("div#subContent5").toggle("fast");
				});
				$("div#subTitle6").click(function(){
					$("div#subContent6").toggle("fast");
				});
				$("div#subTitle7").click(function(){
					$("div#subContent7").toggle("fast");
				});
				$("div#subTitle8").click(function(){
					$("div#subContent8").toggle("fast");
				});
				$("div#subTitle9").click(function(){
					$("div#subContent9").toggle("fast");
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
					<!-- List of accessories with sub categories -->
					<div class="block01">
						<div class="blockTitle" id="accessoryListTitle">Danh sách phụ kiện</div>
							<div class="contentCenter" id="accessoryListContainer">
								<c:forEach var="aType" items="${model}" varStatus="loop01">
									<div class="subContent">
										<div class="blockSubTitle01" id="subTitle<c:out value="${loop01.index}"/>"><c:out value="${aType.ten}"/></div>
										<div class="subContent" id="subContent<c:out value="${loop01.index}"/>">
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
															<a href="accessoryDetails.html?id=<c:out value="${a.id}" />" ><img src="img/phukien/<c:out value="${ a.hinhAnh }"/>" width="50px" height="75px"/></a>
													    </div>
													    <!-- Name -->
														<div class="itemName01"><a href="accessoryDetails.html?id=<c:out value="${a.id}" />" ><c:out value="${a.ten}"/></a></div>
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
                
                <!-- Include Right Column -->
                <%@ include file="/WEB-INF/views/include/rightColumn.jsp" %>
            </div> <!-- end content -->
            
            <!-- Footer -->
            <%@ include file="/WEB-INF/views/include/footer.jsp" %>
        </div>
    </body>
</html>

