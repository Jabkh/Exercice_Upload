<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload Successful</title>
    <%@ include file="bootstrap-includes.html" %>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Upload Successful</h2>
    <p class="text-center">${message}</p>
    <div class="card mx-auto" style="width: 18rem;">
        <img src="${imagePath}" class="card-img-top" alt="Uploaded Image">
        <div class="card-body text-center">
            <h5 class="card-title">Uploaded Image</h5>
            <a href="upload" class="btn btn-primary">Upload Another Image</a>
            <a href="gallery" class="btn btn-secondary">View Gallery</a>
        </div>
    </div>
</div>
</body>
</html>
