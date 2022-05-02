package ua.goit.model.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductDao {
    private Integer id;
    private String name;
    private Double price;
    private PromotionDao promotionDao;

    public ProductDao() {
    }

    public ProductDao(Integer id, String name, Double price, PromotionDao promotionDao) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.promotionDao = promotionDao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "promotion_id", nullable = false)
    public PromotionDao getPromotionDao() {
        return promotionDao;
    }

    public void setPromotionDao(PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }

}
