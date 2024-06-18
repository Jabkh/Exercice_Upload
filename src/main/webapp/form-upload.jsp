<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload Image</title>
    <%@ include file="bootstrap-includes.html" %>
</head>
<body>
<div class="container">
    <h2>Upload Image</h2>
    <form action="upload" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="image">Choose an image:</label>
            <input type="file" id="image" name="image" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Upload</button>
    </form>
    <hr>
    <a href="gallery" class="btn btn-secondary">View Gallery</a>
</div>
</body>
</html>
