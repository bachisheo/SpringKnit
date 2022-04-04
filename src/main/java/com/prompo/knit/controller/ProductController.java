package com.prompo.knit.controller;

import com.prompo.knit.Dao.ProductService;
import com.prompo.knit.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class ProductController {
    @Autowired
    ProductService productService;

    /**
     * Просмотр списка всех товаров в системе
     * @param vars
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model vars) {
        /* Заполняем модель для представления */
        vars.addAttribute("products", productService.getAll());
        /* Возвращаем имя шаблона, который надо рендерить */
        return "index";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/e")
    public String empty() {
        /* Возвращаем имя шаблона, который надо рендерить */
        return "empty_template";
    }

    /**
     * Подробный просмотр информации о товаре
     * @param productid id запрашиваемого товара
     * @param vars
     * @return
     */
    @GetMapping("/product/{productid}")
    private String getProduct(@PathVariable("productid") Long productid, Model vars){
        //todo проверка на случай, если файл не найден
        vars.addAttribute("product", productService.find(productid).get());
        return "product_details";
    }
}
