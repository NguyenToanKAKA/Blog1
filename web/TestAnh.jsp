<%-- 
    Document   : TestAnh
    Created on : May 24, 2024, 2:30:14 AM
    Author     : Admin
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload File</title>
    <link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Upload File</h2>
    <form action="upload" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="file" class="form-label">Ch?n ?nh ?? t?i lên:</label>
            <input type="file" class="form-control" id="file" name="file">
        </div>
        <button type="submit" class="btn btn-primary">T?i lên</button>
    </form>
</div>
<script src="https://unpkg.com/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
