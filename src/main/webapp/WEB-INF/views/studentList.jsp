<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết Quả Tìm Kiếm Sinh Viên</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Kết Quả Tìm Kiếm Sinh Viên</h1>
        <c:if test="${empty students}">
            <p>Không tìm thấy sinh viên nào.</p>
        </c:if>
        <c:if test="${not empty students}">
            <table>
                <thead>
                    <tr>
                        <th>Số CMND</th>
                        <th>Họ Tên</th>
                        <th>Email</th>
                        <th>Số Điện Thoại</th>
                        <th>Địa Chỉ</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.soCMND}</td>
                            <td>${student.hoTen}</td>
                            <td>${student.email}</td>
                            <td>${student.soDT}</td>
                            <td>${student.diaChi}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <div class="form-group">
            <a href="${pageContext.request.contextPath}/search/student" class="button">Tìm Lại</a>
            <a href="${pageContext.request.contextPath}/" class="button">Quay Về Trang Chủ</a>
        </div>
    </div>
</body>
</html>