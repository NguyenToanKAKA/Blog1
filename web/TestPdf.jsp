<%-- 
    Document   : TestPdf
    Created on : May 24, 2024, 1:27:19 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Tạo PDF từ JSP</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script>
        function savePDF() {
            // Lấy nội dung của thẻ <p id="test">
            var textContent = document.getElementById("test").innerText;

            // Tạo một đối tượng jsPDF
            var { jsPDF } = window.jspdf;
            var pdf = new jsPDF();

               // Thiết lập màu sắc cho văn bản (đỏ)
            pdf.setTextColor(255, 0, 0);
        // Thêm nội dung vào tài liệu PDF
            pdf.text(textContent, 10, 10);

            // Lưu PDF vào máy người dùng
            pdf.save("output.pdf");
        }
    </script>
</head>
<body>
    <p id="test">fdsafdsafsadffdsfdasf.</p>
    <button onclick="savePDF()">Lưu vào PDF</button>
</body>
</html>
