<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h3 class="text-danger fw-bold mb-3">Thêm danh mục mới</h3>
    <p class="mb-4">Vui lòng nhập thông tin danh mục bên dưới</p>

    <form action="add" method="post" enctype="multipart/form-data" class="border p-4 rounded shadow-sm bg-light">
        <div class="mb-3">
            <label for="name" class="form-label">Tên danh mục</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Nhập tên danh mục" required>
        </div>

        <div class="mb-3">
            <label for="icon" class="form-label">Ảnh đại diện</label>
            <input type="file" class="form-control" id="icon" name="icon" accept="image/*" required>
        </div>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success">Thêm</button>
            <button type="reset" class="btn btn-secondary">Hủy</button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
