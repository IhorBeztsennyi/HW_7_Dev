package ua.goit.model.converter;

import ua.goit.model.dao.ProductDao;
import ua.goit.model.dto.ProductDto;

public class ProductConverter implements Converter<ProductDao, ProductDto>{

    PromotionConverter converter = new PromotionConverter();

    @Override
    public ProductDto daoToDto(ProductDao type) {
        ProductDto dto = new ProductDto();
        dto.setId(type.getId());
        dto.setName(type.getName());
        dto.setPrice(type.getPrice());
        dto.setPromotionDto(converter.daoToDto(type.getPromotionDao()));
        return dto;
    }

    @Override
    public ProductDao dtoToDao(ProductDto type) {
        ProductDao dao = new ProductDao();
        dao.setId(type.getId());
        dao.setName(type.getName());
        dao.setPrice(type.getPrice());
        dao.setPromotionDao(converter.dtoToDao(type.getPromotionDto()));
        return dao;
    }
}
