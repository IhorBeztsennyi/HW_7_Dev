package ua.goit.commands;

import ua.goit.config.DataBaseManager;
import ua.goit.config.HibernateProvider;
import ua.goit.model.converter.ProductConverter;
import ua.goit.model.dto.ProductDto;
import ua.goit.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/findAllProducts")
public class FindAllProductsFormServlet extends HttpServlet {
    private ProductRepository productRepository;
    private ProductConverter productConverter;

    @Override
    public void init() {
        DataBaseManager manager = new HibernateProvider();
        productRepository = new ProductRepository(manager);
        productConverter = new ProductConverter();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDto> products = productRepository.findAll().stream()
                .map(productConverter::daoToDto)
                .collect(Collectors.toList());
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/html/products/findAllProducts.jsp").forward(req, resp);
    }
}
