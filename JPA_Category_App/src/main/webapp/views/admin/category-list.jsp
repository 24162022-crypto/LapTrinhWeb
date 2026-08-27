<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><title>Danh sách Category</title></head>
<body>
    <h2>QUẢN LÝ DANH MỤC</h2>
    <a href="<c:url value='/admin/category/add'/>">Thêm Mới</a><br><br>
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Tên Danh Mục</th>
            <th>Trạng Thái</th>
            <th>Thao Tác</th>
        </tr>
        <c:forEach items="${listCategory}" var="cate" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${cate.categoryName}</td>
                <td>${cate.status == 1 ? 'Hoạt động' : 'Khóa'}</td>
                <td><a href="<c:url value='/admin/category/delete?id=${cate.categoryId}'/>">Xóa</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>