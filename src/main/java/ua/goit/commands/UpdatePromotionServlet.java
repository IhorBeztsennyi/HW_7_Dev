package ua.goit.commands;

import ua.goit.config.DataBaseManager;
import ua.goit.config.HibernateProvider;
import ua.goit.model.converter.PromotionConverter;
import ua.goit.model.dao.PromotionDao;
import ua.goit.model.dto.PromotionDto;
import ua.goit.repository.PromotionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updatePromotion")
public class UpdatePromotionServlet extends HttpServlet {
    private PromotionRepository promotionRepository;
    private PromotionConverter promotionConverter;

    @Override
    public void init() {
        DataBaseManager manager = new HibernateProvider();
        promotionRepository = new PromotionRepository(manager);
        promotionConverter =new PromotionConverter();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        Double price = Double.parseDouble(req.getParameter("price"));
        PromotionDao promotion = promotionConverter.dtoToDao(new PromotionDto(id, amount, price));
        promotionRepository.update(promotion);
        req.getRequestDispatcher("/WEB-INF/html/promotions/updatePromotion.jsp").forward(req, resp);
    }
}
