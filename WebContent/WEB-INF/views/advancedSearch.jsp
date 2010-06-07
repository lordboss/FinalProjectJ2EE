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
				$("div#criteriaTitle").click(function(){
					$("div#criteriaContent").toggle("fast");
				});
				$("input#btn01").click(function() {
					$("div#multimedia").slideToggle("fast");
				});
				$("input#btn02").click(function() {
					$("div#connectivity").slideToggle("fast");
				});
				$("div#multimedia").slideUp();
				$("div#connectivity").slideUp();
			});
        </script>
    </head>
    <body>
        <div id="container">
        	<!-- Header -->
            <%@ include file="/WEB-INF/views/include/header.jsp" %>
            
			<!-- Menu -->
            <div id="navigation">
                <ul>
                    <li>
                        <a href="index.jsp">TRANG CHỦ</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="phoneListByBrand.html">ĐIỆN THOẠI</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="accessoryList.html">PHỤ KIỆN</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="#">GÓP Ý</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="#">LIÊN HỆ</a>
                    </li>
                </ul>
            </div> <!-- end menu -->
			
            <!-- Content -->
            <div id="content-container">
            
            	<!-- Include Left Column -->
                <%@ include file="/WEB-INF/views/include/leftColumn.jsp" %>
            	
                
                
                <!-- Middle Column -->
                <div id="content">
                	
                	<!-- List of phones -->
					<div class="block01">
						<div class="blockTitle" id="criteriaTitle">Tìm kiếm nâng cao</div>
						<div class="contentCenter" id="criteriaContent">
							<div class="helpSearch">Mời bạn chọn những tính năng cần thiết để hệ thống tìm ra chiếc điện thoại phù hợp nhất theo yêu cầu. </div>
							
							<!-- Advanced search form -->
							<spring:nestedPath path="phoneCriteria">
								<form method="post" action="advancedSearch.html" >
									<table width="98%" cellspacing="5px" cellpadding="0" border="0">
										<tbody>
											<!-- Name -->
											<tr>
												<td align="left">Tên model:</td>
												<td colspan="3">
													<spring:bind path="name">
														<input type="text" style="width:99%;" name="${status.expression}" value="${status.value}" />
													</spring:bind>
												</td>
											</tr>
											<!-- Price -->
											<tr>
												<td align="left">Giá từ:</td>
												<td>
													<spring:bind path="minPrice">
														<select style="width: 100%" name="${status.expression}" >
															<option value="-1" <c:if test="${ status.value == -1}">selected</c:if> >- Giá từ -</option>
																<c:forEach var="g" begin="1" end="10">
													           		<option value="${g * 1000000.0}" <c:if test="${ status.value == g * 1000000.0}">selected</c:if> >${g} triệu</option>
													           	</c:forEach>
															<option value="900000000" <c:if test="${ status.value == 900000000 }">selected</c:if> >&gt; 10 triệu</option>
														</select>
													</spring:bind>
												</td>
												<td align="right">Đến:</td>
												<td align="right">
													<spring:bind path="maxPrice">
														<select style="width: 100%" name="${status.expression}" >
															<option value="-1" <c:if test="${ status.value == -1}">selected</c:if> >- Đến -</option>
															<c:forEach var="g" begin="1" end="10">
												           		<option value="${g * 1000000.0}" <c:if test="${ status.value == g * 1000000.0}">selected</c:if>>${g} triệu</option>
												           	</c:forEach>
															<option value="900000000" <c:if test="${ status.value == 900000000 }">selected</c:if>>&gt; 10 triệu</option>
														</select>
													</spring:bind>
												</td>
											</tr>
											<!-- Manufacture -->
											<!-- A little bit hard code ;) -->
											<tr>
												<td align="left">Hãng điện thoại:</td>
												<td colspan="3">
													<spring:bind path="manufactureId">
														<select style="width: 100%" name="${status.expression}"  >
															<option value="-1" <c:if test="${ status.value == -1}">selected</c:if>> - Chọn Hãng Điện Thoại -</option>
													        <option value="1" <c:if test="${ status.value == 1}">selected</c:if>>Nokia</option>
													        <option value="2" <c:if test="${ status.value == 2}">selected</c:if>>LG</option>
													        <option value="3" <c:if test="${ status.value == 3}">selected</c:if>>Samsung</option>
													        <option value="4" <c:if test="${ status.value == 4}">selected</c:if>>Sony Ericssion</option>
													        <option value="5" <c:if test="${ status.value == 5}">selected</c:if>>HTC</option>
													        <option value="6" <c:if test="${ status.value == 6}">selected</c:if>>Motorola</option>
													        <option value="7" <c:if test="${ status.value == 7}">selected</c:if>>K-Touch</option>
													        <option value="8" <c:if test="${ status.value == 8}">selected</c:if>>Mobell</option>
													        <option value="9" <c:if test="${ status.value == 9}">selected</c:if>>F-Mobile</option>
													        <option value="10" <c:if test="${ status.value == 10}">selected</c:if>>Philips</option>
													        <option value="11" <c:if test="${ status.value == 11}">selected</c:if>>eTouch</option>
													        <option value="12" <c:if test="${ status.value == 12}">selected</c:if>>Apple</option>
													        <option value="13" <c:if test="${ status.value == 13}">selected</c:if>>Blackberry</option>
													        <option value="14" <c:if test="${ status.value == 14}">selected</c:if>>S-Fone</option>
													        <option value="15" <c:if test="${ status.value == 15}">selected</c:if>>Khác</option>
														</select>
													</spring:bind>
												</td>
											</tr>
											<!-- Multimedia -->
											<tr>
												<td>Giải trí:</td>
												<td colspan="3">
													<input type="button" id="btn01" value="Chọn tính năng">
													<div  class="criteriaBox" id="multimedia" >
														<spring:nestedPath path="mediaCriteria">
															<table>
																<tr>
																	<td>
																		<spring:bind path="hasFMRadio">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Đài FM
																		</spring:bind>
																	</td>
																	<td>
																		<spring:bind path="hasGame">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Game
																		</spring:bind>		
																	</td>
																</tr>
																<tr>
																	<td>
																		<spring:bind path="hasJavaApps">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Ứng dụng Java
																		</spring:bind>		
																	</td>
																	<td>
																		<spring:bind path="hasMusicPlayer">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Nghe nhạc	
																		</spring:bind>	
																	</td>
																</tr>
																<tr>
																	<td>
																		<spring:bind path="hasOfficeApps">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Ứng dụng văn phòng
																		</spring:bind>
																	</td>	
																	<td>
																		<spring:bind path="hasTivi">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Xem Tivi
																		</spring:bind>	
																	</td>
																</tr>
																<tr>
																	<td>
																		<spring:bind path="hasVideoPlayer">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Xem video
																		</spring:bind>
																	</td>
																	<td>
																		<spring:bind path="hasVideoRecorder">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Quay video	
																		</spring:bind>	
																	</td>
																</tr>
																<tr>
																	<td>
																		<spring:bind path="hasVoiceRecorder">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Ghi âm		
																		</spring:bind>
																	</td>
																</tr>
															</table>
														</spring:nestedPath>
													</div>
												</td>
											</tr>
											<!-- Design & Melody -->
											<tr>
												<td>Kiểu dáng:</td>
												<td>
													<spring:bind path="designId">
														<select style="width: 100%" name="${status.expression}" >
															<option value="-1" <c:if test="${ status.value == -1}">selected</c:if>>- Kiểu dáng -</option>
															<option value="2" <c:if test="${ status.value == 2}">selected</c:if>>Kiểu Nấp Gập</option>
															<option value="3" <c:if test="${ status.value == 3}">selected</c:if>>Kiểu Thanh</option>
															<option value="4" <c:if test="${ status.value == 4}">selected</c:if>>Kiểu Trượt</option>
															<option value="5" <c:if test="${ status.value == 5}">selected</c:if>>Kiểu Cảm Ứng</option>
															<option value="6" <c:if test="${ status.value == 6}">selected</c:if>>Kiểu Nắp Xoay</option>
															<option value="7" <c:if test="${ status.value == 7}">selected</c:if>>Kiểu Thân Xoay</option>
														</select>
													</spring:bind>
												</td>
												<td align="right">Nhạc chuông:</td>
												<td>
													<spring:bind path="melody">
														<select style="width: 100%" name="${status.expression}" >
															<option value="-1" <c:if test="${ status.value == -1}">selected</c:if>>- Nhạc chuông -</option>
															<option value="4" <c:if test="${ status.value == 4}">selected</c:if>>4 âm sắc</option>
															<option value="16" <c:if test="${ status.value == 16}">selected</c:if>>16 âm sắc</option>
															<option value="24" <c:if test="${ status.value == 24}">selected</c:if>>24 âm sắc</option>
															<option value="40" <c:if test="${ status.value == 40}">selected</c:if>>40 âm sắc</option>
															<option value="64" <c:if test="${ status.value == 64}">selected</c:if>>64 âm sắc</option>
															<option value="-1" <c:if test="${ status.value == -1}">selected</c:if>>Khác</option>
														</select>
													</spring:bind>
												</td>
											</tr>
											<!-- Connectivity -->
											<tr>
												<td>Kết nối:</td>
												<td colspan="3">
													<input type="button" id="btn02" value="Chọn kết nối">
													<div class="criteriaBox" id="connectivity" >
														<spring:nestedPath path="connectivityCriteria">
															<table>
																<tr>
																	<td>
																		<spring:bind path="has2Sim">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Hổ trợ 2 SIM
																		</spring:bind>
																	</td>
																	<td>
																		<spring:bind path="has3G">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />3G
																		</spring:bind>		
																	</td>
																</tr>
																<tr>
																	<td>
																		<spring:bind path="hasBluetooth">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Bluetooth
																		</spring:bind>		
																	</td>
																	<td>
																		<spring:bind path="hasGPRS">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />GPRS	
																		</spring:bind>	
																	</td>
																</tr>
																<tr>
																	<td>
																		<spring:bind path="hasGPS">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Định vị
																		</spring:bind>
																	</td>	
																	<td>
																		<spring:bind path="hasUSB">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />USB
																		</spring:bind>	
																	</td>
																</tr>
																<tr>
																	<td>
																		<spring:bind path="hasWifi">
																			<input type="checkbox" name="${status.expression}" <c:if test="${ status.value == true}">checked</c:if> />Wifi
																		</spring:bind>
																	</td>
																</tr>
															</table>
														</spring:nestedPath>
													</div>
												</td>
											</tr>
											<!-- Camera & Network (GSM, CDMA) -->
											<tr>
												<td>Camera:</td>
												<td>
													<spring:bind path="cameraRange">
														<select style="width: 100%" id="cameraRange" name="${status.expression}" >
															<option value="-1" <c:if test="${ status.value == -1}">selected</c:if>>- Camera -</option>
															<option value="1" <c:if test="${ status.value == 1}">selected</c:if>>Dưới 0.3 MP (VGA)</option>
															<option value="2" <c:if test="${ status.value == 2}">selected</c:if>>Từ 0.3 MP đến 1 MP</option>
															<option value="3" <c:if test="${ status.value == 3}">selected</c:if>>Từ 1 MP đến 2 MP</option>
															<option value="4" <c:if test="${ status.value == 4}">selected</c:if>>Từ 2 MP đến 3.2 MP</option>
															<option value="5" <c:if test="${ status.value == 5}">selected</c:if>>Từ 3.2 MP đến 5 MP</option>
															<option value="6" <c:if test="${ status.value == 6}">selected</c:if>>Từ 5 MP trở lên</option>
														</select>
													</spring:bind>
												</td>
												<td align="right">Mạng hỗ trợ:</td>
												<td>
													<spring:bind path="networkId">
														<select style="width: 100%" name="${status.expression}" >
															<option value="-1" <c:if test="${ status.value == -1}">selected</c:if>>- Loại Mạng -</option>
															<option value="1" <c:if test="${ status.value == 1}">selected</c:if>>GSM</option>
															<option value="2" <c:if test="${ status.value == 2}">selected</c:if>>CDMA</option> 
														</select>
													</spring:bind>
												</td>
											</tr>
											<tr>
												<td>Hệ điều hành: </td>
												<td colspan="3">
													<spring:bind path="osId">
														<select style="width: 100%" name="${status.expression}" >
															<option value="-1" <c:if test="${ status.value == -1}">selected</c:if>>- Hệ điều hành -</option>
															<option value="1" <c:if test="${ status.value == 1}">selected</c:if>>Không có hệ điều hành</option>
															<option value="2" <c:if test="${ status.value == 2}">selected</c:if>>Symbian</option>
															<option value="3" <c:if test="${ status.value == 3}">selected</c:if>>Android</option>
															<option value="4" <c:if test="${ status.value == 4}">selected</c:if>>Windows Mobile</option>
															<option value="5" <c:if test="${ status.value == 5}">selected</c:if>>RIM OS</option>
															<option value="6" <c:if test="${ status.value == 6}">selected</c:if>>iPhone</option>
															<option value="7" <c:if test="${ status.value == 7}">selected</c:if>>webOS</option>
															<option value="8" <c:if test="${ status.value == 8}">selected</c:if>>Bada</option>
														</select>
													</spring:bind>
												</td>
											</tr>
											<tr>
												<td colspan="4">
													<input type="submit" value="Tìm kiếm"/>
												</td>
											</tr>
										</tbody>
									</table>
								</form>
							</spring:nestedPath>
						</div>
						<div style="clear:both;"></div>
					</div>
					
					
					<!-- Search result -->
					<div class="block01">
						<!-- Title -->
						<div class="blockTitle" id="resultTitle">Kết quả tìm kiếm (<c:out value="${fn:length(model.result)}"/>)</div>
						<!-- Content of block -->
						<div class="contentCenter">
						<c:if test="${fn:length(model.result) > 0}">
							<c:forEach var="p" items="${model.result}" varStatus="loop">
								<div class="<c:choose><c:when test="${ loop.index eq 0 }"><c:out value="itemLeft"/></c:when><c:otherwise><c:out value="itemCenter"/></c:otherwise></c:choose>">
									<!-- New model or not -->
									<c:choose>
										<c:when test="${p.tinhTrangSanPham.id eq 3}">
											<div class="isNewModel"></div>
										</c:when>
										<c:otherwise>
											<div class="isNotNewModel"></div>
										</c:otherwise>
									</c:choose>
									<!-- Image and Name -->
									<div class="itemImageAndName">
										<div class="itemImage">
											<c:if test="${fn:length(p.dsHinhAnh) > 0}">
												<c:forEach var="img" items="${p.dsHinhAnh}" begin="1" end="1" varStatus="loopCount">
											        <c:if test="${loopCount.index eq 1}">
											         	<a href="#"><img src="img/dienthoai/<c:out value="${ img.hinhAnh }"/>" width="50px" height="75px"/></a>
											        </c:if>
											    </c:forEach>
											</c:if>
										</div>
										<div class="itemName"><c:out value="${p.ten}"/></div>
									</div>
									<!-- Price -->
									<div class="itemPrice"><fmt:formatNumber value="${p.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/> VND</div>
								</div>
							</c:forEach>
						</c:if>
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

