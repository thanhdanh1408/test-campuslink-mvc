<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ - Quản Lý Thống Kê Việc Làm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Quản Lý Thống Kê Việc Làm Sinh Viên</h1>
        <div class="menu">
            <a href="${pageContext.request.contextPath}/student/form" class="button">Khai Báo Thông Tin Sinh Viên</a>
            <a href="${pageContext.request.contextPath}/search/student" class="button">Tìm Kiếm Thông Tin Sinh Viên</a>
            <a href="${pageContext.request.contextPath}/search/graduation-job" class="button">Tìm Kiếm Thông Tin Tốt Nghiệp và Việc Làm</a>
        </div>
    </div>
</body>
</html>