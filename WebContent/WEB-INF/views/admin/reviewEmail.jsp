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
        <script type="text/javascript" src="js/dateValidator.js"></script>
        
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
									Admin có thể review nội dung email trước khi gởi.
								</div>
							</div>
							
							
							<div class="newsItem">
								
								<!-- Inner Left Column -->
			                	<div id="newsItemInnerLeftColumn">
			                		<!-- Bill Icon -->
									<div class="newsIcon">
										<center><a href="#" ><img src="img/icon/mail_send.png" width="75px" height="75"/></a></center>
									</div>
			                	</div> <!-- End inner Left Column -->
               	
			                	<!-- Inner Right Column -->
			                	<div id="newsItemInnerRightColumn">
			                		<div class="newsItemInfo">
			                			<div class="detailTitle">REVIEW AND SEND EMAIL</div>
			                			<div class="newsInfoContent">
			                				<c:if test="${not empty model}">
				                				<c:choose>
					                				<c:when test="${model.isSuccess eq 'yes'}">
														<div class="successInfo">
															<span class="successInfoText"><c:out value="${model.status}"/> </span>
															<a href="viewAccounts.html">View accounts list</a>
														</div>
													</c:when>
													<c:when test="${model.isSuccess eq 'no'}">
														<div class="failedInfo">
															<span class="failedInfoText"><c:out value="${model.status}"/></span>
														</div>
													</c:when>
												</c:choose>
											</c:if>
			                				<spring:nestedPath path="email">
			                					<form method="post" action="sendEmail.html">
													<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
														<tr>
															<spring:bind path="subject">
														    	<td align="right" width="15%">Subject:</td>
														    	<td width="50%" align="left">
											    					<input type="text" name="${status.expression}" value="${status.value}" style="width: 100%"/>
														    	</td>
														    	<td><span class="error"> *</span></td>
														    	<td>
														    		<c:if test="${status.error}">
																		<span class="error"><c:out value="${status.errorMessage}"/></span>
																	</c:if>
														    	</td>
													    	</spring:bind>
													    </tr>
													    <tr>
													    	<spring:bind path="to">
													    		<td align="right">To:</td>
													    		<td>
													    			<input type="text" name="${status.expression}" value="${status.value}" style="width: 100%"/>
														    	</td>
														    	<td><span class="error"> *</span></td>
														    	<td>
														    		<c:if test="${status.error}">
																		<span class="error"><c:out value="${status.errorMessage}"/></span>
																	</c:if>
														    	</td>
													    	</spring:bind>
													    </tr>
													    <tr>
													    	<spring:bind path="body">
													    		<td align="right" valign="top">Body:</td>
													    		<td>
													    			<textarea rows="10" cols="35" name="${status.expression}"><c:out value="${status.value}"/></textarea>
													    		</td>
													    		<td valign="top"><span class="error"> *</span></td>
													    		<td>
														    		<c:if test="${status.error}">
																		<span class="error"><c:out value="${status.errorMessage}"/></span>
																	</c:if>
														    	</td>
													    	</spring:bind>
													    </tr>
													    <tr>
													    	<td colspan="2" align="right">
													    		<a href="viewAccounts.html"><input type="submit" value="Trở lại" /></a>
													    		<input type="submit" value="Send" />
													    	</td>
													    </tr>
													    <tr>
													    	<td colspan="4" valign="top"><span class="error">(*)</span>: Các trường bắt buộc nhập liệu</td>
													    </tr>
													</table>
												</form>
											</spring:nestedPath>
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

