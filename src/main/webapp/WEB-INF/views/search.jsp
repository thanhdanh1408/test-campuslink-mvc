<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm Kiếm Sinh Viên</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Tìm Kiếm Sinh Viên</h1>
        <form action="${pageContext.request.contextPath}/search" method="post">
            <label>Từ khóa (Số CMND hoặc Họ Tên):</label>
            <input type="text" name="keyword">
            <button type="submit">Tìm</button>
        </form>
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
        <c:if test="${not empty sinhViens}">
            <h2>Kết Quả Tìm Kiếm</h2>
            <table>
                <tr>
                    <th>Số CMND</th>
                    <th>Họ Tên</th>
                    <th>Email</th>
                    <th>Số ĐT</th>
                    <th>Địa Chỉ</th>
                </tr>
                <c:forEach var="sv" items="${sinhViens}">
                    <tr>
                        <td>${sv.soCmnd}</td>
                        <td>${sv.hoTen}</td>
                        <td>${sv.email}</td>
                        <td>${sv.soDt}</td>
                        <td>${sv.diaChi}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <a href="${pageContext.request.contextPath}/input">Nhập thông tin</a> |
        <a href="${pageContext.request.contextPath}/search-employment">Tìm kiếm việc làm</a>
    </div>
</body>
</html>