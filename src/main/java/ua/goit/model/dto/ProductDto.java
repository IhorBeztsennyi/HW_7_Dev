package ua.goit.model.dto;

public class ProductDto {
    private Integer id;
    private String name;
    private Double price;
    private PromotionDto promotionDto;

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PromotionDto getPromotionDto() {
        return promotionDto;
    }

    public void setPromotionDto(PromotionDto promotionDto) {
        this.promotionDto = promotionDto;
    }
}
