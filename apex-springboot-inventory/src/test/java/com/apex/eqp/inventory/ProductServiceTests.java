package com.apex.eqp.inventory;

import com.apex.eqp.inventory.entities.Product;
import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.repositories.InventoryRepository;
import com.apex.eqp.inventory.repositories.RecalledProductRepository;
import com.apex.eqp.inventory.services.ProductService;
import com.apex.eqp.inventory.services.RecalledProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceTests {

    @InjectMocks
    ProductService productService;

    @Mock
    RecalledProductService recalledProductService;
    @Mock
    InventoryRepository inventoryRepository;
    @Mock
    RecalledProductRepository recalledProductRepository;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    /**
     * Helper method to create test products
     */
    private Product createTestProduct(String productName, Double price, Integer quantity) {
        return Product.builder()
                .name(productName)
                .price(price)
                .quantity(quantity)
                .build();
    }

    /**
     * Helper method to create test recalled products
     */
    private RecalledProduct createTestRecalledProduct(String recalledProductName, Boolean expired) {
        return RecalledProduct.builder()
                .name(recalledProductName)
                .expired(expired)
                .build();
    }

    @Test
    void shouldSaveProduct() {
        Product product = createTestProduct("product1", 1.2, 2);

        Product savedProduct = productService.save(product);

        Product loadedProduct = productService.findById(savedProduct.getId()).orElse(null);

        assertNotNull(loadedProduct);
        assertNotNull(loadedProduct.getId());
    }

    @Test
    void shouldUpdateProduct() {
        Product product = createTestProduct("product2", 1.3, 5);

        Product savedProduct = productService.save(product);

        Product loadedProduct = productService.findById(savedProduct.getId()).orElse(null);

        assertNotNull(loadedProduct);

        loadedProduct.setName("NewProduct");

        productService.save(loadedProduct);

        assertNotNull(productService.findById(loadedProduct.getId()).orElse(null));
    }

    // Write your tests below get all production.
    @Test
    void shouldGetAllProduct(){
        List<Product> products = Arrays.asList(
                new Product(1, "Product1", 10.0, 100),
                new Product(2, "RecalledProduct1", 15.0, 50),
                new Product(3, "Product2", 20.0, 200)
        );
        List<RecalledProduct> recalledProducts = List.of(
                new RecalledProduct(1, "RecalledProduct1", true)
        );
//        when(recalledProductService.getAllRecalledProducts()).thenReturn(recalledProducts);
        when(inventoryRepository.findAll()).thenReturn(products);
        when(recalledProductRepository.findAll()).thenReturn(recalledProducts);
        Collection<Product> result = productService.getAllProduct();

        assertEquals(2,result.size());
        assertTrue(result.stream().anyMatch(product -> product.getName().equals("Product1")));
        assertTrue(result.stream().anyMatch(product -> product.getName().equals("Product2")));
        assertFalse(result.stream().anyMatch(product -> product.getName().equals("RecalledProduct1")));
//
//        verify(inventoryRepository, times(1)).findAll();
//        verify(recalledProductRepository, times(1)).findAll();
    }
    @Test
    void shouldDeleteProduct(){
        Integer pId = 1;
        doNothing().when(inventoryRepository).deleteById(pId);

        productService.deleteById(pId);
        verify(inventoryRepository,times(1)).deleteById(pId);
    }

}
