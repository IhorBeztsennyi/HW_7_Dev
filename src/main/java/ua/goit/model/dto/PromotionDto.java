package ua.goit.model.dto;

public class PromotionDto {
    private Integer id;
    private Integer amount;
    private Double price;

    public PromotionDto() {
    }

    public PromotionDto(Integer id, Integer amount, Double price) {
        this.id = id;
        this.amount = amount;
        this.price = price;
    }

    public PromotionDto(Integer amount, Double price) {
        this.amount = amount;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
