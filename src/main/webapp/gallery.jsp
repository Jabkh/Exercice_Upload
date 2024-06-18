<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Image Gallery</title>
    <%@ include file="bootstrap-includes.html" %>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Image Gallery</h2>
    <div class="row">
        <c:forEach var="imagePath" items="${imagePaths}">
            <div class="col-md-3 mb-4">
                <div class="card">
                    <img src="<%= request.getContextPath() %>/image/${imagePath}" class="card-img-top" alt="Image">
                    <div class="card-body">
                        <p class="card-text">Uploaded Image</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="text-center mt-4">
        <a href="upload" class="btn btn-primary">Upload Another Image</a>
    </div>
</div>
</body>
</html>
