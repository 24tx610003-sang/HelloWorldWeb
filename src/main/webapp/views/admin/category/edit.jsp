<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa danh mục</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-warning text-white">
            <h3 class="mb-0">Chỉnh sửa danh mục</h3>
            <p class="mb-0">Cập nhật thông tin danh mục bên dưới</p>
        </div>
        <div class="card-body">
            <c:url value="/admin/category/edit" var="editUrl" />
            <form action="${editUrl}" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${category.cateid}" />

                <div class="mb-3">
                    <label for="name" class="form-label">Tên danh mục</label>
                    <input type="text" class="form-control" id="name" name="name"
                           value="${category.catename}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Ảnh hiện tại</label><br>
                    <c:if test="${not empty category.icon}">
                        <img src="${pageContext.request.contextPath}/${category.icon}"
                             alt="Hình ảnh" class="img-thumbnail mb-2"
                             style="width: 150px; height: 150px; object-fit: cover;">
                    </c:if>
                </div>

                <div class="mb-3">
                    <label for="icon" class="form-label">Chọn ảnh mới</label>
                    <input type="file" class="form-control" id="icon" name="icon" accept="image/*">
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-success">Lưu thay đổi</button>
                    <button type="reset" class="btn btn-secondary">Hủy</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
