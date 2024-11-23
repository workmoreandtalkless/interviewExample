package com.apex.eqp.inventory.services;

import com.apex.eqp.inventory.entities.Product;
import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.helpers.ProductFilter;
import com.apex.eqp.inventory.repositories.InventoryRepository;
import com.apex.eqp.inventory.repositories.RecalledProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final InventoryRepository inventoryRepository;
    @Autowired
    private final RecalledProductRepository recalledProductRepository;
    @Autowired
    private final RecalledProductService recalledProductService;
    @Transactional
    public Product save(Product product) {
        return inventoryRepository.save(product);
    }


    public Collection<Product> getAllProduct() {
        Collection<RecalledProduct> recalledProductList = recalledProductService.getAllRecalledProducts();
        System.out.println("Recalled products: " + recalledProductList);

        Set<String> recalledProductNames = recalledProductList
                .stream()
                .map(RecalledProduct::getName)
                .collect(Collectors.toSet());
        System.out.println("Recalled product names: " + recalledProductNames);
        ProductFilter filter = new ProductFilter(recalledProductNames);

        List<Product> allProducts = inventoryRepository.findAll();
        System.out.println("All products: " + allProducts);

        Collection<Product> filteredProducts = filter.removeRecalledFrom(allProducts);
        System.out.println("Filtered products: " + filteredProducts);
        return filteredProducts;
    }

    public Optional<Product> findById(Integer id) {
        return inventoryRepository.findById(id);
    }

    public Integer deleteById(Integer id){
        inventoryRepository.deleteById(id);
        return id;
    }
}
