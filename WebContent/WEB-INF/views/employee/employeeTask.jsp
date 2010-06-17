<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- @Unused -->
<!-- Function for employees -->
<c:if test="${(sessionScope.userType eq 'NhanVien') or (sessionScope.userType eq 'NhanVienQuanLy')}">
	<div class="employeeTaskBox">
	
		<input type="button" value="Cập nhật"/>
		 
		<c:set var="v" value="Hiển thị"/>
		<c:if test="${p.hienThi eq true}">
			<c:set var="v" value="Ẩn"/>
		</c:if>
		<input id="<c:out value="v${p.id}"/>" type="button" value="${v}" onclick="setVisibility('setVisibility.html?pid=${p.id}', ${p.id})"/>
	</div>
</c:if>