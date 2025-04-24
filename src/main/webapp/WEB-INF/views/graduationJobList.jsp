<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết Quả Tìm Kiếm Tốt Nghiệp và Việc Làm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Kết Quả Tìm Kiếm Tốt Nghiệp và Việc Làm</h1>
        <h2>Thông Tin Tốt Nghiệp</h2>
        <c:if test="${empty graduations}">
            <p>Không tìm thấy thông tin tốt nghiệp.</p>
        </c:if>
        <c:if test="${not empty graduations}">
            <table>
                <thead>
                    <tr>
                        <th>Số CMND</th>
                        <th>Mã Trường</th>
                        <th>Mã Ngành</th>
                        <th>Hệ Tốt Nghiệp</th>
                        <th>Ngày Tốt Nghiệp</th>
                        <th>Loại Tốt Nghiệp</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="graduation" items="${graduations}">
                        <tr>
                            <td>${graduation.soCMND}</td>
                            <td>${graduation.maTruong}</td>
                            <td>${graduation.maNganh}</td>
                            <td>${graduation.heTN}</td>
                            <td>${graduation.ngayTN}</td>
                            <td>${graduation.loaiTN}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <h2>Thông Tin Việc Làm</h2>
        <c:if test="${empty jobs}">
            <p>Không tìm thấy thông tin việc làm.</p>
        </c:if>
        <c:if test="${not empty jobs}">
            <table>
                <thead>
                    <tr>
                        <th>Số CMND</th>
                        <th>Ngày Vào Công Ty</th>
                        <th>Mã Ngành</th>
                        <th>Tên Công Ty</th>
                        <th>Thời Gian Làm Việc (Tháng)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="job" items="${jobs}">
                        <tr>
                            <td>${job.soCMND}</td>
                            <td>${job.ngayVaoCongTy}</td>
                            <td>${job.maNganh}</td>
                            <td>${job.tenCongTy}</td>
                            <td>${job.thoiGianLamViec}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <div class="form-group">
            <a href="${pageContext.request.contextPath}/search/graduation-job" class="button">Tìm Lại</a>
            <a href="${pageContext.request.contextPath}/" class="button">Quay Về Trang Chủ</a>
        </div>
    </div>
</body>
</html>