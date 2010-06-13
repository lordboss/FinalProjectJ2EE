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
                	
                	<!-- Suggestion List -->
					<div class="block01">
						<div class="blockTitle" id="regTitle">Danh sách các góp ý của bạn</div>
						<div class="contentCenter" id="regContainer">
							<c:choose>
								<c:when test="${fn:length(model) > 0}">
									<c:forEach var="g" items="${model}" varStatus="loop">
										<div class="suggestionBox">
											<table>
												<tbody>
													<tr><td colspan="2" style="font-weight: bold"><c:out value="${loop.count}"/></td></tr>
													<tr class="suggestionInfoRow">
														<td>Ngày tạo:</td>
														<td>
															<c:out value="${g.ngayTao.date}"/> / <c:out value="${g.ngayTao.month + 1}"/> / <c:out value="${g.ngayTao.year + 1900}"/> <c:out value="${g.ngayTao.hours}"/>:<c:out value="${g.ngayTao.minutes}"/>
														</td>
													</tr>
													<tr class="suggestionInfoRow">
														<td>Tiêu đề:</td>
														<td><c:out value="${g.tieuDe}"/></td>
													</tr>
													<tr class="suggestionInfoRow">
														<td>Nội dung:</td>
														<td>
															<textarea class="boxInput" rows="5" cols="90" style="width: 95%" readonly="readonly"><c:out value="${g.noiDung}"/></textarea>
														</td>
													</tr>
													<tr class="suggestionInfoRow">
														<td>Trạng thái:</td>
														<td>
															<c:out value="${g.trangThaiGopY.trangThai}"/>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									
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

