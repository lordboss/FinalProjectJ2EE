<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Required login to view this page --%>
<%@ include file="/WEB-INF/views/user/requiredLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/dateValidator.js"></script>
        
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
						<div class="blockTitle" id="regTitle">Cập nhật thông tin cá nhân</div>
						<div class="contentCenter" id="regContainer">
							<c:if test="${not empty model.status}">
								<div class="successInfo">
									<span class="successInfoText"><c:out value="${model.status}"/>   </span>
									<a href="viewAccount.html">Xem tài khoản</a>
								</div>
							</c:if>
							<spring:nestedPath path="khachHang">
								<form action="updateAccount.html" method="post" onsubmit="return checkForm();">
									<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
										<tr>
									    	<spring:bind path="ho">
										    	<td align="right" width="20%">Họ:</td>
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
									    	<spring:nestedPath path="ngaySinh">
									    		<td align="right" width="20%">Ngày Sinh:</td>
									    		<td width="40%">
										    		<spring:bind path="date">
														<select name="${status.expression}" id="dd" >
															<option value="0" selected >- Ngày -</option>
															<c:forEach var="g" begin="1" end="31">
												           		<option value="${g}" <c:if test="${ status.value == g }">selected</c:if> >${g}</option>
												           	</c:forEach>
														</select>
													</spring:bind>
													<spring:bind path="month">
														<select name="${status.expression}" id="mm" onchange="adaptDay()">
															<option value="-1" selected >- Tháng -</option>
															<c:forEach var="g" begin="0" end="11">
												           		<option value="${g}" <c:if test="${ status.value == g }">selected</c:if> >${g + 1}</option>
												           	</c:forEach>
														</select>
													</spring:bind>
													
													<% Date myCurrent = new Date(); pageContext.setAttribute("d", myCurrent); %>
													
													<spring:bind path="year">
														<select name="${status.expression}"  id="yyyy" onchange="adaptDay()">
															<option value="-1900" selected >- Năm -</option>
															<c:forEach var="y" begin="0" end="${d.year}" >
																<c:set var="j" value="${d.year - y}"/>
												           		<option value="${j}" <c:if test="${ status.value == j }">selected</c:if> >${j + 1900}</option>
												           	</c:forEach>
														</select>
													</spring:bind>
													
													<span class="error"> *</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
													<%-- Javascript validation --%>
													<span class="error" id="dateRequired"></span>
										    	</td>
									    	</spring:nestedPath>
									    	
									    </tr>
									    <tr>
									    	<spring:bind path="gioiTinh">
									    		<td align="right" width="20%">Giới tính:</td>
									    		<td width="40%">
										    		<select name="${status.expression}">
										    			<option value="0" <c:if test="${ status.value == 0}">selected</c:if> >- Giới Tính -</option>
										    			<option value="1" <c:if test="${ status.value == 1}">selected</c:if> >Nam</option>
										    			<option value="2" <c:if test="${ status.value == 2}">selected</c:if> >Nữ</option>
										    		</select>
										    		<span class="error"> *</span>
									    		</td>
									    		<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<spring:bind path="diaChi">
									    		<td align="right" width="20%">Địa chỉ:</td>
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
									    	<spring:bind path="username">
										    	<td align="right" width="20%">Username:</td>
										    	<td width="40%">
										    		<input class="readOnlyTextbox" readonly="readonly" type="text" name="${status.expression}" value="${status.value}" />
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <%-- 
									    <tr>
									    	<spring:bind path="pass">
										    	<td align="right" width="20%">Password:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="password" name="${status.expression}" value="${status.value}" /><span class="error"> *</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<spring:bind path="pass2">
										    	<td align="right" width="20%">Confirm Password:</td>
										    	<td width="40%">
										    		<input class="regInput01" type="password" name="${status.expression}" value="${status.value}" /><span class="error"> *</span>
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    --%>
									    <tr>
									    	<spring:bind path="email">
										    	<td align="right" width="20%">Email:</td>
										    	<td width="40%">
										    		<input class="readOnlyTextbox" readonly="readonly" type="text" name="${status.expression}" value="${status.value}" />
										    	</td>
										    	<td width="40%">
										    		<c:if test="${status.error}">
														<span class="error"><c:out value="${status.errorMessage}"/></span>
													</c:if>
										    	</td>
									    	</spring:bind>
									    </tr>
									    <tr>
									    	<td align="right" width="20%"></td>
									    	<td width="40%" align="right" style="padding-right: 30px;">
									    		<a href="viewAccount.html"><input type="button" value="Trở lại"></a>
									    		<input type="submit" value="Đồng ý">
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

