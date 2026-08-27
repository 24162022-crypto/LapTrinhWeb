<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><title>Đăng nhập</title></head>
<body>
    <h2>ĐĂNG NHẬP HỆ THỐNG</h2>
    <c:if test="${not empty alertError}"><p style="color:red">${alertError}</p></c:if>
    <c:if test="${not empty alertSuccess}"><p style="color:green">${alertSuccess}</p></c:if>
    <form action="<c:url value='/login'/>" method="post">
        Tài khoản: <input type="text" name="username" required><br><br>
        Mật khẩu: <input type="password" name="password" required><br><br>
        <input type="submit" value="Đăng nhập"><br><br>
        <a href="<c:url value='/register'/>">Đăng ký mới</a>
    </form>
</body>
</html>