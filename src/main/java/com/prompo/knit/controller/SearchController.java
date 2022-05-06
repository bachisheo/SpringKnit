package com.prompo.knit.controller;

import com.prompo.knit.model.AjaxResponseBody;
import com.prompo.knit.model.Product;
import com.prompo.knit.model.SearchCriteria;
import com.prompo.knit.Dao.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Controller

public class SearchController {
    @Autowired
    ProductService productService;

    /**
     * Поиск продукта по заданному имени
     *
     * @param productName содержимое строки запроса
     * @return шаблон, который надо рендерить и его наполнение
     */

    @GetMapping("/search/{productName}")
    public ModelAndView getSearchResultViaAjax(@PathVariable("productName") String productName) {


        var result = new AjaxResponseBody();
        List<Product> products = productService.searchProducts(productName);
        if (products.isEmpty()) {
            result.setMsg("no prod found!");
            var mav = new ModelAndView("no_res");
            return mav;
        }
        result.setMsg("success");
        var mav = new ModelAndView("product_list");
        result.setResult(products);
        mav.addObject("products", products);
        return mav;
    }

    @GetMapping("/map")
    public ModelAndView getMap() {
        return new ModelAndView("site_tree");
    }

    @GetMapping("/bought")
    public ModelAndView getBye() {
        return new ModelAndView("bye_res");
    }
}