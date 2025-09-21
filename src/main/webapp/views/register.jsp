<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            border-radius: 15px;
        }
        .form-control {
            border-radius: 10px;
        }
        .btn-primary {
            border-radius: 10px;
        }
    </style>
</head>
<body>

<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
    <div class="card shadow-lg p-4" style="width: 400px;">
        <h2 class="text-center mb-4">Tạo tài khoản mới</h2>

        <core:if test="${alert != null}">
            <div class="alert alert-danger text-center">
                ${alert}
            </div>
        </core:if>

        <form action="register" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="fa fa-user"></i></span>
                <input type="text" class="form-control" name="username" placeholder="Tên đăng nhập" required>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text"><i class="fa fa-id-card"></i></span>
                <input type="text" class="form-control" name="fullname" placeholder="Họ tên" required>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                <input type="email" class="form-control" name="email" placeholder="Nhập Email" required>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text"><i class="fa fa-phone"></i></span>
                <input type="text" class="form-control" name="phone" placeholder="Số điện thoại">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" name="confirmPassword" placeholder="Nhập lại mật khẩu" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Tạo tài khoản</button>
        </form>

        <p class="text-center mt-3">
            Nếu bạn đã có tài khoản? <a href="${pageContext.request.contextPath }/login">Đăng nhập</a>
        </p>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
