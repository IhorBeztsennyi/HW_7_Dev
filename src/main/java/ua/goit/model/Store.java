package ua.goit.model;

import ua.goit.model.dao.ProductDao;
import ua.goit.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Store {
    private ProductRepository productRepository;


    public Store(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Double getFinalPrice(String request) {
        Double result = 0.0;
        HashMap<Character, Integer> productsWithQuantity = quantityOfProducts(request.toUpperCase());
        for (Character name : productsWithQuantity.keySet()) {
            ProductDao product = productRepository.findByName(name.toString()).get(0);
            if (product.getPromotionDao().getAmount() > 0 && product.getPromotionDao().getPrice() > 0.0) {
                int i = productsWithQuantity.get(name);
                while (i > 0) {
                    if ((i - product.getPromotionDao().getAmount() >= 0)) {
                        result += product.getPromotionDao().getPrice();
                        i -= product.getPromotionDao().getAmount();
                    } else {
                        result += product.getPrice();
                        i--;
                    }
                }
            } else {
                result += product.getPrice() * productsWithQuantity.get(name);
            }
        }
        return result;
    }

    private HashMap<Character, Integer> quantityOfProducts(String request) {
        HashMap<Character, Integer> productsWithQuantity = new HashMap<>();
        ArrayList<Character> chars = new ArrayList<>(
                request.chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toList()));

        for (Character name : chars) {
            if (productsWithQuantity.keySet().contains(name)) {
                productsWithQuantity.put(name, productsWithQuantity.get(name) + 1);
            } else if ((productRepository.findByName(name.toString()).get(0)) != null) {
                productsWithQuantity.put(name, 1);
            }
        }
        return productsWithQuantity;
    }
}
