package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    private Product[] items = new Product[0];

    public void add(Product item) {
        Product[] tmp  = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++ ) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp  = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++ ) {
                    tmp[i] = items[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getTitle().contains(search);
    }
}
