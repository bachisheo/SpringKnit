package com.prompo.knit.controller;

import com.prompo.knit.Service.ProductService;
import com.prompo.knit.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class ProductController {
    @Autowired
    ProductService productService;

    /** Список товаров */
    @RequestMapping(method = RequestMethod.GET, value = "/iiii")
    public String index(Model vars) {
        /* Заполняем модель для представления */
      //  vars.addAttribute("students", productService.getAllProducts());
        /* Возвращаем имя шаблона, который надо рендерить */
        return "index";
    }

    @GetMapping("/product/{productid}")
    private Product getProduct(@PathVariable("productid") Long productid){
        return productService.getProductById(productid);
    }
}
