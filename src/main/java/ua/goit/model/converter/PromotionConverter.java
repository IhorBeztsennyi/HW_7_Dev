package ua.goit.model.converter;

import ua.goit.model.dao.PromotionDao;
import ua.goit.model.dto.PromotionDto;

public class PromotionConverter implements Converter<PromotionDao, PromotionDto>{
    @Override
    public PromotionDto daoToDto(PromotionDao type) {
        PromotionDto dto = new PromotionDto();
        dto.setId(type.getId());
        dto.setAmount(type.getAmount());
        dto.setPrice(type.getPrice());
        return dto;
    }

    @Override
    public PromotionDao dtoToDao(PromotionDto type) {
        PromotionDao dao = new PromotionDao();
        dao.setId(type.getId());
        dao.setAmount(type.getAmount());
        dao.setPrice(type.getPrice());
        return dao;
    }
}
