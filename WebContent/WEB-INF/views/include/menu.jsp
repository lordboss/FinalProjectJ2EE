<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>

<!-- Menu -->
<c:choose>
	<c:when test="${empty sessionScope.userType}">
		<%@ include file="/WEB-INF/views/include/defaultMenu.jsp" %>
	</c:when>
	<c:when test="${sessionScope.userType eq 'KhachHang'}">
		<%@ include file="/WEB-INF/views/include/userMenu.jsp" %>
	</c:when>
	<c:when test="${sessionScope.userType eq 'NhanVien'}">
		<%@ include file="/WEB-INF/views/include/employeeMenu.jsp" %>
	</c:when>
	<c:when test="${sessionScope.userType eq 'NhanVienQuanLy'}">
		<%@ include file="/WEB-INF/views/include/managerMenu.jsp" %>
	</c:when>
	<c:when test="${sessionScope.userType eq 'NhanVienQuanTri'}">
		<%@ include file="/WEB-INF/views/include/adminMenu.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/views/include/defaultMenu.jsp" %>
	</c:otherwise>
</c:choose>