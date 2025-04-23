<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/themSinhVien" method="post">
    <label for="soCMND">Số CMND:</label>
    <input type="text" id="soCMND" name="soCMND" required />

    <label for="hoTen">Họ tên:</label>
    <input type="text" id="hoTen" name="hoTen" />

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" />

    <label for="soDT">Số điện thoại:</label>
    <input type="text" id="soDT" name="soDT" />

    <label for="diaChi">Địa chỉ:</label>
    <input type="text" id="diaChi" name="diaChi" />

    <label for="ngayTN">Ngày tốt nghiệp:</label>
    <input type="date" id="ngayTN" name="ngayTN" required />

    <label for="maTruong">Trường:</label>
    <select id="maTruong" name="maTruong" required>
        <option th:each="truong : ${truongs}" th:value="${truong.id}" th:text="${truong.tenTruong}"></option>
    </select>

    <label for="maNganh">Ngành:</label>
    <select id="maNganh" name="maNganh" required>
        <option th:each="nganh : ${nganhs}" th:value="${nganh.id}" th:text="${nganh.tenNganh}"></option>
    </select>

    <button type="submit">Thêm sinh viên</button>
</form>
	
</body>
</html>