<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm Kiếm Tốt Nghiệp và Việc Làm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Tìm Kiếm Thông Tin Tốt Nghiệp và Việc Làm</h1>
        <form action="${pageContext.request.contextPath}/search/graduation-job" method="post">
            <div class="form-group">
                <label for="soCMND">Số CMND</label>
                <input type="number" id="soCMND" name="soCMND" required>
            </div>
            <div class="form-group">
                <button type="submit" class="button">Tìm Kiếm</button>
                <a href="${pageContext.request.contextPath}/" class="button cancel">Hủy</a>
            </div>
        </form>
    </div>
</body>
</html>