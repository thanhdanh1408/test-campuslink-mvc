<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhập Thông Tin Sinh Viên</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Nhập Thông Tin Sinh Viên và Tốt Nghiệp</h1>
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
        <c:if test="${not empty message}">
            <p class="success">${message}</p>
        </c:if>
        <form action="${pageContext.request.contextPath}/input" method="post">
            <h2>Thông Tin Sinh Viên</h2>
            <label>Số CMND (*):</label>
            <input type="text" name="soCmnd" required><br>
            <label>Họ Tên:</label>
            <input type="text" name="hoTen"><br>
            <label>Email:</label>
            <input type="email" name="email"><br>
            <label>Số ĐT:</label>
            <input type="text" name="soDt"><br>
            <label>Địa Chỉ:</label>
            <input type="text" name="diaChi"><br>

            <h2>Thông Tin Tốt Nghiệp</h2>
            <label>Trường (*):</label>
            <select name="maTruong" required>
                <option value="">Chọn trường</option>
                <c:forEach var="truong" items="${truongs}">
                    <option value="${truong.maTruong}">${truong.tenTruong}</option>
                </c:forEach>
            </select><br>
            <label>Ngành (*):</label>
            <select name="maNganh" required>
                <option value="">Chọn ngành</option>
                <c:forEach var="nganh" items="${nganhs}">
                    <option value="${nganh.maNganh}">${nganh.tenNganh}</option>
                </c:forEach>
            </select><br>
            <label>Ngày Tốt Nghiệp (yyyy-MM-dd) (*):</label>
            <input type="text" name="ngayTnStr" required><br>
            <button type="submit">Lưu</button>
        </form>
        <a href="${pageContext.request.contextPath}/search">Tìm kiếm sinh viên</a> |
        <a href="${pageContext.request.contextPath}/search-employment">Tìm kiếm việc làm</a>
    </div>
</body>
</html>