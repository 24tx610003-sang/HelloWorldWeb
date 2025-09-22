<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý danh mục</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <div>
            <h3 class="text-danger fw-bold mb-0">Quản lý danh mục</h3>
            <p class="mb-0 text-muted">Nơi bạn có thể quản lý danh mục của mình</p>
        </div>
        <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-success">
            + Thêm mới danh mục
        </a>
    </div>

    <table class="table table-bordered table-striped align-middle text-center">
        <thead class="table-primary">
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Hình ảnh</th>
            <th scope="col">Tên danh mục</th>
            <th scope="col">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cateList}" var="cate" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <c:url value="/image" var="imgUrl">
                    <c:param name="fname" value="${cate.icon}"/>
                </c:url>
                <td>
                    <c:if test="${not empty cate.icon}">
                        <img src="${pageContext.request.contextPath}/${cate.icon}" 
                             alt="Hình ảnh" class="img-thumbnail"
                             style="width: 150px; height: 150px; object-fit: cover;">
                    </c:if>
                </td>
                <td class="fw-semibold">${cate.catename}</td>
                <td>
                    <c:url value="/admin/category/edit" var="editUrl">
                        <c:param name="id" value="${cate.cateid}"/>
                    </c:url>
                    <c:url value="/admin/category/delete" var="deleteUrl">
                        <c:param name="id" value="${cate.cateid}"/>
                    </c:url>
                    <a href="${editUrl}" class="btn btn-sm btn-warning me-2">Sửa</a>
                    <a href="${deleteUrl}" class="btn btn-sm btn-danger"
                       onclick="return confirm('Bạn có chắc muốn xóa danh mục này?');">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
