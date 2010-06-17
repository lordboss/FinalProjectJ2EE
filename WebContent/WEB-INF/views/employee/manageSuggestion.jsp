<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Required login to view this page --%>
<%@ include file="/WEB-INF/views/employee/requiredLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link href="css/3_col.css" media="all" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/suggestionStatus.js"></script>
        <script type="text/javascript">
        	$(document).ready(function() {
				$("div#regTitle").click(function(){
					$("div#regContainer").toggle("fast");
				});
			});

			function toggleEditForm(id) {
				var s1 = "div#edit" + id;
				$(s1).toggle("fast");
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
                	
                	<!-- Suggestion List -->
					<div class="block01">
						<div class="blockTitle" id="regTitle">Danh sách các góp ý</div>
						<div class="contentCenter" id="regContainer">
							<c:choose>
								<c:when test="${not empty model}">
									<c:forEach var="g" items="${model.pageList}" varStatus="loop">
										<div class="suggestionBox">
											<table>
												<tbody>
													<tr><td colspan="2" style="font-weight: bold"><c:out value="${loop.count}"/></td></tr>
													<tr class="suggestionInfoRow">
														<td>Người gởi:</td>
														<td>
															<c:out value="${g.khachHang.username}"/>
														</td>
													</tr>
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
															<span id="v<c:out value="${g.id}"/>"><b><c:out value="${g.trangThaiGopY.trangThai}"/></b></span>
															<img src="img/icon/edit.png" width="24" height="24" align="middle" onclick="toggleEditForm(<c:out value="${g.id}"/>)" onmouseover="this.style.cursor='pointer'" title="Cập nhật trạng thái góp ý"></img>
														</td>
													</tr>
												</tbody>
											</table>
											<!-- Edit suggestion status -->
											<div id="edit<c:out value="${g.id}"/>" class="suggestionStatusEdit" style="display: none;">
												<div style="font-weight: bold;color: green">Cập nhật trạng thái góp ý</div>
												<div>
													<table>
														<tr>
															<td>
																<select id="newStatus<c:out value="${g.id}"/>" name="newStatus<c:out value="${g.id}"/>">
																	<option value="1" <c:if test="${g.trangThaiGopY.id eq 1}">selected</c:if>>Chưa đọc</option>
																	<option value="2" <c:if test="${g.trangThaiGopY.id eq 2}">selected</c:if>>Đã đọc</option>
																	<option value="3" <c:if test="${g.trangThaiGopY.id eq 3}">selected</c:if>>Đã giải quyết</option>
																</select>
															</td>
															<td>
																<input type="submit" value="Cập nhật" onclick="setStatus('setSuggestionStatus.html?id=<c:out value="${g.id}"/>', <c:out value="${g.id}"/>)">
															</td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</c:forEach>
									
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
								</c:when>
								
								<c:otherwise>
									<div class="notFound">Danh sách góp ý còn trống</div>
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

