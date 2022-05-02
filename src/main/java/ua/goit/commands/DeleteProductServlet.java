package ua.goit.commands;

import ua.goit.config.DataBaseManager;
import ua.goit.config.HibernateProvider;
import ua.goit.repository.ProductRepository;
import ua.goit.repository.PromotionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() {
        DataBaseManager manager = new HibernateProvider();
        productRepository = new ProductRepository(manager);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer productId = Integer.parseInt(req.getParameter("id"));
        productRepository.remove(productId);
        req.getRequestDispatcher("/WEB-INF/html/products/deleteProduct.jsp").forward(req, resp);
    }
}
