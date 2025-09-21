<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card shadow-lg p-4" style="width: 400px;">
            <h3 class="text-center mb-4">Đăng Nhập Vào Hệ Thống</h3>

            <core:if test="${alert != null}">
                <div class="alert alert-danger">${alert}</div>
            </core:if>

            <form action="login" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Tài khoản</label>
                    <div class="input-group">
                        <span class="input-group-text"><i class="fa fa-user"></i></span>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Nhập tài khoản">
                    </div>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Mật khẩu</label>
                    <div class="input-group">
                        <span class="input-group-text"><i class="fa fa-lock"></i></span>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu">
                    </div>
                </div>

                <div class="d-flex justify-content-between align-items-center mb-3">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="remember">
                        <label class="form-check-label" for="remember">Nhớ tôi</label>
                    </div>
                    <a href="#">Quên mật khẩu?</a>
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </div>
            </form>

            <p class="text-center mt-3">
                Nếu bạn chưa có tài khoản, hãy <a href="register.jsp">Đăng ký</a>
            </p>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>