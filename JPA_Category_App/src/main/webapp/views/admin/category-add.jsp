<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><title>Thêm Category</title></head>
<body>
    <h2>THÊM MỚI CATEGORY</h2>
    <form action="<c:url value='/admin/category/insert'/>" method="post" enctype="multipart/form-data">
        Tên danh mục: <input type="text" name="categoryName" required><br><br>
        Link URL ảnh: <input type="text" name="imageUrl"><br><br>
        Upload file ảnh: <input type="file" name="imageFile"><br><br>
        Trạng thái:
        <input type="radio" name="status" value="1" checked> Hoạt động
        <input type="radio" name="status" value="0"> Khóa<br><br>
        <input type="submit" value="Lưu Dữ Liệu">
    </form>
</body>
</html>