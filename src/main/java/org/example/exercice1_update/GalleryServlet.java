package org.example.exercice1_update;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "gallery", value = "/gallery")
public class GalleryServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "image";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("/") + UPLOAD_DIR;

        File directory = new File(uploadPath);
        String[] imageFiles = directory.list((dir, name) -> name.toLowerCase().endsWith(".jpg") ||
                name.toLowerCase().endsWith(".png") ||
                name.toLowerCase().endsWith(".gif"));

        List<String> imagePaths = new ArrayList<>();
        if (imageFiles != null) {
            for (String imageFile : imageFiles) {
                imagePaths.add(req.getContextPath() + "/" + UPLOAD_DIR + "/" + imageFile);
            }
        }

        req.setAttribute("imagePaths", imagePaths);
        req.getRequestDispatcher("gallery.jsp").forward(req, resp);
    }
}
