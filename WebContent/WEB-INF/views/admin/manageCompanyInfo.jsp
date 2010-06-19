<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Required login to view this page --%>
<%@ include file="/WEB-INF/views/admin/requiredLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%><html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        
        <script type="text/javascript">
        	$(document).ready(function() {
        		$("div#newsTitle").click(function(){
					$("div#newsContainer").toggle("fast");
				});
				$("div#newsHelp").click(function() {
					$("div#newsHelpContent").slideToggle("fast");
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
                	
                	<!-- List of news -->
					<div class="block01">
						<div class="blockTitle" id="newsTitle">THÔNG TIN CÔNG TY</div>
						<div class="contentCenter" id="newsContainer">
							<div>
								<div class="newsHelp" id="newsHelp"><a onmouseover="this.style.cursor='pointer'">Trợ giúp</a></div>
								<div class="newsHelpContent" id="newsHelpContent">
									Admin có thể chỉnh sửa cập nhật các thông tin giới thiệu về công ty.
								</div>
							</div>
							
							
							<div class="newsItem">
								
								<!-- Inner Left Column -->
			                	<div id="newsItemInnerLeftColumn">
			                		<!-- Bill Icon -->
									<div class="newsIcon">
										<center><a href="#" ><img src="img/icon/twitter.png" width="75px" height="75"/></a></center>
									</div>
			                	</div> <!-- End inner Left Column -->
               	
			                	<!-- Inner Right Column -->
			                	<div id="newsItemInnerRightColumn">
			                		<div class="newsItemInfo">
			                			<div class="detailTitle">THÔNG TIN CÔNG TY</div>
			                			<div class="newsInfoContent">
											<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
												<tr>
											    	<td align="right" width="15%">Tên công ty:</td>
											    	<td width="50%" align="left">
								    					<c:out value="${model.ten}"></c:out>
											    	</td>
											    </tr>
											    <tr>
										    		<td align="right">Địa chỉ:</td>
										    		<td>
										    			<c:out value="${model.diaChi}"></c:out>
											    	</td>
											    </tr>
											    <tr>
											    	<td align="right">Điện thoại:</td>
											    	<td width="40%">
											    		<c:out value="${model.dienThoai}"></c:out>
											    	</td>
											    </tr>
												<tr>
											    	<td align="right" width="25%" valign="top">Email:</td>
											    	<td width="40%">
											    		<c:out value="${model.email}"></c:out>
											    	</td>
											    </tr>
											    <tr>
										    		<td align="right">Ngày thành lập:</td>
										    		<td>
										    			<fmt:formatDate value="${model.ngayThanhLap}" pattern="dd/MM/yyyy"/>
										    		</td>
											    </tr>
											    <tr>
										    		<td align="right">Thông tin chung:</td>
										    		<td>
										    			<c:out value="${model.thongTinChung}"></c:out>
										    		</td>
											    </tr>
											    <tr>
											    	<td colspan="3" align="right">
											    		<a href="updateCompanyInfo.html"><input type="button" value="Cập nhật" /></a>
											    	</td>
											    </tr>
											</table>
			                			</div>
			                		</div>
			                	</div> <!-- end innner right column -->
			                	<div style="clear: both;"></div>
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

