<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="core" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<core:choose>
		<core:when test="${sessionScope.account == null}">
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li><a href="${pageContext.request.contextPath }/login">Đăng
							nhập</a> | <a href="${pageContext.request.contextPath }/register">Đăng
							ký</a></li>
					<li><i class="search fa fa-search search-button"></i></li>
				</ul>
			</div>
		</core:when>
		<core:otherwise>
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li><a
						href="${pageContext.request.contextPath
	}/member/myaccount">${sessionScope.account.fullName}</a>
						| <a href="${pageContext.request.contextPath }/logout">Đăng
							Xuất</a></li>
					<li><i class="search fa fa-search search-button"></i></li>
				</ul>
			</div>
		</core:otherwise>
	</core:choose>
</body>
</html>