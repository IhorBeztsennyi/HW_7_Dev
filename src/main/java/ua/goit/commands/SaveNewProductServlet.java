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

@WebServlet(urlPatterns = "/saveNewProduct")
public class SaveNewProductServlet extends HttpServlet {
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
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        Integer promotionId = Integer.parseInt(req.getParameter("promotionId"));
        PromotionDao promotionDao = promotionRepository.findById(promotionId);
        PromotionDto promotionDto = promotionConverter.daoToDto(promotionDao);

        ProductDao product = productConverter.dtoToDao(new ProductDto(name, price, promotionDto));
        productRepository.save(product);
        req.getRequestDispatcher("/WEB-INF/html/products/saveNewProduct.jsp").forward(req, resp);
    }
}
