package org.example.exercice1_update;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "upload", value = "/upload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class UploadServlet extends HttpServlet {

    private List<String> imagePaths = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("imagePaths", imagePaths);
        req.getRequestDispatcher("form-upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("/") + "image";

        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }

        Part image = req.getPart("image");
        String fileName = image.getSubmittedFileName();

        String filePath = uploadPath + File.separator + fileName;
        image.write(filePath);

        imagePaths.add(fileName);

        req.setAttribute("message", "Upload Successful!");
        req.setAttribute("imagePath", req.getContextPath() + "/image/" + fileName);
        req.getRequestDispatcher("success.jsp").forward(req, resp);
    }
}
