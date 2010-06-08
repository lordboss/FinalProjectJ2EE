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
				$("div#regTitle").click(function(){
					$("div#regContainer").toggle("fast");
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
                	
                	<!-- Register Form -->
					<div class="block01">
						<div class="blockTitle" id="regTitle">Đăng kí thành viên</div>
						<div class="contentCenter" id="regContainer">
							<div>Xin vui lòng cung cấp đủ thông tin</div>
							<spring:nestedPath path="khachHang">
								<form action="register.html" method="post">
									<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
										<tr>
									    	<spring:bind path="ho">
										    	<td align="right" width="20%">Họ:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="text" name="${status.expression}" value="${status.value}" /><span class="error">(*)</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<spring:bind path="dem">
										    	<td align="right" width="20%">Đệm:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="text" name="${status.expression}" value="${status.value}" />
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<spring:bind path="ten">
										    	<td align="right" width="20%">Tên:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="text" name="${status.expression}" value="${status.value}" /><span class="error">(*)</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<spring:bind path="username">
										    	<td align="right" width="20%">Username:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="text" name="${status.expression}" value="${status.value}" /><span class="error">(*)</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<spring:bind path="pass">
										    	<td align="right" width="20%">Password:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="password" name="${status.expression}" value="${status.value}" /><span class="error">(*)</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<td align="right" width="20%">Confirm Password:</td>
									    	<td width="40%">
									    		<input class="regInput01" type="password" name="password2" /><span class="error">(*)</span>
									    	</td>
									    	<td width="40%">
									    		
									    	</td>
									    </tr>
									    <tr>
									    	<spring:bind path="email">
										    	<td align="right" width="20%">Email:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="text" name="${status.expression}" value="${status.value}" /><span class="error">(*)</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<td colspan="3">
									    		<center><input type="submit" value="Đồng ý"></center>
									    	</td>
									    </tr>
									</table>
								</form>
							</spring:nestedPath>
							<div><span class="error">(*)</span>: Các trường bắt buộc nhập liệu</div>
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

