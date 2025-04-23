<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm Kiếm Thông Tin Tốt Nghiệp và Việc Làm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Tìm Kiếm Thông Tin Tốt Nghiệp và Việc Làm</h1>
        <form action="${pageContext.request.contextPath}/search-employment" method="post">
            <label>Từ khóa (Số CMND hoặc Họ Tên):</label>
            <input type="text" name="keyword">
            <button type="submit">Tìm</button>
        </form>
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
        <c:if test="${not empty results}">
            <h2>Kết Quả Tìm Kiếm</h2>
            <table>
                <tr>
                    <th>Số CMND</th>
                    <th>Họ Tên</th>
                    <th>Mã Ngành (TN)</th>
                    <th>Mã Trường (TN)</th>
                    <th>Mã Ngành (VL)</th>
                    <th>Tên Công Ty</th>
                    <th>Thời Gian Làm Việc</th>
                </tr>
                <c:forEach var="row" items="${results}">
                    <tr>
                        <td>${row[0]}</td>
                        <td>${row[1]}</td>
                        <td>${row[2]}</td>
                        <td>${row[3]}</td>
                        <td>${row[4]}</td>
                        <td>${row[5]}</td>
                        <td>${row[6]}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <a href="${pageContext.request.contextPath}/input">Nhập thông tin</a> |
        <a href="${pageContext.request.contextPath}/search">Tìm kiếm sinh viên</a>
    </div>
</body>
</html>