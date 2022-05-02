package ua.goit.commands;

import ua.goit.config.DataBaseManager;
import ua.goit.config.HibernateProvider;
import ua.goit.model.Store;
import ua.goit.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cartCost")
public class CartCostServlet extends HttpServlet {
    private ProductRepository productRepository;
    private Store store;

    @Override
    public void init() {
        DataBaseManager manager = new HibernateProvider();
        productRepository = new ProductRepository(manager);
        store = new Store(productRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productSet = req.getParameter("productSet");
        String sum = store.getFinalPrice(productSet).toString();
        req.setAttribute("sum", sum);
        req.getRequestDispatcher("/WEB-INF/html/cartCost.jsp").forward(req, resp);
    }
}
