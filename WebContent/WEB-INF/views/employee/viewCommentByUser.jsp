<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Required login to view this page --%>
<%@ include file="/WEB-INF/views/employee/requiredLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%><html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <!-- Raw Ajax to set comment visibility -->
        <script type="text/javascript" src="js/phoneCommentVisibility.js"></script>
        
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
                	
                	<div class="block02">
						<div class="blockTitle">DANH SÁCH NHẬN XÉT</div>
						<div>
							<div class="contentCenter">
								<c:choose>
									<c:when test="${fn:length(model) > 0}">
										<c:forEach var="c" items="${model}">
											<c:set var="v" value="${true}"/>
											<c:if test="${(c.hienThi eq false) and ((empty sessionScope.userType) or (sessionScope.userType eq 'KhachHang'))}">
												<c:set var="v" value="${false}"/>
											</c:if>
											<c:if test="${v eq true}">
												<div class="block03">
						                			<div class="detailTitle">
						                				<table width="100%">
						                					<tbody>
						                						<tr>
						                							<td width="40%">User:
						                								<c:choose> 
						                									<c:when test="${not empty c.khachHang.username}">
						                										<a href="#" style="text-decoration: none;"><c:out value="${c.khachHang.username}"/></a>
						                									</c:when>
						                									<c:otherwise>
						                										<a href="#" style="text-decoration: none;">Anonymous</a>
						                									</c:otherwise>
						                								</c:choose>
						                							</td>
						                							<td width="60%" align="right"> <fmt:formatDate value="${c.thoiGian}" pattern="dd-MM-yyyy hh:mm"/></td>
						                						</tr>
						                					</tbody>
						                				</table>
						                			</div>
						                			<div class="contentCenter">
						                				<ul style="font-size: 9pt;">
							                				<li><b>Ưu điểm</b>: <c:out value="${c.uuDiem}"/> </li>
							                				<li><b>Nhược điểm</b>: <c:out value="${c.nhuocDiem}"/> </li>
							                				<li><b>Tổng quan</b>: <c:out value="${c.tongQuan}"/></li>
							                				<li><b>Đánh giá</b>: <fmt:formatNumber value="${c.danhGia}" minIntegerDigits="2"/> / 10</li>
							                				<c:if test="${(sessionScope.userType eq 'NhanVien') or (sessionScope.userType eq 'NhanVienQuanLy')}">
							                					<li>
							                						<b><i>Hiển thị với khách hàng</i></b>: 
							                						<span id="span${c.id}">
							                							<c:choose><c:when test="${c.hienThi eq true}">Hiển thị</c:when><c:otherwise>Không hiển thị</c:otherwise></c:choose>
							                						</span>
							                					</li>
							                				</c:if>
						                				</ul>
						                			</div>
						                			
						                			<!-- Function for employees -->
													<c:if test="${(sessionScope.userType eq 'NhanVien') or (sessionScope.userType eq 'NhanVienQuanLy')}">
														<div class="employeeTaskBox01">
															<c:set var="v" value="Hiển thị"/>
															<c:if test="${c.hienThi eq true}">
																<c:set var="v" value="Không hiển thị"/>
															</c:if>
															<table align="right">
																<tbody>
																	<tr>
																		<td align="right">
																			<input id="<c:out value="button${c.id}"/>" type="button" value="${v}" onclick="setCommentVisibility('setCommentVisibility.html?cid=${c.id}', ${c.id})"/>
																		</td>
																	</tr>
																</tbody>
															</table>
														</div>
													</c:if>
													<div style="clear: both;"></div>
						                		</div>
					                		</c:if>
				                		</c:forEach>
		                			</c:when>
		                			<c:otherwise>
		                				<div class="notFound">Hiện chưa có nhận xét nào cho <c:out value="${p.ten}"/></div>
		                			</c:otherwise>
		                		</c:choose>
							</div>
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

