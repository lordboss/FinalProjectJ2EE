<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Required login to view this page --%>
<%@ include file="/WEB-INF/views/user/requiredLogin.jsp" %>

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
                	
                	<!-- Account information -->
					<div class="block01">
						<div class="blockTitle" id="accountTitle">Thông tin tài khoản</div>
						<div class="contentCenter" id="accountContainer">
							<c:choose>
								<c:when test="${not empty k}">
									<div>
										<div class="userInfoImage">
											<img alt="userInfo" src="img/icon/user_info.png" width="128" height="128">
										</div>
										<div class="userInfoContainer">
											<table width="350;">
												<colgroup class="userInfoTitle"></colgroup>
												<colgroup class="userInfoContent"></colgroup>
												<tbody>
													<tr  class="userInfoRow">
														<td>Họ và tên:</td>
														<td><c:out value="${k.ho}"/> <c:out value="${k.dem}"/> <c:out value="${k.ten}"/></td>
													</tr>
													<tr  class="userInfoRow">
														<td>Ngày sinh:</td>
														<td>
															<c:choose>
																<c:when test="${(k.ngaySinh.date > 0)}">
																	<c:out value="${k.ngaySinh.date}"/> / <c:out value="${k.ngaySinh.month + 1}"/> / <c:out value="${k.ngaySinh.year + 1900}"/>
																</c:when>
																<c:otherwise>Chưa cập nhật thông tin</c:otherwise>
															</c:choose>
														</td>
													</tr>
													<tr  class="userInfoRow">
														<td>Giới tính</td>
														<td>
															<c:choose>
																<c:when test="${k.gioiTinh eq 1}">Nam</c:when>
																<c:when test="${k.gioiTinh eq 2}">Nữ</c:when>
																<c:otherwise></c:otherwise>
															</c:choose>
														</td>
													</tr>
													<tr  class="userInfoRow">
														<td>Địa chỉ:</td>
														<td>
															<c:out value="${k.diaChi}"/>
														</td>
													</tr>
													<tr  class="userInfoRow">
														<td>Tên đăng nhập:</td>
														<td><c:out value="${k.username}"/></td>
													</tr>
													<tr  class="userInfoRow">
														<td>Email:</td>
														<td><c:out value="${k.email}"/></td>
													</tr>
												</tbody>
											</table>
											<div class="userInfoSeparator"></div>
											
											<div class="userTask">
												<table>
													<tbody>
														<tr>
															<td>
																<a href="updateAccount.html">
																	<input type="submit" value="Cập nhật thông tin">
																</a>
															</td>
															<td>
																<a href="changeUserPassword.html">
																	<input type="submit" value="Thay đổi mật khẩu">
																</a>
															</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="notFound">Lỗi truy xuất tài khoản! Vui lòng thử lại sau!</div>
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

