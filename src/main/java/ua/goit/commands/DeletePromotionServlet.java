package ua.goit.commands;

import ua.goit.config.DataBaseManager;
import ua.goit.config.HibernateProvider;
import ua.goit.repository.PromotionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deletePromotion")
public class DeletePromotionServlet extends HttpServlet {
    private PromotionRepository promotionRepository;

    @Override
    public void init() {
        DataBaseManager manager = new HibernateProvider();
        promotionRepository = new PromotionRepository(manager);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer promotionId = Integer.parseInt(req.getParameter("id"));
        promotionRepository.remove(promotionId);
        req.getRequestDispatcher("/WEB-INF/html/promotions/deletePromotion.jsp").forward(req, resp);
    }
}
