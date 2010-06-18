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
        <script type="text/javascript" src="js/newsType.js"></script>
        <script type="text/javascript" src="js/newsVisibility.js"></script>
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
        	
			function toggleEditForm(id) {
				var s1 = "div#edit" + id;
				$(s1).toggle("fast");
			}

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
                	
                	<!-- List of news -->
					<div class="block01">
						<div class="blockTitle" id="newsTitle">Danh sách tin tức (<c:out value="${fn:length(model.pageList)}"/>)</div>
						<div class="contentCenter" id="newsContainer">
							<div>
								<div class="newsHelp" id="newsHelp"><a onmouseover="this.style.cursor='pointer'">Trợ giúp</a></div>
								<div class="newsHelpContent" id="newsHelpContent">
									Nhân viên có thể <b>thêm</b> một tin tức mới, <b>xóa</b> hay <b>cập nhật</b> nội dung của tin tức, chọn kích hoạt <b>hiển thị</b>/<b>không hiển thị</b> với khách hàng đối với 1 tin tức.
								</div>
							</div>
							<c:if test="${not empty model.status}">
								<div class="successInfo">
									<span class="successInfoText"><c:out value="${model.status}"/>   </span>
									<a href="manageNews.html">Xem danh sách tin tức</a>
								</div>
							</c:if>
							<spring:nestedPath path="tinTuc">
								<form method="post" action="addNews.html" onsubmit="return checkForm02();">
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
					                			<div class="detailTitle">Chi tiết tin tức</div>
					                			<div class="newsInfoContent">
													<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
														<tr>
															<spring:nestedPath path="loaiTinTuc">
														    	<td align="right" width="15%">Loại tin:</td>
														    	<td width="50%" align="left">
											    					<spring:bind path="id">
												    					<select name="${status.expression}">
												    						<option value="1" <c:if test="${status.value == 1}">selected</c:if>>Thông thường</option>
												    						<option value="2" <c:if test="${status.value == 2}">selected</c:if>>Thông báo</option>
												    						<option value="3" <c:if test="${status.value == 3}">selected</c:if>>Khuyến mãi</option>
												    					</select>
												    				</spring:bind>
														    	</td>
														    	<td width="35%">
														    		<c:if test="${status.error}">
																		<span class="error"><c:out value="${status.errorMessage}"/></span>
																	</c:if>
														    	</td>
													    	</spring:nestedPath>
													    </tr>
													    
													    <tr>
													    	<spring:nestedPath path="ngayDang">
													    		<td align="right">Ngày đăng:</td>
													    		<td>
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
														    	<td>
														    		<c:if test="${status.error}">
																		<span class="error"><c:out value="${status.errorMessage}"/></span>
																	</c:if>
																	
																	<span class="error" id="dateRequired"></span>
														    	</td>
													    	</spring:nestedPath>
													    </tr>
													    
													    <tr>
													    	<spring:bind path="tieuDe">
														    	<td align="right">Tiêu đề:</td>
														    	<td width="40%">
														    		<input type="text" name="${status.expression}" value="${status.value}" style="width: 98%"/>
														    	</td>
														    	<td>
														    		<c:if test="${status.error}">
																		<span class="error"><c:out value="${status.errorMessage}"/></span>
																	</c:if>
														    	</td>
													    	</spring:bind>
													    </tr>
														<tr>
															<spring:bind path="noiDung">
														    	<td align="right" width="25%" valign="top">Nội dung:</td>
														    	<td width="40%">
														    		<textarea rows="10" cols="40" name="${status.expression}"><c:out value="${status.value}"/></textarea>
														    	</td>
														    	<td>
														    		<c:if test="${status.error}">
																		<span class="error"><c:out value="${status.errorMessage}"/></span>
																	</c:if>
														    	</td>
													    	</spring:bind>
													    </tr>
													    <tr>
													    	<spring:bind path="hienThi">
													    		<td align="right">Hiển thị:</td>
													    		<td>
													    			<select name="${status.expression}">
													    				<option value="true" <c:if test="${status.value}">selected</c:if> >Hiển thị</option>
													    				<option value="false" <c:if test="${status.value}">selected</c:if> >Không hiển thị</option>
													    			</select>
													    		</td>
													    		<td>
													    			<c:if test="${status.error}">
																		<span class="error"><c:out value="${status.errorMessage}"/></span>
																	</c:if>
													    		</td>
													    	</spring:bind>
													    </tr>
													    
													    <tr>
													    	<td colspan="3" align="right">
													    		<a href="manageNews.html"><input type="button" value="Trở lại"></a> 
													    		<input type="submit" value="Đồng ý" />
													    	</td>
													    </tr>
													</table>
					                			</div>
					                		</div>
					                	</div> <!-- end innner right column -->
					                	<div style="clear: both;"></div>
									</div>
								</form>
							</spring:nestedPath>
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

