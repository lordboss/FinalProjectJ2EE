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
				$("div#divTitle0").click(function(){
					$("div#divContainer0").toggle("fast");
				});
				$("div#divTitle1").click(function(){
					$("div#divContainer1").toggle("fast");
				});
				$("div#divTitle2").click(function(){
					$("div#divContainer2").toggle("fast");
				});
				$("div#divTitle3").click(function(){
					$("div#divContainer3").toggle("fast");
				});
			});
        </script>
    </head>
    <body>
        <div id="container">
        	<!-- Header -->
            <%@ include file="/WEB-INF/views/include/header.jsp" %>
            
			<!-- Menu -->
            <div id="navigation">
                <ul>
                    <li>
                        <a href="index.jsp">TRANG CHỦ</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="phoneListByBrand.html">ĐIỆN THOẠI</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="accessoryList.html">PHỤ KIỆN</a>
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
            	<%@ include file="/WEB-INF/views/include/leftColumn.jsp" %>
                
                
                <!-- Middle Column -->
                <div id="content">
                	<!-- Walk through list of phone brands -->
                	<c:forEach var="b" items="${model}" varStatus="loop01">
						<div class="block01">
							<div class="blockTitle" id="divTitle<c:out value="${loop01.index}"/>">Hàng <c:out value="${b.ten}"/></div>
							<div class="contentCenter" id="divContainer<c:out value="${loop01.index}"/>">
								<c:choose>
									<c:when test="${fn:length(b.dsDienThoai) > 0}">
										<c:forEach var="p" items="${b.dsDienThoai}" varStatus="loop">
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
									</c:when>
									<c:otherwise>
										<c:out value="Chưa có sản phẩm!"></c:out>
									</c:otherwise>
								</c:choose>
							</div>
							<div style="clear:both;"></div>
						</div>
					</c:forEach>
                </div> <!-- end midlle column -->
                
                
                <!-- Right Column -->
                <%@ include file="/WEB-INF/views/include/rightColumn.jsp" %>
            </div> <!-- end content -->
            
            <!-- Footer -->
            <%@ include file="/WEB-INF/views/include/footer.jsp" %>
        </div>
    </body>
</html>

