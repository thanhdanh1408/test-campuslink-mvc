<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm Kiếm Thông Tin Sinh Viên</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Tìm Kiếm Thông Tin Sinh Viên</h1>
        <form action="${pageContext.request.contextPath}/search/student" method="post">
            <div class="form-group">
                <label for="keyword">Từ Khóa (Số CMND hoặc Họ Tên)</label>
                <input type="text" id="keyword" name="keyword" required>
            </div>
            <div class="form-group">
                <button type="submit" class="button">Tìm Kiếm</button>
                <a href="${pageContext.request.contextPath}/" class="button cancel">Hủy</a>
            </div>
        </form>
    </div>
</body>
</html>