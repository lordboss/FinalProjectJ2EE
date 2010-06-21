<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Required login to view this page --%>
<%@ include file="/WEB-INF/views/admin/requiredLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/setAccountActivition.js"></script>

        <script type="text/javascript">
        	$(document).ready(function() {
				$("div#newsTitle1").click(function(){
					$("div#newsContainer1").toggle("fast");
				});
				$("div#newsHelp1").click(function() {
					$("div#newsHelpContent1").slideToggle("fast");
				});

				$("div#newsTitle2").click(function(){
					$("div#newsContainer2").toggle("fast");
				});
				$("div#newsHelp2").click(function() {
					$("div#newsHelpContent2").slideToggle("fast");
				});

				$("div#newsTitle3").click(function(){
					$("div#newsContainer3").toggle("fast");
				});
				$("div#newsHelp3").click(function() {
					$("div#newsHelpContent3").slideToggle("fast");
				});
			});
        
			function confirmDeletion() {
				return confirm("Bạn có thực sự muốn xóa?");
			}
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
                	
                	<c:forEach var="type" items="${model.accountTypes}" varStatus="loop">
                	<!-- List of accounts -->
					<div class="block01">
						<div class="blockTitle" id="newsTitle${loop.count}">Danh sách tài khoản <c:out value="${type[0].class.simpleName}"/></div>
						<div class="contentCenter" id="newsContainer${loop.count}">
							<div>
								<div class="newsHelp" id="newsHelp${loop.count}"><a onmouseover="this.style.cursor='pointer'">Trợ giúp</a></div>
								<div class="newsHelpContent" id="newsHelpContent${loop.count}">
									Nhân viên <b><i>quản trị</i></b> có thể <b>kích hoạt</b> hoặc <b>vô hiệu hóa</b> 
									các tài khoản của khách hàng/nhân viên 
									(có thể thực hiện trên một hoặc cùng lúc nhiều nhân viên); 
									<b>Xem</b> danh sách tài khoản và <b>xóa</b> tài khoản; 
									Có thể reset mật khẩu cho người dùng và gởi mật khẩu mới qua email. 
									Trước khi thực hiện thì cho phép review email.
								</div>
							</div>
							
							<!-- Users -->
							<c:choose>
								<c:when test="${! empty type}">
									<c:forEach var="n" items="${type}">
										<c:if test="${true}">
											<div class="newsItem">
												<!-- Inner Left Column -->
							                	<div id="newsItemInnerLeftColumn">
							                		<!-- Bill Icon -->
													<div class="newsIcon">
														<center><a href="#" ><img src="img/icon/male_user.png" width="75px" height="75"/></a></center>
														<div class="newsType">
															<span><c:out value="${n.class.simpleName}"/></span>
														</div>
													</div>
							                	</div>
			                	
							                	<!-- Inner Right Column -->
							                	<div id="newsItemInnerRightColumn">
							                		<div class="newsItemInfo">
							                			<div class="detailTitle">Chi tiết tài khoản</div>
							                			<div class="newsInfoContent">
															<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
																<tr>
															    	<td align="right" width="25%"></td>
															    	<td width="75%" align="left">
															    		<div>
															    			<a style="color: green;font-weight: bold;text-decoration: none;text-transform: uppercase">
															    				<span id="t<c:out value="${n.id}"/>" ><c:out value="${n.class.simpleName}"/></span>
															    			</a>
															    		</div>
															    	</td>
															    </tr>
															    <tr>
															    	<td align="right" width="25%">Username:</td>
															    	<td width="40%">
															    		<c:out value="${n.username}"/>
															    	</td>
															    </tr>
															    <tr>
															    	<td align="right">Email:</td>
															    	<td width="40%">
															    		<c:out value="${n.email}"/>
															    	</td>
															    </tr>
															    <!-- Active or deactive -->
																<tr>
															    	<td align="right" width="25%">Trạng thái:</td>
															    	<td width="40%">
															    		<c:choose>
															    			<c:when test="${n.trangThai eq 1}"><c:set var="state" value="Active"/></c:when>
															    			<c:when test="${n.trangThai eq 0}"><c:set var="state" value="Chưa kích hoạt"/></c:when>
															    			<c:otherwise><c:set var="state" value="Invalid state"/></c:otherwise>
															    		</c:choose>
															    		<!-- will be set by ajax -->
															    		<span id="<c:out value="stateLabel${n.id}" />" style="color: highlight;font-weight: bold;">${state}</span>
															    	</td>
															    </tr>
															</table>
															
															<!-- Admin Task -->
															<div style="text-align: right">
																
																
																<table align="right">
																	<tbody>
																		<tr>
																			<td>
																				<a href="sendEmail.html?aid=${n.id}"><input type="button" value="Gởi email" /></a>
																			</td>
																			<td>
																				<a href="resetAccount.html?aid=${n.id}"><input type="button" value="Reset mật khẩu" /></a>
																			</td>
																			<td>
																				<a href="deleteAccount.html?aid=${n.id}"><input type="button" value="Xóa" onclick="return confirmDeletion();"/></a>
																			</td>
																			<c:set var="v" value="Kích hoạt"/>
																			<c:if test="${n.trangThai eq 1}">
																				<c:set var="v" value="Vô hiệu hóa"/>
																			</c:if>
																			<td>	
																				<!-- will be set by ajax -->
																				<input id="<c:out value="stateButton${n.id}" />" type="button" value="${ v }" onclick="changeActivition('setAccountActivition.html?aid=<c:out value="${n.id}"/>',<c:out value="${n.id}"/>)" />
																			</td>
																		</tr>
																	</tbody>
																</table>
															</div>
							                			</div>
							                		</div>
							                	</div> <%-- end innner right column --%>
							                	<div style="clear: both;"></div>
											</div>
										</c:if>
									</c:forEach>
									
									<%--
									<!-- Paging content -->
									<div class="paging">
										<a href="?page=first"><b>First</b></a>
										<c:if test="${!model.firstPage}">
											<a href="?page=prev">&lt;&lt; Prev</a>
										</c:if> 
										<c:forEach var="currentPage" begin="${model.firstLinkedPage}" end="${model.lastLinkedPage}">
											<c:choose>
												<c:when test="${currentPage == model.page}">
													<b><c:out value="${currentPage + 1}"/></b>
												</c:when>
												<c:otherwise>
													<a href="?page=<c:url value="${currentPage}"></c:url>"><c:out value="${currentPage+1}"/></a>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<c:if test="${!model.lastPage}">
											<a href="?page=next">Next &gt;&gt;</a>
										</c:if>
										<a href="?page=last">Last</a>
									</div>
									 --%>
								</c:when>
								<c:otherwise>
									<div style="margin-bottom: 10px; text-align: left; padding-left: 5px;font-size: 9pt;">Hệ thống chưa có tin tức nào.</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					</c:forEach>
                </div> <!-- end midlle column -->
                
                <!-- Include Right Column -->
                <%@ include file="/WEB-INF/views/include/rightColumn.jsp" %>
                
            </div> <!-- end content -->
            
            <!-- Footer -->
            <%@include file="/WEB-INF/views/include/footer.jsp" %>
        </div>
    </body>
</html>

