package com.prompo.knit.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getSeller() {

    }

    @Test
    void setSeller() {
    }

    @Test
    void testId() {
        Long a = Long.valueOf(1232);
        Product product = new Product();
        product.setId(a);
        assertEquals(a, product.getId());
    }

}