package ua.goit.commands;

import ua.goit.config.DataBaseManager;
import ua.goit.config.HibernateProvider;
import ua.goit.model.converter.ProductConverter;
import ua.goit.model.converter.PromotionConverter;
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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/findAllPromotions")
public class FindAllPromotionsServlet extends HttpServlet {
    private PromotionRepository promotionRepository;
    private PromotionConverter promotionConverter;


    @Override
    public void init() {
        DataBaseManager manager = new HibernateProvider();
        promotionRepository = new PromotionRepository(manager);
        promotionConverter = new PromotionConverter();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PromotionDto> promotions = promotionRepository.findAll().stream()
                .map(promotionConverter::daoToDto)
                .collect(Collectors.toList());
        req.setAttribute("promotions", promotions);
        req.getRequestDispatcher("/WEB-INF/html/promotions/findAllPromotions.jsp").forward(req, resp);
    }
}
