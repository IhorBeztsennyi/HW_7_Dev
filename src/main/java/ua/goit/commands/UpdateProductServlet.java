package ua.goit.commands;

import ua.goit.config.DataBaseManager;
import ua.goit.config.HibernateProvider;
import ua.goit.model.converter.ProductConverter;
import ua.goit.model.converter.PromotionConverter;
import ua.goit.model.dao.ProductDao;
import ua.goit.model.dao.PromotionDao;
import ua.goit.model.dto.ProductDto;
import ua.goit.model.dto.PromotionDto;
import ua.goit.repository.ProductRepository;
import ua.goit.repository.PromotionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    private ProductRepository productRepository;
    private PromotionRepository promotionRepository;
    private ProductConverter productConverter;
    private PromotionConverter promotionConverter;

    @Override
    public void init() {
        DataBaseManager manager = new HibernateProvider();
        productRepository = new ProductRepository(manager);
        promotionRepository = new PromotionRepository(manager);
        productConverter = new ProductConverter();
        promotionConverter =new PromotionConverter();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        Integer promotionId = Integer.parseInt(req.getParameter("promotionId"));
        PromotionDto promotionDto = promotionConverter.daoToDto(promotionRepository.findById(promotionId));
        ProductDao product = productConverter.dtoToDao(new ProductDto(id, name, price, promotionDto));
        productRepository.update(product);
        req.getRequestDispatcher("/WEB-INF/html/products/updateProduct.jsp").forward(req, resp);
    }
}
