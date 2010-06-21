<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Required login to view this page --%>
<%@ include file="/WEB-INF/views/admin/requiredLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/changeUserPasswordValidator.js"></script>
        
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
			<%@ include file="/WEB-INF/views/include/menu.jsp" %>
			
            <!-- Content -->
            <div id="content-container">
            
            	<!-- Include Left Column -->
                <%@ include file="/WEB-INF/views/include/leftColumn.jsp" %>
            	
                
                
                <!-- Middle Column -->
                <div id="content">
                	
                	<!-- Register Form -->
					<div class="block01">
						<div class="blockTitle" id="regTitle">Thay đổi mật khẩu</div>
						<div class="contentCenter" id="regContainer">
							<c:if test="${not empty model.status}">
								<div class="<c:choose><c:when test="${model.success eq '1'}"><c:out value="successInfo"/></c:when><c:otherwise><c:out value="failedInfo"/></c:otherwise></c:choose>">
									<span class="successInfoText"><c:out value="${model.status}"/>   </span>
								</div>
							</c:if>
							<spring:nestedPath path="nhanVienQuanTri">
								<form action="changeAdminPassword.html" method="post" onsubmit="return checkForm();" >
									<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
										<tr>
											<td align="right" width="20%">Mật khẩu cũ:</td>
									    	<td width="40%">
									    		<input class="regInput01" type="password" name="oldPassword" id="oldPassword" /><span class="error"> *</span>
									    	</td>
									    	<td width="40%">
												<span class="error" id="oldPasswordError"></span>
									    	</td>
										</tr>
									    <tr>
									    	<spring:bind path="pass">
										    	<td align="right" width="20%">Mật khẩu mới:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="password" id="password" name="${status.expression}" /><span class="error"> *</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error" id="passwordError"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<spring:bind path="pass2">
										    	<td align="right" width="20%">Xác nhận mật khẩu mới:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="password" id="password2" name="${status.expression}" /><span class="error"> *</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error" id="password2Error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<td align="right" width="20%"></td>
									    	<td width="40%" align="right" style="padding-right: 30px;">
									    		<a href="viewAccounts.html"><input type="button" value="Trở lại"></a>
									    		<input type="submit" value="Đồng ý" onclick="buoi()">
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

