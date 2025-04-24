<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Khai Báo Thông Tin Sinh Viên</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script>
        function validateForm() {
            let studentSoCMND = document.getElementById("student.soCMND").value;
            let hoTen = document.getElementById("student.hoTen").value;
            let maTruong = document.getElementById("graduation.maTruong").value;
            let maNganh = document.getElementById("graduation.maNganh").value;
            let ngayTN = document.getElementById("graduation.ngayTN").value;

            if (!studentSoCMND || !hoTen || !maTruong || !maNganh) {
                alert("Vui lòng nhập đầy đủ các trường bắt buộc: Số CMND, Họ Tên, Mã Trường, Mã Ngành");
                return false;
            }

            let today = new Date();
            let inputDate = new Date(ngayTN);
            if (isNaN(inputDate) || inputDate > today) {
                alert("Ngày tốt nghiệp không hợp lệ");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Khai Báo Thông Tin Sinh Viên</h1>
        <!-- Debug dữ liệu -->
        <c:if test="${empty schools}">
            <p>Không có trường nào được tải.</p>
        </c:if>
        <c:if test="${empty majors}">
            <p>Không có ngành nào được tải.</p>
        </c:if>

        <form:form action="${pageContext.request.contextPath}/student/save" method="post" onsubmit="return validateForm()">
            <h2>Thông Tin Sinh Viên</h2>
            <div class="form-group">
                <label for="student.soCMND">Số CMND <span class="required">*</span></label>
                <input name="student.soCMND" id="student.soCMND" required="true"/>
                <c:if test="${not empty studentError}">
                    <span class="error">${studentError}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="student.hoTen">Họ Tên <span class="required">*</span></label>
                <input name="student.hoTen" id="student.hoTen" required="true"/>
            </div>
            <div class="form-group">
                <label for="student.email">Email</label>
                <input name="student.email" id="student.email"/>
            </div>
            <div class="form-group">
                <label for="student.soDT">Số Điện Thoại</label>
                <input name="student.soDT" id="student.soDT"/>
            </div>
            <div class="form-group">
                <label for="student.diaChi">Địa Chỉ</label>
                <input name="student.diaChi" id="student.diaChi"/>
            </div>

            <h2>Thông Tin Tốt Nghiệp</h2>
            <div class="form-group">
                <label for="graduation.soCMND">Số CMND <span class="required">*</span></label>
                <input name="graduation.soCMND" id="graduation.soCMND" required="true"/>
                <c:if test="${not empty graduationError}">
                    <span class="error">${graduationError}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="graduation.maTruong">Trường <span class="required">*</span></label>
                <select name="graduation.maTruong" id="graduation.maTruong" required="true">
                    <option value="">-- Chọn Trường --</option>
                    <c:forEach var="school" items="${schools}">
                        <option value="${school.maTruong}">${school.tenTruong}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="graduation.maNganh">Ngành <span class="required">*</span></label>
                <select name="graduation.maNganh" id="graduation.maNganh" required="true">
                    <option value="">-- Chọn Ngành --</option>
                    <c:forEach var="major" items="${majors}">
                        <option value="${major.maNganh}">${major.tenNganh}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="graduation.heTN">Hệ Tốt Nghiệp</label>
                <input name="graduation.heTN" id="graduation.heTN"/>
            </div>
            <div class="form-group">
                <label for="graduation.ngayTN">Ngày Tốt Nghiệp <span class="required">*</span></label>
                <input name="graduation.ngayTN" id="graduation.ngayTN" type="date" required="true"/>
                <c:if test="${not empty dateError}">
                    <span class="error">${dateError}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="graduation.loaiTN">Loại Tốt Nghiệp</label>
                <input name="graduation.loaiTN" id="graduation.loaiTN"/>
            </div>

            <div class="form-group">
                <button type="submit" class="button">Lưu</button>
                <a href="${pageContext.request.contextPath}/" class="button cancel">Hủy</a>
            </div>
        </form:form>
    </div>
</body>
</html>