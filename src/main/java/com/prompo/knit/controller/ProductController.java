package com.prompo.knit.controller;

import com.prompo.knit.Dao.ProductService;
import com.prompo.knit.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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

    /**
     * Получение страницы редактирования продукта
     * @param productid
     * @param vars
     * @return
     */
    @GetMapping("/edit/{productid}")
    private String editProduct(@PathVariable("productid") Long productid, Model vars){
        vars.addAttribute("product", productService.find(productid).get());
        return "edit";
    }

    /**
     * Сохранение результата изменения продукта
     * @param product
     * @param vars
     * @param productid
     * @return
     */
    @PostMapping("/edit/{productid}")
    public String editProduct(@ModelAttribute Product product, Model vars, @PathVariable String productid) {
        Product original = productService.find(Long.valueOf(productid)).get();
        original.setName(product.getName());
        original.setCount(product.getCount());
        original.setDescription(product.getDescription());
        original.setPrice(product.getPrice());
        productService.update(original);
        vars.addAttribute("product", original);
        return "product_details";
    }
    /**
     * Получение страницы для управления объявлениями
     * @param vars
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/monitor")
    public String monitor(Model vars) {
        vars.addAttribute("products", productService.getAll());
        return "product_monitor";
    }
}