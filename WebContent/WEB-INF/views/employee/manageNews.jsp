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
        <script type="text/javascript" src="js/newsType.js"></script>
        <script type="text/javascript" src="js/newsVisibility.js"></script>
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
							<c:choose>
								<c:when test="${! empty model}">
									<c:forEach var="n" items="${model.pageList}">
										<c:if test="${true}">
											<a name="a:<c:out value="${bill.id}"/>"></a>
											<div class="newsItem">
												<!-- Inner Left Column -->
							                	<div id="newsItemInnerLeftColumn">
							                		<!-- Bill Icon -->
													<div class="newsIcon">
														<center><a href="#" ><img src="img/icon/twitter.png" width="75px" height="75"/></a></center>
														<div class="newsType">
															<span id="tt<c:out value="${n.id}"/>" ><c:out value="${n.loaiTinTuc.loaiTin}"/></span>
														</div>
														<div class="newsEditType">
															<img src="img/icon/edit.png" width="32" height="32" onclick="toggleEditForm(<c:out value="${n.id}"/>)" onmouseover="this.style.cursor='pointer'" title="Cập nhật loại tin tức"></img>
														</div>
														<!-- News type status -->
														<div id="edit<c:out value="${n.id}"/>" class="newsEditForm" style="display: none;">
															<div style="font-weight: bold;color: green">Cập nhật loại tin tức</div>
															<div>
																<select id="newsType<c:out value="${n.id}"/>" name="newsType">
																	<option value="1" <c:if test="${n.loaiTinTuc.id eq 1}">selected</c:if>>Thông thường</option>
																	<option value="2" <c:if test="${n.loaiTinTuc.id eq 2}">selected</c:if>>Thông báo</option>
																	<option value="3" <c:if test="${n.loaiTinTuc.id eq 3}">selected</c:if>>Khuyến mãi</option>
																</select>
																<center><input type="button" value="Cập nhật" onclick="setNewsType('setNewsType.html?id=<c:out value="${n.id}"/>', <c:out value="${n.id}"/>)" ></center>
															</div>
														</div>
													</div>
							                	</div>
			                	
							                	<!-- Inner Right Column -->
							                	<div id="newsItemInnerRightColumn">
							                		<div class="newsItemInfo">
							                			<div class="detailTitle">Chi tiết tin tức</div>
							                			<div class="newsInfoContent">
															<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="3">
																<tr>
															    	<td align="right" width="25%"></td>
															    	<td width="75%" align="left">
															    		<div>
															    			<a style="color: green;font-weight: bold;text-decoration: none;text-transform: uppercase">
															    				Loại tin: <span id="t<c:out value="${n.id}"/>" ><c:out value="${n.loaiTinTuc.loaiTin}"/></span>
															    			</a>
															    		</div>
															    	</td>
															    </tr>
															    <tr>
															    	<td align="right" width="25%">Ngày đăng:</td>
															    	<td width="40%">
															    		<fmt:formatNumber minIntegerDigits="2" value="${n.ngayDang.date}"/> / <fmt:formatNumber minIntegerDigits="2" value="${n.ngayDang.month + 1}"/> / <c:out value="${n.ngayDang.year + 1900}"/> <fmt:formatNumber minIntegerDigits="2" value="${n.ngayDang.hours}"/>:<fmt:formatNumber minIntegerDigits="2" value="${n.ngayDang.minutes}"/>
															    	</td>
															    </tr>
															    <tr>
															    	<td align="right">Tiêu đề:</td>
															    	<td width="40%">
															    		<c:out value="${n.tieuDe}"/>
															    	</td>
															    </tr>
																<tr>
															    	<td align="right" width="25%">Nội dung:</td>
															    	<td width="40%">
															    		<c:out value="${n.noiDung}"/>
															    	</td>
															    </tr>
															</table>
															
															<!-- Employee Task -->
															<div style="text-align: right">
																<c:set var="v" value="Hiển thị"/>
																<c:if test="${n.hienThi eq true}">
																	<c:set var="v" value="Không hiển thị"/>
																</c:if>
																
																<table align="right">
																	<tbody>
																		<tr>
																			<td>
																				<a href="updateNews.html?nid=${n.id}"><input type="button" value="Cập nhật" /></a>
																			</td>
																			<td>
																				<form method="get" action="deleteNews.html" onsubmit="return confirmDeletion();">
																					<input type="hidden" name="nid" value="<c:out value="${n.id}"/>">
																					<input type="submit" value="Xóa" />
																				</form>
																			</td>
																			<td>
																				<input id="<c:out value="v${n.id}" />" type="button" value="${ v }" onclick="changeVisibility('setNewsVisibility.html?nid=<c:out value="${n.id}"/>',<c:out value="${n.id}"/>)" />
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
									<div style="margin-bottom: 10px; text-align: left; padding-left: 5px;font-size: 9pt;">Hệ thống chưa có tin tức nào.</div>
								</c:otherwise>
							</c:choose>
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

