<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><title>Đăng ký</title></head>
<body>
    <h2>ĐĂNG KÝ TÀI KHOẢN</h2>
    <c:if test="${not empty alertError}"><p style="color:red">${alertError}</p></c:if>
    <form action="<c:url value='/register'/>" method="post">
        Tài khoản: <input type="text" name="username" required><br><br>
        Mật khẩu: <input type="password" name="password" required><br><br>
        Họ tên: <input type="text" name="fullName" required><br><br>
        <input type="submit" value="Đăng ký"><br><br>
        <a href="<c:url value='/login'/>">Đã có tài khoản? Đăng nhập</a>
    </form>
</body>
</html>