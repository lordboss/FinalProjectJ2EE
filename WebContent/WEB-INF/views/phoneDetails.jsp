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
                	<c:choose>
	                	<c:when test="${! empty p}">
		                	<!-- General Info -->
		                	<div class="block02">
								<!-- Title -->
								<div class="blockTitle" id="">Thông tin về <c:out value="${p.ten}"/></div>
								<!-- Content of block -->
								<div class="contentCenter">
									<!-- Inner Left Column -->
				                	<div id="innerLeftColumn">
				                		<!-- Phone name -->
				                		<div class="phoneDetail_Name"><c:out value="${p.ten}"/></div>
				                		<!-- Phone Image -->
				                		<div class="phoneDetail_Image">
				                			<img src="img/dienthoai/<c:out value="${p.hinhAnh}"/>" />
				                		</div>
				                		<div class="phoneDetail_Price"><fmt:formatNumber value="${p.giaHienHanh}" minFractionDigits="0" maxFractionDigits="0"/> VND</div>
				                		<c:if test="${p.tinhTrangSanPham.id == 4}" >
				                			<div class="na">(Đã hết hàng)</div>
				                		</c:if>
				                		<hr/>
				                		
				                		<div class="bookProduct">Đặt mua hàng</div>
				                		<div class="compareProduct">So sánh sản phẩm</div>
				                		<div class="supportProduct">Hổ trợ khách hàng</div>
				                	</div>
		                	
				                	<!-- Inner Right Column -->
				                	<div id="innerRightColumn">
				                		<!-- Promotion -->
				                		<div class="block03">
				                			<div class="detailTitle">Thông tin khuyến mãi dành cho <c:out value="${p.ten}"/></div>
				                			<div class="contentCenter">
				                				<c:forEach var="ct" items="${p.dsChiTietKhuyenMai}" varStatus="loop">
				                					<c:set var="t" value="${ct.tinKhuyenMai}"/>
				                					<div>
				                						<ul style="font-size: 9pt;">
				                							<li>Ngày bắt đầu: <c:out value="${t.ngayBatDau.date}" /> / <c:out value="${t.ngayBatDau.month + 1}" /> / <c:out value="${t.ngayBatDau.year + 1990}" /></li>
				                							<li>Ngày kết thúc: <c:out value="${t.ngayKetThuc.date}" /> / <c:out value="${t.ngayKetThuc.month + 1}" /> / <c:out value="${t.ngayKetThuc.year + 1990}" /></li>
				                							<li>Nội dung: <c:out value="${t.noiDung}" /></li>
				                							<li>Mức giảm: <fmt:formatNumber value="${ct.mucGiam}" minFractionDigits="0" maxFractionDigits="0"/> VND </li>
				                						</ul>
				                					</div>
				                					<c:if test="${loop.count < fn:length(a.dsTinGiamGiaPhuKien)}">
				                						<hr/>
				                					</c:if>
				                				</c:forEach>
				                			</div>
				                		</div>
				                		
				                		<!-- Standard Product Packet -->
				                		<div class="block03">
				                			<div class="detailTitle">Bộ bán hàng chuẩn dành cho <c:out value="${p.ten}"/></div>
				                			<div class="contentCenter">
				                				<div style="padding-left: 10px;"><c:out value="${p.boBanHangChuan}"/></div>
				                			</div>
				                		</div>
				                		
				                		<!-- Images List -->
				                		<div class="block03">
				                			<div class="detailTitle">Hình ảnh chi tiết</div>
				                			<div class="contentCenter">
				                				Không biết làm sao cho đẹp huhu :(
				                			</div>
				                		</div>
				                		
				                		<!-- Accessory List -->
				                		<div class="block03">
				                			<div class="detailTitle">Danh sách phụ kiện có thể dùng được với <c:out value="${p.ten}"/></div>
				                			<div class="contentCenter">
				                				<c:if test="${fn:length(p.dsPhuKienTuongThich) > 0}">
						                			<div class="contentCenter01">
						                				<c:forEach var="a" items="${p.dsPhuKienTuongThich}">
						                					<div class="compatableAccessory"><a href="accessoryDetails.html?id=<c:out value="${ a.id }"/>"><c:out value="${a.ten}"/></a></div> 	
						                				</c:forEach>
						                				<div style="clear: both"></div>
						                			</div>
						                		</c:if>
				                			</div>
				                		</div>
				                		
				                	</div>
								</div>
								<div style="clear:both;"></div>
							</div>
		                	
		                	<!-- Detail Info -->
							<div class="block02">
								<!-- Title -->
								<div class="blockTitle" id="">CHI TIẾT</div>
								<!-- Content of block -->
								<div class="contentCenter">
									
									<!-- Notable features -->
									<div class="block03">
			                			<div class="detailTitle">Tính năng nổi bật</div>
			                			<div class="contentCenter">
			                				<ul style="font-size: 9pt;">
				                				<c:forEach var="t" items="${p.dsTinhNangNoiBat}">
				                					<li><c:out value="${t.tinhNang}" /></li>
				                				</c:forEach>
			                				</ul>
			                			</div>
			                		</div>
			                		
			                		<!-- Details -->
			                		<!-- Multimedia -->
			                		<div class="boxTop">
		             					<div class="boxLeft">Chức năng giải trí</div>
		             					<div class="boxRight">
		             						<div class="boxTR">
		             							<div class="cellTitle">Máy ảnh</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.camera.doPhanGiaiMayAnh > 0}">
			             									<c:out value="${p.camera.doPhanGiaiMayAnh}" /> MP, <c:out value="${p.camera.moTaMayAnh}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Quay phim</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.multiMedia.quayPhim and fn:length(p.multiMedia.quayPhim) > 0 }">
			             									<c:out value="${p.multiMedia.quayPhim}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Video Call</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.multiMedia.videoCall == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Xem phim</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.multiMedia.xemPhim and fn:length(p.multiMedia.xemPhim) > 0 }">
			             									<c:out value="${p.multiMedia.xemPhim}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Nghe nhạc</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.multiMedia.ngheNhac and fn:length(p.multiMedia.ngheNhac) > 0 }">
			             									<c:out value="${p.multiMedia.ngheNhac}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">FM Radio</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.multiMedia.FMRadio == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Xem Tivi</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.multiMedia.xemTivi == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Trò chơi</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.multiMedia.troChoi and fn:length(p.multiMedia.troChoi) > 0 }">
			             									<c:out value="${p.multiMedia.troChoi}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Loa ngoài</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.multiMedia.loaNgoai == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Ghi âm</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.multiMedia.ghiAm and fn:length(p.multiMedia.ghiAm) > 0 }">
			             									<c:out value="${p.multiMedia.ghiAm}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Ghi âm cuộc gọi</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.multiMedia.ghiAmCuocGoi == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>            						
		             					</div>
		             				</div> 
		             				
		             				<!-- Branch -->
		             				<div class="boxCenter">
		             					<div class="boxLeft">Phân khúc sản phẩm</div>
		             					<div class="boxRight">
		             						<div class="boxTR">
		             							<div class="cellTitle">Phong cách</div>
		             							<div class="cellContent">
		             								<c:out value="${p.phongCach.ten}" />
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Kiểu dáng</div>
		             							<div class="cellContent">
		             								<c:out value="${p.kieuDang.ten}" />
		             							</div>
		             						</div>
		             					</div>
		             				</div>
		             				
		             				<!-- Melody -->
		             				<div class="boxCenter">
		             					<div class="boxLeft">Nhạc chuông</div>
		             					<div class="boxRight">
		             						<div class="boxTR">
		             							<div class="cellTitle">Loại</div>
		             							<div class="cellContent">
		             								<c:out value="${p.nhacChuong.nhacChuong}" /> âm sắc <c:out value="${p.nhacChuong.dinhDangNhacChuong}" /> 
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Tải nhạc</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.nhacChuong.taiNhacChuong == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Báo rung</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.nhacChuong.baoRung == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             					</div>
		             				</div>
		             				
		             				<!-- Storage -->
		             				<div class="boxCenter">
		             					<div class="boxLeft">Bộ nhớ, danh bạ, tin nhắn</div>
		             					<div class="boxRight">
		             						<div class="boxTR">
		             							<div class="cellTitle">Danh bạ</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.luuTru.danhBa and fn:length(p.luuTru.danhBa) > 0 }">
			             									<c:out value="${p.luuTru.danhBa}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Tin nhắn</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.luuTru.tinNhan and fn:length(p.luuTru.tinNhan) > 0 }">
			             									<c:out value="${p.luuTru.tinNhan}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Bộ nhớ trong</div>
		             							<div class="cellContent">
	             									<c:choose>
			             								<c:when test="${! empty p.luuTru.boNhoTrong and fn:length(p.luuTru.boNhoTrong) > 0 }">
			             									<c:out value="${p.luuTru.boNhoTrong}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Thẻ nhớ ngoài</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.luuTru.theNho and fn:length(p.luuTru.theNho) > 0 }">
			             									<c:out value="${p.luuTru.theNho}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             					</div>
		             				</div>
		             				
		             				<!-- Connectivity -->
		             				<div class="boxCenter">
		             					<div class="boxLeft">Kết nối dữ liệu, phần mềm</div>
		             					<div class="boxRight">
		             						<div class="boxTR">
		             							<div class="cellTitle">GPRS</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.ketNoi.GPRS == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Trình duyệt</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.ketNoi.trinhDuyet == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">EDGE</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.ketNoi.EDGE == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">3G</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.ketNoi.hoTro3G and fn:length(p.ketNoi.hoTro3G) > 0 }">
			             									<c:out value="${p.ketNoi.hoTro3G}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">UMTS</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.ketNoi.UMTS == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">WCDMA</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.ketNoi.WCDMA == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Wifi</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.ketNoi.wifi and fn:length(p.ketNoi.wifi) > 0 }">
			             									<c:out value="${p.ketNoi.wifi}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">GPS</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.ketNoi.GPS and fn:length(p.ketNoi.GPS) > 0 }">
			             									<c:out value="${p.ketNoi.GPS}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Hồng ngoại</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.ketNoi.hongNgoai == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Bluetooth</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.ketNoi.bluetooth == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">USB</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.ketNoi.USB == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Java</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.javaApp == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Ứng dụng văn phòng</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.office == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Băng tần</div>
		             							<div class="cellContent">
		             								<c:out value="${p.loaiMang.ten}" />
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Hổ trợ 2 SIM</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.ketNoi.haiSim == true}">Có</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             					</div>
		             				</div>
									
									<!-- Display -->
									<div class="boxCenter">
		             					<div class="boxLeft">Hiển thị</div>
		             					<div class="boxRight">
		             						<div class="boxTR">
		             							<div class="cellTitle">Loại màn hình</div>
		             							<div class="cellContent">
		             								<c:out value="${p.manHinh.loaiManHinh}" />
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Kích thước màn hình</div>
		             							<div class="cellContent">
		             								<c:out value="${p.manHinh.chieuRongManHinh}" /> x <c:out value="${p.manHinh.chieuCaoManHinh}" /> pixels
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Cảm ứng</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${p.manHinh.camUng == true}">
			             									Có
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             					</div>
		             				</div>
		             				
		             				<!-- Pin -->
		             				<div class="boxCenter">
		             					<div class="boxLeft">PIN</div>
		             					<div class="boxRight">
		             						<div class="boxTR">
		             							<div class="cellTitle">Loại PIN</div>
		             							<div class="cellContent">
		             								<c:choose>
			             								<c:when test="${! empty p.pin.loaiPin and fn:length(p.pin.loaiPin) > 0 }">
			             									<c:out value="${p.pin.loaiPin}" />
			             								</c:when> 
			             								<c:otherwise>Không</c:otherwise>
		             								</c:choose>
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Dung lượng PIN</div>
		             							<div class="cellContent">
		             								<c:out value="${p.pin.dungLuong}" /> mAh 
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Thời gian đàm thoại</div>
		             							<div class="cellContent">
		             								<c:out value="${p.pin.thoiGianDamThoai}" /> (giờ)
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Thời gian chờ</div>
		             							<div class="cellContent">
		             								<c:out value="${p.pin.thoiGianCho}" /> (giờ)
		             							</div>
		             						</div>
		             					</div>
		             				</div>
		             				
		             				<!-- Size, weight,.. -->
		             				<div class="boxCenter">
		             					<div class="boxLeft">Đặc tính khác</div>
		             					<div class="boxRight">
		             						<div class="boxTR">
		             							<div class="cellTitle">Kích cỡ máy</div>
		             							<div class="cellContent">
		             								<c:out value="${p.kichCo.chieuDaiDienThoai}" /> x <c:out value="${p.kichCo.chieuRongDienThoai}" /> x <c:out value="${p.kichCo.chieuCaoDienThoai}" /> mm
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Trọng lượng</div>
		             							<div class="cellContent">
		             								<c:out value="${p.kichCo.trongLuong}" /> (g)
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Hệ điều hành</div>
		             							<div class="cellContent">
		             								<c:out value="${p.heDieuHanh.ten}" /> 
		             							</div>
		             						</div>
		             						<div class="boxTR">
		             							<div class="cellTitle">Ngôn ngữ</div>
		             							<div class="cellContent">
		             								<c:out value="${p.ngonNgu}" />
		             							</div>
		             						</div>
		             					</div>
		             				</div>
								</div>
								
								<div style="clear:both;"></div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="block02">
								<div class="blockTitle" id="">Thông tin chi tiết</div>
								<div class="contentCenter">
									<div class="notFound">Không tìm thấy sản phẩm trong dữ liệu</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
                </div> <!-- end midlle column -->
                
                <!-- Include Right Column -->
                <%@ include file="/WEB-INF/views/include/rightColumn.jsp" %>
                
            </div> <!-- end content -->
            
            <!-- Footer -->
            <%@include file="/WEB-INF/views/include/footer.jsp" %>
        </div>
    </body>
</html>

