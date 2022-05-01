package ua.goit.model.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "promotion")
public class PromotionDao {
    private Integer id;
    private Integer amount;
    private Double price;

    public PromotionDao() {
    }

    public PromotionDao(Integer id, Integer amount, Double price) {
        this.id = id;
        this.amount = amount;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PromotionDao{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
